import java.util.Scanner;

public class practice2b {

	public static void main(String[] args) {
		/*
		 * 輸入說明：要求使用者輸入兩個整數，並印出和的平方值。執行範例如下（輸入部分以黑體字標註）： Integer 1: 7 Integer 2: 5
		 * 
		 * Square sum: 74
		 */
		Scanner scanner = new Scanner(System.in);
		int integer1, integer2, squareSum = 0;

		System.out.print("求兩數之平方和\n請輸入 兩個整數:");
		integer1 = scanner.nextInt();
		integer2 = scanner.nextInt();

		squareSum = integer1 * integer1 + integer2 * integer2;
		System.out.printf("Square Sum = %d\n", squareSum);

	}

}
