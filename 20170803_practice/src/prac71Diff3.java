
//大小寫轉換
//
//一、程式範例描述：
//輸入一個字元, 判斷是大寫或小寫或是其他字元, 並轉換其大小寫輸出 (大寫 ->小寫, 小寫->大寫)
//
//
//二、輸入說明：
//輸入一個字元(範圍:A-Z,a-z)
////輸入一個字元, 判斷是大寫或小寫或是其他字元
////輸入一個字元, 轉換其大小寫輸出 (大寫 ->小寫, 小寫->大寫)
//
//三、輸出說明：
//輸出轉換後的大小寫字元
//
//四、輸入範例：
//請輸入一個字元: a
//請輸入一個字元: B
//
//五、輸出範例： 
//a為小寫，其大寫為A
//B為大寫，其小寫為b

import java.util.Scanner;

public class prac71Diff3 {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] arrCheck = new int[10];
		// int scanCheck = 0;
		// 1, 大寫
		// 2, 小寫
		// -1, 特殊字元
		// char[] arrChar = new char[10];
		char scanChar;

		do {
			System.out.println("請輸入 一個字元 : ( 0, 離開)");
			scanChar = scanner.next().charAt(0);

			if (((int) scanChar >= 65) && ((int) scanChar <= 90)) {
				System.out.println(scanChar + " 是 大寫, 其 小寫是 " + (char) ((int) scanChar + 32));
			} else if (((int) scanChar >= 97) && ((int) scanChar <= 122)) {
				System.out.println(scanChar + " 是 小寫, 其 大寫是 " + (char) ((int) scanChar - 32));
			} else {
				System.out.println(scanChar + "是 特殊字元");
			}
		} while (scanChar != '0');

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