
public class IntegerSet {
	// attributes
	private int[] element;	 //儲存數字的陣列；最小長度為10
	private int count;		//目前陣列內的數字個數

	// methods
	public IntegerSet() {	//建構子
		this(10);
	}			
	public IntegerSet(int size) {	//建構子；引數代表集合可儲存最大容量
		this.element = new int[size];
		this.count = 0;
	}		
	public void Insert(int value) {	//新增新的元素value（重複的元素不加入）
		if(this.count == this.element.length) {
			this.resize(this.element.length * 2);
		}
		this.element[this.count++] = value;
		return;
	}	
	public int getElement(int i) {	//抓取編號為i的整數，如果索引超出範圍，請回傳-1
		if(i < this.element.length) {
			return this.element[i];
		} else {
			return -1;
		}

	}	
	public void output() {	//印出集合中所有元素的內容
//		System.out.print("IntegerSet.element = { ");
		if(this.count == 0) {
			System.out.println("is Empty.");
			return;
		}
		System.out.print("{ ");
		for(int i = 0; i < this.count; i++) {
			if(i < this.count - 1) {
				System.out.print(this.element[i] + ", ");
			} else {
				System.out.println(this.element[i] + "}");
			}
		}
	}			
	public int search(int value) {	//搜尋value是否在集合中。有則回傳其index，否則回傳-1
		for(int i = 0; i < this.count; i++) {
			if(this.element[i] == value) {
				return i;
			}
		}
		return -1;
	}  
	public void delete(int value) {	//移除元素value
		if(value < 0 || value > 100) {
			System.out.println("'" + value +"' is out range.");
			return;
		}

		int index = this.search(value);
		if(index == -1) {
			System.out.println("'" + value + "' is not Exist.");
			return;
		} else {
			for(int i = index; i < this.count - 1; i++) {
				this.element[i] = this.element[i+1];
			}
			this.count--;
			this.element[this.count] = 0;
			return;
		}
	}  
	public IntegerSet intersection(IntegerSet setB) {	//求出與A的交集並予以回傳
		//this => setA
		IntegerSet setC = new IntegerSet(this.count);
		
		for(int i = 0; i < this.count; i++) {
			for(int j = 0; j < setB.count; j++) {
				if(this.getElement(i) == setB.getElement(j)) {
					setC.Insert(this.element[i]);
				}
			}
		}
		
		return setC;
	}	
	public IntegerSet union(IntegerSet setB) {	//求出與A的聯集並予以回傳
		IntegerSet setC = new IntegerSet(this.count + setB.count);
		for(int i = 0; i < this.count; i++) {
			setC.Insert(this.getElement(i));
		}
		for(int j = 0; j < setB.count; j++) {
			int value = setB.getElement(j);
			if(setC.search(value) == -1) {
				setC.Insert(value);
			}
		}
		
		return setC;
	}		
	private void resize(int newSize) {	//數字數量大於陣列長度時變更陣列大小
		int[] arr = new int[newSize];
		for(int i = 0; i < this.count; i++) {
			arr[i] = this.getElement(i);
		}
		this.element = arr;
	}  


}
