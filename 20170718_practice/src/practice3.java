import java.util.Scanner;

public class practice3 {

	public static void main(String[] args) {
		
		// 比較運算子 與 邏輯運算子	
		int x = 10,y = 20;

		System.out.print(" x=" + x);  
		System.out.println(" y=" + y);  
		System.out.println("---------------"); 
		System.out.println("x == y ==> " + (x==y));  
		System.out.println("x != y ==> " + (x!=y));  
		System.out.println("x > y  ==> " + (x>y));  
		System.out.println("x < y  ==> " + (x<y));  
		System.out.println("x >= y ==> " + (x>=y));  
		System.out.println("x <= y ==> " + (x<=y));
		
		// 實作練習 - 1
		Scanner scanner = new Scanner(System.in);
		int numPositiveOrNegative = 0;
		
		System.out.println("---------------"); 
		System.out.println("---判斷負數---");
		System.out.println("請輸入一個整數:");
		numPositiveOrNegative = scanner.nextInt();
		
		if(numPositiveOrNegative > 0)
		{
			System.out.println("> 0, 是 正數");
			
		} 
		else if(numPositiveOrNegative < 0)
		{
			System.out.println("< 0, 是 負數");
			
		} 
		else 
		{
			System.out.println("= 0");

		}
		
		
		
	}

}
