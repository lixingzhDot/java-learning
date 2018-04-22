package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

public class WhileTest {
	public static final int END = Integer.MAX_VALUE;
	public static final int START = END - 100;
	public static void main(String[] args) {
		int count = 0;
		
		// 问题在于：当i = END 后，还会自增一次。之后，由于溢出，i变成了负数。可以一直自增下去。
		//for(int i = START; i <= END; ++i) {
		for(int i = START; i < END; ++i) {
			count++;
		}
		
		System.out.println(count);
	}
}
