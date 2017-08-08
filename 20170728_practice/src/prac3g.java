
//題目四：陣列的記憶體管理
//
//請寫一個程式讀入使用者所輸入正整數，接著統計數字出現的次數，並將其出現的次數以直方圖畫出。
//請用一個一維陣列來記錄數字出現的次數，例如假設陣列的名稱為freq	，當輸入10的時候，就執行「freq[10]++;」，執行範例如下(輸入部分以黑體字標註)：
//
//Input (-1 to end): 10
//Input (-1 to end): 10
//Input (-1 to end): -10
//Error!
//Input (-1 to end): 10
//Input (-1 to end): 3
//Input (-1 to end): 3
//Input (-1 to end): 5
//Input (-1 to end): 3
//Input (-1 to end): 5
//Input (-1 to end): 10
//Input (-1 to end): -1
//
//3	***
//5	**
//10	****
//
//請注意，如果使用者輸入的數字太大，導致你所使用的陣列長度不夠存的時候
//（例如原先你的陣列長度是100，因此索引最大到99。這時如果使用者輸入100，存取freq[100]將超出陣列範圍），你必須將你的陣列長度調大。
//如程式當中有此動作執行時，請順便印出「Array is resized!」的訊息。
import java.util.Arrays;
import java.util.Scanner;

public class prac3g {

	public static void main(String[] args) {
		// declare, initial
		Scanner scanner = new Scanner(System.in);

		// array
		int[] frequency = new int[3];
		int[] appearNum = new int[3];
		Arrays.fill(appearNum, -1);

		// variable
		int scanInput = -1;

		// #####
		// Begin
		// #####

		// input & check
		do {
			System.out.print("\n Input 'Postive' Integer (-1 to quit): ");
			scanInput = scanner.nextInt();

			// negative Int
			if (scanInput < -1) {
				System.out.println("\tError. \n\t-- Enter again --");
			} else {
				for (int i = 0; i < appearNum.length; i++) {

					// array resized
					if (i == appearNum.length - 1) {
						appearNum = Arrays.copyOf(appearNum, appearNum.length * 2);
						frequency = Arrays.copyOf(frequency, frequency.length * 2);
						System.out.println("Array is resized!!");
						appearNum[i] = -1;

					}
					// 無重複, 輸入
					if (appearNum[i] == -1) {
						appearNum[i] = scanInput;
						frequency[i] += 1;
						// 放數字, 頻率+1
						appearNum[i + 1] = -1;
						break;
					}
					// 重複, freq+1
					if (appearNum[i] == scanInput) {
						frequency[i] += 1;
						// 頻率+1
						appearNum[i + 1] = -1;
						break;
					}
				}
			}

		} while (scanInput != -1);// -1 --> break
		// print
		System.out.println("\nNum\ttimes");
		System.out.println("------------------------------");

		for (int i = 0; i < appearNum.length; i++) {
			// -1 即 中斷顯示
			if (appearNum[i] == -1)
				break;
			System.out.printf("%d\t", appearNum[i]);
			for (int j = 0; j < frequency[i]; j++)
				System.out.print("*");
			System.out.println("");
		}
		// recycle
		scanner.close();
	}

}
