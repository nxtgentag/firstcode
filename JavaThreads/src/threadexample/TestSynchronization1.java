package threadexample;

class Table {

	void printTable(int n) { // method not synchronized output is jumbled
		//synchronized (this) {
			for (int i = 1; i <= 5; i++) { // put the below code in synchronized
											// block
				System.out.println(n * i);
				try {
					Thread.sleep(0);
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		//}
	}
}

class MyThread1 extends Thread {
	Table t;

	MyThread1(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(5);
	}

}

class MyThread2 extends Thread {
	Table t;

	MyThread2(Table t) {
		this.t = t;
	}

	public void run() {
		t.printTable(100);
	}
}

class TestSynchronization1 {
	public static void main(String args[]) {
		Table obj = new Table(); // only one object
		MyThread1 t1 = new MyThread1(obj);
		MyThread2 t2 = new MyThread2(obj);
		t1.start();	//instead of start call run on both without sychronization
		t2.start();
	}
}
