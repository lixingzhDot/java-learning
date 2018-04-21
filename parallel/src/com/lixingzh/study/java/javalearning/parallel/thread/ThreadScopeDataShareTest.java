package com.lixingzh.study.java.javalearning.parallel.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// method 1 to specific data
public class ThreadScopeDataShareTest {
	private static int data = 0;
	// method 1 to specific data
	private static Map<Thread, Integer> threadData = new HashMap<>();
	public static void main(String[] args) {
		for(int i = 0; i < 2; ++i) {
			new Thread(new Runnable() {
				public void run() {
					data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + "has put data: " + data);
					threadData.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A {
		public void get() {
			System.out.println("A - " + Thread.currentThread().getName() + " get data: " + 
							   threadData.get(Thread.currentThread()));
		}
	}
	
	static class B {
		public void get() {
			System.out.println("B - " + Thread.currentThread().getName() + " get data: " + 
							   threadData.get(Thread.currentThread()));
		}
	}
}
