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
	static FileReader fr;
	static FileWriter fw;

	public static void main(String[] args) throws FileNotFoundException, IOException{


		// test
		test();

		//		setLoadingFile();
		// main menu
				menu();

	}
	// function
	public static void setLoadingFile() throws IOException, FileNotFoundException {
		System.out.println("載入資料檔 : ");
		String str = sc.nextLine();
		if(!str.equals("DataBase.txt")) {
			str = "DataBase.txt";
			System.out.println("File Not Found, \nloading default: DataBase.txt");
		}
		fr = new FileReader("src//" + str);
		fw = new FileWriter("src//" + str);
	}
	public static void menu() {
		do {
			System.out.print("選項：1)檢視全部, 2)新增, 3)刪除, 4)修改, 5)篩選編號, -1) 結束? ");
			int option = sc.nextInt();
			switch(option) {
			case -1:
				System.out.println(" Bye~! ");
				return ;
			case 1:
				System.out.println(" 檢視全部 ");
				break;
			case 2:
				System.out.println(" 新增 ");
				break;
			case 3:
				System.out.println(" 刪除 ");
				break;
			case 4:
				System.out.println(" 修改 ");
				break;
			case 5:
				System.out.println(" 篩選編號 ");
				break;

			default:
				System.out.println("Input Error.");
			}
		} while(true);
	}
	public static void test() {

		// IDCode
		System.out.println("J122559887 is " + IDCode.isValid("J122559887") );
		
		// Date
		Date date1 = new Date("1990/7/3");
		date1.output();
//		System.out.println();
		
		// MemberData
		MemberData md1 = new MemberData("10", "陳維漢", "J122559887", "1990/7/3", "0975861709");
		System.out.println("編號 \t姓名 \t身分證 \t\t生日 \t\t電話");
		System.out.println("==============================================================");
		md1.output();
		
	}

}
