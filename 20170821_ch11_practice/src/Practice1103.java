import java.io.*;
import java.lang.*;
public class Practice1103 {

	public static void main(String[] args) throws IOException{

		String str1 = "費氏數列如下:";
		char endCh[] = {'C','o','n','t','i','n','u','e','.','.','.'};
		int numF;
		FileWriter fw = new FileWriter("src//test2.txt");
		fw.write(str1);
		fw.write('\r');	
		fw.write('\n');
		for(int i = 1; i < 10; i++) {
			numF = Fib(i);  
			fw.write(numF + " ");
		}
		fw.write(endCh);  
		fw.close();	//關檔
	}

	public static int Fib(int n) {
		if((n == 1) || (n == 0))  
			return n;
		else
			return Fib(n - 1) + Fib(n - 2);
	}

}
