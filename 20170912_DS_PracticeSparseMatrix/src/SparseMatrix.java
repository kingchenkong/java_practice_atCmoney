
public class SparseMatrix {
	// Attributes
	private Term[] terms;
	// Constructor
	public SparseMatrix(int r, int c) {
		terms = new Term[2];
		terms[0] = new Term(r, c, 0);
	}
	// Method
	public void Transpose() {
		
	}
	public void FastTranspose() {
		
	}
	public static SparseMatrix Add(SparseMatrix matrix1, SparseMatrix matrix2) {
		return new SparseMatrix(0, 0);
	}
	public static SparseMatrix Mult(SparseMatrix matrix1, SparseMatrix matrix2) {
		return new SparseMatrix(0, 0);
	}
	// Resize
	// Output
	// Getter
	// Setter	
}
