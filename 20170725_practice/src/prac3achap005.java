//題目：
//難度一：
//選擇選項1 輸入成績後，再 選擇選項2 可印出所有的已輸入的成績。
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: 1
//聽力測驗: -1
//聽力測驗分數輸入錯誤!
//聽力測驗: 40
//閱讀測驗: 110
//總分: 150
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: 1
//聽力測驗: 60
//閱讀測驗: 70
//總分: 130
//
//主選項: 1)輸入成績 2)統計資料 3)搜尋成績 4)修改成績 -1)結束: 2
//    聽力測驗	閱讀測驗	  總分
//----------------------------------------------------------
//1		40	    110	  150
//2		60	     70	  130
import java.util.Scanner;
import java.util.Arrays;
public class prac3achap005 {

	public static void main(String[] args) {
		//Declare, Initial
		Scanner scanner = new Scanner(System.in);
		boolean reWhile = true;
		int mainOption = 0;	// 主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束:
		int listenScore = 0, readingScore = 0;
		int arrayAlreadyNewCount = 0;	// 成績筆數
		//		int arrayAlreadyNew = 0;	// 筆數索引
		int[] arrayListenScore = new int[3];
		int[] arrayReadingScore = new int[3];
		int[] arrayListenScoreForCopy;
		int[] arrayReadingScoreForCopy;

		do {
			System.out.println("主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束:");
			mainOption = scanner.nextInt();

			switch (mainOption) {
			case -1:
				System.out.println("Bye!");
				reWhile = false;
				break;

			case 1:
				//do-while - 聽力 輸入防呆
				do {
					System.out.println("聽力測驗: ");
					listenScore = scanner.nextInt();
					if(listenScore < 0) {
						System.out.println("---聽力測驗分數輸入錯誤 !!");
					}
				} while(listenScore < 0);
				//do-while - 閱讀 輸入防呆
				do {
					System.out.println("閱讀測驗: ");
					readingScore = scanner.nextInt();
					if(readingScore < 0) {
						System.out.println("---閱讀測驗分數輸入錯誤 !!");
					}
				} while(readingScore < 0);
				System.out.println("總分: " + (listenScore + readingScore) );

				//store in array
				arrayListenScore[arrayAlreadyNewCount] = listenScore;
				arrayReadingScore[arrayAlreadyNewCount] = readingScore;

				//test
				//				System.out.println("    聽力測驗    閱讀測驗    總分\n----------------------------------------------------------");
				//				System.out.println( (arrayAlreadyNew + 1) + "    " + arrayListenScore[arrayAlreadyNew] +
				//						"    " + arrayReadingScore[arrayAlreadyNew]+ "    " + (arrayListenScore[arrayAlreadyNew] + arrayReadingScore[arrayAlreadyNew]) );					
				//本筆新增完成, 指向下一筆
				//				arrayAlreadyNew += 1;
				arrayAlreadyNewCount += 1;
				break;

			case 2:
				System.out.println("    聽力測驗	閱讀測驗	  總分\n----------------------------------------------------------");
				for(int i = 0; i < arrayListenScore.length; i++) {
					System.out.println( (i + 1) + "    " + arrayListenScore[i] +
							"    " + arrayReadingScore[i]+ "    " + (arrayListenScore[i] + arrayReadingScore[i]) );		
					if( (i + 1) >= arrayAlreadyNewCount) {
						break;
					}
				}
				break;

			case 3:
				System.out.println("尚未實作 '修改成績' 功能, 稍後開放");
				break;

			default:
				System.out.println("錯誤輸入");
			}

			// 超過array可儲存項目時.
			if(arrayAlreadyNewCount == arrayListenScore.length ) {
				arrayListenScoreForCopy = Arrays.copyOf(arrayListenScore, arrayListenScore.length * 2);
				arrayReadingScoreForCopy = Arrays.copyOf(arrayReadingScore, arrayReadingScore.length * 2);

				arrayListenScore = Arrays.copyOf(arrayListenScoreForCopy, arrayListenScoreForCopy.length);
				arrayReadingScore = Arrays.copyOf(arrayReadingScoreForCopy, arrayReadingScoreForCopy.length);

				//test
				//				System.out.println("-- 成績紀錄 已滿 --");
				//				System.out.println("-- 擴增 array --");
				//				System.out.println("arrayListenScore.length = " + arrayListenScore.length + ", arrayReadingScore.length = " + arrayReadingScore.length);
			}

		} while(reWhile);


		//Recycle
		scanner.close();
		arrayListenScore = null;
		arrayReadingScore = null;
		arrayListenScoreForCopy = null;
		arrayReadingScoreForCopy = null;

	}

}
