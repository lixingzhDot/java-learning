package com.lixingzh.study.java.javalearn.codingtrap;

import java.math.BigDecimal;

public class DoubleMinus {
	public static void main(String[] args) {
		System.out.println(2.0 - 1.1);
		
		BigDecimal number1 = new BigDecimal("2.0");
		BigDecimal number2 = new BigDecimal("1.1");
		
		System.out.println(number1.subtract(number2));
		System.out.printf("%.1f\n", 2.0 - 1.1);
	}
}
