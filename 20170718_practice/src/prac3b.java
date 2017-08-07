import java.util.Scanner;

public class prac3b {

	public static void main(String[] args) {
		/*
		題目：四則運算 Part II
		請要求使用者 "依序輸入選項"，以 "選擇算術運算子" ，接著選擇 "兩個整數" 以計算其結果； "結果也請以整數" 表示。
		注意：如選擇除法時發現除數為0，請印出錯誤訊息。以下為三種不同的執行範例：

		運算: 1) +, 2) -, 3)*, 4) /, -1)Quit: 1
		數字 1: 3
		數字 2: 4
		3 + 4 = 7

		---------------------------------------------------------------

		運算: 1) +, 2) -, 3)*, 4) /, -1)Quit: 4
		數字1: 3
		數字2: 0
		除數不可為零!

		---------------------------------------------------------------

		運算: 1) +, 2) -, 3)*, 4) /, -1)Quit: 4
		數字1: 3
		數字2: 1
		3 / 1 = 3
		*/
		Scanner scanner = new Scanner(System.in);
		int num1 = 0, num2 = 0, option = 0;

		System.out.print("請輸入需要的算術選項\n1) +, 2) -, 3)*, 4) /, -1)Quit");
		option = scanner.nextInt();
		
		// -1)Quit
		if(option == -1) {
			System.out.println("is Quit!!");
			return;
		}
		if((option >=1) && (option <=4)) {
			// option:1~4
				System.out.print("請輸入整數 Num1:");
				num1 = scanner.nextInt();
				System.out.print("請輸入整數 Num2:");
				num2 = scanner.nextInt();
		
				//	" + "
			if(option == 1) 
				System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		
				//	" - "
			if(option == 2) 
				System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
		
				//	" * "
			if(option == 3) 
				System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
		
				//	" / "
			if(option == 4) {
				// 判斷除數是否為0	
				if(num2 == 0) {
					System.out.println("除數不可為零!");
					return;
				}
				System.out.printf("%d / %d = %d", num1, num2, num1 / num2);
			}
		}
		
	}
}
