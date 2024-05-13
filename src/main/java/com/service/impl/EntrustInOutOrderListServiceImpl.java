package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.EntrustInOutOrderListDao;
import com.entity.EntrustInOutOrderListEntity;
import com.service.EntrustInOutOrderListService;
import com.entity.view.EntrustInOutOrderListView;

/**
 * 委托出入库订单详情 服务实现类
 * @author 
 * @since 2021-03-10
 */
@Service("entrustInOutOrderListService")
@Transactional
public class EntrustInOutOrderListServiceImpl extends ServiceImpl<EntrustInOutOrderListDao, EntrustInOutOrderListEntity> implements EntrustInOutOrderListService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<EntrustInOutOrderListView> page =new Query<EntrustInOutOrderListView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
