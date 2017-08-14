
public class Record {
	//Attributes
	private String name;
	private int price;
	private CTime recordTime;

	// Method
	// - 建構子
	public Record(String n, int p, CTime rt) {
		this.setData(n, p, rt);
	}
	// - set
	public void setData(String n, int p, CTime rt) {
		this.name = n;
		this.price = p;
		this.recordTime = rt;
	}
	// - get
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public CTime getRecordTime() {
		return recordTime;
	}
	public void print() {
		System.out.printf("%02d : %02d : %02d", this.name, this.price, this.recordTime);
	}
}
