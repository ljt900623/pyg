package com.qixin.Tread;

public class TrainTickets implements Runnable {

	private int total = 20;
	private  Object mutex = new Object();
	public void run() {
		while (total>0) {			
			synchronized (mutex) {
				
				if (total>0) {
					total--;
					System.out.println(Thread.currentThread().getName()+"线程抢到1张,"+
					"还剩余"+total+"张票");	
				}				
			}			
		}
		
	}

}
