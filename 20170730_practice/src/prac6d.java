import java.util.Scanner;

public class prac6d {
	// scanner
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int needNum;
		do {
			System.out.print("How many Number you need to test: ");
			needNum = scanner.nextInt();
			// needNum = 8;
			if (needNum < 1)
				System.out.println(" --> Error <-- ");
		} while (needNum < 1);
		int[] arrayForGetRandom = new int[needNum];
		getRandomInt100(arrayForGetRandom);
		System.out.println("\nafter Random => ");
		printArray(arrayForGetRandom);
		bubbleSort(arrayForGetRandom, needNum);
		System.out.println("\nafter Sort => ");
		printArray(arrayForGetRandom);

	}

	// function
	public static void bubbleSort(int[] source, int count) {
		for (int j = 0; j < count; j++) {
			for (int i = 0; i < count - 1; i++) {
				if (source[i] < source[i + 1]) {
					int temp = source[i];
					source[i] = source[i + 1];
					source[i + 1] = temp;
				}
			}
		}
	}

	public static void getRandomInt100(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100) + 1;
		}
	}

	public static void printArray(int[] array) {
		System.out.print("\narray = { ");
		for (int i = 0; i < array.length; i++) {
			if (i == (array.length - 1)) {
				System.out.print(array[i] + "}");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("");
	}
}
