package com.lixingzh.study.java.javalearning.thread;

public class ThreadSynchronization {

	/**
	 * 多线程 访问 单一 对象，会产生 race condition
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Outputter outputter = new Outputter();
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputter.output2("abcdfg");
				}
			}
		}).start();
		
//		new Thread(new Runnable() {
//			public void run() {
//				while(true) {
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					outputter.output1("hijklmn");
//				}
//			}
//		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputter.output3("hijklmn");
				}
			}
		}).start();
	}
	
	/**
	 * synchronized 的使用方法。
	 * 注 output1 是 使用“this” 作为key。与output2 和 output3 不样。
	 * 会产生race conditon
	 * 
	 * @author lixing.zhang
	 */
	private static class Outputter {
		// synchronized on function, also use "this" as key
		public synchronized void output1(String name) {
			int len = name.length();
			for(int i = 0; i < len; ++i) {
				System.out.print(name.charAt(i));
			}

			System.out.println();
		}
	
		public void output2(String name) {
			int len = name.length();
			//synchronized (this) {
			synchronized (Outputter.class) {
				for(int i = 0; i < len; ++i) {
					System.out.print(name.charAt(i));
				}
			}

			System.out.println();
		}
		
		// static *.class 当做 key
		public static synchronized void output3(String name) {
			int len = name.length();
			//synchronized (this) {
				for(int i = 0; i < len; ++i) {
					System.out.print(name.charAt(i));
				}
			//}

			System.out.println();
		}
	}
}
