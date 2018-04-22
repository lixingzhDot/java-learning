package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

public class UnicodeTest {
	public static void main(String[] args) {
		//\u0022 是双引号的unicode 转义字符
		System.out.println("a\u0022.length() + \u0022b");
		System.out.println("a\u0022.length() + \u0022b".length());
	}
}
