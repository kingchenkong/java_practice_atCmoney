
public class CStack {
	// Attributes
	//	private final int MAX_STACK_SIZE = 10;
	private int capacity;
	private int[] items;
	private int top;

	public CStack() {
		//		this.items = new int[MAX_STACK_SIZE];
		this.capacity = 10;
		this.items = new int[this.capacity];
		this.top = -1;
	}
	public boolean isEmpty() {
		if (top < 0)
			return true;
		return false;
	}
	public boolean isFull() {
		if (top >= items.length - 1)
			return true;
		return false;
	}
	public int pop() {
		if (this.isEmpty())
			return -1;
		return items[top--];
	}
	public int push(int item) {
		if (!this.isFull()) {
			items[++top] = item;    // 從堆疊頂部加入並改變top值
			return 1;
		} else {
			return -1;
		}
	}
	// getter
	public int getTopPos() {
		return this.top;
	}
	// resize
	public void resizeStack() {
		int[] copy = new int[this.capacity * 2];
		for(int i = 0; i < this.capacity; i++)
			copy[i] = this.items[i];
		this.items = copy;
		this.capacity = this.items.length;
	}
	public static void printStackStatus(CStack stack, boolean isInit) {
		if(isInit) {
			System.out.println("----Condition: Init----");
			System.out.println("'top' = " + stack.getTopPos());
			if(stack.isEmpty())
				System.out.println(" --is Empty.");
			if(stack.isFull())
				System.out.println(" --is Full.");
		} else {
			System.out.println("'top' = " + stack.getTopPos());
			if(stack.isEmpty())
				System.out.println(" --is Empty.");
			if(stack.isFull())
				System.out.println(" --is Full.");
		}
	}
	public static void printStackElement(CStack stack) {
		int[] print = new int[stack.top + 1];
		for(int i = 0; i < print.length; i++) {
			System.out.println(stack.top + ", element: " + (print[i] = stack.pop()));
		}
		for(int i = 0; i < print.length; i++)
			stack.push(print[i]);
	}

}
