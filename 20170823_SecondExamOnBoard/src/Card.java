// 代表一張牌的資料
public class Card {
	private int colorNum;
	private int pointNum;
	public static final String S = "剪刀";	// 0
	public static final String R = "石頭";	// 1
	public static final String P = "布";		// 2

	public Card(int num) {
		this.colorNum = num % 3; 		// 0, 1, 2
		this.pointNum = num / 3 + 1; 	// 0 ~ 9
	}
	// getter
	public int getColorNum() {
		return this.colorNum;
	}
	public int getPointNum() {
		return this.pointNum;
	}
	public void outputCardData() {
		String outputColorStr = "";
		switch(this.colorNum) {
		case 0:
			outputColorStr = String.format("%s", Card.S);
			break;
		case 1:
			outputColorStr = String.format("%s", Card.R);
			break;
		case 2:
			outputColorStr = String.format("%s", Card.P);
			break;
		default:
			System.out.println("ColorNum Error.");
		}
		System.out.printf(" %2s %2dp ", outputColorStr, this.pointNum);
		return ;
	}



}
