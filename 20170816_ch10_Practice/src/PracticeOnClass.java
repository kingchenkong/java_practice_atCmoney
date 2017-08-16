
import java.util.*;
import java.lang.*;
public class PracticeOnClass {
	//static

	public static void main(String[] args) {
		// main code
		Cb b1 = new Cb();
		b1.show( 17, 18);
		System.out.println("######################################################");
		Cb b2 = new Cb( 5, 6);
		b2.show( -17, -18);



	}
	// function


}
// class
class C {
	protected int t0;
	public int t1;
	int t2; // package
	
	public C() {
		System.out.println("鄒罵建構子() 構築中...");
		this.t0 = 101;
		this.t2 = 103;
	}
	public C(int i, int j) {
		System.out.println("鄒罵--建構子( i, j) 構築中...");
		this.t0 = i;
		this.t2 = j;
		
	}
	
}
class Ca extends C {
	protected int x;
	public int y;
	int z; // package
	
	protected int t1;
	

	public Ca() {
		System.out.println("老爸建構子() 構築中...");
		this.x = 1;
		this.z = 3;
		this.t1 = 222;
	}
	public Ca(int i, int j) {
		super( i + 1, j + 1);
		System.out.println("老爸--建構子( i, j) 構築中...");
		this.x = i;
		this.z = j;
		this.t1 = 333;
		
		
	}
	protected C show(int a, int b) {
		System.out.println("父類別 的 show. 被執行了...");
		System.out.println("Show a = " + a + " ,b = " + b);
		return new C();
	}
	protected int mes(String str) {
		System.out.println("父類別的mes : " + str);
		return 1;
	}
}

class Cb extends Ca {
	protected int y;
	protected int t1;

	public Cb() {
		System.out.println("你的建構子() 構築中...");
		this.y = 2;
		this.t1 = -222;
	}
	public Cb(int m, int n) {
		super( m + 1, n + 1);
		System.out.println("你的--建構子( m, n) 構築中...");
		this.y = m + n;
		this.t1 = -333;
		
	}
	@Override public Ca show(int m, int n) {
		System.out.println("--------------------------");
		System.out.println("var x = " + x);
		System.out.println("var y = " + y);
		System.out.println("var z = " + z);
		System.out.println("--------------------------");
		
		// this, super 部分 -- （ 類別 ch10_02 ）
		this.x = -1;
		System.out.println(" - this -	.x = " + this.x);
		System.out.println(" # super #	.x = " + super.x);
		System.out.println(" - this - 	.y = " + this.y);
		System.out.println(" # super # 	.y = " + super.y);
		System.out.println(" - this - 	.z = " + this.z);
		System.out.println(" # super # 	.z = " + super.z);
		System.out.println("--------------------------");
		this.x = -1;
		System.out.println(" - this -	.t0 = " + this.t0);
		System.out.println(" # super #	.t0 = " + super.t0);
		System.out.println(" & supsup &	.t0 = " + super.t0);
		System.out.println(" - this - 	.t1 = " + this.t1);
		System.out.println(" # super # 	.t1 = " + super.t1);
		System.out.println(" & supsup &	.t1 = " + super.t1);
		System.out.println(" - this - 	.t2 = " + this.t2);
		System.out.println(" # super # 	.t2 = " + super.t2);
		System.out.println(" & supsup &	.t2 = " + super.t2);
		System.out.println("--------------------------");
		
		// override, overLoad 部分 -- （ 類別 ch10_03 ）
		super.show(m, n);
		
		return new Ca();
	}
	protected int mes(String str, String str2) {
		System.out.println("這是多載 因為 同名 但不同 署名 :" + str2);
		System.out.println("子類別的mes : " + str);
		
		super.mes("這是 父類別 的mes str");
		
		return 1;
	}
	
}