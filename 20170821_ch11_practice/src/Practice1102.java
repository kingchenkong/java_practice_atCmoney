import java.lang.*;  
import java.io.*;
public class Practice1102 {

	public static void main(String[] args) {
		char cbuf[] = new char[256];

		try(FileReader fr = new FileReader("src//test1.txt")) {
			int num = fr.read(cbuf);
			String str1 = new String(cbuf,0,num);
			System.out.println("總共讀取" + num + "個字元數");  
			System.out.println(" 檔 案 內 容 如 下 ");  
			System.out.println(str1);
			fr.close();
		} catch(FileNotFoundException e) {
			System.out.println("例外發生:找不到該檔案");
		} catch(final IOException e) {
			System.out.println("例外發生:檔案存取錯誤");
		}


	}

}
