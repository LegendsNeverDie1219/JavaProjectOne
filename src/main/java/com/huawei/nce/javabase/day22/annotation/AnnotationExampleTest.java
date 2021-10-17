package com.huawei.nce.javabase.day22.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 文档注释
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/10/17 12:21
 */
public class AnnotationExampleTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int a = 10;
        System.out.println("javaDocTest");
    }

    @Deprecated
    public void print() {
        System.out.println("过时的方法");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

@WebServlet("/login")
class LoginServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    /**
     * <servlet>
     * <servlet-name>LoginServlet</servlet-name>
     * <servlet-class>com.servlet.LoginServlet</servlet-class>
     * </servlet>
     * <servlet-mapping>
     * <servlet-name>LoginServlet</servlet-name>
     * <url-pattern>/login</url-pattern>
     * </servlet-mapping>
     */
}
