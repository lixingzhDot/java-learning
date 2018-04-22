package com.lixingzh.study.java.javalearning.executor;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 1. ExecutorService.shutdown will shutdown all the threads
 * 
 */
public class Executortest {

	/**
	 * ExecutorService interrupt test
	 * 
	 * Conclusion:
	 * 1. shutdown() & shutdownNow()
	 * 	a. shutdown() will finish accepted tasks, kill rests, stop accepting new tasks.
	 *  b. shutdownNow() will try to interrupt running tasks, kill rests, stop accepting new tasks.
	 *  
	 * 2. How does interrupt work for thread
	 *  a. If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class, 
	 *     or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), methods of this class, 
	 *     then its interrupt status will be cleared and it will receive an InterruptedException.
	 *  b. If this thread is blocked in an I/O operation upon an interruptible channel then the channel will be closed, 
	 *     the thread's interrupt status will be set, and the thread will receive a ClosedByInterruptException.
	 *  c. If this thread is blocked in a Selector then the thread's interrupt status will be set and it will return immediately from the selection operation, 
	 *     possibly with a non-zero value, just as if the selector's wakeup method were invoked.
	 *  d. If none of the previous conditions hold then this thread's interrupt status will be set.
	 * 
	 * 3. the worst case is 2.d. Runnable itself needs to monitor the isInterrupt flag.
	 * 
	 * 4. future<?> get will throw {@link InterruptedException},  {@link CancellationException} , {@link ExecutionException}
	 *    And, get function will while loop until something happened, result get or interrupt issued
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		// submit 1
		Future<String> future1 = service.submit(new Callable<String>() {
			ExecutorService service = Executors.newFixedThreadPool(2);
			public String call() {
				try {
					System.out.println(Thread.currentThread().getName() + ": Start");

					Future<Object> future1 = service.submit(new Callable<Object>() {
						@Override
						public Object call() {
							BigInteger i = BigInteger.valueOf(1);
							try {
								System.out.println(Thread.currentThread().getName() + ": Start");
								while(!i.equals(0)) {
									if(Thread.interrupted()) {
										throw new InterruptedException();
									}
									i.add(BigInteger.valueOf(1));
								}
							} catch (Exception e) {
							
							} finally {
								System.out.println(Thread.currentThread().getName() + ": Done - " + i);
							}
							return Thread.currentThread().getName();
						}
					});
					
					Future<String> future2 = service.submit(new Callable<String>() {
						@Override
						public String call() {
							// TODO Auto-generated method stub
							BigInteger i = BigInteger.valueOf(1);

							try {
								System.out.println(Thread.currentThread().getName() + ": Start");
								while(!i.equals(0)) {
									if(Thread.interrupted()) {
										throw new InterruptedException();
									}
									i.add(BigInteger.valueOf(1));
								}
							} catch (Exception e) {
								
							} finally {
								System.out.println(Thread.currentThread().getName() + ": Done - " + i);
							}
							return Thread.currentThread().getName();
						}
						
					});
					try {
						String a = (String)future1.get();
						System.out.println(Thread.currentThread().getName() + ": " + a);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						String b = future2.get();
						System.out.println(Thread.currentThread().getName() + ": " + b);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(Thread.currentThread().getName() + ": generalException");
				} finally {
					service.shutdownNow();
					System.out.println(Thread.currentThread().getName() + ": future 1.shutdownNow()");
				}
				
				return Thread.currentThread().getName();
			}
		});
		
		//submit 2
		Future<String> future2 = service.submit(new Callable<String>() {
			@Override
			public String call() {
				System.out.println(Thread.currentThread().getName() + ": Start");
				System.out.println(Thread.currentThread().getName() + ": End");
				return Thread.currentThread().getName();
			}
		});
		
		System.out.println(Thread.currentThread().getName() + ": try cancel future 1");
		future1.cancel(true);
		System.out.println(Thread.currentThread().getName() + ": try cancelled future 1");

		try {
			System.out.println(Thread.currentThread().getName() + ": future 1 get result " + future2.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(Thread.currentThread().getName() + ": future 1 InterruptedException");
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + ": future 1 generalException");
		}
		
		try {
			System.out.println(Thread.currentThread().getName() + ": future 2 get result " + future2.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println(Thread.currentThread().getName() + ": future 2 InterruptedException");
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + ": future 2 generalException");
		}																														
		
		System.out.println(Thread.currentThread().getName() + ": service shutdown");
		try {
			TimeUnit.SECONDS.sleep(1);																																																	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		service.shutdownNow();																																																																																																																																																																																																																								

		
		try {
			TimeUnit.SECONDS.sleep(2);																																																	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": END");
	}
}
