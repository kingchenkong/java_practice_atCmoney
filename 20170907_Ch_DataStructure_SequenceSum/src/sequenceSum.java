//序列和
//
//給定一個序列，第n個元素 Tn = n2 - (n-1)2。 
//
//求序列的和 Sn % (109 + 7)的結果。 
//其中  Sn = T1 + T2 + T3 + .... + Tn。  
//
//輸入格式如下：  
//
//第一行包含一個整數「T」，代表測試數據的個數。
//每個測試數據對應一行，包含一個整數「n」。  
//    
//輸出格式： 
//
//對每一個測試數據，用一行輸出Sn % (109 + 7)。
//
//數據範圍：  
//
//1 <= T <= 10  
//1 <= n <= 1016  
//
//範例輸入：  
//2
//2 
//1  
//
//範例輸出：  
//4
//1
//
//題目1：
//請用遞迴的方式撰寫上述題目，並請在檔案開頭用註解的方式分析時間複雜度與空間複雜度。
//題目2：
//請重新撰寫此程式，同時在時間複雜度與空間複雜度必須皆為O(1)。
//
//註1：請注意本題的數字範圍，你有可能需要使用型態long
//註2：請注意本題的數字範圍，你有可能需要應用模數運算的分配律，如下：
//
//假設有一個整數K與n，則
//K2 mod n = [(K mod n) (K mod n)] mod n

// -------------------------------------分析 Problem 1-------------------------------------
// 
//public static long getSnUsingRecursive(long n) {
//		// base case
//		if(n == 1) {
//			return 1;
//		}
//		// another case
//		return getTn(n) + getSnUsingRecursive(n-1);
//	}
//
// --空間複雜度
// 		當進入函數後, 
//		n = 1時, 僅產生一個 函數執行實體,
//		n > 1時, 會產生 隨呼叫次數增加的 n 個實體
//		so, worst case: 時間複雜度 = O(n);
//
// --時間複雜度
//		如同 空間複雜度, 
//		n = 1時, 僅執行一次函數,
//		n > 1時, 會呼叫函數本身 n次,
//		so, worst case: 空間複雜度 = n*O(1) = O(n);
//
// -------------------------------------分析 Problem 2-------------------------------------
// 
//	public static void problem2() {
//		// O(1), O(1)
//		long[] n = new long[10];
//
//		int dataCount = 0;
//
//		System.out.println("-- this is Problem 2 --");
//		do {
//			if(dataCount == 10)
//				break;
//			if((n[dataCount++] = scanN() ) == -1)
//				break;
//		} while(true);
//		// Sn
//		for(int i = 0; i < dataCount; i++) {
//			if(n[i] != -1) {
//				long Sn = getSn(n[i]);
//				if(doModOrNot(n[i])) {
//					System.out.println("n[" + i + "],result = " + getResult(n[i]) );
//				} else {
//					System.out.println("n[" + i + "],result = " + Sn );
//				}
//			}
//		}
//		System.out.println("-----------------------");
//	}
//	public static boolean doModOrNot(long n) {
//		if(n < 31623)	// Math.sqrt(div)
//			return false;
//		else 
//			return true;
//
//	}
//	public static long getResult(long n) {
//		return ((n % div) * (n % div)) % div;
//	}
//
//	public static long getSn(long n) {
//		return n * n;
//	}
//
// --空間複雜度
// 		執行 函式: problem2, 
//		共宣告 long[] n, int dataCount, int i, long Sn, 4個變數;
//		執行 函式: doModOrNot,
//		共宣告 long n, 4個變數;
//		執行 函式: getResult,
//		共宣告 long n, 4個變數;
//		執行 函式: getSn,
//		共宣告 long n, 4個變數;
//		cause, 沒有因為執行次數增加 而增加的變數, 
//		so, worst case: 空間複雜度 = O(1);
//
// --時間複雜度
// 		執行 函式: problem2, 
//		共執行 1次;
//		執行 函式: doModOrNot,
//		共執行 dataCount 次, dataCount最多 10筆: n ;
//		執行 函式: getResult,
//		共執行 dataCount 次, dataCount最多 10筆: n ;
//		執行 函式: getSn,
//		共執行 dataCount 次, dataCount最多 10筆: n ;
//		cause, 執行次數為 n 的筆數次, 與 n之值無關, 
//		so, worst case: 時間複雜度 = O(1);	
//
import java.util.*;

public class sequenceSum {

	// static
	public static Scanner sc = new Scanner(System.in);
	static final long div = (long) (Math.pow(10, 9) + 7);

	public static void main(String[] args) {
		// test
		//		test();

		// problem 1
		//		problem1();

		// problem 2
		problem2();
	}
	public static void test() {
		long Sn = 0;
		long Tn = 0;
		long n = 0;

		// input n
		n = scanN();

		// get Sn
		for(int i = 1; i <= n; i++) {
			Tn = getTn(i);
			//			System.out.println("T"+ i +" = " + Tn);
			Sn += Tn;
		}
		// print Sn
		System.out.println("Sn = " + Sn);
		// test
		System.out.println("----");
		System.out.println("div = " + div);
		Long x = Long.MAX_VALUE;
		System.out.println("result = " + getResult(n));
		System.out.println("=======" + Math.sqrt((double)div));
		System.out.println("-------" + x);
	}
	public static void problem1() {
		// recursive
		long[] n = new long[10];
		int dataCount = 0;
		System.out.println("-- this is Problem 1 --");
		do {
			if(dataCount == 10)
				break;
			if((n[dataCount++] = scanN() ) == -1)
				break;
		} while(true);
		// Sn
		for(int i = 0; i < dataCount; i++) {
			if(n[i] != -1) {
				long Sn = getSnUsingRecursive(n[i]);
				System.out.println("n[" + i + "],result = " + (Sn % div) );
			}
		}
		System.out.println("-----------------------");
	}
	public static void problem2() {
		// O(1), O(1)
		long[] n = new long[10];

		int dataCount = 0;

		System.out.println("-- this is Problem 2 --");
		do {
			if(dataCount == 10)
				break;
			if((n[dataCount++] = scanN() ) == -1)
				break;
		} while(true);
		// Sn
		for(int i = 0; i < dataCount; i++) {
			if(n[i] != -1) {
				long Sn = getSn(n[i]);
				if(doModOrNot(n[i])) {
					System.out.println("n[" + i + "],result = " + getResult(n[i]) );
				} else {
					System.out.println("n[" + i + "],result = " + Sn );
				}
			}
		}
		System.out.println("-----------------------");
	}
	public static boolean doModOrNot(long n) {
		if(n < 31623)	// Math.sqrt(div)
			return false;
		else 
			return true;

	}
	public static long getResult(long n) {
		return ((n % div) * (n % div)) % div;
	}

	public static long getSn(long n) {
		return n * n;
	}

	public static long getSnUsingRecursive(long n) {
		// base case
		if(n == 1) {
			return 1;
		}
		// another case
		return getTn(n) + getSnUsingRecursive(n-1);
	}

	public static long scanN() {
		long n = 0;
		do {
			System.out.println("input n (input -1 to Quit): ");
			n = sc.nextLong();
			System.out.println("n = " + n);
			if(n == -1) {
				System.out.println("Input end.");
				return -1;
			}
			else if(n < 1) {
				System.out.println("Error: n < 1");
			}
			else {
				return n;
			}
		} while(true);
	}

	public static long getTn(long n) {
		return 2 * n - 1;
	}

}
