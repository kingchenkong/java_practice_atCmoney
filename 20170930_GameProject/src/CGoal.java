import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CGoal {
	private int x, y;
	private int row, column;
	private BufferedImage sourceImage;
	public CGoal(int r, int c) {
		this.x = c * 50;
		this.y = r * 50;
		this.row = r;
		this.column = c;
		
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//03黑洞.png"));
		} catch (IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
	}
	// getter
	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}
	public void paint(Graphics g) {
		g.drawImage(this.sourceImage, x, y, 50, 50, null);
	}
}