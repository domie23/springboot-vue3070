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
 * 师资力量
 *
 * @author 
 * @email
 */
@TableName("shizililiang")
public class ShizililiangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShizililiangEntity() {

	}

	public ShizililiangEntity(T t) {
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
     * 老师工号
     */
    @TableField(value = "shizililiang_uuid_number")

    private String shizililiangUuidNumber;


    /**
     * 老师名称
     */
    @TableField(value = "shizililiang_name")

    private String shizililiangName;


    /**
     * 老师照片
     */
    @TableField(value = "shizililiang_photo")

    private String shizililiangPhoto;


    /**
     * 所教专业
     */
    @TableField(value = "shizililiang_types")

    private Integer shizililiangTypes;


    /**
     * 擅长
     */
    @TableField(value = "shizililiang_shanchang")

    private String shizililiangShanchang;


    /**
     * 所获荣誉
     */
    @TableField(value = "shizililiang_rongyu")

    private String shizililiangRongyu;


    /**
     * 老师详细介绍
     */
    @TableField(value = "shizililiang_content")

    private String shizililiangContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "shizililiang_delete")

    private Integer shizililiangDelete;


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
	 * 设置：老师工号
	 */
    public String getShizililiangUuidNumber() {
        return shizililiangUuidNumber;
    }
    /**
	 * 获取：老师工号
	 */

    public void setShizililiangUuidNumber(String shizililiangUuidNumber) {
        this.shizililiangUuidNumber = shizililiangUuidNumber;
    }
    /**
	 * 设置：老师名称
	 */
    public String getShizililiangName() {
        return shizililiangName;
    }
    /**
	 * 获取：老师名称
	 */

    public void setShizililiangName(String shizililiangName) {
        this.shizililiangName = shizililiangName;
    }
    /**
	 * 设置：老师照片
	 */
    public String getShizililiangPhoto() {
        return shizililiangPhoto;
    }
    /**
	 * 获取：老师照片
	 */

    public void setShizililiangPhoto(String shizililiangPhoto) {
        this.shizililiangPhoto = shizililiangPhoto;
    }
    /**
	 * 设置：所教专业
	 */
    public Integer getShizililiangTypes() {
        return shizililiangTypes;
    }
    /**
	 * 获取：所教专业
	 */

    public void setShizililiangTypes(Integer shizililiangTypes) {
        this.shizililiangTypes = shizililiangTypes;
    }
    /**
	 * 设置：擅长
	 */
    public String getShizililiangShanchang() {
        return shizililiangShanchang;
    }
    /**
	 * 获取：擅长
	 */

    public void setShizililiangShanchang(String shizililiangShanchang) {
        this.shizililiangShanchang = shizililiangShanchang;
    }
    /**
	 * 设置：所获荣誉
	 */
    public String getShizililiangRongyu() {
        return shizililiangRongyu;
    }
    /**
	 * 获取：所获荣誉
	 */

    public void setShizililiangRongyu(String shizililiangRongyu) {
        this.shizililiangRongyu = shizililiangRongyu;
    }
    /**
	 * 设置：老师详细介绍
	 */
    public String getShizililiangContent() {
        return shizililiangContent;
    }
    /**
	 * 获取：老师详细介绍
	 */

    public void setShizililiangContent(String shizililiangContent) {
        this.shizililiangContent = shizililiangContent;
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
    public Integer getShizililiangDelete() {
        return shizililiangDelete;
    }
    /**
	 * 获取：逻辑删除
	 */

    public void setShizililiangDelete(Integer shizililiangDelete) {
        this.shizililiangDelete = shizililiangDelete;
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
        return "Shizililiang{" +
            "id=" + id +
            ", shizililiangUuidNumber=" + shizililiangUuidNumber +
            ", shizililiangName=" + shizililiangName +
            ", shizililiangPhoto=" + shizililiangPhoto +
            ", shizililiangTypes=" + shizililiangTypes +
            ", shizililiangShanchang=" + shizililiangShanchang +
            ", shizililiangRongyu=" + shizililiangRongyu +
            ", shizililiangContent=" + shizililiangContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", shizililiangDelete=" + shizililiangDelete +
            ", createTime=" + createTime +
        "}";
    }
}
