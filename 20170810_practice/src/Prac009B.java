//路徑
//
//所謂的「路徑」，指的是一串座標點的序列P={v1, v2, …, vk}，其中v1=(x1, y1)；x1與y1代表v1的x座標與y座標。如果P中沒有出現重複的座標點的話，則稱P為simple path；否則不為simple。請設計一個名為Path的類別，用以記錄一條路徑上的座標點；並請實作當中的方法如下：
//
//class Path {
//	//請在此宣告陣列與相關屬性/變數用來記錄路徑點座標
////屬性的封裝層級必須為private。
////注意：一個點包含兩個座標值（x與y）。
//	public Path() {}	//建構子
//	public void append(int x, int y) {}			//將新增的座標點(x, y)加入序列的最後
//	public int[] getPoint(int inx) {}	//取得編號inx的點座標，將結果寫入陣列後回傳
//	public int getEdge(){}			//回傳此路徑的數量
//	//以上為基本分
//
//public bool isSimple(){}	//回傳true代表該路徑為simple path，否則回傳false
//	public double length(){}	//計算路徑所有邊長的歐基里德距離（Euclidean length）
//	//註：(x1, y1)與(x2, y2)兩點之間的歐基里德距離為
//};
//
//請建立一個測試類別名為TestPath，在其中加入main函式，藉此讓使用者可以重複地輸入選項來對該類別的物件進行輸入與列印的動作。在Path類別內禁止使用public的屬性；可依需求自行定義private的成員函式與變數；目前你只需要將類別TestPath與類別Path放在同一個檔案（TestPath.java）即可。執行範例如下： 
//
//Options: 1) Append, 2)Output, -1)Quit: 1
//3 4
//Options: 1) Append, 2)Output, -1)Quit: 1
//-1 2
//Options: 1) Append, 2)Output, -1)Quit: 1
//5 6
//Options: 1) Append, 2)Output, -1)Quit: 2
//(3, 4) (-1, 2) (5, 6)
//Count of edges: 2
//Euclidean length: 11.68
//This is a simple path!
//
//Options: 1) Append, 2)Output, -1)Quit: -1
//Program quits.
import java.lang.*;
import java.util.*;
public class Prac009B {

	// 宣告物件
	public static Path path = new Path();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		// 主選單
		do {
			System.out.print("Options: 1) Append, 2)Output, -1)Quit: ");
			int option = sc.nextInt();
			if(option == -1) {
				// 程式結束
				printStatusBar("Program quits.");
				break;
			} else if(option == 1) {
				// Append
				printStatusBar("Append.");
				int[] arrP = inputPathPoint();
				path.append(arrP[0], arrP[1]);

			} else if(option == 2) {
				// Output
				printStatusBar("Output.");
				// 輸出全部點位
				printPathPoint();
				// 輸出 有 幾段路徑
				int pathCount = path.getEdge();
				if(pathCount >= 0) {
					System.out.println("Count of edges: " + pathCount);
				} else {
					System.out.println("Count of edges: " + 0);
				}
				// 輸出路徑總長
				System.out.println("Euclidean length: " + path.length());
				// 判斷 是否為 Simple Path
				if(pathCount >= 0) {
					if(path.isSimple()) {
						System.out.println("This is a simple path!");
					} else {
						System.out.println("Not a simple path.");
					}
				}
			} else {
				//print error
				printStatusBar("Input Error.");
			}
		} while(true);

	}
	//##########
	// function
	//##########
	// - 流程
	// 輸入路徑點
	public static int[] inputPathPoint() {
		int[] arrP = new int[2];
		arrP[0] = sc.nextInt();
		arrP[1] = sc.nextInt();

		return arrP;
	}
	// 輸出全部點位
	public static void printPathPoint() {
		int c = 0;
		do {
			int[] arr = path.getPoint(c);
			if(arr[2] == 0) {
				break;
			} else {
				System.out.printf("(%2d,%2d) ", arr[0], arr[1]);
			}
			c += 1;
		} while(true);
		System.out.println("");
	}


	// - 版面
	// 分隔線
	public static void line(String str, int count, boolean br) {
		for(int i = 0; i < count; i++) {
			System.out.printf("%s", str);
		}
		if(br)
			System.out.println("");
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
	}

	// - test
	public static void showArrInt(int[] arr) {

		System.out.println("arr => ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("");
	}

}
//#######
// class
//#######


class Path {
	//請在此宣告 陣列與相關屬性/變數 用來記錄路徑點座標
	// '屬性' 的封裝層級必須為 ' private' 
	//注意：一個點包含兩個座標值（x與y）。
	private int[][] arrPoint = new int[10][3];
	private int dataCount = 0;

	//建構子
	public Path() {


	}	
	//將新增的座標點(x, y)加入序列的最後
	public void append(int x, int y) {
		// 擴增陣列
		if(dataCount == arrPoint.length - 1) {
			int[][] arrForCopy = new int[arrPoint.length * 2][3];
			for(int i = 0; i < arrPoint.length; i++) {
				arrForCopy[i] = arrPoint[i];
			}
			arrPoint = arrForCopy;
			//return arrPoint;
		}

		// 輸入新點
		arrPoint[dataCount][0] = x;
		arrPoint[dataCount][1] = y;
		arrPoint[dataCount][2] = 1;
		dataCount += 1;

	}	
	//取得編號index的點座標，將結果寫入陣列後回傳
	public int[] getPoint(int inx) {
		int arr[] = arrPoint[inx];
		return arr;
	}	
	//回傳此路徑的總長
	public int getEdge(){
		return dataCount - 1;
	}
	//計算路徑所有邊長的歐基里德距離（Euclidean length）
	public double length(){
		double sumL = 0;
		for(int i = 0; i < arrPoint.length - 1; i++) {
			if(arrPoint[i+1][2] == 1) {
				sumL += Math.sqrt( Math.pow(arrPoint[i][0] - arrPoint[i+1][0], 2) + Math.pow(arrPoint[i][1] - arrPoint[i+1][1], 2) );
			} else {
				break;
			}
		}
		return sumL;
	}	
	//計算某點到0的距離
	public double lengthToZero(int[] arr){
		double L = Math.sqrt( Math.pow(arr[0], 2) + Math.pow(arr[1], 2) );
		return L;
	}	
	//回傳true代表該路徑為simple path，否則回傳false
	public boolean isSimple(){
		// x, [i][0]
		for(int i = 0; i < arrPoint.length - 1; i++) {
			if(arrPoint[i][2] == 0) {
				break;
			}
			for(int j = i + 1; j < arrPoint.length - 1; j++) {
				if(arrPoint[j][2] == 0) {
					break;
				}
				if(arrPoint[i][0] == arrPoint[j][0]) {
					if(arrPoint[i][1] == arrPoint[j][1]) {
						return false;
					}
				}
			}
		}	
		return true;
	}	
}
