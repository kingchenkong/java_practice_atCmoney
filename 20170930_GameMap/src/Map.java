import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Map  extends JFrame implements Material{
	//初始化第0層為草地
	public Map() {
		for(int i = 0; i < MapHeight / eleHeight; i++){  
			for(int j = 0; j < MapWidth / eleWidth; j++){  
				map0[i][j] = 0;
				icons0[i][j] = icon00;
			} 
		} 
	}
	//地圖二維陣列(數值, 圖像)
	static int[][] map0 = new int[MapWidth / eleWidth][MapHeight / eleHeight];//地板(人物腳下)
	static int[][] map1 = new int[MapWidth / eleWidth][MapHeight / eleHeight];//地上物(障礙物)
	static ImageIcon[][] icons0 = new ImageIcon[MapWidth / eleWidth][MapHeight / eleHeight];//地板(人物腳下)  
	static ImageIcon[][] icons1 = new ImageIcon[MapWidth / eleWidth][MapHeight / eleHeight];//地上物(障礙物)   
	//下拉式選單
	static JComboBox<Integer> mapnum;//地圖層數
	static JComboBox<ImageIcon> material;//地圖素材
	static JPanel panel;//視窗中地圖顯示器
	//將層數放入下拉式選單
	public static void setMapnum(JComboBox<Integer> jcb){    
		jcb.addItem(0);
		jcb.addItem(1);
	}
	//將素材放入下拉式選單
	public static void setMaterial(JComboBox<ImageIcon> jcb){
		for(int i = 0; i< allIcons.length; i++)  
			jcb.addItem(allIcons[i]);    
	}
	//將素材繪製在選定的位置上
	static class SetPanel extends JPanel{  
		@Override  
		public void paint(Graphics graph) {  
			super.paint(graph);  
			for(int i = 0; i < MapHeight / eleHeight; i++){  
				for(int j = 0; j < MapWidth / eleWidth; j++){  
					//第0層  
					if(icons0[i][j] != null){  
						graph.drawImage(icons0[i][j].getImage(), drawX(j), drawY(i), eleWidth, eleHeight, null);  
					}  
					//第1層  
					if(icons1[i][j] != null){  
						graph.drawImage(icons1[i][j].getImage(), drawX(j), drawY(i), eleWidth, eleHeight, null);  
					}  
				}
			}
		}  
	}
	//地圖陣列位置轉換
	public static int drawX(int j){ 
		return j * eleWidth;  
	}  
	public static int drawY(int i){     
		return i * eleHeight;  
	}  
	class Buttonlistenner implements ActionListener{
		@Override  
		public void actionPerformed(ActionEvent e) {  
			//儲存地圖按鈕
			if(e.getActionCommand().equals("save")){  
				try{  
					System.out.println("開始儲存");    
					FileOutputStream fos = new FileOutputStream(path);  
					DataOutputStream dos = new DataOutputStream(fos);   
					int x = MapHeight / eleHeight;  
					int y = MapWidth / eleWidth;  
					dos.writeInt(x);  
					dos.writeInt(y);    
					for(int i = 0; i < x; i++){  
						for(int j = 0; j < y; j++){
							dos.writeInt(map0[i][j]);  
							dos.writeInt(map1[i][j]);    
						}  
					}  
					
					dos.flush();   
					dos.close();  
					System.out.println("儲存成功");  
				}catch(Exception e1){  
					e1.printStackTrace();  
				}  
			}  
			if(e.getActionCommand().equals("load")){  
				try{  
					System.out.println("開始載入");   
					FileInputStream fis = new FileInputStream(path); 
					DataInputStream dis = new DataInputStream(fis);  
					int x = dis.readInt();  
					int y = dis.readInt();  
					map0 = new int[x][y];  
					map1 = new int[x][y];  
					for(int i=0;i<x;i++){  
						for(int j=0;j<y;j++){  
							map0[i][j] = dis.readInt();
							icons0[i][j] = int2icon(Map.map0[i][j]);
							map1[i][j] = dis.readInt();
							icons1[i][j] = int2icon(Map.map1[i][j]);
						}  
					}  
					dis.close();  
					fis.close();
					System.out.println("載入成功");
				}catch(Exception e2){  
					e2.printStackTrace();  
				}  
			}  
		}  
	}
	//在地圖繪製範圍內點選位置
	class PanelListenner extends MouseAdapter{  
		public void mouseDragged(MouseEvent e) {    
			int j = e.getX()/eleWidth;  
			int i = e.getY()/eleHeight;  
//			System.out.print("(" + i +", " + j + ") ");  
			ImageIcon icon = (ImageIcon)material.getSelectedItem();  
			int num = Integer.parseInt(icon.toString().substring(16, 18));  
			if((int)mapnum.getSelectedItem() == 0){  
				map0[i][j] = num;  
				icons0[i][j] = icon;  
			}
			else if((int)mapnum.getSelectedItem() == 1){  
				map1[i][j] = num;  
				icons1[i][j] = icon; 
			}
//			System.out.println((int)mapnum.getSelectedItem());  
			panel.repaint();  
		} 
	}
	//將數字地圖轉成圖片
	static ImageIcon int2icon(int num){  
		if(num==0) 
			return icon00;  
		else if(num==1)  
			return icon01;  
		else if(num==2)
			return icon02;      
		else if(num==3) 
			return icon03;  
		else if(num==5) 
			return icon05;  
		return null;  
		  
	}
}