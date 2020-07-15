package com.yungyu.map;

import java.util.HashMap;

public class hashmapdemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        int initialCapacity = 18;
        System.out.println(tableSizeFor(158));
//        System.out.println(constructArrIndex("aafcvzx", initialCapacity));
//        System.out.println(constructArrIndex("absdfe", initialCapacity));
//        System.out.println(constructArrIndex("abc", initialCapacity));
//        System.out.println(constructArrIndex("afd", initialCapacity));
//        System.out.println(constructArrIndex("awer", initialCapacity));
//        System.out.println(constructArrIndex("ger", initialCapacity));
//        System.out.println(constructArrIndex("sdfe", initialCapacity));
//        System.out.println(constructArrIndex("dfgabc", initialCapacity));
//        System.out.println(constructArrIndex("aefd", initialCapacity));
//        System.out.println(constructArrIndex("werawer", initialCapacity));
    }

    static int constructArrIndex (Object object, Integer initialCapacity) {
        if (null == initialCapacity)
            initialCapacity = 1 << 4;
        return object.hashCode() & (initialCapacity - 1);
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;;
        System.out.println(n + " ---- " + Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(n + " ---- " + Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(n + " ---- " + Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(n + " ---- " + Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(n + " ---- " + Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(n + " ---- " + Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
