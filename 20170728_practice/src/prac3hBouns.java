//題目
//請撰寫一個陣列用來表示多項式。以陣列儲存多項式時，請以index代表指數，對應的元素內容代表係數。
//例如，多項式3x4+5.6x2+0.8x+1即可用下列的方式進行儲存：

//請要求使用者輸入多個多項式，請提供選項以進行多項式的運算。
//請特別注意記憶體管理的問題，如果相加後的最高指數超過陣列索引範圍，陣列必須增大，
//但是如果最高指數低於陣列最大索引範圍以下，請縮減陣列的大小以符合最高指數。
//執行範例如下（使用者輸入部分以黑體字標註）：
//Insert a new polynomial (1: yes/2: no)? 1
//Add new term (coefficient exponent): 3 4
//Add new term (coefficient exponent): 5.6 2
//Add new term (coefficient exponent): 5 -2
//Exponent out of range!
//
//Add new term (coefficient exponent): 0.8 1
//Add new term (coefficient exponent): 1 0 
//Add new term (coefficient exponent): 0 0
//P0 is inserted!
//
//Insert a new polynomial (1: yes/2: no)? 1
//Add new term (coefficient exponent): 2 1
//Add new term (coefficient exponent): 1 0
//Add new term (coefficient exponent): 0 0
//P1 is inserted!
//
//Insert a new polynomial (1: yes/2: no)? 1
//Add new term (coefficient exponent): 0 0
//P2 is inserted!
//
//Insert a new polynomial (1: yes/2: no)? 2
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? 1
//Which polynomial: 3
//Polynomial 3 does not exist!
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? 1
//Which polynomial: 0
//P0: 3.00x^4 + 5.60x^2 + 0.80x^1 + 1.00
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? 2
//Summand: 0
//Addend: 1
//P0: 3.00x^4 + 5.60x^2 + 2.80x^1 + 2.00
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? 1
//Which polynomial: 0
//p0: 3.00x^4 + 5.60x^2 + 2.80x^1 + 2.00
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? 3
//Minuend: 0
//Subtrahend: 1
//P0: 3.00x^4 + 5.60x^2 + 0.80x^1 + 1.00
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit? 1
//Which polynomial: 0
//P0: 6.00x^5 + 3.00x^4 + 11.20x^3 + 7.20x^2 + 2.80x^1 + 1.00
//
//Option: 1) Output. 2) Add. 3) Subtract. -1) Quit?
import java.util.Arrays;
import java.util.Scanner;

public class prac3hBouns {

