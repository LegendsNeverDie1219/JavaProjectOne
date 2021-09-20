package com.huawei.nce.javabase.day08.objectoriented;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/9/19 17:06
 */
public class Student {
    /**
     * 学号
     */
    private int number;
    /**
     * 年级
     */
    private int state;
    /**
     * 分数
     */
    private int score;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", state=" + state +
                ", score=" + score +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }
}
