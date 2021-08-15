package com.huawei.nce.javabase.IdeaOperate;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author Administrator
 * @date 2021/8/8 21:14
 */
public class TestKeyMap extends Father implements FatherInterface, MotherInterface {

    private static String param;

    public static void main(String[] args) {
        // 1.单行注释  ctrl + /
        // 2.多行注释  ctrl +shift +/
        // 3.向下复制一行(duplicate  lines)  ctrl + alt + down
        // 4.删除所选的行. (delete line)  ctrl +D
        // 5.向下移动行(move statement down)  alt  +down
        // 6.向上移动行(move statement up)    alt + up
        // 7.向下开始新的一行(start new line)  shift + enter
        // 8.向上开始新的一行(start new line before current)  ctrl +shift + enter
        // 9.查看某一个类的源码 (class) ctrl + 选中该类.
        // 10.万能解错/生成返回值变量  alt +enter

        // 11.返回上一个编辑的地方(back) alt +left

        // 12.返回下一次编辑的地方(forward) alt +right

        // 13.查看类的继承关系(type hierarchy)  F4

        // 14.格式化代码(reformat code)  ctrl + shift +F

        // 15.提示参数信息(Parameter info) ctrl + alt +/
        ArrayList<Object> objects = Lists.newArrayList();
        objects.add("aaa");
        // 16.选中行,整体后移  tab

        // 17.选中行,整体前移  shift + tab

        // 18.查看类的结构  ctrl + O  (类中包含的方法,属性,子类)

        // 19.修改类名.方法名 ,变量名(rename)  alt + shfit +R
        subMethod();
        // 20.大小写转换(toggle case)  ctrl +shift + U

        // 21.生成getter/ setter /toString(generate)   alt + insert

        // 22.查看文档说明(quick document)     F2

        // 23.收起所有的方法 (collapse all) alt +shift + c

        // 24.展开所有的方法(expand all) alt +shift + X

        // 25.在资源管理器中打开 (show in explorer)   alt + shift + I

        // 26 代码围绕try catch /if else (surround with) alt +shit +z

        // 27.局部变量抽取为成员变量 (introduce field) ctrl +alt +F
        param = "sss";
        System.out.println(param);
        // 28.在当前文件中查找/替换 (Ctrl +F)

        // 29.全局中查找/替换  (ctrl +H)

        // 30.根据文件名称查找 (double shift)

        // 31.查看类的继承结构图 (show uml diagram) ctrl +Alt +U

        // 32.查看方法的多层层次结构.(method hierarchy) Ctrl + alt +H

        // 33.添加到收藏(add to favorite) alt +shift +F

        // 34.抽取方法(extract method) alt +shift +M

        // 35.打开最近修改的文件(recently changed files) ctrl +E

        // 36.关闭当前的所有的代码文件(close all) (ctrl +shift +w)

        // 37. 快速搜索类中的错误 (next highlighted error) ctrl +shit +Q

        // 38.选择要粘贴的内容 (paste from history) ctrl +shirift +V
    }

    /**
     * eat
     */
    @Override
    public void eat() {
        System.out.println("eat");
        subMethod();
    }

    /**
     * sleep
     */
    @Override
    public void sleep() {
        System.out.println("sleeep");
        subMethod();
    }

    public static void subMethod() {
        String bbbb = "abc";
        System.out.println("study" + bbbb);
    }
}
