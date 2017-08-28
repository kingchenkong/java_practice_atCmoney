package eeshiuan_ques;


class ShuffleCards extends Cards{	//arr count

	public int remainCards(){ //¶^∂«≥—æl™∫•dµPº∆∂q
		return count;  
	}
	@Override public int getCard() {		//©‚µP		
		int r, p = 0;
		r = (int)(Math.random()*30);
		for (int n = 1; n < play.length; n++) { //øÈ§J™±ÆaµP≤’
			play[n] = arr[r];
			p = play[n];
		}		
		arr[r] = -1;
		count--;
			
		return p;
	}
	public void change(int a, int b) {	 //¥´µP
		int temp = play[a];
		play[a] = play[b];
		play[b] = temp;
	}
	public int compare( int c[], int p[] ) {  //ßP¬_°G¶¨∞—¶“°A¶^∂«µ≤™G    -1:πq∏£    0:•≠§‚   ¢∞:™±Æa (¶Xß@) •D®Á¶°°G≠p§¿				
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
		return 0;   //•iØ‡¶≥bug?
	}
	public String print() {  //¶LµP
		String suit[] = {"paper, scissors, stone"};
		String s = "";
		for(int i=0; i<30; i++) {
			s += suit[ i % 3 ] + ( i % 10 + 1 ) + "\n";
		}
		return s;		
	}

}

