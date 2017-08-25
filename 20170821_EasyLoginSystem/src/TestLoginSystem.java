//會員登錄系統
//
//請撰寫一個會員登錄系統，並設計一個類別用來表示每一位會員的欄位資料，會員的資料在程式開始時必須事先從檔案中讀取，最後也必須存入檔案。如檔案一開始不存在，則必須自動建立。會員編號必須介於0至100之間，列印時必須要印滿三個字元，不足者必須補上0。請驗證身分證是否正確，身分證檢查方法請見以下網站：
//http://returnbool.pixnet.net/blog/post/10268673-%5B知識%5D身分證字號相關概念
//
//請使用函式實作，列印時請用格式化字串進行對齊。
//
//
//載入資料檔：Database.txt
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 1
//編號	姓名	身分證		生日	電話
//============================================
//001	黃獻鋒	A128099248	1988/2/3		0225342312
//002	陳其英	A114557853	1981/2/4		0223523412
//003	林仁政	U155695379	1988/2/5		0512423423
//004	石珮儀	A297077330	1988/2/6		0812323422
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 2
//編號(介於0-100)：101
//錯誤！超出範圍！
//編號(介於0-100)：1
//錯誤！編號重複！
//編號(介於0-100)：77
//姓名：林瑞龍
//身分證：A123456789
//生日（年/月/日）：1980 1 20
//電話：0926232122
//會員新增成功!
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 1
//編號	姓名	身分證		生日	電話
//============================================
//001	黃獻鋒	A128099248	1988/2/3		0225342312
//002	陳其英	A114557853	1981/2/4		0223523412
//003	林仁政	U155695379	1988/2/5		0512423423
//004	石珮儀	A297077330	1988/2/6		0812323422
//077	林瑞龍	A123456789	1980/1/20	0926232122

//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 3
//輸入編號：5
//編號不存在！
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 3
//輸入編號：3
//刪除成功！
//編號	姓名	身分證		生日	電話
//============================================
//001	黃獻鋒	A128099248	1988/2/3		0225342312
//002	陳其英	A114557853	1981/2/4		0223523412
//004	石珮儀	A297077330	1988/2/6		0812323422
//077	林瑞龍	A123456789	1980/1/20	0926232122
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 3
//輸入編號：5
//編號不存在！
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 4
//輸入編號：2
//姓名：林其英
//身分證：A114557853
//生日（年/月/日）：1981 2 4
//電話：0223523412
//會員修改成功!
//
//編號	姓名	身分證		生日	電話
//============================================
//001	黃獻鋒	A128099248	1988/2/3		0225342312
//002	林其英	A114557853	1981/2/4		0223523412
//004	石珮儀	A297077330	1988/2/6		0812323422
//077	林瑞龍	A123456789	1980/1/20	0926232122
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? 5
//輸入起始編號：2
//輸入結束編號：15
//輸出資料檔名：file001.txt
//檔案寫入成功！
//
//選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? -1
//寫入Database.txt成功！
//程式結束。
//
//難度一：完成功能1。
//難度二：完成功能2；資料必須依編號由小到大排列。
//難度三：完成功能3。
//難度四：完成功能4。
//難度五：完成功能5；檔案寫入格式請參考Database.txt。
import java.lang.*;
import java.io.*;
import java.util.*;
public class TestLoginSystem {

	static Scanner sc = new Scanner(System.in);
	static String[] arrFileStr = new String[101];
	static MemberData[] mData = new MemberData[101];
	static final String dbTitle = "編號 \t姓名 \t身分證 \t\t生日 \t\t電話";

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// test
		//		test();

