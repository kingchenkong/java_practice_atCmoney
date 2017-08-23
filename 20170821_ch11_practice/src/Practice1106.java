import java.lang.*;
import java.io.*;
public class Practice1106 {

	public static void main(String[] args) throws IOException, FileNotFoundException{
		String mes1;
		FileReader fr = new FileReader("src//text1.txt");
		BufferedReader bufferIn = new BufferedReader(fr);
		
		while((mes1 = bufferIn.readLine()) != null) {
			System.out.println(mes1);
			//test
//			System.out.println("換行囉～～～");
		}
		bufferIn.close();
		fr.close();
		
	}

}
