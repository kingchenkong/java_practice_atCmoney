
public class RunsData {
	// 一班車 的資料
	//  |客運業者| |路線編號| |支線| |往返| |路線名稱| 				|站名| 		|班次序| |發車時間| 	|星期一| |星期二| |星期三| |星期四| |星期五| |星期六| |星期日|
	//  |三重客運| |1209| 	|0| 	  |往|  |公西→臺北北門[經林口國宅]| 	|華亞園區|	|1| 		|500| 		|1| 		|1| 		|1| 		|1| 		|1| 		|1| 		|1|
	protected String company;
	protected String pathNo;
	//	protected char branchLine; 	// may be char, one char
	protected String branchLine;
	//	protected boolean toOrBack; 	// true: 往, false: 返
	protected String toOrBack;
	protected String pathName;		
	protected String stationName;
	//	protected int rinsOrder;
	protected String rinsOrder;
	//	protected int departureTime;
	protected String departureTime;
	//	protected boolean[] runsOrNot;
	protected String[] runsOrNot;

	public RunsData(String[] arr){
		this.runsOrNot = new String[7];
		this.setData(arr);
	}
	// setter
	public void setData(String[] arr) {
		this.company = arr[0];
		this.pathNo = arr[1];
		this.branchLine = arr[2];
		this.toOrBack = arr[3];
		this.pathName = arr[4];
		this.stationName = arr[5];
		this.rinsOrder = arr[6];
		this.departureTime = arr[7];

		for(int i = 8; i < 15; i++)
			this.runsOrNot[i-8] = arr[i];
	}
	// getter
	public String getData(){
		String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.company, this.pathNo, this.branchLine, this.toOrBack, this.pathName, this.stationName, this.rinsOrder, this.departureTime);
		for(int i = 0; i < 7; i++) {
			str += String.format(",%s", this.runsOrNot[i]);
		}
		return str;
	}
	// output
	public void output() {
//		System.out.printf("%s | %s | %s | %s | %s | %s | %s | %s | ", this.company, this.pathNo, this.branchLine, this.toOrBack, this.pathName, this.stationName, this.rinsOrder, this.departureTime);
//		for(int i = 0; i < 7; i++) {
//			System.out.printf("%s | ", this.runsOrNot[i]);
//		}
//		System.out.println();
		System.out.println(this.getData());
	}


	//		public RunsData(String com, String pno, char bl, boolean tob, String pna, String sn, int ro, int dt, boolean[] ron){
	//		this.company = com;
	//		this.pathNo = pno;
	//		this.branchLine = bl;
	//		this.toOrBack = tob;
	//		this.pathName = pna;
	//		this.stationName = sn;
	//		this.rinsOrder = ro;
	//		this.departureTime = dt;
	//		this.runsOrNot = ron;
	//	}
}
