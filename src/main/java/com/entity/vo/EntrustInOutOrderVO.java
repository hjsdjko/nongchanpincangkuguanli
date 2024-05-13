package com.entity.vo;

import com.entity.EntrustInOutOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 委托出入库订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-10
 */
@TableName("entrust_in_out_order")
public class EntrustInOutOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "update_time")
    private Date updateTime;


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

}
