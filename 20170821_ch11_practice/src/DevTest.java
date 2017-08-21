import java.lang.*;
import java.io.*;
public class DevTest {

	public static void main(String[] args) throws IOException,FileNotFoundException{

		char cbuf[] = new char[16];
		FileReader fr = new FileReader("src//test1.txt");  
		int num;
		String str1;

		while((num = fr.read(cbuf)) != -1) {
			str1 = new String(cbuf, 0, num);
//			str1 = new String(cbuf);
			System.out.println("總共讀取" + num + "字元數");  
			System.out.println(str1);
			System.out.println("-----------------------");
		}
		// 執行結果
		// 換行算一個字元喔～～
		
		fr.close();	// 關檔

	}

}
