import java.util.Scanner;

public class devtest {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrayThisRoundNum = new int[5];

		for (int i = 0; i < 10; i++) {
			int numIndex = 0;
			do {
				int thisRoundNum = 0;
				thisRoundNum = ((int) (Math.random() * 32)) + 1;
				if (isDuplicated(thisRoundNum, arrayThisRoundNum) == 1) {
					continue;
				} else {
					arrayThisRoundNum[numIndex] = thisRoundNum;
					numIndex++;
				}
				if (numIndex == arrayThisRoundNum.length - 1) {
					break;
				}
			} while (true);
			showArray(arrayThisRoundNum);

		}

	}

	// 判斷key是否有在陣列s當中，如果有重複的數字，請回傳1，否則回傳0

	// 判斷重複
	public static int isDuplicated(int key, int[] s) {

		for (int i = 0; i < s.length; i++) {
			if (s[i] == key) {
				return 1;
			}
		}
		return 0;
	}

	// 呼叫此函數來比對簽注的數字myNumbers是否與開出的數字lottoNumbers相同；
	// 對中參獎回傳3；對中二獎回傳2；對中頭獎回傳1；否則回傳0

	// 兌獎
	public static int Match(int[] myNumbers, int[] lottoNumbers) {
		return 0;
	}

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
