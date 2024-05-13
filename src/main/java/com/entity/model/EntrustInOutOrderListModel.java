package com.entity.model;

import com.entity.EntrustInOutOrderListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 委托出入库订单详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-10
 */
public class EntrustInOutOrderListModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单id
     */
    private Integer entrustInOutOrderId;


    /**
     * 物资表id
     */
    private Integer goodsId;


    /**
     * 数量
     */
    private Integer orderNumber;


    /**
     * 状态
     */
    private Integer entrustTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单id
	 */
    public Integer getEntrustInOutOrderId() {
        return entrustInOutOrderId;
    }


    /**
	 * 设置：订单id
	 */
    public void setEntrustInOutOrderId(Integer entrustInOutOrderId) {
        this.entrustInOutOrderId = entrustInOutOrderId;
    }
    /**
	 * 获取：物资表id
	 */
    public Integer getGoodsId() {
        return goodsId;
    }


    /**
	 * 设置：物资表id
	 */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    /**
	 * 获取：数量
	 */
    public Integer getOrderNumber() {
        return orderNumber;
    }


    /**
	 * 设置：数量
	 */
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    /**
	 * 获取：状态
	 */
    public Integer getEntrustTypes() {
        return entrustTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setEntrustTypes(Integer entrustTypes) {
        this.entrustTypes = entrustTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
