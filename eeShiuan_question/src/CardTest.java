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
				System.out.print("�}�l�C�� (y/n)?");
				char opt = sc.next().charAt(0);
				int i = (int)opt;
				if(i == 121) { //��Jy
					stage++;
				}
				else if(i == 110) { //��Jn
					break;
				}
				else
					System.out.println("��J���~");
			}
			else if(stage == 1) {  //�H��(�q���B���a)���P
				c.newCard();
				for(int i=0; i<5; i++) {
					p[i] = c.getCard();
					c[i] = c.getCard();
				}				
			}
			else if(stage == 2) {  //���P
				System.out.println("��J�A�n�洫����i�P�]�P���s����0��4�^: ");
				int a = sc.nextInt();
				int b = sc.nextInt();
				c.change(a,b);
			}
			else if(stage == 3) {  //�p��ӧO�o��
				
			}
			else if(stage == 4) {  //�P�_���G

			}
			else
				System.out.println("��J���~");
			stage = 0;
		}
		
	}
}