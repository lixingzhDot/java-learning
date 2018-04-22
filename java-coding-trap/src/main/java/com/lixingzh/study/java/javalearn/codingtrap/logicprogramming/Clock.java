package com.lixingzh.study.java.javalearn.codingtrap.logicprogramming;

public class Clock {
	public static void main(String[] args) {
		int minutes = 0;
		int minutes2 = 0;
		for(int ms = 0;  ms < 60 * 60 * 1000; ms++) {
			if(ms % 60 *1000 == 0) {
				minutes++;
			}
			
			if(ms % (60 *1000) == 0) {
				minutes2++;
			}
		}
		
		System.out.println(minutes);
		System.out.println(minutes2);

	}
}
