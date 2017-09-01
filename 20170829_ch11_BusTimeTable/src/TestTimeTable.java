import java.lang.*;
import java.util.*;
import java.io.*;
public class TestTimeTable {

	// static
	public static Scanner sc = new Scanner(System.in);
	static String readFilePath = "src//";
	//	static String readFileName = "timetable.csv";
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
							if(arrStr[3].equals(arrLoadInStr[3])) {
								lineTable[i].setListLineDetail(arrLoadInStr);
								break;
							} else {
								c++; // 往返 不同
							}
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
		//		System.out.println("#################################");
		//		System.out.println("################lineTable#################");
		//		for(int i = 0; i < linesCount; i++) {
		//			if(lineTable[i] != null) {
		//				//				// line
		//				lineTable[i].output();
		//				System.out.println();
		//				// detail
		//				//				for(int j = 0; j < lineTable[i].getListCount(); j++) {
		//				//					lineTable[i].output();
		//				//					lineTable[i].getList(j).output();;
		//				//					System.out.println();
		//				//				}
		//			}
		//		}
		//		System.out.println("#################################");
	}
	// menu
	public static void menu() throws IOException, FileNotFoundException {
		do {
			System.out.println("1)檢視所有路線資料, 2)新增路線, 3)檢視指定路線資訊, 4)刪除路線, 5)寫入檔案, -1) 結束：");
			try {
				int scanOption = sc.nextInt();
				sc.nextLine();
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
		//		System.out.println("print All Lines.");
		String[] arrS = firstLine.split(",");
		System.out.print( String.format("%5s %5s %2s %2s %20s\n", arrS[0], arrS[1], arrS[2], arrS[3], arrS[4]));
		for(int i = 0; i < linesCount; i++) {
			if(lineTable[i] != null) {
				lineTable[i].output();
				System.out.println();
			}
		}
	}
	public static void newLine() {
		String[] arrScanStr = new String[15];
		System.out.println("-------new Line.-------");
		System.out.println("請輸入 客運業者： ");
		arrScanStr[0] = sc.nextLine();
		System.out.println("請輸入 路線編號： ");
		arrScanStr[1] = sc.nextLine();

		System.out.println("請輸入 支線： ");
		arrScanStr[2] = sc.nextLine();


		do {
			System.out.println("請輸入 往(1 / 返(0： ");
			arrScanStr[3] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[3]) == -1);

		System.out.println("請輸入 路線名稱： ");
		arrScanStr[4] = sc.nextLine();

		System.out.println("請輸入 站名： ");
		arrScanStr[5] = sc.nextLine();
		System.out.println("請輸入 班次序： ");
		arrScanStr[6] = sc.nextLine();
		System.out.println("請輸入 發車時間： ");
		arrScanStr[7] = sc.nextLine();

		do {
			System.out.println("請輸入 是否發車? 星期一： ");
			arrScanStr[8] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[8]) == -1);

		do {
			System.out.println("請輸入 是否發車? 星期二： ");
			arrScanStr[9] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[9]) == -1);

		do {
			System.out.println("請輸入 是否發車? 星期三： ");
			arrScanStr[10] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[10]) == -1);

		do {
			System.out.println("請輸入 是否發車? 星期四： ");
			arrScanStr[11] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[11]) == -1);

		do {
			System.out.println("請輸入 是否發車? 星期五： ");
			arrScanStr[12] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[12]) == -1);

		do {
			System.out.println("請輸入 是否發車? 星期六： ");
			arrScanStr[13] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[13]) == -1);

		do {
			System.out.println("請輸入 是否發車? 星期日： ");
			arrScanStr[14] = sc.nextLine();
		} while(isOneOrZero(arrScanStr[14]) == -1);

		// search path
		int c = 0;
		for(int i = 0; i < linesCount; i++) {
			String[] arrS = lineTable[i].getData();
			if(arrScanStr[1].equals(arrS[1]) && arrScanStr[2].equals(arrS[2])) {
				lineTable[i].setListLineDetail(arrScanStr);
			} else {
				c++;
			}
		}
		if(c == linesCount) {
			lineTable[linesCount].setLineData(arrScanStr);
			lineTable[linesCount].setListLineDetail(arrScanStr);
			linesCount++;
		}
	}
	public static int isInt(String str) {
		try {
			int i = Integer.parseInt(str);
			return i;
		} catch(Exception e) {
			System.out.println("input Error.");
			//			sc.nextLine();
		}
		return -1;

	}
	public static int isOneOrZero(String str) {
		int i = isInt(str);
		if(i == 0 || i == 1)
			return i;

		return -1;
	}
	public static void printThisLine() {
		System.out.println("print This Line.");
	}
	public static void deleteThisLine() {
		System.out.println("delete This Line.");
	}
	public static void export() throws IOException, FileNotFoundException{
		//		System.out.println("export.");
		System.out.println("輸入檔名:");
		String scanStr = sc.nextLine();
		String[] arrCheckStr = scanStr.split("\\.");
		if(arrCheckStr.length > 2) {
			System.out.println("Input Error.");
			return;
		} else {
			if(arrCheckStr.length < 2) 
				writeFileName = scanStr + ".csv";
			else if(!arrCheckStr[1].equals("csv"))
				writeFileName = arrCheckStr[0] + ".csv";
			else 
				writeFileName = scanStr;
			//			System.out.println(writeFileName);
			FileWriter fw = new FileWriter(writeFilePath + writeFileName);
			BufferedWriter bufW = new BufferedWriter(fw);
			bufW.write(firstLine);
			bufW.newLine();
			for(int i = 0; i < linesCount; i++) {	
				for(int j = 0; j < lineTable[i].getListCount(); j++) {
					bufW.write(lineTable[i].getString() + lineTable[i].getList(j).getString());
					bufW.newLine();
				}	
			}
			bufW.flush();
			bufW.close();
			fw.close();
		}
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

		//		System.out.println("#################################");
		//		// output
		//		for(int i = 0; i < timeTable.length; i++) 
		//			if(timeTable[i] != null) 
		//				timeTable[i].output();		

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
