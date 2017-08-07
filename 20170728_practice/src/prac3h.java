//題目
//螺旋矩陣
//問題描述 
//螺旋矩陣是一個短陣，其中每個 cell 都填滿整數，且每個整數以螺旋的方式排列。
//下圖為二個 size = 8 的螺旋矩陣。觀查圖 (a) ，數字由 1 開始，以逆時鐘的方向，螺旋狀地往中心排列。
//而圖 (b) 則是一個順時鐘的螺旋矩陣，和圖 (a) 不一樣之處在於其數字的旋轉方向為順時鐘旋轉。 
//請寫一個程式，接受輸入，並將螺旋矩陣印出。 
//輸入說明： 
//輸入為一行字串，包含了兩個數值，每個數值以逗點隔開。 
//第一個數值為 size ，其值介於 1 到 30 間（ i.e., 1 <= size <= 30 ）。 
//第二個數值為方向， 1 為順時鐘方向， 2 為逆時鐘方向。 
//輸出說明： 
//將螺旋矩陣輸出。每個數字的寬度為 3 ，不足寬度之處補 0 （也就是說，數字 1 要印輸出成 001 ，數字 12 要輸出成 012 …依此類推）。
//每個數字後要加一個逗點，數字間不要有空白。每一 row 的最後一個數字之後不要加逗點。 
//如採用Java實作，你可以使用System.out.printf進行格式化，例如如果要印出整數，格式化轉換符號可使用「%d」，如要印出寬度為5且不足填0的整數，則格式化轉換符號可使用「%05d」

import java.util.Arrays;
import java.util.Scanner;
public class prac3h {

	public static void main(String[] args) {
		//declare, initial
		Scanner scanner = new Scanner(System.in);

		//array
		int[][] arrayTest;
		int[][] arrayRotate;

		//variable
		int arraySize = 0;


		//#####
		//Begin
		//#####
		System.out.println("\t\t-- 螺旋矩陣 --");

		// input & check
		do {
			System.out.print("請輸入需要的大小: ");
			System.out.println("");
			arraySize = scanner.nextInt();


		} while( arraySize < 1 );	//[...-2, -1, 0] 重新輸入

		// arraySize = 1
		if(arraySize == 1) {
			System.out.println("001");
		} else {
			//arraySize > 1

			//##########
			// part. I
			//##########
			System.out.printf("size 為 '%2d' 的 螺旋矩陣\n", arraySize);
			//array initial
			arrayRotate = new int[arraySize][arraySize];

			for(int i = 0; i < arrayRotate.length; i++)
				Arrays.fill(arrayRotate[i], -1);

			//array position & value setting
			int nowCircle = 0;
			int count = 1;
			int j = 0, k = 0;
//			for(int i = 1; i <= (arrayRotate.length * arrayRotate.length); i++) {
			for(int i = 0; i < arrayRotate.length; i++) {
				
				for( ; j < (arrayRotate.length - nowCircle); j++, count++) {
					arrayRotate[k][j] = count;
				}
				k += 1;
				j -= 1;
				for( ; k < (arrayRotate.length - nowCircle); k++, count++) {
					arrayRotate[k][j] = count;
				}
				j -= 1;
				k -= 1;
				for( ; j >= nowCircle; j--, count++) {
					arrayRotate[k][j] = count;
				}
				j += 1;
				k -= 1;
				for( ; k > nowCircle; k--, count++) {
					arrayRotate[k][j] = count;
				}
				j += 1;
				k += 1;
				
				nowCircle += 1;
				if(count > (arraySize * arraySize) ) {
					break;
				}
			}

			// array print
			for(int i = 0; i < arraySize; i++) {
				for(int a = 0; a < arraySize; a++) {
					//補 '0'
					System.out.print(" ");
					if(arrayRotate[i][a] < 100)
						System.out.print("0");
					if(arrayRotate[i][a] < 10)
						System.out.print("0");

					if(j == arraySize - 1){
						System.out.printf("%d", arrayRotate[i][a]);
					} else {
						System.out.printf("%d,", arrayRotate[i][a]);
					}

				}
				System.out.println("");
			}




		}
		//End
		System.out.println("");
		System.out.println("is Over.");

		//recycle
		scanner.close();
		arrayTest = null;
		arrayRotate = null;

	}

}
