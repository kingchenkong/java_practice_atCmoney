//Dozen 打 
//gross 羅（12打） 
//drum 桶 
//-------------In bulk 散裝 
//lot 批 
//package 件 
//pallet 拖盤 
//Pieces/pcs 件 
//Ream 令
//roll 卷 
//set 套、台、坐 
//Sheet 張、件
//strand 股 
//unit 輛、台、單位 
//Vial 藥瓶
public class Product {
	private String no;		//商品編號（Product No.，字串）
	private String name;		//商品名稱（Product Name，字串）
	private String unit;		//單位（Unit，字串）
	private String maker;	//製造商（Maker，字串）
	private int price;		//單價（Price，整數）
	private int stock;		//庫存量（Stock，整數）
	
	//常數
	public static final String G = "公克";
	public static final String KG = "公斤";
	public static final String BOXFUL = "箱";
	public static final String Dozen = "打";
	public static final String GROSS = "羅";
	public static final String DRUM = "桶";
	public static final String LOT = "批";
	public static final String PACKAGE = "包";
	public static final String PALLET = "拖盤";
	public static final String PIECES = "件";
	public static final String REAM = "令";
	public static final String ROLL = "卷";
	public static final String SET = "套";
	public static final String SHEET = "張";
	public static final String STRAND = "股";
	public static final String UNIT = "台";
	public static final String Vial = "瓶(藥)";
	
	// 建構子
	public Product(String no, String name, int unitNum, String maker, int price) {
		this.setter(no, name, maker, price);
		this.setUnit(unitNum);
		this.stock = 0;
	}
	// setter
	public void setter(String no, String name,  String maker, int price) {
		this.no = no;
		this.name = name;
//		this.unit = unit;
		this.maker = maker;
		this.price = price;
	}
	public boolean setUnit(int unitNum) {
		switch(unitNum) {
		case 1:
			this.unit = this.G;
			return true;
		case 2:
			this.unit = this.KG;
			return true;
		case 3:
			this.unit = this.BOXFUL;
			return true;
		case 4:
			this.unit = this.Dozen;
			return true;
		case 5:
			this.unit = this.GROSS;
			return true;
		case 6:
			this.unit = this.DRUM;
			return true;
		case 7:
			this.unit = this.LOT;
			return true;
		case 8:
			this.unit = this.PACKAGE;
			return true;
		case 9:
			this.unit = this.PALLET;
			return true;
		case 10:
			this.unit = this.PIECES;
			return true;
		case 11:
			this.unit = this.REAM;
			return true;
		case 12:
			this.unit = this.ROLL;
			return true;
		case 13:
			this.unit = this.SET;
			return true;
		case 14:
			this.unit = this.SHEET;
			return true;
		case 15:
			this.unit = this.STRAND;
			return true;
		case 16:
			this.unit = this.unit;
			return true;
		case 17:
			this.unit = this.Vial;
			return true;
		default:
			return false;
		}
	}
	public void increaseStock(int amount) {
		this.stock += amount;
	}
	public void decreaseStock(int amount) {
		this.stock -= amount;
		
	}
	// getter
	public int getStock() {
		return this.stock;
	}
	
	
	// output
	public void print() {
		System.out.printf(" %2s %5s", " ", this.no);
		System.out.printf(" %3s %6d", " ", this.stock);
		System.out.printf(" %2s %2s", " ", this.unit);
		System.out.printf(" %3s %5d", " ", this.price);
		System.out.printf(" %2s %6s", " ", this.name);		
		System.out.printf(" %4s %s", " ", this.maker);
		
//		System.out.print(this.no + "\t");
//		System.out.print(this.name + "\t");
//		System.out.print(this.maker + "\t");
//		System.out.print(this.price + "\t");
//		System.out.print(this.stock + "\t");
//		System.out.print(this.unit);
	}
	
}
