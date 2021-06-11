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
public class ProtocolCheckResult {
    private Long id;
    private String sheetName;
    private String columnName;
    private String srcRowId;
    private String dstRowId;
    //暂时string
    private String paramCheckRule;
    //暂时string
    private String checkResult;

    private String oldNeValue;
    private String newNeValue;
}
