
//難度五：
//請計算出每位學生某一科的名次，並算出其中的平均值、標準差與中間值。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Insert new data (SN/ENGLISH/MATH): 0 50 30 
//Insert new data (SN/ENGLISH/MATH): 1 100 83 
//Insert new data (SN/ENGLISH/MATH): 2 100 83 
//Insert new data (SN/ENGLISH/MATH): 3 50 30
//Insert new data (SN/ENGLISH/MATH): 4 61 4 
//Insert new data (SN/ENGLISH/MATH): 8 70 100 
//Insert new data (SN/ENGLISH/MATH): 6 10 100 
//Insert new data (SN/ENGLISH/MATH): -1 -1 -1 
//
//Option: 1) Add. 2) Histogram. 3) Output. 4) Query. 5) Rank. -1) Quit: 5
//1) English. 2) Math. 3) Average. -1) Back: 3
//Start: 50
//End: 100
//SN		ENG.		MATH.	AVG.		Rank
//----------------------------------------------------------------------
//1		100		  83		 91		1
//2		100		  83		 91		1
//6		 10		 100		 55		4
//8		 70		 100		 85		3
//-----------------------------------------------------------
//Average: 80.50
//STD: 14.92
//Median: 91
//
//Option: 1) Add. 2) Histogram. 3) Output. 4) Query. 5) Rank. -1) Quit:
//
//
//標準差可由以下公式求得；為x1、x2、...、xN的平均值。
import java.util.Arrays;
import java.util.Scanner;

public class prac6j005 {

	// static
	public static Scanner scanner = new Scanner(System.in);

