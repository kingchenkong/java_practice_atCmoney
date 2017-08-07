import java.util.*;
public class pracOnClass {
	public static Scanner scanner = new Scanner(System.in);
	public static int count = 0;
	public static void main(String[] args) {
		//declare, initial
		int[] arrayS = new int[10];

		//產生 10個隨機數 in陣列

		for(int i = 0 ; i < arrayS.length; i++) {
			arrayS[i] = (int)(Math.random() * 100) + 1;
		}
		showArray(arrayS);
		//隨機取某位置
		int randomPos =  (int) (Math.random() * arrayS.length);
		System.out.println("randomPos = " + randomPos + ", array[randomPos] = " + arrayS[randomPos]);

		// 1 - 循序搜尋
		for(int i = 0; i < 5; i++) {
			randomPos =  (int) (Math.random() * arrayS.length);
			int wannaNum = arrayS[randomPos];

			count = 0;
			System.out.printf("%d,\tarrayForSearch[ %d ],\n\t\t\t find %d times\n", wannaNum, sequential_Search(arrayS, wannaNum),  count);
		}
		//############################################################
		//		java - 內建
		//		所屬類別：java.util.Arrays
		//		語法：public static int binarySearch(int[] a,int key)
		//		功能：二分搜尋。
		//
		//############################################################
		//
		// 2 - 二分搜尋法
		// 須經過 '排序' 再搜尋
		// so 先bubble sort
		bubble_Sort(arrayS, true); // (int[] array, boolean bigToSmall)
		//檢視結果
		showArray(arrayS);

		//搜尋
		for(int i = 0; i < 5; i++) {
			randomPos =  (int) (Math.random() * arrayS.length);
			int wannaNum = arrayS[randomPos];

			count = 0;
			System.out.printf("%d,\tarrayForSearch[ %d ],\n\t\t\t find %d times\n", wannaNum, binary_Search(arrayS, wannaNum),  count);
		}

		//test
		System.out.printf(" Color %10s", "##");
		

	}
	//##########
	// function
	//##########

	// 1 - 循序搜尋法 - sequential search
	public static int sequential_Search (int list[], int keyValue) {
		for(int pos = 0; pos < list.length; pos++) {
			if(list[pos] == keyValue) {
				return pos;	//找到 的位置
			} 
			count +=1;
		}
		return -1; //沒有找到
	}
	// 2 - 二分搜尋法 - binary search
	public static int binary_Search(int list[], int keyValue) {
		int left = 0, right = list.length - 1;
		int middle; // searching index, 搜尋中的索引值
		if(list[0] <= list[list.length - 1]) { 
			while(left <= right) {
				count += 1;
				middle = (left + right) / 2;
				if(keyValue == list[middle]) {
					return middle;
					//[ "0", 1, 2, 3, "4", 5, 6, 7, 8, "9"]
					//  left			middle		   right
				}
				//沒找到,調整位置
				if(keyValue > list[middle]) {
					left = middle + 1;
					//[     "5",    	 "6", 		7, 		"8"]
					//     left     middle             right
				} else {
					right = middle - 1;
					//[       "1",        "2",        "3", ]
					//       left      middle        right
				}
			}
		} else {
			while(left <= right) {
				count += 1;
				middle = (left + right) / 2;
				if(keyValue == list[middle]) {
					return middle;
				}
				//沒找到,調整位置
				if(keyValue > list[middle]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				} 
			}
		}


		return -1;	//沒有找到
	}
	//	3 - 氣泡排序法 - bubble sort 
	public static void bubble_Sort (int array[], boolean bigToSmall) {
		int temp = 0;
		for(int j = 0; j < array.length; j++) {
			for(int i = 0; i < array.length - j - 1; i++) {

				//big to small
				if( (array[i] > array[i+1]) && bigToSmall) {
					temp = array[i];
					array[i] = array[i+1];
					array[i + 1] = temp;
				}
				//small to big
				if( (array[i] < array[i+1]) && !bigToSmall) {
					temp = array[i];
					array[i] = array[i+1];
					array[i + 1] = temp;
				}
			}
		}


		return;	//離開
	}
	//##########
	// - show array
	public static void showArray (int array[]) {
		System.out.print("arrray = { ");
		for(int i = 0 ; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.println(array[i] + " }");
			} else {
				System.out.print(array[i] +", ");
			}
		}
		return;
	}

}
