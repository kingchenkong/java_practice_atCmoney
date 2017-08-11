//撰寫一個程式用來逐步輸入學生的生日，並將所有學生的生日印出，印出時請用以下yyyy/mm/dd格式列印。
//生日包含西元年月日，請在主函式中宣告陣列來作儲存，並定義副函式來完成這個程式。
//*請注意：如果你有餘力，你可以自訂其他的副函式用來檢查日期輸入的格式是否正確，包括日期範圍（1月有31天、閏年問題等等）是否正確。
//請撰寫一個副函式將生日依照最早到最近的順序進行排序，並將結果印出。

//2011 7 9
//293 7 7
//1900 2 29
//1990 7 3
//2013 4 14
//2013 2 28
//2013 12 7
//2199 9 9
//1845 3 31

import java.lang.*;
import java.util.*;
public class Prac0092B2 {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Birthday[] arrBir = new Birthday[10];
		//	- [stu][0] - year
		//         [1] - month
		//         [2] - day

		//		Birthday b = new Birthday(0, 0, 0);
		arrBir = inputData(arrBir);
		sortBirthday(arrBir);

		// output
		for(int i = 0; i < arrBir.length; i++) {
			if(arrBir[i] != null) {
				arrBir[i].printBirthDay();
				System.out.println("");
			}
		}



	}
	//##########
	// function
	//##########
	// - 流程
	public static Birthday[] inputData(Birthday[] arrB) {
		int dataCount = 0;
		do {
			//宣告 物件
			Birthday b = new Birthday( 1900, 1, 1);
			System.out.println("生日格式 : yyyy mm dd");
			System.out.println("請輸入生日 : ");
			Scanner sc = new Scanner(System.in);
			String inputStr = sc.nextLine();
			// 判斷 -1 跳出迴圈
			if( inputStr.equals("-1") ) {
				return arrB;
			}
			
			if(b.scanBirthDay(inputStr)) {
				arrB[dataCount] = b;
				dataCount++;
			}
			
			//擴增陣列
			if(dataCount == arrB.length) {
				arrB = Arrays.copyOf(arrB, arrB.length * 2);
			}

		} while(true);

	}
	// 排序
	public static void sortBirthday(Birthday[] arrDate) {
		//排序 年
		for(int i = 0; i < arrDate.length - 1; i++) {
			for(int j = i + 1; j < arrDate.length - 2; j++ ) {
				if(arrDate[j] != null) {
					if(Birthday.isEarlier(arrDate[j], arrDate[i])) {
						Birthday temp = arrDate[i];
						arrDate[i] = arrDate[j];
						arrDate[j] = temp;
					}
				}
			}
		}
	}

	// - 版面
	// 分隔線
	public static void line(String str, int count, boolean br) {
		for(int i = 0; i < count; i++) {
			System.out.printf("%s", str);
		}
		if(br)
			System.out.println("");
	}
	public static void printStatusBar(String str) {
		// 上面的線
		System.out.print(" ");
		line("--", str.length() + 1, false);
		System.out.println(" ");

		// message
		System.out.print("||");
		line(" ", str.length() / 2, false);
		System.out.print(str);
		line(" ", str.length() / 2, false);
		System.out.println("||");

		// 下面的線
		System.out.print(" ");
		line("--", str.length() + 1, false);
		System.out.println(" ");
	}

	// - test
	public static void showArrInt(int[] arr) {

		System.out.println("arr => ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");
	}

}
//#######
// class
//#######
class Birthday {
	private int year;
	private int month;
	private int day;
	//建構函式
	public Birthday(int y, int m, int d) {
		if(isValid(y, m, d)) {
			year = y;
			month = m;
			day = d;

		} else {
			year = 0;
			month = 0;
			day = 0;
		}
	}
	//########
	// method
	//########
	public void printBirthDay() {
		System.out.printf("%4d年 %02d月 %02d日", year, month, day);
		return;
	}
	public boolean scanBirthDay(String inputStr) {
		//		Scanner sc = new Scanner(System.in);
		//		String inputStr = sc.nextLine();
		//		if(inputStr == "-1") {
		//			return;
		//		}
		String[] arrSplit = inputStr.split(" ", 3);
		int y, m, d;
		try {
			y = Integer.parseInt(arrSplit[0]);
			m = Integer.parseInt(arrSplit[1]);
			d = Integer.parseInt(arrSplit[2]);
		} catch(Exception E) {
			y = 0;
			m = 0;
			d = 0;
		}
		// 檢查字串是否合法
		if(isValid( y, m, d)) {
			year = y;
			month = m;
			day = d;
			return true;
		}
		return false;
	}
	public static boolean isEarlier(Birthday a, Birthday b) {
		if(a.year > b.year) {
			return false; 
		}
		if(a.year == b.year) {
			if(a.month > b.month) {
				return false;
			}
			if(a.month == b.month) {
				if(a.day > b.day) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isValid(int y, int m, int d) {

		// 判斷 閏年
		boolean isLeap = false;
		boolean yearIsOk = false, monthIsOk = false, dayIsOk = false;
		int[] arrMonthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((y < 1) || (y > 9999)) {
			System.out.println("不存在該年份.");
		} else if (y % 4 == 0) {
			isLeap = true;
			yearIsOk = true;
			if (y % 100 == 0)
				isLeap = false;
			if (y % 400 == 0)
				isLeap = true;
		} else {
			isLeap = false;
			yearIsOk = true;
		}
		// 月份
		if(yearIsOk) {
			if ((m < 1) || (m > 12)) {
				System.out.println("不存在該月份.");
			} else {
				monthIsOk = true;
			}
		}
		// 日期
		if(yearIsOk && monthIsOk) {
			if ((d < 1) || (d > 31)) {
				System.out.println("不存在該日期.");
			} else {
				if (isLeap && (m == 2)) {
					if (d <= 29) {
						dayIsOk = true;
					}
				} else if (d <= arrMonthDays[m - 1]) {
					dayIsOk = true;
				} else {
					dayIsOk = false;
					System.out.println("該日期不存在");
				}
			}
		}
		if (yearIsOk && monthIsOk && dayIsOk) {
			return true;
		}
		return false;
	}
}
