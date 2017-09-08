//插入排序法
//
//利用陣列撰寫一個程式，用來儲存學生成績（介於0~100），輸入後將陣列排序後輸出排序結果與名次。
//請撰寫一個遞迴副函式用以實作插入排序法（Insertion Sort）來將陣列中的數字排序；其函式原型如下：
//
//public static void insertionSort(int a[], int n);
//
//其中陣列a代表儲存輸入的數字，n代表陣列a中的前n個數字。
//注意：禁止宣告全域變數，如果沒有用到遞迴者以零分計。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Option: 1) Add. 2) Insert Sort. -1) Quit: 1
//Insert grade (-1 to end): 20
//Insert grade (-1 to end): 100
//Insert grade (-1 to end): 20
//Insert grade (-1 to end): 56
//Insert grade (-1 to end): 86
//Insert grade (-1 to end): 86
//Insert grade (-1 to end): -1
//
//Option: 1) Add. 2) Insert Sort. -1) Quit: 2
//Before sorting:
//20 100 20 56 86 86
//
//After sorting:
//20 20 56 86 86 100
//
//Option: 1) Add. 2) Insert Sort. -1) Quit: 
//
//
//請寫註解，並注意程式碼排版。
import java.util.*;
public class prac5008 {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		int[] arr = new int[10];
//		int[] arr = { 20, 100, 19, 86, 85, 82, 56, -1, 0, 0};
		int newDataPos = 0;

		do {
			System.out.print("\nOption: 1) Add. 2) Insert Sort. -1) Quit: ");
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

				// print
				System.out.println("before 'Sort' :");
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + ", ");
				}

			} else if(option == 2) {
				// no input
				if(newDataPos == 0) {
					System.out.println("is Empty.");
				} else {
					// sort
					insertionSort( arr, newDataPos);

					// print
					System.out.println("after 'Sort' :");
					for(int i = 0; i < newDataPos; i++) {
						System.out.print(arr[i] + ", ");
					}
				}

			} else {
				// re-input
				System.out.println("  ---------------------- ");
				System.out.println("||     Error input.     ||");
				System.out.println("  ---------------------- ");			
			}

		} while(true);


//		for(int i = n - 1; i >= 0; i--) {
//			for(int j = 0; j < i; j++ ) {
//				if(a[i] < a[j]) {
//					int min = a[i];
//					//全部往後排
//					for(int k = i; k > j; k--) {
//					a[k] = a[k-1];
//					}
//					//插入最小的
//					a[j] = min;
//					
//				}
//			}
//		}


	}
	// function
	// insertion sort
	//（左）小到大（右）
	public static void insertionSort(int a[], int n) {
		int index = n - 1;

		// base
		if(n == 1) {
			return;
		} 
		
		// 
		if(n > 1) {
			insertionSort( a, n - 1);
		}
		
		for(int i = 0; i < n; i++) {
			if(a[index] < a[i]) {
				int temp = a[index];
				for(int j = index; j > i; j-- ) {
				a[j] = a[j - 1];	
				}
				a[i] = temp;
			}
		}
		return ;
	}
}
