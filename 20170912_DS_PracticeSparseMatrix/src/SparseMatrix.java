
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
		int dataCount = this.terms[0].getTerm()[2];
		// transpose
		for(int i = 0; i <= dataCount; i++) {
			int[] t = this.terms[i].getTerm();
			this.terms[i].setTerm(t[1], t[0], t[2]);
		}
		// insertion sort
		for(int i = 2; i <= dataCount; i++) {
			for(int j = 1; j < i; j++) {
				if(this.terms[i].getTerm()[0] < this.terms[j].getTerm()[0]) {
					Term t = this.terms[i];
					for(int k = i; k > j; k--) {
						this.terms[k] = this.terms[k-1];
					}
					this.terms[j] = t;
				}
			}
		}
	}
	public void FastTranspose() {
		Term[] b = new Term[this.terms[0].getTerm()[2] + 1];			
		int[] rowTerms = new int[this.terms[0].getTerm()[1]]; // 轉置後 每行有幾列 ?
		int[] startingPos = new int[this.terms[0].getTerm()[1]];
		int numRows = this.terms[0].getTerm()[0];
		int numCols = this.terms[0].getTerm()[1];
		int numTerms = this.terms[0].getTerm()[2];
		b[0] = new Term(numCols, numRows, numTerms);
		if(numTerms <= 0) // 空矩陣
			return;
		for(int i = 0; i < numCols; i++) // 0 ~ <6
			rowTerms[i] = 0;
		for(int i = 1; i <= numTerms; i++) // 1 ~ =8
			rowTerms[this.terms[i].getTerm()[1]]++;
		startingPos[0] = 1;
		for(int i = 1; i < numCols; i++) // 1 ~ <6
			startingPos[i] = startingPos[i-1] + rowTerms[i-1];
		for(int i = 1; i <= numTerms; i++) { // 1 ~ =8
			int j = startingPos[this.terms[i].getTerm()[1]]++;
			b[j] = new Term(this.terms[i].getTerm()[1], this.terms[i].getTerm()[0], this.terms[i].getTerm()[2]);
		}
		this.terms = b;
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
	public void setTerms(Term[] ts) {
		this.terms = ts;
	}
	// Static
	public static SparseMatrix Mul(SparseMatrix Multiplicand, SparseMatrix Multiplier) {
		// check can Multiply
		Term[] tsMpd = Multiplicand.getTerms();
		Term[] tsMpr = Multiplier.getTerms();
		int rowMpd = tsMpd[0].getTerm()[0];
		int colMpd = tsMpd[0].getTerm()[1];
		int valMpd = tsMpd[0].getTerm()[2]; // Multiplicand data count
		int rowMpr= tsMpr[0].getTerm()[0];
		int colMpr = tsMpr[0].getTerm()[1];
		int valMpr = tsMpr[0].getTerm()[2]; // Multiplier data count
		// can't multiply
		if(colMpd != rowMpr ) {
			return null;
		}
		// multiply
		int i = 1, column, totalB = valMpr, totalD = 0;
		int rowsA = rowMpd, colsA = colMpd, totalA = valMpd, colsB = colMpr;  //totalA是第一個矩陣非零項的個數
		int rowBegin = 1, row = tsMpd[1].getTerm()[0], sum = 0;
		Term[] newB;
		SparseMatrix smToFT = SparseMatrix.copySM(Multiplier);
		smToFT.FastTranspose();
		newB = smToFT.getTerms();
		Term[] d = new Term[rowMpd * colMpr + 1];
		// 設定邊界狀況
		// resize
		tsMpd[totalA + 1] = new Term(rowsA, 0, 0);
		if(totalB + 1 == newB.length) {
			Term[] copy = new Term[newB.length * 2];
			for(int c = 0; c < newB.length; c++)
				copy[c] = newB[c];	
			newB = copy;
		}	
		newB[totalB + 1] = new Term(colsB, 0, 0);
		while (i <= valMpd)
		{
			column = newB[1].getTerm()[0]; // newB.row
			int j = 1;
			while (j <= totalB + 1)
			{
				// a的row *= b的column
				if (tsMpd[i].getTerm()[0] != row)
				{
					//                     storeSum(d, ref totalD, row, column, ref sum);
					if(sum != 0)
						d[++totalD] = new Term(row, column, sum);
					sum = 0;
					i = rowBegin;
					while (newB[j].getTerm()[0] == column)
						j++;
					column = newB[j].getTerm()[0];
				}
				else if (newB[j].getTerm()[0] != column)
				{
					//                              storeSum(d, ref totalD, row, column, ref sum);
					if(sum != 0)
						d[++totalD] = new Term(row, column, sum);
					sum = 0;
					i = rowBegin;
					column = newB[j].getTerm()[0];
				}
				else
				{
					if (tsMpd[i].getTerm()[1] - newB[j].getTerm()[1] < 0)
					{  // go to next term in a
						i++;
					}
					else if (tsMpd[i].getTerm()[1] - newB[j].getTerm()[1] == 0) //add terms, go to next term in a and b
					{
						sum += (tsMpd[i++].getTerm()[2] * newB[j++].getTerm()[2]);
					}
					else  // advance to next term in b
						j++;
				}
			}
			while (tsMpd[i].getTerm()[0] == row)
				i++;
			rowBegin = i;
			row = tsMpd[i].getTerm()[0];
		} //end of for i <= totalA 
		d[0] = new Term(rowsA, colsB, totalD);
		SparseMatrix sm = new SparseMatrix(rowMpr, colMpd);
		sm.setTerms(d);
		return sm;
	}
	public static SparseMatrix Add(SparseMatrix Summand, SparseMatrix Addend) {
		// check can add
		Term[] tsSum = Summand.getTerms();
		Term[] tsAdd = Addend.getTerms();
		Term[] newTs;
		int rowSum = tsSum[0].getTerm()[0];
		int colSum = tsSum[0].getTerm()[1];
		int valSum = tsSum[0].getTerm()[2]; // summand data count
		int rowAdd = tsAdd[0].getTerm()[0];
		int colAdd = tsAdd[0].getTerm()[1];
		int valAdd = tsAdd[0].getTerm()[2]; // addend data count
		// can't add
		if(rowSum != rowAdd || colSum != colAdd) {
			System.out.println("Error: two matrix Row&Column mismatch.");
			return null;
		}
		// add
		// copy summand
		newTs = new Term[valSum + 1];
		for(int i = 0; i < valSum + 1; i++) {
			newTs[i] = new Term(tsSum[i].getTerm()[0], tsSum[i].getTerm()[1], tsSum[i].getTerm()[2]); 
		}
		int valNewTs = newTs[0].getTerm()[2];
		for(int i = 1; i <= valSum; i++) { // 1 ~ valSum
			//			int notSameCount = 0;
			for(int j = 1; j <= valAdd; j++) { // 1 ~ valAdd
				// is same position
				if(SparseMatrix.isSamePosition(tsSum[i], tsAdd[j])) {
					newTs[i].setValue(tsSum[i].getTerm()[2] + tsAdd[j].getTerm()[2]); 
					break;
				}
			}
		}
		for(int i = 1; i <= valAdd; i++) { // 1 ~ valAdd
			int notSameCount = 0;
			for(int j = 1; j <= valSum; j++) { // 1 ~ valSum
				if(!SparseMatrix.isSamePosition(tsSum[j], tsAdd[i])) 
					if(tsAdd[i].getTerm()[2] != 0) 
						notSameCount++;
			}
			if(notSameCount == valSum) {
				newTs[0].setValue(++valNewTs);
				// resize newTs
				if(valNewTs == newTs.length) {
					Term[] copy = new Term[newTs.length * 2];
					for(int c = 0; c < valNewTs; c++) 
						copy[c] = new Term(newTs[c].getTerm()[0], newTs[c].getTerm()[1], newTs[c].getTerm()[2]);
					newTs = copy;
				}
				newTs[valNewTs] = new Term(tsAdd[i].getTerm()[0], tsAdd[i].getTerm()[1], tsAdd[i].getTerm()[2]);
			}
		}
		// insertion sort
		for(int i = 1; i <= valNewTs; i++) {
			for(int j = 1; j < i; j++) {
				if(newTs[i].getTerm()[0] < newTs[j].getTerm()[0]) {
					Term t = newTs[i];
					for(int k = i; k > j; k--) {
						newTs[k] = newTs[k-1];
					}
					newTs[j] = t;
				} else if(newTs[i].getTerm()[0] == newTs[j].getTerm()[0] && newTs[i].getTerm()[1] < newTs[j].getTerm()[1]) {
					Term t = newTs[i];
					for(int k = i; k > j; k--) {
						newTs[k] = newTs[k-1];
					}
					newTs[j] = t;
				}
			}
		}
		SparseMatrix sm = new SparseMatrix(rowSum, colSum);
		sm.setTerms(newTs);
		return sm;
	}
	// same position
	public static boolean isSamePosition(Term t1, Term t2) {

		if(t1.getTerm()[0] == t2.getTerm()[0] && t1.getTerm()[1] == t2.getTerm()[1])
			return true;
		return false;
	}
	// copy SparseMatrix
	public static SparseMatrix copySM(SparseMatrix osm) {
		Term[] ts = osm.getTerms();
		SparseMatrix sm = new SparseMatrix(ts[0].getTerm()[0], ts[0].getTerm()[1]);
		int tsCount = ts[0].getTerm()[2];
		Term[] newTs = new Term[tsCount + 1];
		for(int i = 0; i < tsCount + 1; i++) {
			newTs[i] = new Term(ts[i].getTerm()[0], ts[i].getTerm()[1], ts[i].getTerm()[2]); 
		}
		sm.setTerms(newTs);
		return sm;
	}
}
