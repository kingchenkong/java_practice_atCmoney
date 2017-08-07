import java.util.Scanner;

public class practice1 extends Practice2a {

	public static void main(String[] args) {
		/*
		要求 使用者輸入 兩個浮點數，並印出兩個數的相加結果。執行範例如下（輸入部分以黑體字標註）：
		Number 1: 3.223
		Number 2: 1.2

		Sum: 4.42

		請寫註解，並注意程式碼排版。
		 */
		Scanner scanner = new Scanner(System.in);
	    double db1, db2, db3 = 0.0;
	      
	    System.out.print("輸入 兩個浮點數:");
	    db1 = scanner.nextDouble();
	    db2 = scanner.nextDouble();
	    
	    db3 = db1 + db2;
	    System.out.printf("Sum = %.2f\n", db3);
		
		
	}

}
