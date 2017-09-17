
public class Term {
	// Attributes
	private int row;
	private 	int col;
	private 	int value;

	// Constructor
	public Term() {
		this.setTerm(0, 0, 0);
	}
	public Term(int r, int c, int v) {
		this.setTerm(r, c, v);
	}
	// Setter
	public void setTerm(int r, int c, int v) {
//		if(v > r*c) {
//			System.out.println("Error: value > Row * Colume.");
//			this.setTerm(0, 0, 0);
//		} else {
		this.row = r;
		this.col = c;
		this.value = v;
//		}
	}
	public void setValue(int v) {
		this.value = v;
	}
	public void valueadd1() {
//		if(this.value < this.row * this.col) {
			this.value++;
//		}
	}
	// Getter
	public int[] getTerm() {
		int[] arr = {this.row, this.col, this.value};
		return arr;
	}
	// Output
	public static String outputTerms(Term t) {
		return String.format("row = %2d, column = %2d, value = %2d", t.row, t.col, t.value);
	}

}
