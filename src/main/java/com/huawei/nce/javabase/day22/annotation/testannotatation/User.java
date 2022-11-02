package com.huawei.nce.javabase.day22.annotation.testannotatation;

/**
 * TODO
 *
 * @author Administrator
 * @date 2022/10/12 15:03
 */
// 将自定义的注解加在用户上,实现一个表的映射
@Table(value = "user_table")
public class User {

    @UserFiled(name = "user_id",type = "int",length = 8)
    private int userId;

    @UserFiled(name = "user_name",type = "varchar",length = 16)
    private String userName;

    @UserFiled(name = "password",type = "varchar",length = 16)
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
