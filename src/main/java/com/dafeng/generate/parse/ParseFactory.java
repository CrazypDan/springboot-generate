package com.dafeng.generate.parse;


import com.dafeng.generate.parse.impl.FreeMarkerParseImpl;
import com.dafeng.generate.enums.TemplateEnum;

/**
 * 获取解析模板类的工厂
 *
 * @author da.feng
 */
public class ParseFactory {

    private ParseFactory() {}

    /**
     * 获取解析模板类
     *
     * @param type 模板类型
     * @return     模板类
     */
    public static Parse getParse(TemplateEnum type) {
        if (TemplateEnum.FREEMARKER.equals(type)) {
            return new FreeMarkerParseImpl();
        }
        throw new RuntimeException("模板类型不支持");
    }

}
