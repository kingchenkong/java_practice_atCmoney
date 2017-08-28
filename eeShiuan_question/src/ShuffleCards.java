
class ShuffleCards extends Cards{	//arr count

	public int remainCards(){ //�^�ǳѾl���d�P�ƶq
		return count;  
	}
	@Override public int getCard() {		//��P		
		int r, p = 0;
		r = (int)(Math.random()*30);
		for (int n=1; n<play.length; n++) { //��J���a�P��
			play[n] = arr[r];
			p = play[n];
		}		
		arr[r] = -1;
		count--;
			
		return p;
	}
	public void change(int a, int b) {	 //���P
		int temp = play[a];
		play[a] = play[b];
		play[b] = temp;
	}
	public int compare( int c[], int p[] ) {  //�P�_�G���ѦҡA�^�ǵ��G    -1:�q��    0:����   ��:���a (�X�@) �D�禡�G�p��				
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
		return 0;   //�i�঳bug?
	}
	public String print() {  //�L�P
		String suit[] = {"paper, scissors, stone"};
		String s = "";
		for(int i=0; i<30; i++) {
			s += suit[ i % 3 ] + ( i % 10 + 1 ) + "\n";
		}
		return s;		
	}

}
