import java.lang.*;
import java.util.*;
public class TechersDemo {

	public static void main(String[] args) {

		ClassC objC1 =	new ClassC();  
		ClassC objC2 =	new ClassC(10);  
		ClassC objC3 =	new ClassC(3,5);  
		objC1.show();
		objC2.show();
		objC3.show();


	}

}

class ClassA {
	protected int varA;
	public ClassA() { 
		varA=1;
		System.out.println("this is Constructor 'ClassA()'");
	}  
	public ClassA(int i) { varA=i;}
}

// 類別ClassB 繼承自 類別ClassA
class ClassB extends ClassA	{
	protected int varB;  
	public ClassB() { 
		varB=1;
		System.out.println("this is Constructor 'ClassB()'");
	}  
	public ClassB(int i) {
		super(i);  
		varB=i;
		System.out.println("this is Constructor 'ClassB(int i)'");
	}
}
// 類別ClassC 繼承自 類別ClassB
class ClassC extends ClassB {
	protected int varC;  public ClassC() { 
		varC=1;
		System.out.println("this is Constructor 'ClassC()'");
	}  
	public ClassC(int i) {
		varC=i;
		System.out.println("this is Constructor 'ClassC(int i)'");
	}  
	public ClassC(int i,int j) {
		super(i*j);  
		varC=i*j;
		System.out.println("this is Constructor 'ClassC(int i, int , j)'");
	}
	public void show() {
		System.out.print(" varA = " + varA + "\t");  
		System.out.print(" varB = " + varB + "\t");  
		System.out.println(" varC = " +varC);
	}
}