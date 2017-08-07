import java.util.*;
public class pracOnClass {

	public static void main(String[] args) {
		//declare, initialize
		Scanner scanner = new Scanner(System.in);

		System.out.print("請輸入 範圍: ");
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		printMulSheet(input1, input2);
		
		//recycle
		scanner.close();
	}

	// function
	public static void printMulSheet(int x, int y) {
		for(int i = 1; i <= 9; i++) {
			for(int j = x; j <= y; j++) {
				System.out.printf("%2d x %2d = %3d  ##  ", j, i , i * j);
			}
			System.out.println("");
		}
		return;
	}

}
