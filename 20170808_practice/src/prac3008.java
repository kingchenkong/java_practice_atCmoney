//測試迴文
//
//（迴文，palindrome）迴文是一種正向拼法與逆向拼法都相同的字串（忽略空白不計）。例如"radar"、"able was i ere i saw elba"、"a man a plan a canal panama"。
//請撰寫一個遞迴的副函式TestPalindrome，測試某個存在在陣列中的字串是否為迴文，如果是的話傳回1，否則傳回0。
//函式原型如下：
//int TestPalindrome (char a[], int leftEnd, int rightEnd);
//
//陣列a為一個 '已去除空白' 的字元陣列， leftEnd與rightEnd為陣列的index，代表陣列範圍的起迄兩端。如果陣列a中的字串是否為迴文，如果 '是的話傳回1' ， '否則傳回0' ；
//禁止使用全域變數，如果沒有用到遞迴者以零分計。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//
//Option: 1) Test Palindrome. -1) Quit: 1
//Input a string: a man a plan a canal panama
//The input string is a palindrome.
//
//Option: 1) Test Palindrome. -1) Quit: 1
//Input a string: a man
//The input string is not a palindrome.
//
//Option: 1) Test Palindrome. -1) Quit: 
//
//
//
//請寫註解，並注意程式碼排版。
import java.util.*;
public class prac3008 {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		do {
			System.out.println("Option: 1) Test Palindrome. -1) Quit: ");
			int option = scanner.nextInt();
			if(option == 1) {
				break;
			} else if(option == -1) {
				System.out.println("Bye!");
				System.exit(0);
			} else {
				System.out.println("--> Error. <--");
			}
		} while(true);



		System.out.print("\ninput str : ");
		String str = scanner.nextLine();
		str = scanner.nextLine();
		//				String str = "a man a plan a canal panama";
		//				String str = "radar";
		//				String str = "able was i ere i saw elba";

		//去除空白
		str = str.replaceAll(" ", "");
		char[] arrStr = str.toCharArray();

		if(TestPalindrome( arrStr, 0, arrStr.length - 1) == 1) {
			System.out.println(" is a palindrome.");
		} else {
			System.out.println(" is a NOT palindrome.");
		}

		//		System.out.println("is Done.");
	}
	// function
	public static int TestPalindrome (char a[], int leftEnd, int rightEnd) {
		// '是的話傳回1' ， '否則傳回0' 
		if(leftEnd == rightEnd) {
			return 1;
		}
		if(a[leftEnd] == a[rightEnd]) {
			return TestPalindrome( a, leftEnd + 1, rightEnd - 1);
		} else {
			return 0;
		}
	}

}
