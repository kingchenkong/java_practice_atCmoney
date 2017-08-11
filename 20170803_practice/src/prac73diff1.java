
//字串切割
//
//一、程式範例描述：
//輸入日期"2017-08-03" 這字串轉換成 "民國106 年 08 月 03 日"
//
//二、輸入說明：
//輸入西元日期字串。
//
//三、輸出說明：
//輸出民國日期字串。
//
//四、輸入範例：
//2017-08-03
//
//五、輸出範例： 
//民國106 年 08 月 03 日

import java.util.Scanner;

public class prac73diff1 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean redo = false;
		String[] arrStrDateSplit;
		String strDate;
		int[] arrParse;
		do {
			do {
				redo = false;
				System.out.println("ex: 2044-12-25");
				System.out.print("輸入西元日期 : ");

				strDate = scanner.nextLine();
				// System.out.println(strDate + "\n--------------------");
				arrStrDateSplit = strDate.split("-");
				for (String str : arrStrDateSplit) {
					// System.out.println(str);
				}
				arrParse = new int[arrStrDateSplit.length];
				for (int i = 0; i < arrStrDateSplit.length; i++) {
					try {
						arrParse[i] = Integer.parseInt(arrStrDateSplit[i]);
						// System.out.printf("%d -> %d\n", i, arrParse[i]);

					} catch (Exception exception) {
						System.out.println("輸入格式錯誤");
						redo = true;
					}
				}
			} while (redo);
			
			//判斷 閏年
			boolean isLeap = false;
			boolean yearIsOk = false, monthIsOk = false, dayIsOk = false;
			int[] arrMonthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if ((arrParse[0] < 1) || (arrParse[0] > 9999)) {
				System.out.println("不存在該年份.");
			} else if (arrParse[0] % 4 == 0) {
				isLeap = true;
				yearIsOk = true;
				if (arrParse[0] % 100 == 0)
					isLeap = false;
				if (arrParse[0] % 400 == 0)
					isLeap = true;

			} else {
				isLeap = false;
				yearIsOk = true;
			}
			if ((arrParse[1] < 1) || (arrParse[1] > 12)) {
				System.out.println("不存在該月份.");
			} else {
				monthIsOk = true;
			}
			if ((arrParse[2] < 1) || (arrParse[2] > 31)) {
				System.out.println("不存在該日期.");
			} else {

				if ((isLeap) && (arrParse[1] == 2)) {
					if (arrParse[2] <= 29) {
						dayIsOk = true;
					}
				} else if (arrParse[2] <= arrMonthDays[arrParse[1] - 1]) {
					dayIsOk = true;
				} else {
					dayIsOk = false;
					System.out.println("該日期不存在");
				}
			}

			if (yearIsOk && monthIsOk && dayIsOk) {
				break;
			}
			// System.out.println("該日期不存在");
			// System.out.println("--------------------------------");
		} while (true);
		System.out.println("--------------------------------");
		arrParse[0] -= 1911;
		System.out.println(" 民國 " + arrParse[0] + "年 " + arrParse[1] + " 月" + arrParse[2] + "日");

	}

}
