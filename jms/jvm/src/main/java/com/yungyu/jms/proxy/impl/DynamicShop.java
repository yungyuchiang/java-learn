package com.yungyu.jms.proxy.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicShop<T> implements InvocationHandler {

    private T target;

    public DynamicShop(T target){
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始了。。。");
        Class cls = target.getClass();
        //if(cls.isAnnotation()){
        Annotation[] annotations = cls.getAnnotations();
        for(Annotation annotation : annotations){
            Field field = annotation.getClass().getDeclaredField("memberValues");
            System.out.println(field.getName());
            System.out.println();
        }
        //}

        Object obj = method.invoke(target, args);
        System.out.println("动态代理结束了。。。");
        return obj;
    }

}
