package com.huawei.nce.javabase.day17.team.domain;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/10/3 23:27
 */
public class Status {
    private final String NAME;
    /**
     * 空闲
     */
    public static final Status FREE = new Status("FREE");
    /**
     * 已加入开发团队
     */
    public static final Status BUSY = new Status("BUSY");
    /**
     * 正在度假
     */
    public static final Status VOCATION = new Status("VOCATION");


    public Status(String value) {
        this.NAME = value;
    }

    public String getNAME() {
        return NAME;
    }
}
