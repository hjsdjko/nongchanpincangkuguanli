package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.view.EntrustInOutOrderView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 委托出入库订单
 * 后端接口
 * @author
 * @email
 * @date 2021-03-10
*/
@RestController
@Controller
@RequestMapping("/entrustInOutOrder")
public class EntrustInOutOrderController {
    private static final Logger logger = LoggerFactory.getLogger(EntrustInOutOrderController.class);

    @Autowired
    private EntrustInOutOrderService entrustInOutOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private EntrustInOutOrderListService entrustInOutOrderListService;
    @Autowired
    private GoodsService goodsService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = entrustInOutOrderService.queryPage(params);

        //字典表数据转换
        List<EntrustInOutOrderView> list =(List<EntrustInOutOrderView>)page.getList();
        for(EntrustInOutOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        EntrustInOutOrderEntity entrustInOutOrder = entrustInOutOrderService.selectById(id);
        if(entrustInOutOrder !=null){
            //entity转view
            EntrustInOutOrderView view = new EntrustInOutOrderView();
            BeanUtils.copyProperties( entrustInOutOrder , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(entrustInOutOrder.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody EntrustInOutOrderEntity entrustInOutOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,entrustInOutOrder:{}",this.getClass().getName(),entrustInOutOrder.toString());
        Wrapper<EntrustInOutOrderEntity> queryWrapper = new EntityWrapper<EntrustInOutOrderEntity>()
            .eq("yonghu_id", entrustInOutOrder.getYonghuId())
            .eq("order_name", entrustInOutOrder.getOrderName())
            .eq("order_types", entrustInOutOrder.getOrderTypes())
            .eq("caozuo_name", entrustInOutOrder.getCaozuoName())
            .eq("caozuo_table", entrustInOutOrder.getCaozuoTable())
            .eq("caozuo_types", entrustInOutOrder.getCaozuoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        EntrustInOutOrderEntity entrustInOutOrderEntity = entrustInOutOrderService.selectOne(queryWrapper);
        if(entrustInOutOrderEntity==null){
            entrustInOutOrder.setInsertTime(new Date());
            entrustInOutOrder.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      entrustInOutOrder.set
        //  }
            entrustInOutOrderService.insert(entrustInOutOrder);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody EntrustInOutOrderEntity entrustInOutOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,entrustInOutOrder:{}",this.getClass().getName(),entrustInOutOrder.toString());
        //根据字段查询是否有相同数据
        Wrapper<EntrustInOutOrderEntity> queryWrapper = new EntityWrapper<EntrustInOutOrderEntity>()
            .notIn("id",entrustInOutOrder.getId())
            .eq("yonghu_id", entrustInOutOrder.getYonghuId())
            .eq("order_name", entrustInOutOrder.getOrderName())
            .eq("order_types", entrustInOutOrder.getOrderTypes())
            .eq("caozuo_name", entrustInOutOrder.getCaozuoName())
            .eq("caozuo_table", entrustInOutOrder.getCaozuoTable())
            .eq("caozuo_types", entrustInOutOrder.getCaozuoTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        EntrustInOutOrderEntity entrustInOutOrderEntity = entrustInOutOrderService.selectOne(queryWrapper);
                entrustInOutOrder.setUpdateTime(new Date());
        if(entrustInOutOrderEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      entrustInOutOrder.set
            //  }
            entrustInOutOrderService.updateById(entrustInOutOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
     * 新增 委托出库入库
     */
    @RequestMapping("/inOutOrder")
    public R inOutOrder(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inOutOrder方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            Map<String, Integer> map = (Map<String, Integer>) params.get("map");
            String orderName = String.valueOf(params.get("orderName"));
    //        InOutOrderEntity one = inOutOrderService.selectOne(new EntityWrapper<InOutOrderEntity>().eq("order_name", orderName));
            EntrustInOutOrderEntity one = entrustInOutOrderService.selectOne(new EntityWrapper<EntrustInOutOrderEntity>().eq("order_name", orderName));
            if(one != null){
                return R.error(orderName+"的委托订单名已经被使用");
            }

            Set<String> ids = map.keySet();
            Date date = new Date();

            //新增订单
            EntrustInOutOrderEntity entrustInOutOrderEntity = new EntrustInOutOrderEntity();
            entrustInOutOrderEntity.setYonghuId(Integer.parseInt(String.valueOf(request.getSession().getAttribute("userId"))));
            entrustInOutOrderEntity.setOrderName(orderName);
            entrustInOutOrderEntity.setOrderTypes(Integer.parseInt(String.valueOf(params.get("orderType"))));
            entrustInOutOrderEntity.setCaozuoTypes(2);//操作类型为未操作
            entrustInOutOrderEntity.setInsertTime(new Date());
            entrustInOutOrderEntity.setCreateTime(date);
            entrustInOutOrderService.insert(entrustInOutOrderEntity);


            if(entrustInOutOrderEntity.getId()!=null){
                //新增订单详情
                List<EntrustInOutOrderListEntity> inOutOrderListEntityList = new ArrayList<>();
                for(String i:ids){
                    EntrustInOutOrderListEntity entrustInOutOrderListEntity = new EntrustInOutOrderListEntity();
                    entrustInOutOrderListEntity.setEntrustInOutOrderId(entrustInOutOrderEntity.getId());
                    entrustInOutOrderListEntity.setGoodsId(Integer.valueOf(i));
                    entrustInOutOrderListEntity.setOrderNumber(Integer.valueOf(map.get(i)));
                    entrustInOutOrderListEntity.setEntrustTypes(1);//默认状态为不同意
                    entrustInOutOrderListEntity.setCreateTime(date);
                    inOutOrderListEntityList.add(entrustInOutOrderListEntity);
                }
                if(inOutOrderListEntityList != null && inOutOrderListEntityList.size()>0){
                    entrustInOutOrderListService.insertBatch(inOutOrderListEntityList);
                    return R.ok();
                }
            }else{
                return R.error("新增订单失败");
            }
            return R.ok();
        }else{
          return R.error("您没有委托权限");
        }
    }




    /**
     * 对委托的出入库订单进行审核
     */
    @RequestMapping("/examineInOutOrder")
    public R examineInOutOrder(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("examineInOutOrder方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("管理员".equals(role)){
            Date date = new Date();
            List<Integer> ids = (List<Integer>) params.get("list");//list为订单详情的id列表
            String id = String.valueOf(params.get("id"));//订单id的
            if(ids == null || ids.size() == 0){
                //如果全部都是不同意,会进入这里,直接修改订单状态为已操作就好了
                EntrustInOutOrderEntity order = new EntrustInOutOrderEntity();
                order.setId(Integer.valueOf(id));
                order.setCaozuoTypes(1);//设置操作状态为已操作
                order.setCaozuoName(String.valueOf(request.getSession().getAttribute("username")));//设置操作人名字
                order.setCaozuoTable(String.valueOf(request.getSession().getAttribute("tableName")));//设置操作人表名
                order.setUpdateTime(date);
                entrustInOutOrderService.updateById(order);
                return R.ok();
            }
            //订单详情
            List<EntrustInOutOrderListEntity> orderList = entrustInOutOrderListService.selectBatchIds(ids);//当天订单列表详情
            EntrustInOutOrderEntity entrustInOutOrderEntity = entrustInOutOrderService.selectById(id);//当前订单信息
            Map<Integer, Integer> map = new HashMap<>();
            for(EntrustInOutOrderListEntity o:orderList){
                o.setEntrustTypes(2);//设置订单为同意
                map.put(o.getGoodsId(), o.getOrderNumber());
            }
            if(entrustInOutOrderEntity != null){

                Set<Integer> goodIds = map.keySet();
                List<GoodsEntity> list = goodsService.selectBatchIds(goodIds);
                Integer orderTypes = entrustInOutOrderEntity.getOrderTypes();
                if(orderTypes == null){
                    return R.error(entrustInOutOrderEntity.getOrderName()+"的订单的委托类型有问题");
                }else if(orderTypes ==1 || orderTypes ==2){
                    for(GoodsEntity g:list){
                        if(orderTypes ==1 ){
                            //出库
                            int i = g.getGoodsNumber() - map.get(g.getId());
                            if(i<0){
                                Integer flag = g.getFlag();
                                String a="";
                                if(flag == 1){
                                    a="在使用状态";
                                }else{
                                    a="已经删除";
                                }
                                return R.error(g.getGoodsName()+"的商品出库后数量为负,请重新处理,商品是"+a);
                            }else{
                                g.setGoodsNumber(i);
                            }
                        }else if(orderTypes ==2){
                            //入库
                            g.setGoodsNumber(g.getGoodsNumber()+map.get(g.getId()));
                        }
                    }
                }else{
                    return R.error(entrustInOutOrderEntity.getOrderName()+"的订单的委托类型是"+orderTypes+"有问题");
                }

                //更新订单详情表
                entrustInOutOrderListService.updateBatchById(orderList);
                //更新订单表
                entrustInOutOrderEntity.setCaozuoTypes(1);//设置操作状态为已操作
                entrustInOutOrderEntity.setCaozuoName(String.valueOf(request.getSession().getAttribute("username")));//设置操作人名字
                entrustInOutOrderEntity.setCaozuoTable(String.valueOf(request.getSession().getAttribute("tableName")));//设置操作人表名
                entrustInOutOrderEntity.setUpdateTime(date);
                entrustInOutOrderService.updateById(entrustInOutOrderEntity);
                //修改物资的数量
                goodsService.updateBatchById(list);

            }else{
                return R.error("订单不存在");
            }
            return R.ok();
        }else{
            return R.error("您没有处理委托的权限");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());

        List<EntrustInOutOrderEntity> list = entrustInOutOrderService.selectList(new EntityWrapper<EntrustInOutOrderEntity>().in("id", ids));
        entrustInOutOrderService.deleteBatchIds(Arrays.asList(ids));
        List<Integer> entrustInOutOrderIds = new ArrayList<>();
        for(EntrustInOutOrderEntity order:list){
            entrustInOutOrderIds.add(order.getId());
        }
        if(entrustInOutOrderIds != null && entrustInOutOrderIds.size()>0){
            entrustInOutOrderListService.delete(new EntityWrapper<EntrustInOutOrderListEntity>().in("entrust_in_out_order_id", entrustInOutOrderIds));
        }
        return R.ok();
    }
}

