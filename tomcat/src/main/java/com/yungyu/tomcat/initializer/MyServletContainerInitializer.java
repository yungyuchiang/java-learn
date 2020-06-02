package com.yungyu.tomcat.initializer;

import com.yungyu.tomcat.servlet.MyServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @Author: j1280
 * @Date: Create in 2020/2/26
 * @Description:
 * @Modified:
 */
@HandlesTypes(value = {WebInitializer.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        if (null != classes && !classes.isEmpty()) {
            for (Class<?> cls : classes) {
                try {
                    WebInitializer initializer = (WebInitializer) cls.newInstance();
                    initializer.onStartUp(servletContext);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
