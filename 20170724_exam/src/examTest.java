import java.util.Scanner;

public class examTest {

	public static void main(String[] args) {
		// Declare, Initial
		Scanner scanner = new Scanner(System.in);

		// #############
		// #############
		// problem - 1
		// #############
		// #############
		System.out.println("Q1: ");
		int numerator = 1, dominator = 1;
		int q1min, GCD;
		System.out.println("請輸入分子：");
		// numerator = scanner.nextDouble(); //---- 行 10 - 改為 .nextInt();
		numerator = scanner.nextInt();
		do {
			System.out.println("請輸入分母：");
			dominator = scanner.nextInt();
			// if (dominator = 0) //---- 行 14 - 要用 ==
			if (dominator == 0)
				System.out.println("分母不可為0!");
			// } while (dominator == 0) //---- 行 16 - 沒有分號
		} while (dominator == 0);
		q1min = dominator;
		if (numerator > dominator)
			q1min = numerator;

		GCD = 1;
		// for (int q1i = 2, q1i <= q1min, q1i++) { //---- 行 21 - 要用分號 ; 不是逗號 ,
		for (int q1i = 2; q1i <= q1min; q1i++) {
			// if (numerator % q1i == 0 || dominator % q1i == 0) { //---- 行 22 -
			if (numerator % q1i == 0 && dominator % q1i == 0) {
				if (q1i > GCD) // ---- 行 23 - GCD要初始化
					GCD = q1i;
			}
		}
		switch (numerator) {
		case 0:
			System.out.println("0");
			// ---- 行 30 - 沒有 break;
			break;

		default:
			// System.out.print("最簡分數: %f / %f\n", numerator / GCD, dominator / GCD); //----
			// 行 32 - 要使用 printf, 以及 %d
			System.out.printf("最簡分數: %d / %d\n", numerator / GCD, dominator / GCD);
		}

		// #############
		// #############
		// problem - 2
		// #############
		// #############
		System.out.println("Q2: ");

		int q2k, q2i = 0, q2sum = 0;
		for (q2k = 0; q2k < 5; q2k++) {
			if (q2k % 2 == 1)
				q2sum = q2sum + (q2i++);
			else
				q2sum = q2sum + (++q2i);
		}
		System.out.printf("Sum: %d, i: %d\n", q2sum, q2i);

		// #############
		// #############
		// problem - 3
		// #############
		// #############
		System.out.println("Q3: ");
		System.out.println("輸入一個正整數: ");
		int q3input = scanner.nextInt();
		int q3count = 0, q3ans = 0;
		if (q3input <= 2) {
			System.out.println("Error.");
		} else if (q3input == 3) {
			System.out.println("is 2");
		} else {
			for (int q3i = 3; q3i < q3input; q3i++) {
				for (int q3j = 2; q3j < q3i / 2; q3j++) {
					if (q3i % q3j == 0) {
						q3count += 1;
					}
				}
				if (q3count == 0) {
					q3ans = q3i;
				}
				q3count = 0;
			}
			System.out.println("is " + q3ans);
		}

		// #############
		// #############
		// problem - 4
		// #############
		// #############
		System.out.println("Q4: ");
		System.out.println("輸入一個正整數: ");

		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int k = 0; k < 2 * (i - 1) + 1; k++) {
				if (i == (n - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			if (i > 0) {
				System.out.print("*\n");
			} else {
				System.out.print("\n");
			}
		}

		// #############
		// #############
		// problem - 5
		// #############
		// #############
		System.out.println("Q5: ");
		int q5n = 0, q5count = 0, q5mul = 1, q5max = 1, q5second = 1;
		int q5input = 0;

		q5n = scanner.nextInt();
		for (int q5i = 0; q5i < q5n; q5i++) {
			q5input = scanner.nextInt();
			q5count += 1;
			if (q5input == -1) {
				break;
			}
			if (q5input < 0) {
				q5input *= -1;
			}
			if (q5input > q5max) {
				q5second = q5max;
				q5max = q5input;
			} else if (q5input > q5second) {
				q5second = q5input;
			}

			System.out.println("i = " + q5i + ", input = " + q5input + ", max = " + q5max + ", second = " + q5second);
		}
		if (q5n < 1) {
			System.out.println("未輸入");
		} else if ((q5count < 2) && (q5input == -1)) {
			System.out.println("未輸入");

		} else {
			q5mul = q5max * q5second;
			System.out.println("maxMul = " + q5mul);
		}

		// Recycle
		scanner.close();
	}

}
