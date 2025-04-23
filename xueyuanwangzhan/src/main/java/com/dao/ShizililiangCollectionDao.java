package com.dao;

import com.entity.ShizililiangCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShizililiangCollectionView;

/**
 * 师资力量收藏 Dao 接口
 *
 * @author 
 */
public interface ShizililiangCollectionDao extends BaseMapper<ShizililiangCollectionEntity> {

   List<ShizililiangCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
