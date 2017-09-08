//旋轉陣列
//
//對一個陣列進行向左旋轉的動作將會使得陣列元素往左邊位移。例如，假如對一個陣列[1, 2, 3, 4, 5]進行兩個單位的左旋，
//則結果將變成[3, 4, 5, 1, 2]。給一個有n個元素的陣列，以及一個位移量d，請用Java或C#撰寫一個函式如下：
//public static void leftRotation(int[] arr, int d);
//此函式傳入arr與一個位移量d，並對arr進行d個單位的左旋運算，其結果將直接寫入arr之中。請實作一個主函式類別並呼叫這個函式，以完成以下功能。
//
//輸入格式如下：
//第一行包含兩個數字，以空白隔開，分別代表陣列個數n與位移量d。第二行則是輸入陣列的內容，中間也是以空白隔開。 
//    
//輸出格式： 
//
//陣列的左旋運算結果。
//
//數據範圍：  
//
//1 <= n <= 105  
//1 <= d <= n
//1 <= arr[i] <= 106
//
//範例輸入：  
//5 4
//1 2 3 4 5
//
//範例輸出：  
//5 1 2 3 4
//
//
//請重新撰寫此程式，同時在時間複雜度與空間複雜度必須皆為O(n)與O(1)。

import java.util.Scanner;

public class leftRotationArray {

	// static
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int count = 0;	// 資料筆數
		int shift = 0;	// 位移

		System.out.println("Input count:");
		count = sc.nextInt();
		System.out.println("Input diff:");
		shift = sc.nextInt();
		int[] arr = new int[count];
		System.out.println("input arr(" + count + " 筆): ");
		for(int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		leftRotation(arr, shift);
		printArr(arr, count);
	}
	public static void leftRotation(int[] arr, int d) {
		// modify shift
		if(d == 0 || d % arr.length == 0)
			return;
		while(d < 0)
			d += arr.length;
		while( d > arr.length)
			d -= arr.length;
		// declare
		int collisionIndex = 0;
		int nowIndex = 0;
		int nextIndex = 0;
		int temp = arr[nowIndex];
		int temp2 = 0;
		// 時間複雜度, O(n)
		for(int i = 0; i < arr.length; i++) {
			// set nextIndex
			nextIndex -= d;
			if(nextIndex < 0)
				nextIndex += arr.length;
			else if(nextIndex >= arr.length)
				nextIndex -= arr.length;
			// rotation
			temp2 = arr[nextIndex];
			arr[nextIndex] = temp;
			temp = temp2;
			// set nowIndex
			nowIndex = nextIndex;
			// check collision, if true => set new collisionIndex
			if(nowIndex == collisionIndex && nowIndex < arr.length) {
				nowIndex += 1;
				temp = arr[nowIndex];
				nextIndex = nowIndex;
				collisionIndex = nowIndex;
			}
		}
	}
	public static void swap(int[] arr, int souIndex, int desIndex) {
		int temp = arr[desIndex];
		arr[desIndex] = arr[souIndex];
		arr[souIndex] = temp;
	}
	public static void printArr(int[] arr, int d) {
		for(int i = 0; i < d; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
