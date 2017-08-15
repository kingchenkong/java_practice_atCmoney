
//請撰寫一個程式用以模擬樂透獎對獎，簽注樂透彩一張的金額固定為50元，初始獎金為10 000 000元。
//樂透獎遊玩方法如下述；使用者簽注一組數字不重複的號碼共五個（數字為1~32），如對中後三碼得獎金之1%（參獎），
//對中後四碼得獎金之20%（貳獎），五碼全中得獎金的100%（頭獎）。
//每回開獎金皆自上次剩餘獎金中增加6%，
//如開出頭獎，所有中獎的玩家可分享全部獎金（例如獎金累積到120 000 000，兩人中頭獎則一人分得60 000 000）。
//如得獎的獎金被分光或分超過了，下次獎金需重新自10 000 000累計。如使用者所持有現金為0，則自動終止程式（輸入範例如黑體字標註）。
//
//程式中，請實作並呼叫以下函式：
////判斷key是否有在陣列s當中，如果有重複的數字，請回傳1，否則回傳0
//int isDuplicated(int key, int[] s);
//
////呼叫此函數來比對簽注的數字myNumbers是否與開出的數字lottoNumbers相同；
////對中參獎回傳3；對中二獎回傳2；對中頭獎回傳1；否則回傳0
//int Match(int[] myNumbers, int[] lottoNumbers);
//
//程式執行範例如下（使用者輸入的部分以粗體字標註）：
//
//持有資金：2000
//
//樂透彩一注簽注金額：50
//累積獎金：10000000
//=========================
//1) 簽注 2) 終止: 1
//購買張數：45
//現金不足！
//購買張數：4
//
//您購買了4張樂透。
//本期開出號碼： 23 12 24 30 18
//
//您簽注的第1組號碼為：5 17 21 22 31 ……槓龜
//您簽注的第2組號碼為：23 3 24 30 18 ……恭喜您！中參獎
//您簽注的第3組號碼為：12 2 19 22 31 ……槓龜
//您簽注的第4組號碼為：15 17 24 30 18 ……恭喜您！中參獎
//您總共得到200000元！
//持有資金剩餘 201800 元
//
//1) 簽注 2) 終止: 

import java.util.Scanner;

