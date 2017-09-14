//矩陣實作練習
//使用文字檔以下列格式儲存矩陣
//2
//6 6
//15 0 0 22 0 -15
//0 11 3 0 0 0
//0 0 0 -6 0 0
//0 0 0 0 0 0
//91 0 0 0 0 0
//0 0 28 0 0 0
//
//2 3
//1 2 3
//4 5 6
//
//如以上格式，第一行代表要檔案中的矩陣個數。多個矩陣間以 「空行」 做為區隔，每一個term之間用「空格」作區隔，
//每個矩陣的一開始會有一行記錄這個矩陣的列高與行寬。請以C#或Java撰寫，實作製作如投影片中所示範的SparseMatrix。
//以下為參考的結構/類別（以下為虛擬碼）定義（註：你必須依照投影片中的方式定義，也就是使用terms存放矩陣中的非零項，且這些項必須以row major的方式排列）：
//Term{
//	int row;
//	int col;
//	int value;
//} 
//SparseMatrix 
//{
//	private Term[] terms;
//	public SparseMatrix(int r, int c) {
//		terms = new Term[2];
//		terms[0].row = r;
//		terms[0].col = c;
//		terms[0].value = 0;
//	}
//	public void Transpose() {}
//	public void FastTranspose() {}
//	public static SparseMatrix Add(SparseMatrix matrix1, SparseMatrix matrix2) {}
//	public static SparseMatrix Mult(SparseMatrix matrix1, SparseMatrix matrix2)
//	//你可以增加其他你認為需要的方法及成員，如resize等
//}
//
//請於主函式類別中實作以下功能以測試你的程式，並請加入適當的錯誤判斷：
//程式開啟後讀取txt檔並存入一個「矩陣的陣列」mArray。
//請實現實現以下功能 
//Clone：使用者輸入上述mArray的index後，再將對應此index的矩陣複製一份並存入mArray的尾端。
//Transpose：使用者輸入mArray的index，再將對應矩陣轉置的結果存入mArray尾端
//Add：使用者輸入兩個索引，index1與index2，請對應的兩個矩陣相加後，結果存入mArray尾端
//Mult：使用者輸入兩個索引，index1與index2，相乘對應的兩個矩陣，並結果存入mArray尾端
//Save：寫入Txt檔案中(若沒有執行此選項則不會自動寫回原檔案)
//Exit：結束程式
//
//若出現例外情形請印出對應之錯誤訊息，不可讓程式意外終止；陣列大小不足時請使用Resize進行調整。
//
//範例：  
//請輸入檔案名稱: matrix.txt
//15 0 0 22 0 -15
//0 11 3 0 0 0
//0 0 0 -6 0 0
//0 0 0 0 0 0
//91 0 0 0 0 0
//0 28 0 0 0
//
//1) Clone, 2) Transpose, 3) Add, 4) Mult, 5) Save, 6) Exit
//2
//
//15	0	0	0	91	0
//0	11	0	0	0	0
//0	3	0	0	0	28
//22	0	-6	0	0	0
//0	0	0	0	0	0
//-15	0	0	0	0	0
//矩陣已存入陣列尾端 位置為 1
//1) Clone, 2) Transpose, 3) Add, 4) Mult, 5) Save, 6) Exit
//1
//
//15	0	0	22	0	-15
//0	11	3	0	0	0
//0	0	0	-6	0	0
//0	0	0	0	0	0
//91	0	0	0	0	0
//0	0	28	0	0	0
//矩陣已存入陣列尾端 位置為 2
//1) Clone, 2) Transpose, 3) Add, 4) Mult, 5) Save, 6) Exit
//4
//
//225	0	-420	330	0	-225
//0	121	33	-18	0	0
//0	0	0	0	0	0
//0	0	0	0	0	0
//1365	0	0	2002	0	-1365
//0	0	0	-168	0	0
//矩陣已存入陣列尾端 位置為 3
//1) Clone, 2) Transpose, 3) Add, 4) Mult, 5) Save, 6) Exit
//5
//請輸入檔名(輸入o寫回原檔案): a.txt
//已將所有矩陣成功寫入 a.txt 中
//
//請確保矩陣運算的時間複雜度與空間複雜度符合投影片中之描述。撰寫時，建議嘗試先將基本的類別方法與基本的檔案輸入輸出完成後，爾後逐步完成詳盡功能。

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	// Scanner
	public static Scanner sc = new Scanner(System.in);
	// static
	public static SparseMatrix[] arrMatrix = new SparseMatrix[10];

	public static void main(String[] args) {
		// test
		test();

		// menu
		//		menu();
	}
	// menu
	public static void menu() {
		// input file name
		inputFileName();
		// main option
		do {
			System.out.print("1) Clone, 2) Transpose, 3) Add, 4) Mult, 5) Save, 6) Exit : ");
			String scanStr = sc.nextLine();
			if(checkOption(scanStr)) {
				int intOption = Integer.parseInt(scanStr);
				switch(intOption) {
				case 6:	// exit
					System.out.println("--Exit prog--");
					System.exit(0);
					break;
				case 1:	// Clone
					optionClone();
					break;
				case 2:	// Transpose
					optionTranspose();
					break;
				case 3:	// Add
					optionAdd();
					break;
				case 4:	// Multiply
					optionMultiply();
					break;
				case 5:	// Save
					optionSave();
					break;
				default:
					System.out.println("Error: 'intOption' issue.");

				}
			} else {
				System.out.println("Error: input error.");
			}
		} while(true);

	}
	// function
	public static String[] resizeArrStr(String[] arr) {
		String[] copy = new String[arr.length * 2];
		for(int i = 0; i < arr.length; i++) 
			copy[i] = arr[i];
		return copy;
	}
	public static void inputFileName() {
		do {
			System.out.print("請輸入檔案名稱: ");
			String fileName = sc.next();
			System.out.println();

			FileReader fr = null;
			try {
				fr = new FileReader("src//" + fileName);
			} catch (FileNotFoundException e) {
				System.out.println("Error: file not found.");
				continue;
			}
			sc.nextLine();
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println("Error: 'fr' close issue.");
			}
			return ;

			//			BufferedReader bufR = new BufferedReader(fr);
			//			String readStr;
			//			try {
			//				String strMatrixCount = bufR.readLine();
			//				String strMatrixRC = bufR.readLine();
			//				
			//
			//			} catch (IOException e) {
			//				System.out.println("Error: bufR loading issue.");				
			//			}

		} while(true);

	}
	// check 1~6
	public static boolean checkOption(String str) {
		String[] arrStr = {"1", "2", "3", "4", "5", "6"};
		for(int i = 0; i < arrStr.length; i++)
			if(str.equals(arrStr[i]))
				return true;
		return false;
	}
	public static boolean isNumber(String str){
		char[] arrCh;
		arrCh = str.toCharArray();
		for(int i = 0; i < arrCh.length; i++)
			if((int)arrCh[i] < 48 || (int)arrCh[i] > 57 )
				return false;
		return true;
	}
	// option
	public static void optionClone() {
		System.out.println("is clone.");
	}
	public static void optionTranspose() {
		System.out.println("is transpose.");
	}
	public static void optionAdd() {
		System.out.println("is add.");
	}
	public static void optionMultiply() {
		System.out.println("is multiply.");
	}
	public static void optionSave() {
		System.out.println("is save.");
	}
	// test
	public static void test() {
		System.out.println(" --Term");	//
		Term t1 = new Term(5, 5, 3);
		Term t2 = new Term();

		System.out.println(" --getter test");
		System.out.printf("get t1 => r:%2d, c:%2d, v:%2d\n", t1.getTerm()[0], t1.getTerm()[1], t1.getTerm()[2]);
		System.out.printf("get t2 => r:%2d, c:%2d, v:%2d\n", t2.getTerm()[0], t2.getTerm()[1], t2.getTerm()[2]);

		System.out.println(" --setter test");	//
		t2.setTerm(1, 2, 3);
		System.out.printf("get t2 => r:%2d, c:%2d, v:%2d\n", t2.getTerm()[0], t2.getTerm()[1], t2.getTerm()[2]);
		t2.setTerm(2, 2, 3);
		System.out.printf("get t2 => r:%2d, c:%2d, v:%2d\n", t2.getTerm()[0], t2.getTerm()[1], t2.getTerm()[2]);

		System.out.println(" --output test");	//
		System.out.println(Term.outputTerms(t1));
		System.out.println(Term.outputTerms(t2));

		System.out.println(" --SparseMatrix");	//
		SparseMatrix sm = new SparseMatrix(0, 0);
		//		if(isNumber("20\n"))
		//			System.out.println("is Num.");

		try {
			String[] arrStrLine = new String[100];
			int lineCount = 0;
			String fileNameRead = "src//Matrix.txt";
			FileReader fr = new FileReader(fileNameRead);
			BufferedReader bufR = new BufferedReader(fr);

			int matrixCount = 0; // count of matrix
			String strRead = ""; 

			// read first line
			String strMatrixCount = bufR.readLine();	
			while((strRead = bufR.readLine()) != null) {
				if(lineCount == arrStrLine.length)
					arrStrLine = resizeArrStr(arrStrLine);
				arrStrLine[lineCount++] = strRead;
			}
			// print Matrix.txt
			System.out.println("--file: Matrix.txt");
			System.out.println("--first line: " + strMatrixCount);
			for(int i = 0; i < lineCount; i++) {
				System.out.printf("%3d  - %s\n", i, arrStrLine[i]);
			}

			try {
				matrixCount = Integer.parseInt(strMatrixCount);
			} catch(NumberFormatException e) {
				System.out.println(e);
			}
			// no line count
			if(lineCount == 0) {
				System.out.println("is Empty.");
				// close
				bufR.close();
				fr.close();
				return;
			}

			// get matrix to int
			int nextLineIndex = 0;
			int r = 0, c = 0;
			int[][][] matrix = new int[matrixCount][][];

			//			// -- new arrTerm
			//			Term[] arrT = new Term[matrixCount];
			// -- new arrSparseMatrix
			SparseMatrix[] arrSM = new SparseMatrix[matrixCount];

			for(int m = 0; m < matrixCount; m++) {
				String[] rc = arrStrLine[nextLineIndex].split(" ");
				// matrix row & column
				try {
					r = Integer.parseInt(rc[0]);
					c = Integer.parseInt(rc[1]);
				} catch(NumberFormatException e) {
					System.out.println(e);
				}
				// next line index to matrix
				nextLineIndex += 1;
				//				System.out.println(" --matrix " + (m + 1));
				matrix[m] = new int[r][c];

				// -- new Term
				arrSM[m] = new SparseMatrix(r, c);

				for(int i = nextLineIndex; i < nextLineIndex + r; i++) {
					String[] split = arrStrLine[i].split("\\s");
					for(int j = 0; j < split.length; j++) {
						//					System.out.println("j = " + j + " - " + split[j]);
						try {
							matrix[m][i - nextLineIndex][j] = Integer.parseInt(split[j]);
						} catch(NumberFormatException e) {
							System.out.println(e);
						}
						// -- 
						try {
							int newParse = Integer.parseInt(split[j]);
							if(newParse != 0) {
								Term[] arrT = arrSM[m].getTerms();
								arrT[0].valueadd1(); // value + 1
								int nowSetTerm = arrT[0].getTerm()[2]; // get Value
								if(nowSetTerm == arrT.length) {
									arrSM[m].resize();
									arrT = arrSM[m].getTerms();
								}
								arrT[nowSetTerm] = new Term(i - nextLineIndex, j, newParse);
							}							
						} catch(NumberFormatException e) {
							System.out.println(e);
						}
						//---------
						//						System.out.println(" - " + matrix[m][i - nextLineIndex][j]);
					}
					//					System.out.print("row:" + (i - nextLineIndex));
					//					System.out.println("-----------");
				}
				// next line index offset
				nextLineIndex += (r + 1);
			}
			// print matrix
			System.out.println(" --print matrix");
			for(int i = 0; i < matrix.length; i++) {
				System.out.println("--matrix " + i);
				System.out.printf(" -- col :%7s", " ");
				for(int j = 0; j < matrix[i].length; j++) {
					System.out.printf("%3d ", j);
				}
				System.out.println();
				for(int j = 0; j < matrix[i].length; j++) {
					System.out.printf(" -- row : %2d => ", j);
					for(int k = 0; k < matrix[i][j].length; k++) {
						System.out.printf("%3d ",matrix[i][j][k]);
					}	
					System.out.println();
				}
			}
			// print arrSM
			System.out.println(" --print arrSM");
			for(int m = 0; m < matrixCount; m++) {
				System.out.println("--matrix " + m);
				SparseMatrix.printTerms(arrSM[m].getTerms());
				//							Term[] arrT = arrSM[m].getTerms();
				//							System.out.println("matrix " + m);
				//							System.out.println("row\t col\t value");
				//							for(int i = 1; i < arrT[0].getTerm()[2]; i++) {
				//								int[] t = arrT[i].getTerm();
				//								System.out.printf("%d\t %d\t %d\n", t[0], t[1], t[2]);
				//							}
			}

			// Note:
			// part -test
			// 1. try to transpose the 'matrix[][][]'.
			// 2. try to add, mul, clone.
			// 3. finish class SparseMatrix.
			// 4. use class SparseMatrix to finish add, mul, clone, save.
			// 5. done.
			// ----------------------------------------

			// close read
			bufR.close();
			fr.close();

			// save
			System.out.println("請輸入檔名(輸入o寫回原檔案): ");
			String scanStr = sc.nextLine();
			String fileNameWriteTo = "src//";
			if(scanStr.equals("o"))
				fileNameWriteTo += "Matrix.txt";
			else if(scanStr.equals("a"))		// <- for test
				fileNameWriteTo += "a.txt";
			else
				fileNameWriteTo += scanStr;
			FileWriter fw = new FileWriter(fileNameWriteTo);
			BufferedWriter bufW = new BufferedWriter(fw);

			// test
			System.out.println(matrixCount);

			bufW.write(String.format("%d", matrixCount));
			bufW.newLine();

			// - matrix[][][]
			//			for(int i = 0; i < matrixCount; i++) {
			//				bufW.write(String.format("%d %d", matrix[i].length, matrix[i][0].length));
			//				bufW.newLine();
			//				for(int j = 0; j < matrix[i].length; j++) {	// 0 ~ row
			//					for(int k = 0; k < matrix[i][0].length; k++) {	// 0 ~ column
			//						bufW.write(matrix[i][j][k] + " ");
			//					}
			//					bufW.newLine();
			//				}
			//				bufW.newLine();
			//			}

			// - arrSM
			System.out.println("-- test save arrSM");
			for(int i = 0; i < matrixCount; i++) {
				Term[] arrT = arrSM[i].getTerms();
				int[] t0 = arrT[0].getTerm();

				//test
				System.out.println(t0[0] + " " + t0[1]);
				bufW.write(String.format("%d %d", t0[0], t0[1]));
				bufW.newLine();

				// next term
				int nextTermIndex = 1;
				int nextTermRow = arrT[nextTermIndex].getTerm()[0];
				int nextTermColumn = arrT[nextTermIndex].getTerm()[1];
				int nextTermValue = arrT[nextTermIndex].getTerm()[2];

				for(int nowRow = 0; nowRow < t0[0]; nowRow++) {
					for(int nowColumn = 0; nowColumn < t0[1]; nowColumn++) {
						if(nowRow == nextTermRow && nowColumn == nextTermColumn) {
							// now position's value != 0
							System.out.print(nextTermValue + " ");
							bufW.write(String.format("%d ", nextTermValue));
							// modify - nextTerm
							if(nextTermIndex < t0[2]) {
								nextTermIndex++;
								nextTermRow = arrT[nextTermIndex].getTerm()[0];
								nextTermColumn = arrT[nextTermIndex].getTerm()[1];
								nextTermValue = arrT[nextTermIndex].getTerm()[2];
							}
						} else {
							// now position's value = 0
							System.out.print("0 ");
							bufW.write("0 ");
						}
					}
					System.out.println();
					bufW.newLine();
				}
				// one matrix already done.
				bufW.newLine();
				System.out.println();
			}
			//close writer
			bufW.flush();
			bufW.close();
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File Not Found.");
		} catch (IOException e) {
			System.out.println("Error: IOException.");
		}
		System.out.println(" --");
		System.out.println(" --");
		System.out.println(" --");
	}
}
