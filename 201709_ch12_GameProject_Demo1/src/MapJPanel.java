import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapJPanel extends javax.swing.JPanel{
	private static final long serialVersionUID = 1L;
	
	// Attributes
	private CMap[][] arrFloor;
	private int offsetX;
	private int offsetY;
	//	CMap floor;
	//	CMap floor2;
	//	CMap floor3;

	// Constructor
	public MapJPanel() {
		this.offsetX = 50;
		this.offsetY = 25;
		this.arrFloor = new CMap[15][15];

		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				this.arrFloor[i][j] = new CMap( i * 48 + this.offsetX, j * 48 + this.offsetY);
			}
		}

		//		this.floor = new CMap(0,0);
		//		this.floor2 = new CMap(0,40);
		//		this.floor3 = new CMap(40,40);
	}

	// Override
	@Override public void paint(Graphics g) {
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				this.arrFloor[i][j].paint(g);
			}
		}
		
		//		this.floor.paint(g);
		//		this.floor2.paint(g);
		//		this.floor3.paint(g);
	}


}
