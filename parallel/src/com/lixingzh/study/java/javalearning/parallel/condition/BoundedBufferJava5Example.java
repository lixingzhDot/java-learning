package com.lixingzh.study.java.javalearning.parallel.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBufferJava5Example {
	final Lock lock = new ReentrantLock();
	Condition notEmpty = lock.newCondition();
	Condition notFull = lock.newCondition();
	
	final Object[] items = new Object[10];
	int putptr = 0, takeptr = 0, count = 0;
	
	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while(count == items.length) {
				notFull.await();
			}
			
			items[putptr] = x;
			if(++putptr == items.length) putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public Object get() throws InterruptedException {
		lock.lock();
		try {
			while(count == 0) {
				notEmpty.await();
			}
			
			Object x = items[takeptr];
			if(++takeptr == items.length) takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}
