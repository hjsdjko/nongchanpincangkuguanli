package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 委托出入库订单详情
 *
 * @author 
 * @email
 * @date 2021-03-10
 */
@TableName("entrust_in_out_order_list")
public class EntrustInOutOrderListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public EntrustInOutOrderListEntity() {

	}

	public EntrustInOutOrderListEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "EntrustInOutOrderList{" +
            "id=" + id +
            ", entrustInOutOrderId=" + entrustInOutOrderId +
            ", goodsId=" + goodsId +
            ", orderNumber=" + orderNumber +
            ", entrustTypes=" + entrustTypes +
            ", createTime=" + createTime +
        "}";
    }
}
