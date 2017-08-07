import java.util.*;
public class practiceOnClass {

	public static void main(String[] args) {
		//declare, initial
		Scanner scanner = new Scanner(System.in);
		
		//可以換行宣告, 長度可以不固定
		int[][] score = { 	{ 88, 81, 83, 84},
				{ 12, 18,},
				{ 33, 38, 39},
		};
		
		//可以先宣告 row, 再宣告 後續 
		int[][] test = new int[3][];	// 0: index, 1: x-coordinate, 2: y-coordinate
		test[0] = new int[] { 3, 6, 27, 3, 19, 23, 17}; //7個
		test[1] = new int[3];
		test[2] = new int[] {333, 444, 555, 666};

		//print
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[i].length; j++) {
				System.out.println("test [" + i + "] [" + j + "] = " + test[i][j]);
				
			}
			System.out.println("##### 第 " + i + " 行 #####");
		}

		// 二維陣列 append
		int[] arrayForCopy = Arrays.copyOf(test[2], test[2].length + 3);
		test[2] = Arrays.copyOf(arrayForCopy, arrayForCopy.length);
		
		//print - after append
		System.out.println("\n------------------------\n");
		for(int i = 0; i < test.length; i++) {
			for(int j = 0; j < test[i].length; j++) {
				System.out.println("test [" + i + "] [" + j + "] = " + test[i][j]);
				
			}
			System.out.println("##### 第 " + i + " 行 #####");
		}


		//recycle
		scanner.close();
	}

}
