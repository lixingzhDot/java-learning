package com.lixingzh.study.java.javalearn.codingtrap;

public class LongDivision {
	public static void main(String[] args) {
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		
		System.out.println(MICROS_PER_DAY + " / " + MILLIS_PER_DAY + " = " + MICROS_PER_DAY / MILLIS_PER_DAY);
		
		final long MICROS_PER_DAY_L = 24L * 60 * 60 * 1000 * 1000;
		// final long MICROS_PER_DAY_L = (long)24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY_L = 24L * 60 * 60 * 1000;
		
		System.out.println(MICROS_PER_DAY_L / MILLIS_PER_DAY_L);

	}
}
