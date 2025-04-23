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
 * 校园风光
 *
 * @author 
 * @email
 */
@TableName("xiaoyuanfengguang")
public class XiaoyuanfengguangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XiaoyuanfengguangEntity() {

	}

	public XiaoyuanfengguangEntity(T t) {
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
     * 风光编号
     */
    @TableField(value = "xiaoyuanfengguang_uuid_number")

    private String xiaoyuanfengguangUuidNumber;


    /**
     * 校园风光名称
     */
    @TableField(value = "xiaoyuanfengguang_name")

    private String xiaoyuanfengguangName;


    /**
     * 校园风光照片
     */
    @TableField(value = "xiaoyuanfengguang_photo")

    private String xiaoyuanfengguangPhoto;


    /**
     * 校园风光类型
     */
    @TableField(value = "xiaoyuanfengguang_types")

    private Integer xiaoyuanfengguangTypes;


    /**
     * 热度
     */
    @TableField(value = "xiaoyuanfengguang_clicknum")

    private Integer xiaoyuanfengguangClicknum;


    /**
     * 校园风光介绍
     */
    @TableField(value = "xiaoyuanfengguang_content")

    private String xiaoyuanfengguangContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "xiaoyuanfengguang_delete")

    private Integer xiaoyuanfengguangDelete;


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
	 * 设置：风光编号
	 */
    public String getXiaoyuanfengguangUuidNumber() {
        return xiaoyuanfengguangUuidNumber;
    }
    /**
	 * 获取：风光编号
	 */

    public void setXiaoyuanfengguangUuidNumber(String xiaoyuanfengguangUuidNumber) {
        this.xiaoyuanfengguangUuidNumber = xiaoyuanfengguangUuidNumber;
    }
    /**
	 * 设置：校园风光名称
	 */
    public String getXiaoyuanfengguangName() {
        return xiaoyuanfengguangName;
    }
    /**
	 * 获取：校园风光名称
	 */

    public void setXiaoyuanfengguangName(String xiaoyuanfengguangName) {
        this.xiaoyuanfengguangName = xiaoyuanfengguangName;
    }
    /**
	 * 设置：校园风光照片
	 */
    public String getXiaoyuanfengguangPhoto() {
        return xiaoyuanfengguangPhoto;
    }
    /**
	 * 获取：校园风光照片
	 */

    public void setXiaoyuanfengguangPhoto(String xiaoyuanfengguangPhoto) {
        this.xiaoyuanfengguangPhoto = xiaoyuanfengguangPhoto;
    }
    /**
	 * 设置：校园风光类型
	 */
    public Integer getXiaoyuanfengguangTypes() {
        return xiaoyuanfengguangTypes;
    }
    /**
	 * 获取：校园风光类型
	 */

    public void setXiaoyuanfengguangTypes(Integer xiaoyuanfengguangTypes) {
        this.xiaoyuanfengguangTypes = xiaoyuanfengguangTypes;
    }
    /**
	 * 设置：热度
	 */
    public Integer getXiaoyuanfengguangClicknum() {
        return xiaoyuanfengguangClicknum;
    }
    /**
	 * 获取：热度
	 */

    public void setXiaoyuanfengguangClicknum(Integer xiaoyuanfengguangClicknum) {
        this.xiaoyuanfengguangClicknum = xiaoyuanfengguangClicknum;
    }
    /**
	 * 设置：校园风光介绍
	 */
    public String getXiaoyuanfengguangContent() {
        return xiaoyuanfengguangContent;
    }
    /**
	 * 获取：校园风光介绍
	 */

    public void setXiaoyuanfengguangContent(String xiaoyuanfengguangContent) {
        this.xiaoyuanfengguangContent = xiaoyuanfengguangContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXiaoyuanfengguangDelete() {
        return xiaoyuanfengguangDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setXiaoyuanfengguangDelete(Integer xiaoyuanfengguangDelete) {
        this.xiaoyuanfengguangDelete = xiaoyuanfengguangDelete;
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
        return "Xiaoyuanfengguang{" +
            "id=" + id +
            ", xiaoyuanfengguangUuidNumber=" + xiaoyuanfengguangUuidNumber +
            ", xiaoyuanfengguangName=" + xiaoyuanfengguangName +
            ", xiaoyuanfengguangPhoto=" + xiaoyuanfengguangPhoto +
            ", xiaoyuanfengguangTypes=" + xiaoyuanfengguangTypes +
            ", xiaoyuanfengguangClicknum=" + xiaoyuanfengguangClicknum +
            ", xiaoyuanfengguangContent=" + xiaoyuanfengguangContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", xiaoyuanfengguangDelete=" + xiaoyuanfengguangDelete +
            ", createTime=" + createTime +
        "}";
    }
}
