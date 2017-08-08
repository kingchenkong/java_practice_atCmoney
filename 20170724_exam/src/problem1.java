
//題目
//請撰寫一個程式，要求使用者輸入一個正整數（前提假設為正整數，可不用考慮例外情況）用來計算此數字每個位數的乘積。
//例如輸入356，程式即輸出3 * 5 * 6的結果。執行範例如下（粗體字表使用者輸入的部分）： 
//
//Input (-1 to quit)：356
//Output：90
//
//Input (-1 to quit)：1000
//Output：0
//
//Input (-1 to quit)：-1
//Bye!

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		// Declare, Initial
		Scanner scanner = new Scanner(System.in);
		// Initial
		int n = 0;
		int temp = 0;
		int mul = 1;
		int count = 0;

		do {
			// prompt to user input
			System.out.print("Input (-1 to quit)： ");
			n = scanner.nextInt();
			System.out.println("");

			// exit program
			if (n == -1) {
				break;
			}
			// test
			// System.out.println("n = " + n);
			if (n != 0) {
				// 幾位數？
				temp = n;
				for (int i = 1; i <= n; i++) {
					temp /= 10;
					count += 1;
					// test
					// System.out.println("at i =" + i + ", temp / 10 = " + temp + ", count = " +
					// count);
					if (temp == 0) {
						break;
					}
				}
				// System.out.println("##############################");

				// reset
				temp = 0;
				mul = 1;

				// 乘積
				for (int j = 0; j < count; j++) {
					temp = n % 10;
					n /= 10;
					mul *= temp;

					// test
					// System.out.println("at j = " + j + ", temp = " + temp + ", n/10 = " + n + ",
					// mul = " + mul);

				}
				System.out.println("Output :" + mul + "\n");
			} else {
				System.out.println("Output : 0\n");

			}

			// reset count
			count = 0;

		} while (n >= 0);
		// quit
		System.out.println("Bye!");

		// Recycle
		scanner.close();
	}

}
