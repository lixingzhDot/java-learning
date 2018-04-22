package com.lixingzh.study.java.javalearning.core.gc;

/**
 * 引用计数法
 * Java中没有使用这种算法，因为这种算法很难解决对象之间相互引用的情况。
 * 
 * 虚拟机参数：-verbose:gc
 */
public class ReferenceCountingGC {
    private Object instance = null;
    private static final int _1MB = 1024 * 1024;
 
    /** 这个成员属性唯一的作用就是占用一点内存 */
    private byte[] bigSize = new byte[2 * _1MB];
 
    public static void main(String[] args)
    {
        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();
        
        //Java中没有使用这种算法，因为这种算法很难解决对象之间相互引用的情况。
        objectA.instance = objectB;
        objectB.instance = objectA;
        
        System.gc();

        objectA = null;
        objectB = null;
        
        System.gc();

    }
}
