package com.entity.view;

import com.entity.XueshengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 学生
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xuesheng")
public class XueshengView extends XueshengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 年龄段的值
		*/
		private String nianlingduanValue;
		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 班级的值
		*/
		private String banjiValue;
		/**
		* 院系的值
		*/
		private String yuanxiValue;
		/**
		* 生源地的值
		*/
		private String shengyuandiValue;



	public XueshengView() {

	}

	public XueshengView(XueshengEntity xueshengEntity) {
		try {
			BeanUtils.copyProperties(this, xueshengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
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
