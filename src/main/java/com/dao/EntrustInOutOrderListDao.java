package com.dao;

import com.entity.EntrustInOutOrderListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.EntrustInOutOrderListView;

/**
 * 委托出入库订单详情 Dao 接口
 *
 * @author 
 * @since 2021-03-10
 */
public interface EntrustInOutOrderListDao extends BaseMapper<EntrustInOutOrderListEntity> {

   List<EntrustInOutOrderListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
