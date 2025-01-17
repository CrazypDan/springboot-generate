package com.dafeng.generate.bean;

import lombok.*;

/**
 * TABLE_NAME:(t_code_params)
 * 生成代码的一些基本参数
 *
 * @author da.feng
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TemplateEngineQueryBean extends BasePage {

    /**
     * 模板引擎名称
     */
    private String engineName;

}