import java.util.Scanner;
public class prac3d {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num3Digit = 0;
		int sum = 0;
		int num100 = 0;
		int num10 = 0;
		int num1 = 0;
		
		System.out.println("請輸入一個 '三位數' 整數: ");
		num3Digit =  scanner.nextInt();
		
		// 確定為 三位數
		if((num3Digit < 100) || (num3Digit>999)) {
			System.out.printf("輸入錯誤!!");
			return;	//離開
		}
		
		// 分位數
		num100 = num3Digit / 100;
		num10 = num3Digit % 100 / 10;
		num1 = num3Digit % 100 % 10 ;
			//test
		//System.out.printf("%d %d %d\n", num100, num10, num1);	
		
		num100 = num100 * num100 * num100;
		num10 = num10 * num10 * num10;
		num1 = num1 * num1 * num1;
		sum = num100 + num10 + num1;
			//test
		//System.out.printf("%d %d %d %d\n", num100, num10, num1, sum);
		
		//	判斷是否為 Armsrtong數
		if(num3Digit == sum) {
			System.out.printf("Yes. 恭喜你找到 Armsrtong數!!\n");
		} else {
			System.out.printf("No. 再接再厲~\n");

		}
		
		//	自動找 Armsrtong數
		for(int i=100; i<=999; i++) {
			// 分位數
			num100 = i / 100;
			num10 = i % 100 / 10;
			num1 = i % 100 % 10 ;
				//test
			//System.out.printf("%d %d %d\n", num100, num10, num1);	
			
			num100 = num100 * num100 * num100;
			num10 = num10 * num10 * num10;
			num1 = num1 * num1 * num1;
			sum = num100 + num10 + num1;
				//test
			//System.out.printf("%d %d %d %d\n", num100, num10, num1, sum);
			
			//	判斷是否為 Armsrtong數
			if(i == sum) {
				System.out.printf("Yes. 恭喜你找到 Armsrtong數!!");
				System.out.printf("%d %d %d %d %d\n", i, num100, num10, num1, sum);

			} 
		}
		
		
		
	}

}
