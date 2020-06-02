package com.yungyu.tomcat.test;

import com.yungyu.tomcat.initializer.WebInitializer;
import com.yungyu.tomcat.servlet.MyServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class TestWebInitializer implements WebInitializer {

    public void onStartUp(ServletContext ctx) throws ServletException {
        System.out.println("test web initializer...");
        ServletRegistration.Dynamic myServlet = ctx.addServlet("myServlet", new MyServlet());
        myServlet.setLoadOnStartup(1);
        // ctx.setInitParameter("")
    }

}
