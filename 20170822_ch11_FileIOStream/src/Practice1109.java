//(1)第11行，宣告一個大小為54的陣列data，陣列元素資料型態為byte，其元素只佔用一個位元組，元素值介於-128~+127，。
//(2)第14行：使用read函式讀取檔案的前54個位元組資料，並存入data陣列中。
//(3)第19~45行：由前面的介紹可以得知檔案大小之資訊存放在 data[2]~data[5]之中，但我們必須轉換進制才能求得正確之檔案 大小。
//轉換時必須注意，每一個位元組若大於127，也就是十六進 制的3F，會被認為負值，因此計算前要先修正為正值。
import java.io.*;
public class Practice1109 {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		byte[] data = new byte[54];
		int filesize, value1, value2, value3, value4, low, high;
		FileInputStream fi = new FileInputStream("a001.bmp");  
		int fileSize = fi.available();
		int num;
		num = fi.read(data,0,54);	//讀取前54個位元組

		int title[] = new int[6];  
		for(int i=2;i<5;i++) {
			if(data[i]<0)	// 若資料 > 127(3FH) ，則
				title[i] = (int) data[i] + 256;	//會被判定為負值，所以需
			else	  //要修正為正值
				title[i] = (int) data[i];

		}
		low = title[2] % 16;  
		high = (title[2] - low ) / 16;  
		value1 = high * 16 + low;

		low = title[3] % 16;  
		high = (title[3] - low) / 16;  
		value2 = high * 16 * 16 * 16 + low * 16 * 16;

		low = title[4] % 16;
		high = (title[4] - low) / 16;
		value3 = high * 16 * 16 * 16 * 16 * 16 + low * 16 * 16 * 16 * 16;
		
		low = title[5] % 16;
		high = (title[5] - low) / 16;  
		value4 = high * 16 * 16 * 16 * 16 * 16 * 16 * 16 + low * 16 * 16 * 16 * 16 * 16 * 16;

		filesize = value1 + value2 + value3 + value4;

		System.out.println("檔案大小為" + filesize + "個位元組");
		fi.close();	//關檔


	}

}
