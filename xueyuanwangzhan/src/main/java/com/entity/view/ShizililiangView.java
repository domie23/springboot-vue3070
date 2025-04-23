package com.entity.view;

import com.entity.ShizililiangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 师资力量
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shizililiang")
public class ShizililiangView extends ShizililiangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 所教专业的值
		*/
		private String shizililiangValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public ShizililiangView() {

	}

	public ShizililiangView(ShizililiangEntity shizililiangEntity) {
		try {
			BeanUtils.copyProperties(this, shizililiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
