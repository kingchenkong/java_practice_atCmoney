import java.util.Arrays;

public class devTest {

	public static void main(String[] args) {
		int[] arrayTest = new int[3];
		Arrays.fill(arrayTest, 1);

		showArray(arrayTest);

		appendArray(arrayTest);
		showArray(arrayTest);

		arrayTest = appendArray2(arrayTest);
		showArray(arrayTest);

		arrayChangeValue(arrayTest);
		showArray(arrayTest);

	}

	public static void showArray(int[] array) {

		System.out.println("---------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println("\n###############");

	}

	public static void appendArray(int[] array) {
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
		return;

	}

	public static int[] appendArray2(int[] array) {
		int[] newArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;

	}

	public static void arrayChangeValue(int[] array) {
		array[0] = 10;
		array[2] = 10;
		array[5] = 10;

	}

}
