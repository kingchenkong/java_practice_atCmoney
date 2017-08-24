import java.io.*;
public class Practice1108 {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		byte[] byteData = new byte[1];
		FileInputStream fi = new FileInputStream("p1.jpg");
		FileOutputStream fo = new FileOutputStream("p2.jpg");
		int fileSize = fi.available();
		int num;
		while(fi.read(byteData) != -1) {
			fo.write(byteData);
		}
			System.out.println("File size = " + fileSize + " Bytes, copy complete.");
			fi.close();
			fo.close();
		
	}

}
