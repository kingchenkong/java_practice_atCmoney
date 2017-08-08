import java.util.Scanner;

public class prac3a {

	public static void main(String[] args) {
		/*
		 * 題目：四則運算 Part I
		 * 
		 * 請要求使用者輸入兩個浮點數，再依序印出加減乘除的結果。注意：如計算除法運算時發現除數為0，請印出錯誤訊息。以下為兩種不同的執行範例：
		 * 
		 * 數字1: 3 數字2: 4.2
		 * 
		 * 3.00 + 4.20 = 7.20 3.00 - 4.20 = -1.20 3.00 * 4.20 = 12.60 3.00 / 4.20 = 0.71
		 * 
		 * ==========================================================
		 * 
		 * 數字1: 3 數字2: 0
		 * 
		 * 3.00 + 0.00 = 3.00 3.00 - 0.00 = 3.00 3.00 * 0.00 = 0.00 3.00 / 0.00錯誤！除數為零。
		 */
		Scanner scanner = new Scanner(System.in);
		double db1, db2, db3 = 0.0;

		System.out.print("Plz input two double float:");
		db1 = scanner.nextDouble();
		db2 = scanner.nextDouble();

		db3 = db1 + db2;
		System.out.printf("Number1 + Number2 = %.2f\n", db3);
		db3 = db1 - db2;
		System.out.printf("Number1 - Number2 = %.2f\n", db3);
		db3 = db1 * db2;
		System.out.printf("Number1 * Number2 = %.2f\n", db3);

		if (db2 != 0) {
			db3 = db1 / db2;
			System.out.printf("Number1 / Number2 = %.2f\n", db3);
		} else {
			System.out.printf("錯誤！ 除數為零");
		}
	}

}
