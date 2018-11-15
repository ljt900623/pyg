package com.qixin.Tread;

public class ThreadZy implements Runnable {

	private static int j = 0;

	public  void run() {

		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			add();
			sub();
		}
	}

	private synchronized void sub() {
		String name = Thread.currentThread().getName();
		if (name.equals("Thread-0") || name.equals("Thread-1")) {
			j--;
			System.out.println(Thread.currentThread().getName() + "给J减1后等于" + j);
		}

	}

	public synchronized void add() {
		String name = Thread.currentThread().getName();
		if (name.equals("Thread-2") || name.equals("Thread-3")) {
			j++;
			System.out.println(Thread.currentThread().getName() + "给J加1后等于" + j);
		}

	}

}
