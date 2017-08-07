//題目
//陣列實作題目：排序與搜尋問題
//
//請利用陣列撰寫一個程式，用來儲存學生的學號以及英數兩科的成績（請檢查成績，範圍必須介於0~100之間），
//最後提供選項可以做額外新增與列印結果。新增成績時，如果輸入的學號重複，請印出錯誤訊息後，再要求使用者重新輸入。
//列印時，請將學生依照平均分數的高低由大到小排列。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//
//請計算出每位學生的名次，名次以平均分數排列。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Insert new data (SN/ENGLISH/MATH): 1 100 83 
//Insert new data (SN/ENGLISH/MATH): 2 100 90 
//Insert new data (SN/ENGLISH/MATH): 6 10 100 
//Insert new data (SN/ENGLISH/MATH): 8 70 100 
//Insert new data (SN/ENGLISH/MATH): -1 -1 -1 
//
//Option: 1) Add. 2) Output. -1) Quit: 1
//Insert new data (SN/ENGLISH/MATH): 7 80 100 
//Insert new data (SN/ENGLISH /MATH): -1 -1 -1
//
//Option: 1) Add. 2) Output. -1) Quit: 2
//
//SN		ENG.		MATH.	AVG.		
//----------------------------------------------------------
//2		100		 90		95		
//1		100		 83		91		
//7		80		 100		90		
//8		70		 100		85		
//6		10		 100		55		
//
//Option: 1) Add. 2) Output. -1) Quit: -1
//Bye!


import java.util.Scanner;
import java.util.Arrays;
public class prac3c {

