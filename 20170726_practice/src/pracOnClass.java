import java.util.Scanner;
import java.util.Arrays;
public class pracOnClass {

	public static void main(String[] args) {
		//declare, initial
		Scanner scanner = new Scanner(System.in);


		int[] arrayForSort = { 25, 10 , 0, 39, 40, 33, 12};

		//###########
		//	氣泡排序
		//###########
		//排序前 顯示
		System.out.print("排序前: arrayForSort = { ");
		for(int i = 0; i < arrayForSort.length; i++) {
			if (i == arrayForSort.length - 1) {
				System.out.print( arrayForSort[i] );
			} else {
				System.out.print(arrayForSort[i] + ", ");

			}
		}
		System.out.println("}");
		//氣泡排序
		for(int i = 1; i < arrayForSort.length; i++) {
			for(int j = 0; j < arrayForSort.length - i; j++) {
				if( arrayForSort[j] > arrayForSort[j+1]) {
					int temp = arrayForSort[j];
					arrayForSort[j] = arrayForSort[j+1];
					arrayForSort[j+1] = temp;
				}
			}
		}

		//排序後 顯示
		System.out.print("排序前: arrayForSort = { ");
		for(int i = 0; i < arrayForSort.length; i++) {
			if (i == arrayForSort.length - 1) {
				System.out.print( arrayForSort[i] );
			} else {
				System.out.print(arrayForSort[i] + ", ");

			}
		}
		System.out.println("}");

		//###########
		//	循序搜尋
		//###########
		int[] arrayForSearch = { 25, 10 ,39, 40, 33, 12};
		//搜尋前 顯示
		System.out.print("arrayForSearch = { ");
		for(int i = 0; i < arrayForSearch.length; i++) {
			if (i == arrayForSort.length - 1) {
				System.out.print( arrayForSearch[i] );
			} else {
				System.out.print(arrayForSearch[i] + ", ");

			}
		}
		System.out.println("}");
		System.out.print("請輸入要搜尋的數字: ");
		int key = scanner.nextInt();
		boolean notSearch = true;
//		int pos = 0;	//陣列停住的位置
		for(int pos = 0; pos < arrayForSearch.length; pos++) {
			if( arrayForSearch[pos] == key ) {
				System.out.println("index = " + pos);
				notSearch = false;
				break;
			}
			
		}
		if(notSearch) {
			System.out.println("不再陣列中!");
		}
		



		//recycle
		scanner.close();
	}

}
