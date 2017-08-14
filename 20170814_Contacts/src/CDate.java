//實作CDate類別，用來代表一筆日期資料
//請在Contacts專案底下新增一個名為「CDate」的類別（請勿加入main函式）用以描述日期。
//在此類別中加入三個私密（private）的資料成員year、month與day，型態為整數，分別用來表示年月日。
public class CDate {
	private int year, month, day;
	public CDate(int y, int m, int d) {
		this.setData(y, m, d);
		// 用來指定資料成員的值，可直接在建構子中呼叫它
		// 也可以在物件建立後
		// 用 this 是因為 setData 不是 static（類別方法）,
		// 所以 要用在 物件建立後 呼叫;
	}
	public void setData(int y, int m, int d) {
		year = month = day = 1;
		if (y >= 1) 
			year = y;
		if (m >= 1 && m <= 12)
			month = m;
		if (CDate.isValid(y, m, d) == true)
			day = d;
		// 檢查傳入的年月日是否是格式正確的日期
		// 回傳false代表格式不符
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public void print() {
		System.out.printf("%04d/%02d/%02d", 
				this.year, this.month, this.day);
	}
	
	//############
	// - 類別方法
	//############
	public static boolean isValid(int y, int m, int d) {
		//用陣列記住每個月的天數
		int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (y <= 0 || m <= 0 || m > 12)//年月超出正常範圍
			return false;	

		//如果不是二月
		if (m != 2) {
			//對應的天數不在正常範圍
			if (d <= 0 || d > days[m])
				return false; 
			return true;
		}
		//二月的情況需判斷閏年
		//西元年份除以4可整除且除以100不可整除，或
		//西元年份除以400可整除
		if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
			if (d <= 0 || d > 29)
				return false; 
			return true;
		}
		//平年（非閏年）
		if (d <= 0 || d > days[m])
			return false; 
		return true;
	}
	public static int compare(CDate a, CDate b) {
		//回傳數字代表兩個日期比較的結果
		//回傳小於0的值即代表a日期比較早
		//回傳大於0的值即代表a比較晚
		//回傳等於0的值即代表a, b兩個日期一樣
		if (a.year - b.year != 0)
			return a.year - b.year;
		if (a.month - b.month != 0)
			return a.month - b.month;
		return a.day - b.day;
	}
	// last {
}

