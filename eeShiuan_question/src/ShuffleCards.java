
class ShuffleCards extends Cards{	//arr count

	public int remainCards(){ //回傳剩餘的卡牌數量
		return count;  
	}
	@Override public int getCard() {		//抽牌		
		int r, p = 0;
		r = (int)(Math.random()*30);
		for (int n=1; n<play.length; n++) { //輸入玩家牌組
			play[n] = arr[r];
			p = play[n];
		}		
		arr[r] = -1;
		count--;
			
		return p;
	}
	public void change(int a, int b) {	 //換牌
		int temp = play[a];
		play[a] = play[b];
		play[b] = temp;
	}
	public int compare( int c[], int p[] ) {  //判斷：收參考，回傳結果    -1:電腦    0:平手   １:玩家 (合作) 主函式：計分				
		for(int i=0; i<play.length; i++) {
			if( c[i] > p[i] ) {
				return -1;
			}
			else if ( c[i] < p[i] ) {
				return 1;
			}
			else
				return 0;
		}
		return 0;   //可能有bug?
	}
	public String print() {  //印牌
		String suit[] = {"paper, scissors, stone"};
		String s = "";
		for(int i=0; i<30; i++) {
			s += suit[ i % 3 ] + ( i % 10 + 1 ) + "\n";
		}
		return s;		
	}

}
