import java.util.Random;

public class Cards {
	//����
	public static int arr[]  = new int [30];
	public static int play[] = new int [5];
	public static int count = 30;
	//�غc�l
	public Cards(){ //���ͤ@�Ʒs�P
		this.newCards();
	}
	//��k
	public void newCards() {	//���P
		for(int i=0; i<30; i++) { 	//�]�w�P��index 0~29
			arr[i] = i ;			
		}
	}
	public int getCard() {
		if(count < 0) {  //�קK�o�X�o�� -��
			return -1;
		}
		return arr[count--];  //��arr[count]�A�o�X�h�@�i��A�Acount--
	}

}	


