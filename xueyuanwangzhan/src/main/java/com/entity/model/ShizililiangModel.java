package com.entity.model;

import com.entity.ShizililiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 师资力量
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShizililiangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 逻辑删除
     */
    private Integer shizililiangDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：老师工号
	 */
    public String getShizililiangUuidNumber() {
        return shizililiangUuidNumber;
    }


    /**
	 * 设置：老师工号
	 */
    public void setShizililiangUuidNumber(String shizililiangUuidNumber) {
        this.shizililiangUuidNumber = shizililiangUuidNumber;
    }
    /**
	 * 获取：老师名称
	 */
    public String getShizililiangName() {
        return shizililiangName;
    }


    /**
	 * 设置：老师名称
	 */
    public void setShizililiangName(String shizililiangName) {
        this.shizililiangName = shizililiangName;
    }
    /**
	 * 获取：老师照片
	 */
    public String getShizililiangPhoto() {
        return shizililiangPhoto;
    }


    /**
	 * 设置：老师照片
	 */
    public void setShizililiangPhoto(String shizililiangPhoto) {
        this.shizililiangPhoto = shizililiangPhoto;
    }
    /**
	 * 获取：所教专业
	 */
    public Integer getShizililiangTypes() {
        return shizililiangTypes;
    }


    /**
	 * 设置：所教专业
	 */
    public void setShizililiangTypes(Integer shizililiangTypes) {
        this.shizililiangTypes = shizililiangTypes;
    }
    /**
	 * 获取：擅长
	 */
    public String getShizililiangShanchang() {
        return shizililiangShanchang;
    }


    /**
	 * 设置：擅长
	 */
    public void setShizililiangShanchang(String shizililiangShanchang) {
        this.shizililiangShanchang = shizililiangShanchang;
    }
    /**
	 * 获取：所获荣誉
	 */
    public String getShizililiangRongyu() {
        return shizililiangRongyu;
    }


    /**
	 * 设置：所获荣誉
	 */
    public void setShizililiangRongyu(String shizililiangRongyu) {
        this.shizililiangRongyu = shizililiangRongyu;
    }
    /**
	 * 获取：老师详细介绍
	 */
    public String getShizililiangContent() {
        return shizililiangContent;
    }


    /**
	 * 设置：老师详细介绍
	 */
    public void setShizililiangContent(String shizililiangContent) {
        this.shizililiangContent = shizililiangContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShizililiangDelete() {
        return shizililiangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShizililiangDelete(Integer shizililiangDelete) {
        this.shizililiangDelete = shizililiangDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
