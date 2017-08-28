import java.util.*;
import java.lang.*;
public class DevTest_20170825 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		String str = "yyyy mmmm\t ddd     \r aaabbbbiioio      \n";
		String[] tokens = str.split("\\s+");
		
		for(int i = 0; i < tokens.length; i++) {
			System.out.println("--------------");
			System.out.println("|" + tokens[i] + "|");
		}
		
		System.out.println("--------------------------------------------------------");
		System.out.println(CA.class);
		System.out.println("--------------");
		CA a = new CA();
		System.out.println(a.getClass());
		System.out.println(a.toString());
		System.out.println(a.getClass().getName());
		System.out.println(a.getClass().getSimpleName());
		System.out.println(a);
		System.out.println();
		System.out.println("--------------");
		System.out.println(a instanceof originCA);
		
		if(a instanceof Object) {
			System.out.println("true");
		}
		System.out.println("--------------");
		System.out.println("--------------");
		String str1 = "apple";
		String str2 = "application";
		String str3 = "appzz";
		String str4 = "aPple";
		System.out.println(str1.compareTo(str1));
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.compareTo(str3));
		System.out.println(str1.compareTo(str4));
		System.out.println("--------------");
		System.out.println(str1.compareToIgnoreCase(str1));
		System.out.println(str1.compareToIgnoreCase(str2));
		System.out.println(str1.compareToIgnoreCase(str3));
		System.out.println(str1.compareToIgnoreCase(str4));
		System.out.println("--------------");
		System.out.println("--------------");
		
		
		
		
		
	}
	public static int valOf(int a, int b) {
		
		return 1;
	}
	final void valOf(int a, int b,int c) {
		
	}

}
class originCA {
	private int j;
	
	public originCA() {
		j = 5;
	}
	public int getj() {
		return j;
	}
	
}

class CA extends originCA {
	private int i;
	
	public CA() {
		i = 10;
	}
	public int geti() {
		return i;
	}
}
