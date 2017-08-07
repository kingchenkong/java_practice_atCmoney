//難度二： 
//新增成績時，如果輸入的索引已經存在成績，請印出錯誤訊息後，再要求使用者重新輸入。程式執行範例如下（使用者輸入的部分以粗體字標註）：
//Insert new data (SN/ENGLISH/MATH): 0 50 30 
//Insert new data (SN/ENGLISH/MATH): 1 100 83 
//Insert new data (SN/ENGLISH/MATH): 2 70 66 
//Insert new data (SN/ENGLISH/MATH): 3 50 30
//Insert new data (SN/ENGLISH/MATH): 4 61 4 
//Insert new data (SN/ENGLISH/MATH): 0 33 34 
//Data '0' duplicated!
//Insert new data (SN/ENGLISH/MATH): 5 33 34 
//Insert new data (SN/ENGLISH/MATH): 6 10 100 
//Insert new data (SN/ENGLISH/MATH): -1 -1 -1 
//
//Option: 1) Add. 2) Histogram. 3) Output. -1) Quit: 1
//Insert new data (SN/ENGLISH/MATH): 8 70 100 
//Insert new data (SN/ENGLISH/MATH): -1 -1 -1 
//
//Option: 1) Add. 2) Histogram. 3) Output. -1) Quit: 3
//SN		ENG.		MATH.	AVG.		PASSED
//----------------------------------------------------------------------
//0		 50		  30		40		n
//1		100		  83		91		y
//2		 70		  66		68		y
//3		 50		  30		40		n
//4		 61		   4		32		n
//5		 33		  34		33		n
//6		 10		 100		55		n
//8		 70		 100		85		y
//
//
//Option: 1) Add. 2) Histogram. 3) Output. -1) Quit: 
import java.util.*;
public class prac6j002 {

	//static
	public static Scanner scanner = new Scanner(System.in);

