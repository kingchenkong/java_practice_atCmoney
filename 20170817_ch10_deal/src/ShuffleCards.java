import java.math.*;
public class ShuffleCards extends Cards{
	protected final String club = "梅花";
	protected final String diamond = "方塊";
	protected final String heart = "愛心";
	protected final String spade = "黑桃";

	public ShuffleCards() {
	}

	public int remainCards(){
		//回傳剩餘的卡牌數量
		return this.remain;
	}
	@Override public int getCard(){
		//實作getCards方法，隨機從卡牌中發一張牌，沒牌請自動產生一副新牌
		if(this.remain == 0) {
			this.newCards();
			System.out.println("\n-----new Cards------");
		}
		int returnVal = 0;
			int random =(int)(Math.random() * this.remain);
			returnVal = this.poker[random];
			this.poker[random] = -1;
			int temp = this.poker[this.remain - 1];
			this.poker[this.remain - 1] = this.poker[random];
			this.poker[random] = temp;
			
		this.remain -= 1;
		return returnVal;
	}
	@Override public String toString(){
		//列出剩餘的牌之花色與數字
		String returnStr = String.format("remain %d sheets\n", this.remain);
		int getCount = 0;
		for(int i = 0; i < 52 ; i++) {
			if(getCount == this.remain) {
				break;
			}
			if(i != 0 && i % 4 == 0) {
				returnStr += "\n";
			}
			if(this.poker[i] != -1) {
				returnStr += String.format("# %2s %2d #|", this.color(this.poker[i] % 4), (this.poker[i] / 4 + 1) );
				getCount += 1;
			} else {
				returnStr += "# ------ #|";
			}
		}

		return returnStr;
	}
	public String color (int colorNum) {
		String str = "";
		switch(colorNum) {
		case 0:
			str += this.club;
			break;
		case 1:
			str += this.diamond;
			break;
		case 2:
			str += this.heart;
			break;
		case 3:
			str += this.spade;
			break;
		default:
			str += "is Error.";
		}
		return str;
	}
	public String printCardData(int pokerNum) {
		return String.format("# %2s %2d #|", this.color(pokerNum % 4), (pokerNum / 4 + 1) );
	}
}
