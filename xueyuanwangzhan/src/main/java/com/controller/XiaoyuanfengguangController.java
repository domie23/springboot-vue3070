
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
 * 校园风光
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaoyuanfengguang")
public class XiaoyuanfengguangController {
    private static final Logger logger = LoggerFactory.getLogger(XiaoyuanfengguangController.class);

    @Autowired
    private XiaoyuanfengguangService xiaoyuanfengguangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        params.put("xiaoyuanfengguangDeleteStart",1);params.put("xiaoyuanfengguangDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xiaoyuanfengguangService.queryPage(params);

        //字典表数据转换
        List<XiaoyuanfengguangView> list =(List<XiaoyuanfengguangView>)page.getList();
        for(XiaoyuanfengguangView c:list){
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
        XiaoyuanfengguangEntity xiaoyuanfengguang = xiaoyuanfengguangService.selectById(id);
        if(xiaoyuanfengguang !=null){
            //entity转view
            XiaoyuanfengguangView view = new XiaoyuanfengguangView();
            BeanUtils.copyProperties( xiaoyuanfengguang , view );//把实体数据重构到view中

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
    public R save(@RequestBody XiaoyuanfengguangEntity xiaoyuanfengguang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaoyuanfengguang:{}",this.getClass().getName(),xiaoyuanfengguang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XiaoyuanfengguangEntity> queryWrapper = new EntityWrapper<XiaoyuanfengguangEntity>()
            .eq("xiaoyuanfengguang_uuid_number", xiaoyuanfengguang.getXiaoyuanfengguangUuidNumber())
            .eq("xiaoyuanfengguang_name", xiaoyuanfengguang.getXiaoyuanfengguangName())
            .eq("xiaoyuanfengguang_types", xiaoyuanfengguang.getXiaoyuanfengguangTypes())
            .eq("xiaoyuanfengguang_clicknum", xiaoyuanfengguang.getXiaoyuanfengguangClicknum())
            .eq("shangxia_types", xiaoyuanfengguang.getShangxiaTypes())
            .eq("xiaoyuanfengguang_delete", xiaoyuanfengguang.getXiaoyuanfengguangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoyuanfengguangEntity xiaoyuanfengguangEntity = xiaoyuanfengguangService.selectOne(queryWrapper);
        if(xiaoyuanfengguangEntity==null){
            xiaoyuanfengguang.setXiaoyuanfengguangClicknum(1);
            xiaoyuanfengguang.setShangxiaTypes(1);
            xiaoyuanfengguang.setXiaoyuanfengguangDelete(1);
            xiaoyuanfengguang.setCreateTime(new Date());
            xiaoyuanfengguangService.insert(xiaoyuanfengguang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoyuanfengguangEntity xiaoyuanfengguang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiaoyuanfengguang:{}",this.getClass().getName(),xiaoyuanfengguang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XiaoyuanfengguangEntity> queryWrapper = new EntityWrapper<XiaoyuanfengguangEntity>()
            .notIn("id",xiaoyuanfengguang.getId())
            .andNew()
            .eq("xiaoyuanfengguang_uuid_number", xiaoyuanfengguang.getXiaoyuanfengguangUuidNumber())
            .eq("xiaoyuanfengguang_name", xiaoyuanfengguang.getXiaoyuanfengguangName())
            .eq("xiaoyuanfengguang_types", xiaoyuanfengguang.getXiaoyuanfengguangTypes())
            .eq("xiaoyuanfengguang_clicknum", xiaoyuanfengguang.getXiaoyuanfengguangClicknum())
            .eq("shangxia_types", xiaoyuanfengguang.getShangxiaTypes())
            .eq("xiaoyuanfengguang_delete", xiaoyuanfengguang.getXiaoyuanfengguangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoyuanfengguangEntity xiaoyuanfengguangEntity = xiaoyuanfengguangService.selectOne(queryWrapper);
        if("".equals(xiaoyuanfengguang.getXiaoyuanfengguangPhoto()) || "null".equals(xiaoyuanfengguang.getXiaoyuanfengguangPhoto())){
                xiaoyuanfengguang.setXiaoyuanfengguangPhoto(null);
        }
        if(xiaoyuanfengguangEntity==null){
            xiaoyuanfengguangService.updateById(xiaoyuanfengguang);//根据id更新
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
        ArrayList<XiaoyuanfengguangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XiaoyuanfengguangEntity xiaoyuanfengguangEntity = new XiaoyuanfengguangEntity();
            xiaoyuanfengguangEntity.setId(id);
            xiaoyuanfengguangEntity.setXiaoyuanfengguangDelete(2);
            list.add(xiaoyuanfengguangEntity);
        }
        if(list != null && list.size() >0){
            xiaoyuanfengguangService.updateBatchById(list);
        }
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
            List<XiaoyuanfengguangEntity> xiaoyuanfengguangList = new ArrayList<>();//上传的东西
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
                            XiaoyuanfengguangEntity xiaoyuanfengguangEntity = new XiaoyuanfengguangEntity();
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangUuidNumber(data.get(0));                    //风光编号 要改的
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangName(data.get(0));                    //校园风光名称 要改的
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangPhoto("");//详情和图片
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangTypes(Integer.valueOf(data.get(0)));   //校园风光类型 要改的
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangClicknum(Integer.valueOf(data.get(0)));   //热度 要改的
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangContent("");//详情和图片
//                            xiaoyuanfengguangEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            xiaoyuanfengguangEntity.setXiaoyuanfengguangDelete(1);//逻辑删除字段
//                            xiaoyuanfengguangEntity.setCreateTime(date);//时间
                            xiaoyuanfengguangList.add(xiaoyuanfengguangEntity);


                            //把要查询是否重复的字段放入map中
                                //风光编号
                                if(seachFields.containsKey("xiaoyuanfengguangUuidNumber")){
                                    List<String> xiaoyuanfengguangUuidNumber = seachFields.get("xiaoyuanfengguangUuidNumber");
                                    xiaoyuanfengguangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xiaoyuanfengguangUuidNumber = new ArrayList<>();
                                    xiaoyuanfengguangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xiaoyuanfengguangUuidNumber",xiaoyuanfengguangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //风光编号
                        List<XiaoyuanfengguangEntity> xiaoyuanfengguangEntities_xiaoyuanfengguangUuidNumber = xiaoyuanfengguangService.selectList(new EntityWrapper<XiaoyuanfengguangEntity>().in("xiaoyuanfengguang_uuid_number", seachFields.get("xiaoyuanfengguangUuidNumber")).eq("xiaoyuanfengguang_delete", 1));
                        if(xiaoyuanfengguangEntities_xiaoyuanfengguangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XiaoyuanfengguangEntity s:xiaoyuanfengguangEntities_xiaoyuanfengguangUuidNumber){
                                repeatFields.add(s.getXiaoyuanfengguangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [风光编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xiaoyuanfengguangService.insertBatch(xiaoyuanfengguangList);
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
        PageUtils page = xiaoyuanfengguangService.queryPage(params);

        //字典表数据转换
        List<XiaoyuanfengguangView> list =(List<XiaoyuanfengguangView>)page.getList();
        for(XiaoyuanfengguangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaoyuanfengguangEntity xiaoyuanfengguang = xiaoyuanfengguangService.selectById(id);
            if(xiaoyuanfengguang !=null){

                //点击数量加1
                xiaoyuanfengguang.setXiaoyuanfengguangClicknum(xiaoyuanfengguang.getXiaoyuanfengguangClicknum()+1);
                xiaoyuanfengguangService.updateById(xiaoyuanfengguang);

                //entity转view
                XiaoyuanfengguangView view = new XiaoyuanfengguangView();
                BeanUtils.copyProperties( xiaoyuanfengguang , view );//把实体数据重构到view中

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
    public R add(@RequestBody XiaoyuanfengguangEntity xiaoyuanfengguang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xiaoyuanfengguang:{}",this.getClass().getName(),xiaoyuanfengguang.toString());
        Wrapper<XiaoyuanfengguangEntity> queryWrapper = new EntityWrapper<XiaoyuanfengguangEntity>()
            .eq("xiaoyuanfengguang_uuid_number", xiaoyuanfengguang.getXiaoyuanfengguangUuidNumber())
            .eq("xiaoyuanfengguang_name", xiaoyuanfengguang.getXiaoyuanfengguangName())
            .eq("xiaoyuanfengguang_types", xiaoyuanfengguang.getXiaoyuanfengguangTypes())
            .eq("xiaoyuanfengguang_clicknum", xiaoyuanfengguang.getXiaoyuanfengguangClicknum())
            .eq("shangxia_types", xiaoyuanfengguang.getShangxiaTypes())
            .eq("xiaoyuanfengguang_delete", xiaoyuanfengguang.getXiaoyuanfengguangDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiaoyuanfengguangEntity xiaoyuanfengguangEntity = xiaoyuanfengguangService.selectOne(queryWrapper);
        if(xiaoyuanfengguangEntity==null){
            xiaoyuanfengguang.setXiaoyuanfengguangDelete(1);
            xiaoyuanfengguang.setCreateTime(new Date());
        xiaoyuanfengguangService.insert(xiaoyuanfengguang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
