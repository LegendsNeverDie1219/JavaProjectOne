package com.huawei.nce.javabase.IdeaOperate;

import com.huawei.nce.pojo.Animal;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/7/31 18:06
 */
public class Plugins {
    public static void main(String[] args) {
        // 1.translation plugin
        ArrayList<Object> objects = new ArrayList<>();
        // 2.generateAllSetter plugin
        Animal animal = new Animal();
        animal.setName("");
        animal.setAge(0);
        animal.setType(0);
        // 3.GsonFormatPlus
     /*   [{"name":"name0","age":0},{"name":"name1","age":5},{"name":"name2","age":10},{"name":"name3","age":15},{"name":"name4","age":20},{"name":"name5","age":25},{"name":"name6","age":30},{"name":"name7","age":35},{"name":"name8","age":40},{"name":"name9","age":45}]*/
        // 4.rainbow brackets
        if(1==1) {
            System.out.println("-----------");
        } else {
            if (2==2) {
            }
        }
        // 5.Rearrange Code

        // 6.Material Theme UI

        // 7.Sequence Diagram
        // 8.maven helper
        // 9.Codota
        //
    }
}
