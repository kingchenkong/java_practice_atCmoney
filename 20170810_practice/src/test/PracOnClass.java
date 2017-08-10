package test;

public class PracOnClass {

	public static void main(String[] args) {
		CSstudent john = new CSstudent();

		john.id = 54088;
		john.name = "Johnson Johnson";
		john.major = "Computer Science";
		//		john.score = 85.5; score 是 private
		//		john.address = "關你屁四"; address 是 private

		System.out.println("物件 '" + john.name + "' 的資料 : ");
		System.out.println("id : " + john.showId());
		System.out.print("major : ");
		john.showMajor();

		// CMyClass
		CMyClass X = new CMyClass(2);
		CMyClass Y = new CMyClass(5,40);  
		CMyClass Z = new CMyClass(20.2,30.6);  

		X.showVar();
		Y.showVar();
		Z.showVar();

		System.out.println("------------------------------------");
		int c10 = 30, c5 = 30, c1 = 20;
		int ch = 165;
		int[] arrNeedCh = new int[3];
		// coin 10
		if(ch / 10 >= c10) {
			arrNeedCh[2] = c10;
			ch = ch - 10 * c10; 
		} else {
			arrNeedCh[2] = ch / 10;
			ch = ch - 10 * arrNeedCh[2];
		}
		// coin 5
		if(ch / 5 >= c5) {
			arrNeedCh[1] = c5;
			ch = ch - 5 * c5; 
		} else {
			arrNeedCh[1] = ch / 5;
			ch = ch - 5 * arrNeedCh[1];
		}
		// coin 1
		if(ch >= c1) {
			arrNeedCh[0] = c1;
			ch = ch - c1; 
		} else {
			arrNeedCh[0] = ch;
			ch = ch - arrNeedCh[0];
		}
		// 零錢不夠
		if(ch != 0) {
			System.out.println("「現金不足，無法找零」");
		} else {
			System.out.printf("找您 10 元硬幣 %2d 個,\n", arrNeedCh[2]);
			System.out.printf("找您 5  元硬幣 %2d 個,\n", arrNeedCh[1]);
			System.out.printf("找您 1  元硬幣 %2d 個,\n", arrNeedCh[0]);
		}



	}

}
//
class CCar{
	public int wheel;
	public int person;
	public String name;
	private String engine;
}
//
class CMyClass{

	public double dbA;  
	private double dbB;
	private int intC;

	public String strA = "strA is end.";
	private String strB = "strB is end.";




	//-------------
	// 建構函式
	private CMyClass() {
		System.out.println("CMyClass() is execute.");

	}
	public CMyClass(int i) {
		intC = i;
		//		CMyClass();
	}
	public CMyClass(int a,int b)	//定義兩個整數參數的建構函式
	{
		dbA = a;  
		dbB = a+b;
	}
	public CMyClass(double  a,double  b)	//定義兩個浮點數參數的建構函式
	{
		dbA = a;  
		dbB = a*b;
	}
	private CMyClass(String str) {
		System.out.println("CMyClass(String str) is execute.");
		System.out.println("str = " + str);
	}

	//-------------
	//一般函式
	public void showVar()
	{
		System.out.println("VarA =" + dbA);
		System.out.println("VarB =" + dbB);
	} 
	public void addVar(int b){
		intC=intC+b;  
	}

}