import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeMap {
	// Attributes
	// - File
	String filePath;
	FileReader fr;
	BufferedReader bfr;

	// - Map
	private int mapCount;
	private int[][] posEntrance;
	private int[][] posExport;
	private int[][][] map;

	public MazeMap(String filePath) {
		// file
		this.filePath = filePath;
		try {
			fr = new FileReader(this.filePath);
			bfr = new BufferedReader(fr);
			String lineMapCount = bfr.readLine();
			String[] spLineMapCount = lineMapCount.split("\\s+");
			this.mapCount = Integer.parseInt(spLineMapCount[2]);
			this.map = new int[this.mapCount][][];	// map initial [this][][]
			this.posEntrance = new int[mapCount][2];
			this.posExport = new int[mapCount][2];
			for(int i = 0; i < this.mapCount; i++) {
				// mapNo
				String lineMapNo = bfr.readLine();
				String[] spLineMapNo = lineMapNo.split("\\s+");
				int mapNo = Integer.parseInt(spLineMapNo[2]);
				// array row column
				String lineRC = bfr.readLine();
				String[] spLineRC = lineRC.split("\\s+");
				int rowCount = Integer.parseInt(spLineRC[2]);	
				int columnCount = Integer.parseInt(spLineRC[3]);
				this.map[mapNo] = new int[rowCount][columnCount];
				// entrance
				String lineEn = bfr.readLine();
				String[] spLineEn = lineEn.split("\\s+");
				this.posEntrance[mapNo][0] = Integer.parseInt(spLineEn[2]);
				this.posEntrance[mapNo][1] = Integer.parseInt(spLineEn[3]);
				// export
				String lineEx = bfr.readLine();
				String[] spLineEx = lineEx.split("\\s+");
				this.posExport[mapNo][0] = Integer.parseInt(spLineEx[2]);
				this.posExport[mapNo][1] = Integer.parseInt(spLineEx[3]);
				// read matrix
				String readStr;
				for(int j = 0; j < rowCount; j++) {
					readStr = bfr.readLine();
					String[] spReadStr = readStr.split("\\s+");
					if(spReadStr.length == columnCount) {
						for(int k = 0; k < columnCount; k++) {
							this.map[mapNo][j][k] = Integer.parseInt(spReadStr[k]);
						}	
					}
				}
				// last blank line
				String blankLine = bfr.readLine();
			}
			// close
			bfr.close();
			fr.close();		
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);	
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	// setter
//	public void setArrayMap(int[][][] arr) {
//		this.map = new int[arr.length][arr[0].length][arr[0][0].length];
//		for(int i = 0; i < arr.length; i++) 
//			for(int j = 0; j < arr[i].length; j++) 
//				for(int k = 0; k < arr[i][j].length; k++)
//					this.map[i][j][k] = arr[i][j][k];
//	}
	// getter
	public int getMapCount() {
		return this.mapCount;
	}
	public int[][] getOneMap(int index){
		if(index < this.mapCount)
			return this.map[index];
		return null;
	}
	public int[] getEntrance(int index) {
		if(index < this.mapCount)
			return this.posEntrance[index];
		return null;
	}
	public int[] getExport(int index) {
		if(index < this.mapCount)
			return this.posExport[index];
		return null;
	}
	// Printer
	public void printMap() {
		for(int i = 0; i < this.map.length; i++) {
			System.out.println("maze " + i);
			for(int j = 0; j < this.map[i].length; j++) {
				for(int k = 0; k < this.map[i][j].length; k++) {
					System.out.print(this.map[i][j][k] + " ");
				}
				System.out.println();
			}
		}
	}
	public static void printNowMap(int[][] nowMap) {
		System.out.println("--- Now Map Matrix ---");
		for(int j = 0; j < nowMap.length; j++) {
			for(int k = 0; k < nowMap[j].length; k++) {
				System.out.print(nowMap[j][k] + " ");
			}
			System.out.println();
		}
	}

}
