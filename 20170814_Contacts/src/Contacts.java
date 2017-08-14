//實作Contacts類別，用來代表一個聯絡簿並可儲存多筆聯絡人的資料
//請在Contacts專案底下新增一個名為「Contacts」的類別（請勿加入main函式）用以描述聯絡人的資料。
//在此類別中加入三個私密（private）的資料成員accounts與count，
//其中accounts是一個陣列，每個元素的型態為Account，初始的長度為50，
//而count代表陣列中目前有幾筆聯絡人資訊，一開始初始化為0。
public class Contacts {
	//用陣列來儲存這些資料，每一個元素都是指向Account物件的參考
	private Account accounts[] = new Account[50];
	private int count = 0;	//目前儲存的資料筆數

	//建構子
	public Contacts() {

	}
	//加入一筆聯絡資訊，包括此人的姓名、年紀與生日
	public void add(String name, int age, CDate birthday) {
		Account newAccount = new Account(name, age, birthday);
		if (this.count >= accounts.length)	
			this.resize();	//呼叫resize將陣列變大
		this.accounts[this.count++] = newAccount; 
		//將新物件的位址存入陣列中
	}
	//將陣列的長度變成原本的兩倍
	//因為是類別自己使用，因此宣告為private
	private void resize() {
		//產生一個容量為原本兩倍大的陣列
		Account newArray[] = new Account[accounts.length * 2];

		//將原本陣列中的內容（物件的記憶體位址）複製到新的陣列
		for (int i = 0; i < this.count; i++) {
			newArray[i] = this.accounts[i];
		}
		this.accounts = null;
		this.accounts = newArray;
	}
	//印出全部的資料
	public void print() {
		//排除掉索引不合法的情況
		for (int i = 0; i < count; i++) {
			Account person = this.accounts[i];
			String name = person.getName();
			int age = person.getAge();
			CDate birthday = person.getBirthday();
			System.out.printf("%2d%10s", i + 1, name);
			System.out.printf("%5d", age);
			System.out.print("  ");
			birthday.print();
			System.out.println("");
		}
	}

	// last {
}
