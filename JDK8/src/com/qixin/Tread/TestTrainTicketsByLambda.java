package com.qixin.Tread;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.OptionalLong;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TestTrainTicketsByLambda {

	public static void sale(Integer total,Consumer<Integer> com) {		
		
		com.accept(total);
		
	}

	public static long parallelSum(long n){
		
    return Stream.iterate(1L, i -> i +1).limit(n).parallel().reduce(0L,Long::sum);
    
	}
	
	@Test 
	public void testFor() { 
		Instant start = Instant.now(); long sum = 0; 
		for (long i = 0; i <= 50000000000L; i++) {  sum += i; }  System.out.println(sum); 
		Instant end = Instant.now(); 
		System.out.println("五百亿求和花费的时间为: " + Duration.between(start, end).toMillis());
		}
	@Test 
	public void testStream() { 
		Instant start = Instant.now(); 
		//使用StreamAPI 
		OptionalLong result = LongStream.rangeClosed(0L, 50000000000L).parallel().reduce(Long::sum); 
		System.out.println(result.getAsLong()); 
		Instant end = Instant.now(); 
		System.out.println("五百亿求和耗费的时间为: " + Duration.between(start, end).toMillis()); 
	}


	    public static void doTask(String material, Consumer<String> consumer) {
	        consumer.accept(material);
	    }
	   
	




	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	    
	
	static int total=100000;
	private static  Object mutex = new Object();
	public static void main(String[] args) {		
		ExecutorService threadPool = Executors.newFixedThreadPool(100);
		while (total>0) {
			threadPool.execute(new Runnable() {				
				public void run() {
					synchronized (mutex) {
						if (total>0) {
							total--;
							System.out.println(Thread.currentThread().getName()+"线程抢到1张,"+
							"还剩余"+total+"张票");	
							}							
					}						
			
				}
			});
			
		}
		threadPool.shutdown();
		
		
	}
}
