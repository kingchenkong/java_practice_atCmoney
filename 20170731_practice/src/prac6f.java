import java.util.*;
public class prac6f {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		int array1[] = {33,41,52,54,63,74,79,86};
		showArray(array1);
		System.out.print("請輸入要查詢的值: ");
		int findNum = scanner.nextInt();
		System.out.println("");
		bubble_Sort(array1, true); // true, big to small
		System.out.println(findNum + " at array[ " + binary_Search(array1, findNum) + " ]");

	}
	//##########
	// function
	//##########
	// 2 - 二分搜尋法 - binary search
	public static int binary_Search(int list[], int keyValue) {
		int left = 0, right = list.length - 1;
		int middle; // searching index, 搜尋中的索引值
		if(list[0] <= list[list.length - 1]) { 
			while(left <= right) {
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
