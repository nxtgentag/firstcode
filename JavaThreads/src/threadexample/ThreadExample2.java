package threadexample;

public class ThreadExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo T1 = new ThreadDemo("Thread-1");
		T1.startthread();
		ThreadDemo T2 = new ThreadDemo("Thread-2");
		T2.startthread();
		try{
			T1.join();
			T2.join();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;

	ThreadDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {	//step-1
		System.out.println("Running " + threadName);
		try {
			for (int i = 3; i > 0; i--) {
				System.out.println("Thread " + threadName + " "+ i);
				
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void startthread() {	//step-2
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();	// this will in turn call run();
		}
	}
}
