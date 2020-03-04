package com.yungyu.jms.proxy.impl;

import com.yungyu.jms.proxy.IShop;

public class Taobao implements IShop {

    private IShop iShop;

    public Taobao(IShop iShop){
        this.iShop = iShop;
    }

    public void shopping() {
        System.out.println("打开淘宝");
        this.iShop.shopping();
        System.out.println("买了，剁手...");
    }

}
