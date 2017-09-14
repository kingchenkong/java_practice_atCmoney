
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
	public void resize() {
		Term[] copy = new Term[this.terms[0].getTerm()[2] * 2];
		for(int i = 0; i < this.terms[0].getTerm()[2]; i++) {
			copy[i] = this.terms[i];
		}
		this.terms = copy;
	}
	// Output
	public static void printTerms(Term[]  arrT) {
		System.out.println("   - row\t col\t value");
		System.out.println("-------------------------");
		for(int i = 0; i <= arrT[0].getTerm()[2]; i++) {
			int[] t = arrT[i].getTerm();
			System.out.printf("%2d - %3d\t %3d\t %3d\n", i, t[0], t[1], t[2]);
			if(i == 0) {
				System.out.println("-------------------------");
			}
		}
	}
	// Getter
	public Term[] getTerms() {
		return this.terms;
	}
	// Setter

}
