package com.lixingzh.study.java.javalearning.parallel.communication;

/**
 * 子线程循环10次，接着主线程循环100，接着回到子线程循环10次，接着再回到主线程循环100， 如此循环50次。
 */
public class ThreadCommunication {
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				for(int i = 1; i <= 50; ++i) {
					business.sub(i);
				}
			}
		}).start();
		
		for(int i = 1; i <= 50; ++i) {
			business.main(i);
		}
	}
	
	static class Business {
		private boolean bShouldSub = true;
		public synchronized void sub(int i) {
			while(!bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 0; j < 10; j++) {
				System.out.println("sub thread seq of " + j + ", loop of " + i);
			}
			bShouldSub = false;
			this.notify();
		}
		
		public synchronized void main(int i) {
			while(bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 0; j < 100; j++) {
				System.out.println("main thread seq of " + j + ", loop of " + i);
			}
			bShouldSub = true;
			this.notify();
		}
	}
}
