package com.lixingzh.study.java.javalearning.parallel.concurrent.arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Same functionalities as com.lixingzh.study.java.javalearning.parallel.concurrent.BoundedBuffer
 */
public class ArrayBlockingQueueTest {
	public static void main(String[] args) {
		final ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue (3);
		
		for(int i = 0; i < 2; ++i) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							System.out.println(Thread.currentThread().getName() + " take " + abq.take() + " from Q");
						}
					} catch (InterruptedException e) {
					}
				}
			}).start();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(2000);
						int i = new Random().nextInt();
						abq.put(i);
						System.out.println(Thread.currentThread().getName() + " put " + i + " from Q");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
