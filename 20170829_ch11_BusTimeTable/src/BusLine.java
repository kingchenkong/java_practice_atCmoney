
public class BusLine {
	// 一班車 的資料
	//  |客運業者| |路線編號| |支線| |往返| |路線名稱| 				
	//  |三重客運| |1209| 	|0| 	  |往|  |公西→臺北北門[經林口國宅]|

	// Attributes
	private String company;
	private String lineNo;
	private String branchLine;
	private String toOrBack;
	private String lineName;
	private LineDetail[] listLineDetail;
	private int listCount;

	// Constructor
	public BusLine(String[] arr) {
		this.listLineDetail = new LineDetail[20];
		this.listCount = 0;
		this.setLineData(arr);
	}
	// setter
	public boolean setLineData(String[] arr) {
		try {
			this.company = arr[0];
			this.lineNo = arr[1];
			this.branchLine = arr[2];
			this.toOrBack = arr[3];
			this.lineName = arr[4];
			return true;
		} catch (Exception ex) {
			System.out.println("setLineData arr data error.");
			return false;
		}
	}
	public boolean setListLineDetail(String[] arr) {
		if(this.listCount == this.listLineDetail.length) 
			this.resizeList();
		this.listLineDetail[this.listCount++] = new LineDetail(arr);
		return true;
	}
	public boolean resizeList() {
		LineDetail[] arrCopy = new LineDetail[this.listLineDetail.length * 2];
		for(int i = 0; i < this.listLineDetail.length; i++)
			arrCopy[i] = this.listLineDetail[i];
		this.listLineDetail = arrCopy;
		return true;
	}
	// getter
	public String getString(){
		String str = String.format("%s,%s,%s,%s,%s", this.company, this.lineNo, this.branchLine, this.toOrBack, this.lineName);
		return str;
	}
	public String[] getData() {
		String[] arrStr = new String[6];
		arrStr[0] = this.company;
		arrStr[1] = this.lineNo;
		arrStr[2] = this.branchLine;
		arrStr[3] = this.toOrBack;
		arrStr[4] = this.lineName;
//		arrStr[5] = String.format("%d", this.listCount);
		return arrStr;
	}
	public int getListCount() {
		return this.listCount;
	}
	public LineDetail getList(int i) {
		return this.listLineDetail[i];
	}
	// output
	public void output() {
		System.out.print(this.getString());
	}
	// function

	

}
