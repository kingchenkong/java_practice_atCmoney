import java.util.Scanner;
import java.util.Arrays;
public class prac3d {

	public static void main(String[] args) {
		//declare, initial
		Scanner scanner = new Scanner(System.in);
		int[][] mulSheet = new int[9][9];

		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + " x " + j + " = " + i * j + " ");
				//丟入 乘法資料
				mulSheet[ i - 1 ][ j - 1 ] = i * j;
			}
			System.out.println("");
		}
		System.out.println("\n\n\n#######################################\n\n\n");

		//test mulSheet
//		for(int i = 1; i <= 9; i++) {
//			for(int j = 1; j <= 9; j++) {
//				System.out.print(i + " x " + j + " = " +mulSheet[ i - 1 ][ j - 1 ] + " ");
//			}
//			System.out.println("");
//		}

		//##########
		//user input
		//##########
		int multiplied = 0;
		int multiplier = 0;
		boolean redo = true;
		boolean print = true;

		while (redo){
			multiplied = 0;
			multiplier = 0;
			redo = true;
			print = true;
			while( (multiplied > 9) || (multiplied < 1) || (multiplier < 1) || ( multiplier > 9)) {
				System.out.print("\n\t需要離開請輸入 -1, -1\n\t請輸入\t被乘數: ");
				multiplied = scanner.nextInt();
				System.out.print("\n\t請輸入\t乘數: ");
				multiplier = scanner.nextInt();
				if( (multiplied == -1) && (multiplier == -1) ) {
					redo = false;
					print = false;
					break;
				}
			}
			if(print) {
			System.out.println("\n\t" + multiplied + " x " + multiplier + " = " + mulSheet[multiplied - 1][multiplier - 1]);
			}
		}
		System.out.println("is Over.");

		//recycle
		scanner.close();

	}

}
