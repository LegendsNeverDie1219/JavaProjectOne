package com.huawei.nce.javabase.day18.multithread;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:16
 */
public interface BaseThreadServiceTemplate<T> {

    // index为查询索引, num为查询记录数
    List<T> getList(int index, int num);

    // 查询总记录数
    int getCount();
}
