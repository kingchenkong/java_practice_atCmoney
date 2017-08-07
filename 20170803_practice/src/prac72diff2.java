//字串轉變為 char[] (字串陣列)，再做處理。
//
//一、程式範例描述：
//將字串轉成char[] (字串陣列)，再逐一對字元輸出。
//
//二、輸入說明：
//輸入一個姓名陣列字串。陣列大小:3
//
//三、輸出說明：
//逐一對字元輸出；不同的姓名要換行。
//
//四、輸入範例：
//請輸入第1個姓名: John
//請輸入第2個姓名: Michael
//請輸入第3個姓名: Bowie 
//
//五、輸出範例： 
//John
//Michael
//Bowie
import java.util.*;

public class prac72diff2 {
	//static
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// variable
		String[] arrStringNames = new String[3];
		char[] arrcharCheck;

		// scan
		for(int i = 0; i < arrStringNames.length; i++) {
			System.out.print("\n請輸入第" + (i + 1) + "個姓名: ");
			arrStringNames[i] = scanner.next();
		}
		// print
		for(int i = 0; i < arrStringNames.length; i++) {
			arrcharCheck = arrStringNames[i].toCharArray();
			System.out.print("charArray ["+ (i + 1) +"] => ");
			for(int j = 0; j < arrcharCheck.length; j++ ) {
				System.out.print(arrcharCheck[j]);
			}
			System.out.println("");
		}
		System.out.println("######################################################");
	}
	// last {
}
