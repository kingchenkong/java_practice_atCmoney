//迴文
//
//一、程式範例描述：
//迴文(Palindrome)是指一個單字，其正向唸和反向唸都是相同的，例如：refer，反過來還是refer。設計一個程式，判斷輸入的單字是否為palindrome。
//
//二、輸入說明：
//輸入一行字串英文小寫單字，單字長度不會超過20。
//
//三、輸出說明：
//當輸入為迴文(Palindrome)時印出一行Yes，如果不是則印出一行No。
//
//四、輸入範例：
//refer
//madam
//nccu
//
//五、輸出範例： 
//Yes
//Yes
//No
import java.util.*;
public class prac73diff3 {

	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("請輸入字串: ");
		String inputStr = scanner.nextLine();
		System.out.println("----------------------------------------");

		char[] arrChar = new char[inputStr.length()];
		for(int i = 0; i < inputStr.length(); i++ ) {
			arrChar[i] = inputStr.charAt(i);
		}
		int count = 0;
		int indexReverse = inputStr.length() - 1;
		
		for(int i = 0; i < inputStr.length() / 2; i++) {
				if( (int)arrChar[i] != (int)arrChar[indexReverse]) {
					count += 1;
				}
				indexReverse -= 1;
		}
		if(count == 0) {
			System.out.println("Yes!");
		} else {
			System.out.println("No!");
		}

	}

}
