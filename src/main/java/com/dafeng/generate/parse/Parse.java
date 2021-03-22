package com.dafeng.generate.parse;


import com.dafeng.generate.bean.BasicDataBean;
import com.dafeng.generate.bean.TemplateBean;

import java.util.List;

/**
 * 模板解析接口
 *    用户扩展不同类型的模板引擎解析
 *
 * @author da.feng
 */
public interface Parse {


    /**
     * 解析模板 生成文件
     *
     * @param bean           封装的参数
     * @param templateList   模板
     * @return 生成完成的模板内容
     */
    List<TemplateBean> parse(BasicDataBean bean, List<TemplateBean> templateList);

}