public class problem01 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrayInit = { 10000000, 2000, 50 };
		// 0 - 初始獎金 - 10,000,000
		// 1 - 使用者持有資金
		// 2 - 下注 一注
		int scanSelect = 0;
		// 1) 簽注 2) 終止:
		int ticketNum = 0;
		//

		System.out.println("持有資金 : ");
		arrayInit[1] = scanner.nextInt();
		System.out.println("樂透彩一注簽注金額 : ");
		arrayInit[2] = scanner.nextInt();
		System.out.println("累積獎金 : ");
		arrayInit[0] = scanner.nextInt();

		showArray(arrayInit);

		do {
			// 簽注？
			do {
				System.out.println("\n1) 簽注 2) 終止: ");
				scanSelect = scanner.nextInt();
				if (scanSelect == 2) {
					System.out.println("Bye!");
					System.exit(0);
					// exit
				}
				if (scanSelect == 1) {
					break;
					// 簽注
				}
				System.out.println("請重新輸入");
			} while (true);

			// 購買張數
			do {
				System.out.println("購買張數：");
				ticketNum = 0;
				ticketNum = scanner.nextInt();
				if (ticketNum < 1) {
					System.out.println("輸入錯誤");
				} else if (ticketNum * arrayInit[2] > arrayInit[1]) {
					System.out.println("現金不足");
				} else {
					arrayInit[1] -= ticketNum * arrayInit[2];
					System.out.println("您購買了" + ticketNum + "張樂透");
					break;
				}
			} while (true);

			// 本期開出號碼： 23 12 24 30 18
			int[] arrayThisRoundNum = new int[5];
			int numIndex = 0;
			do {
				int thisRoundNum = 0;
				thisRoundNum = ((int) (Math.random() * 32)) + 1;
				if (isDuplicated(thisRoundNum, arrayThisRoundNum) == 1) {
					continue;
				} else {
					arrayThisRoundNum[numIndex] = thisRoundNum;
					numIndex++;
				}
				if (numIndex == arrayThisRoundNum.length) {
					break;
				}
			} while (true);
			System.out.print("本期開出號碼：");
			showArray(arrayThisRoundNum);
			System.out.println("");

			// 您簽注的第1組號碼為：5 17 21 22 31 ……槓龜
			// 您簽注的第2組號碼為：23 3 24 30 18 ……恭喜您！中參獎
			// 您簽注的第3組號碼為：12 2 19 22 31 ……槓龜
			// 您簽注的第4組號碼為：15 17 24 30 18 ……恭喜您！中參獎
			// 您總共得到200000元！
			// 持有資金剩餘 201800 元

			int bingoCount = 0;
			int bingo1Count = 0, bingo2Count = 0, bingo3Count = 0;
			boolean get1 = false, get2 = false, get3 = false;
			int circleCount = 1;
			int[] arrayForRandom = new int[5];

			do {

				System.out.print("您簽注的第" + circleCount + "組號碼為：");
				numIndex = 0;
				do {
					int thisCircleNum = 0;
					thisCircleNum = ((int) (Math.random() * 32)) + 1;
					if (isDuplicated(thisCircleNum, arrayForRandom) == 1) {
						continue;
					} else {
						arrayForRandom[numIndex] = thisCircleNum;
						numIndex++;
					}
					if (numIndex == arrayForRandom.length) {
						break;
					}
				} while (true);
				
				showArray(arrayForRandom);

				if (Match(arrayForRandom, arrayThisRoundNum) == 1) {
					get1 = true;
					bingo1Count += 1;
					System.out.println("……恭喜您！中了 頭獎");
					break;
					// 中頭獎 直接 break;
				} else if (Match(arrayForRandom, arrayThisRoundNum) == 2) {
					get2 = true;
					bingo2Count += 1;
					System.out.println("……恭喜您！中了 2獎");
				} else if (Match(arrayForRandom, arrayThisRoundNum) == 3) {
					get3 = true;
					bingo3Count += 1;
					System.out.println("……恭喜您！中了 3獎");
				} else {
					System.out.println("……槓龜");
				}
				circleCount++;
			} while (circleCount <= ticketNum);

			// 您總共得到200000元！
			// 持有資金剩餘 201800 元

			int bingoIncome = 0;
			if (get1) {
				bingoIncome = arrayInit[0];
				arrayInit[1] += bingoIncome;
				System.out.println("您總共得到 " + bingoIncome + "元");
				System.out.println("持有資金剩餘 " + arrayInit[1] + "元");

				arrayInit[0] = 10000000;
			} else if (get2) {
				if (bingo2Count < 6) {
					bingoIncome = arrayInit[0] / 5 * bingo2Count;
					arrayInit[0] -= bingoIncome;
					arrayInit[1] += bingoIncome;
					System.out.println("您總共得到 " + bingoIncome + "元");
					System.out.println("持有資金剩餘 " + arrayInit[1] + "元");

					arrayInit[0] = (int) ((double) arrayInit[0] * 1.06);
				} else {
					bingoIncome = arrayInit[0];
					arrayInit[0] = 10000000;
					arrayInit[1] += bingoIncome;
					System.out.println("您總共得到 " + bingoIncome + "元");
					System.out.println("持有資金剩餘 " + arrayInit[1] + "元");

					arrayInit[0] = 10000000;
				}

			} else if (get3) {
				if (bingo3Count < 100) {
					bingoIncome = arrayInit[0] / 100 * bingo3Count;
					arrayInit[0] -= bingoIncome;
					arrayInit[1] += bingoIncome;
					System.out.println("您總共得到 " + bingoIncome + "元");
					System.out.println("持有資金剩餘 " + arrayInit[1] + "元");

					arrayInit[0] = (int) ((double) arrayInit[0] * 1.06);
				} else {
					bingoIncome = arrayInit[0];
					arrayInit[1] += bingoIncome;
					System.out.println("您總共得到 " + bingoIncome + "元");
					System.out.println("持有資金剩餘 " + arrayInit[1] + "元");

					arrayInit[0] = 10000000;
				}
			} else {
				arrayInit[0] = (int) ((double) arrayInit[0] * 1.06);
			}
			//test
			showArray(arrayInit);
			System.out.println("------------------------");
			
		} while (true);

	}

	// function

	// 判斷key是否有在陣列s當中，如果有重複的數字，請回傳1，否則回傳0

	// 判斷重複
	public static int isDuplicated(int key, int[] s) {

		for (int i = 0; i < s.length; i++) {
			if (s[i] == key) {
				return 1;
			}
		}
		return 0;
	}

	// 呼叫此函數來比對簽注的數字myNumbers是否與開出的數字lottoNumbers相同；
	// 對中參獎回傳3；對中二獎回傳2；對中頭獎回傳1；否則回傳0

	// 兌獎
	public static int Match(int[] myNumbers, int[] lottoNumbers) {

		int count = 0;

		for (int i = myNumbers.length - 1; i > -1; i--) {
			if (lottoNumbers[i] == myNumbers[i]) {
				count++;
			}
		}
		if (count == 5) {
			return 1;
		}
		if (count == 4) {
			return 2;
		}
		if (count == 3) {
			return 3;
		}
		return 0;
	}

	// - print Array
	public static void showArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// 3 - 氣泡排序法 - bubble sort
	public static void bubble_Sort(int array[], boolean bigToSmall) {
		int temp = 0;
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length - j - 1; i++) {

				// true, big to small
				if ((array[i] > array[i + 1]) && bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				// false, small to big
				if ((array[i] < array[i + 1]) && !bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}
}

////test
//// 頭獎
//arrayForRandom = arrayThisRoundNum;
//// 二獎 
//arrayThisRoundNum = null;
//arrayForRandom = null;
//int[] arr0 = { 5, 6, 7, 8, 9};
//int[] arr1 = { 0, 0, 7, 8, 9};
//
//arrayThisRoundNum  = arr0;
//arrayForRandom = arr1;
//// 三獎



