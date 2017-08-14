import java.lang.*;
import java.util.*;
public class ContactTest {
	
	// - static
	public static Contacts accountBook = new Contacts();
	public static Scanner scanner = new Scanner(System.in);
	// - main function
	public static void main(String[] args) {
		// test CDate
		System.out.println(" ###### test CDate. ###### ");
		CDate cd1 = new CDate(2011, 4, 3);
		CDate cd2 = new CDate(2001, 1, 3);
		CDate cd3 = new CDate(2011, 4, 30);

		cd1.print();
		System.out.println("");
		cd2.print();
		System.out.println("");
		cd3.print();
		System.out.println("");

		int result1 = CDate.compare(cd1, cd2);
		int result2 = CDate.compare(cd1, cd3);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println("------------------------------------------------------------");

		// test Account
		System.out.println(" ###### test Account. ###### ");
		CDate cd4 = new CDate(1977, 6, 27);
		CDate cd5 = new CDate(1987, 4, 30);
		Account ac1 = new Account("Joe", 40, cd4);
		Account ac2 = new Account("Mary", 30, cd5);

		System.out.print(ac1.getName()+" "+ac1.getAge()+" ");
		ac1.getBirthday().print();
		System.out.println("");

		System.out.print(ac2.getName()+" "+ac2.getAge()+" ");
		ac2.getBirthday().print();
		System.out.println("");
		System.out.println("------------------------------------------------------------");

		// test Contacts
		System.out.println(" ###### test Contacts. ###### ");
		accountBook.add("Joe", 40, new CDate(1977, 6, 27));
		accountBook.add("Mary", 25, new CDate(2000, 1, 3));
		accountBook.add("Tom", 25, new CDate(1995, 10, 13));
		accountBook.add("Bob", 25, new CDate(2011, 40, 3));
		accountBook.print();
		System.out.println("------------------------------------------------------------");

		// main code
		int option = -1;
		do {
			System.out.print("選項：1)新增,2)印出全部,-1)結束：");
			option = scanner.nextInt();
			if (option != -1 && option != 1 && option != 2) {
				System.out.print("Error!");
			}
			else if (option == -1) {
				System.out.println("感謝您的使用!");
				break;
			}
			else if (option == 2) {
				accountBook.print();
			}
			else if (option == 1) {
				System.out.print("姓名：");
				String name = scanner.next();
				System.out.print("年齡：");
				int age = scanner.nextInt();
				System.out.print("生日(年/月/日)：");
				int year = scanner.nextInt();
				int month = scanner.nextInt();
				int day = scanner.nextInt();
				CDate b1 = new CDate(year, month, day);
				accountBook.add(name,age,b1);
				System.out.println("新增成功!\n");
			}
		} while (true);
		
	}

	// last {
}