import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class testMatrix {
	// squareStatus 
	// 地板, 0
	// 石頭, 1
	// 箱子, 2
	// 草叢, 3
	// 人物, 4
	// 怪物, 5
	private int[][][] mapMatrix;
	private int[][] squareStatus; 
	private int mapCount;
	private int nowMapNo;

	public testMatrix() {
		try {
			FileReader fr = new FileReader("src//MapMatrix.txt");
			BufferedReader bfr = new BufferedReader(fr);
			String firstLine = bfr.readLine();
			String[] firstLineSplit = firstLine.split(":");
			this.mapCount = Integer.parseInt(firstLineSplit[1]);
			this.mapMatrix = new int[this.mapCount][][];

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
				this.mapMatrix[mapNo] = new int[rowCount][columnCount];
				// - read 'row' line
				//			String readRow;			
				for(int r = 0; r < rowCount; r++) {
					String readRow = bfr.readLine();
					String[] readRowSplit = readRow.split(" ");
					for(int c = 0; c < columnCount; c++) {
						this.mapMatrix[mapNo][r][c] = Integer.parseInt(readRowSplit[c]);
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
	public int getMatrixItem(int mapNo, int row, int column) {
		return this.mapMatrix[mapNo][row][column];
	}
	public int[][] getOneMapMatrix(int mapNo) {
		return this.mapMatrix[mapNo];
	}
	public int getRowCountByMapNo(int mapNo) {
		return this.mapMatrix[mapNo].length;
	}
	public int getColumnCountByMapNo(int mapNo) {
		return this.mapMatrix[mapNo][0].length;
	}

	public void printMapMatrix() {
		System.out.println(" --- MapMatix --- ");
		System.out.println(" - MapCount:" + this.mapCount);
		for(int i = 0; i < this.mapMatrix.length; i++) {
			System.out.println(" - MapNo:" + i);
			System.out.println(" - Map row & column:" + this.mapMatrix[i].length + " " + this.mapMatrix[i][0].length);
			for(int j = 0; j < this.mapMatrix[i].length; j++) {
				for(int k = 0; k < this.mapMatrix[i][j].length; k++) {
					System.out.printf("%d ", this.mapMatrix[i][j][k]);
				}
				System.out.println("");
			}
		}
	}

}
