package com.qixin.Tread;

public class TestZy {

	public static void main(String[] args) {
		ThreadZy zy = new ThreadZy();
		Thread t1 = new Thread(zy);
		Thread t2 = new Thread(zy);
		Thread t3 = new Thread(zy);
		Thread t4 = new Thread(zy);
		t1.start();t2.start();
		t3.start();t4.start();
	}
}
