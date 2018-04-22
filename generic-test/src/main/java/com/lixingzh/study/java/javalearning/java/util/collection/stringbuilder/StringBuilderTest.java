package com.lixingzh.study.java.javalearning.java.util.collection.stringbuilder;

import java.util.Arrays;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("test");
		System.out.println(sb.toString());
		sb.setLength(0);
		System.out.println(sb.toString());
		sb.append("test");
		System.out.println(sb.toString());
		
		StringBuilder sb2 = new StringBuilder(12);
		sb2.append("aaa-bbb-rrrr");
		System.out.println(sb2.capacity());
		System.out.println(sb2.length());
	}
}
