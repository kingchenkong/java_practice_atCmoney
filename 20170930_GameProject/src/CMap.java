import java.io.DataInputStream;
import java.io.FileInputStream;

import javax.swing.ImageIcon;

public class CMap {
	//素材大小
	private int eleWidth = 50;  
	private int eleHeight = 50;  
	//地圖大小
	private int mapWidth = 600;  
	private int mapHeight= 600;  
	private int[][] map0 = new int[mapWidth / eleWidth][mapHeight / eleHeight]; //地板(人物腳下)
	private int[][] map1 = new int[mapWidth / eleWidth][mapHeight / eleHeight]; //地上物(障礙物)
	private ImageIcon[][] icons0 = new ImageIcon[mapWidth / eleWidth][mapHeight / eleHeight]; //地板(人物腳下)  
	private ImageIcon[][] icons1 = new ImageIcon[mapWidth / eleWidth][mapHeight / eleHeight]; //地上物(障礙物)
	//素材圖片
	ImageIcon icon00 = new ImageIcon("bin//resources//00bg.png");
	ImageIcon icon01 = new ImageIcon("bin//resources//01rock.png");
	ImageIcon icon02 = new ImageIcon("bin//resources//02box.png");
	ImageIcon icon03 = new ImageIcon("bin//resources//03box.png");
	ImageIcon icon04 = new ImageIcon("bin//resources//04grass.png");
	ImageIcon icon05 = new ImageIcon("bin//resources//05grass2.png");
//	ImageIcon[] icon;
	//素材陣列
	ImageIcon[] allIcons = {icon00, icon01, icon02, icon03, icon04, icon05};

	public CMap() {
	}

	public int drawX(int j){ 
		return j * eleWidth;
	}  
	public int drawY(int i){     
		return i * eleHeight;
	} 
	// getter
	public ImageIcon getIcon(int index) {
		// 防呆
		if(index < 0 || index > 5)
			index = 0;
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
	public void loadMap() {
		try{ 
			System.out.println("開始載入");   
			String str = "bin//Map//map.map";
			FileInputStream fis = new FileInputStream(str);
			DataInputStream dis = new DataInputStream(fis);  
			int x = dis.readInt();  
			int y = dis.readInt();  
			map0 = new int[x][y];  
			map1 = new int[x][y];  
			for(int i = 0; i < x; i++){  
				for(int j = 0; j < y; j++){  
					map0[i][j] = dis.readInt();
					icons0[i][j] = int2icon(map0[i][j]);
					map1[i][j] = dis.readInt();
					icons1[i][j] = int2icon(map1[i][j]);
				}  
			}  
			dis.close();  
			fis.close();
			System.out.println("載入成功");
		}catch(Exception e2){  
			e2.printStackTrace();  
		}  
	}
	public  ImageIcon int2icon(int num){  
		if(num==0) 
			return icon00;  
		else if(num==1)  
			return icon01;  
		else if(num==2)
			return icon02;      
		else if(num==3) 
			return icon03;  
		else if(num==4)
			return icon04;  
		else if(num==5) 
			return icon05;  
		return null;  

	}

}
