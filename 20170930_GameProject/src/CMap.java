import java.awt.Graphics;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.FileInputStream;

import javax.swing.ImageIcon;

public class CMap {	
	// 素材大小
	private int eleWidth;  
	private int eleHeight;  
	// 地圖大小
	private int mapWidth;  
	private int mapHeight;  
	private int[][] map0; //地板(人物腳下)
	private int[][] map1; //地上物(障礙物)
	private ImageIcon[][] icons0; //地板(人物腳下)  
	private ImageIcon[][] icons1; //地上物(障礙物)
	// 素材陣列
	private ImageIcon[] allIcons;
	private int[][] mapMatrix;
	// 人物出生點 == 5
	private int[] bornRC;
	// 過關區域 == 3
	private int[][] goalRC;
	// 箱子出現點 == 2
	private int[][] boxRC;
	// 牆壁 == 1
	// 地板 == 0

	public CMap() {
		this.eleWidth = 50;  
		this.eleHeight = 50;  
		
		// 地圖大小
		this.mapWidth = 500;
		this.mapHeight = 500; 
		this.map0 = new int[mapWidth / eleWidth][mapHeight / eleHeight]; //地板(人物腳下)
		this.map1 = new int[mapWidth / eleWidth][mapHeight / eleHeight]; //地上物(障礙物)
		this.icons0 = new ImageIcon[mapWidth / eleWidth][mapHeight / eleHeight]; //地板(人物腳下)  
		this.icons1 = new ImageIcon[mapWidth / eleWidth][mapHeight / eleHeight]; //地上物(障礙物)
		// 素材陣列
		this.allIcons = new ImageIcon[2];
		this.allIcons[0] = new ImageIcon("bin//resources//00地板.png");
		this.allIcons[1] = new ImageIcon("bin//resources//01磚牆.png"); 
		// 
		this.bornRC = new int[2];
		this.goalRC = new int[3][2];
		this.boxRC = new int[3][2];
		
		this.loadMap();
	}
	public void paint(Graphics g) {
		for(int i = 0; i < this.getMapWH()[1] / this.getEleWH()[1]; i++){  
			for(int j = 0; j < this.getMapWH()[0] / this.getEleWH()[0]; j++){
				//第0層, floor
				if(this.getIcon2dimen()[0][i][j] != null){  
					g.drawImage(this.getIcon2dimen()[0][i][j].getImage(), this.drawX(j), this.drawY(i), this.getEleWH()[0], this.getEleWH()[1], null);  
				}  
				//第1層, blocks
				if(this.getIcon2dimen()[1][i][j] != null){  
					g.drawImage(this.getIcon2dimen()[1][i][j].getImage(), this.drawX(j), this.drawY(i), this.getEleWH()[0], this.getEleWH()[1], null);  
				}  
			}
		}
	}
	public int drawX(int j){
		return j * eleWidth;
	}  
	public int drawY(int i){   
		return i * eleHeight;
	} 
	public ImageIcon getIcon(int index) {
		return this.allIcons[index];
	}
	public int[] getEleWH() {
		int[] eleWH = {this.eleWidth, this.eleHeight};
		return eleWH;
	}
	public int[] getMapWH() {
		int[] mapWH = {this.mapWidth, this.mapHeight};
		return mapWH;
	}
	public ImageIcon[][][] getIcon2dimen() {
		ImageIcon[][][] arr = {this.icons0, this.icons1}; 
		return arr;
	}
	public int[][] getMapMatrix(){
		return this.mapMatrix;
	}
	public int[] getBornRC() {
		return this.bornRC;
	}
	public int[][] getGoalRC() {
		return this.goalRC;
	}
	public int[][] getBoxRC() {
		return this.boxRC;
	}
	public void loadMap() {
		try{ 
//			System.out.println("開始載入");   
			String str = "bin//Map//map.map";
			FileInputStream fis = new FileInputStream(str);
			DataInputStream dis = new DataInputStream(fis); 
			// x = row, y = column
			int x = dis.readInt();  
			int y = dis.readInt();  
			map0 = new int[x][y];  
			map1 = new int[x][y];  
			int goalCount = 0;
			int boxCount = 0;
			for(int i = 0; i < x; i++) {  
				for(int j = 0; j < y; j++) {  
					map0[i][j] = dis.readInt();
					icons0[i][j] = int2icon(map0[i][j]);
					map1[i][j] = dis.readInt();
					icons1[i][j] = int2icon(map1[i][j]);
					// role born
					if(map1[i][j] == 5) {
						this.bornRC[0] = i; // row
						this.bornRC[1] = j; // column
						map1[i][j] = 0;
					}
					// goal
					if(map1[i][j] == 3 && goalCount < 4) {
						this.goalRC[goalCount][0] = i; // row
						this.goalRC[goalCount][1] = j; // column
						map1[i][j] = 0;
						goalCount++;
					}
					// box
					if(map1[i][j] == 2 && boxCount < 4) {
						this.boxRC[boxCount][0] = i; // row
						this.boxRC[boxCount][1] = j; // column
						boxCount++;
					}
				}  
			}  
			this.mapMatrix = map1;
			dis.close();  
			fis.close();
		} catch(Exception e2){  
			e2.printStackTrace();  
		}  
	}
	
	public  ImageIcon int2icon(int num){  
		if(num == 0) 
			return this.allIcons[0];  
		else if(num == 1)  
			return this.allIcons[1];  
		return null;  
	}
}
