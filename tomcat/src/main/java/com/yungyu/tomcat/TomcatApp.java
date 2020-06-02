package com.yungyu.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @Author: j1280
 * @Date: Create in 2020/2/26
 * @Description:
 * @Modified:
 */
public class TomcatApp {

    public static void main(String[] args) throws LifecycleException, InterruptedException {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.setPort(8989);
        // tomcat.getHost().setAppBase(System.getProperty("user.dir") + "/tomcat/web");
        // tomcat.addWebapp("/web", System.getProperty("user.dir") + "/tomcat/web/");
        tomcat.addWebapp("", System.getProperty("user.dir") + "/tomcat/web");
        tomcat.start();
        tomcat.getServer().await();
    }

}
