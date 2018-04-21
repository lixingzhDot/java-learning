package com.lixingzh.study.java.javalearning.parallel.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWReentrantLockTest {
	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		
		for(int i = 0; i < 3; ++i) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						q3.get();
					}
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					q3.put(new Random().nextInt(10000));
				}
			}).start();
		}
	}
	
	static class Queue3 {
		private Object data = null;
		private ReadWriteLock rwl = new ReentrantReadWriteLock();
		
		void get() {
			rwl.readLock().lock();
			System.out.println(Thread.currentThread().getName() + " READY to read ");

			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			System.out.println(Thread.currentThread().getName() + " read " + data);

			rwl.readLock().unlock();
		}
		
		void put(int i) {
			rwl.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + " READY to write ");
			
			try {
				Thread.sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			data = Integer.valueOf(i);			
			System.out.println(Thread.currentThread().getName() + " write " + data);

			rwl.writeLock().unlock();
		}
	}
}

