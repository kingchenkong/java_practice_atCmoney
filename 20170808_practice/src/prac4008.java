//二元搜尋（二分搜尋）
//
//（二元搜尋，Binary Search）先將陣列排序後，則假如欲在陣列中找出到某一個數值，先比較陣列的中間值，如果比該中間值大，就代表此數應存在於比中間值大的那一半邊；
//如果比該中間值小，就代表此數應存在於比中間值小的那一半邊，因此我們就可以把搜尋範圍縮減一半，繼續以此模式繼續搜尋下去，直到找到為止；
//或者，如果發現範圍縮減到最後中間已經沒有數字了，但仍未找到該數字，即可知道該數字未存在於此陣列中。
//請利用一維陣列儲存使用者輸入的數字（介於0~100）並以 '氣泡排序法' 加以排序，接著撰寫一個遞迴的副函式binarySearch用以執行二元搜尋。其函式原型定義如下：
//
//public static void binarySearch(int a[], int key, int start, int end);
//
//陣列a為一個已排好序的數字陣列（數字介於0~100間），key為欲搜尋的數字，start與end為陣列的index，代表搜尋的起迄範圍。如果key存在於陣列a的start到end範圍中，便回傳1，否則回傳0；
//禁止使用全域變數，如果沒有用到遞迴者以零分計。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Option: 1) Add. 2) Binary Search. -1) Quit: 1
//Insert grade (-1 to end): 20
//Insert grade (-1 to end): 100
//Insert grade (-1 to end): 20
//Insert grade (-1 to end): 56
//Insert grade (-1 to end): 86
//Insert grade (-1 to end): 86
//Insert grade (-1 to end): -1
//
//Option: 1) Add. 2) Binary Search. -1) Quit: 2
//Key: 72
//'72' is not found!
//
//Option: 1) Add. 2) Binary Search. -1) Quit: 2
//Key: 20
//'20' is found!
//
//Option: 1) Add. 2) Binary Search. -1) Quit: 
//
//請寫註解，並注意程式碼排版。
import java.util.*;
public class prac4008 {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		int[] arr = new int[10];
		int newDataPos = 0;

		do {

			System.out.print("\nOption: 1) Add. 2) Binary Search. -1) Quit: ");
			int option = scanner.nextInt();
			if(option == -1) {
				System.out.println("Bye!");
				System.exit(0);
			} else if(option == 1) {
				// insert new data
				do {
					System.out.println("\nInsert grade (-1 to end): ");

					// append
					if(newDataPos == arr.length) {
						arr = Arrays.copyOf(arr, arr.length * 2);
						System.out.println("####################");
						System.out.println("#  arr is append.  #");
						System.out.println("####################");
					}

					//input
					arr[newDataPos] = scanner.nextInt();

					if(arr[newDataPos] == -1) {
						// end input
						break;
					} else if(arr[newDataPos] < 0 || arr[newDataPos] > 100) {
						// re-input
						System.out.println("  ---------------------- ");
						System.out.println("||     Error input.     ||");
						System.out.println("  ---------------------- ");
					} else {
						// data store
						// index ++
						newDataPos++;
					}

				} while(true);

				// sort
				myBubbleSort(arr);

				//test
//				System.out.println("test : arr = ");
//				for(int i = 0; i < arr.length; i++) {
//					System.out.print(arr[i] + ", ");
//				}

			} else if(option == 2) {
				// search
				System.out.print("\nKey: ");
				int key = scanner.nextInt();
				int isfound = binarySearch( arr, key, 0, newDataPos -1);
				if(isfound == 1) {
					System.out.println("'" + key +"' is found.");
				} else {
					System.out.println("'" + key +"' is NOT found.");
				}

			} else {
				// re-input
				System.out.println("  ---------------------- ");
				System.out.println("||     Error input.     ||");
				System.out.println("  ---------------------- ");			}

		} while(true);

	}
	// function
	public static int binarySearch(int a[], int key, int start, int end) {

		int isFound = 0;
		if(start <= end) {
			int mid = (start + end) / 2;
			if( a[mid] == key ) {
				// base condition
				//				System.out.println("'" + key +"' is found.");
				return 1;
			}
			if(a[mid] > key) {
				isFound = binarySearch( a, key, start, mid - 1);
			}
			if(a[mid] < key) {
				isFound = binarySearch( a, key, mid + 1, end);	
			}	


		} 
			//			System.out.println("'" + key +"' is NOT found.");
//			return 0;

		
		return isFound;
	}

	// bubble sort
	// （左）小到大（右）
	public static void myBubbleSort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				// 為 -1 則, 終止
				if(arr[j + 1] == -1) {
					break;
				}
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return;
	}
}
