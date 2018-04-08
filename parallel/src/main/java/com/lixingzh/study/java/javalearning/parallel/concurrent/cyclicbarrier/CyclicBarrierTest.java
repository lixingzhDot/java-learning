package com.lixingzh.study.java.javalearning.parallel.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		final CyclicBarrier cb = new CyclicBarrier(3);
		//final CyclicBarrier cb2 = new CyclicBarrier(3);
		//final CyclicBarrier cb3 = new CyclicBarrier(3);
		for(int i = 0; i < 3; ++i) {
			service.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("Thread " + Thread.currentThread().getName() + " is arriving destination 1"
										   + ", where current have " + (cb.getNumberWaiting() + 1) );
						
						cb.await();
						
						//System.out.println("barrier 1 have " + cb1.getNumberWaiting());
						System.out.println("Thread " + Thread.currentThread().getName() + " is arriving destination 2"
								   + ", where current have " + (cb.getNumberWaiting() + 1) );	
						cb.await();
						
						//System.out.println("barrier 2 have " + cb2.getNumberWaiting());
						System.out.println("Thread " + Thread.currentThread().getName() + " is arriving destination 3"
								   + ", where current have " + (cb.getNumberWaiting() + 1) );	
						cb.await();
						
						//System.out.println("barrier 3 have " + cb3.getNumberWaiting());
						System.out.println(Thread.currentThread().getName() + " Arrived");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		}
		service.shutdown();
	}
}
