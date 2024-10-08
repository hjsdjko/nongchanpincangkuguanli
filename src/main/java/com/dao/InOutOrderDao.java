package com.dao;

import com.entity.InOutOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.InOutOrderView;

/**
 * 出入库订单 Dao 接口
 *
 * @author 
 * @since 2021-03-10
 */
public interface InOutOrderDao extends BaseMapper<InOutOrderEntity> {

   List<InOutOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
