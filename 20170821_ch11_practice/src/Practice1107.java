import java.lang.*;
import java.io.*;
public class Practice1107 {

	public static void main(String[] args) throws IOException, FileNotFoundException{
		String str1 = "費氏數列如下:";
		char endCh[] = {'C','o','n','t','i','n','u','e','.','.','.'};
		int numF;  
		FileWriter fw = new FileWriter("src//text4.txt");  
		BufferedWriter bufferOut = new BufferedWriter(fw, 20);
		bufferOut.write(str1);
		bufferOut.newLine();

		for(int i = 0; i < 10; i++) {
			numF = fib(i);
			bufferOut.write(String.format("%d ", numF));
//			bufferOut.write(numF + " ");
		}
		bufferOut.newLine();
		bufferOut.write(endCh);
		bufferOut.flush();
		fw.close();

	}
	// function
	static int fib(int n) {
		if(n == 1 || n == 0) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
