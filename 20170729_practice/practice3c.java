package workplace;

import java.util.Scanner;

public class practice3c {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sn[] = new int[5]; 
		int eng[] = new int[5]; 
		int math[] = new int[5]; 
		int avg[] = new int[5];
		int i, a, c, stage; 
		stage = 0;  //stage 
		i = 0;  //i index
		int z;  //z 
		while (true) {
			if (stage == 0) {  
				System.out.print("Insert new data (SN/ENGLISH/MATH)");
				sn[i] = scanner.nextInt();
				eng[i] = scanner.nextInt();
				math[i] = scanner.nextInt();	
				c = sn.length;  
				if (sn[i] >= 0 && sn[i] <= 100 &&  eng[i] >= 0  &&  eng[i] <= 100  &&  math[i] >= 0  &&  math[i] <= 100  ) {
					
					for (int pos = 0; pos<c; pos++) {
						if (sn[pos] == sn[i]) {
							System.out.print("學號重複輸入，請重新輸入");
							System.out.print("\n");
						}
					}
				}
				
				if (sn[i] == -1 && eng[i] == -1 && math[i] == -1) {
					stage = 1;
					System.out.print("Option: 1) Add. 2) Output. -1) Quit");
					z = scanner.nextInt();
					if (z == 1) {
						stage = 0;
						continue;
					}
					else if (z == 2) {
						System.out.print("SN	ENG.	MATH.	AVG.\n");
						System.out.print("--------------------------\n");
						stage = 2;
					}
					else if (z == -1) {
						System.out.print("Bye!");
						break;
					}
					else {
						System.out.print("Error");
						stage = 0;
					}
				}
				
				if (eng[i] > 100 || eng[i] < 0) {
					System.out.print("英文成績輸入錯誤，請重新輸入");
					System.out.print( "\n");
				}
				if ( math[i] > 100 || math[i] < 0 ) {
					System.out.print("數學成績輸入錯誤，請重新輸入");
					System.out.print("\n");
				}
				
				//��J �ŦX�W�h
				stage = 1;
			}
			
			if (stage == 1) {  //�s�J�}�C�B�p��
				avg[i] = ( eng[i] + math[i] ) / 2;
				i++;
				stage = 0;
			}
			
			
			

			if (stage == 2) {  //��ܵ��G
				System.out.print(sn[i]+"\t");
				System.out.print(eng[i]+"\t");
				System.out.print(math[i]+"\t");
				System.out.print(avg[i]+"\t");
				
			}
			




		}
	}
}

