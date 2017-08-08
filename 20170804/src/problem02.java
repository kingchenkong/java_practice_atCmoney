
//要求使用者輸入10個整數數字（有正有負），再另外輸入一個數字n，請寫程式以回答這串數字中哪兩個非零的數字相加的結果與n最接近？
//又是哪三個非零的數字相加的結果與n最接近？
//如恰好有兩組以上相加結果符合答案，僅需要顯示其中一組即可（輸入範例如黑體字標註）。
//Numbers: -1 9 8 2 6 0 -2 -3 4 2
// -1 9 8 2 6 0 -2 -3 4 2 
//n (-1 to quit): 3
//Answer 1 (two numbers): -1 4
//Answer 2 (three numbers): -3 4 2
//
//n (-1 to quit):

import java.util.Scanner;

public class problem02 {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// test
		// int[] arrayTest = { -1, 9, 8, 2, 6, 0, -2, -3, 4, 2};
		// showArray(arrayTest);

		// Begin
		int[] arrayNum = new int[10];
		int inputN = 0;
		System.out.print("\n Numbers: ");
		for (int i = 0; i < arrayNum.length; i++) {
			arrayNum[i] = scanner.nextInt();
		}
		System.out.println("");

		do {
			System.out.println("\n N (-1 to quit):");
			inputN = scanner.nextInt();

			int d = 0;
			int maxDistance = 0;
			int minDistance = 0;

			for (int j = 0; j < arrayNum.length; j++) {
				for (int i = 0; i < arrayNum.length; i++) {
					if ((arrayNum[i] == 0) || (arrayNum[j] == 0)) {
						continue;
					}
					if ((arrayNum[i] == arrayNum[j])) {
						continue;
					}
					if (i == j) {
						continue;
					}
					int tempSum = arrayNum[i] + arrayNum[j];
					d = 0;
					d = inputN - tempSum;
					if (d < 0) {
						d = -1 * d;
					}
					if (d > maxDistance) {
						maxDistance = d;
					}
				}
			}
			System.out.println("d = " + d);
			System.out.println("minD = " + minDistance);
			// Exit
			if (inputN == -1) {
				System.out.println("Bye!");
				System.exit(0);
			}
			System.out.println("\n 哪兩個非零的數字相加的結果與n最接近");
			int aIndex = 0, bIndex = 0;
			// 最近的兩數的index
			int sum = 0;
			// 和
			minDistance = maxDistance;

			for (int i = 0; i < arrayNum.length; i++) {
				for (int j = 0; j < arrayNum.length; j++) {
					if ((arrayNum[i] == 0) || (arrayNum[j] == 0)) {
						continue;
					}
					if ((arrayNum[i] == arrayNum[j])) {
						continue;
					}
					if (i == j) {
						continue;
					}
					sum = arrayNum[i] + arrayNum[j];
					d = 0;
					d = inputN - sum;
					if (d < 0) {
						d = -1 * d;
					}
					if (d < minDistance) {
						minDistance = d;
						aIndex = i;
						bIndex = j;
					}
				}
			}
			System.out.println("\n 相加 最接近 Ｎ 的 兩數 : " + arrayNum[aIndex] + ", " + arrayNum[bIndex]);

			for (int k = 0; k < arrayNum.length; k++) {
				for (int j = 0; j < arrayNum.length; j++) {
					for (int i = 0; i < arrayNum.length; i++) {
						if ((arrayNum[i] == 0) || (arrayNum[j] == 0) || (arrayNum[k] == 0)) {
							continue;
						}
						if ((arrayNum[i] == arrayNum[j]) || (arrayNum[i] == arrayNum[k])
								|| (arrayNum[k] == arrayNum[j])) {
							continue;
						}
						if ((i == j) || (i == k) || (k == j)) {
							continue;
						}
						int tempSum = arrayNum[i] + arrayNum[j] + arrayNum[k];
						d = 0;
						d = inputN - tempSum;
						if (d < 0) {
							d = -1 * d;
						}
						if (d > maxDistance) {
							maxDistance = d;
						}
					}
				}
			}
			System.out.println("maxDistance = " + maxDistance);

			minDistance = maxDistance;
			int cIndex = 0;
			for (int k = 0; k < arrayNum.length; k++) {
				for (int i = 0; i < arrayNum.length; i++) {
					for (int j = 0; j < arrayNum.length; j++) {
						if ((arrayNum[i] == 0) || (arrayNum[j] == 0) || (arrayNum[k] == 0)) {
							continue;
						}
						if ((arrayNum[i] == arrayNum[j]) || (arrayNum[i] == arrayNum[k])
								|| (arrayNum[k] == arrayNum[j])) {
							continue;
						}
						if ((i == j) || (i == k) || (k == j)) {
							continue;
						}
						sum = arrayNum[i] + arrayNum[j] + arrayNum[k];
						d = 0;
						d = inputN - sum;
						if (d < 0) {
							d = -1 * d;
						}
						if (d < minDistance) {
							minDistance = d;
							aIndex = i;
							bIndex = j;
							cIndex = k;
						}
					}
				}
			}
			System.out.println(
					"\n 相加 最接近 Ｎ 的三個非零數" + arrayNum[aIndex] + ", " + arrayNum[bIndex] + ", " + arrayNum[cIndex]);

		} while (true);

	}

	// function
	// - print Array
	public static void showArray(int[] arr) {
		System.out.print("\n array => {");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.println(arr[i] + " }");
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}

	// 3 - 氣泡排序法 - bubble sort
	public static void bubble_Sort(int array[], boolean bigToSmall) {
		int temp = 0;
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length - j - 1; i++) {
				// true, big to small
				if ((array[i] > array[i + 1]) && bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				// false, small to big
				if ((array[i] < array[i + 1]) && !bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}

}
