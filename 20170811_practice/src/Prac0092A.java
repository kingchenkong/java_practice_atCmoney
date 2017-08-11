//撰寫一個程式用來逐步輸入學生的生日，並將所有學生的生日印出，印出時請用以下yyyy/mm/dd格式列印。
//生日包含西元年月日，請在主函式中宣告陣列來作儲存，並定義副函式來完成這個程式。
//*請注意：如果你有餘力，你可以自訂其他的副函式用來檢查日期輸入的格式是否正確，包括日期範圍（1月有31天、閏年問題等等）是否正確。
//請撰寫一個副函式將生日依照最早到最近的順序進行排序，並將結果印出。
import java.lang.*;
import java.util.*;
public class Prac0092A {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[][] arrBir = new int[10][3];
		int dataCount = 0;
		//	- [stu][0] - year
		//         [1] - month
		//         [2] - day

		//回傳 資料總數
		dataCount = inputData(arrBir, dataCount);
		//排序 最早到最晚
		sortDate(arrBir, dataCount);

		line("---", 20, true);
		//test
		for(int i = 0; i < dataCount; i++) {
			for(int j = 0; j < arrBir[i].length; j++) {
				if(arrBir[i][0] == -1) 
					break;
				System.out.printf("%d ", arrBir[i][j]);
			}
			System.out.println("");
		}

	}
	//##########
	// function
	//##########
	// - 流程
	// 輸入資料
	public static int inputData(int[][] arrB, int dc) {
		do {
			System.out.println("生日格式 : yyyy mm dd");
			System.out.println("請輸入生日 : ");
			String inputStr = sc.nextLine();
			String[] arrSplit = inputStr.split(" ", 3);
			line("--", 30, true);
			try {
				for(int i = 0; i < arrSplit.length; i++) 
					arrB[dc][i] = Integer.parseInt(arrSplit[i]);


			} catch(Exception E) {
				printStatusBar("Input Error.");
			}

			// 判斷 -1 跳出迴圈 
			int judge = 0;
			for(int i = 0; i < arrB[dc].length; i++) 
				judge += arrB[dc][i];
			if(judge == -1) {
				dc++;
				break;
			}

			// 判斷 閏年
			boolean isLeap = false;
			boolean yearIsOk = false, monthIsOk = false, dayIsOk = false;
			int[] arrMonthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if ((arrB[dc][0] < 1) || (arrB[dc][0] > 9999)) {
				//				System.out.println("不存在該年份.");
				printStatusBar("該 -年份- 不存在");
			} else if (arrB[dc][0] % 4 == 0) {
				isLeap = true;
				yearIsOk = true;
				if (arrB[dc][0] % 100 == 0)
					isLeap = false;
				if (arrB[dc][0] % 400 == 0)
					isLeap = true;

			} else {
				isLeap = false;
				yearIsOk = true;
			}

			// 月份
			if(yearIsOk) {
				if ((arrB[dc][1] < 1) || (arrB[dc][1] > 12)) {
					//				System.out.println("不存在該月份.");
					printStatusBar("該 -月份- 不存在");
				} else {
					monthIsOk = true;
				}
			}
			// 日期
			if(yearIsOk && monthIsOk) {
				if ((arrB[dc][2] < 1) || (arrB[dc][2] > 31)) {
					//				System.out.println("不存在該日期.");
					printStatusBar("該 -日期- 不存在");
				} else {
					if (isLeap && (arrB[dc][1] == 2)) {
						if (arrB[dc][2] <= 29) {
							dayIsOk = true;
						}
					} else if (arrB[dc][2] <= arrMonthDays[arrB[dc][1] - 1]) {
						dayIsOk = true;
					} else {
						dayIsOk = false;
						//					System.out.println("該日期不存在");
						printStatusBar("該 -日期- 不存在");
					}
				}
			}

			if (yearIsOk && monthIsOk && dayIsOk) {
				dc++;
			}
		} while(true);

		return dc;
	}
	// 排序
	public static void sortDate(int[][] arrDate, int dc) {
		//排序 年
		for(int i = 0; i < dc - 1; i++) {
			for(int j = i + 1; j < dc - 1; j++ ) {
				if(arrDate[i][0] > arrDate[j][0]) {
					for(int k = 0; k < arrDate[i].length; k++) {
						int temp = arrDate[i][k];
						arrDate[i][k] = arrDate[j][k];
						arrDate[j][k] = temp;
					}
				}

			}
		}

		//年 一樣才比較
		for(int m = 0; m < dc - 1; m++) {
			for(int n = m + 1; n < dc - 1; n++) {
				if(arrDate[m][0] == arrDate[n][0]) {
					if(arrDate[m][1] > arrDate[n][1]) {
						for(int k = 0; k < arrDate[m].length; k++) {
							int temp = arrDate[m][k];
							arrDate[m][k] = arrDate[n][k];
							arrDate[n][k] = temp;
						}
					}
				}
			}
		}

		// 月一樣才排序
		for(int m = 0; m < dc - 1; m++) {
			for(int n = m + 1; n < dc - 1; n++) {
				if(arrDate[m][1] == arrDate[n][1]) {
					if(arrDate[m][2] > arrDate[n][2]) {
						for(int k = 0; k < arrDate[m].length; k++) {
							int temp = arrDate[m][k];
							arrDate[m][k] = arrDate[n][k];
							arrDate[n][k] = temp;
						}
					}
				}
			}
		}


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

