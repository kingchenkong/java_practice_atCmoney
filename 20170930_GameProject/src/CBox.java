import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CBox{
	private int posX, posY;
	private int forcedDirection;
	private BufferedImage sourceImage;
	
	public CBox(int x, int y){
		this.posX = y * 50;
		this.posY = x * 50;
		
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//02box.png"));
		}
		catch(IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}


	}	

	public void paint(Graphics g) {
		g.drawImage(this.sourceImage, posX, posY, 50, 50, null);
	}

	public boolean move(int d) {

		if(this.forcedDirection == 0) {	// from up to down
			this.posY = this.posY + d;
		}
		if(this.forcedDirection == 1) {	// from right to left
			this.posX = this.posX - d;
		}
		if(this.forcedDirection == 2) {	// from left to right
			this.posX = this.posX + d;
		}
		if(this.forcedDirection == 3) {	// from down to up
			this.posY = this.posY - d;
		}
		return true;
	}


}
