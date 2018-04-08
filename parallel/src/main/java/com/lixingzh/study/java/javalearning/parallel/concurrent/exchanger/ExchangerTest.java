package com.lixingzh.study.java.javalearning.parallel.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
	public static void main(String[] args) {
		final Exchanger<Integer> exchanger = new Exchanger<>();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Integer item = -1;
				System.out.println(Thread.currentThread().getName() + " want to exchange " + item);
				
				try {
					Thread.sleep((long)Math.random() * 10000);
					Integer ret = exchanger.exchange(item);
					System.out.println(Thread.currentThread().getName() + " get trade " + ret);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				Integer item = 1;
				System.out.println(Thread.currentThread().getName() + " want to exchange " + item);
				
				try {
					Thread.sleep((long)Math.random() * 10000);
					Integer ret = exchanger.exchange(item);
					System.out.println(Thread.currentThread().getName() + " get trade " + ret);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
