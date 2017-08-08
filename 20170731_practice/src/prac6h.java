
//難度二：
//承上，請判斷抽出的五張牌的組合為何。
//組合包括：
//散牌、一對、兩對、三條、順子、同花、葫蘆、四條、同花順，與同花大順
//有關花色組合的說明請見：
//https://www.intellipoker.tw/articles/?id=47
//提示：你可針對組合撰寫不同的函式用來判斷是否抽出的牌組有滿足某個特定花色組合。
import java.util.Scanner;

public class prac6h {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] pokerPool = new int[52];
		int level = 0;

		for (int i = 0; i < 52; i++) {
			pokerPool[i] = i;
		}
		showArray(pokerPool);
		// 洗牌 開始
		System.out.println("洗牌後:");
		shuffleCard(pokerPool);
		showArray(pokerPool);
		// - 抽五張牌
		longLine("-");
		int[] pick5Card = new int[5];
		for (int i = 0; i < 5; i++) {
			// 抽排底 五張
			pick5Card[i] = pokerPool[i];
		}
		showArray(pick5Card);
		System.out.println("No.#\tColor  Num");
		longLine("#");
		for (int i = 0; i < pick5Card.length; i++) {
			System.out.print("No." + (i + 1) + "\t");
			printColorAndNum(pick5Card[i], true);
			System.out.print("\t");
			printColorAndNum(pick5Card[i], false);
			System.out.println("");
		}
		longLine("&");
		ratingLevel(pick5Card);
		longLine("-");
		level = ratingLevel(pick5Card);
		System.out.println("level = " + level);
		showLevel(level);

	}

	// ##########
	// function
	// ##########
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
			System.out.printf(" %s ", str);
		}
		System.out.println("");
	}

	// - 洗牌
	public static void shuffleCard(int[] array) {
		int temp = 0;
		int r = 0;
		for (int i = 0; i < 52; i++) {
			// 換牌
			r = (int) (Math.random() * 51);
			temp = array[i];
			array[i] = array[r];
			array[r] = temp;
		}
		return;
	}

	// - print 花色, 數字
	public static void printColorAndNum(int code, boolean showColorOrNum) { // true -> color, false -> num
		int color = -1;
		int num = -1;

		color = code % 4;
		num = (code / 4) + 1;
		// 花色
		if (showColorOrNum) {
			switch (color) {
			case 0:
				System.out.print("Clover");
				break;

			case 1:
				System.out.print("Diamond");
				break;

			case 2:
				System.out.print("Heart");
				break;

			case 3:
				System.out.print("Spade");
				break;

			default:
				System.out.print(" -- ");
			}
		}
		// 數字
		if (!showColorOrNum) {
			switch (num) {
			case -1:
				System.out.print("->Error<-");
				break;
			case 1:
				System.out.print("-A-");
				break;

			case 11:
				System.out.print("-J-");
				break;

			case 12:
				System.out.print("-Q-");
				break;

			case 13:
				System.out.print("-K-");
				break;

			default:
				System.out.printf("%2d", num);
			}
		}
		return;
	}

	// 評級
	public static int ratingLevel(int[] array) {
		int color = -1;
		int num = -1;
		int level = 0;
		int[] arrayC = new int[5];
		int[] arrayN = new int[5];

		for (int i = 0; i < 5; i++) {
			arrayC[i] = array[i] % 4;
			arrayN[i] = array[i] / 4 + 1;
		}
		// bubble sort
		bubble_Sort(arrayN, true);
		boolean aceIsFirst = (arrayN[0] == 1);
		// 找每個數字出現次數
		int[] arrayNumAppear = new int[13];

		for (int i = 0; i < arrayN.length; i++) {
			arrayNumAppear[arrayN[i] - 1] += 1;
		}
		// 最多出現次數
		int maxAppear = 0;
		for (int i = 0; i < arrayNumAppear.length; i++) {
			if (arrayNumAppear[i] > maxAppear) {
				maxAppear = arrayNumAppear[i];
			}
		}
		// 順
		// 連續數字
		int continuousCount = 0;
		for (int i = 0; i < arrayN.length - 1; i++) {
			if (arrayN[i] == (arrayN[i + 1] - 1)) {
				continuousCount += 1;
			}
			if ((i == 1) && (arrayN[i] == 10) && (arrayN[0] == 1)) {
				continuousCount += 1;
			}
		}
		if (continuousCount == 4) {
			level = 4; // - 順子
		}
		// 花
		// 花色相同
		int equalColorCount = 1;
		for (int i = 0; i < arrayC.length - 1; i++) {
			if (arrayC[i] == arrayC[i + 1]) {
				equalColorCount += 1;
			}
		}
		if ((equalColorCount == 5) && (continuousCount == 4) && (arrayNumAppear[0] == 1) && (arrayNumAppear[8] == 0)) {
			level = 9; // - 同花大順
			return 9;
		} else if ((equalColorCount == 5) && (continuousCount == 4)) {
			level = 8; // - 同花順
			return 8;
		} else if (equalColorCount == 5) {
			level = 5; // - 同花
		}
		// 條,對
		// 鐵支
		if (maxAppear == 4) {
			level = 7;
			// return 7;
		} else if (maxAppear == 3) {
			for (int i = 0; i < arrayNumAppear.length; i++) {
				if (arrayNumAppear[i] == 2) {
					// 葫蘆
					level = 6;
					return 6;
				} else {
					// 三條
					level = 3;
					return 3;
				}
			}
		} else if (maxAppear == 2) {
			int count = 0;
			for (int i = 0; i < arrayNumAppear.length; i++) {
				if (arrayNumAppear[i] == 2) {
					count += 1;
				}
			}
			if (count == 2) {
				// 二對
				level = 2;
				// return 2;
			} else if (count == 1) {
				// 一對
				level = 1;
				// return 1;

			} else {
				level = 0;
				// return 0;
			}
		}
		return level;
	}

	public static void showLevel(int level) {
		switch (level) {
		case 0:
			System.out.println(" - 散牌 - ");
			break;
		case 1:
			System.out.println(" - 一對 - ");
			break;
		case 2:
			System.out.println(" - 二對 - ");
			break;
		case 3:
			System.out.println(" - 三條 - ");
			break;
		case 4:
			System.out.println(" - 順子 - ");
			break;
		case 5:
			System.out.println(" - 同花 - ");
			break;
		case 6:
			System.out.println(" - 葫蘆 - ");
			break;
		case 7:
			System.out.println(" - 鐵支 - ");
			break;
		case 8:
			System.out.println(" ＊ 同花順 ＊ ");
			break;
		case 9:
			System.out.println(" ＊＊＊  $ ＄＄＄＄＄＄＄＄＄＄＄＄＄ $ ＊＊＊ ");
			System.out.println(" ＊＊＊   ＄＄＄＄＄ 花 ＄＄ 順 ＄＄＄ ＊＊＊ ");
			System.out.println(" ＊＊＊   ＄＄＄ 同 ＄＄ 大 ＄＄＄＄＄ ＊＊＊ ");
			System.out.println(" ＊＊＊  $ ＄＄＄＄＄＄＄＄＄＄＄＄＄ $ ＊＊＊ ");
			break;

		default:
			System.out.println("->Error<-");
		}
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
	// ######
	// last }
}