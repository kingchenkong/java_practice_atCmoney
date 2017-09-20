import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CMap {

	private BufferedImage floor;
	private int posX, posY;
	// Constructor
	public CMap(int x, int y) {
		
		// floor position
		this.setPositionX(x);
		this.setPositionY(y);

		try {
			this.floor = ImageIO.read(getClass().getResource("resources//234_preview.jpg"));
		}
		catch(IOException e) {
			System.out.println("this.floor IOException.");
			e.printStackTrace();
		}

	}
	// Method
	// - setter
	public void setPositionX(int x) {
		 this.posX = x;
	}
	public void setPositionY(int y) {
		 this.posY = y;
	}
	
	// - getter
	public int getPositionX() {
		return this.posX;
	}
	public int getPositionY() {
		return this.posY;
	}
	
	
	//  - paint
	public void paint(Graphics g) {
		g.drawImage(this.floor, this.posX, this.posY, 48, 48, null);
	}

}
