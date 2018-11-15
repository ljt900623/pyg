package com.qixin;

public class TestThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new CreateRunable());
		t1.start();		
		CreateThread c = new CreateThread();
		c.start();
	}		

}
