
//題目
//陣列實習題目三：多維陣列
//
//請使用一個二維陣列，儲存一群平面上的 '離散座標點x與y' 。所謂離散座標點指的是，座標值為 '整數' 。
//其中，二維陣列中的 '每一列代表一組座標' 。在輸出時，請印出每一座標點在平面上與其距離 '最靠近的輸入點' ，同時 '印出距離 '時，請印到 '小數點以下兩位 '。
//執行範例如下所示（使用者輸入部分以黑體字標註）。
//註：假設兩座標點為（x1, y1）與（x2, y2）的距離，則兩點距離d如下：
//d = ( (x1 – x2)^2 + (y1 – y2)^2 )^0.5
//
//Option: 1) Insert. 2) Output. -1) Quit? 1
//請輸入座標:20 25
//
//Option: 1) Insert. 2) Output. -1) Quit? 1
//請輸入座標: 0 45
//
//Option: 1) Insert. 2) Output. -1) Quit? 1
//請輸入座標: 0 0
//
//Option: 1) Insert. 2) Output. -1) Quit? 1
//請輸入座標: 100 25
//
//Option: 1) Insert. 2) Output. -1) Quit? 1
//請輸入座標：50 60
//
//Option: 1) Insert. 2) Output. -1) Quit? 2
//
//(20, 25)	->	(0, 45)		距離：28.28
//(0, 45) 	->	(20, 25) 	距離：28.28
//(0, 0) 	->	(20, 25) 	距離：32.01
//(100, 25) 	->	(50, 60) 	距離：61.03
//(50, 60) 	->	(20, 25) 	距離：46.09
//
//Option: 1) Insert. 2) Output. -1) Quit?
import java.util.Arrays;
import java.util.Scanner;

public class prac3e {

	public static void main(String[] args) {
		// declare, initial
		Scanner scanner = new Scanner(System.in);
		double distance = 0.00;
		int[][] array2axisCoordinate = new int[3][5]; // 0: index, 1: x-coordinate, 2: y-coordinate
		double[][] arrayDistance;
		int maxScanX = 0, maxScanY = 0;
		int minScanX = 0, minScanY = 0;
		// process control
		int option = 0;
		boolean cycleOption = true;
		int indexForCoordinate = 1;
		// input
		int scanX = 0, scanY = 0;

		// begin
		while (cycleOption) {
			System.out.println("\tOption==>\t|1) Insert.\t|2) Output.\t|-1) Quit?");
			option = scanner.nextInt();

			switch (option) {
			case 1: // insert
				// 設定 -array2axisCoordinate[0] is 哪一row 已使用
				for (int i = 0; i < array2axisCoordinate[0].length; i++) {
					if (array2axisCoordinate[0][i] == 0) {
						array2axisCoordinate[0][i] = i + 1;
						indexForCoordinate = i + 1;
						break;

					}
					// array append
					if (i == (array2axisCoordinate[0].length - 1)) {
						int[] arrayForCopy;
						// [0]
						arrayForCopy = Arrays.copyOf(array2axisCoordinate[0], array2axisCoordinate[0].length + 3);
						array2axisCoordinate[0] = Arrays.copyOf(arrayForCopy, arrayForCopy.length);
						// [1]
						arrayForCopy = Arrays.copyOf(array2axisCoordinate[1], array2axisCoordinate[1].length + 3);
						array2axisCoordinate[1] = Arrays.copyOf(arrayForCopy, arrayForCopy.length);
						// [2]
						arrayForCopy = Arrays.copyOf(array2axisCoordinate[2], array2axisCoordinate[2].length + 3);
						array2axisCoordinate[2] = Arrays.copyOf(arrayForCopy, arrayForCopy.length);
					}
				}
				// scan
				System.out.print("\n請輸入座標: ");
				scanX = scanner.nextInt();
				scanY = scanner.nextInt();
				array2axisCoordinate[1][indexForCoordinate - 1] = scanX;
				if (scanX >= maxScanX) {
					maxScanX = scanX;
				}
				if (scanX <= minScanX) {
					minScanX = scanX;
				}

				array2axisCoordinate[2][indexForCoordinate - 1] = scanY;
				if (scanX >= maxScanX) {
					maxScanY = scanY;
				}
				if (scanX <= minScanX) {
					minScanY = scanY;
				}
				break;

			case 2: // output
				// var
				int x1 = 0, x2 = 0;
				int y1 = 0, y2 = 0;
				int alreadyNewCount = 0;

				for (int i = 0; i < array2axisCoordinate[0].length; i++) {
					if (array2axisCoordinate[0][i] == 0) {
						alreadyNewCount = i;
						break;
					} else {
						alreadyNewCount = array2axisCoordinate[0].length;
					}
				}
				arrayDistance = new double[alreadyNewCount][];
				double[] arrayMinDistance = new double[alreadyNewCount];
				int[] arrayMostClosePointIndex = new int[alreadyNewCount];

				double tempD = Math.sqrt(Math.pow((maxScanX - minScanX), 2) + Math.pow((maxScanY - minScanY), 2));

				Arrays.fill(arrayMinDistance, tempD);

				System.out.print("");

				// 求arrayDistance
				for (int i = 0; i < alreadyNewCount; i++) {
					// 建立需要的array數量
					// arrayDistance[i] = new double[array2axisCoordinate[0].length - i - 1];
					arrayDistance[i] = new double[alreadyNewCount];

					// for(int j = i + 1; j < array2axisCoordinate[0].length; j++) {
					for (int j = 0; j < alreadyNewCount; j++) {

						x1 = array2axisCoordinate[1][i];
						x2 = array2axisCoordinate[1][j];
						y1 = array2axisCoordinate[2][i];
						y2 = array2axisCoordinate[2][j];
						distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y1 - y2), 2));
						// arrayDistance[i][j - i - 1] = distance;
						arrayDistance[i][j] = distance;

						if ((distance < arrayMinDistance[i]) && (i != j)) {
							arrayMinDistance[i] = distance;
							arrayMostClosePointIndex[i] = j;
						}
					}
				}

				System.out.println("**************************************");
				for (int j = 0; j < alreadyNewCount; j++) {
					System.out.printf("( %3d, %3d ) ->\t", array2axisCoordinate[1][j], array2axisCoordinate[2][j]);
					System.out.printf("最近的點: ( %3d, %3d )\t", array2axisCoordinate[1][arrayMostClosePointIndex[j]],
							array2axisCoordinate[2][arrayMostClosePointIndex[j]]);
					System.out.printf(" 最短距離: %8.2f\n", arrayMinDistance[j]);
				}
				System.out.println("**************************************");

				break;

			case -1: // quit
				cycleOption = false;
				break;
			default:
				System.out.println("\t-- unidentified input --");
			}
		}
		System.out.println("is Over.");

		// recycle
		scanner.close();
	}

}
