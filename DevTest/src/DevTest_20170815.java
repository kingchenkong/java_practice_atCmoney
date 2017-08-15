import java.util.Scanner;
import java.util.Arrays;
public class DevTest_20170815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrA = new int[2];
		Arrays.fill(arrA, 2);
		resize(arrA);
		
		System.out.println("is Over.");

	}
	public static void resize(int[] arr) {
		int[] arrCopy = new int[5];
		Arrays.fill(arrCopy, -1);
		
		arr = null;
		arr = arrCopy;
		System.out.println("is end.");
	}

}
