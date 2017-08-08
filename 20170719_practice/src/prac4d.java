import java.util.Scanner;

public class prac4d {

	public static void main(String[] args) {
		// Declare, Initialize
		Scanner scanner = new Scanner(System.in);
		int n, count = 0;

		System.out.println("請輸入正整數: ");
		// n = scanner.nextInt();
		n = (int) (Math.random() * 100 + 1);
		System.out.println("n = " + n);

		if (n > 1) {
			System.out.println("開始檢查");

			if (n == 2) {
				System.out.println("True. " + n + "是質數.");

			} else {

				int i = 2;
				System.out.print("N的因數有:1, ");
				while (n > i) {
					if (n % i == 0) {
						count = count + 1;
						System.out.print(i + ", ");
					}
					i = i + 1;
				}
				if (count == 0) {
					System.out.print(n + ". True. " + n + "是質數");
				} else {
					System.out.println("False." + n + "不是質數.");
					System.out.println("count = " + count);
				}

			}

		} else {
			System.out.println("錯誤輸入");

		}

		// Recycle the resources - scanner
		scanner.close();
	}

}
