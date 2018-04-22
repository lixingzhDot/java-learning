package com.lixingzh.study.java.javalearning.java.primitive;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String a = "test1-test2";
		
		// indexOf
		System.out.println(a.indexOf('s') );
		
		
		String[] as = a.split("-");
		
		// swap in array
		String tmp = as[0];
		as[0] = as[1];
		as[1] = tmp;
		System.out.println(Arrays.toString(as));
	}

}
