package com.dafeng.generate.service;


import com.dafeng.generate.model.TemplateGroupModel;
import com.dafeng.generate.bean.TemplateGroupBean;
import com.dafeng.generate.bean.TemplateGroupQueryBean;

import java.util.List;


/**
 * interface TemplateGroupservice
 *
 * @author da.feng
 */
public interface TemplateGroupService {

    /**
     * 返回分页列表信息
     *
     * @param bean 数据
     * @return list<TemplateGroupModel>
     */
    List<TemplateGroupModel> getList(TemplateGroupQueryBean bean);


    /**
     * 返回分页列表信息
     *
     * @return list<TemplateGroupModel>
     */
    List<TemplateGroupBean> getList();

    /**
     * 根据id返回信息
     *
     * @param id id
     * @return SysUserModel
     */
    TemplateGroupModel getById(Long id);


    /**
     * 增加
     *
     * @param bean 数据
     * @return boolean
     */
    boolean insert(TemplateGroupBean bean);


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
    boolean update(TemplateGroupBean bean);

}