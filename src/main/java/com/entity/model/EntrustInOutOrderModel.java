package com.entity.model;

import com.entity.EntrustInOutOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 委托出入库订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-10
 */
public class EntrustInOutOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 订单名
     */
    private String orderName;


    /**
     * 委托类型
     */
    private Integer orderTypes;


    /**
     * 委托时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 操作人姓名
     */
    private String caozuoName;


    /**
     * 操作人所在表名
     */
    private String caozuoTable;


    /**
     * 操作类型
     */
    private Integer caozuoTypes;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：订单名
	 */
    public String getOrderName() {
        return orderName;
    }


    /**
	 * 设置：订单名
	 */
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    /**
	 * 获取：委托类型
	 */
    public Integer getOrderTypes() {
        return orderTypes;
    }


    /**
	 * 设置：委托类型
	 */
    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }
    /**
	 * 获取：委托时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：委托时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：操作人姓名
	 */
    public String getCaozuoName() {
        return caozuoName;
    }


    /**
	 * 设置：操作人姓名
	 */
    public void setCaozuoName(String caozuoName) {
        this.caozuoName = caozuoName;
    }
    /**
	 * 获取：操作人所在表名
	 */
    public String getCaozuoTable() {
        return caozuoTable;
    }


    /**
	 * 设置：操作人所在表名
	 */
    public void setCaozuoTable(String caozuoTable) {
        this.caozuoTable = caozuoTable;
    }
    /**
	 * 获取：操作类型
	 */
    public Integer getCaozuoTypes() {
        return caozuoTypes;
    }


    /**
	 * 设置：操作类型
	 */
    public void setCaozuoTypes(Integer caozuoTypes) {
        this.caozuoTypes = caozuoTypes;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：操作时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
