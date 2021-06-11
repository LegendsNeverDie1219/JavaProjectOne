package com.huawei.nce.pojo;

import lombok.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/11/6 22:37
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProtocolRule {
    private Long id;
    private String projectId;
    private Long templateId;
    private String groupName;
    private String sheetName;
    private String columnName;
    //暂时string
    private String paramType;
    //暂时string
    private String paramCheckRule;
    private String paramId;
}
