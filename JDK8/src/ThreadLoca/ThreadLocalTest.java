package ThreadLoca;

class Res{
	
	
	private  ThreadLocal<Integer> count =new ThreadLocal<Integer>() {
		
		protected Integer initialValue() {
	        return 0;
	    }
	};
	
	public Integer getNum() {
		int count =this.count.get()+1;
		this.count.set(count);
		return count;
	}
	
}

class ThreadLocaDemo extends Thread{
	
	private Res res;

	public ThreadLocaDemo(Res res) {		
		this.res = res;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <3; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName()+"i"+i+"num--"+res.getNum());
		}
	}
	
}

public class ThreadLocalTest {

	public static void main(String[] args) {
		Res res = new Res();
		ThreadLocaDemo t1 = new ThreadLocaDemo(res);
		ThreadLocaDemo t2 = new ThreadLocaDemo(res);
		ThreadLocaDemo t3 = new ThreadLocaDemo(res);
		t1.start();t2.start();t3.start();
	}
}
