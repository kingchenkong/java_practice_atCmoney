import java.util.*;
public class devtest {

	//static
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arrayTest = new int [3];

		for(int i = 0; i < 10; i++) {
			arrayTest[i] = (int) (Math.random() * 100) + 1;
			longLine("###");
			showArray(arrayTest);
			if( i == arrayTest.length - 1 ) {
				arrayTest = appenIntArray(arrayTest);
			}
		}
		longLine("###");
		longLine("$$$");
		longLine(" 難度二 ");
		longLine("$$$");
		longLine("###");

		//		3) Output.
		int[][] score ={
				{ 0, 1, 2, 3, 4, 5, 6, 7},
				{ 50, 100, 70, 50, 61, 33, 10, 70},
				{ 30, 83, 66, 30, 4, 34, 100, 100}
		};
		int[] arrAv = new int[8];
		int[] arrPass = new int[8];
		Arrays.fill(arrAv, -1);
		Arrays.fill(arrPass,	-1);
		// av, pass
		System.out.println("SN\tENG.\tMATH.\tAVG.\tPASSED");
		longLine("---");
		for(int i = 0; i < score[0].length; i++) {
			arrAv[i] = ( score[1][i] + score[2][i] ) / 2;
			if( arrAv[i] >= 60) {
				arrPass[i] = 1;
			} else {
				arrPass[i] = 0;
			}
		}
		//output
		for(int i = 0; i < score[0].length; i++) {
			System.out.printf("%2d\t%3d \t%3d \t%3d \t", score[0][i], score[1][i], score[2][i], arrAv[i]);
			if(arrPass[i] == 1) {
				System.out.println("y");
			} else if (arrPass[i] == 0) {
				System.out.println("n");
			} else {
				System.out.println("-");
			}
		}
		longLine("###");
		longLine("$$$");
		longLine(" 難度三 ");
		longLine("$$$");
		longLine("###");

		///
		///
		

	}
	//##########
	// function
	//##########
	// - 擴增陣列
	public static int[] appenIntArray(int[] array) {
		int[] arrayForCopy = new int [array.length * 2];

		for(int i = 0; i < array.length; i++) {
			arrayForCopy[i] = array[i];
		}
		return arrayForCopy;
	}
	// - show array
	public static void showArray (int[] array) {
		System.out.print("arrray = { ");
		for(int i = 0 ; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.println(array[i] + " }");
			} else {
				System.out.print(array[i] +", ");
			}
		}
		return;
	}
	// - 分隔線
	public static void longLine(String str) {
		for(int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}


}
