package com.yungyu.tomcat.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface WebInitializer {

    void onStartUp(ServletContext ctx) throws ServletException;

}
