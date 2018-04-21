package com.lixingzh.study.java.javalearning.thread;

public class ThreadCommunication {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			int i = 10;
			public void run() {
				synchronized (ThreadCommunication.class) {				
					while(i > 0) {
						System.out.println("sub thread loop:" + i--);
					}				
				}
			}
		}).start();
		
		int i = 10;
		int j = 100;
		while(j > 0) {
			synchronized (ThreadCommunication.class) {	
				while(i > 0) {
					System.out.println("main thread loop:" + i--);
				}				
			}
			--j;
		}
	}
	
	/**
	 * 注意，同步的信息要在服务的类内部实现。而不是在Thread中实现。
	 * 比如 main 和 sub function在Business 内部实现同步/communication
	 * @author lixing.zhang
	 *
	 */
	class Business {
		private boolean bSub = true;
		public synchronized void sub(int i) {
			if(!bSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int j = 1; j <= 100; j++) {
				System.out.println("sub thread sequence of " + j + " loop of " + i);
			}
			bSub = false;
			this.notify();
		}
		
		public synchronized void main(int i) {
			if(bSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int j = 1; j <= 100; j++) {
				System.out.println("sub thread sequence of " + j + " loop of " + i);
			}
			bSub = true;
			this.notify();
		}
	}
}
