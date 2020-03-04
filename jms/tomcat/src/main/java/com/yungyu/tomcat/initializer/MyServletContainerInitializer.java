package com.yungyu.tomcat.initializer;

import com.yungyu.tomcat.servlet.MyServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * @Author: j1280
 * @Date: Create in 2020/2/26
 * @Description:
 * @Modified:
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("开始启动了");

        ServletRegistration.Dynamic myServlet = servletContext.addServlet("MyServlet", new MyServlet());
        myServlet.addMapping("/my");

    }

}
