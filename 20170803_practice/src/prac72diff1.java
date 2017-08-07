//判斷字串是否是整數
//
//一、程式範例描述：
//輸入一個字串，並判斷是否為整數。
//
//二、輸入說明：
//輸入一個字串。
//
//三、輸出說明：
//輸出true或false。
//
//四、輸入範例：
//請輸入一個字串: 30
//請輸入一個字串: ab
//
//五、輸出範例： 
//字串:30 是整數
//字串:ab 不是整數
import java.util.*;
public class prac72diff1 {

	//static
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//declare
		String scanStr;
		char[] arrCharScan;
		boolean isNum = true;

		System.out.println(" -- 輸入一個字串，並判斷是否為整數。 --");
		System.out.print("輸入一個字串 : ");
		scanStr = scanner.next();
		System.out.println("");

		// 轉 char array 法
		//		arrCharScan = scanStr.toCharArray();
		//		for(int i = 0; i < arrCharScan.length; i++) {
		//			if ( (( (int)arrCharScan[i] ) < 48)  || ( ((int)arrCharScan[i] ) > 57) ){
		//				System.out.println(scanStr + "不是整數");
		//				isNum = false;
		//				 break;
		//			} 
		//		}
		//		if(isNum)
		//			System.out.println(scanStr + "是整數");
		//		System.out.println(Integer.MAX_VALUE);   
		//			// 2,147,483,647
		//		System.out.println(Integer.MIN_VALUE); 
		//			// -2,147,483,648

		//parInt 法 - try-catch
		try {
			Integer.parseInt(scanStr);
			System.out.println(scanStr + " 是整數");
		} catch (Exception exception) {
			System.out.println(scanStr + " 不是整數");
		}

	}

}
