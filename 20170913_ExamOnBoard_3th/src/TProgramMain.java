import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//2017/09/13上機考
//
//假設有一種語言叫做T語言，包含三種語法，範例如下：
//LOAD 3;
//ADD 10;
//PRT;
//
//LOAD指令將其後的數字載入暫存器中，如重複執行，後續的數字會把原本暫存器的內容覆蓋。ADD指令將其後的數字加進暫存器中，
//而PRT指令則是將暫存器內的印到螢幕中；每一行敘述皆必須以分號結尾。請撰寫程式滿足以下需求：
//(10%) 請寫一個方法將傳入字串的頭尾空白去掉，並將英文轉大寫字母。
//(10%) 請寫一個方法判斷一個字串是否為正整數的字串。如果是則回傳true，否則回傳false。
//(10%) 請寫一個方法判斷傳入字串中是否全為T語言所定義的字元，且是否以分號結尾。不符上述條件者請回傳0，否則回傳1。
//(10%) 假設字串s中包含T語言所定義的合法字元同時以分號結尾。請寫一個方法計算s中字組（token）的個數。
//(10%) 請利用 (a)-(d)撰寫一個方法，函式原型如下：
//		int parser(String s, int[] params);
//		請判斷字串s是否滿足T語言的指令格式，如果有錯誤地方請回傳-1。如果指令是LOAD便回傳0，ADD則回傳1，PRT回傳2。如指令後有其他數字，便存到params之中。
//(50%) 請撰寫一個程式用來編譯T語言指令，使用者輸入一行字串如下：
//		Command:
//		T program.t p.out
//		program.t代表指令檔，p.out代表輸出檔則用來儲存輸出結果。如果輸入的字串不符上述格式，一律在螢幕上印出「Command error!」（指令錯誤）。
//		如果判讀T語言的敘述有誤(例如：錯誤的指令)，在螢幕上印出「Syntax error!」（語法錯誤）。請宣告一個變數代表暫存器的內容（初始化為0），
//		根據使用者所輸入的指令變更暫存器的內容。一旦讀到”PRT;”指令，你必須將暫存器的內容寫入輸出檔中。執行完畢，印出「Done.」即可結束程式。以下為指令檔，與對應的輸出檔：
//

public class TProgramMain {
	// Scanner
	public static Scanner sc = new Scanner(System.in);
	// static
	static String filePath = "src//";

	public static void main(String[] args) {
		// main
		mainFunction();
	}
	// function
	// main
	public static void mainFunction() {
		String scan;
		do {
			System.out.println("Conmmands: ");
			 scan = sc.nextLine();
			if(checkCommand(scan)) {
				break;
			} else {
				System.out.println("Command error!");
			}
		} while(true);
		String[] split = scan.split(" ");
		
		TProgram tp = new TProgram(split[1], split[2]);
		
		

	}
	// check command is correct
	public static boolean checkCommand(String scan) {
		String[] scanSplit = scan.split("\\s+");
		if(scanSplit.length == 3) {
			if(scanSplit[0].compareToIgnoreCase("T") == 0) {
				try {
					FileReader fr = new FileReader(filePath + scanSplit[1]);
					return true;

				} catch (FileNotFoundException e) {
					return false;
				}
			}
		} 
		return false;
	}
}
