package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

public class Swap {
	public static void main(String[] args) {
		int x = 1984;
		int y = 2001;
		x^=y^=x^=y;
		System.out.println("x= " + x + ";y= " + y);
		
		x = 1984;
		y = 2001;
		//x^=(y^=(x^=y));
		y = (x^= (y^=x)) ^ y;
		System.out.println("x= " + x + "; y= " + y);
	}
}