	public static void main(String[] args) {
		//declare, initial
		Scanner scanner = new Scanner(System.in);
		//array - score
		int[] arrayStuNum = new int [5];
		int[] arrayStuNum_Copy;
		int[] arrayEngScore = new int [5];
		int[] arrayEngScore_Copy;
		int[] arrayMaScore = new int [5];
		int[] arrayMaScore_Copy;
		int[] arraySumScore = new int [5];
		int[] arraySumScore_Copy;

		//var - process control
		int step = 1; //default - input new data
		boolean keepInputNewData = true;
		boolean reInputNewData = false;
		boolean redo = true;



		//begin

		do {

			switch (step) {
			case 1:

				//step 1 - input new data
				int inputStuNum = 0;
				int inputEngScore = 0;
				int inputMaScore = 0;

				System.out.println("  --- student Number / English Score / Math Score: -1 -1 -1 時, 結束 ---  ");
				System.out.println("Score 0 ~ 100.");
				do {
					keepInputNewData = true;

					//StuNum
					do {
						reInputNewData = false;
						System.out.print("Insert new data ( SN / Eng / Math): ");

						inputStuNum = scanner.nextInt();
						System.out.print(" ");
						inputEngScore = scanner.nextInt();
						System.out.print(" ");
						inputMaScore = scanner.nextInt();
						System.out.println("");//換行

						if(inputStuNum > arrayStuNum.length) {
							//StuNum > array index
							//array - copy and append

							// append length
							int x = inputStuNum - arrayStuNum.length;
							arrayStuNum_Copy = Arrays.copyOf(arrayStuNum, arrayStuNum.length + x);
							arrayEngScore_Copy = Arrays.copyOf(arrayEngScore, arrayEngScore.length + x);
							arrayMaScore_Copy = Arrays.copyOf(arrayMaScore, arrayMaScore.length + x);
							arraySumScore_Copy = Arrays.copyOf(arraySumScore, arraySumScore.length + x);
							//copy data
							arrayStuNum = Arrays.copyOf(arrayStuNum_Copy, arrayStuNum_Copy.length);
							arrayEngScore = Arrays.copyOf(arrayEngScore_Copy, arrayEngScore_Copy.length);
							arrayMaScore = Arrays.copyOf(arrayMaScore_Copy, arrayMaScore_Copy.length);
							arraySumScore = Arrays.copyOf(arraySumScore_Copy, arraySumScore_Copy.length);

						}
						if ( (inputStuNum <= arrayStuNum.length) && ( inputStuNum != -1) ) {
							if(arrayStuNum[inputStuNum - 1] != 0) {
								//該項次, 已有值
								System.out.println(" - index is Duplicated -");
								reInputNewData = true;
							}
						}
						//輸入錯誤
						//default - 學號不可超過一百 ###
						if( (inputStuNum == 0) || (inputStuNum < -1) || (inputStuNum > 100) ) {
							System.out.println(" - Error -  Plz re-enter SN");
							reInputNewData = true;
						}
						if( (inputEngScore == 0) || (inputEngScore < -1) || (inputEngScore > 100) ) {
							System.out.println(" - Error - Plz re-enter English score");
							reInputNewData = true;
						}
						if( (inputMaScore == 0) || (inputMaScore < -1) || (inputMaScore > 100) ) {
							System.out.println(" - Error -  Plz re-enter Math score");
							reInputNewData = true;
						}
					} while(reInputNewData);

					System.out.println("");

					if(inputStuNum != -1) {
						//store data in arrays
						arrayStuNum[inputStuNum - 1] = inputStuNum;	// index
						// score
						arrayEngScore[inputStuNum - 1] = inputEngScore;
						arrayMaScore[inputStuNum - 1] = inputMaScore;
						arraySumScore[inputStuNum - 1] = inputEngScore + inputMaScore; // sum

						//###########
						//test OutPut
						//						System.out.println("SN		ENG.		MATH.	AVG.	");	
						//						System.out.println("----------------------------------------------------------");
						//						for(int c = 0; c < arrayStuNum.length; c++) {
						//							System.out.print(arrayStuNum[c]);
						//							System.out.print(" 		");
						//							System.out.print(arrayEngScore[c]);
						//							System.out.print(" 		");
						//							System.out.print(arrayMaScore[c]);
						//							System.out.print(" 		");
						//							System.out.println(arraySumScore[c] / 2); // output is --> average				
						//						}
						//						System.out.println("");
						//###########
					}
					// -1, -1, -1
					if ( (inputStuNum == -1) && (inputEngScore == -1) && (inputMaScore == -1) ) {
						//################################
						//	input End - break to option
						//################################
						break;
					}

					keepInputNewData = true;
				} while(keepInputNewData);
				break;

			case 2:
				//Output
				for(int i = 1; i < arrayStuNum.length; i++) {
					for(int j = 0; j < arrayStuNum.length - i; j++) {
						// bubble sort
						if(arraySumScore[j] < arraySumScore[j+1]) {
							int temp = 0;
							//StuNum
							temp = arrayStuNum[j];
							arrayStuNum[j] = arrayStuNum[j+1];
							arrayStuNum[j+1] = temp;
							//EngScore
							temp = arrayEngScore[j];
							arrayEngScore[j] = arrayEngScore[j+1];
							arrayEngScore[j+1] = temp;
							//MaScore
							temp = arrayMaScore[j];
							arrayMaScore[j] = arrayMaScore[j+1];
							arrayMaScore[j+1] = temp;
							//SumScore
							temp = arraySumScore[j];
							arraySumScore[j] = arraySumScore[j+1];
							arraySumScore[j+1] = temp;

						}
					}
				}


				System.out.println("SN\t\tENG.\t\tMATH.\t\tAVG.	");	
				System.out.println("----------------------------------------------------------");
				for(int c = 0; c < arrayStuNum.length; c++) {
					if(arrayStuNum[c] != 0) {
						System.out.print(arrayStuNum[c]);
						System.out.print("\t\t");
						System.out.print(arrayEngScore[c]);
						System.out.print("\t\t");
						System.out.print(arrayMaScore[c]);
						System.out.print("\t\t");
						System.out.println(arraySumScore[c] / 2); // output is --> average
					}
				}
				System.out.println("");
				break;

			case -1:
				//Quit
				redo = false;
				break;

			default:
				System.out.println("- Error - step");
			}

			//option select
			if(step != -1) {
				System.out.print("Option: 1) Add. 2) Output. -1) Quit: ");
				step = scanner.nextInt();
				System.out.println("");
			}

		} while(redo);

		System.out.println("Bye!");

		//recycle
		scanner.close();

	}

}
