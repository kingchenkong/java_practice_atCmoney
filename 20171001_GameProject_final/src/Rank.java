import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rank {
	private BufferedImage sourceImage;
	private String[] rank;
	private int count;
	public Rank(){
		rank = new String[5];
		this.count = 0;
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//rank.png"));
		} catch (IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
	}
	
	public void add(String str) {
		rank[count++] = str;
	}
	public void setCount() {
		count = 0;
	}
	public void paint(Graphics g) {
		Font font = new Font("", Font.BOLD, 50);
		g.drawImage(this.sourceImage, 0, 0, 600, 622, null);
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("<<", 0, 40);
		g.drawString(rank[0], 150, 100);//差110
		g.drawString(rank[1], 150, 210);
		g.drawString(rank[2], 150, 320);
		g.drawString(rank[3], 150, 430);
		g.drawString(rank[4], 150, 540);
		
	}
	
	
}
