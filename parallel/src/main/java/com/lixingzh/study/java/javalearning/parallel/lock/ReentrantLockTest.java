package com.lixingzh.study.java.javalearning.parallel.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.lixingzh.study.java.javalearning.parallel.synchronize.ThreadSynchronized;

public class ReentrantLockTest {
	public static void main(String[] args) {
		//静态方法中不能用内部类的实例对象，因为内部类可以访问外部类的成员变量。 
		//但是static function不需要外部类的实例
		//final Outputter outputter = new Outputter();
		
//			final Outputter outputter
//			new Thread(new Runnable() {
//				
//				public void run() {
//					while(true) {
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			}).start();
		new ReentrantLockTest().ReentrantLockTest();
	}
	
	private void ReentrantLockTest() {
		final Outputter outputter = new Outputter();
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputter.output("Lixing Zhang");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputter.output2("Lei Zhu");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputter.output3("Lei Zhang");
				}
			}
		}).start();
	}
	
	static class Outputter{
		static Lock lock = new ReentrantLock();
		public void output(String name) {
			int len = name.length();
			lock.lock();
			try
			{
				for(int i = 0; i < len; ++i) {
					System.out.print(name.charAt(i));
				}			
				System.out.println();
			}
			finally {
				lock.unlock();
			}
		}
		
		public void output2(String name) {
			int len = name.length();
			lock.lock();
			try
			{
				for(int i = 0; i < len; ++i) {
					System.out.print(name.charAt(i));
				}			
				System.out.println();
			}
			finally {
				lock.unlock();
			}
		}
		
		// synchronized 在 静态 function 用的是 Outputter.class
		static public void output3(String name) {
			int len = name.length();
			lock.lock();
			try
			{
				for(int i = 0; i < len; ++i) {
					System.out.print(name.charAt(i));
				}			
				System.out.println();
			}
			finally {
				lock.unlock();
			}
		}
	}
}

