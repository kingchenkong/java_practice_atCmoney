// 1990/7/3
public class Date {
	private String date;
	private int year;
	private int month;
	private int day;
	public static final int[] arrLeapMon = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] arrNotLeapMon = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public Date(String str) {
		if(Date.isExist(str)) {
			String[] arrS = str.split("/", 3);
			this.year = Integer.parseInt(arrS[0]);
			this.month = Integer.parseInt(arrS[1]);
			this.day = Integer.parseInt(arrS[2]);
			this.date = String.format("%4d/%d/%d", this.year, this.month, this.day);
		}
	}
	// getter
	public String getDate() {
		return this.date;
	}

	// output
	public void output() {
		System.out.println(this.date);
	}
	public static boolean isExist(String str) {
		// 不能有非"/"
		char[] arrForCheck = str.toCharArray();
		for(int i = 0; i < arrForCheck.length; i++) {
			if((int) arrForCheck[i] < 47 || (int) arrForCheck[i] > 57)
				return false;
		}
		
		String[] arrS = str.split("/", 3);

		// String[] length = 3, 且都有值
		if(arrS.length != 3) 
			return false;

		for(int i = 0; i < arrS.length; i++) 
			if(arrS[i].length() < 1)
				return false;
		// 1990, 7, 3
		// - year
		int y = 0;
		char[] arrC = arrS[0].toCharArray();
		// - [0] 皆為數字
		for(int i = 0; i < arrC.length; i++) 
			if((int) arrC[i] < 48 || (int) arrC[i] > 57) 
				return false;
		//加總
		for(int i = 0; i < arrC.length; i++) {
			y += ((int)arrC[i] - 48) * ((int)Math.pow(10, arrC.length - 1 - i));
			//			System.out.println("y =" + y);
		}
		// - month
		int m = 0;
		arrC = arrS[1].toCharArray();
		// - [1] 皆為數字
		for(int i = 0; i < arrC.length; i++) 
			if((int) arrC[i] < 48 || (int) arrC[i] > 57) 
				return false;
		//加總
		for(int i = 0; i < arrC.length; i++) {
			m += ((int)arrC[i] - 48) * ((int)Math.pow(10, arrC.length - 1 - i));
//			System.out.println("m =" + m);
		}
		if(m < 1 || m > 12)
			return false;
		// - day
		int d = 0;
		arrC = arrS[2].toCharArray();
		// - [2] 皆為數字
		for(int i = 0; i < arrC.length; i++) 
			if((int) arrC[i] < 48 || (int) arrC[i] > 57) 
				return false;
		//加總
		for(int i = 0; i < arrC.length; i++) {
			d += ((int)arrC[i] - 48) * ((int)Math.pow(10, arrC.length - 1 - i));
//			System.out.println("d =" + d);
		}
		// isLeap
		if(Date.isLeap(y)) {
			if(d < 0 || d > Date.arrLeapMon[m-1]) {
				return false;
			}
		}else {
			if(d < 0 || d > Date.arrNotLeapMon[m-1]) {
				return false;
			}
		}

		return true;
	}
	public static boolean isLeap(int y) {
		// % 4 = 0
		// % 100 != 0
		// % 400 == 0
		if(y % 4 ==0)
			if(y % 100 != 0 || y % 400 == 0)
				return true;
		// else
		return false;
	}



}
