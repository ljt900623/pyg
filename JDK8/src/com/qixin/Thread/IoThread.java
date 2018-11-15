package com.qixin.Thread;

class res  {

	public String name;
	public String sex;
	public boolean flag = false;
	
	
}
class InThread implements Runnable{

	public res res;
	
	public InThread(com.qixin.Thread.res res) {
		super();
		this.res = res;
	}

	@Override
	public void run() {
		int count=0;
		while(true) {			
			synchronized (res) {
				if (res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (count%2==0) {
					res.name="赵帝";res.sex="男";
				}else {
					res.name="杜鹃";res.sex="女";
				}
				
				count++;
				res.flag = true;
				res.notify();
			}			
		}
		
	}	
}

class OuThread implements Runnable{

	
	private res res;
	
	public OuThread(com.qixin.Thread.res res) {
		super();
		this.res = res;
	}
	
	@Override
	public  void run() {
	while(true) {		
		synchronized (res) {
			if (!res.flag) {
				try {
					res.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("name::"+res.name+"sex::"+res.sex);
			res.flag = false;
			res.notify();
		}
			
			
		}
		
	}
}

public class IoThread {

	public static void main(String[] args) {
		
		 res res = new res();		
		 Thread t1 = new Thread(new InThread(res));
		 Thread t2 = new Thread(new OuThread(res));
		 t1.start();
		 t2.start();
	}
}
