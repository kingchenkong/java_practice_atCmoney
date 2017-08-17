import java.lang.*;
import java.util.*;
public class TestList {
	// static 
	public static Scanner sc = new Scanner(System.in);
	public static AdvancedSearchList advSList = new AdvancedSearchList();
	public static void main(String[] args) {

		menu();

	}
	public static void menu() {
		do {
			System.out.println("Options: 1) Append, 2)Search, 3)Max, 4)remove(index), 5)remove(value,number), -1)Quit: ");
			int option = sc.nextInt();
			switch(option) {
			case -1:
				System.out.println("Quit.");
				return;
			case 1:
				advSList.add(sc.nextInt());
				print();
				break;
			case 2:
				int s = sc.nextInt();
				System.out.println("search ( " + s + " ) => " + advSList.search(s) );
				break;
			case 3:
				System.out.println("findmax = " + advSList.findMax() );
				break;
			case 4:
				advSList.remove(sc.nextInt());
				print();
				break;
			case 5:
				advSList.remove(sc.nextInt(), sc.nextInt());
				print();
				break;	
			default:
				System.out.println("Input Error.");
			}
		} while(true);
	}
	public static void print() {
		advSList.printListData(true);
		return;
	}

}
