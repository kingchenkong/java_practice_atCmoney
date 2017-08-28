import java.util.Scanner;

class CardTest {
	public static ShuffleCards c = new ShuffleCards();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stage = 0;
		int c[] = new int[5];
		int p[] = new int[5];
		
		while(true) {
			if(stage == 0) {
				System.out.print("開始遊戲 (y/n)?");
				char opt = sc.next().charAt(0);
				int i = (int)opt;
				if(i == 121) { //輸入y
					stage++;
				}
				else if(i == 110) { //輸入n
					break;
				}
				else
					System.out.println("輸入錯誤");
			}
			else if(stage == 1) {  //隨機(電腦、玩家)取牌
				c.newCard();
				for(int i=0; i<5; i++) {
					p[i] = c.getCard();
					c[i] = c.getCard();
				}				
			}
			else if(stage == 2) {  //換牌
				System.out.println("輸入你要交換的兩張牌（牌的編號為0到4）: ");
				int a = sc.nextInt();
				int b = sc.nextInt();
				c.change(a,b);
			}
			else if(stage == 3) {  //計算個別得分
				
			}
			else if(stage == 4) {  //判斷結果

			}
			else
				System.out.println("輸入錯誤");
			stage = 0;
		}
		
	}
}