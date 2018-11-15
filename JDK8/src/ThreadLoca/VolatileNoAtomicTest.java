package ThreadLoca;

import java.util.concurrent.atomic.AtomicInteger;
class VolatileNoActomic extends Thread{	
	private static volatile AtomicInteger ai = new AtomicInteger(0);
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10000; i++) {
				ai.incrementAndGet();
			}
			System.out.println(ai);
		}
		
	}
}

public class VolatileNoAtomicTest {
	
	public static void main(String[] args) throws InterruptedException {
		VolatileNoActomic[] vna =new VolatileNoActomic[10];
		for (int i = 0; i < 10; i++) {
			vna[i]=new VolatileNoActomic();
		}
		for (int i = 0; i < 10; i++) {			
			vna[i].start();
			Thread.sleep(3);
		}
	}
}
