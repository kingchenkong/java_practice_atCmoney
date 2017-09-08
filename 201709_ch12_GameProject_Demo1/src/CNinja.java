import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CNinja {

	
	private BufferedImage source;
	private BufferedImage source_mirror;
	private BufferedImage role;
	
	private int posX, posY;

	public CNinja(int x, int y) {
		// load in source
		try {
			this.source = ImageIO.read(getClass().getResource("resources//rudolf_0.bmp"));
			this.source_mirror = ImageIO.read(getClass().getResource("resources//rudolf_0_mirror.bmp"));
		}
		catch(IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
		
		// role position
				this.setPositionX(x);
				this.setPositionY(y);
				this.setRoleImage(this.source);		
	}
	
	// Method
		// - setter
		public void setPositionX(int x) {
			 this.posX = x;
		}
		public void setPositionY(int y) {
			 this.posY = y;
		}
		public void setRoleImage(BufferedImage img) {
			this.role = img;
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
			g.drawImage(this.role, this.posX, this.posY, 500, 500, null);
		}

}
