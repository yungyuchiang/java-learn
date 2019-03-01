package com.yungyu.jms.proxy;

import com.yungyu.jms.proxy.impl.DynamicShop;
import com.yungyu.jms.proxy.impl.ShopImpl;
import com.yungyu.jms.proxy.impl.Taobao;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args){
        //静态代理
        IShop carShop = new ShopImpl();
        IShop taobao = new Taobao(carShop);
        taobao.shopping();

        //动态代理
        IShop shop = (IShop) Proxy.newProxyInstance(IShop.class.getClassLoader(), new Class[]{IShop.class}, new DynamicShop<IShop>(carShop));
        shop.shopping();
    }

}
