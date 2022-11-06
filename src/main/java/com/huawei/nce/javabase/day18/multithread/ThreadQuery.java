package com.huawei.nce.javabase.day18.multithread;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/11/2 17:37
 */
public class  ThreadQuery<T> implements Callable<List<T>>  {

    private BaseService<T> baseService;

    public ThreadQuery() {}

    public ThreadQuery(BaseService<T> baseService) {
        this.baseService = baseService;
    }

    @Override
    public List<T> call() throws Exception {
        // 查询数据库
        return baseService.template();
    }

    public BaseService<T> getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService<T> baseService) {
        this.baseService = baseService;
    }
}

