
import java.util.Scanner;

public class prac3a2_fromHong1shiun {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int alreadyNewCount = 0;
		int processStep = 0; //流程控制
		int listen[]= new  int[5];
		int read[]= new  int[5]; 
		int sum[] = new int[5];

		//平均值、標準差、最小值、最大值
		double[] average= new double [3];
		double[] sigma= new double [3];
		int max[]= new int [3];
		int min[]= new int [3];
		for(int i = 0; i < min.length; i++) {
			min[i] = 120;
		}
		//輸入選項
		int inputOption;   

		while ( true ) {

			if (processStep== 0) {
				System.out.print("主選項: 1)輸入成績 2)統計資料 3)搜尋成績 4)修改成績 -1)結束:");
				inputOption = scanner.nextInt();
				if (inputOption == 1) {
					processStep = 1;
				}
				else if (inputOption == 2) {
					if(alreadyNewCount > 0) {
						processStep = 4;
					} else {
						System.out.println("-- 無輸入資料 --");
					}
				}
				else if (inputOption == 3) {
					processStep = 5;
				}
				else if (inputOption == 4) {
					processStep = 6;
				}
				else if (inputOption == -1) {
					System.out.println("Bye!");
					break;
				}
				else {
					System.out.print( "輸入錯誤，請重新輸入");	
					System.out.print( "\n");
					processStep = 0;
				}
			}
			if (processStep == 1) {
				System.out.print( "請輸入聽力成績");
				listen[alreadyNewCount] = scanner.nextInt();
				if (listen[alreadyNewCount] < 0 || listen[alreadyNewCount] > 120) {
					System.out.println("分數輸入錯誤!");	
					listen[alreadyNewCount] = 0;      //輸入錯誤的數字，不要記錄到index裡
					processStep = 1;  
				}
				else {
					if(listen[alreadyNewCount] > max[0]) {
						max[0] = listen[alreadyNewCount];
					}
					if(listen[alreadyNewCount] < min[0]) {
						min[0] = listen[alreadyNewCount];
					}
					processStep++;
				}

			}
			if ( processStep == 2 ) {		
				System.out.print("請輸入閱讀成績");
				read[alreadyNewCount] = scanner.nextInt();
				if (read[alreadyNewCount] < 0 || read[alreadyNewCount] > 120) {
					System.out.println("分數輸入錯誤!");
					processStep = 2;
					read[alreadyNewCount] = 0;      //輸入錯誤的數字，不要記錄到index裡
				}
				else {
					if(read[alreadyNewCount] > max[1]) {
						max[1] = read[alreadyNewCount];
						}
						if(read[alreadyNewCount] < min[1]) {
							min[1] = read[alreadyNewCount];
						}
					processStep++;					
				}
			}
			if ( processStep == 3 ) {
				// 總分
				sum[alreadyNewCount] = listen[alreadyNewCount] + read[alreadyNewCount];
				System.out.println("========================="); 
				System.out.println("總分:" + sum[alreadyNewCount]);
				
				if(sum[alreadyNewCount] > max[2]) {
					max[2] = sum[alreadyNewCount];
					}
					if(sum[alreadyNewCount] < min[2]) {
						min[2] = sum[alreadyNewCount];
					}
				processStep = 0;
				alreadyNewCount++;
			}
			if ( processStep == 4 ) {


				//平均值
				for(int s = 0; s < alreadyNewCount; s++) {
					average[0] += (double) listen[s] / alreadyNewCount;   
					average[1] += (double) read[s] / alreadyNewCount;   
					average[2] += (double) sum[s] / alreadyNewCount;   
				}
				//標準差
				// 1 - 平方和
				for (int j = 0; j < alreadyNewCount; j++) {
					sigma[0] += Math.pow( (double)listen[j], 2);
					sigma[1] += Math.pow( (double)read[j], 2);
					sigma[2] += Math.pow( (double)sum[j], 2);
				}
				// 2 - 標準差
				for(int i = 0; i < 3; i++) { 
					// i = 0 - listen
					// i = 1 - read
					// i = 2 - sum
					sigma[i] = Math.sqrt(sigma[i] / alreadyNewCount - Math.pow(average[i], 2));

				}

				//print
				System.out.println("========================="); 
				System.out.println("聽力測驗\t閱讀測驗\t總分"); 
				System.out.println("--------------------");
				for (int i = 0; i < alreadyNewCount; i++) {
					System.out.printf(" %3d\t %3d\t %3d\n", listen[i], read[i], sum[i]);

				}
				System.out.println("#########################"); 
				System.out.println("\t聽力測驗\t\t閱讀測驗\t\t總分"); 
				System.out.println("--------------------------------------------------");
				System.out.print("平均值\t");
				for(int i = 0; i < 3; i++) {
					System.out.printf("%6.2f\t\t", average[i]);	
				}
				System.out.print("\n標準差\t");
				for(int i = 0; i < 3; i++) {
					System.out.printf("%6.2f\t\t", sigma[i]);	
				}
				System.out.print("\n最小值\t");
				for(int i = 0; i < 3; i++) {
					System.out.printf("%5d\t\t", min[i]);	
				}
				System.out.print("\n最大值\t");
				for(int i = 0; i < 3; i++) {
					System.out.printf("%5d\t\t", max[i]);	
				}
				System.out.println("");
				processStep = 0;
			}
			if (processStep == 5) {
				System.out.println("搜尋成績，沒有要做");
				processStep = 0;   
			}
			if (processStep == 6) {
				System.out.println("修改成績，沒有要做");
				processStep = 0;       
			}
		}
		
		//recycle
		scanner.close();
	}
}


