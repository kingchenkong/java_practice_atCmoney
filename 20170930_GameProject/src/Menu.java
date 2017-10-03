import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.imageio.ImageIO;

public class Menu {
	private BufferedImage sourceImage;
	public Rectangle playB = new Rectangle(100, 400, 100, 50);
	public Rectangle quitB = new Rectangle(300, 400, 100, 50);
	public Menu() {
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//封面.png"));
		} catch (IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
	}
	public  void paint(Graphics g) {
		
//		Shape roundRectangle = new RoundRectangle2D.Float(100, 120, 100, 80, 100, 300);
		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("", Font.BOLD, 45);
		g.drawImage(sourceImage, 0, 0, 500, 522, null);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("開始", playB.x + 5, playB.y + 42);
		g2d.draw(playB);
		g.drawString("離開", quitB.x + 5, quitB.y + 42);
		g2d.draw(quitB);
	}
}
