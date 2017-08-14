import java.lang.*;
import java.util.*;
public class AccountingTest {
	//static
	public static Accounting accountingBook = new Accounting();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// test 
		//		testCTime();
		//		testRecord();
		//		testAccount();

		// main code
		mainCode();

	}
	// function
	// main code
	public static void mainCode() {
		int option = -1;
		do {
			System.out.println("選項： 1) 新增, 2) 印出全部, -1) 結束：");
			option = sc.nextInt();
			if (option != -1 && option != 1 && option != 2) {
				System.out.println("Error!");
			}
			else if (option == -1) {
				System.out.println("感謝您的使用!");
				break;
			}
			else if (option == 2) {
				printAc();
			}
			else if (option == 1) {
				String name;
				int price;
				CTime ct1;

				System.out.print("品名：");
				name = sc.next();
				do {
					System.out.print("價格：");
					price = sc.nextInt();
					if(price > -1) {
						break;
					} else {
						printStatusBar(" input Error.");
					}
				} while(true);
				do {
					System.out.print("時間 ( 時 / 分 / 秒 )：");
					int hour = sc.nextInt();
					int min = sc.nextInt();
					int sec = sc.nextInt();

					if(CTime.isValid(hour, min, sec)) {
						ct1 = new CTime(hour, min, sec);
						accountingBook.add(name, price, ct1);
						break;
					} else {
						printStatusBar(" input Error.");
					}
				} while(true);
				System.out.println("新增成功!\n");
			}
		} while (true);
		return;
	}
	public static void printAc() {
		printStatusBar("print  Accounting");
		System.out.printf("%12s \t %5s \t %10s\n", "name", "price", "RecordTime");
		accountingBook.print();
		line("##", 30, true);
		return;
	}

	// - test CTime
	public static void testCTime() {
		CTime ct1 = new CTime( 10, 20, 44);
		CTime ct2 = new CTime( 24, 5, 5);
		CTime ct3 = new CTime( 6, 0, -1);
		CTime ct4 = new CTime( 9, 10, -1);
		CTime ct5 = new CTime(12, 12, 12);
		CTime ct6 = new CTime(23, 23, 32);
		CTime ct7 = new CTime(12, 4, 59);
		CTime ct8 = new CTime(12, 12, 1);
		CTime[] arrCT = { null, ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8};
		// - testCTime
		printStatusBar("testCTime");
		line("--", 20, true);
		for(int i = 0; i < arrCT.length; i++) {
			if(arrCT[i] != null) {
				arrCT[i].print();
				System.out.println("");
			}
		}
		System.out.println("// set & print");
		line("--", 20, true);
		ct2.setData(20, 15, 7);
		ct3.setData(6, 27, 11);
		for(int i = 0; i < arrCT.length; i++) {
			if(arrCT[i] != null) {
				arrCT[i].print();
				System.out.println("");
			}
		}

		for(int i = 0; i < arrCT.length - 1; i++) {
			if(arrCT[i] != null) {
				System.out.print("ct" + i + " ##");
				arrCT[i].print();
				System.out.print("\tcompare, ct" + (i+1) + " ##");
				arrCT[i+1].print();
				System.out.print("\tis " + CTime.compare(arrCT[i], arrCT[i+1]) );
				System.out.println("");
			}
		}
		line("##", 30, true);
		return;
	}
	// - test record
	public static void testRecord() {
		Record re1 = new Record("eclipe", 0, new CTime(11, 45, 33) );
		Record re2 = new Record("Adobe Ps", 389, new CTime(14, 02, 70) );
		Record re3 = new Record("Xcode", 1189, new CTime(23, 4, 7) );

		// - testRecord
		printStatusBar("testRecord");
		System.out.println("Name\tPrice\tRecordTime");
		line("--", 20, true);
		System.out.print(re1.getName() + "\t" + re1.getPrice() + "\t");
		re1.getRecordTime().print();
		System.out.println("");
		System.out.print(re2.getName() + "\t" + re2.getPrice() + "\t");
		re2.getRecordTime().print();
		System.out.println("");
		System.out.print(re3.getName() + "\t" + re3.getPrice() + "\t");
		re3.getRecordTime().print();
		System.out.println("");

		line("##", 30, true);
		return;
	}
	//test
	// - test Accounting
	public static void testAccount() {
		Accounting ac1 = new Accounting();
		ac1.add("Beatslaya", 99, new CTime(11, 45, 33));
		ac1.add("DJ Elmi", 32, new CTime(7, 8, 13));
		ac1.add("Busta Rhyme", 349, new CTime(3, 25, 22));
		ac1.add("DJ Kool", 579, new CTime(9, 1, 53));
		ac1.add("DJ shash'u", 99, new CTime(19, 28, 14));

		printStatusBar("testAccounting");
		System.out.printf("%15s \t %5s \t %10s\n", "name", "price", "RecordTime");
		ac1.print();
		line("##", 30, true);
		return;
	}

	// - 版面
	// 分隔線
	public static void line(String str, int count, boolean br) {
		for(int i = 0; i < count; i++) {
			System.out.printf("%s", str);
		}
		if(br)
			System.out.println("");
		return;
	}
	public static void printStatusBar(String str) {
		// 上面的線
		System.out.print(" ");
		line("--", str.length() + 1, false);
		System.out.println(" ");

		// message
		System.out.print("||");
		line(" ", str.length() / 2, false);
		System.out.print(str);
		line(" ", str.length() / 2, false);
		System.out.println("||");

		// 下面的線
		System.out.print(" ");
		line("--", str.length() + 1, false);
		System.out.println(" ");
		return;
	}
	// - test
	public static void showArrInt(int[] arr) {

		System.out.println("arr => ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");
		return;
	}
	// last {
}
