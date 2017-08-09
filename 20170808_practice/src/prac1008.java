//找尋最小值
//
//請設計一個程式要求使用者輸入數字（介於0~100）並存入陣列中，再撰寫一個遞迴函式RecursiveMinimum用以找出陣列中的最小值。其函式原型定義如下：
//
//public static int RecursiveMinimum (int a[], int n);
//
//陣列a為一個數字陣列，n表示搜尋陣列的範圍為前n個數字。函式回傳在此範圍內的最小值；禁止使用全域變數，如果沒有用到遞迴者以零分計。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Option: 1) Add. 2) Minimum. -1) Quit: 1
//Insert grade (-1 to end): 20
//Insert grade (-1 to end): -2
//Input error!
//Insert grade (-1 to end): 100
//Insert grade (-1 to end): 20
//Insert grade (-1 to end): 56
//Insert grade (-1 to end): 86
//Insert grade (-1 to end): 86
//Insert grade (-1 to end): -1
//
//Option: 1) Add. 2) Minimum. -1) Quit: 2
//Minimum: 20
//
//Option: 1) Add. 2) Minimum. -1) Quit: 1
//Insert grade (-1 to end): 72
//Insert grade (-1 to end): 14
//Insert grade (-1 to end): -1
//
//Option: 1) Add. 2) Minimum. -1) Quit: 2
//Minimum: 14
//
//Option: 1) Add. 2) Minimum. -1) Quit:
//
//
//請寫註解，並注意程式碼排版。
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;
public class prac1008 {


	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		int[] arrP = new int[10];
		Arrays.fill(arrP, -1);
		int nextIndexArrP = 0;
		int option = 0;

		do {
			System.out.print("\nOption: 1) Add. 2) Minimum. -1) Quit: ");
			option = scanner.nextInt();

			switch(option) {
			case 1:
				do {
					// append array
					if(nextIndexArrP == arrP.length - 1) {
						arrP = Arrays.copyOf(arrP, arrP.length * 2 );
						System.out.println("array append.");	
					}

					// input
					System.out.println("請輸入成績 : ");
					arrP[nextIndexArrP] = scanner.nextInt();

					// quit
					if(arrP[nextIndexArrP] == -1) {
						break;
					} else if(arrP[nextIndexArrP] < 0) {
						System.out.println("--> Error. <--");
					} else {
						nextIndexArrP++;
					}
				} while(true);
				break;

			case 2:
				// 判斷 陣列有無資料
				if(arrP[0] == -1) {
					System.out.println("--> 未輸入資料 <--");
				} else {
					System.out.println("minimum : " + RecursiveMinimum( arrP, nextIndexArrP ) );
				}
				break;

			case -1:
				System.out.println("結束");
				System.exit(0);
				break;

			default:
				System.out.println("--> Error.<--");
			}

		} while(true);

	}
	// function
	public static int RecursiveMinimum (int a[], int n) {
		int index = n - 1;
		//只有一筆資料
		if( n <= 1) {
			return a[index];
		}
		//有兩筆以上資料
		int min = RecursiveMinimum (a, n - 1);
		if(a[index] < min) {
			return a[index];
		} else {
			return min;
		}
	}
}
