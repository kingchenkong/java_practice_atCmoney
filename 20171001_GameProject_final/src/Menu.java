import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Menu {
	private BufferedImage sourceImage;
	public Rectangle playB = new Rectangle(80, 500, 100, 50);
	public Rectangle listB = new Rectangle(230, 500, 100, 50);
	public Rectangle quitB = new Rectangle(380, 500, 100, 50);
	public Menu() {
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//封面.png"));
		} catch (IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
	}
	public  void paint(Graphics g) {
		
		Font font = new Font("", Font.BOLD, 50);
		g.drawImage(sourceImage, 0, 0, 600, 622, null);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("開始", playB.x + 5, playB.y + 42);
		g.drawString("排行", listB.x + 5, playB.y + 42);
		g.drawString("離開", quitB.x + 5, quitB.y + 42);

	}
}
