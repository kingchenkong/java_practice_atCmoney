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
		this.products = new Product[50];
		this.count = 0;
	}
	// resize
	public void resize() {
		Product[] arrProductForCopy = new Product[this.products.length];
		for(int i = 0; i < this.count; i++) 
			arrProductForCopy[i] = this.products[i];
		this.products = null;
		this.products = arrProductForCopy;
		return;
	}

	// - 顯示所有資料
	// output
	public void printStorage() {


		return;
	}

	// - 增加商品資料
	// 增加品項 
	public boolean addProduct(Product pdt) {


		return false;
	}

	// - 進貨登錄
	// 增加某品項的 庫存
	public boolean Purchase(Product pdt, int amount) {


		return false;
	}

	// - 出貨登錄
	// 減少某品項的 庫存
	// - (!!) - 庫存為 '0', 不可出貨
	public boolean Shipments(Product pdt, int amount) {


		return false;
	}


}
