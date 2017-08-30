import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CEnemy {
	BufferedImage img;
	public int x, y, d;
	public CEnemy(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
		try {
			this.img = ImageIO.read(getClass().getResource("resources//enemy1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void paint(Graphics g) {
		g.drawImage(this.img, x, y, null);
	}
	public boolean move() {
		this.y += 16;
		this.x += d;
		if(y > 650) 
			return false;
		return true;
	}

}
