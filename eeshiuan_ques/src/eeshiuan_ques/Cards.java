package eeshiuan_ques;

import java.util.Random;

public class Cards {
	//¶®≠˚
	public static int arr[]  = new int [30];
	public static int play[] = new int [5];
	public static int count = 30;
	//´ÿ∫c§l
	public Cards(){ //≤£•Õ§@∞∆∑sµP
		this.newCards();
	}
	//§Ë™k
	public void newCards() {	//≤£µP
		for(int i=0; i<30; i++) { 	//≥]©wµP§ßindex 0~29
			arr[i] = i ;			
		}
	}
	public int getCard() {
		if(count < 0) {  //¡◊ßKµo•Xµo®Ï -≠»
			return -1;
		}
		return arr[count--];  //•˝arr[count]°Aµo•X•h§@±i´·°A¶Acount--
	}

}	


