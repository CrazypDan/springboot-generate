package com.dafeng.generate.mapper;


import com.dafeng.generate.model.TemplateModel;
import com.dafeng.generate.bean.TemplateBean;
import com.dafeng.generate.bean.TemplateQueryBean;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * interface TemplateMapper
 *
 * @author da.feng
 */

public interface TemplateMapper extends Mapper<TemplateModel>, MySqlMapper<TemplateModel> {


    /**
     * 返回分页列表信息
     *
     * @param bean 数据
     * @return list<TemplateModel>
     */
    List<TemplateBean> getList(TemplateQueryBean bean);


    /**
     * 查询模板内容
     *
     * @param templateIds 模板id
     * @return list<String>
     */
    List<TemplateBean> getTemplateComment(@Param("templateIds") List<Long> templateIds);

}