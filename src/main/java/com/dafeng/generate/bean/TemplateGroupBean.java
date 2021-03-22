package com.dafeng.generate.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TABLE_NAME:(t_code_template_group)
 * 模板组
 *
 * @author da.feng
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TemplateGroupBean {


    /**
     *
     */

    private Long id;


    /**
     * 组名称
     */
    private String groupName;


    /**
     * 描述
     */
    private String groupDesc;


    /**
     * 创建时间
     */
    private String createTime;


    /**
     * 修改时间
     */
    private String updateTime;


}