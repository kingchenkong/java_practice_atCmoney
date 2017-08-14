import java.lang.*;
import java.util.*;
public class LottoTest {

	// static
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		// test
		
		
		// main code
		
	}
	// function
	
	
	
	
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
