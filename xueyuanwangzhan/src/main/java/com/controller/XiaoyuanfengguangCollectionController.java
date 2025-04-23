
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 校园风光收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoyuanfengguangCollection")
public class XiaoyuanfengguangCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoyuanfengguangCollectionController.class);

    @Autowired
    private XiaoyuanfengguangCollectionService xiaoyuanfengguangCollectionService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private XiaoyuanfengguangService xiaoyuanfengguangService;
    @Autowired
    private XueshengService xueshengService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiaoyuanfengguangCollectionService.queryPage(params);

        //字典表数据转换
        List<XiaoyuanfengguangCollectionView> list =(List<XiaoyuanfengguangCollectionView>)page.getList();
        for(XiaoyuanfengguangCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollection = xiaoyuanfengguangCollectionService.selectById(id);
        if(xiaoyuanfengguangCollection !=null){
            //entity转view
            XiaoyuanfengguangCollectionView view = new XiaoyuanfengguangCollectionView();
            BeanUtils.copyProperties( xiaoyuanfengguangCollection , view );//把实体数据重构到view中

                //级联表
                XiaoyuanfengguangEntity xiaoyuanfengguang = xiaoyuanfengguangService.selectById(xiaoyuanfengguangCollection.getXiaoyuanfengguangId());
                if(xiaoyuanfengguang != null){
                    BeanUtils.copyProperties( xiaoyuanfengguang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoyuanfengguangId(xiaoyuanfengguang.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(xiaoyuanfengguangCollection.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoyuanfengguangCollection:{}",this.getClass().getName(),xiaoyuanfengguangCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xiaoyuanfengguangCollection.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XiaoyuanfengguangCollectionEntity> queryWrapper = new EntityWrapper<XiaoyuanfengguangCollectionEntity>()
            .eq("xiaoyuanfengguang_id", xiaoyuanfengguangCollection.getXiaoyuanfengguangId())
            .eq("xuesheng_id", xiaoyuanfengguangCollection.getXueshengId())
            .eq("xiaoyuanfengguang_collection_types", xiaoyuanfengguangCollection.getXiaoyuanfengguangCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollectionEntity = xiaoyuanfengguangCollectionService.selectOne(queryWrapper);
        if(xiaoyuanfengguangCollectionEntity==null){
            xiaoyuanfengguangCollection.setInsertTime(new Date());
            xiaoyuanfengguangCollection.setCreateTime(new Date());
            xiaoyuanfengguangCollectionService.insert(xiaoyuanfengguangCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollection, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiaoyuanfengguangCollection:{}",this.getClass().getName(),xiaoyuanfengguangCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xiaoyuanfengguangCollection.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XiaoyuanfengguangCollectionEntity> queryWrapper = new EntityWrapper<XiaoyuanfengguangCollectionEntity>()
            .notIn("id",xiaoyuanfengguangCollection.getId())
            .andNew()
            .eq("xiaoyuanfengguang_id", xiaoyuanfengguangCollection.getXiaoyuanfengguangId())
            .eq("xuesheng_id", xiaoyuanfengguangCollection.getXueshengId())
            .eq("xiaoyuanfengguang_collection_types", xiaoyuanfengguangCollection.getXiaoyuanfengguangCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollectionEntity = xiaoyuanfengguangCollectionService.selectOne(queryWrapper);
        if(xiaoyuanfengguangCollectionEntity==null){
            xiaoyuanfengguangCollectionService.updateById(xiaoyuanfengguangCollection);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiaoyuanfengguangCollectionService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XiaoyuanfengguangCollectionEntity> xiaoyuanfengguangCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollectionEntity = new XiaoyuanfengguangCollectionEntity();
//                            xiaoyuanfengguangCollectionEntity.setXiaoyuanfengguangId(Integer.valueOf(data.get(0)));   //校园风光 要改的
//                            xiaoyuanfengguangCollectionEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xiaoyuanfengguangCollectionEntity.setXiaoyuanfengguangCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            xiaoyuanfengguangCollectionEntity.setInsertTime(date);//时间
//                            xiaoyuanfengguangCollectionEntity.setCreateTime(date);//时间
                            xiaoyuanfengguangCollectionList.add(xiaoyuanfengguangCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xiaoyuanfengguangCollectionService.insertBatch(xiaoyuanfengguangCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xiaoyuanfengguangCollectionService.queryPage(params);

        //字典表数据转换
        List<XiaoyuanfengguangCollectionView> list =(List<XiaoyuanfengguangCollectionView>)page.getList();
        for(XiaoyuanfengguangCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollection = xiaoyuanfengguangCollectionService.selectById(id);
            if(xiaoyuanfengguangCollection !=null){


                //entity转view
                XiaoyuanfengguangCollectionView view = new XiaoyuanfengguangCollectionView();
                BeanUtils.copyProperties( xiaoyuanfengguangCollection , view );//把实体数据重构到view中

                //级联表
                    XiaoyuanfengguangEntity xiaoyuanfengguang = xiaoyuanfengguangService.selectById(xiaoyuanfengguangCollection.getXiaoyuanfengguangId());
                if(xiaoyuanfengguang != null){
                    BeanUtils.copyProperties( xiaoyuanfengguang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXiaoyuanfengguangId(xiaoyuanfengguang.getId());
                }
                //级联表
                    XueshengEntity xuesheng = xueshengService.selectById(xiaoyuanfengguangCollection.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xiaoyuanfengguangCollection:{}",this.getClass().getName(),xiaoyuanfengguangCollection.toString());
        Wrapper<XiaoyuanfengguangCollectionEntity> queryWrapper = new EntityWrapper<XiaoyuanfengguangCollectionEntity>()
            .eq("xiaoyuanfengguang_id", xiaoyuanfengguangCollection.getXiaoyuanfengguangId())
            .eq("xuesheng_id", xiaoyuanfengguangCollection.getXueshengId())
            .eq("xiaoyuanfengguang_collection_types", xiaoyuanfengguangCollection.getXiaoyuanfengguangCollectionTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoyuanfengguangCollectionEntity xiaoyuanfengguangCollectionEntity = xiaoyuanfengguangCollectionService.selectOne(queryWrapper);
        if(xiaoyuanfengguangCollectionEntity==null){
            xiaoyuanfengguangCollection.setInsertTime(new Date());
            xiaoyuanfengguangCollection.setCreateTime(new Date());
        xiaoyuanfengguangCollectionService.insert(xiaoyuanfengguangCollection);
            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }


}
