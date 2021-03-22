package com.dafeng.generate.controller;


import com.dafeng.generate.bean.*;
import com.dafeng.generate.service.DatabaseInfoService;
import com.dafeng.generate.utils.CopyDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 数据库管理
 *
 * @author da.feng
 * @version V1.0
 **/

@Controller
@RequestMapping("/databaseInfo")
public class DatabaseInfoController extends BaseController {

    @Autowired
    private DatabaseInfoService codeDatabaseInfoService;


    /**
     * 跳转到 数据库管理 页面
     */
    @GetMapping("/info")
    public String dbinfo() {
        return "dbinfo/dbinfo";
    }

    /**
     * 跳转到 数据库管理新增 页面
     */
    @GetMapping("/add")
    public String dbinfoAdd() {
        return "dbinfo/dbinfo_add";
    }


    /**
     * 跳转到 数据库管理编辑 页面
     *
     * @param id 主键id
     */
    @GetMapping(value = "/edit/{id}")
    public String query(@PathVariable("id") Long id, Model model) {
        DatabaseInfoBean bean = CopyDataUtil.copyObject(codeDatabaseInfoService.getById(id), DatabaseInfoBean.class);
        model.addAttribute("dbinfo", bean);
        return "dbinfo/dbinfo_edit";
    }


    /**
     * 获取所有数据
     *
     * @param dto DatabaseInfoBean
     * @return ResultData<Page   <   DatabaseInfoBean>>
     */
    @PostMapping(value = "/list")
    @ResponseBody
    public ResultData<Page<DatabaseInfoBean>> getList(@RequestBody DatabaseInfoQueryBean dto) {
        return ResultData.createSelectSuccessResult(convertPageInfo(codeDatabaseInfoService.getList(dto), DatabaseInfoBean.class));
    }


    /**
     * 添加
     *
     * @param dto DatabaseInfoDto
     * @return ResultData<DatabaseInfoBean>
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public ResultData<DatabaseInfoBean> insert( @RequestBody DatabaseInfoBean dto) {
        return ResultData.createInsertResult(codeDatabaseInfoService.insert(dto));
    }

    /**
     * 更新
     *
     * @param dto DatabaseInfoDto
     * @return ResultData<DatabaseInfoBean>
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    public ResultData<DatabaseInfoBean> update(@RequestBody DatabaseInfoBean dto) {
        return ResultData.createUpdateResult(codeDatabaseInfoService.update(dto));
    }


    /**
     * 删除
     *
     * @param id 主键id
     * @return ResultData<String>
     */
    @PostMapping(value = "/remove")
    @ResponseBody
    public ResultData<Void> delete(@RequestBody IdBean id) {
        return ResultData.createDeleteResult(codeDatabaseInfoService.delete(id.getId()));
    }

}
