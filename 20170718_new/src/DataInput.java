import java.util.Scanner;

public class DataInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); // new 一個新類別 scanner 繼承 Scanner

		// 2-2 變數輸入
		/*
		 * int x, y; System.out.print("請輸入兩個整數:"); x = scanner.nextInt(); y =
		 * scanner.nextInt(); System.out.println("您的輸入為" + x + " " + y + "\n");
		 * 
		 * double m, n; System.out.print("請輸入兩個浮點數:"); m = scanner.nextDouble(); // n =
		 * scanner.nextDouble(); System.out.println("您的輸入為" + m + " " + n);
		 */
		// 例外發生
		// 如果 Scanner 無法將使用者的輸入轉換為指定的資料型態
		// 程式會發出 java.util.InputMismatchException 錯誤
		// 處理方式後續單元再說明
		// 目前程式處理這個錯誤的方式就是直接終止程式。

		// input boolean
		/*
		 * boolean bool;
		 * 
		 * System.out.print("輸入布林數:"); bool = scanner.nextBoolean();
		 * 
		 * System.out.println("布林數輸入:" + bool);
		 */

		// 2-3 算術運算式與輸出格式化
		// practice-1
		/*
		 * double db1, db2, db3 = 0.0;
		 * 
		 * System.out.print("Plz input two double float:"); db1 = scanner.nextDouble();
		 * db2 = scanner.nextDouble();
		 * 
		 * db3 = db1 + db2; System.out.println("Number1 + Number2 = " + db3); db3 = db1
		 * - db2; System.out.println("Number1 - Number2 = " + db3); db3 = db1 * db2;
		 * System.out.println("Number1 * Number2 = " + db3); db3 = db1 / db2;
		 * System.out.println("Number1 / Number2 = " + db3);
		 * //System.out.println("Number1 / Number2 = " + (db1 / db2)); //is OK!!
		 * 
		 * //以下 print"f" System.out.printf("相加結果（限制 小數後兩位): %.2f", db1 + db2); //限制顯示
		 * 小數後第二位, 會 "四捨五入"
		 */
		// practice-2
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
		db3 = db1 / db2;
		System.out.printf("Number1 / Number2 = %.2f\n", db3);
		// System.out.printf("Number1 / Number2 = %f\n" ,db3);

	}

}
