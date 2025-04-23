package com.entity.view;

import com.entity.XiaoyuanfengguangCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 校园风光收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiaoyuanfengguang_collection")
public class XiaoyuanfengguangCollectionView extends XiaoyuanfengguangCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String xiaoyuanfengguangCollectionValue;



		//级联表 xiaoyuanfengguang
			/**
			* 风光编号
			*/
			private String xiaoyuanfengguangUuidNumber;
			/**
			* 校园风光名称
			*/
			private String xiaoyuanfengguangName;
			/**
			* 校园风光照片
			*/
			private String xiaoyuanfengguangPhoto;
			/**
			* 校园风光类型
			*/
			private Integer xiaoyuanfengguangTypes;
				/**
				* 校园风光类型的值
				*/
				private String xiaoyuanfengguangValue;
			/**
			* 热度
			*/
			private Integer xiaoyuanfengguangClicknum;
			/**
			* 校园风光介绍
			*/
			private String xiaoyuanfengguangContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer xiaoyuanfengguangDelete;

		//级联表 xuesheng
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;
			/**
			* 年龄
			*/
			private Integer age;
			/**
			* 年龄段
			*/
			private Integer nianlingduanTypes;
				/**
				* 年龄段的值
				*/
				private String nianlingduanValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;
			/**
			* 院系
			*/
			private Integer yuanxiTypes;
				/**
				* 院系的值
				*/
				private String yuanxiValue;
			/**
			* 生源地
			*/
			private Integer shengyuandiTypes;
				/**
				* 生源地的值
				*/
				private String shengyuandiValue;

	public XiaoyuanfengguangCollectionView() {

	}

	public XiaoyuanfengguangCollectionView(XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, xiaoyuanfengguangCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getXiaoyuanfengguangCollectionValue() {
				return xiaoyuanfengguangCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setXiaoyuanfengguangCollectionValue(String xiaoyuanfengguangCollectionValue) {
				this.xiaoyuanfengguangCollectionValue = xiaoyuanfengguangCollectionValue;
			}

























				//级联表的get和set xiaoyuanfengguang

					/**
					* 获取： 风光编号
					*/
					public String getXiaoyuanfengguangUuidNumber() {
						return xiaoyuanfengguangUuidNumber;
					}
					/**
					* 设置： 风光编号
					*/
					public void setXiaoyuanfengguangUuidNumber(String xiaoyuanfengguangUuidNumber) {
						this.xiaoyuanfengguangUuidNumber = xiaoyuanfengguangUuidNumber;
					}

					/**
					* 获取： 校园风光名称
					*/
					public String getXiaoyuanfengguangName() {
						return xiaoyuanfengguangName;
					}
					/**
					* 设置： 校园风光名称
					*/
					public void setXiaoyuanfengguangName(String xiaoyuanfengguangName) {
						this.xiaoyuanfengguangName = xiaoyuanfengguangName;
					}

					/**
					* 获取： 校园风光照片
					*/
					public String getXiaoyuanfengguangPhoto() {
						return xiaoyuanfengguangPhoto;
					}
					/**
					* 设置： 校园风光照片
					*/
					public void setXiaoyuanfengguangPhoto(String xiaoyuanfengguangPhoto) {
						this.xiaoyuanfengguangPhoto = xiaoyuanfengguangPhoto;
					}

					/**
					* 获取： 校园风光类型
					*/
					public Integer getXiaoyuanfengguangTypes() {
						return xiaoyuanfengguangTypes;
					}
					/**
					* 设置： 校园风光类型
					*/
					public void setXiaoyuanfengguangTypes(Integer xiaoyuanfengguangTypes) {
						this.xiaoyuanfengguangTypes = xiaoyuanfengguangTypes;
					}


						/**
						* 获取： 校园风光类型的值
						*/
						public String getXiaoyuanfengguangValue() {
							return xiaoyuanfengguangValue;
						}
						/**
						* 设置： 校园风光类型的值
						*/
						public void setXiaoyuanfengguangValue(String xiaoyuanfengguangValue) {
							this.xiaoyuanfengguangValue = xiaoyuanfengguangValue;
						}

					/**
					* 获取： 热度
					*/
					public Integer getXiaoyuanfengguangClicknum() {
						return xiaoyuanfengguangClicknum;
					}
					/**
					* 设置： 热度
					*/
					public void setXiaoyuanfengguangClicknum(Integer xiaoyuanfengguangClicknum) {
						this.xiaoyuanfengguangClicknum = xiaoyuanfengguangClicknum;
					}

					/**
					* 获取： 校园风光介绍
					*/
					public String getXiaoyuanfengguangContent() {
						return xiaoyuanfengguangContent;
					}
					/**
					* 设置： 校园风光介绍
					*/
					public void setXiaoyuanfengguangContent(String xiaoyuanfengguangContent) {
						this.xiaoyuanfengguangContent = xiaoyuanfengguangContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getXiaoyuanfengguangDelete() {
						return xiaoyuanfengguangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setXiaoyuanfengguangDelete(Integer xiaoyuanfengguangDelete) {
						this.xiaoyuanfengguangDelete = xiaoyuanfengguangDelete;
					}










				//级联表的get和set xuesheng

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}

					/**
					* 获取： 年龄
					*/
					public Integer getAge() {
						return age;
					}
					/**
					* 设置： 年龄
					*/
					public void setAge(Integer age) {
						this.age = age;
					}

					/**
					* 获取： 年龄段
					*/
					public Integer getNianlingduanTypes() {
						return nianlingduanTypes;
					}
					/**
					* 设置： 年龄段
					*/
					public void setNianlingduanTypes(Integer nianlingduanTypes) {
						this.nianlingduanTypes = nianlingduanTypes;
					}


						/**
						* 获取： 年龄段的值
						*/
						public String getNianlingduanValue() {
							return nianlingduanValue;
						}
						/**
						* 设置： 年龄段的值
						*/
						public void setNianlingduanValue(String nianlingduanValue) {
							this.nianlingduanValue = nianlingduanValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}

					/**
					* 获取： 院系
					*/
					public Integer getYuanxiTypes() {
						return yuanxiTypes;
					}
					/**
					* 设置： 院系
					*/
					public void setYuanxiTypes(Integer yuanxiTypes) {
						this.yuanxiTypes = yuanxiTypes;
					}


						/**
						* 获取： 院系的值
						*/
						public String getYuanxiValue() {
							return yuanxiValue;
						}
						/**
						* 设置： 院系的值
						*/
						public void setYuanxiValue(String yuanxiValue) {
							this.yuanxiValue = yuanxiValue;
						}

					/**
					* 获取： 生源地
					*/
					public Integer getShengyuandiTypes() {
						return shengyuandiTypes;
					}
					/**
					* 设置： 生源地
					*/
					public void setShengyuandiTypes(Integer shengyuandiTypes) {
						this.shengyuandiTypes = shengyuandiTypes;
					}


						/**
						* 获取： 生源地的值
						*/
						public String getShengyuandiValue() {
							return shengyuandiValue;
						}
						/**
						* 设置： 生源地的值
						*/
						public void setShengyuandiValue(String shengyuandiValue) {
							this.shengyuandiValue = shengyuandiValue;
						}



}
