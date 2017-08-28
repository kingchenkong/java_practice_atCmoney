package eeshiuan_ques;


public class pra6g {

	public static void main(String[] args) {
		int card[] = new int [52];
		for(int i=0; i<52; i++) {		
				card[i] = i;			
		}
		
		System.out.println("印出前");
		String s = "print()";	

		int get[] = new int [5];
		for(int n=0; n<get.length; n++) {
			get[n] = shuffle(card, card.length);
		}
		
		System.out.println("洗牌後：");
		System.out.println(get);
		
	}
	public static int shuffle(int a[], int count) {  
		int r = 0;
		for(int i=0; i<count; i++) {
			r = (int)(Math.random()*count);
			int temp = a[r];
			a[r] = a[i];
			a[i] = temp;
		}
		return a[r];
	}
	public String toString() {  //¶C¶L
		String str[]= {"黑桃","梅花","方塊","愛心"};
		String s = "";	
		for(int i=0; i<52; i++) {
			s += str[i % 13]+(i%4+1)+"\n";
		}
		System.out.print("");
		return s;
	}
	
}

