/*package ThreadLoca;


class Res{
	//private  int count = 0;
	
	//设置本地局部变量，和其他线程的局部变量需要隔离开，做到互不影响
	private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			//设置当前线程局部变量 初始化值为0
			return 100;
		}
	};
	
	

	
	//生成序列号
	public Integer getNum() {
	
		int count = this.count.get() + 1;
		this.count.set(count);
		return count;
	}
}

class ThreadLocalTestDemo extends Thread{
	private Res res;
	
	public ThreadLocalTestDemo(Res res) {
		this.res = res;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getName() + "----i " + i + " number:" + res.getNum());
		}
	}
}

public class ThreadlocalDemo {
	public static void main(String[] args) {
		Res res = new Res();
		ThreadLocalTestDemo t1 = new ThreadLocalTestDemo(res);
		ThreadLocalTestDemo t2 = new ThreadLocalTestDemo(res);
		ThreadLocalTestDemo t3 = new ThreadLocalTestDemo(res);
		t1.start();
		t2.start();
		t3.start();
	}

}
*/