import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class Main extends Map{

	public static void main(String[] args) {
		Map map = new Map();
		//視窗
		map.setTitle("地圖產生器");
		map.setSize(1200, 650);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setLayout(new FlowLayout()); //排版
		//地圖繪製區
		panel = new SetPanel();  
		panel.setPreferredSize(new Dimension(MapWidth, MapHeight));  
		JScrollPane jsp = new JScrollPane(panel);  
		jsp.setPreferredSize(new Dimension(550, 550));  
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//地圖層數選單
		mapnum = new JComboBox<Integer>();  
		setMapnum(mapnum);
		//素材選單
		material = new JComboBox<ImageIcon>();
		material.setMaximumRowCount(3);
		setMaterial(material);
		//儲存鍵
		JButton save = new JButton("儲存");
		save.setActionCommand("save");
		//載入鍵
		JButton load = new JButton("載入");
		load.setActionCommand("load");
		map.add(jsp);//地圖繪製區
		map.add(mapnum);//地圖層數選單
		map.add(material);//素材選單
		map.add(save);//儲存鍵
		map.add(load);//載入鍵
		map.setVisible(true);//顯示視窗(true)
		//監聽地圖繪製區的滑鼠指令
		PanelListenner plis = map.new PanelListenner();  
		panel.addMouseMotionListener(plis);  
		//監聽按鈕指令
		Buttonlistenner blis = map.new Buttonlistenner();  
		Buttonlistenner blis1 = map.new Buttonlistenner();  
		save.addActionListener(blis);
		load.addActionListener(blis1);
	}
}