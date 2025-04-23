package com.entity.view;

import com.entity.XiaoyuanfengguangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 校园风光
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xiaoyuanfengguang")
public class XiaoyuanfengguangView extends XiaoyuanfengguangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 校园风光类型的值
		*/
		private String xiaoyuanfengguangValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public XiaoyuanfengguangView() {

	}

	public XiaoyuanfengguangView(XiaoyuanfengguangEntity xiaoyuanfengguangEntity) {
		try {
			BeanUtils.copyProperties(this, xiaoyuanfengguangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
