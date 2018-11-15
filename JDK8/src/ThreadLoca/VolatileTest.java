package ThreadLoca;

class VolatileDemo extends Thread{
	public volatile boolean flag = true;
	

	public void run() {
		System.out.println("线程开始执行");
		while (flag) {			
			
		}
		System.out.println("线程执行完成");
	}
	
	public void bb(boolean flag) {
		this.flag=flag;
	}
}


public class VolatileTest {

	public static void main(String[] args) throws InterruptedException {
		VolatileDemo t1 = new VolatileDemo();		
		t1.start();
		Thread.sleep(3);
		t1.bb(false);
	}
}
