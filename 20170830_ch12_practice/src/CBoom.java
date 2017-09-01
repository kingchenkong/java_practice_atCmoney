import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;


public class CBoom {
	BufferedImage img, imgB;
	BufferedImage[] arrImg;
	public int x, y;
	int state;
	public final String[] arrPng  = { "005-carrot", "007-broccoli", "008-cherries", "009-steak", "010-fish", "011-apple", "013-pineapple"};
	
	public CBoom(int sx, int sy) {
		this.x = sx;
		this.y = sy;
		this.state = 0;
		this.arrImg = new BufferedImage[8];
		try {
			this.img = ImageIO.read(getClass().getResource("resources//005-carrot.png"));	// 子彈
			this.imgB = ImageIO.read(getClass().getResource("resources//003-salad-1.png"));	// 爆炸
			this.arrImg[0] = ImageIO.read(getClass().getResource("resources//005-carrot.png"));
			this.arrImg[1] = ImageIO.read(getClass().getResource("resources//006-salad.png"));
			this.arrImg[2] = ImageIO.read(getClass().getResource("resources//007-broccoli.png"));
			this.arrImg[3] = ImageIO.read(getClass().getResource("resources//008-cherries.png"));
			this.arrImg[4] = ImageIO.read(getClass().getResource("resources//009-steak.png"));
			this.arrImg[5] = ImageIO.read(getClass().getResource("resources//010-fish.png"));
			this.arrImg[6] = ImageIO.read(getClass().getResource("resources//011-apple.png"));
			this.arrImg[7] = ImageIO.read(getClass().getResource("resources//013-pineapple.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public boolean paint(Graphics g) {
//		for(int i = 0; i < this.arrPng.length; i++) {
//			try {
//				this.img = ImageIO.read(getClass().getResource("resources//" + this.arrPng[i] + ".png"));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		int index = (int) (Math.random()*8);
		this.img = this.arrImg[index];
		if(this.state == 0) {
			g.drawImage(this.img, x, y, 32, 32, null);
		} else {
			g.drawImage(this.imgB, x, y, 64, 64, null);
		}
		return true;
	}
	public boolean move() {
		if(this.state == 0) {
			this.y -= 18;
			if(y < 0)
				return false;
		} else {
			this.state++;
			if(this.state > 12)
				return false;
		}
		return true;		
	}
	public boolean checkAttack(CEnemy e) {
		int left1, left2;
		int right1, right2;
		int top1, top2;
		int bottom1, bottom2;

		left1 = x;
		left2 = e.x;
		right1 = x + 34;
		right2 = e.x + 48;
		top1 = y;
		top2 = e.y;
		bottom1 = y + 40;
		bottom2 = e.y + 44;
		if(bottom1 < top2)
			return false;
		if(top1 > bottom2)
			return false;
		if(right1 < left2)
			return false;
		if(left1 > right2)
			return false;
		this.state = 1;
		return true;
	}

}
