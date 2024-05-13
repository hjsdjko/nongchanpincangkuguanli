package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.EntrustInOutOrderListEntity;

import com.service.EntrustInOutOrderListService;
import com.entity.view.EntrustInOutOrderListView;
import com.service.EntrustInOutOrderService;
import com.entity.EntrustInOutOrderEntity;
import com.service.GoodsService;
import com.entity.GoodsEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 委托出入库订单详情
 * 后端接口
 * @author
 * @email
 * @date 2021-03-10
*/
@RestController
@Controller
@RequestMapping("/entrustInOutOrderList")
public class EntrustInOutOrderListController {
    private static final Logger logger = LoggerFactory.getLogger(EntrustInOutOrderListController.class);

    @Autowired
    private EntrustInOutOrderListService entrustInOutOrderListService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private EntrustInOutOrderService entrustInOutOrderService;
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
        PageUtils page = entrustInOutOrderListService.queryPage(params);

        //字典表数据转换
        List<EntrustInOutOrderListView> list =(List<EntrustInOutOrderListView>)page.getList();
        for(EntrustInOutOrderListView c:list){
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
        EntrustInOutOrderListEntity entrustInOutOrderList = entrustInOutOrderListService.selectById(id);
        if(entrustInOutOrderList !=null){
            //entity转view
            EntrustInOutOrderListView view = new EntrustInOutOrderListView();
            BeanUtils.copyProperties( entrustInOutOrderList , view );//把实体数据重构到view中

            //级联表
            EntrustInOutOrderEntity entrustInOutOrder = entrustInOutOrderService.selectById(entrustInOutOrderList.getEntrustInOutOrderId());
            if(entrustInOutOrder != null){
                BeanUtils.copyProperties( entrustInOutOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setEntrustInOutOrderId(entrustInOutOrder.getId());
            }
            //级联表
            GoodsEntity goods = goodsService.selectById(entrustInOutOrderList.getGoodsId());
            if(goods != null){
                BeanUtils.copyProperties( goods , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGoodsId(goods.getId());
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
    public R save(@RequestBody EntrustInOutOrderListEntity entrustInOutOrderList, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,entrustInOutOrderList:{}",this.getClass().getName(),entrustInOutOrderList.toString());
        Wrapper<EntrustInOutOrderListEntity> queryWrapper = new EntityWrapper<EntrustInOutOrderListEntity>()
            .eq("entrust_in_out_order_id", entrustInOutOrderList.getEntrustInOutOrderId())
            .eq("goods_id", entrustInOutOrderList.getGoodsId())
            .eq("order_number", entrustInOutOrderList.getOrderNumber())
            .eq("entrust_types", entrustInOutOrderList.getEntrustTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        EntrustInOutOrderListEntity entrustInOutOrderListEntity = entrustInOutOrderListService.selectOne(queryWrapper);
        if(entrustInOutOrderListEntity==null){
            entrustInOutOrderList.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      entrustInOutOrderList.set
        //  }
            entrustInOutOrderListService.insert(entrustInOutOrderList);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody EntrustInOutOrderListEntity entrustInOutOrderList, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,entrustInOutOrderList:{}",this.getClass().getName(),entrustInOutOrderList.toString());
        //根据字段查询是否有相同数据
        Wrapper<EntrustInOutOrderListEntity> queryWrapper = new EntityWrapper<EntrustInOutOrderListEntity>()
            .notIn("id",entrustInOutOrderList.getId())
            .eq("entrust_in_out_order_id", entrustInOutOrderList.getEntrustInOutOrderId())
            .eq("goods_id", entrustInOutOrderList.getGoodsId())
            .eq("order_number", entrustInOutOrderList.getOrderNumber())
            .eq("entrust_types", entrustInOutOrderList.getEntrustTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        EntrustInOutOrderListEntity entrustInOutOrderListEntity = entrustInOutOrderListService.selectOne(queryWrapper);
        if(entrustInOutOrderListEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      entrustInOutOrderList.set
            //  }
            entrustInOutOrderListService.updateById(entrustInOutOrderList);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        entrustInOutOrderListService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

