import java.util.Arrays;
import java.util.Scanner;

public class practiceOnClass {

	public static void main(String[] args) {

		// Declare, Initial
		Scanner scanner = new Scanner(System.in);

		// ########
		// 陣列
		// ########

		// 陣列宣告 與 初始化
		int Ary1[] = new int[] { 5, 3, 6, 1 };
		int[] Ary2 = new int[] { 3, 2, 7, 4, 9 };

		int Ary3[];
		Ary3 = new int[] { 4, 3, 2, 2 };
		int[] Ary4;
		Ary4 = new int[] { 3, 3, 5, 2 };

		int Ary5[] = { 5, 3, 6, 1 };
		int[] Ary6 = { 3, 2, 7, 4, 9 };

		// 取得陣列長度
		System.out.println("Ary1[].length =" + Ary1.length);
		System.out.println("Ary1[].length =" + Ary2.length);

		// .clone() 跟 = 的陣列執行差別
		// Ary3 -> {4,3,2,2};
		// Ary4 -> {3,3,5,2};

		// reset
		Ary3 = new int[] { 4, 3, 2, 2 };
		Ary4 = new int[] { 3, 3, 5, 2 };

		// =
		Ary3 = Ary4;
		System.out.println(" '=' Ary3 = Ary4 --> ");

		for (int i = 0; i < Ary3.length; i++) {
			System.out.println("Ary3[ " + i + " ] = " + Ary3[i]);
		}

		Ary3[2] = 22;
		System.out.println("set -> Ary3[2] = 22");
		System.out.println("Ary3[2] = " + Ary3[2]);
		System.out.println("Ary4[2] = " + Ary4[2]);
		// = => Ary3 參考 Ary4的位址,
		// so Ary3數值 改變時,
		// Ary4數值 '也會' 改變,
		// 因為 '參考' 是使用 '同一個位址'

		// .clone()
		// Ary3 -> {4,3,2,2};
		// Ary4 -> {3,3,5,2};

		// reset
		Ary3 = new int[] { 4, 3, 2, 2 };
		Ary4 = new int[] { 3, 3, 5, 2 };
		Ary3 = Ary4.clone();
		System.out.println(" '.clone()' Ary3 = Ary4 --> ");

		for (int i = 0; i < Ary3.length; i++) {
			System.out.println("Ary3[ " + i + " ] = " + Ary3[i]);
		}

		Ary3[2] = 22;
		System.out.println("set -> Ary3[2] = 22");
		System.out.println("Ary3[2] = " + Ary3[2]);
		System.out.println("Ary4[2] = " + Ary4[2]);
		// .clone() => 複製一個陣列實體,
		// so Ary3數值 改變時,
		// '只會' 改變 Ary3數值, 'Ary4數值不變'
		// cause '實體位址' 不同

		int[] AryPlus;
		// AryPlus = Ary5 + Ary6;

		//
		// System.arraycopy()
		// System.arraycopy(來源陣列, 來源陣列 起始索引, 目的陣列, 目的陣列 起始索引, 複製長度);
		// System.arraycopy(scores1, 0, scores2, 0, scores1.length);
		//
		int scores1[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int scores2[] = new int[scores1.length];

		System.arraycopy(scores1, 0, scores2, 0, scores1.length);

		for (int score : scores2) {
			System.out.println(" scores2 - " + score);
		}
		//
		// Arrays.copyof(來源陣列, 陣列長度)
		//
		int[] arraySource = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] arrayDestination = Arrays.copyOf(arraySource, arraySource.length + 3);

		System.out.print("arrayDestination = { ");
		int countForArrayDestination = 0;
		for (int num : arrayDestination) {
			System.out.print(num);
			countForArrayDestination += 1;
			if (countForArrayDestination != arrayDestination.length) {
				System.out.print(", ");
			} else {
				System.out.println(" }");
			}
		}
		System.out.println("arrayDestination.length = " + arrayDestination.length);
		System.out.println("countForArrayDestination = " + countForArrayDestination);
		//
		//

		// practice-1 - 指定數個隨機數

		System.out.println("你需要幾個數?");
		int n = scanner.nextInt();
		int aFewNumbers[] = new int[n];
		boolean reWhile = true;
		int minNum = 0, maxNum = 0;

		System.out.println("請輸入隨機範圍大小: ");
		do {
			System.out.println("最小範圍: ");
			minNum = scanner.nextInt();

			System.out.println("最大範圍: ");
			maxNum = scanner.nextInt();

			if (minNum > maxNum) {
				System.out.println("小於 最小範圍, 請重新輸入範圍");
				reWhile = true;
			} else {
				reWhile = false;
			}

		} while (reWhile);

		System.out.println("你需要 " + n + " 個數, 從 " + minNum + " ~ " + maxNum);

		// print Array
		for (int i = 0; i < n; i++) {
			aFewNumbers[i] = (int) (Math.random() * (maxNum - minNum)) + minNum; // (0 ~ 0.99) * 總範圍 + 零位點
			// System.out.println("int [" + i + "] = " + aFewNumbers[i]);

		}
		// Enhanced for loop
		int count = 0;
		for (int num : aFewNumbers) {
			System.out.println("Array - aFewNumbers [" + count + "] = " + num);
			count += 1;
		}

		// ########

		// Recycle
		scanner.close();
		Ary1 = null;
		Ary2 = null;
		Ary3 = null;
		Ary4 = null;
		Ary5 = null;
		Ary6 = null;
		aFewNumbers = null;

	}

}
