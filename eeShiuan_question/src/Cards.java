import java.util.Random;

public class Cards {
	//成員
	public static int arr[]  = new int [30];
	public static int play[] = new int [5];
	public static int count = 30;
	//建構子
	public Cards(){ //產生一副新牌
		this.newCards();
	}
	//方法
	public void newCards() {	//產牌
		for(int i=0; i<30; i++) { 	//設定牌之index 0~29
			arr[i] = i ;			
		}
	}
	public int getCard() {
		if(count < 0) {  //避免發出發到 -值
			return -1;
		}
		return arr[count--];  //先arr[count]，發出去一張後，再count--
	}

}	


