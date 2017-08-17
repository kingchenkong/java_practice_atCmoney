
public class AdvancedSearchList extends SearchList{

	public AdvancedSearchList() {
	}
	void sort() {
		//將數列由小排到大
		for(int i = 0; i < this.count - 1; i++) {
			for(int j = 0; j < this.count - 1; j++) {
				if(this.list[j] > this.list[j+1]) {
					int temp = this.list[j+1];
					this.list[j+1] = this.list[j];
					this.list[j] = temp;
				}
			}
		}
	}
	@Override int search(int x) {
		//使用binary search進行搜尋，有此數值回傳位址，否則回傳-1
		this.sort();
		int l = 0;
		int r = this.count -1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(this.list[mid] == x) 
				return mid;
			if(this.list[mid] > x)
				r = mid - 1;
			if(this.list[mid] < x)
				l = mid + 1;
		}
		return -1;
	}
	@Override boolean remove(int index) {
		//移除指定位置的值，並將數列向前推移(所有空格移至最後)
		if(index >= this.count)
			return false;
		int originalCount = this.count;
		this.list[index] = -1;
		for(int j = index; j < this.count - 1; j++) 
			this.list[j] = this.list[j+1];
		this.count -= 1;
		this.list[this.count] = 0;
		return (originalCount != this.count);
	}
	boolean remove(int x, int num) {
		//移除數列中的前num個x值，num傳入-1時則全部移除

		// 不合法輸入
		if(num == 0 || num < -1) 
			return false;
		int xCount = 0;
		int[] arrindex = new int[this.count];
		for(int i = 0; i < this.count; i++) 
			if(this.list[i] == x) 
				xCount += 1;

		if(num > xCount) 
			return false;
		if(num == -1)
			num = xCount;
		for(int i = 0; i < num; i++) 
			this.remove(this.search(x));

		return true;

	}

}
