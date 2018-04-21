package com.lixingzh.study.java.javalearning.parallel.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {
	// method 1 to specific data
	static ThreadLocal<Integer> localX = new ThreadLocal();
	public static void main(String[] args) {
		for(int i = 0; i < 2; ++i) {
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + "has put data: " + data);
					localX.set(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A {
		public void get() {
			System.out.println("A - " + Thread.currentThread().getName() + " get data: " + 
					localX.get());
		}
	}
	
	static class B {
		public void get() {
			System.out.println("B - " + Thread.currentThread().getName() + " get data: " + 
					localX.get());
		}
	}
}

class MyThreadScopeData {
	private static ThreadLocal<MyThreadScopeData> local = new ThreadLocal<>();
	public static synchronized MyThreadScopeData getInstance() {
		MyThreadScopeData instance = local.get();
		if(null == instance) {
			instance = new MyThreadScopeData();
			local.set(instance);
		}
		return instance;
	}
	
	private MyThreadScopeData() {}

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
