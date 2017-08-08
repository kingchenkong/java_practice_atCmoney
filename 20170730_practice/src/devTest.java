public class devTest {

	public static void main(String[] args) {

		double[] arrayT1 = new double[10];
		int[] arrayT2 = new int[10];
		for (int i = 0; i < 10; i++) {
			arrayT1[i] = (int) ((Math.random() * 20) - 10);
			arrayT2[i] = ((int) (Math.random() * 20)) - 10;
		}
		System.out.print("\nT1 : ");
		for (int i = 0; i < 10; i++) {
			System.out.printf(" %4.1f, ", arrayT1[i]);
		}
		System.out.print("\nT2 : ");
		for (int i = 0; i < 10; i++) {
			System.out.printf(" %3d, ", arrayT2[i]);
		}

		System.out.println("");
		double[] arrayInit = new double[4];
		int feeIncrease = -1;
		int interestIncrease = 9;

		System.out.printf("feeIncrease = %f\n", 0.7 * (1 + ((double) feeIncrease) / 100));
		arrayInit[1] = (0.7 * (1 + (double) feeIncrease / 100)) / 100;

		System.out.print("Loading rate (%");
		System.out.printf("): %.3f ( %1d", (arrayInit[1] * 100), feeIncrease);
		System.out.println("%)");

		// if(feeIncrease >= 0) {
		// System.out.printf("Loading rate (%): %.3f ( %1d ", (arrayInit[1] * 100),
		// feeIncrease);
		// } else {
		// System.out.printf("Loading rate (%): %.3f ( %1d %)", (arrayInit[1] * 100),
		// feeIncrease);
		// }
		// if(interestIncrease >= 0) {
		// System.out.printf("Interest rate (%): %.3f ( %1d %)", (arrayInit[2] * 100),
		// interestIncrease);
		// } else {
		// System.out.printf("Interest rate (%): %.3f ( %1d %)", (arrayInit[2] * 100),
		// interestIncrease);
		// }

	}

}