		// main menu
		menu();
	}
	// function
	public static void menu() throws IOException, FileNotFoundException {
		// set loading file
		System.out.println("載入資料檔 : ");
		String scanStr = sc.nextLine();
		if(!scanStr.equals("DataBase.txt")) {
			scanStr = "DataBase.txt";
			System.out.println("File Not Found, \nloading default: DataBase.txt");
		}
		// load in mData
		FileReader fr = new FileReader("src//" + scanStr);
		BufferedReader bufR = new BufferedReader(fr);
		String readStr;
		bufR.skip(17);
		//		String[] arrLoadInStr = null;
		while( (readStr = bufR.readLine()) != null) {
			String[] arrLoadInStr = readStr.split("\t");
			for(int i = 0; i < arrLoadInStr.length; i++) {
				//				System.out.println(arrLoadInStr[i]);
				//				System.out.println("----------");
			}
			int dataNo = Integer.parseInt(arrLoadInStr[0]);
			mData[dataNo] = new MemberData(arrLoadInStr[0], arrLoadInStr[1], arrLoadInStr[2], arrLoadInStr[3], arrLoadInStr[4]);
		}
		bufR.close();
		fr.close();

		do {
			// file stream
			System.out.print("選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? ");
			int optionNum = 0; // 預設為 "Illegal input."
			String option = sc.nextLine();
			if(isInt(option)) {
				optionNum = Integer.parseInt(option);
			}
			switch(optionNum) {
			case -1:
				System.out.println(" Bye~! ");
				fr.close();
				// be sure all close
				FileWriter fw = new FileWriter("src//" + scanStr);
				BufferedWriter bufW = new BufferedWriter(fw);
				for(int i = 0; i < 101; i++) {
					if(mData[i] != null) {
						bufW.write(mData[i].getData());
						bufW.newLine();
					}
				}
				bufW.flush();
				bufW.close();
				fw.close();
				return ;
			case 1:
				System.out.println(dbTitle);
				System.out.println("==============================================================");
				for(int i = 0; i < mData.length; i++) 
					if(mData[i] != null) 
						mData[i].output();
				break;
			case 2:
				newData("");
				break;
			case 3:
				deleteData();
				break;
			case 4:
				modifyData();
				break;
			case 5:
				int sNo = 0;
				System.out.println("輸入起始編號： ");
				String scanStartNo = sc.nextLine();
				if(isInt(scanStartNo)) 
					sNo = Integer.parseInt(scanStartNo);
				int eNo = 0;
				System.out.println("輸入結束編號： ");
				String scanEndNo = sc.nextLine();
				if(isInt(scanEndNo))
					eNo = Integer.parseInt(scanEndNo);
				System.out.println("輸出資料檔名：");
				String scanFileName = sc.nextLine();
				//如果沒有副檔名
				String[] arrSplit = scanFileName.split("\\.");
				if(arrSplit.length < 2) {
					scanFileName += ".txt";
				}
				System.out.println(scanFileName);
				fw = new FileWriter("src//" + scanFileName);
				bufW = new BufferedWriter(fw);
				bufW.write(dbTitle);
				bufW.newLine();
				for(int i = sNo; i <=eNo; i++) {
					if(mData[i] != null) {
						bufW.write(mData[i].getData());
						bufW.newLine();
					}
				}
				bufW.flush();
				System.out.println("檔案寫入成功！");
				bufW.close();
				fw.close();
				break;
			default:
				System.out.println("Illegal input.");
			}

		} while(true);
	}

	public static void modifyData() {
		System.out.print("輸入 欲修改之 編號： ");
		String scanNo = sc.nextLine();
		if(isExistData(scanNo)) {
			int mi = Integer.parseInt(scanNo);
			MemberData tempMD = mData[mi];
			mData[mi] = null;
			if(!newData(scanNo)) {
				// 修改失敗
				System.out.println("修改失敗, 復原 原資料");
				mData[mi] = tempMD;
			}
		}
		return;
	}
	public static boolean isExistData(String strNo) {
		if(isInt(strNo)) {
			int no = Integer.parseInt(strNo);
			if(no >= 0 && no <= 100) {
				if(mData[no] != null) {
					return true;
				} else {
					System.out.println("Illegal input. - 該 編號 尚無資料");
				}
			} else {
				System.out.println("Illegal input. - 編號 超出範圍");
			}
		} else {
			System.out.println("Illegal input. - 格式錯誤");
		}
		return false;
	}
	public static void deleteData() {
		System.out.print("輸入 欲刪除之 編號： ");
		String scanNo = sc.nextLine();
		if(isExistData(scanNo)) {
			mData[Integer.parseInt(scanNo)] = null;
			System.out.println("刪除成功！！");
		}
		return;
	}
	public static boolean newData(String modifyNo) {
		String[] arrNMD = new String[5];
		System.out.println("欲離開 請於任何輸入 輸入 '-1'");
		if(modifyNo.equals("")) {
			do {
				System.out.print("編號 ( 介於 0 - 100 ) ：");
				String scanNo = sc.nextLine();
				if(scanNo.equals("-1")) {
					System.out.println(" 取消輸入 ");
					return false;
				}
				if(isInt(scanNo)) {
					int no = Integer.parseInt(scanNo);
					if(no >= 0 && no <= 100) {
						if(mData[no] == null) {
							arrNMD[0] = String.format("%03d", no);
							System.out.println("");
							break;
						} else {
							System.out.println("Illegal input. - 編號重複");
						}
					} else {
						System.out.println("Illegal input. - 超過編號範圍");
					}
				}
				System.out.println("Illegal input. - 格式錯誤");
			} while(true);
		} else {
			arrNMD[0] = modifyNo;
		}
		// 姓名：林瑞龍
		System.out.print("姓名： ");
		arrNMD[1] = sc.nextLine();
		if(arrNMD[1].equals("-1")) {
			System.out.println(" 取消輸入 ");
			return false;
		}
		// 身分證：A123456789
		do {
			System.out.print("身分證： ");
			String scanID = sc.nextLine();
			if(scanID.equals("-1")) {
				System.out.println(" 取消輸入 ");
				return false;
			}
			if(IDCode.isValid(scanID)) {
				arrNMD[2] = scanID;
				break;
			} else {
				System.out.println("Illegal input. - 格式錯誤");
			}
		} while(true);
		// 生日（年/月/日）：1980 1 20
		do {
			System.out.print("生日（年/月/日： ");
			String scanDate = sc.nextLine();
			if(scanDate.equals("-1")) {
				System.out.println(" 取消輸入 ");
				return false;
			}
			if(Date.isExist(scanDate)) {
				arrNMD[3] = scanDate;
				break;
			} else {
				System.out.println("Illegal input. - 格式錯誤");
			}
		} while(true);
		// 電話：0926232122
		do {
			System.out.print("電話： ");
			String scanPh = sc.nextLine();
			if(scanPh.equals("-1")) {
				System.out.println(" 取消輸入 ");
				return false;
			}
			if(isInt(scanPh)) {
				arrNMD[4] = scanPh;
				break;
			} else {
				System.out.println("Illegal input. - 格式錯誤");
			}
		} while(true);
		// 進入 陣列
		mData[Integer.parseInt(arrNMD[0])] = new MemberData(arrNMD[0], arrNMD[1], arrNMD[2], arrNMD[3], arrNMD[4]);
		// 會員新增成功!
		System.out.println("會員新增成功!");
		return true;
	}
	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	public static void test() {
		// IDCode
		System.out.println("J122559887 is " + IDCode.isValid("J122559887") );
		// Date
		Date date1 = new Date("1990/7/3");
		date1.output();
		// MemberData
		MemberData md1 = new MemberData("10", "陳維漢", "J122559887", "1990/7/3", "0975861709");
		System.out.println("編號 \t姓名 \t身分證 \t\t生日 \t\t電話");
		System.out.println("==============================================================");
		md1.output();

	}

}
