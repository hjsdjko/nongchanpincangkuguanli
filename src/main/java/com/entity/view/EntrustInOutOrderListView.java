package com.entity.view;

import com.entity.EntrustInOutOrderListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 委托出入库订单详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-10
 */
@TableName("entrust_in_out_order_list")
public class EntrustInOutOrderListView extends EntrustInOutOrderListEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 状态的值
		*/
		private String entrustValue;



		//级联表 entrust_in_out_order
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
				* 委托类型的值
				*/
				private String orderValue;
			/**
			* 委托时间
			*/
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
				* 操作类型的值
				*/
				private String caozuoValue;
			/**
			* 操作时间
			*/
			private Date updateTime;

		//级联表 goods
			/**
			* 物品名字
			*/
			private String goodsName;
			/**
			* 物品种类
			*/
			private Integer goodsTypes;
				/**
				* 物品种类的值
				*/
				private String goodsValue;
			/**
			* 物资数量
			*/
			private Integer goodsNumber;
			/**
			* 物品图片
			*/
			private String goodsPhoto;
			/**
			* 单位
			*/
			private String danwei;
			/**
			* 物资详情
			*/
			private String goodsContent;
			/**
			* 是否删除
			*/
			private Integer flag;

	public EntrustInOutOrderListView() {

	}

	public EntrustInOutOrderListView(EntrustInOutOrderListEntity entrustInOutOrderListEntity) {
		try {
			BeanUtils.copyProperties(this, entrustInOutOrderListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 状态的值
			*/
			public String getEntrustValue() {
				return entrustValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setEntrustValue(String entrustValue) {
				this.entrustValue = entrustValue;
			}







				//级联表的get和set entrust_in_out_order
					/**
					* 获取： 用户
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 用户
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 订单名
					*/
					public String getOrderName() {
						return orderName;
					}
					/**
					* 设置： 订单名
					*/
					public void setOrderName(String orderName) {
						this.orderName = orderName;
					}
					/**
					* 获取： 委托类型
					*/
					public Integer getOrderTypes() {
						return orderTypes;
					}
					/**
					* 设置： 委托类型
					*/
					public void setOrderTypes(Integer orderTypes) {
						this.orderTypes = orderTypes;
					}


						/**
						* 获取： 委托类型的值
						*/
						public String getOrderValue() {
							return orderValue;
						}
						/**
						* 设置： 委托类型的值
						*/
						public void setOrderValue(String orderValue) {
							this.orderValue = orderValue;
						}
					/**
					* 获取： 委托时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 委托时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 操作人姓名
					*/
					public String getCaozuoName() {
						return caozuoName;
					}
					/**
					* 设置： 操作人姓名
					*/
					public void setCaozuoName(String caozuoName) {
						this.caozuoName = caozuoName;
					}
					/**
					* 获取： 操作人所在表名
					*/
					public String getCaozuoTable() {
						return caozuoTable;
					}
					/**
					* 设置： 操作人所在表名
					*/
					public void setCaozuoTable(String caozuoTable) {
						this.caozuoTable = caozuoTable;
					}
					/**
					* 获取： 操作类型
					*/
					public Integer getCaozuoTypes() {
						return caozuoTypes;
					}
					/**
					* 设置： 操作类型
					*/
					public void setCaozuoTypes(Integer caozuoTypes) {
						this.caozuoTypes = caozuoTypes;
					}


						/**
						* 获取： 操作类型的值
						*/
						public String getCaozuoValue() {
							return caozuoValue;
						}
						/**
						* 设置： 操作类型的值
						*/
						public void setCaozuoValue(String caozuoValue) {
							this.caozuoValue = caozuoValue;
						}
					/**
					* 获取： 操作时间
					*/
					public Date getUpdateTime() {
						return updateTime;
					}
					/**
					* 设置： 操作时间
					*/
					public void setUpdateTime(Date updateTime) {
						this.updateTime = updateTime;
					}







				//级联表的get和set goods
					/**
					* 获取： 物品名字
					*/
					public String getGoodsName() {
						return goodsName;
					}
					/**
					* 设置： 物品名字
					*/
					public void setGoodsName(String goodsName) {
						this.goodsName = goodsName;
					}
					/**
					* 获取： 物品种类
					*/
					public Integer getGoodsTypes() {
						return goodsTypes;
					}
					/**
					* 设置： 物品种类
					*/
					public void setGoodsTypes(Integer goodsTypes) {
						this.goodsTypes = goodsTypes;
					}


						/**
						* 获取： 物品种类的值
						*/
						public String getGoodsValue() {
							return goodsValue;
						}
						/**
						* 设置： 物品种类的值
						*/
						public void setGoodsValue(String goodsValue) {
							this.goodsValue = goodsValue;
						}
					/**
					* 获取： 物资数量
					*/
					public Integer getGoodsNumber() {
						return goodsNumber;
					}
					/**
					* 设置： 物资数量
					*/
					public void setGoodsNumber(Integer goodsNumber) {
						this.goodsNumber = goodsNumber;
					}
					/**
					* 获取： 物品图片
					*/
					public String getGoodsPhoto() {
						return goodsPhoto;
					}
					/**
					* 设置： 物品图片
					*/
					public void setGoodsPhoto(String goodsPhoto) {
						this.goodsPhoto = goodsPhoto;
					}
					/**
					* 获取： 单位
					*/
					public String getDanwei() {
						return danwei;
					}
					/**
					* 设置： 单位
					*/
					public void setDanwei(String danwei) {
						this.danwei = danwei;
					}
					/**
					* 获取： 物资详情
					*/
					public String getGoodsContent() {
						return goodsContent;
					}
					/**
					* 设置： 物资详情
					*/
					public void setGoodsContent(String goodsContent) {
						this.goodsContent = goodsContent;
					}
					/**
					* 获取： 是否删除
					*/
					public Integer getFlag() {
						return flag;
					}
					/**
					* 设置： 是否删除
					*/
					public void setFlag(Integer flag) {
						this.flag = flag;
					}















}
