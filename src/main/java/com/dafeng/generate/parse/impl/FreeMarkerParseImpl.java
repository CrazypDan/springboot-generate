package com.dafeng.generate.parse.impl;

import com.dafeng.generate.bean.BasicDataBean;
import com.dafeng.generate.bean.TemplateBean;
import com.dafeng.generate.parse.Parse;
import com.dafeng.generate.utils.CopyDataUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

/**
 * freemark 解析
 *
 * @author da.feng
 */
@Slf4j
public class FreeMarkerParseImpl implements Parse {

    private static final StringTemplateLoader RESOURCE_LOADER = new StringTemplateLoader();

    private static Configuration cfg;

    static {
        try {
            cfg = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
            cfg.setTemplateLoader(RESOURCE_LOADER);
            cfg.setLocale(Locale.CHINA);
            cfg.setDefaultEncoding("UTF-8");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<TemplateBean> parse(BasicDataBean bean, List<TemplateBean> templateList) {
        List<TemplateBean> list = CopyDataUtil.copyList(templateList, TemplateBean.class);
        try {
            Template t;
            for (TemplateBean template : list) {
                RESOURCE_LOADER.putTemplate(template.getTemplateContent().hashCode() + "_FTL_KEY", template.getTemplateContent());
                t = cfg.getTemplate(template.getTemplateContent().hashCode() + "_FTL_KEY");
                Writer write = new StringWriter();
                Map<String, Object> paramsMap = new HashMap<>(4);
                paramsMap.put("data", bean);
                t.process(paramsMap, write);
                template.setTemplateContent(write.toString());
                template.setClassName(bean.getClassName());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }

}
