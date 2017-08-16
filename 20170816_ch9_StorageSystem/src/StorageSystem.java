//請幫8-12連鎖超商建立一套「倉儲管理系統」（StorageSystem），以便提供用戶隨時登錄各連鎖店進出貨量。該系統功能有：
//顯示所有資料
//增加商品資料
//出貨登錄
//進貨登錄
//當點選「出貨登錄」與「進貨登錄」時，系統會先顯示目前已經建立的商品，再要求使用者輸入商品與出/進數量即可。
//
public class StorageSystem {
	private Product[] products;
	private int count;

	// 建構子
	public StorageSystem() {
		this.products = new Product[50]; // 品項陣列
		this.count = 0;					// 品項數量
	}
	// resize
	public void resize() {
		Product[] arrProductForCopy = new Product[this.products.length * 2];
		for(int i = 0; i < this.count; i++) 
			arrProductForCopy[i] = this.products[i];
		this.products = null;
		this.products = arrProductForCopy;
		return;
	}
	// setter

	// getter
	public int getCount() {
		return this.count;
	}
	public Product getProduct(int index) {
		return this.products[index];
	}

	// - 顯示所有資料
	// output
	public void printStorage() {
		//		System.out.printf("%3s %4s %5s %4s %8s %4s %6s %4s %5s %4s %2s\n", "索引", " ", "序號", "", "品名", "", "製造商", "", "售價", "", "庫存", "", "單位");
		System.out.printf(" %2s", "索引");
		System.out.printf(" %2s %3s", " ", "序號");
		System.out.printf(" %2s %6s", " ", "庫存");
		System.out.printf(" %2s %2s", " ", "單位");
		System.out.printf(" %2s %5s", " ", "售價");
		System.out.printf(" %2s %6s", " ", "品名");
		System.out.printf(" %4s %s\n", " ", "製造商");

		System.out.println("-----------------------------------------------------------------------------");
		for(int i = 0; i < this.count; i++) {
			System.out.printf(" %3d", i);
			this.products[i].print();
			System.out.println("");
		}
		return;
	}

	// - 增加商品資料
	// 增加品項 
	public boolean addProduct(Product pdt) {
		this.products[this.count++] = pdt;
		return false;
	}
	public int searchProduct(int index) {
		if(index < 0 || index >= this.products.length) {
			return -2; // out length
		} else if(index >= this.count) {
			return -1; // out data count
		} else {
//			System.out.printf(" %3d", index);
//			this.products[index].print();
			return 1; // correct
		}
	}

	// - 進貨登錄
	// 增加某品項的 庫存
	public boolean purchase(Product pdt, int amount) {
		pdt.increaseStock(amount);
		return false;
	}

	// - 出貨登錄
	// 減少某品項的 庫存
	// - (!!) - 庫存為 '0', 不可出貨
	public boolean shipments(Product pdt, int amount) {
		pdt.decreaseStock(amount);
		return false;
	}


}
