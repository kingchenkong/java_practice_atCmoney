
public class SearchList extends List{

	public SearchList(){
		//初始化陣列及其餘屬性
		this.list = new int[10];
		this.count = 0;
	}
	int search(int x){
		//若數列中有此數值回傳位址，否則回傳-1
		for(int i = 0; i < this.count; i++) 
			if(this.list[i] == x) 
				return i;
		return -1;
	}
	int findMax(){
		//回傳數列中的最大值
		int max = this.list[0];
		for(int i = 0; i < this.count; i++) 
			if(this.list[i] > max) 
				max = this.list[i];
		return max;
	}
	boolean replace(int x, int y){
		//將數列中的所有x數值替換為y數值
		int index = this.search(x);
		if(index == -1) 
			return false;
		this.list[index] = y;
		if(index != -1) 
			replace( x, y);
		return true;

	}



}
