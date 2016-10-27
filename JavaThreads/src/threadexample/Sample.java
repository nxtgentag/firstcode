package threadexample;

public class Sample extends Thread {
	
	public void run(){
		System.out.println("Thread executed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample s1=new Sample();
		Sample s2=new Sample();
		s1.start();
		s2.start();
		System.out.println("Hai from kiran");

	}

}
