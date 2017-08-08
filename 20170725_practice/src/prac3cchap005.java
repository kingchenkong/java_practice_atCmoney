
//題目：
//難度三：
//請提供修改功能，用來修正某一個編號的成績。執行範例如下：
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: 1
//聽力測驗: 40
//閱讀測驗: 110
//總分: 150
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: 1
//聽力測驗: 60
//閱讀測驗: 70
//總分: 130
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: 1
//聽力測驗: 10
//閱讀測驗: 70
//總分: 80
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束: 3
//編號: 9
//索引超出範圍！
//
//編號: 1
//修正分數: 100 20
//
//主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束:

import java.util.Arrays;
import java.util.Scanner;

public class prac3cchap005 {

	public static void main(String[] args) {
		// Declare, Initial
		Scanner scanner = new Scanner(System.in);
		boolean reWhile = true;
		int mainOption = 0; // 主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束:
		int listenScore = 0, readingScore = 0;
		int arrayAlreadyNewCount = 0; // 成績筆數
		int[] arrayListenScore = new int[3];
		int[] arrayReadingScore = new int[3];
		int[] arrayLRSumScore = new int[3];
		int[] arrayListenScoreForCopy;
		int[] arrayReadingScoreForCopy;
		int[] arrayLRSumScoreForCopy;
		int minListenScore = 0, minReadingScore = 0, minSumScore = 0; // 最小值
		int maxListenScore = 0, maxReadingScore = 0, maxSumScore = 0; // 最大值

		// Begin
		// -1,離開
		do {
			System.out.println("主選項: 1)輸入成績 2)統計資料 3)修改成績 -1)結束:");
			mainOption = scanner.nextInt();

			switch (mainOption) {
			case -1:
				System.out.println("Bye!");
				reWhile = false;
				break;

			case 1:
				// do-while - 聽力 輸入防呆
				do {
					System.out.println("聽力測驗: ");
					listenScore = scanner.nextInt();
					if ((listenScore < 0) || (listenScore > 120)) {
						System.out.println("---聽力測驗分數輸入錯誤 !!");
					}
				} while ((listenScore < 0) || (listenScore > 120));

				// do-while - 閱讀 輸入防呆
				do {
					System.out.println("閱讀測驗: ");
					readingScore = scanner.nextInt();
					if ((readingScore < 0) || (readingScore > 120)) {
						System.out.println("---閱讀測驗分數輸入錯誤 !!");
					}
				} while ((readingScore < 0) || (readingScore > 120));
				System.out.println("總分: " + (listenScore + readingScore));

				// 最大最小值紀錄
				// 聽力
				if (maxListenScore < listenScore) {
					maxListenScore = listenScore;
				}

				if (arrayAlreadyNewCount == 0) {
					minListenScore = listenScore;
				} else if (minListenScore > listenScore) {
					minListenScore = listenScore;
				}

				// 閱讀
				if (maxReadingScore < readingScore) {
					maxReadingScore = readingScore;
				}

				if (arrayAlreadyNewCount == 0) {
					minReadingScore = readingScore;
				} else if (minReadingScore > readingScore) {
					minReadingScore = readingScore;
				}

				// 總分
				if (maxSumScore < (readingScore + listenScore)) {
					maxSumScore = readingScore + listenScore;
				}

				if (arrayAlreadyNewCount == 0) {
					minSumScore = readingScore + listenScore;
				} else if (minSumScore > (readingScore + listenScore)) {
					minSumScore = readingScore + listenScore;
				}

				// store in array
				arrayListenScore[arrayAlreadyNewCount] = listenScore;
				arrayReadingScore[arrayAlreadyNewCount] = readingScore;
				arrayLRSumScore[arrayAlreadyNewCount] = listenScore + readingScore;
				arrayAlreadyNewCount += 1;
				break;

			case 2:
				// ################
				// ### Part - I ###
				// ################
				// 修正輸出
				// 上方版面
				int blankSize = 5;
				int blankAdj = 0;

				for (int iblank = 0; iblank <= 5; iblank++)
					System.out.print(" ");

				System.out.print("聽力測驗");

				for (int jblank = 0; jblank <= 5; jblank++)
					System.out.print(" ");

				System.out.print("閱讀測驗");

				for (int kblank = 0; kblank <= 5; kblank++)
					System.out.print(" ");

				System.out.print("總分");
				System.out.print("\n");
				System.out.println("----------------------------------------------------------");

				// 陣列
				for (int i = 0; i < arrayListenScore.length; i++) {

					// 索引
					System.out.print((i + 1));

					// 聽力
					blankSize = 5;
					blankAdj = 0;
					if (arrayListenScore[i] < 100)
						blankAdj += 1;
					if (arrayListenScore[i] < 10)
						blankAdj += 1;

					for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
						System.out.print(" ");
					System.out.print(arrayListenScore[i]);

					// 閱讀
					blankSize = 9;
					blankAdj = 0;
					if (arrayReadingScore[i] < 100)
						blankAdj += 1;
					if (arrayReadingScore[i] < 10)
						blankAdj += 1;

					for (int jblank = 0; jblank <= blankSize + blankAdj; jblank++)
						System.out.print(" ");
					System.out.print(arrayReadingScore[i]);

					// 總分
					blankSize = 8;
					blankAdj = 0;
					if ((arrayListenScore[i] + arrayReadingScore[i]) < 100)
						blankAdj += 1;
					if ((arrayListenScore[i] + arrayReadingScore[i]) < 10)
						blankAdj += 1;

					for (int kblank = 0; kblank <= blankSize + blankAdj; kblank++)
						System.out.print(" ");
					System.out.print((arrayListenScore[i] + arrayReadingScore[i]));

					// 換行
					System.out.print("\n");
					// close when develop
					if ((i + 1) >= arrayAlreadyNewCount) {
						break;
					}
				}

				// 聽力測驗 閱讀測驗 總分
				// ----------------------------------------------------------
				// 平均值 50.00 90.00 140.00
				// 標準差 10.00 20.00 10.00
				// 最小值 40 70 130
				// 最大值 60 110 150
				//
				// ################
				// ### Part - II ##
				// ################
				// 修正輸出
				// 上方版面
				blankSize = 5;
				blankAdj = 0;

				for (int iblank = 0; iblank <= 8; iblank++)
					System.out.print(" ");

				System.out.print("聽力測驗");

				for (int jblank = 0; jblank <= 5; jblank++)
					System.out.print(" ");

				System.out.print("閱讀測驗");

				for (int kblank = 0; kblank <= 5; kblank++)
					System.out.print(" ");

				System.out.print("總分");
				System.out.print("\n");
				System.out.println("----------------------------------------------------------");

				// 數值運算
				double averageLis = 0, squareListenSum = 0;
				double averageReading = 0, squareReadingSum = 0;
				int[] squareSumSum = new int[arrayListenScore.length];
				double standardDiffListen = 0, standardDiffReading = 0;

				// 聽力
				for (int j = 0; j < arrayListenScore.length; j++) {
					averageLis += arrayListenScore[j];
					squareListenSum += arrayListenScore[j] * arrayListenScore[j];
					// for 總分標準差
					squareSumSum[j] += arrayListenScore[j];
				}

				averageLis = averageLis / (double) arrayAlreadyNewCount;
				squareListenSum = squareListenSum / (double) arrayAlreadyNewCount;
				standardDiffListen = Math.sqrt(squareListenSum - averageLis * averageLis);

				// 閱讀
				for (int j = 0; j < arrayReadingScore.length; j++) {
					averageReading += arrayReadingScore[j];
					squareReadingSum += arrayReadingScore[j] * arrayReadingScore[j];
					// for 總分標準差
					squareSumSum[j] += arrayReadingScore[j];
				}

				averageReading = averageReading / (double) arrayAlreadyNewCount;
				squareReadingSum = squareReadingSum / (double) arrayAlreadyNewCount;
				// for 總分標準差
				for (int j = 0; j < squareSumSum.length; j++) {
					int a = squareSumSum[j];
					squareSumSum[j] = a * a;
				}
				standardDiffReading = Math.sqrt(squareReadingSum - averageReading * averageReading);

				// 總分
				double arrayForPrint[] = new double[12];
				arrayForPrint[0] = averageLis;
				arrayForPrint[1] = averageReading;
				arrayForPrint[2] = (averageLis + averageReading);
				arrayForPrint[3] = standardDiffListen;
				arrayForPrint[4] = standardDiffReading;
				// 總分表準差運算
				int squareSumSumOneElementToSum = 0;
				for (int c = 0; c <= arrayAlreadyNewCount; c++) {
					squareSumSumOneElementToSum += squareSumSum[c];
				}
				arrayForPrint[5] = Math.sqrt((squareSumSumOneElementToSum) / arrayAlreadyNewCount
						- (averageLis + averageReading) * (averageLis + averageReading));
				arrayForPrint[6] = minListenScore;
				arrayForPrint[7] = minReadingScore;
				arrayForPrint[8] = minSumScore;
				arrayForPrint[9] = maxListenScore;
				arrayForPrint[10] = maxReadingScore;
				arrayForPrint[11] = maxSumScore;

				// 顯示
				for (int x = 0; x < arrayForPrint.length; x++) {
					switch (x % 3) {
					case 0:
						// 第一項 中文輸出
						switch (x / 3) {
						case 0:
							System.out.print("平均值");
							break;

						case 1:
							System.out.print("標準差");
							break;
						case 2:
							System.out.print("最小值");
							break;
						case 3:
							System.out.print("最大值");
							break;
						default:
							System.out.print("Error.");
						}

						// 聽力
						if (x < 6) {
							blankSize = 3;
							blankAdj = 0;
							if (arrayForPrint[x] < 100)
								blankAdj += 1;
							if (arrayForPrint[x] < 10)
								blankAdj += 1;

							for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
								System.out.print(" ");
							System.out.printf("%.2f", arrayForPrint[x]);
						} else {
							// x >= 6
							blankSize = 5;
							blankAdj = 0;
							if (arrayForPrint[x] < 100)
								blankAdj += 1;
							if (arrayForPrint[x] < 10)
								blankAdj += 1;

							for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
								System.out.print(" ");
							System.out.printf("%.0f", arrayForPrint[x]);
						}
						break;

					case 1:
						// 閱讀
						if (x < 6) {
							blankSize = 5;
							blankAdj = 0;
							if (arrayForPrint[x] < 100)
								blankAdj += 1;
							if (arrayForPrint[x] < 10)
								blankAdj += 1;
							for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
								System.out.print(" ");
							System.out.printf("%.2f", arrayForPrint[x]);
						} else {
							// x >= 6
							blankSize = 8;
							blankAdj = 0;
							if (arrayForPrint[x] < 100)
								blankAdj += 1;
							if (arrayForPrint[x] < 10)
								blankAdj += 1;
							for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
								System.out.print(" ");
							System.out.printf("%.0f", arrayForPrint[x]);
						}
						break;

					case 2:
						// 總分
						if (x < 6) {
							blankSize = 5;
							blankAdj = 0;
							if (arrayForPrint[x] < 100)
								blankAdj += 1;
							if (arrayForPrint[x] < 10)
								blankAdj += 1;
							for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
								System.out.print(" ");
							System.out.printf("%.2f\n", arrayForPrint[x]);
						} else {
							blankSize = 8;
							blankAdj = 0;
							if (arrayForPrint[x] < 100)
								blankAdj += 1;
							if (arrayForPrint[x] < 10)
								blankAdj += 1;
							for (int iblank = 0; iblank <= blankSize + blankAdj; iblank++)
								System.out.print(" ");
							System.out.printf("%.0f\n", arrayForPrint[x]);
						}
						break;

					default:
						System.out.println("Error.");
					}
				}

				break;

			case 3:
				boolean redoInput = false;
				do {
					System.out.print("請輸入項次索引: ");
					int searchIndex = scanner.nextInt();
					if ((searchIndex > arrayAlreadyNewCount) || (searchIndex < 1)) {
						System.out.println("索引超出範圍！");
						redoInput = true;
					} else {
						redoInput = false;
						// do-while - 聽力 輸入防呆
						do {
							System.out.println("聽力測驗: ");
							listenScore = scanner.nextInt();
							if ((listenScore < 0) || (listenScore > 120)) {
								System.out.println("---聽力測驗分數輸入錯誤 !!");
							}
						} while ((listenScore < 0) || (listenScore > 120));

						// do-while - 閱讀 輸入防呆
						do {
							System.out.println("閱讀測驗: ");
							readingScore = scanner.nextInt();
							if ((readingScore < 0) || (readingScore > 120)) {
								System.out.println("---閱讀測驗分數輸入錯誤 !!");
							}
						} while ((readingScore < 0) || (readingScore > 120));
						System.out.println("總分: " + (listenScore + readingScore));

						// store in array
						arrayListenScore[searchIndex - 1] = listenScore;
						arrayReadingScore[searchIndex - 1] = readingScore;
						arrayLRSumScore[searchIndex - 1] = listenScore + readingScore;

						// 最大最小值紀錄
						// reset
						minListenScore = 120;
						minReadingScore = 120;
						minSumScore = 120;
						maxListenScore = 0;
						maxReadingScore = 0;
						maxSumScore = 0;

						for (int c = 0; c < arrayAlreadyNewCount; c++) {
							// 聽力
							if (maxListenScore < arrayListenScore[c]) {
								maxListenScore = arrayListenScore[c];
							}
							if (arrayAlreadyNewCount == 0) {
								minListenScore = arrayListenScore[c];
							} else if (minListenScore > arrayReadingScore[c]) {
								minListenScore = arrayListenScore[c];
							}

							// 閱讀
							if (maxReadingScore < arrayReadingScore[c]) {
								maxReadingScore = arrayReadingScore[c];
							}
							if (arrayAlreadyNewCount == 0) {
								minListenScore = arrayReadingScore[c];
							} else if (minReadingScore > arrayReadingScore[c]) {
								minReadingScore = arrayReadingScore[c];
							}

							// 總分
							if (maxSumScore < arrayLRSumScore[c]) {
								maxSumScore = arrayLRSumScore[c];
							}
							if (arrayAlreadyNewCount == 0) {
								minListenScore = arrayLRSumScore[c];
							} else if (minSumScore > arrayLRSumScore[c]) {
								minSumScore = arrayLRSumScore[c];
							}

						}
					}
				} while (redoInput);

				break;

			default:
				System.out.println("錯誤輸入");
			}

			// 超過array可儲存項目時.
			if (arrayAlreadyNewCount == arrayListenScore.length) {
				arrayListenScoreForCopy = Arrays.copyOf(arrayListenScore, arrayListenScore.length * 2);
				arrayReadingScoreForCopy = Arrays.copyOf(arrayReadingScore, arrayReadingScore.length * 2);
				arrayLRSumScoreForCopy = Arrays.copyOf(arrayLRSumScore, arrayLRSumScore.length * 2);

				arrayListenScore = Arrays.copyOf(arrayListenScoreForCopy, arrayListenScoreForCopy.length);
				arrayReadingScore = Arrays.copyOf(arrayReadingScoreForCopy, arrayReadingScoreForCopy.length);
				arrayLRSumScore = Arrays.copyOf(arrayLRSumScoreForCopy, arrayLRSumScoreForCopy.length);

			}

		} while (reWhile);

		// Recycle
		scanner.close();
		arrayListenScore = null;
		arrayReadingScore = null;
		arrayListenScoreForCopy = null;
		arrayReadingScoreForCopy = null;

	}

}
