import java.util.Scanner;

public class prac3c {

	public static void main(String[] args) {
		/*
		 * 
		 */

		Scanner scanner = new Scanner(System.in);
		int inputSec = 0;
		int outDay = 0, outHour = 0, outMin = 0, outSec = 0;

		System.out.println("請輸入要轉換的秒數:");
		inputSec = scanner.nextInt();

		// 1 day = 24 hour = 1440 min = 86400 sec
		if (inputSec >= 86400) {
			outDay = inputSec / 86400;
			inputSec = inputSec % 86400;
			// test
			// System.out.println(outDay);
			// System.out.println(inputSec);

		}

		// 1 hour = 60 min = 3600 sec
		if (inputSec >= 3600) {
			outHour = inputSec / 3600;
			inputSec = inputSec % 3600;
			// test
			// System.out.println(outHour);
			// System.out.println(inputSec);
		}

		// 1 min = 60sec
		if (inputSec >= 60) {
			outMin = inputSec / 60;
			outSec = inputSec % 60;
			// test
			// System.out.println(outMin);
		} else {
			outSec = inputSec;
		}

		// 輸出
		System.out.printf("轉換為： %d day %d hour %d min %d sec", outDay, outHour, outMin, outSec);

	}

}