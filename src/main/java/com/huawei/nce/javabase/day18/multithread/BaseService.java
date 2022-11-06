package com.huawei.nce.javabase.day18.multithread;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:16
 */
@FunctionalInterface
public interface BaseService<T> {
    List<T> template();
}
