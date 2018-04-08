package com.lixingzh.study.java.javalearning.parallel.threadpool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ThreadPoolTest object = new ThreadPoolTest();
		//object.fixedThreadPoolTest();
		//object.cacheddThreadPoolTest();
		//object.singleThreadPoolTest();
		//object.scheduleThreadPoolTest();
		object.callableAndFuture();
		//object.completionServiceTest();
	}
	
	void fixedThreadPoolTest() {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 10; ++i) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						} catch (Exception ex) {
							//ex.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " loop of "+ i + " for task of " + task);
					}
				}
			});
		}
		System.out.println("all tasks are submitted");
		//threadPool.shutdown(); // this will shutdown when all submitted work are down.
		threadPool.shutdownNow();
	}
	
	void cacheddThreadPoolTest() {
		// cached pool 会 flexibly 建立或删除 Thead
		ExecutorService threadPool = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 10; ++i) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						} catch (Exception ex) {
							//ex.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " loop of "+ i + " for task of " + task);
					}
				}
			});
		}
		System.out.println("all tasks are submitted");
		//threadPool.shutdown(); // this will shutdown when all submitted work are down.
		threadPool.shutdownNow();
	}
	
	void singleThreadPoolTest() {
		// cached pool 只会保留一个 Thread，提交的任务会排队处理
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i = 0; i < 10; ++i) {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						} catch (Exception ex) {
							//ex.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " loop of "+ i + " for task of " + task);
					}
				}
			});
		}
		System.out.println("all tasks are submitted");
		//threadPool.shutdown(); // this will shutdown when all submitted work are down.
		threadPool.shutdownNow();
	}
	
	void scheduleThreadPoolTest() {
		// cached pool 只会保留一个 Thread，提交的任务会排队处理
		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
		threadPool.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 1, TimeUnit.SECONDS);
		threadPool.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
			}
		}, 1, 2, TimeUnit.SECONDS);
		
		threadPool.shutdown();
	}
	
	void callableAndFuture() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} 
/*				catch (InterruptedException e) {			
					// executor.shutdownNow(); could be CATCHED here, if cancel happend
					System.out.println("thread call, shutdown");
				}*/
				catch (CancellationException e) {
					// future.cancel(true); NOT catched here, if cancel happend
					System.out.println("inside thread call, cancel");
				}
				return 10;
			}
		});
		
		try {
			future.cancel(true);
			//executor.shutdownNow();
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// executor.shutdownNow(); 
			// if callale doen't catch, then here could catch it
			//e.printStackTrace();
			System.out.println("outside thread call, shutdown");
		} catch (CancellationException e) {
			// future.cancel(true); CATCHED here, if cancel happend
			System.out.println("out thread call, cancel");
		}
		executor.shutdown();
	}
	void completionServiceTest() {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		CompletionService<Integer> service = new ExecutorCompletionService<Integer>(threadPool);
		
		for(int i = 0; i <10; ++i) {
			final int task = i;
			service.submit( new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(1000));
					return task;
				}
			});
		}
		
		for(int i = 0; i< 10; ++i) {
			try {
				System.out.println(service.take().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
