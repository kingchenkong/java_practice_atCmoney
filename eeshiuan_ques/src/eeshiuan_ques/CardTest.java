package eeshiuan_ques;

import java.util.Scanner;

class CardTest {
	public static ShuffleCards c = new ShuffleCards();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stage = 0;
		int com[] = new int[5];
		int play[] = new int[5];

		while(true) {
//			stage = 0;
			
			if(stage == 0) {
				System.out.print("play game? (y/n)?");
				char opt = sc.next().charAt(0);
				int i = (int)opt;
				if(i == 121) { // y
					stage++;
				}
				else if(i == 110) { // n
					break;
				}
				else
					System.out.println("error.");
			}
			else if(stage == 1) {  // 產生 電腦 玩家 set
				c.newCards();
				for(int i=0; i<5; i++) {
					play[i] = c.getCard();
					com[i] = c.getCard();
				}			
				stage++;
			}
			else if(stage == 2) {  // 調整順序
				
				
				System.out.println("換排順序 (0~4): ");
				int a = sc.nextInt();
				int b = sc.nextInt();
				c.change(a,b);
			}
			else if(stage == 3) {  //計算點數

			}
			else if(stage == 4) {  //判斷輸贏

			}
			else
				System.out.println("error.");
			
		}

	}
}

