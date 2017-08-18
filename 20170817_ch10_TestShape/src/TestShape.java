//建立一TestShape之類別，在類別內禁止使用public的屬性；可依需求自行定義private的成員函式與變數；達到以下效果： 
//
//Menu: 1)add, 2)output, -1)Quit: 1
//Options: 1)rectangle, 2)circle, 3)trapezoid, -1)Quit: 1
//
//選擇選單功能1，嘗試新增一種形狀到陣列去，同時印出另一層選單選擇輸入的形狀類型。選擇子 選項1 則 請使用者輸入矩形的長與寬，並顯示面積與周長
//選擇子選項2則請使用者輸入圓形的半徑，並顯示面積與周長
//選擇子選項3則請使用者輸入等腰梯形的上下底與高， 並顯示面積與周長
//
//選擇選單功能2請印出所有形狀，請標示每一種形狀的類型、 面積與周長
import java.util.*;
import java.lang.*;
public class TestShape {

	//	static 
	static Scanner sc = new Scanner(System.in);
	static CShape[] arrCS = new CShape[10];
	static int arrCount = 0;
	public static void main(String[] args) {
				menu();
	}
	// function
	static void menu() {
		do {
			System.out.print("\nMenu: 1)add, 2)output, -1)Quit: ");
			int option = sc.nextInt();
			switch(option) {
			case -1:
				System.out.println("is Quit.");
				return;
			case 1:
				// add
				add();
				break;
			case 2:
				//output all
				output();
				break;
			default:
				System.out.println("Input Error.");
			}
		} while(true);
	}
	static void add() {
		//add CShape in array
		do {
			System.out.print("\nOptions: 1)rectangle, 2)circle, 3)trapezoid, -1)Quit: ");
			int option = sc.nextInt();
			switch(option) {
			case -1:
				System.out.println("back to Menu.");
				return;
			case 1:
				// add rectangle
				System.out.println(" -add rectangle");
				double w; // width
				do {
					System.out.print("intput width: ");
					w = sc.nextDouble();
					if(w > 0)
						break;
					else
						System.out.println("input Error.");
				} while(true);
				double h; // height
				do {
					System.out.print("intput height: ");
					h = sc.nextDouble();
					if(h > 0)
						break;
					else
						System.out.println("input Error.");
				} while(true);
				arrCS[arrCount] = new CRect(w, h);
				arrCount += 1;
				break;
			case 2:
				// add circle
				System.out.println(" -add circle");
				double r; // radius
				do {
					System.out.print("intput radius: ");
					r = sc.nextDouble();
					if(r > 0)
						break;
					else
						System.out.println("input Error.");
				} while(true);
				arrCS[arrCount] = new CCircle(r);
				arrCount += 1;
				break;
			case 3:
				// add trapezoid
				System.out.println(" -add trapezoid");
				double up; // upper
				do {
					System.out.print("intput width: ");
					up = sc.nextDouble();
					if(up > 0)
						break;
					else
						System.out.println("input Error.");
				} while(true);
				double lo; // lower
				do {
					System.out.print("intput height: ");
					lo = sc.nextDouble();
					if(lo > 0)
						break;
					else
						System.out.println("input Error.");
				} while(true);
				double he; // height
				do {
					System.out.print("intput height: ");
					he = sc.nextDouble();
					if(he > 0)
						break;
					else
						System.out.println("input Error.");
				} while(true);
				arrCS[arrCount] = new CTrapezoid(up, lo, he);
				arrCount += 1;
				break;
			default:
				System.out.println("Input Error.");
			}
		} while(true);

	}
	static void output() {
		//output all element data in CShape array
		System.out.println("output");
		for(int i = 0; i < arrCount; i++) {
			System.out.println("----- " + arrCS.getClass().getSimpleName() + " [" + i + "] -----");
			System.out.printf("class : %s \n -Area : %.2f\n -Perimeter : %.2f\n", arrCS[i].getClass().getName(), arrCS[i].area, arrCS[i].perimeter);
		}
	}


}
