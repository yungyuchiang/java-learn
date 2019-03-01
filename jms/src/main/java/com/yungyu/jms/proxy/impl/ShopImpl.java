package com.yungyu.jms.proxy.impl;

import com.yungyu.jms.annotation.ColorEnum;
import com.yungyu.jms.annotation.MyAnnotation;
import com.yungyu.jms.proxy.IShop;

@MyAnnotation(color = "red", colorEnum = {ColorEnum.BLUE, ColorEnum.RED})
public class ShopImpl implements IShop {

    public void shopping() {
        System.out.println("购物中，道奇......");
    }

}
