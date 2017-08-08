import java.util.Scanner;

public class prac4g {

	public static void main(String[] args) {

		// Declare, Initialize
		Scanner scanner = new Scanner(System.in);
		// int level = 0;
		int size = 0;

		// scan
		// level only 1,2,3
		// do {
		// System.out.println("請輸入難度: ");
		// level = scanner.nextInt();
		// } while ( ( level > 3 ) || ( level < 1 ) );

		// size >= 1
		do {
			System.out.println("請輸入層級: ");
			size = scanner.nextInt();
		} while (size < 1);

		// Part I :
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < (size - i - 1); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2 * i + 1); j++) {
				System.out.print("*");
			}

			System.out.print("\n");
		}

		// Part II :
		for (int i = 0; i < (size - 1); i++) {
			for (int j = 0; j < (i + 1); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2 * (size - i) - 3); j++) {
				System.out.print("*");
			}

			System.out.print("\n");
		}

		// Recycle the resources - scanner
		scanner.close();
	}

}
