import java.util.Scanner;
public class practiceOnClass {

	public static void main(String[] args) {

		//	Declare, Initial
		Scanner scanner = new Scanner(System.in);
		
		
		//
		//Math.random() 0 ~ 0.999...
		//隨機產生
		int punchNum = 0;

		for(int i = 0; i < 20; i++) {
			punchNum = ( (int) (Math.random() * 3) + 2 ) * 5;
			//punchNum = ( (int) (Math.random() * randomMul) + randomAdj) * 5;

			System.out.println("    電腦猜 : " + punchNum );
		}
		
		
		//
		//	from 庭瑋
		//	DrawStar-1
		int drawStar1Num;
		System.out.print("請輸入層數: ");
		drawStar1Num = scanner.nextInt();                   //���J�ϧ�size
		for(int i = 0 ;i < drawStar1Num ; i++) {            //�W�b��for�j��
			for(int q = 0 ;q < drawStar1Num - i - 1; q++) { //���L�����ť�
				System.out.print(" ");
			}
			for(int k = 0; k < 2*i + 1; k++) {     //�A�L�k���P�P
				System.out.print("*");
			}
			System.out.print("\n");                //�C�h��������
		}
		for(int j = drawStar1Num-1 ;j > 0; j--) {           //���b��for�j��
			for(int e = 0;e <drawStar1Num - j ;e++) {       //���L�����ť�
				System.out.print(" ");
			}
			for(int w = 0;w < 2*j - 1;w++) {       //�A�L�k���P�P
				System.out.print("*");
			}
			System.out.print("\n");                //�C�h��������
		}

		//
		//	from 庭瑋
		//	DrawStar-2
		int drawStar2Num;
		System.out.print("請輸入層數: ");
		drawStar2Num = scanner.nextInt();                    //���J�ϧ�size
		for(int i = 0 ;i < drawStar2Num ; i++) {             //�W�b�hfor�j��
			for(int q = 0 ;q < drawStar2Num - i - 1; q++) {  //���L�����ť�
				System.out.print(" ");
			}
			if(i == 0) {                            //�Ĥ@�h�u���@���P�P
				System.out.print("*");
			}
			else {                                  //�W�b���ѤU���h��
				System.out.print("*");              //���L���P�P
				for(int r = 0;r < 2*i-1;r++ ) {     //�A�L�����ť�
					System.out.print(" ");
				}
				System.out.print("*");              //�A�L�k�P�P
			}
			System.out.print("\n");                 //�C�h����������
		}
		for(int j = drawStar2Num-1 ;j > 0; j--) {            //�U�b����for�j��
			for(int e = 0;e < drawStar2Num - j ;e++) {        //�C�h���L�����ť�
				System.out.print(" ");
			}
			if(j == 1) {                            //�̫��@�h�u���@���P�P
				System.out.print("*");
			}
			else {                                  //�U�b���ѤU���h��
				System.out.print("*");              //���L�@�������P�P
				for(int t = 0; t < 2*j-3; t++) {    //�A�L�����ť�
					System.out.print(" ");
				}
				System.out.print("*");              //�A�L�k���@���P�P
			}
			System.out.print("\n");                 //�C�h����������
		}
		
		//
		//	from 庭瑋
		//	DrawStar-3
		int drawStar3Num;
		System.out.print("請輸入層數: ");
		drawStar3Num = scanner.nextInt();//���J�ϧΪ�size
		for(int i = 0 ;i < drawStar3Num ; i++) {               //�W�b����for�j��
			if(i == 0) {                              //�Ĥ@�h�P�P
				for(int q = 0;q < 2*drawStar3Num -1;q++) {
					System.out.print("*");
				}
			}
			else {                                    //�ѤU���W�b��
				for(int w = 0;w < drawStar3Num -i;w++) {       //���b�䪺�P�P
					System.out.print("*");
				}
				for(int r = 0;r < 2*i - 1;r++) {      //�������ť�
					System.out.print(" ");
				}
				for(int w = 0;w < drawStar3Num -i;w++) {       //�k�b�䪺�P�P
					System.out.print("*");
				}
			}
			System.out.print("\n");                   //�C�h�L��������
		}
		for(int j = drawStar3Num-1 ;j > 0; j--) {              //�U�b����for�j��
			if(j == 1) {                              //�̫��@�h���P�P
				for(int t = 0;t < 2*drawStar3Num - 1;t++) {
					System.out.print("*");
				}
			}
			else {                                    //�ѤU���U�b��
				for(int y = 0;y < drawStar3Num - j + 1;y++) {  //���b�䪺�P�P
					System.out.print("*");
				}
				for(int u = 0;u < 2*j-3 ;u++) {       //�������ť�
					System.out.print(" ");
				}
				for(int y = 0;y < drawStar3Num - j + 1;y++) {  //�k�b�䪺�P�P
					System.out.print("*");
				}
			}
			System.out.print("\n");                   //�C�h�L��������
		}
		
		

	}

}
