
public class MyRunnable implements Runnable{

	private String name;
	// - Part IV
	private CallBackInterface callBackInterface;

	//	public MyRunnable (String name) {
	//		this.name = name;
	//	}
	// - Part IV
	public MyRunnable(String name, CallBackInterface callBackInterface) {
		this.name = name;
		this.callBackInterface = callBackInterface; // 將介面傳入
	}

	//	@Override 
	//	public void run() {
	//		try {
	//			Thread.sleep(1000);
	//			
	//			// - Part II
	////			System.out.println("Hello run() : MyRunnable!");
	//			
	//			// - Part III
	//			System.out.println("Thread:"+name+" Finished");
	//			
	//		} catch (InterruptedException e) {
	//			e.printStackTrace();
	//		}
	//	}

	// - Part IV
	@Override
	public void run(){
		try{
			Thread.sleep(1000);
			// 通過介面傳送訊息給NameCollector
			synchronized(callBackInterface) {
				this.callBackInterface.sendMessage("Thread:" + name + " Finished");
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

