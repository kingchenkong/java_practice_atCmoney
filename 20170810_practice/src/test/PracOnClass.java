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