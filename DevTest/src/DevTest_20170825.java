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
		
		
	}

}
