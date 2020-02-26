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
        tomcat.setPort(8989);
        tomcat.setBaseDir("G:\\IDEAProjects\\java-learn\\jms\\tomcat\\log");
        tomcat.start();
        tomcat.getServer().await();
    }

}
