package com.entity.model;

import com.entity.XiaoyuanfengguangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 校园风光
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XiaoyuanfengguangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 逻辑删除
     */
    private Integer xiaoyuanfengguangDelete;


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
	 * 获取：风光编号
	 */
    public String getXiaoyuanfengguangUuidNumber() {
        return xiaoyuanfengguangUuidNumber;
    }


    /**
	 * 设置：风光编号
	 */
    public void setXiaoyuanfengguangUuidNumber(String xiaoyuanfengguangUuidNumber) {
        this.xiaoyuanfengguangUuidNumber = xiaoyuanfengguangUuidNumber;
    }
    /**
	 * 获取：校园风光名称
	 */
    public String getXiaoyuanfengguangName() {
        return xiaoyuanfengguangName;
    }


    /**
	 * 设置：校园风光名称
	 */
    public void setXiaoyuanfengguangName(String xiaoyuanfengguangName) {
        this.xiaoyuanfengguangName = xiaoyuanfengguangName;
    }
    /**
	 * 获取：校园风光照片
	 */
    public String getXiaoyuanfengguangPhoto() {
        return xiaoyuanfengguangPhoto;
    }


    /**
	 * 设置：校园风光照片
	 */
    public void setXiaoyuanfengguangPhoto(String xiaoyuanfengguangPhoto) {
        this.xiaoyuanfengguangPhoto = xiaoyuanfengguangPhoto;
    }
    /**
	 * 获取：校园风光类型
	 */
    public Integer getXiaoyuanfengguangTypes() {
        return xiaoyuanfengguangTypes;
    }


    /**
	 * 设置：校园风光类型
	 */
    public void setXiaoyuanfengguangTypes(Integer xiaoyuanfengguangTypes) {
        this.xiaoyuanfengguangTypes = xiaoyuanfengguangTypes;
    }
    /**
	 * 获取：热度
	 */
    public Integer getXiaoyuanfengguangClicknum() {
        return xiaoyuanfengguangClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setXiaoyuanfengguangClicknum(Integer xiaoyuanfengguangClicknum) {
        this.xiaoyuanfengguangClicknum = xiaoyuanfengguangClicknum;
    }
    /**
	 * 获取：校园风光介绍
	 */
    public String getXiaoyuanfengguangContent() {
        return xiaoyuanfengguangContent;
    }


    /**
	 * 设置：校园风光介绍
	 */
    public void setXiaoyuanfengguangContent(String xiaoyuanfengguangContent) {
        this.xiaoyuanfengguangContent = xiaoyuanfengguangContent;
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
    public Integer getXiaoyuanfengguangDelete() {
        return xiaoyuanfengguangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXiaoyuanfengguangDelete(Integer xiaoyuanfengguangDelete) {
        this.xiaoyuanfengguangDelete = xiaoyuanfengguangDelete;
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
