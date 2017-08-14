
public class CTime {

	//Attributes
	private int hour;
	private int min;
	private int sec;

	// Method
	// - 建構子
	public CTime(int h, int m, int s) {
		this.setData(h, m, s);
	}
	// - set
	public void setData(int h, int m, int s) {
		if(CTime.isValid(h, m, s)) {
			this.hour = h;
			this.min = m;
			this.sec = s;
		} else {
			this.hour = 1;
			this.min = 1;
			this.sec = 1;
		}		
	}
	// - get
	public int getHour() {
		return hour;
	}
	public int getMin() {
		return min;
	}
	public int getSec() {
		return sec;
	}
	public void print() {
		System.out.printf("%02d : %02d : %02d", this.hour, this.min, this.sec);
	}

	// - 類別方法
	public static boolean isValid(int h, int m, int s) {
		if(h < 0 || h > 23) {
			return false;
		} 
		if(m < 0 || m > 59) {
			return false;
		}
		if(s < 0 || s > 59) {
			return false;
		}
		return true;
	}
	public static int compare(CTime ct1, CTime ct2) {
		if(ct1.hour - ct2.hour != 0) {
			return ct1.hour - ct2.hour;
		}
		if(ct1.min - ct2.min != 0) {
			return ct1.min - ct2.min;
		}		
		return ct1.sec - ct1.sec;
	}


}
