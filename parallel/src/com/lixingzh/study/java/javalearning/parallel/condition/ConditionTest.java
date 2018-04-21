package com.lixingzh.study.java.javalearning.parallel.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
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
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		public synchronized void sub(int i) {
			while(!bShouldSub) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 0; j < 10; j++) {
				System.out.println("sub thread seq of " + j + ", loop of " + i);
			}
			bShouldSub = false;
			condition.signal();
		}
		
		public synchronized void main(int i) {
			while(bShouldSub) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 0; j < 100; j++) {
				System.out.println("main thread seq of " + j + ", loop of " + i);
			}
			bShouldSub = true;
			condition.signal();
		}
	}
}