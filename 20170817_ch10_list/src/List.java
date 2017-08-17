//宣告int型態之陣列以及相關屬性，使其得以實現下列方法
public class List {
	protected int[] list;
	protected int count;

	public List(){
		//初始化陣列及其餘屬性
		this.list = new int[10];
		this.count = 0;
	}
	boolean add(int x){
		//新增一個數值於 列表尾端(資料的尾端)，並回傳新增成功/失敗
		int originalCount = this.count;
		if(this.count == this.list.length) 
			if(!this.resize()) 
				return false;

		this.list[this.count] = x;
		this.count += 1;
		return (originalCount != this.count);
	}
	boolean remove(int x){
		//刪除數列中所有的x數值，並回傳刪除成功/失敗，並將數列向前推移(所有空格移至最後)
		int originalCount = this.count;
		for(int i = 0; i < this.count; i++) {
			if(this.list[i] == x) {
				for(int j = i; j < this.count - 1; j++) 
					this.list[j] = this.list[j+1];
				this.list[this.count-1] = 0;
				this.count -= 1;
			}
			if(this.list[i] == x) 
				i -= 1;
		}
		return (originalCount != this.count);
	}
	public boolean resize() {
		int[] arrCopy = new int[this.list.length * 2];
		for(int i = 0; i < this.count; i++)
			arrCopy[i] = this.list[i];
		this.list = null;
		this.list = arrCopy;

		if(this.list == null) {
			return false;
		} else {
			System.out.println("-- resize --");
			return true;
		}
	}
	public void printListData(boolean dataCountOrArrayLength) {
		int length = 0;
		if(dataCountOrArrayLength) {
			length = this.count;
		} else {
			length = this.list.length;
		}
		
		System.out.println("list = { ");
		for(int i = 0; i < length; i++) 
			System.out.print( this.list[i] + ", ");
		System.out.println("}");
		System.out.println("this.count = " + this.count);
	
	}
}
