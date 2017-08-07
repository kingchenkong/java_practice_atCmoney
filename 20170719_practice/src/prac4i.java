import java.util.Scanner;

public class prac4i {

	public static void main(String[] args) {

		// Declare, Initialize
		Scanner scanner = new Scanner(System.in);
		int size = 0;

		// size >= 1
		do {
			System.out.println("請輸入層級: ");
			size = scanner.nextInt();
		} while (size < 1);
		
		int power = 2 * size - 1; //層數 = 寬度
		int midNum = size;//中位數
		int startPos = 0; //開始位置
		int stopPos = 0; //停止位置
		int adjNum = 1; //調整數

		for ( int i = 1; i <= (2 * size - 1); i++ ) {
			if(i <= size) {
				for( int j = 1; j <= (2 * size - 1); j++ ) {
					startPos = midNum - i + adjNum; //中位數 - 遞增數 + 調整數
					stopPos = midNum + i -adjNum; //中位數 + 遞增數 - 調整數
					if ( ( j > startPos ) && ( j < stopPos ) ) {
						System.out.print(" ");
					
					} else {
						System.out.print("*");
						
					}
				}
				System.out.print("\n");
			
			} else {
				
				for( int j = 1; j <= (2 * size - 1); j++ ) {
					startPos = midNum - (power - i) + adjNum;
					stopPos = midNum + (power - i) - adjNum;
					if ( ( j >= startPos ) && ( j <= stopPos )  ) {

						System.out.print(" ");
					
					} else {
						System.out.print("*");	
					
					}
				}
				System.out.print("\n");
				
			}
		}

		// Recycle the resources - scanner
		scanner.close();
	}

}
