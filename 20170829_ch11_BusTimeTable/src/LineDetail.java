
public class LineDetail {
	// 一班車 的資料
	//  |站名| 		|班次序| |發車時間| 	|星期一| |星期二| |星期三| |星期四| |星期五| |星期六| |星期日|
	//  	|華亞園區|	|1| 		|500| 		|1| 		|1| 		|1| 		|1| 		|1| 		|1| 		|1|

	// Attributes
	private String stationName;
	private String runsOrder;
	private String departureTime;
	private int[] runsOrNot;
	// Constructor
	public LineDetail(String[] arr) {
		this.runsOrNot = new int [7];
		this.setLineDetail(arr);
	}
	// setter
	public boolean setLineDetail(String[] arr) {
		this.stationName = arr[5];
		this.runsOrder = arr[6];
		this.departureTime = arr[7];
		try {
			for(int i = 0; i < 7; i++) 
				this.runsOrNot[i] = Integer.parseInt(arr[i+8]);
			return true;
		} catch(Exception ex) {
			System.out.println("arr[8~15] data error.");
			return false;
		}
	}
	// getter
	public String getString() {
		String str = String.format(",%s,%s,%s", this.stationName, this.runsOrder, this.departureTime);
		for(int i = 0; i < 7; i++)
			str += String.format(",%s", this.runsOrNot[i]);
		return str;
	}
	public String[] getData() {
		String[] arrStr = new String[10];
		arrStr[0] = this.stationName;
		arrStr[1] = this.runsOrder;
		arrStr[2] = this.departureTime;
		for(int i = 3; i < 10; i++)
			arrStr[i] = String.format("%d", this.runsOrNot[i-3]);
		return arrStr;
	}

	// output
	public void output() {
		System.out.print(this.getString());
	}

}
