package com.lixingzh.study.java.javalearning.parallel.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class semaphoreTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sem = new Semaphore(3);
		for(int i = 0; i < 10; ++i) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						sem.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Thread " + Thread.currentThread().getName() + " entered, currently "
							+ "there are " + (3 - sem.availablePermits()) + "aquired");
					
					try {
						Thread.sleep((long) Math.random()*10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("Thread " + Thread.currentThread().getName() + " is leaving");
					sem.release();
					System.out.println("Thread" + Thread.currentThread().getName() + "has Left " + 
						 "there are " + (3 - sem.availablePermits() + "aquired"));
				}
			};
			
			service.execute(runnable);
		}
	}
}
