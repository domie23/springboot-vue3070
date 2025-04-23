package com.entity.view;

import com.entity.ShizililiangCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 师资力量收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shizililiang_collection")
public class ShizililiangCollectionView extends ShizililiangCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String shizililiangCollectionValue;



		//级联表 shizililiang
			/**
			* 老师工号
			*/
			private String shizililiangUuidNumber;
			/**
			* 老师名称
			*/
			private String shizililiangName;
			/**
			* 老师照片
			*/
			private String shizililiangPhoto;
			/**
			* 所教专业
			*/
			private Integer shizililiangTypes;
				/**
				* 所教专业的值
				*/
				private String shizililiangValue;
			/**
			* 擅长
			*/
			private String shizililiangShanchang;
			/**
			* 所获荣誉
			*/
			private String shizililiangRongyu;
			/**
			* 老师详细介绍
			*/
			private String shizililiangContent;
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
			private Integer shizililiangDelete;

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

	public ShizililiangCollectionView() {

	}

	public ShizililiangCollectionView(ShizililiangCollectionEntity shizililiangCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, shizililiangCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getShizililiangCollectionValue() {
				return shizililiangCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setShizililiangCollectionValue(String shizililiangCollectionValue) {
				this.shizililiangCollectionValue = shizililiangCollectionValue;
			}













				//级联表的get和set shizililiang

					/**
					* 获取： 老师工号
					*/
					public String getShizililiangUuidNumber() {
						return shizililiangUuidNumber;
					}
					/**
					* 设置： 老师工号
					*/
					public void setShizililiangUuidNumber(String shizililiangUuidNumber) {
						this.shizililiangUuidNumber = shizililiangUuidNumber;
					}

					/**
					* 获取： 老师名称
					*/
					public String getShizililiangName() {
						return shizililiangName;
					}
					/**
					* 设置： 老师名称
					*/
					public void setShizililiangName(String shizililiangName) {
						this.shizililiangName = shizililiangName;
					}

					/**
					* 获取： 老师照片
					*/
					public String getShizililiangPhoto() {
						return shizililiangPhoto;
					}
					/**
					* 设置： 老师照片
					*/
					public void setShizililiangPhoto(String shizililiangPhoto) {
						this.shizililiangPhoto = shizililiangPhoto;
					}

					/**
					* 获取： 所教专业
					*/
					public Integer getShizililiangTypes() {
						return shizililiangTypes;
					}
					/**
					* 设置： 所教专业
					*/
					public void setShizililiangTypes(Integer shizililiangTypes) {
						this.shizililiangTypes = shizililiangTypes;
					}


						/**
						* 获取： 所教专业的值
						*/
						public String getShizililiangValue() {
							return shizililiangValue;
						}
						/**
						* 设置： 所教专业的值
						*/
						public void setShizililiangValue(String shizililiangValue) {
							this.shizililiangValue = shizililiangValue;
						}

					/**
					* 获取： 擅长
					*/
					public String getShizililiangShanchang() {
						return shizililiangShanchang;
					}
					/**
					* 设置： 擅长
					*/
					public void setShizililiangShanchang(String shizililiangShanchang) {
						this.shizililiangShanchang = shizililiangShanchang;
					}

					/**
					* 获取： 所获荣誉
					*/
					public String getShizililiangRongyu() {
						return shizililiangRongyu;
					}
					/**
					* 设置： 所获荣誉
					*/
					public void setShizililiangRongyu(String shizililiangRongyu) {
						this.shizililiangRongyu = shizililiangRongyu;
					}

					/**
					* 获取： 老师详细介绍
					*/
					public String getShizililiangContent() {
						return shizililiangContent;
					}
					/**
					* 设置： 老师详细介绍
					*/
					public void setShizililiangContent(String shizililiangContent) {
						this.shizililiangContent = shizililiangContent;
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
					public Integer getShizililiangDelete() {
						return shizililiangDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShizililiangDelete(Integer shizililiangDelete) {
						this.shizililiangDelete = shizililiangDelete;
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
