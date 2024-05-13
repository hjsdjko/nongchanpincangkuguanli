package com.entity.vo;

import com.entity.EntrustInOutOrderListEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 委托出入库订单详情
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-10
 */
@TableName("entrust_in_out_order_list")
public class EntrustInOutOrderListVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单id
     */

    @TableField(value = "entrust_in_out_order_id")
    private Integer entrustInOutOrderId;


    /**
     * 物资表id
     */

    @TableField(value = "goods_id")
    private Integer goodsId;


    /**
     * 数量
     */

    @TableField(value = "order_number")
    private Integer orderNumber;


    /**
     * 状态
     */

    @TableField(value = "entrust_types")
    private Integer entrustTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单id
	 */
    public Integer getEntrustInOutOrderId() {
        return entrustInOutOrderId;
    }


    /**
	 * 获取：订单id
	 */

    public void setEntrustInOutOrderId(Integer entrustInOutOrderId) {
        this.entrustInOutOrderId = entrustInOutOrderId;
    }
    /**
	 * 设置：物资表id
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 获取：物资表id
	 */

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 设置：数量
	 */
    public Integer getOrderNumber() {
        return orderNumber;
    }


    /**
	 * 获取：数量
	 */

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    /**
	 * 设置：状态
	 */
    public Integer getEntrustTypes() {
        return entrustTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setEntrustTypes(Integer entrustTypes) {
        this.entrustTypes = entrustTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
