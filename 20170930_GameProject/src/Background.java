import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Background extends JPanel{
	//素材大小
	private int eleWidth = 50;  
	private int eleHeight = 50;  
	//地圖大小
	private int MapWidth = 600;  
	private int MapHeight= 600;  
	private int[][] map0 = new int[MapWidth / eleWidth][MapHeight / eleHeight];//地板(人物腳下)
	private int[][] map1 = new int[MapWidth / eleWidth][MapHeight / eleHeight];//地上物(障礙物)
	private ImageIcon[][] icons0 = new ImageIcon[MapWidth / eleWidth][MapHeight / eleHeight];//地板(人物腳下)  
	private ImageIcon[][] icons1 = new ImageIcon[MapWidth / eleWidth][MapHeight / eleHeight];//地上物(障礙物)
	//素材圖片
	ImageIcon icon00 = new ImageIcon("bin//00bg.png");
	ImageIcon icon01 = new ImageIcon("bin//01rock.png");
	ImageIcon icon02 = new ImageIcon("bin//02box.png");
	ImageIcon icon03 = new ImageIcon("bin//03box.png");
	ImageIcon icon04 = new ImageIcon("bin//04grass.png");
	ImageIcon icon05 = new ImageIcon("bin//05grass2.png");
	//素材陣列
	ImageIcon[] allIcons = {icon00, icon01, icon02, icon03, icon04, icon05};

	public int drawX(int j){ 
		return j * eleWidth;
	}  
	public int drawY(int i){     
		return i * eleHeight;
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
		} catch(Exception e2) {  
			e2.printStackTrace();  
		}  
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		loadMap();
		Image image = new ImageIcon("bin//bg.png").getImage();
		int x = 0;
		int y = 0;
		int bitisx = getSize().width;
		int bitisy = getSize().height;
		int w = bitisx/MapWidth;
		int l = bitisy/MapWidth;
		g.drawImage(image, x, y ,bitisx, bitisy, null);
		for(int i = 0; i < MapHeight / eleHeight; i++){  
			for(int j = 0; j < MapWidth / eleWidth; j++){
				//第0層  
				if(icons0[i][j] != null){  
					g.drawImage(icons0[i][j].getImage(), drawX(j), drawY(i), eleWidth, eleWidth, null);  
				}  
				//第1層  
				if(icons1[i][j] != null){  
					g.drawImage(icons1[i][j].getImage(), drawX(j), drawY(i), eleWidth, eleWidth, null);  
				}  
			}
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
