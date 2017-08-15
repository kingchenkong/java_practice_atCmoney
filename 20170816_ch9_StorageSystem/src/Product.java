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
	public static final String G = "克";
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
	public Product(String no, String name, String unit, String maker, int price, int stock) {
		this.setter(no, name, unit, maker, price, stock);
	}
	// setter
	public void setter(String no, String name, String unit, String maker, int price, int stock) {
		this.no = no;
		this.name = name;
		this.unit = unit;
		this.maker = maker;
		this.price = price;
		this.stock = stock;
	}
	// getter
	
	// output
	public void print() {
		System.out.print(this.no + "\t");
		System.out.print(this.name + "\t");
		System.out.print(this.maker + "\t");
		System.out.print(this.price + "\t");
		System.out.print(this.stock + "\t");
		System.out.print(this.unit);
	}
	
}
