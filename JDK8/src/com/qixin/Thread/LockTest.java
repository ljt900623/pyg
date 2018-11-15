package com.qixin.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @author 李江涛
 *
 */
public class LockTest {

	public static void main(String[] args) {
		rel rel = new rel();
		Thread t1 = new Thread(new InpThread(rel));
		Thread t2 = new Thread(new OutThread(rel));
		t1.start();t2.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main.."+i);
			if (i==20) {				
				t1.interrupt();t2.interrupt();
			}
		}
	}
}

class rel {

	public String name;
	public String sex;
	public boolean flag = false;
	public Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();

}

class InpThread implements Runnable {

	private rel rel;

	public InpThread(com.qixin.Thread.rel rel) {
		super();
		this.rel = rel;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				rel.lock.lock();
				if (rel.flag) {

					rel.con.await();
				}
				if (count % 2 == 0) {
					rel.name = "赵帝";
					rel.sex = "男";
				} else {
					rel.name = "杜鹃";
					rel.sex = "女";
				}

				count++;
				//rel.con.signal();
				rel.flag = true;

			} catch (InterruptedException e) {
			
			} finally {
				rel.lock.unlock();
			}
		}

	}

}

class OutThread implements Runnable {
	public rel rel;

	public OutThread(com.qixin.Thread.rel rel) {
		super();
		this.rel = rel;
	}

	@Override
	public void run() {
		while (true) {
			try {
				rel.lock.lock();
				if (!rel.flag) {
					rel.con.await();
				}
				System.out.println("name::" + rel.name + "sex::" + rel.sex);
				//rel.con.signal();
				rel.flag = false;
			} catch (InterruptedException e) {
				
			} finally {
				rel.lock.unlock();
			}
		}

	}

}
