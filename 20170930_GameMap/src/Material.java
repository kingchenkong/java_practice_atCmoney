import javax.swing.ImageIcon;
//介面:只有常數, 抽象方法的類別(不可以有實作變數, 實作方法) 
public interface Material {
	//素材大小
	int eleWidth = 50;  
	int eleHeight = 50;  
	//地圖大小
	int MapWidth = 500;  
	int MapHeight= 500;  
	//地圖存放路徑
	String path = "bin//Map//map3.map";  
	//素材圖片
	ImageIcon icon00 = new ImageIcon("bin//resources//00地板.png");
	ImageIcon icon01 = new ImageIcon("bin//resources//01磚牆.png");
	ImageIcon icon02 = new ImageIcon("bin//resources//02box.png");
	ImageIcon icon03 = new ImageIcon("bin//resources//03黑洞.png");
	ImageIcon icon05 = new ImageIcon("bin//resources//05出生位置.png");
	//素材陣列
	ImageIcon[] allIcons = {icon00, icon01, icon02, icon03, icon05}; 
}