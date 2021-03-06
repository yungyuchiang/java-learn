package com.yungyu.jvm;

import java.io.*;
import java.net.URL;

public class NetSystemClassLoader extends ClassLoader{

    private String rootUrl;

    public NetSystemClassLoader(String rootUrl){
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //return super.findClass(name);
        //查找class, 首先在父级加载器中找
        Class<?> c = null;
        try{
            c = Class.forName(name);
        }catch (ClassNotFoundException e){

        }
        if(c == null){
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            }catch (ClassNotFoundException e){

            }
            if(c == null){
                //构建自定义的加载器加载
                byte[] classData = getClassData(name);
                if(classData != null){
                    c = defineClass(name, classData, 0, classData.length);
                }else{
                    throw new ClassNotFoundException();
                }
            }
        }


        return c;
    }

    private byte[] getClassData(String className){
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try{
            String filePath = this.rootUrl + File.separator + className.replace('.', '/') + ".class";

            URL url = new URL(filePath);
            is = url.openStream();
            bos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int temp;
            while((temp = is.read(buffer)) != -1){
                bos.write(buffer, 0, temp);
            }
            bos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bos.toByteArray();
    }
}
