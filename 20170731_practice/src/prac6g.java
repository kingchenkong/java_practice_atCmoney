import java.util.Scanner;

public class prac6g {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] poker = new int[4][13];
		int[] pokerPool = new int[52];
		int[] pick5Crd = new int[5];

		for (int i = 0; i < 52; i++) {
			pokerPool[i] = i;
		}
		showArray(pokerPool);
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

	// - 確認花色, 數字
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
}
