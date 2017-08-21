import java.lang.*;
import java.io.*;
public class Practice1104 {

	public static void main(String[] args) throws IOException{
		
		String mes1 = "費氏數列是一個無限數列.";
		FileWriter fw = new FileWriter("src//test2.txt", true);
		fw.write("\r");
		fw.write("\n");
		fw.write(mes1);
		fw.close();
		
	}

}
