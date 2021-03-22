package com.dafeng.generate.service;


import com.dafeng.generate.model.TemplateEngineModel;
import com.dafeng.generate.bean.TemplateEngineBean;
import com.dafeng.generate.bean.TemplateEngineQueryBean;

import java.util.List;


/**
 * interface TemplateEngineservice
 *
 * @author da.feng
 */
public interface TemplateEngineService {

    /**
     * 返回分页列表信息
     *
     * @param bean 数据
     * @return list<TemplateEngineModel>
     */
    List<TemplateEngineModel> getList(TemplateEngineQueryBean bean);


    /**
     * 返回分页列表信息
     *
     * @return list<TemplateEngineModel>
     */
    List<TemplateEngineBean> getList();

    /**
     * 根据id返回信息
     *
     * @param id id
     * @return SysUserModel
     */
    TemplateEngineModel getById(Long id);


    /**
     * 增加
     *
     * @param bean 数据
     * @return boolean
     */
    boolean insert(TemplateEngineBean bean);


    /**
     * 根据ID删除
     *
     * @param id id
     * @return boolean
     */
    boolean delete(Long id);

    /**
     * 更新
     *
     * @param bean 数据
     * @return boolean
     */
    boolean update(TemplateEngineBean bean);

}