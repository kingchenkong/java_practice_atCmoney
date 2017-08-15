//請實作一個類別IntegerSet，使每個物件能儲存0~100的整數集合，集合中數字不重複，類別必須以下面方式宣告：
//class IntegerSet {
//private int[] element;	 //儲存數字的陣列；最小長度為10
//private int count;		//目前陣列內的數字個數
//
//public IntegerSet () {}			//建構子
//public IntegerSet (int size) {}		//建構子；引數代表集合可儲存最大容量
//public void Insert(int value) {}	//新增新的元素value（重複的元素不加入）
//public int getElement(int i) {}	//抓取編號為i的整數，如果索引超出範圍，請回傳-1
//public void output() {}			//印出集合中所有元素的內容
//public int seach(int value) {}  //搜尋value是否在集合中。有則回傳其index，否則回傳-1
//public void delete(int value) {}  //移除元素value
//public IntegerSet intersection(IntegerSet A) {}	//求出與A的交集並予以回傳
//public IntegerSet union(IntegerSet A) {}		//求出與A的聯集並予以回傳
//	private void resize(int newSize) {}  //數字數量大於陣列長度時變更陣列大小
//
//};
//
//請建立一個測試類別名為TestIntegerSet，在其中加入main函式，藉此測試IntegerSet是否正確。目前你只需要將類別TestIntegerSet與類別IntegerSet放在同一個檔案（TestIntegerSet.java）即可。執行範例如下：
//
//Initial size for Set A: 10
//Initial size for Set B: 10
//Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit: 1
//Modify A: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 101
//'101' out of range!
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 100
//'100' successfully inserted!
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 100
//'100' duplicated!
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 25
//'25' successfully inserted!
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: b
//100, 25
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: c
//Delete: 43
//'43' not found!
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: c
//Delete: 25
//'25' successfully deleted!
//
//Modify A: a) Insert. b) Output. c) Delete. d) Back: d
//Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit: 2
//Modify B: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 100
//'100' successfully inserted!
//
//Modify B: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 43
//'43' successfully inserted!
//
//Modify B: a) Insert. b) Output. c) Delete. d) Back: a
//Insert: 35
//'35' successfully inserted!
//
//Modify B: a) Insert. b) Output. c) Delete. d) Back: d
//Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit: 3
//Intersection: 100
//
//Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit: 4
//Union: 100, 43, 35
//
//Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit:
//
//難度一：完成選項1-a, 1-b, 2-a, 2-b（建構子、insert、getElement以及output）
//難度二：完成resize（Demo時將給一個很小陣列長度，再輸入超出容量的元素作測試）
//難度三：完成選項1-c, 2-c（search，delete）
//難度四：完成選項3（intersection）
//難度五：完成選項4（union）
//
//請寫註解，並注意程式設計風格與排版。
import java.lang.*;
import java.util.*;
public class PracSetTest {

	// static
	public static Scanner scanner = new Scanner(System.in);
	public static IntegerSet setA, setB;
	public static void main(String[] args) {

		setA = initSet("A");
		setB = initSet("B");
		int option = mainOption();










		//		//test
		//		IntegerSet intSet = new IntegerSet();
		//		//		int input = scanner.nextInt();
		//		int input = 0;
		//		for(int i = 0; i < 10; i++) {
		//			input =  (int) (Math.random()*100) + 1;
		//			if(input < 0 || input > 100) {
		//				System.out.println("'" + input + "' input is out range.");
		//			} else {
		//				intSet.Insert(input);
		//			}
		//		}
		//		intSet.output();
		//		input = scanner.nextInt();
		//		intSet.delete(input);
		//		intSet.output();
		//		//

	}
	// function
	// - process 
	// init int set
	public static IntegerSet initSet(String str){
		IntegerSet set;
		do {
			System.out.print("Initial size for Set " + str + ":");
			int input = scanner.nextInt();
			if(input < 0) {
				System.out.println("input Error.");
			} else {
				set = new IntegerSet(input);
				return set;
			}
		} while(true);
	}
	// main option
	public static int mainOption() {
		do {
			System.out.println("Menu: 1) Modify A. 2) Modify B. 3) Intersection. 4) Union. -1) Quit:");
			int option = scanner.nextInt();
			switch(option) {
			case -1:
				System.out.println("Quit!!");
				//				System.exit(0);
				return 0;
			case 1:
				modifyA();
				break;
			case 2:
				System.out.println("Modify B.");
				modifyB();
				break;
			case 3:
				Intersection();
				break;
			case 4:
				Union();
				break;
			default:
				System.out.println("input Error.");
			}
		} while(true);
	}
	// 1) Modify A. 
	public static void modifyA() {
		do {
			System.out.println("Modify A.: a) Insert. b) Output. c) Delete. d) Back:");
			char option = scanner.next().charAt(0);
			switch(option) {
			case 'a':
				System.out.print("insert : ");
				int value = scanner.nextInt();
				// 0 ~ 100
				if(value < 0 || value > 100) {
					System.out.println("'" + value +"' is out range.");
					break;	
				}
				// 不重複
				if(setA.search(value) == -1) {	
//					this.element[this.count++] = value;
					setA.Insert(value);
					System.out.println("input is sucessfully insert.");
					break;
				} else {
					System.out.println("input is Duplicated.");
					break;
				}
			case 'b':
				setA.output();
				break;
			case 'c':
				System.out.print("delete : ");
				setA.delete(scanner.nextInt());
				break;
			case 'd':
				return;
			default:
				System.out.println("input Error.");
			}
		} while(true);
	}
	// 2) Modify B. 
	public static void modifyB() {
		do {
			System.out.println("Modify A.: a) Insert. b) Output. c) Delete. d) Back:");
			char option = scanner.next().charAt(0);
			switch(option) {
			case 'a':
				System.out.print("insert : ");
				int value = scanner.nextInt();
				// 0 ~ 100
				if(value < 0 || value > 100) {
					System.out.println("'" + value +"' is out range.");
					break;	
				}
				// 不重複
				if(setB.search(value) == -1) {	
//					this.element[this.count++] = value;
					setB.Insert(value);
					System.out.println("input is sucessfully insert.");
					break;
				} else {
					System.out.println("input is Duplicated.");
					break;
				}
			case 'b':
				setB.output();
				break;
			case 'c':
				System.out.print("deleted : ");
				setB.delete(scanner.nextInt());
				break;
			case 'd':
				return;
			default:
				System.out.println("input Error.");
			}
		} while(true);
	}

	// 3) Intersection. 
	public static void Intersection() {
		System.out.print("Intersection : ");
		IntegerSet setC = setA.intersection(setB);
		setC.output();
		System.out.println("");
		return;
	}

	// 4) Union.
	public static void Union() {
		System.out.print("Union : ");
		IntegerSet setC = setA.union(setB);
		setC.output();
		System.out.println("");
		return;
	}

















	// last {
}