package com.dafeng.generate.service;


import com.dafeng.generate.bean.TemplateBean;
import com.dafeng.generate.bean.TemplateQueryBean;
import com.dafeng.generate.model.TemplateModel;

import java.util.List;


/**
 * interface Templateservice
 *
 * @author da.feng
 */
public interface TemplateService {

    /**
     * 返回分页列表信息
     *
     * @param bean 数据
     * @return list<TemplateModel>
     */
    List<TemplateBean> getList(TemplateQueryBean bean);

    /**
     * 根据id返回信息
     *
     * @param id id
     * @return SysUserModel
     */
    TemplateModel getById(Long id);

    /**
     * 增加
     *
     * @param bean 数据
     * @return boolean
     */
    boolean insert(TemplateBean bean);


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
    boolean update(TemplateBean bean);

}