
//找出最大、最小及平均值
//
//一、程式範例描述：
//輸入一個正整數 n，輸入 n 個整數，輸出此 n 個整數最大、最小及平均值。
//
//二、輸入說明：
//輸入一個正整數 n，輸入 n 個整數 (0 < n < 2147483647)
//
//三、輸出說明：
//輸出 n 個整數中其最大、最小及平均值
//
//四、輸入範例：
//6
//24
//53
//52
//74
//34
//22
//
//五、輸出範例： 
//Maximum =74 
//Minimum=22 
//Mean=43.167

import java.util.Scanner;

public class prac6b {

	public static void main(String[] args) {
		// declare, initialize
		Scanner scanner = new Scanner(System.in);
		int needQuantity = 0;
		int[] arrayIntSet;

		// 需要多少
		while (needQuantity == 0) {
			System.out.print("請輸入需要幾個數?\t");
			needQuantity = scanner.nextInt();
			System.out.print("");

			// input error, reset
			if (needQuantity < 1) {
				System.out.println(" --> Error <-- ");
				needQuantity = 0;
			}
		}

		// needQuantity個
		arrayIntSet = new int[needQuantity];
		for (int i = 0; i < needQuantity; i++) {
			arrayIntSet[i] = scanner.nextInt();
		}

		// print - func
		printMax(arrayIntSet);
		printMin(arrayIntSet);
		printAv(arrayIntSet);

		// recycle
		scanner.close();
	}

	// function
	public static void printMax(int[] arrayPara) {
		int max = 0;
		for (int i = 0; i < arrayPara.length; i++) {
			if (max < arrayPara[i])
				max = arrayPara[i];
		}
		System.out.println("Maximum = " + max);

	}

	public static void printMin(int[] arrayPara) {
		int min = arrayPara[0];
		for (int i = 0; i < arrayPara.length; i++) {
			if (min > arrayPara[i])
				min = arrayPara[i];
		}
		System.out.println("Minimum = " + min);
	}

	public static void printAv(int[] arrayPara) {
		int average = 0;
		for (int i = 0; i < arrayPara.length; i++) {
			average += arrayPara[i];
		}
		average /= arrayPara.length;
		System.out.println("Average = " + average);
	}

}
