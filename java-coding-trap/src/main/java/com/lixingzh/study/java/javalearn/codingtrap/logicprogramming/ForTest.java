package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

public class ForTest {
	public static void main(String[] args) {
		int j = 0;
		int j2 = 0;
		for(int i = 0; i < 100; ++i) {
			j = j++;
			j2 = ++j2;
		}
		
		System.out.println(j + " , " + j2);
	}
}
