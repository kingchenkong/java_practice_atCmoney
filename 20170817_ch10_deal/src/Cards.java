//宣告int型態之陣列以及相關屬性，包括花色與點數，使其得以實現下列方法
public class Cards {
	// Attributes
	protected int[] poker;
	protected int remain;
	
	public Cards() {
		this.poker = new int[52];
		this.remain = 0;
	}
	
	public void newCards(){
		//產生一副新牌
		for(int i = 0; i < this.poker.length; i++) {
			this.poker[i] = i;
		}
		this.remain = 52;
		
	}
	public int getCard() {
		if(this.remain == 0) {
			this.newCards();
			System.out.println("\n-----new Cards------");
		}
		this.remain -= 1;
		return this.poker[this.remain];
	}
}
