package com.qixin.Tread;

import java.util.concurrent.TimeUnit;

public class TestTrainTickets {

	public static void main(String[] args) {		
		TrainTickets t = new TrainTickets();		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		Thread t5 = new Thread(t);
		
		t1.start();t2.start();		
		t3.start();t4.start();		
		t5.start();	
		
		
	}
}
