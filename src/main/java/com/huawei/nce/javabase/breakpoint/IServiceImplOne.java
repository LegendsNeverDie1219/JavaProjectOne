package com.huawei.nce.breakpoint;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/5/25 23:10
 */
public class IServiceImplOne implements IService{

    @Override
    public void execute() {
        System.out.println("this is impl class one :execute");
    }
}
