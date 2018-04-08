package com.lixingzh.study.java.javalearning.parallel.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		final CountDownLatch cdl = new CountDownLatch(3);
		//final CyclicBarrier cb2 = new CyclicBarrier(3);
		//final CyclicBarrier cb3 = new CyclicBarrier(3);
		for(int i = 0; i < 3; ++i) {
			service.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						System.out.println("Thread " + Thread.currentThread().getName() + " is going to beready"
										   + ", where count is " + (cdl.getCount()) );
						Thread.sleep((long)Math.random()*10000);
						cdl.countDown();
						
						System.out.println("Thread " + Thread.currentThread().getName() + " is READY"
								   + ", where count is " + (cdl.getCount()) );
						Thread.sleep((long)Math.random()*100000);
						System.out.println(Thread.currentThread().getName() + " Finishes");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		}
		
		try {
			cdl.await();
			System.out.println("current cdl count: " + cdl.getCount());
			System.out.println("Continue Processing");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
	}
}
