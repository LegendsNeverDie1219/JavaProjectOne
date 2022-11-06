package com.huawei.nce.javabase.day18.multithread;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:17
 */
public interface MultiThreadQueryService {
    // 获取最后合并的结果
    List<List> getResult(BaseThreadServiceTemplate baseThreadServiceTemplate);
}

