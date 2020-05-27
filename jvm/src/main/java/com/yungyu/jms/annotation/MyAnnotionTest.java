package com.yungyu.jms.annotation;

import java.util.Arrays;

public class MyAnnotionTest {

    public static void main(String[] args){
        MyAnnotationUse use = new MyAnnotationUse();
        Class cls = use.getClass();
        if(cls.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = (MyAnnotation) cls.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation);
            System.out.println(myAnnotation.color());
            System.out.println(Arrays.toString(myAnnotation.colorEnum()));
        }
    }

}
