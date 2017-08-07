//Ascii Code 與字元互轉
//
//一、程式範例描述：
//輸入一個數值，轉成Ascii Code字元，並輸出；
//輸入一個字元，轉成Ascii Code數值，並輸出。
//
//二、輸入說明：
//輸入一個數值(範圍:30~122)；
//輸入一個字元(範圍:0-9,A-Z,a-z)
//
//三、輸出說明：
//輸出Ascii Code字元；
//輸出Ascii Code數值
//
//四、輸入範例：
//請輸入一個數值: 65
//請輸入一個字元: a
//
//五、輸出範例： 
//AcsiiCode=65 / Asc2Char=A
//Char=a / Char2AsciiCode=97
import java.util.*;
public class prac71 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int scanInt = 0;
		do {
			System.out.print("\n輸入一個數值 : ");
			scanInt = scanner.nextInt();
			if( (scanInt > 29) && (scanInt < 123)) {
				break;
			} else {
				System.out.println("--> Error.<--");
			}
		} while(true);
		System.out.println("AcsiiCode = " + scanInt + " / Asc2Char = " + (char)scanInt);

		char scanChar ;
		do {
			System.out.print("\n輸入一個字元 : ");
			scanChar = scanner.next().charAt(0);
			if( ( ( (int)scanChar >= 48 ) && ( (int)scanChar <= 57 ) ) || ( ( (int)scanChar >= 65 ) && ( (int)scanChar <= 90 ) ) || ( ( (int)scanChar >= 97 ) && ( (int)scanChar <= 122 ) ) ) {
				break;
			} else {
				System.out.println("--> Error.<--");
			}
		} while(true);
		System.out.println("AcsiiCode = " + scanChar + " / Asc2Char = " + (int)scanChar);

	}
	//	function
	// - 分隔線
	public static void longLine(String str) {
		for(int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}


}
