package threadexample;
// threads example using Runnable interface

public class ThreadExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadCreation thread1 = new ThreadCreation("First Thread");
		thread1.startthread();

		ThreadCreation thread2 = new ThreadCreation("Second Thread");
		thread2.startthread();
		
	}

}

class ThreadCreation implements Runnable {
	private Thread t;
	private String threadName;

	public ThreadCreation(String threadname) {
		// TODO Auto-generated constructor stub
		threadName = threadname;
		System.out.println(threadName + " created...");
	}

	public void run() { // first step
		System.out.println(threadName + " running...");
		//System.out.println(t.isAlive());
		try {
			for (int i = 3; i > 0; i--) {
				System.out.println("Hello from " + threadName + i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(threadName + " terminated...");
	}

	public void startthread() {
		System.out.println(threadName + " starting...");
		if (t == null) {
			t = new Thread(this, threadName); // step-2
			t.start(); // step-3, this will in turn call run();
		}

	}
}
