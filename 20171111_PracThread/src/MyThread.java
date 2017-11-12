
public class MyThread extends Thread{
	@Override public void run() {
		try {
			sleep(1000);
			System.out.println("Hello run() : MyThread!");
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
