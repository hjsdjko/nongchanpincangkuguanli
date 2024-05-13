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
 * 委托出入库订单
 *
 * @author 
 * @email
 * @date 2021-03-10
 */
@TableName("entrust_in_out_order")
public class EntrustInOutOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public EntrustInOutOrderEntity() {

	}

	public EntrustInOutOrderEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 订单名
     */
    @TableField(value = "order_name")

    private String orderName;


    /**
     * 委托类型
     */
    @TableField(value = "order_types")

    private Integer orderTypes;


    /**
     * 委托时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 操作人姓名
     */
    @TableField(value = "caozuo_name")

    private String caozuoName;


    /**
     * 操作人所在表名
     */
    @TableField(value = "caozuo_table")

    private String caozuoTable;


    /**
     * 操作类型
     */
    @TableField(value = "caozuo_types")

    private Integer caozuoTypes;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：订单名
	 */
    public String getOrderName() {
        return orderName;
    }


    /**
	 * 获取：订单名
	 */

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    /**
	 * 设置：委托类型
	 */
    public Integer getOrderTypes() {
        return orderTypes;
    }


    /**
	 * 获取：委托类型
	 */

    public void setOrderTypes(Integer orderTypes) {
        this.orderTypes = orderTypes;
    }
    /**
	 * 设置：委托时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：委托时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：操作人姓名
	 */
    public String getCaozuoName() {
        return caozuoName;
    }


    /**
	 * 获取：操作人姓名
	 */

    public void setCaozuoName(String caozuoName) {
        this.caozuoName = caozuoName;
    }
    /**
	 * 设置：操作人所在表名
	 */
    public String getCaozuoTable() {
        return caozuoTable;
    }


    /**
	 * 获取：操作人所在表名
	 */

    public void setCaozuoTable(String caozuoTable) {
        this.caozuoTable = caozuoTable;
    }
    /**
	 * 设置：操作类型
	 */
    public Integer getCaozuoTypes() {
        return caozuoTypes;
    }


    /**
	 * 获取：操作类型
	 */

    public void setCaozuoTypes(Integer caozuoTypes) {
        this.caozuoTypes = caozuoTypes;
    }
    /**
	 * 设置：操作时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：操作时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "EntrustInOutOrder{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", orderName=" + orderName +
            ", orderTypes=" + orderTypes +
            ", insertTime=" + insertTime +
            ", caozuoName=" + caozuoName +
            ", caozuoTable=" + caozuoTable +
            ", caozuoTypes=" + caozuoTypes +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
