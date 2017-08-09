//線性搜尋
//（線性搜尋，Linear Search）線性搜尋法是指，一個一個搜尋陣列中的元素直到找到欲搜尋的數值為止。
//請設計一個程式要求使用者輸入數字（介於0~100）並存入陣列中，再撰寫一個遞迴函式LinearSearch用以執行線性搜尋。其函式原型定義如下：
//
//public static int LinearSearch (int a[], int key, int n);
//
//陣列a為一個數字陣列，n表示搜尋陣列的範圍為前n個數字。
//如果key存在於陣列a中索引0至n-1的範圍內，便回傳所在的index，否則回傳-1；
//禁止使用全域變數，如果沒有用到遞迴者以零分計。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Option: 1) Add. 2) Search. -1) Quit: 1
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
//Option: 1) Add. 2) Search. -1) Quit: 2
//Key: 72
//'72' is not found!
//
//Option: 1) Add. 2) Search. -1) Quit: 2
//Key: 20
//'20' is found!
//
//Option: 1) Add. 2) Search. -1) Quit: 
//
//
//請寫註解，並注意程式碼排版。
import java.util.*;
public class prac2008 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrP = new int[10];
		Arrays.fill(arrP, -1);
		int nextIndexArrP = 0;
		int option = 0;

		do {
			System.out.print("\nOption: 1) Add. 2) Search. -1) Quit: ");
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
					System.out.println("請輸入（介於0~100）的整數 : ");
					arrP[nextIndexArrP] = scanner.nextInt();

					// quit
					if(arrP[nextIndexArrP] == -1) {
						break;
					} else if(arrP[nextIndexArrP] < 0 || arrP[nextIndexArrP] > 100) {
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
					int key = 0;
					do {
						System.out.print("key : ");
						key = scanner.nextInt();
						if(key < 0 || key > 100) {
							System.out.println("--> Error. <--");
						} else {
							break;
						}
					} while(true);

					int index = LinearSearch( arrP, key, nextIndexArrP );
					if(index == -1) {
						System.out.println("'" + key + "' is not found.");
					} else {
//						System.out.println("is at " + index);
//						System.out.println("arrP[" + index +"] = " + arrP[index]);
						System.out.println("'" + key + "' is found !!!");
					}
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
	//function
	public static int LinearSearch (int a[], int key, int n) {
		int index = n - 1;

		if(index == 0) {
			if(a[index] == key) {
				return index;
			} else {
				return -1;
			}
		}
		if(key == a[index]) {
			return index;
		} else {
			return LinearSearch( a, key, n - 1);
		}
	}

}
