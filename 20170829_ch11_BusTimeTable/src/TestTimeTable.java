import java.lang.*;
import java.util.*;
import java.io.*;
public class TestTimeTable {

	// static
	public static Scanner sc = new Scanner(System.in);
	static String readFilePath = "src//";
	static String readFileName = "testtt.csv";
	static String writeFilePath = "src//";
	static String writeFileName = "output.csv";
	static String firstLine = "---";
	// object
	static BusLine[] lineTable = new BusLine[100];
	static RunsData[] timeTable = new RunsData[100];
	static int runsCount = 0;
	static int linesCount = 0;

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// test 
		//		test();
		// init
		init();
		// menu
		menu();
	}
	// init
	public static void init() throws IOException, FileNotFoundException {
		System.out.print("載入資料檔: ");
		//		String scanStr = sc.nextLine();
		String scanStr = "a";

		// test
		// 檔名 更正
		if(scanStr != readFileName)
			scanStr = readFilePath + readFileName;
		else
			scanStr = readFilePath + scanStr;

		// 載入檔案
		FileReader fr = new FileReader(readFilePath + readFileName);
		BufferedReader bufR = new BufferedReader(fr);
		String readStr;
		firstLine = bufR.readLine();

		while((readStr = bufR.readLine()) != null) {
			String[] arrLoadInStr = readStr.split(",");
			// 放入 類別
			// resize lineTable
			if(linesCount == lineTable.length)
				resizeLineTable();
			// 第 0 筆
			if(linesCount == 0) {
				lineTable[linesCount] = new BusLine(arrLoadInStr);
				lineTable[0].setListLineDetail(arrLoadInStr);
				linesCount++;
			} else {
				// is Duplicated
				int c = 0;
				for(int i = 0; i < linesCount; i++) {
					String[] arrStr = lineTable[i].getData();
					if(arrStr[1].equals(arrLoadInStr[1])) {
						if(arrStr[2].equals(arrLoadInStr[2])) {
							lineTable[i].setListLineDetail(arrLoadInStr);
							break;
						} else {
							c++; // 支線 不同
						}
					} else {
						c++; // 主線 不同
					}
				}
				if(c == linesCount) {
					lineTable[linesCount] = new BusLine(arrLoadInStr);
					lineTable[linesCount].setListLineDetail(arrLoadInStr);
					linesCount++;
				}
			}
		}
		bufR.close();
		fr.close();
		System.out.println("#################################");
		// output
		for(int i = 0; i < timeTable.length; i++) 
			if(timeTable[i] != null) 
				timeTable[i].output();
		System.out.println("################lineTable#################");
		for(int i = 0; i < linesCount; i++) {
			if(lineTable[i] != null) {
				//				// line
								lineTable[i].output();
								System.out.println();
				// detail
//				for(int j = 0; j < lineTable[i].getListCount(); j++) {
//					lineTable[i].output();
//					lineTable[i].getList(j).output();;
//					System.out.println();
//				}
			}
		}
		System.out.println("#################################");
	}
	// menu
	public static void menu() throws IOException, FileNotFoundException {
		do {
			System.out.println("1)檢視所有路線資料, 2)新增路線, 3)檢視指定路線資訊, 4)刪除路線, 5)寫入檔案, -1) 結束：");
			try {
				int scanOption = sc.nextInt();
				switch(scanOption) {
				case -1:
					System.out.println("Quit.");
					return;
				case 1:
					printAllLines();
					break;
				case 2:
					newLine();
					break;

				case 3:
					printThisLine();
					break;
				case 4:
					deleteThisLine();
					break;
				case 5:
					export();
					break;
				default:
					System.out.println("Input Error.");			
				}
			} catch(InputMismatchException ex) {
				System.out.println("Input Error.");		
				sc.nextLine();
			} 
		} while(true);
	}
	// function
	public static void printAllLines() {
		System.out.println("print All Lines.");
	}
	public static void newLine() {
		System.out.println("new Line.");
	}
	public static void printThisLine() {
		System.out.println("print This Line.");
	}
	public static void deleteThisLine() {
		System.out.println("delete This Line.");
	}
	public static void export() {
		System.out.println("export.");
	}
	public static void resizeLineTable() {
		lineTable = Arrays.copyOf(lineTable, lineTable.length * 2);
	}
	// test
	public static void test() throws IOException, FileNotFoundException {
		System.out.println("載入: " + readFilePath + readFileName);
		FileReader fr = new FileReader(readFilePath + readFileName);
		BufferedReader bufR = new BufferedReader(fr);
		String readStr;
		//		bufR.skip(62);
		firstLine = bufR.readLine();

		int runsCount = 0;
		while((readStr = bufR.readLine()) != null) {
			String[] arrLoadInStr = readStr.split(",");
			System.out.println("----------'本行資料個數:'" + arrLoadInStr.length + "------------");
			for(int i = 0; i < arrLoadInStr.length; i++) {
				System.out.print("|" + arrLoadInStr[i] + "|");
			}
			System.out.println();

			//放入 類別
			//			timeTable[runsCount++] = new RunsData(arrLoadInStr);
			//			timeTable[runsCount].company = arrLoadInStr[0];
			//			timeTable[runsCount].pathNo = arrLoadInStr[1];
			//			timeTable[runsCount].branchLine = arrLoadInStr[2].charAt(0);
			//			if(arrLoadInStr[3].equals("往"))
			//				timeTable[runsCount].toOrBack = true;
			//			else
			//				timeTable[runsCount].toOrBack = false;
			//			timeTable[runsCount].pathName = arrLoadInStr[4];
			//			timeTable[runsCount].stationName = arrLoadInStr[5];
			//			timeTable[runsCount].rinsOrder = Integer.parseInt(arrLoadInStr[6]);
			//			timeTable[runsCount].departureTime = Integer.parseInt(arrLoadInStr[7]);
			//			boolean[] arrRunsOrNot = new boolean[7];
			//			for(int j = 8; j < 15; j++) 
			//				if(arrLoadInStr[j].equals("1"))
			//					arrRunsOrNot[j-8] = true;
			//				else
			//					arrRunsOrNot[j-8] = false;
			//			timeTable[runsCount].runsOrNot = arrRunsOrNot;
			//			runsCount++;
		}
		bufR.close();
		fr.close();

		System.out.println("#################################");
		// output
		for(int i = 0; i < timeTable.length; i++) 
			if(timeTable[i] != null) 
				timeTable[i].output();		

		// writer
		System.out.println("輸出: " + writeFilePath + writeFileName);
		FileWriter fw = new FileWriter(writeFilePath + writeFileName);
		BufferedWriter bufW = new BufferedWriter(fw);
		bufW.write(firstLine);
		bufW.newLine();
		for(int i = 0; i < runsCount; i++) {
			bufW.write(timeTable[i].getData());
			bufW.newLine();
		}

		bufW.flush();
		bufW.close();
		fw.close();

	}
}
