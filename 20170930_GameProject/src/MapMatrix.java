
public class MapMatrix {
	private int[][] matrix;
	private int rowCount;
	private int columnCount;
	private int mapNo;
	public MapMatrix(int mn, int rc, int cc) {
		this.mapNo = mn;
		this.rowCount = rc;
		this.columnCount = cc;
		this.matrix = new int[rc][cc];
	}
	// setter
	public void setMapMatrix(int r, int c, int item) {
		this.matrix[r][c] = item;
	}
	// getter
	public int[][] getMapMatrix() {
		return this.matrix;
	}
	public int getMapMatrixItem(int r, int c) {
		return this.matrix[r][c];
	}
	public int getRowCount() {
		return this.rowCount;
	}
	public int getColumnCount() {
		return this.columnCount;
	}
	public int getMapNo() {
		return this.mapNo;
	}

}
