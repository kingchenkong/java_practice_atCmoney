//字串反轉
//
//一、程式範例描述：
//請將輸入的每一行字串，顛倒倒印出來。
//
//二、輸入說明：
//輸入一行字串資料。
//
//三、輸出說明：
//輸出反轉的字串。
//
//四、輸入範例：
//tsetnoC retsaM gnimmagorP SC UCCN
//ecneicS retupmoC UCCN
//
//五、輸出範例： 
//NCCU CS Progamming Master Contest
//NCCU Computer Science
import java.util.*;
public class prac73diff2 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("請輸入字串: ");
		String inputStr = scanner.nextLine();
		System.out.println("----------------------------------------");

		char[] arrCharReverse = new char[inputStr.length()];
		int indexReverse = inputStr.length();
		for(int i = 0; i < inputStr.length() ; i++) {
			arrCharReverse[i] = inputStr.charAt(indexReverse - 1);
			if(indexReverse != 0) {
				indexReverse--;
			}
		}
		System.out.print("\n 反轉字串 ：");
		for(int i = 0; i < arrCharReverse.length; i++) {
			System.out.print(arrCharReverse[i]);
		}
		System.out.println("");
	}

}
