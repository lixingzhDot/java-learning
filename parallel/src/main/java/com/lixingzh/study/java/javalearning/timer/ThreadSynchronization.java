package com.lixingzh.study.java.javalearning.timer;

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
					outputter.output("abcdfg");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputter.output("hijklmn");
				}
			}
		}).start();
	}
	
	private static class Outputter {
		public void output(String name) {
			int len = name.length();
			for(int i = 0; i < len; ++i) {
				System.out.println(name.charAt(i));
			}
			
			System.out.println();
		}
	}
}
