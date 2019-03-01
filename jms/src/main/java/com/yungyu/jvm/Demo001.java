package com.yungyu.jvm;

public class Demo001 {

    public static void main(String[] args){
        FileSystemClassLoader loader = new FileSystemClassLoader("E:/Study/Java/MyJava");
        NetSystemClassLoader netLoader = new NetSystemClassLoader("http://localhost:8089/vscode/");
        try {
            Class<?> c = loader.findClass("com.yungyu.test.HelloWorld");
            System.out.println(c.getName());
            System.out.println(c.getClassLoader());

            Class<?> netc = netLoader.findClass("com.yungyu.test.HelloWorld");
            System.out.println(netc.getName());
            System.out.println(netc.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
