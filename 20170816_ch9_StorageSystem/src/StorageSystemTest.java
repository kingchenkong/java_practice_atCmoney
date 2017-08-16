//倉儲管理系統
//
//請幫8-12連鎖超商建立一套「倉儲管理系統」（StorageSystem），以便提供用戶隨時登錄各連鎖店進出貨量。該系統功能有：
//顯示所有資料
//增加商品資料
//出貨登錄
//進貨登錄
//當點選「出貨登錄」與「進貨登錄」時，系統會先顯示目前已經建立的商品，再要求使用者輸入商品與出/進數量即可。
//
//假設描述商品（Product）的屬性為：商品編號（Product No.，字串）、商品名稱（Product Name，字串）、單價（Price，整數）、單位（Unit，字串）、庫存量（Stock，整數）與製造商（Maker，字串）
//
//如有必要，敬請提供必要的數值檢查。
import java.lang.*;
import java.util.*;
public class StorageSystemTest {

	// static
	public static Scanner scanner = new Scanner(System.in);
	public static StorageSystem stsys = new StorageSystem();
	public static void main(String[] args) {

		// test
		Product pdt ;	// (String no, String name, String unit, String maker, int price, int stock)

		stsys.addProduct(new Product("A8421", "麵粉", 2, "味全食品", 44));
		stsys.addProduct(new Product("A0010", "白粉", 8, "El Chapo", 7613));
		stsys.addProduct(new Product("A8402", "米粉", 7, "味全食品", 60));
		stsys.addProduct(new Product("A8003", "粉圓", 6, "台糖", 1549));
		stsys.addProduct(new Product("A7000", "腦粉", 4, "PTT", 0));
		
		// Menu
		menu();

	}
	// function 
	public static void menu() {
		do {
			System.out.println(" 1) 倉儲總覽 2)增加品項 3)進貨登錄 4)出貨登錄 -1)結束 :");
			int option = 0;
			option = scanner.nextInt();			
			switch(option) {
			case -1: // Quit
				return;
			case 1: // print all
				outputStorageData();
				break;
			case 2: // increase item
				increaseItem();
				break;				
			case 3: // increase stock
				purchase();
				break;
			case 4: // decrease stock
				shipments();
				break;
			default:
				System.out.println("No this option.");
			}
		} while(true);
	}
	public static void outputStorageData() {
		stsys.printStorage();
	}
	public static void increaseItem() {
		//增加品項
		System.out.print("\n-- 增加品項 --");
		System.out.print("\n輸入 商品序號 : ");
		String serialNo = scanner.next();
		System.out.print("\n輸入 品名 : ");
		String itemName = scanner.next();
		System.out.println("");
		int unitOption = 0;
		do {
			System.out.println("1) 公克 2) 公斤  3) 箱   4) 打  5) 羅  6) 桶  7) 批  8) 包 9) 拖盤 10) 件");
			System.out.println("11) 令  12) 卷  13) 套  14) 張 15) 股 16) 台 17) 瓶(藥)");
			System.out.print("\n輸入 單位 : ");
			unitOption = scanner.nextInt();
			if(unitOption < 1 || unitOption > 17) {
				System.out.println("Input Error.");
			} else {
				break;
			}
		} while(true);
		System.out.print("\n輸入 製造商 : ");
		String strMaker = scanner.next();
		int itemPrice = 0;
		do {
			System.out.print("\n輸入 價格: ");
			itemPrice = scanner.nextInt();
			if(itemPrice < 1) {
				System.out.println("Input Error.");
			} else {
				break;
			}
		} while(true);
		System.out.println("");
		stsys.addProduct(new Product(serialNo, itemName, unitOption, strMaker, itemPrice));
		return;
	}
	public static void purchase() {
		// 進貨
		System.out.println("-- 進貨登錄 --");
		do {
			System.out.println("1) 倉儲總覽 2)直接輸入索引 -1)結束 :"); 
			int option = scanner.nextInt();
			switch(option) {
			case -1:
				return;
			case 1:
				stsys.printStorage();
				break;
			case 2:
				System.out.println("輸入 索引 : ");
				int itemIndex = scanner.nextInt();
				if( stsys.searchProduct(itemIndex) == 1) {
					System.out.println("\n輸入 進貨數量: ");
					int amount = scanner.nextInt();
					stsys.purchase(stsys.getProduct(itemIndex), amount);
					return;
				} else if(stsys.searchProduct(itemIndex) == -1){
					System.out.printf("目前 商品登錄'索引' 為 0 ~ %d \n請重新輸入 \n", stsys.getCount() - 1);
					break;
				} 
				// 沒有 else{}
				// 沒有 break; 因為 輸入錯誤會往下執行 default:
			default:
				System.out.println("input Error.");
			}
		} while(true);
	}
	public static void shipments() {
		// 出貨
		System.out.println("-- 出貨登錄 --");
		do {
			System.out.println("1) 倉儲總覽 2)直接輸入索引 -1)結束 :"); 
			int option = scanner.nextInt();
			switch(option) {
			case -1:
				return;
			case 1:
				stsys.printStorage();
				break;
			case 2:
				System.out.println("輸入 索引 : ");
				int itemIndex = scanner.nextInt();

				if( stsys.searchProduct(itemIndex) == 1) {
					if(stsys.getProduct(itemIndex).getStock() == 0) {
						// 庫存 = 0
						System.out.println("無庫存 無法出貨");
						break;
					} else {
						System.out.println("\n輸入 出貨數量: ");
						int amount = scanner.nextInt();
						//					stsys.purchase(stsys.getProduct(itemIndex), amount);
						stsys.shipments(stsys.getProduct(itemIndex), amount);
						return;
					}
				} else if(stsys.searchProduct(itemIndex) == -1){
					System.out.printf("目前 商品登錄'索引' 為 0 ~ %d \n請重新輸入 \n", stsys.getCount() - 1);
					break;
				} 
				// 沒有 else{}
				// 沒有 break; 因為 輸入錯誤會往下執行 default:
			default:
				System.out.println("input Error.");
			}
		} while(true);
	}

	public static void searchProductData() {
		// 查詢 某項商品資料
		int index = scanner.nextInt();
		if(stsys.searchProduct(index) == -2) {
			System.out.println("input Error.");
		} else if( stsys.searchProduct(index) == -1) {
			System.out.printf("目前 商品登錄'索引' 為 0 ~ %d \n請重新輸入 \n", stsys.getCount() - 1);
		} else {
			System.out.printf(" %3d", index);
			stsys.getProduct(index).print();
		}
	}

}
