//宣告Card陣列以及相關屬性、方法與建構子，使其得以實現下列方法

public class Cards {
	private Card[] cardLot;
	private int remainCount; // 1 ~ 30

	public Cards() {
		this.newCards();
	}
	public void newCards(){
		//產生一副新牌
		this.cardLot = new Card[30];
		this.remainCount = 30;
		for(int i = 0; i < 30; i++) 
			this.cardLot[i] = new Card(i);

	} 
	public void shuffle() {
		//進行洗牌
		for(int i = 0; i < 30; i++) {
			int ran = (int) (Math.random() * 30);
			Card temp = this.cardLot[i];
			this.cardLot[i] = this.cardLot[ran];
			this.cardLot[ran] = temp;
			//			System.out.println(i + " -> " + ran);
		}
	}
	public Card deal() {
		//抽出一張牌
		if(this.remainCount > 0)
			return this.cardLot[--this.remainCount];
		else
			return null;
	}
}
