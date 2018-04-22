package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

public class ReturnValue {
	public static void main(String[] args) {
		System.out.println(decision());
	}
	
	// finally will catch even try wants to return
	private static boolean decision() {
		try {
			return true;
		} finally {
			System.out.println("cought by finally");
			return false;
		}
	}
}
