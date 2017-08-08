import java.util.Scanner;

public class prac4dForMaximumCommonFactor {

	public static void main(String[] args) {
		// Declare and Initailize
		Scanner scanner = new Scanner(System.in);
		// for scanner
		int a = 0, b = 0;
		// for process
		int min, max, x, y;

		// Begin
		while (!((a > 0) && (b > 0))) {
			System.out.println("請輸入兩個正整數: ");
			a = scanner.nextInt();
			b = scanner.nextInt();
			// a = ( int ) ( Math.random() * 100 + 1 );
			// b = ( int ) ( Math.random() * 100 + 1 );
			// System.out.println("a = " + a + " b = " + b );

		} // while out - re-enter

		// Suppose store min and max
		min = a;
		if (a > b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		} // end if - store Real min and max

		// initialize x, y = 1
		x = 1;
		y = 1;
		while (x <= min) {
			if (min % x == 0) {
				if (max % x == 0) {
					y = x; // store factor
				}
			}
			x += 1;
		} // while out -

		System.out.println("Maximum Common Factor is " + y);

	}
}
