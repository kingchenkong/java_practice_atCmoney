import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CBox{
	private int posX, posY;
	private int row, column;
	private int forcedDirection;
	private BufferedImage sourceImage;

	public CBox(int r, int c){
		this.posX = c * 50;
		this.posY = r * 50;
		this.setRC(r, c);
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//02Box.png"));
		}
		catch(IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
	}	
	// setter
	public void setRC(int r, int c) {
		this.row = r;
		this.column = c;
	}
	public void setForecdDir(int dir) {
		this.forcedDirection = dir;
	}

	// getter
	public int[] getRc() {
		int[] arr = {this.row, this.column};
		return arr;
	}
	public int[] getPos() {
		int[] arr = {this.posX, this.posY};
		return arr;
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
