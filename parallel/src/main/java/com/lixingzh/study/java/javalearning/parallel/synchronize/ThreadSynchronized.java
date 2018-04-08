package com.lixingzh.study.java.javalearning.parallel.synchronize;

public class ThreadSynchronized {
	public static void main(String[] args) {
		//静态方法中不能用内部类的实例对象，因为内部类可以访问外部类的成员变量。 
		//但是static function不需要外部类的实例
		//final Outputter outputter = new Outputter();
		
//		final Outputter outputter
//		new Thread(new Runnable() {
//			
//			public void run() {
//				while(true) {
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
		new ThreadSynchronized().init();
	}
	
	private void init() {
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
		public void output(String name) {
			int len = name.length();
			// 这个不work是因为每个thread 的 name 是不一样的object 
			// synchronized (name)
			synchronized(this)
			{
				for(int i = 0; i < len; ++i) {
					System.out.print(name.charAt(i));
				}
			}
			System.out.println();
		}
		
		// function level 的synchronized 也用的是 ‘this’
		public synchronized void output2(String name) {
			int len = name.length();
			for(int i = 0; i < len; ++i) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
		
		// synchronized 在 静态 function 用的是 Outputter.class
		static public synchronized void output3(String name) {
			int len = name.length();
			for(int i = 0; i < len; ++i) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
