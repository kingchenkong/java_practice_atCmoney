import java.util.Scanner;

public class prac3e {

	public static void main(String[] args) {
		/*
		 * 判斷回文數 請撰寫一個C程式，要求使用者輸入一個 5 位數，判斷它是不是回文數。例如，12321 是回文數；其中個位與萬位相同，十位與千位相同。
		 * 請以if…else選擇結構完成本題目，禁止使用陣列。 執行範例如下（使用者輸入者以粗體字標註）： Input number: 12321 Result:
		 * yes
		 */
		Scanner scanner = new Scanner(System.in);
		int numScan, num5d, num4d, num3d, num2d, num1d;

		System.out.println("請輸入一個 '5位數':");
		numScan = scanner.nextInt();

		// 判斷是否為 5位數
		if ((numScan < 10000) || (numScan > 99999)) {
			System.out.println("不是五位數");
		} else {
			// 是五位數
			num5d = numScan / 10000;
			num4d = numScan / 1000 % 10;
			num3d = numScan / 100 % 10;
			num2d = numScan / 10 % 10;
			num1d = numScan % 10;
			// test
			// System.out.printf("%d / %d / %d / %d / %d\n", num5d, num4d, num3d, num2d,
			// num1d);
			if ((num5d == num1d) && (num4d == num2d)) {
				System.out.println("Yes. 恭喜你找到 回文數!!");
			} else {
				System.out.println("No. 不是 回文數.. ");
			}
		}

		// 找出所有回文數
		int total = 0;
		for (int i = 10000; i <= 99999; i++) {
			num5d = i / 10000;
			num4d = i / 1000 % 10;
			num3d = i / 100 % 10;
			num2d = i / 10 % 10;
			num1d = i % 10;
			// test
			// System.out.printf("%d / %d / %d / %d / %d\n", num5d, num4d, num3d, num2d,
			// num1d);
			if ((num5d == num1d) && (num4d == num2d)) {
				System.out.printf("Yes. %d is 回文數!!\n", i);
				total++;
			}

		}
		System.out.printf("10000 ~ 99999 有 %d 個 回文數\n", total);

		// Recycle the resources - scanner
		scanner.close();

	}

}
