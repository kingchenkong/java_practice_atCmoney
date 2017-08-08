
import java.util.Scanner;

public class helptoHong1shiun {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sn[] = new int[10];
		int eng[] = new int[10];
		int math[] = new int[10];
		int avg[] = new int[10];
		int i, a, c, stage;
		stage = 0; // stage
		i = 0; // i index
		int z; // z

		// variable
		// - process control
		boolean redo = true;
		do {
			while (true) {
				if (stage == 0) {
					System.out.print("Insert new data (SN/ENGLISH/MATH)");
					sn[i] = scanner.nextInt();
					eng[i] = scanner.nextInt();
					math[i] = scanner.nextInt();
					c = sn.length;

					if (sn[i] == -1 && eng[i] == -1 && math[i] == -1) {
						stage = 1;
						sn[i] = 0;
						eng[i] = 0;
						math[i] = 0;

						System.out.print("Option: 1) Add. 2) Output. -1) Quit");
						z = scanner.nextInt();
						if (z == 1) {
							stage = 0;
							continue;
						} else if (z == 2) {
							System.out.print("SN	ENG.	MATH.	AVG.\n");
							System.out.print("--------------------------\n");
							stage = 2;
							break;
						} else if (z == -1) {
							System.out.print("Bye!");
							break;
						} else {
							System.out.print("Error");
							stage = 0;
						}
					}

					if (sn[i] >= 0 && sn[i] <= 100) {
						for (int pos = 0; pos < c; pos++) {
							if ((sn[pos] == sn[i]) && (i != pos)) {
								System.out.print("學號重複輸入，請重新輸入");
								System.out.print("\n");
								sn[i] = 0;
								eng[i] = 0;
								math[i] = 0;
								i -= 1;
							}
						}
						if (eng[i] > 100 || eng[i] < 0) {
							System.out.print("英文成績輸入錯誤，請重新輸入");
							System.out.print("\n");
							sn[i] = 0;
							eng[i] = 0;
							math[i] = 0;
							i -= 1;
						}
						if (math[i] > 100 || math[i] < 0) {
							System.out.print("數學成績輸入錯誤，請重新輸入");
							System.out.print("\n");
							sn[i] = 0;
							eng[i] = 0;
							math[i] = 0;
							i -= 1;
						}

					} else {
						sn[i] = 0;
						eng[i] = 0;
						math[i] = 0;
						i -= 1;
					}

					stage = 1;
				}
				if (stage == 1) {
					avg[i] = (eng[i] + math[i]) / 2;
					i++;
					stage = 0;
				}
			}

			// stage - 2

			if (stage == 2) {

				for (int j = 0; j < sn.length; j++) {
					if (avg[j] != 0) {
						if (avg[j] < avg[j + 1]) {
							int temp = 0;
							temp = avg[j];
							avg[j] = avg[j + 1];
							avg[j + 1] = temp;
							// sn
							temp = sn[j];
							sn[j] = sn[j + 1];
							sn[j + 1] = temp;
							// eng
							temp = eng[j];
							eng[j] = eng[j + 1];
							eng[j + 1] = temp;
							// math
							temp = math[j];
							math[j] = math[j + 1];
							math[j + 1] = temp;

						}
					}
				}

				for (int j = 0; j < sn.length; j++) {
					if (sn[j] != 0) {
						System.out.printf("%d \t %3d \t %3d \t %3d\n", sn[j], eng[j], math[j], avg[j]);
					}
				}

				System.out.print("Option: 1) Add. 2) Output. -1) Quit");
				z = scanner.nextInt();
				if (z == 1) {
					stage = 0;
					continue;
				} else if (z == 2) {
					System.out.print("SN	ENG.	MATH.	AVG.\n");
					System.out.print("--------------------------\n");
					stage = 2;
					break;
				} else if (z == -1) {
					System.out.print("Bye!");
					break;
				} else {
					System.out.print("Error");
					stage = 0;
				}
			}

		} while (redo);

	}
}
