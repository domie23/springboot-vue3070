package com.dao;

import com.entity.XiaoyuanfengguangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoyuanfengguangView;

/**
 * 校园风光 Dao 接口
 *
 * @author 
 */
public interface XiaoyuanfengguangDao extends BaseMapper<XiaoyuanfengguangEntity> {

   List<XiaoyuanfengguangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
