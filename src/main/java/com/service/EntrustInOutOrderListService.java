package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.EntrustInOutOrderListEntity;
import java.util.Map;

/**
 * 委托出入库订单详情 服务类
 * @author 
 * @since 2021-03-10
 */
public interface EntrustInOutOrderListService extends IService<EntrustInOutOrderListEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}