
//請輸入兩個正數字代表分數的分子(numerator)與分母(denominator)，請輸出分子分母的最大公因數。
//如果輸入的數字不為正，請印出錯誤訊息，並要求重新輸入。執行範例如下（使用者輸入者以粗體字標示）：
//Enter numerator: 12
//Enter denominator: 0
//Error!
//
//Enter numerator: 12
//Enter denominator: -16
//Error!
//
//Enter numerator: 12
//Enter denominator: 16
//Answer: 4

import java.util.Scanner;

public class prac6c {
	// 全域使用
	public static Scanner scanner = new Scanner(System.in);

	// main
	public static void main(String[] args) {
		// declare, initialize
		int inputNum1;
		int inputNum2;

		// Begin
		System.out.print("\nEnter Numerator :");
		inputNum1 = scanIntAndCheckIsPos();
		System.out.print("\nEnter Denominator: ");
		inputNum2 = scanIntAndCheckIsPos();
		System.out.println("Answer :" + getGCD(inputNum1, inputNum2));
		// End

	}

	// function
	public static int getGCD(int numerator, int denomenator) {
		int min = 0, GCD = 1;
		if (numerator < denomenator) {
			min = numerator;
		} else {
			min = denomenator;
		}
		for (int i = 2; i < min; i++) {
			if (numerator % i == 0) {
				if (denomenator % i == 0) {
					GCD = i;
					System.out.println("GCD = " + i);
				}
			}
		}
		return GCD;
	}

	public static int scanIntAndCheckIsPos() {
		int x = 0;
		do {
			x = scanner.nextInt();
			if (x < 1) {
				System.out.println(" --> Error <-- \n re-Enter:");

			} else {
				break;
			}
		} while (true);
		return x;
	}
}
