import java.util.Scanner;

public class practiceOnClass {
	//
	//on class practice
	//
	public static void main(String[] args) {


		//Declare, Initialize
		Scanner scanner = new Scanner(System.in);


		//while: break練習
		int A = 1, B = 2, C = 3, D = 4, E = 5, F = 6;
		while (A == 1) {
			System.out.println("A =" + A);
			System.out.println("B =" + B);
			System.out.println("C =" + C);
			if (D == D) {
				System.out.println("D =" + D);
				break;
			}
			System.out.println("E =" + E);

		}
		System.out.println("F =" + F);


		//Duplicate local variable
		//		int x, y;
		//		for (int x = 0; x < 3; x++ ) {
		//			for (int y = 0; y <= 7; y++) {
		//				
		//			}
		//		}

		//
		//機內零錢
		int coin1 = 30, coin5 = 30, coin10 = 30, coin50 = 0; //零錢
		int cash100 = 0, cash500 = 0, cash1000 = 0;	//鈔票
		//
		int giveCharge = 433;		

		//需找零錢
		int needCoin10 = 0, needCoin5 = 0, needCoin1 = 0;
		System.out.println("找您" + giveCharge + " 元");
		// 10元
		needCoin10 = giveCharge / 10;
		if ( needCoin10 > 30 ) {
			needCoin10 = 30;
		}
		giveCharge -= needCoin10 * 10;
		// 5元
		needCoin5 = giveCharge / 5;
		if ( needCoin5 > 30 ) {
			needCoin5 = 30;
		}
		giveCharge -= needCoin5 * 5;
		// 1元
		needCoin1 = giveCharge;

		//零錢是否足夠
		boolean changeEnough = ( ( coin10 >= needCoin10 ) && ( coin5 >= needCoin5 ) && ( coin1 >= needCoin1 ) );
		if( changeEnough ) {
			System.out.printf("退還 - 10元 : %d 個, 5元: %d 個, 1元: %d 個", needCoin10, needCoin5, needCoin1);

			//End - 結束購票
			System.out.println("-- 感謝購買 --");

		} else {
			System.out.println("機台內現金不足, 無法找零, 請洽工作人員");

		}

		//

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i -1; j++) {
				System.out.print("*");
			}

			System.out.print("\n");
		}
		System.out.print("#################\n");
		System.out.print("#################\n");
		System.out.print("#################\n");
		System.out.print("\n");


		int size = 5;
		//層數 = 2 * size - 1
		//寬度 = 2 * size - 1
		int power = 2 * size - 1; //層數 = 寬度
		int midNum = size;//中位數
		int startPos = 0;
		int stopPos = 0;

		for ( int i = 1; i <= (2 * size - 1); i++ ) {
			if(i < size) {
				for( int j = 1; j <= (2 * size - 1); j++ ) {
					startPos = 0;
					stopPos = 0;
					if ( ( j >= size - i ) && ( j < size + i - 1) ) {
						System.out.print("＿");
					} else {
						System.out.print("＊");	
					}
				}
				System.out.print("\n");
			} else {
				for( int j = 1; j <= (2 * size - 1); j++ ) {
					//開始位置 && 結束位置
					// && (總層數 - 離總層數的差距)
					//if ( ( j > i - size + 1) && ( j < 3 * (size - 1) - i ) ) {
					startPos = i - size + 1;



					//					stopPos =  (2 * size - 1) - 2 - i;
					stopPos =  3 * (size - 1) - i ;
					//					System.out.printf("i = %d, startPos = %d, stopPos = %d \n", i, startPos, stopPos);
					if ( ( j > startPos ) && ( j < stopPos )  ) {

						System.out.print("＿");
					} else {
						System.out.print("＊");	
					}
				}
				System.out.print("\n");
			}
		}

		//		System.out.print("＿");


		System.out.print("\n");
		System.out.print("#################\n");
		System.out.print("#################\n");


		size = 5;
		power = 2 * size - 1; //層數 = 寬度
		midNum = size;//中位數
		startPos = 0; //開始位置
		stopPos = 0; //停止位置
		int adjNum = 1; //調整數

		for ( int i = 1; i <= (2 * size - 1); i++ ) {
			if(i <= size) {
				for( int j = 1; j <= (2 * size - 1); j++ ) {
					startPos = midNum - i + adjNum; //中位數 - 遞增數 + 調整數
					stopPos = midNum + i -adjNum; //中位數 + 遞增數 - 調整數
					if ( ( j > startPos ) && ( j < stopPos ) ) {
						System.out.print("＿");
					} else {
						System.out.print("＊");	
					}
				}
				System.out.print("\n");
			} else {
				for( int j = 1; j <= (2 * size - 1); j++ ) {
					startPos = midNum - (power - i) + adjNum;
					stopPos = midNum + (power - i) - adjNum;
					if ( ( j >= startPos ) && ( j <= stopPos )  ) {

						System.out.print("＿");
					} else {
						System.out.print("＊");	
					}
				}
				System.out.print("\n");
			}
		}






		//Recycle the resources - scanner
		scanner.close();

		//Exit program
		System.exit(0);
	}

}
