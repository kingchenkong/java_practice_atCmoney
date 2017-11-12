
public class Main {

	public static void main(String[] args) {

		// - part I
		// new MyThread
		//		MyThread myThread = new MyThread();
		//		myThread.start();
		//		System.out.println("u mother fucker?");

		// - part II
		//		MyRunnable myRunnable = new MyRunnable();
		//		Thread myThread = new Thread(myRunnable);
		//		myThread.start();

		// - part III
//		MyRunnable myRunnable1 = new MyRunnable("A");
//		MyRunnable myRunnable2 = new MyRunnable("B");
//		MyRunnable myRunnable3 = new MyRunnable("C");
		// - Part IV
		NameCollector nameCollector = new NameCollector(); //創建name collector實體
        MyRunnable myRunnable1 = new MyRunnable("A", nameCollector); //傳入有實作介面的實體
        MyRunnable myRunnable2 = new MyRunnable("B", nameCollector);
        MyRunnable myRunnable3 = new MyRunnable("C", nameCollector);
		Thread myThread1 = new Thread(myRunnable1);
		Thread myThread2 = new Thread(myRunnable2);
		Thread myThread3 = new Thread(myRunnable3);
		myThread1.start();
		myThread2.start();
		myThread3.start();

		// - prat III
		try {
			// .join()
			// - 讓 "main Thread" 停下, 等 某Thread 結束 才會執行下一行
			//                            myThread
			myThread1.join();
			myThread2.join();
			myThread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 這一行會最後 print
		System.out.println("Main Thread Finished");
		// - Part IV
		 System.out.println(nameCollector); //印出結果
	}

}
