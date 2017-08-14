//實作Account類別，用來代表一筆聯絡人的資料
//請在Contacts專案底下新增一個名為「Account」的類別（請勿加入main函式）用以描述聯絡人的資料。
//在此類別中加入三個私密（private）的資料成員name、age與birthday，型態分別為字串、整數，以及日期（CDate），分別用來表示姓名、年紀與生日。
public class Account {
	private String name = new String("");
	private int age = 0;
	private CDate birthday = new CDate(1, 1, 1);
	
	//建構子函式。三個參數分別代表姓名、年紀與生日的初始值
	public Account(String n, int a, CDate b) {
		this.setData(n, a, b);
	}
	public void setData(String n, int a, CDate b) {
		if (n != null)
			name = n;
		if (a > 0)
			age = a;
		if (b != null)
			birthday = b;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public CDate getBirthday() {
		return birthday;
	}
	
	
	// last {
}