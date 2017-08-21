import java.lang.*;
import java.io.*;
public class Practice1105 {

	public static void main(String[] args) throws IOException, FileNotFoundException{
		char[] cbuf = new char[1];
		
		// MAC, UNIX => /
		// WIN => \
		FileReader fr = new FileReader("src//text1.txt");
		FileWriter fw = new FileWriter("src//text3.txt");
		int num;
		String str1;
		while( (num = fr.read(cbuf)) != -1) {
			fw.write(cbuf);
		}
		fr.close();
		fw.close();
		
	}

}
