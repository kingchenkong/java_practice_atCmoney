import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapMatrixSet {

	private String sourceFilePath; 
	private MapMatrix[] mapMatrixSet;
	private int mapCount;
	
	public MapMatrixSet() {
		this.sourceFilePath = "src//MapMatrix.txt";
		try {
			FileReader fr = new FileReader(this.sourceFilePath);
			BufferedReader bfr = new BufferedReader(fr);
			String firstLine = bfr.readLine();
			String[] firstLineSplit = firstLine.split(":");
			this.mapCount = Integer.parseInt(firstLineSplit[1]);
//			this.mapMatrix = new int[this.mapCount][][];
			this.mapMatrixSet = new MapMatrix[this.mapCount];

			// for
			for(int i = 0; i < this.mapCount; i++) {
				// MapNo
				String lineMapNo = bfr.readLine();
				String[] lineMapNoSplit = lineMapNo.split(":");
				int mapNo = Integer.parseInt(lineMapNoSplit[1]);
				// - Map row & column
				String lineMapRC = bfr.readLine();
				String[] lineMapRCSplit = lineMapRC.split(":");
				String[] MapRC = lineMapRCSplit[1].split(" ");
				int rowCount = Integer.parseInt(MapRC[0]);
				int columnCount = Integer.parseInt(MapRC[1]);
//				this.mapMatrix[mapNo] = new int[rowCount][columnCount];
				this.mapMatrixSet[mapNo] = new MapMatrix(i, rowCount, columnCount);
				// - read 'row' line
				//			String readRow;			
				for(int r = 0; r < rowCount; r++) {
					String readRow = bfr.readLine();
					String[] readRowSplit = readRow.split(" ");
					for(int c = 0; c < columnCount; c++) {
//						this.mapMatrix[mapNo][r][c] = Integer.parseInt(readRowSplit[c]);
						this.mapMatrixSet[i].setMapMatrix(r, c, Integer.parseInt(readRowSplit[c]));
					}
				}
				// blank line
				bfr.readLine();
			}
			// close
			bfr.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// getter
		public int getMapMatrixItem(int mapNo, int row, int column) {
//			return this.mapMatrix[mapNo][row][column];
			return this.mapMatrixSet[mapNo].getMapMatrixItem(row, column);
		}
		public MapMatrix getOneMapMatrix(int mapNo) {
//			return this.mapMatrix[mapNo];
			return this.mapMatrixSet[mapNo];
		}
		public int getRowCountByMapNo(int mapNo) {
//			return this.mapMatrix[mapNo].length;
			return this.mapMatrixSet[mapNo].getRowCount();
		}
		public int getColumnCountByMapNo(int mapNo) {
//			return this.mapMatrix[mapNo][0].length;
			return this.mapMatrixSet[mapNo].getColumnCount();
		}

		public void printMapMatrix() {
			System.out.println(" --- Map Matix Set --- ");
			System.out.println(" - MapCount:" + this.mapCount);
			for(int i = 0; i < this.mapMatrixSet.length; i++) {
				System.out.println(" - MapNo:" + i);
				System.out.println(" - Map row & column:" + this.mapMatrixSet[i].getRowCount() + " " + this.mapMatrixSet[i].getColumnCount());
				for(int j = 0; j < this.mapMatrixSet[i].getRowCount(); j++) {
					for(int k = 0; k < this.mapMatrixSet[i].getColumnCount(); k++) {
						System.out.printf("%d ", this.mapMatrixSet[i].getMapMatrixItem(j, k));
					}
					System.out.println("");
				}
			}
		}

}