	// ##########
	// main
	// ##########
	public static void main(String[] args) {
		// declare, initial
		int[][] arrayStuData = new int[5][3];
		Arrays.fill(arrayStuData[0], -1);
		Arrays.fill(arrayStuData[1], -1);
		Arrays.fill(arrayStuData[2], -1);
		Arrays.fill(arrayStuData[3], -1);
		Arrays.fill(arrayStuData[4], -1);
		// [0], Student Number
		// [1], English Score
		// [2], Math Score
		// [3], Average
		// [4], Rank
		// var - process control
		int option = 0;

		// ##########
		// Begin
		// ##########
		insertNewData(arrayStuData);
		// test
		// int[] arr0 = { 0, 1, 2, 3, 4, 8, 6, -1, -1, -1};
		// int[] arr1 = {50, 100, 100, 50, 61, 70, 10, -1, -1, -1};
		// int[] arr2 = {30, 83, 83, 30, 4, 100, 100, -1, -1, -1};
		// arrayStuData[0] = Arrays.copyOf(arr0, arr0.length);
		// arrayStuData[1] = Arrays.copyOf(arr1, arr1.length);
		// arrayStuData[2] = Arrays.copyOf(arr2, arr2.length);
		// showArray(arrayStuData[0]);
		// showArray(arrayStuData[1]);
		// showArray(arrayStuData[2]);
		// longLine("###");
		// 取平均值
		getAverage(arrayStuData);
		getRank(arrayStuData);

		// option
		do {
			System.out.println("Option: 1) Add. 2) Histogram. 3) Output. 4) Query 5) Rank -1) Quit: ");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				insertNewData(arrayStuData);
				getAverage(arrayStuData);
				getRank(arrayStuData);
				break;
			case 2:
				histogram(arrayStuData);
				break;
			case 3:
				outputScore(arrayStuData, 0);
				break;
			case 4:
				query(arrayStuData);
				break;
			case 5:
				outputScore(arrayStuData, 1);
				break;
			case -1:
				System.out.println("Bye!!");
				System.exit(0);
				break;

			default:
				System.out.println("--> Error.<--");
			}
		} while (true); // back to select option

	}

	// ################
	// function - 流程
	// ################
	// - 輸入資料
	public static void insertNewData(int[][] data) {
		int sn = -1, en = -1, ma = -1;
		int insertIndex = 0;
		do {
			System.out.print("\nInsert new data (SN/ENGLISH/MATH): ");
			sn = scanner.nextInt();
			en = scanner.nextInt();
			ma = scanner.nextInt();
			// quit insert
			if ((sn == -1) && (en == -1) && (ma == -1)) {
				break;
			}
			// Error process
			if ((sn < 0) || (en < 0) || (ma < 0) || (en > 100) || (ma > 100)) {
				sn = -1;
				en = -1;
				ma = -1;
				System.out.println("--> Error.<--");
			} else {
				// 合法輸入時
				// 學號不得重複
				boolean dataDuplicated = false;
				for (int i = 0; i < data[0].length; i++) {
					if (data[0][i] == sn) {
						System.out.println("學號" + sn + " 重複輸入 ");
						dataDuplicated = true;
						break;
					}
				}
				if (dataDuplicated) {
					sn = -1;
					en = -1;
					ma = -1;
					System.out.println("--> Error.<--");
				} else {

					// check data index => sn is zero
					for (int i = 0; i < data[0].length; i++) {
						if (data[0][i] == -1) { // sn = data[0]
							insertIndex = i;
							break;
						}
						if (i == (data[0].length - 1)) {
							data[0] = appenIntArray(data[0]);
							data[1] = appenIntArray(data[1]);
							data[2] = appenIntArray(data[2]);

							// test
							// showArray(data[0]);
							// showArray(data[1]);
							// showArray(data[2]);
							// longLine("###");
						}
					}
					// store in array
					data[0][insertIndex] = sn;
					data[1][insertIndex] = en;
					data[2][insertIndex] = ma;
				}

			}
		} while (true);// repeat to -1, -1, -1
		return;
	}

	// 計數直條圖
	public static void histogram(int[][] array) {
		int option = 0;
		do {
			System.out.println("1) English. 2) Math. -1) Back: ");
			option = scanner.nextInt();
			if ((option == 1) || (option == 2) || (option == -1)) {
				break;
			} else {
				System.out.println("--> Error.<--");
			}
		} while (true);

		switch (option) {
		case 1:
			int[] arrayGetStarInEnglish = new int[11];
			for (int i = 0; i < array[1].length; i++) {
				if (array[0][i] != -1) {
					int j = array[1][i] / 10;
					arrayGetStarInEnglish[j] += 1;
				}
			}
			System.out.println("0\t10\t20\t30\t40\t50\t60\t70\t80\t90\t100");
			longLine("------");
			for (int j = 0; j < array[1].length; j++) { // 假若全部人100 100分人數也不會超過總人數
				for (int i = 0; i < arrayGetStarInEnglish.length; i++) {
					if (arrayGetStarInEnglish[i] > 0) {
						System.out.print("*\t");
						arrayGetStarInEnglish[i] -= 1;
					} else {
						System.out.print(" \t");
					}
				}
				System.out.println("");
			}
			break;

		case 2:
			int[] arrayGetStarInMath = new int[11];
			for (int i = 0; i < array[2].length; i++) {
				if (array[0][i] != -1) {
					int j = array[2][i] / 10;
					arrayGetStarInMath[j] += 1;
				}
			}
			System.out.println("0\t10\t20\t30\t40\t50\t60\t70\t80\t90\t100");
			longLine("------");
			for (int j = 0; j < array[1].length; j++) { // 假若全部人100 100分人數也不會超過總人數
				for (int i = 0; i < arrayGetStarInMath.length; i++) {
					if (arrayGetStarInMath[i] > 0) {
						System.out.print("*\t");
						arrayGetStarInMath[i] -= 1;
					} else {
						System.out.print(" \t");
					}
				}
				System.out.println("");
			}
			break;

		case -1:
			// back
			break;
		default:
			System.out.println("--> Switch Error.<--");
		}

		return;
	}

	// - 輸出成績
	// 0, pass mode
	// 1, rank mode - 難度五
	public static void outputScore(int[][] arrScore, int mode) {
		int[] arrPass = new int[arrScore[0].length];
		Arrays.fill(arrPass, -1);
		// av, pass
		for (int i = 0; i < arrScore[0].length; i++) {
			if (arrScore[3][i] >= 60) {
				arrPass[i] = 1;
			} else {
				arrPass[i] = 0;
			}
		}

		// - 輸出成績 - output
		if (mode == 0) {
			System.out.println("SN\tENG.\tMATH.\tAVG.\tPASSED");
			longLine("----");
			for (int i = 0; i < arrScore[0].length; i++) {
				if (arrScore[0][i] != -1) {
					System.out.printf("%2d\t%3d \t%3d \t%3d \t", arrScore[0][i], arrScore[1][i], arrScore[2][i],
							arrScore[3][i]);
					if (arrPass[i] == 1) {
						System.out.println("y");
					} else if (arrPass[i] == 0) {
						System.out.println("n");
					} else {
						System.out.println("-");
					}
				} else {

					break;
				}
			}
		}
		if (mode == 1) {
			int[] arrQ = new int[arrScore[0].length];
			int option = 0;
			int start = 0;
			int end = 0;
			// - 輸出成績 - 選擇科目
			do {
				System.out.print("1) English. 2) Math. 3) Average. -1) Back: ");
				option = scanner.nextInt();
				if ((option > 3) || (option == 0) || (option < -1)) {
					System.out.println("--> Error.<--");
				} else {
					if (option == -1) {
						break;
					}
					if (option == 1) {
						// English
						arrQ = Arrays.copyOf(arrScore[1], arrScore[1].length);
						break;
					}
					if (option == 2) {
						// Math
						arrQ = Arrays.copyOf(arrScore[2], arrScore[2].length);
						break;
					}
					if (option == 3) {
						// Query
						arrQ = Arrays.copyOf(arrScore[3], arrScore[3].length);
						break;
					}
				}
			} while (true);

			// - 輸出成績 - 選擇範圍
			do {
				System.out.print("\nStart: ");
				start = scanner.nextInt();
				System.out.print("\nEnd: ");
				end = scanner.nextInt();

				if (start <= end) {
					if ((start >= 0) || (start <= 100)) {
						break;
					} else {
						System.out.println("--> Error.<--");
					}
					if ((end >= 0) || (end <= 100)) {
						break;
					} else {
						System.out.println("--> Error.<--");
					}
				} else {
					System.out.println("--> Error.<--");
				}

			} while (true);
			// - 輸出成績 - 搜尋
			// - 輸出成績 - 顯示
			// 加總運算, 補 0
			int[] arrNowSubject = new int[arrScore[0].length];
			Arrays.fill(arrNowSubject, 0);
			double nowSubjectSum = 0;
			int areaCount = 0;

			System.out.println("SN\tENG.\tMATH.\tAVG.\tRANK");
			longLine("----");
			for (int i = 0; i < arrScore[0].length; i++) {
				if ((arrQ[i] >= start) && (arrQ[i] <= end)) {
					if (arrScore[0][i] != -1) {
						System.out.printf("%2d\t%3d \t%3d \t%3d \t%2d\n", arrScore[0][i], arrScore[1][i],
								arrScore[2][i], arrScore[3][i], arrScore[4][i]);
						arrNowSubject[i] = arrScore[option][i];
						areaCount += 1;
					} else {
						break;
					}
				}
			}
			longLine("---");
			// 平均值
			for (int i = 0; i < arrNowSubject.length; i++) {
				nowSubjectSum += arrNowSubject[i];
			}
			nowSubjectSum /= areaCount;
			System.out.printf("平均值 : %.2f \n", nowSubjectSum);

			// 標準差
			double nowSubjectAv = nowSubjectSum;
			double nowSubjectSquare = 0;
			for (int i = 0; i < arrNowSubject.length; i++) {
				nowSubjectSquare += Math.pow(arrNowSubject[i], 2);
			}
			nowSubjectSquare /= areaCount;
			double STD = Math.sqrt(nowSubjectSquare - Math.pow(nowSubjectAv, 2));
			System.out.printf("標準差 : %.2f\n", STD);
			// 中間數
			int midPos = areaCount / 2;

			if (areaCount % 2 == 1) {
				midPos += 1;
			}
			System.out.println("中間數 : " + arrScore[option][midPos]);

		}

		return;
	}

	// - 平均值
	public static void getAverage(int[][] arrScore) {
		int[] arrAv = new int[arrScore[0].length];
		// av
		for (int i = 0; i < arrScore[0].length; i++) {
			arrAv[i] = (arrScore[1][i] + arrScore[2][i]) / 2;
		}
		// copy to [3] => Av
		arrScore[3] = Arrays.copyOf(arrAv, arrScore[0].length);
		return;
	}

	// - 搜尋 - 某範圍內的成績
	public static void query(int[][] arrScore) {
		int[] arrQ = new int[5];
		int option = 0;
		int start = 0;
		int end = 0;

		do {
			System.out.print("1) English. 2) Math. 3) Average. -1) Back: ");
			option = scanner.nextInt();
			if ((option > 3) || (option == 0) || (option < -1)) {
				System.out.println("--> Error.<--");
			} else {
				if (option == -1) {
					break;
				}
				if (option == 1) {
					// English
					arrQ = Arrays.copyOf(arrScore[1], arrScore[1].length);
					break;
				}
				if (option == 2) {
					// Math
					arrQ = Arrays.copyOf(arrScore[2], arrScore[2].length);
					break;
				}
				if (option == 3) {
					// Query
					arrQ = Arrays.copyOf(arrScore[3], arrScore[3].length);
					break;
				}
			}

		} while (true);
		do {
			System.out.print("\nStart: ");
			start = scanner.nextInt();
			System.out.print("\nEnd: ");
			end = scanner.nextInt();

			if (start <= end) {
				if ((start >= 0) || (start <= 100)) {
					break;
				} else {
					System.out.println("--> Error.<--");
				}
				if ((end >= 0) || (end <= 100)) {
					break;
				} else {
					System.out.println("--> Error.<--");
				}
			} else {
				System.out.println("--> Error.<--");
			}

		} while (true);

		// output
		System.out.println("SN\tENG.\tMATH.\tAVG.\tPASSED");
		longLine("----");
		for (int i = 0; i < arrScore[0].length; i++) {
			if ((arrQ[i] >= start) && (arrQ[i] <= end)) {
				if (arrScore[0][i] != -1) {
					System.out.printf("%2d\t%3d \t%3d \t%3d \t", arrScore[0][i], arrScore[1][i], arrScore[2][i],
							arrScore[3][i]);
					if (arrQ[i] >= 60) {
						System.out.println("y");
					} else if (arrQ[i] >= 0) {
						System.out.println("n");
					} else {
						System.out.println("-");
					}
				} else {
					break;
				}
			}
		}
		return;
	}

	// - 排名
	public static void getRank(int[][] arrScore) {
		int[] arrAvCopy = Arrays.copyOf(arrScore[3], arrScore[0].length);
		int[] arrIndex = new int[arrScore[0].length];
		int[] arrRank = new int[arrScore[0].length];

		// test
		longLine("---");
		showArray(arrAvCopy);

		for (int i = 0; i < arrIndex.length; i++) {
			arrIndex[i] = i;
		}
		int temp = 0;
		for (int j = 0; j < arrAvCopy.length; j++) {
			for (int i = 0; i < arrAvCopy.length - j - 1; i++) {
				if (arrAvCopy[i] < arrAvCopy[i + 1]) {
					temp = arrAvCopy[i];
					arrAvCopy[i] = arrAvCopy[i + 1];
					arrAvCopy[i + 1] = temp;
					temp = arrIndex[i];
					arrIndex[i] = arrIndex[i + 1];
					arrIndex[i + 1] = temp;
				}
			}
		}
		// test
		longLine("&&&");
		showArray(arrAvCopy);
		showArray(arrIndex);
		showArray(arrRank);
		int count = 1;
		for (int i = 0; i < arrIndex.length; i++) {
			if (i == 0) {
				arrRank[arrIndex[i]] = 1;
			} else {
				if (arrScore[3][arrIndex[i - 1]] > arrScore[3][arrIndex[i]]) {
					arrRank[arrIndex[i]] = count;
				}
				if (arrScore[3][arrIndex[i - 1]] == arrScore[3][arrIndex[i]]) {
					arrRank[arrIndex[i]] = arrRank[arrIndex[i - 1]];
				}
			}
			count += 1;
		}

		arrScore[4] = Arrays.copyOf(arrRank, arrScore[0].length);
		longLine("---");
		showArray(arrScore[4]);
		longLine("---");
		return;
	}

	// 3 - 氣泡排序法 - bubble sort
	public static void bubble_Sort(int array[], boolean bigToSmall) {
		int temp = 0;
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length - j - 1; i++) {

				// true, big to small
				if ((array[i] > array[i + 1]) && bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				// false, small to big
				if ((array[i] < array[i + 1]) && !bigToSmall) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}

	// ################
	// function - 實用
	// ################
	// - 擴增陣列
	public static int[] appenIntArray(int[] array) {
		int[] arrayForCopy = new int[array.length * 2];
		Arrays.fill(arrayForCopy, -1);
		for (int i = 0; i < array.length; i++) {
			arrayForCopy[i] = array[i];
		}
		return arrayForCopy;
	}

	// - show array
	public static void showArray(int[] array) {
		System.out.print("arrray = { ");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + " }");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		return;
	}

	// - 分隔線
	public static void longLine(String str) {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}
	// last }
}