	//##########
	//	main
	//##########
	public static void main(String[] args) {
		//declare, initial
		int[][] arrayStuData = new int[5][3];
		Arrays.fill(arrayStuData[0], -1);
		Arrays.fill(arrayStuData[1], -1);
		Arrays.fill(arrayStuData[2], -1);
		//	[0], Student Number
		//	[1], English Score
		//	[2], Math Score
		//var - process control 
		int option = 0;

		//##########
		//	Begin
		//##########
		insertNewData(arrayStuData);
		//test
		//		showArray(arrayStuData[0]);
		//		showArray(arrayStuData[1]);
		//		showArray(arrayStuData[2]);
		//		longLine("###");
		// option
		do {
			System.out.println("Option: 1) Add. 2) Histogram. 3) Output. -1) Quit: ");
			option = scanner.nextInt();
			switch(option) {
			case 1:
				insertNewData(arrayStuData);
				break;

			case 2:
				histogram(arrayStuData);
				break;
			case 3:
				outputScore(arrayStuData);
				break;

			case -1:
				System.out.println("Bye!!");
				System.exit(0);
				break;

			default:
				System.out.println("--> Error.<--");
			}
		} while(true); // back to select option

	}
	//################
	// function - 流程
	//################
	// - 輸入資料
	public static void insertNewData(int[][] data) {
		int sn = -1, en = -1, ma = -1;
		int insertIndex = 0;
		do {
			System.out.print("\nInsert new data (SN/ENGLISH/MATH): ");
			sn = scanner.nextInt();
			en = scanner.nextInt();
			ma = scanner.nextInt();
			//quit insert
			if((sn == -1) && (en == -1) && (ma == -1)) {
				break;
			}
			//Error process
			if( (sn < 0) || (en < 0) || (ma < 0) || (en > 100) || (ma > 100) ) {		
				sn = -1;
				en = -1;
				ma = -1;
				System.out.println("--> Error.<--");
			} else { 
				//合法輸入時
				//學號不得重複
				boolean dataDuplicated = false;
				for(int i = 0; i < data[0].length; i++) {
					if(data[0][i] == sn) {
						System.out.println("學號" + sn +" 重複輸入 ");
						dataDuplicated = true;
						break;
					}
				}
				if(dataDuplicated) {
					sn = -1;
					en = -1;
					ma = -1;
					System.out.println("--> Error.<--");
				} else {

					// check data index => sn is zero
					for(int i = 0; i < data[0].length; i++) {
						if(data[0][i] == -1) {	//sn = data[0]
							insertIndex = i;
							break;
						}
						if(i == (data[0].length - 1) ) {
							data[0] = appenIntArray(data[0]);
							data[1] = appenIntArray(data[1]);
							data[2] = appenIntArray(data[2]);	

							//test
							//							showArray(data[0]);
							//							showArray(data[1]);
							//							showArray(data[2]);
							//							longLine("###");
						}
					}
					// store in array
					data[0][insertIndex] = sn;
					data[1][insertIndex] = en;
					data[2][insertIndex] = ma;
				}

			}
		} while(true);// repeat to -1, -1, -1
		return;
	}
	// 計數直條圖
	public static void histogram(int[][] array) {
		int option = 0; 
		do {
			System.out.println("1) English. 2) Math. -1) Back: ");
			option = scanner.nextInt();
			if( (option == 1) || (option == 2) || (option == -1) ) {
				break;
			} else {
				System.out.println("--> Error.<--");
			}
		} while(true);

		switch(option) {
		case 1:
			int[] arrayGetStarInEnglish = new int[11];
			for(int i = 0; i < array[1].length; i++) {
				if(array[0][i] != -1) {
					int j =  array[1][i] / 10 ;
					arrayGetStarInEnglish[j] += 1;
				}
			}
			System.out.println("0\t10\t20\t30\t40\t50\t60\t70\t80\t90\t100");
			longLine("------");
			for(int j = 0; j < array[1].length; j++) { //假若全部人100 100分人數也不會超過總人數	
				for(int i = 0; i < arrayGetStarInEnglish.length; i++) {
					if(arrayGetStarInEnglish[i] > 0) {
						System.out.print("*\t");
						arrayGetStarInEnglish[i] -= 1;
					} else {
						System.out.print(" \t");
					}				
				}
				System.out.println("");
			}
			break;

		case 2:
			int[] arrayGetStarInMath = new int[11];
			for(int i = 0; i < array[2].length; i++) {
				if(array[0][i] != -1) {
					int j =  array[2][i] / 10 ;
					arrayGetStarInMath[j] += 1;
				}
			}
			System.out.println("0\t10\t20\t30\t40\t50\t60\t70\t80\t90\t100");
			longLine("------");
			for(int j = 0; j < array[1].length; j++) { //假若全部人100 100分人數也不會超過總人數	
				for(int i = 0; i < arrayGetStarInMath.length; i++) {
					if(arrayGetStarInMath[i] > 0) {
						System.out.print("*\t");
						arrayGetStarInMath[i] -= 1;
					} else {
						System.out.print(" \t");
					}				
				}
				System.out.println("");
			}
			break;

		case -1:

			break;
		default:
			System.out.println("--> Switch Error.<--");
		}

		return;
	}
	// - 輸出成績
	public static void outputScore(int[][] arrScore) {
		int[] arrAv = new int[arrScore[0].length];
		int[] arrPass = new int[arrScore[0].length];
		Arrays.fill(arrAv, -1);
		Arrays.fill(arrPass,	-1);

		// av, pass

		System.out.println("SN\tENG.\tMATH.\tAVG.\tPASSED");
		longLine("----");
		for(int i = 0; i < arrScore[0].length; i++) {
			arrAv[i] = ( arrScore[1][i] + arrScore[2][i] ) / 2;
			if( arrAv[i] >= 60) {
				arrPass[i] = 1;
			} else {
				arrPass[i] = 0;
			}
		}
		// copy to [3] => Av, [4] => Pass
		arrScore[3] = Arrays.copyOf( arrAv, arrScore[0].length) ;
		arrScore[4] = Arrays.copyOf( arrPass, arrScore[0].length) ;
		
		//output
		for(int i = 0; i < arrScore[0].length; i++) {
			if(arrScore[0][i] != -1) {
				System.out.printf("%2d\t%3d \t%3d \t%3d \t", arrScore[0][i], arrScore[1][i], arrScore[2][i], arrAv[i]);
				if(arrPass[i] == 1) {
					System.out.println("y");
				} else if (arrPass[i] == 0) {
					System.out.println("n");
				} else {
					System.out.println("-");
				}
			} else {
				System.out.println("output is done.");
				break;
			}
		}
		
		
		
		
		return;
	}


	//################
	// function - 實用
	//################
	// - 擴增陣列
	public static int[] appenIntArray(int[] array) {
		int[] arrayForCopy = new int [array.length * 2];
		Arrays.fill(arrayForCopy, -1);
		for(int i = 0; i < array.length; i++) {
			arrayForCopy[i] = array[i];
		}
		return arrayForCopy;
	}
	// - show array
	public static void showArray (int[] array) {
		System.out.print("arrray = { ");
		for(int i = 0 ; i < array.length; i++) {
			if(i == array.length - 1) {
				System.out.println(array[i] + " }");
			} else {
				System.out.print(array[i] +", ");
			}
		}
		return;
	}
	// - 分隔線
	public static void longLine(String str) {
		for(int i = 0; i < 20; i++) {
			System.out.printf("%s", str);
		}
		System.out.println("");
	}


}
