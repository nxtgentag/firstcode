package threadexample;

public class Deadlock {
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();
	public static int count=0;

	public static void main(String args[]) {
		ThreadDemo1 T1 = new ThreadDemo1("thread-1");
		ThreadDemo2 T2 = new ThreadDemo2("thread-2");
		T1.start();
		T2.start();
	}

	private static class ThreadDemo1 extends Thread {
		String threadname;
		public ThreadDemo1(String name) {
			// TODO Auto-generated constructor stub
			threadname=name;
		}
		public void run() {
			synchronized (Lock1) {
				count++;
				System.out.println(threadname+": Holding lock 1...");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				System.out.println(threadname+": Waiting for lock 2...");
				System.out.println(count);
			}	//sychronized closed
				synchronized (Lock2) {
					System.out.println(threadname+": Holding lock 1 & 2...");
				}
			//}
		}
	}

	private static class ThreadDemo2 extends Thread {
		String threadname;
		public ThreadDemo2(String name) {
			// TODO Auto-generated constructor stub
			threadname=name;
		}
		public void run() {
			synchronized (Lock2) {
				count++;
				System.out.println(threadname+": Holding lock 2...");

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println(threadname+": Waiting for lock 1...");
				System.out.println(count);

				synchronized (Lock1) {
					System.out.println(threadname+": Holding lock 1 & 2...");
				}
			}
		}
	}
}
