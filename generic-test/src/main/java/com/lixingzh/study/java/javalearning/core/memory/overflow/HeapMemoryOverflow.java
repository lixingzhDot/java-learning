package com.lixingzh.study.java.javalearning.core.memory.overflow;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试内容：堆溢出
 *
 * 虚拟机参数：-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapMemoryOverflow {
    public static void main(String[] args)
    {
        List<HeapMemoryOverflow> list = new ArrayList<HeapMemoryOverflow>();
        while (true)
        {
            list.add(new HeapMemoryOverflow());
        }
    }
}
