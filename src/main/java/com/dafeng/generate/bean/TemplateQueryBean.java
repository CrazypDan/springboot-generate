package com.dafeng.generate.bean;

import lombok.*;

/**
 * TABLE_NAME:(t_code_template)
 * 模板信息
 *
 * @author da.feng
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TemplateQueryBean extends BasePage {


    /**
     * 模板名称
     */
    private String templateName;


    /**
     * 模板地址
     */
    private String templateType;


    /**
     * 模板组
     */
    private Long groupId;

    /**
     * 模板引擎类型
     */
    private String templateEngineType;

}