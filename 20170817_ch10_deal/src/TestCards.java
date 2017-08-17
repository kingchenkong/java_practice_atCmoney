//建立一TestCards之類別，在類別內禁止使用public的屬性；可依需求自行定義private的成員函式與變數；再程式開始前請先產生一副新牌，並使用ShffuleCards達到以下效果： 
//
//Options: 1)remain cards , 2)get card, 3)發四副牌, -1)Quit: 1
//		   1)顯示剩餘張數& 牌堆資料	 2)抽一張牌		發成四堆牌 一堆13張

//請自訂輸入輸出格式，當執行功能後請顯示執行結果，以檢查功能是否實作正確。當使用者執行選項3)時請確認牌數是否足夠，否則請產生新牌。
import java.lang.*;
import java.util.*;
public class TestCards {
	//static
	public static Scanner scanner = new Scanner(System.in);
	public static ShuffleCards poker = new ShuffleCards();

	public static void main(String[] args) {
		menu();		
	}
	// function
	public static void menu() {
		do {
			System.out.println("Options: 1)Remain cards , 2)Get 1 card, 3)deal 4 Set, -1)Quit: ");
			int option = scanner.nextInt();
			switch(option) {
			case -1:
				System.out.println("Good Bye!");
				return;
			case 1:
				System.out.println(poker);
				break;
			case 2:
				System.out.println(poker.printCardData( poker.getCard() ) );
				break;
			case 3:
				deal4Set();
				break;
			default:
				System.out.println("Input Error.");
			}
		} while(true);
	}
	public static void deal4Set() {
		if(poker.remainCards() < 52) {
			poker.newCards();
		}
		int[][] arr = new int[4][13];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				arr[i][j] = poker.getCard();
			}
		}		
		// print set
		for(int i = 0; i < 4; i++) {
			System.out.println("-- set" + i +" --");
			for(int j = 0; j < 13; j++) {
				System.out.print( poker.printCardData( arr[i][j] ) );
				if(j != 0&& j % 4 == 0) {
					System.out.println("");
				}
			}
			System.out.println("");
		}
		return;
	}
	// last }
}
