package threadexample;

public class Sample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(new threads());
		Thread t2=new Thread(new threads());
		t1.start();
		t2.start();
                System.out.println("hello this is from Gowtham");
	}

}

class threads implements Runnable{
	public void run(){
		System.out.println("Thread executed");
	}
}
