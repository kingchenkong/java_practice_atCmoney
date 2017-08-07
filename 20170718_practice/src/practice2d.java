import java.util.Scanner;

public class practice2d {

	public static void main(String[] args) {
		/*
		題目：計算面積 
		請觀察以下的圖形，並試圖撰寫一個程式，要求使用者輸入圖中的參數（U、L，以及H）後，再計算出它的面積，並輸出結果，
		結果請列印至 "小數點後兩位。" 
		### 其中，S的長度等於0.75倍的L。
		另外，梯形與圓形的公式如下：
		# 梯形面積公式為：（上底 + 下底） × 高 ÷ 2 。
		# 圓形面積公式為：半徑平方 ×圓周率（圓周率請代3.1416）。
￼
		輸入說明 ： 執行範例如下（輸入部分以黑體字標註）：
		U：20
		L：16
		H: 8
		面積：356.53

		請寫註解，並注意程式碼排版。
		 */
		Scanner scanner = new Scanner(System.in);
	    double U, L, H, area = 0.0;
	      
	    System.out.println("請輸入 三個參數 ");
	    System.out.print("請輸入 U");
	    U = scanner.nextDouble();
	    System.out.print("請輸入 L");
	    L = scanner.nextDouble();
	    System.out.print("請輸入 H");
	    H = scanner.nextDouble();
	    
	    area = ((U + 0.75 * L) * H / 2) + L * H + (H / 2) * (H / 2) * 3.1416 * 2 ;
	    System.out.printf("The area is %.2f\n", area);
		
		
	}

}
