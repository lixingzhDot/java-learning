package com.lixingzh.study.java.javalearning.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TraditionalTImerTest {
	public static void main(String[] args) {

		
		// delay + period
//		new Timer().schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("Alarming");
//			}
//		}, 10, 30);
		
		class MyTimerTask extends TimerTask {
			public MyTimerTask() {
				super();
			}
			
			@Override
			public void run() {
				System.out.println("Alarming");
				new Timer().schedule(new MyTimerTask(), 2000);
			}
		}
		
		new Timer().schedule(new MyTimerTask(), 2000);
		
		while(true) {
			System.out.println(new Date().getSeconds());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
