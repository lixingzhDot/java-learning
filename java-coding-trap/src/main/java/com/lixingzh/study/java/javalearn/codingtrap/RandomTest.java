package com.lixingzh.study.java.javalearn.codingtrap;

import java.util.Random;

public class RandomTest {
	private static Random rnd = new Random();
	public static void main(String[] args) {
		test();
		correct();
	}
	
	private static void test() {
		StringBuffer word = null;
		switch(rnd.nextInt(2)) {
			// char is treated as integer
			case 1: word = new StringBuffer('P');
			case 2: word = new StringBuffer("G");
			default: word = new StringBuffer("M");
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);
	}
	
	private static void correct() {
		StringBuffer word = new StringBuffer();
		switch(rnd.nextInt(3)) {
			case 1: word.append('P'); break;
			case 2: word.append("G"); break;
			default: word.append("M"); break;
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);
	}
}
