
//判斷字串是字母還是數字
//
//一、程式範例描述：
//輸入陣列字元，判斷每個字元是字母還是數字，最後在判斷輸入的陣列字元。
//
//二、輸入說明：
//輪流輸入陣列字元，陣列大小:10
//
//三、輸出說明：
//輸出每個陣列字元是字母還是數字，最後再輸出陣列字元是否為數字
//
//四、輸入範例：
//a
//b
//c
//d
//e
//1
//2
//3
//4
//5
//
//五、輸出範例： 
//a是字母
//b是字母
//c是字母
//d是字母
//e是字母
//1是數字
//2是數字
//3是數字
//4是數字
//5是數字
//abcde12345不是數字

import java.util.Scanner;

public class prac71Diff2 {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrCheck = new int[10];
		// 1, 數字
		// 2, 字母
		// -1, 不是字母也不是數字
		char[] arrChar = new char[10];
		char scanChar;

		System.out.print("\n輸入 10 個字元 : ");
		// 輸入
		for (int i = 0; i < arrChar.length; i++) {
			scanChar = scanner.next().charAt(0);
			if (((int) scanChar >= 48) && ((int) scanChar <= 57)) {
				// if - 數字
				arrCheck[i] = 1;
			} else if (((int) scanChar >= 65) && ((int) scanChar <= 90)
					|| ((int) scanChar >= 97) && ((int) scanChar <= 122)) {
				// if - 字母
				arrCheck[i] = 2;
			} else {
				// else - 不是字母也不是數字
				arrCheck[i] = -1;
			}
			arrChar[i] = scanChar;
		}

		// 輸出 10個字元
		longLine("---");
		for (int i = 0; i < arrChar.length; i++) {
			System.out.print("\n" + arrChar[i]);
			if (arrCheck[i] == 1)
				System.out.println("\t 是 數字");
			if (arrCheck[i] == 2)
				System.out.println("\t 是 字母");
			if (arrCheck[i] == -1)
				System.out.println("\t 不是字母也不是數字");
		}

		// 輸出 arrChar 是什麼組合
		int multiCheck = 1;
		for (int i = 0; i < arrCheck.length; i++) {
			multiCheck *= arrCheck[i];
		}
		System.out.print(arrChar);
		if (multiCheck == 1) {
			System.out.println("\t 是 一堆數字");
		} else if (multiCheck == 1024) {
			System.out.println("\t 是 一群字元");
		} else {
			System.out.println("\t 不是字母也不是數字");
		}
	}

	// function
	// - 分隔線
	public static void longLine(String str) {
		for (int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}
}