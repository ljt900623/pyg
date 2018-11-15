package com.qixin;

public class CreateThread extends Thread {

	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println("i="+i);
		}
	}
}
