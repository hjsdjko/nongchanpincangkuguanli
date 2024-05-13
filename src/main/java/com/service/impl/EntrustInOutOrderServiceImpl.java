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

import com.dao.EntrustInOutOrderDao;
import com.entity.EntrustInOutOrderEntity;
import com.service.EntrustInOutOrderService;
import com.entity.view.EntrustInOutOrderView;

/**
 * 委托出入库订单 服务实现类
 * @author 
 * @since 2021-03-10
 */
@Service("entrustInOutOrderService")
@Transactional
public class EntrustInOutOrderServiceImpl extends ServiceImpl<EntrustInOutOrderDao, EntrustInOutOrderEntity> implements EntrustInOutOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<EntrustInOutOrderView> page =new Query<EntrustInOutOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