	public static void main(String[] args) {
		// declare, initial
		Scanner scanner = new Scanner(System.in);
		// -- array
		int[] arrayPolynomialIndex = new int[5]; // 顯示 arrayPolynomial的index
		// 第幾個多項式
		double[][] arrayPolynomial = new double[5][1];
		double[][] arrayPolynomial_Copy;

		// -- variable
		// process control
		int insertNew = 0;
		int step = 1; // 1.insert 2.select
		int option = 0; // 1.output 2.add 3.subtract
		boolean addNewTermAgain = true;
		double coe = 0;
		int exp = 0;
		int nowPolyIndex = -1; // 現在指向的陣列位置
		int count = 0; // insert new時, coe & exp 輸入了多少項,

		// #########
		// Begin
		// #########
		// step - 1: insert
		do {
			while (insertNew == 0) {
				System.out.print("Insert a new polynomial (1: Yes/2: No)?");
				insertNew = scanner.nextInt();

				switch (insertNew) {
				case 1:
					step = 1; // insert new Polynomial
					addNewTermAgain = true;
					break;
				case 2:
					step = 2; // select option
					break;
				default:
					System.out.println(" --> Error <--");
					insertNew = 0;
				}
			}

			if (step == 1) {
				// 檢查 可以儲存多項式的陣列
				for (int i = 0; i < arrayPolynomialIndex.length; i++) {
					if (arrayPolynomialIndex[i] == 0) {
						nowPolyIndex = i;
						arrayPolynomial[i] = new double[5];
						break;
					}
					// append poly & index
					if (i == arrayPolynomialIndex.length - 1) {
						arrayPolynomialIndex = Arrays.copyOf(arrayPolynomialIndex, arrayPolynomialIndex.length * 2);
						// arrayPolynomial_Copy = new double[arrayPolynomial.length][];
						// for(int j = 0; j < arrayPolynomial.length; j++) {
						// arrayPolynomial_Copy[j] = new double[arrayPolynomial[j].length];
						// }
						// arrayPolynomial_Copy = Arrays.copyOf(arrayPolynomial,
						// arrayPolynomial.length*2);
						arrayPolynomial = Arrays.copyOf(arrayPolynomial, arrayPolynomial.length * 2);
						// for(int j = 0; j < arrayPolyNomial.length ; j++)
					}
				}

				while (addNewTermAgain) {
					System.out.print("Add new term\n");
					System.out.print("\tcoefficient: ");
					coe = scanner.nextDouble();
					System.out.print("\texponent: ");
					exp = scanner.nextInt();
					if (coe != 0) {
						// coe 合法
						if (exp == 0) {
							// 常數
							arrayPolynomialIndex[nowPolyIndex] = 1;
							arrayPolynomial[nowPolyIndex][0] = coe;

							addNewTermAgain = true;
							count += 1;

						} else if ((exp > 0) && (exp <= 100)) {
							// x 多項
							arrayPolynomialIndex[nowPolyIndex] = 1;

							// append 至 次方項
							if ((arrayPolynomial[nowPolyIndex].length - 1) < exp) {
								arrayPolynomial[nowPolyIndex] = Arrays.copyOf(arrayPolynomial[nowPolyIndex], exp + 1);
							}
							arrayPolynomial[nowPolyIndex][exp] = coe;

							addNewTermAgain = true;
							count += 1;

						} else if (exp > 100) {
							// 被玩的時候
							System.out.println("\t-- 不要玩我 凸 --");
							addNewTermAgain = true;

						} else {
							// x 負次方
							System.out.println("\t-- 負次方 多項式功能未開放 --");
							addNewTermAgain = true;

						}
					} else if (exp == 0) { //

						if (count == 0) {
							System.out.println("Nothing is save.");
						} else {
							System.out.printf("P%d is inserted.\n", nowPolyIndex);
							nowPolyIndex += 1;

						}
						addNewTermAgain = false;
						step = 1;
						insertNew = 0;
					} else {
						System.out.println("\n --> Error <--");
						addNewTermAgain = true;
					}

				} // while - inputAgain
			}
		} while (step == 1);

		// step - 2 : select option
		do {
			System.out.println("Option: 1) Output. 2) Add. 3) Subtract. -1) Quit?");
			option = scanner.nextInt();
			switch (option) {
			// 1.output
			case 1:
				// if no data to output
				if (arrayPolynomialIndex[0] == 0) {
					System.out.println("No data to Output.");
					break;
				}
				System.out.println("output -->");

				for (int i = 0; i < arrayPolynomialIndex.length; i++) {
					if (arrayPolynomialIndex[i] == 1) {
						System.out.printf("\nP%d: ", i);
						for (int j = arrayPolynomial[i].length - 1; j >= 0; j--) {
							if (arrayPolynomial[i][j] != 0) {
								// for(int k = 0; k < arrayPolynomial[i].length; k++)
								if (j == (arrayPolynomial[i].length - 1)) {
									System.out.printf("%.2fX^%d", arrayPolynomial[i][j], j);
								} else if (j == 0) {
									if (arrayPolynomial[i][j] > 0) {
										System.out.printf(" +%.2f", arrayPolynomial[i][j]);
									} else {
										System.out.printf(" %.2f", arrayPolynomial[i][j]);
									}
								} else {
									if (arrayPolynomial[i][j] > 0) {
										System.out.printf(" +%.2fX^%d", arrayPolynomial[i][j], j);
									} else {
										System.out.printf(" %.2fX^%d", arrayPolynomial[i][j], j);
									}
								}

							}
						}
					}
				}
				System.out.println("");

				break;

			// 2.add
			case 2:
				int summand = -1; // 被加數
				int addend = -1; // 加數
				System.out.println("add -->");
				System.out.print("請選擇 被加數 Polynomial Number: ");
				summand = scanner.nextInt();
				// 驗證
				if (summand >= arrayPolynomialIndex.length) {
					System.out.println("Polynomial " + summand + " does not exist!");
					break;
				}
				if (arrayPolynomialIndex[summand] == 0) {
					System.out.println("Polynomial " + summand + " does not exist!");
					break;
				}
				System.out.println("請選擇 加數 Polynomial Number: ");
				addend = scanner.nextInt();
				// 驗證
				if (addend >= arrayPolynomialIndex.length) {
					System.out.println("Polynomial " + addend + " does not exist!");
					break;
				}
				if (arrayPolynomialIndex[summand] == 0) {
					System.out.println("Polynomial " + addend + " does not exist!");
					break;
				}
				// 相加
				int mostLongPolyLength = 0;
				if (arrayPolynomial[summand].length >= arrayPolynomial[addend].length) {
					mostLongPolyLength = arrayPolynomial[summand].length;
				} else {
					mostLongPolyLength = arrayPolynomial[addend].length;
				}
				double[] arrayForSummand = new double[mostLongPolyLength]; // 暫存結果
				for (int i = 0; i < arrayPolynomial[summand].length; i++) {
					arrayForSummand[i] += arrayPolynomial[summand][i];
				}
				for (int i = 0; i < arrayPolynomial[addend].length; i++) {
					arrayForSummand[i] += arrayPolynomial[addend][i];
				}
				arrayPolynomial[summand] = Arrays.copyOf(arrayForSummand, arrayForSummand.length);

				// show

				System.out.printf("\nP%d: ", summand);
				for (int j = arrayPolynomial[summand].length - 1; j >= 0; j--) {
					if (arrayPolynomial[summand][j] != 0) {
						// for(int k = 0; k < arrayPolynomial[i].length; k++)
						if (j == (arrayPolynomial[summand].length - 1)) {
							System.out.printf("%.2fX^%d", arrayPolynomial[summand][j], j);
						} else if (j == 0) {
							if (arrayPolynomial[summand][j] > 0) {
								System.out.printf(" +%.2f", arrayPolynomial[summand][j]);
							} else {
								System.out.printf(" %.2f", arrayPolynomial[summand][j]);
							}
						} else {
							if (arrayPolynomial[summand][j] > 0) {
								System.out.printf(" +%.2fX^%d", arrayPolynomial[summand][j], j);
							} else {
								System.out.printf(" %.2fX^%d", arrayPolynomial[summand][j], j);
							}
						}

					}
				}

				System.out.println("");

				break;

			// 3.subtract
			case 3:
				int minuend = 0; // 被減數
				int subtrahend = 0; // 減數

				System.out.println("substract -->");
				System.out.print("請選擇 被減數 Polynomial Number: ");
				minuend = scanner.nextInt();
				// 驗證
				if (minuend >= arrayPolynomialIndex.length) {
					System.out.println("Polynomial " + minuend + " does not exist!");
					break;
				}
				if (arrayPolynomialIndex[minuend] == 0) {
					System.out.println("Polynomial " + minuend + " does not exist!");
					break;
				}
				System.out.println("請選擇 減數 Polynomial Number: ");
				subtrahend = scanner.nextInt();
				// 驗證
				if (subtrahend >= arrayPolynomialIndex.length) {
					System.out.println("Polynomial " + subtrahend + " does not exist!");
					break;
				}
				if (arrayPolynomialIndex[subtrahend] == 0) {
					System.out.println("Polynomial " + subtrahend + " does not exist!");
					break;
				}
				// 相減
				int mostLongPolyLengthForMinued = 0;
				if (arrayPolynomial[minuend].length >= arrayPolynomial[subtrahend].length) {
					mostLongPolyLengthForMinued = arrayPolynomial[minuend].length;
				} else {
					mostLongPolyLengthForMinued = arrayPolynomial[subtrahend].length;
				}
				double[] arrayForMinuend = new double[mostLongPolyLengthForMinued]; // 暫存結果
				for (int i = 0; i < arrayPolynomial[minuend].length; i++) {
					arrayForMinuend[i] += arrayPolynomial[minuend][i];
				}
				for (int i = 0; i < arrayPolynomial[subtrahend].length; i++) {
					arrayForMinuend[i] -= arrayPolynomial[subtrahend][i];
				}
				arrayPolynomial[minuend] = Arrays.copyOf(arrayForMinuend, arrayForMinuend.length);

				// show

				System.out.printf("\nP%d: ", minuend);
				for (int j = arrayPolynomial[minuend].length - 1; j >= 0; j--) {
					if (arrayPolynomial[minuend][j] != 0) {
						// for(int k = 0; k < arrayPolynomial[i].length; k++)
						if (j == (arrayPolynomial[minuend].length - 1)) {
							System.out.printf("%.2fX^%d", arrayPolynomial[minuend][j], j);
						} else if (j == 0) {
							if (arrayPolynomial[minuend][j] > 0) {
								System.out.printf(" +%.2f", arrayPolynomial[minuend][j]);
							} else {
								System.out.printf(" %.2f", arrayPolynomial[minuend][j]);
							}
						} else {
							if (arrayPolynomial[minuend][j] > 0) {
								System.out.printf(" +%.2fX^%d", arrayPolynomial[minuend][j], j);
							} else {
								System.out.printf(" %.2fX^%d", arrayPolynomial[minuend][j], j);
							}
						}
					}
				}

				System.out.println("");
				break;

			// Quit!!
			case -1:
				System.out.println(" Bye !!");
				step = 0;
				break;
			// error
			default:
				System.out.println(" --> Error <--");
			}
		} while (step == 2);

		// recycle
		scanner.close();

	}

}
