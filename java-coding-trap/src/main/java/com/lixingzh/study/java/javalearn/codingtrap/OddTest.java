package com.lixingzh.study.java.javalearn.codingtrap;

public class OddTest {

	/**
	 * 
	 * @param i Note, it is an interger, which means it could be negtive number
	 * @return
	 */
	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}
	public static void main(String[] args) {
		System.out.println(isOdd(1));
		System.out.println(isOdd(2));
		System.out.println(isOdd(3));
	}

}
