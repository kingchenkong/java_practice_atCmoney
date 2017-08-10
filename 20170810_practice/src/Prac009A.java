//兌換零錢器
//
//試設計一個CCalculator類別，資料成員包括coin10, coin5, coin1，其型態均為int，代表不同面額硬幣的個數。
//在其中建立該類別的物件obj，並完成CCalculator類別與其各成員方法的程式設計，如下所示：
//
//(a)定義建構子，用來設定兌幣機的資料成員。
//(b)定義public int[] change(int amount)函數，amount為欲兌換的金額，請將個硬幣數量放入陣列中後傳回。
//(c)定義public void printOut (int[] coins)根據硬幣數量印出結果，如果某一元素為0，則將忽略不印。
//
//
//請設計一個包含main函式的類別，並在其中建立CCalculator的物件，再落實以下執行範例：
//
//1元硬幣個數：30
//5元硬幣個數：30
//10元硬幣個數：5
//---------------------------------------------------------------------------------
//
//換零錢 1)是 2)否? 1
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)結束 -1)取消: 2
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)結束 -1)取消: 1
//請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)結束 -1)取消: 5
//兌換150元
//退回10元硬幣5個，5元硬幣20個
//
//---------------------------------------------------------------------------------
//換零錢 1)是 2)否? 
//
//找錢時會以面額大的硬幣來找開，除非該面額沒有剩餘的硬幣為止。如沒有硬幣現金可找，請印出「現金不足，無法找零」的訊息，並將程式自動終止。
import java.lang.*;
import java.util.*;
public class Prac009A {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] initInputCoin = new int[3];


		// init硬幣
		initCoin(initInputCoin);
		CCalculator cal = new CCalculator(initInputCoin);

		line("--", 30, true);
		do {
			// 主選單
			mainOption();
			// 輸入 硬幣 
			int needToExchangeOrCancel = inputCash();
			if(needToExchangeOrCancel == -1) {
				// 取消本次交易
				System.out.println("取消本次交易");
				
			} else {
				// 投入現金完成
				// - 顯示 需兌換金額
				System.out.println("兌換" + needToExchangeOrCancel + "元");
				// 找零情況
				int[] arr = cal.change(needToExchangeOrCancel);
				int sum = 0;
				for(int i = 0; i < arr.length; i++) {
					sum += arr[i];
				}
				if(sum == 0) {
					System.out.println("「現金不足，無法找零」");
					//				System.exit(0);
					break;
				}
				cal.printOut(arr);
			}
			
			// 本回合結束
			line("--", 30, true);

		} while(true);

	}
	//##########
	// function
	//##########
	// - 流程
	// 輸入硬幣
	public static void initCoin(int[] arr){
			for(int i = 0; i < arr.length; i++) {
				System.out.println(" '" + (i > 0? 5*i: 1) + "' 元硬幣個數：");
				arr[i] = sc.nextInt();
				if(arr[i] < 0) {
					printStatusBar("Input Error.");
					i -= 1;
				}
			}
	}
	// 主選單
	public static void mainOption() {
		do {
			System.out.print("換零錢 1)是 2)否?");
			int option = sc.nextInt();
			if(option == 1) {
				// 開始程式
				return;
			} else if(option == 2) {
				// 結束程式
				printStatusBar("Bye!");
				System.exit(0);
			} else {
				//print error
				printStatusBar("Input Error.");
			}
		} while(true);
	}
	// 選單 - 輸入需兌換
	public static int inputCash() {
		int rtMoney = 0;
		do {
			System.out.print("請投入現金： 1) 50元 2) 100元 3) 500元4) 1000元 5)結束 -1)取消: ");
			int option = sc.nextInt();
			switch(option) {

			case 1:
				rtMoney += 50;
				break;
			case 2:
				rtMoney += 100;
				break;
			case 3:
				rtMoney += 500;
				break;
			case 4:
				rtMoney += 1000;
				break;
			case 5:
				//回傳需要的金錢
				return rtMoney;

			case -1:
				// 取消本次交易	
				return -1;

			default:
				// 輸入錯誤
				printStatusBar("Input Error.");
			}
		} while(true);
		//		return 0;
	}



	// - 版面
	// 分隔線
	public static void line(String str, int count, boolean br) {
		for(int i = 0; i < count; i++) {
			System.out.printf("%s", str);
		}
		if(br)
			System.out.println("");
	}
	public static void printStatusBar(String str) {
		// 上面的線
		System.out.print(" ");
		line("--", str.length() + 1, false);
		System.out.println(" ");

		// message
		System.out.print("||");
		line(" ", str.length() / 2, false);
		System.out.print(str);
		line(" ", str.length() / 2, false);
		System.out.println("||");

		// 下面的線
		System.out.print(" ");
		line("--", str.length() + 1, false);
		System.out.println(" ");
	}

	// - test
	public static void showArrInt(int[] arr) {

		System.out.println("arr => ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");
	}




}
//#######
// class
//#######
class CCalculator{
	private int coin10 = 0;
	private int coin5 = 0;
	private int coin1 = 0;

	// - method
	// (a) 定義建構子，用來設定兌幣機的資料成員。
	public CCalculator( int[] arr) {
		coin10 = arr[2];
		coin5 = arr[1];
		coin1 = arr[0];
		//
//		System.out.println("init 1  元硬幣  : " + coin1 + " 個");
//		System.out.println("init 5  元硬幣  : " + coin5 + " 個");
//		System.out.println("init 10 元硬幣  : " + coin10 + " 個");

	}
	// (b) 定義public int[] change(int amount)函數，amount為欲兌換的金額，請將個硬幣數量放入陣列中後傳回。
	public int[] change(int amount) {
		int[] arrNeedCh = new int[3];

		// coin 10
		if(amount / 10 >= coin10) {
			arrNeedCh[2] = coin10;
			amount = amount - 10 * coin10; 
		} else {
			arrNeedCh[2] = amount / 10;
			amount = amount - 10 * arrNeedCh[2];
		}
		// coin 5
		if(amount / 5 >= coin5) {
			arrNeedCh[1] = coin5;
			amount = amount - 5 * coin5; 
		} else {
			arrNeedCh[1] = amount / 5;
			amount = amount - 5 * arrNeedCh[1];
		}
		// coin 1
		if(amount >= coin1) {
			arrNeedCh[0] = coin1;
			amount = amount - coin1; 
		} else {
			arrNeedCh[0] = amount;
			amount = amount - arrNeedCh[0];
		}
		if(amount != 0) {	
			Arrays.fill(arrNeedCh, 0);
		} else {
			coin10 -= arrNeedCh[2]; 
			coin5 -= arrNeedCh[1]; 
			coin1 -= arrNeedCh[0]; 
		}

		return arrNeedCh;
	}
	//(c) 定義public void printOut (int[] coins)根據硬幣數量印出結果，如果某一元素為0，則將忽略不印。
	public void printOut (int[] coins) {
		int printCount = 0;
		// 零錢不夠
		if(coins[2] != 0) {
			System.out.printf("找您 10 元硬幣 %2d 個,\n", coins[2]);
			printCount++;
		}
		if(coins[1] != 0) {
			System.out.printf("找您 5  元硬幣 %2d 個,\n", coins[1]);
			printCount++;
		}
		if(coins[0] != 0){
			System.out.printf("找您 1  元硬幣 %2d 個,\n", coins[0]);
			printCount++;
		}
		//		if(printCount == 0) {
		//			System.out.println("「現金不足，無法找零」");
		////			System.exit(0);
		//		}
		return;
	}

}