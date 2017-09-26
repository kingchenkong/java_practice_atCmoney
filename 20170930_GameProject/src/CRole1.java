import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CRole1 {

	private BufferedImage sourceImage;
	private int sourceImageRowCount;
	private int sourceImageColumnCount;
	private Dimension sizeOneImg;
	private Point pointClipStart;
	int direction;
	int index;
	private BufferedImage[][] arrClipWalking;
	private int posX, posY;

	public CRole1(int x, int y, int roleImgIndex) {
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//RoleWalk1.png"));
		}
		catch(IOException e) {
			System.out.println("this.source IOException.");
			e.printStackTrace();
		}
		// set row & column Count
		this.sourceImageRowCount = 8;
		this.sourceImageColumnCount = 12;
		// set clip
		this.sizeOneImg = new Dimension(this.sourceImage.getWidth() / this.sourceImageColumnCount, this.sourceImage.getHeight() / this.sourceImageRowCount);
		if(roleImgIndex < 0 || roleImgIndex > 7) {
			roleImgIndex = 0;
		}
		switch(roleImgIndex) {
		case 0:
			this.pointClipStart = new Point(0, 0);
			break;
		case 1:
			this.pointClipStart = new Point(144, 0);
			break;
		case 2:
			this.pointClipStart = new Point(288, 0);
			break;
		case 3:
			this.pointClipStart = new Point(432, 0);
			break;
		case 4:
			this.pointClipStart = new Point(0, 192);
			break;
		case 5:
			this.pointClipStart = new Point(144,192);
			break;
		case 6:
			this.pointClipStart = new Point(288, 192);
			break;
		case 7:
			this.pointClipStart = new Point(432, 192);
			break;
		default:
			this.pointClipStart = new Point(0, 0); 
		}
		this.arrClipWalking = new BufferedImage[4][3];
		this.setArrClipWalking();
		this.posX = x;
		this.posY = y;

		// - direction, index
		this.setDirection(0);
		this.setIndex(0);
	}

	public void paint(Graphics g) {
		g.drawImage(this.arrClipWalking[this.direction][this.index], this.posX, this.posY, 50, 50, null);
	}

	public void setArrClipWalking() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				this.arrClipWalking[i][j] = this.sourceImage.getSubimage(this.pointClipStart.x + j * this.sizeOneImg.width, this.pointClipStart.y + i * this.sizeOneImg.height, this.sizeOneImg.width, this.sizeOneImg.height);
			}
		}
	}
	public void setIndex(int in) {
		//		posY += 8;
		this.index = (in) % arrClipWalking[0].length;
	}
	public void nextIndex() {
		//		posY += 8;
		this.index = (this.index + 1) % arrClipWalking[0].length;
	}
	public void setDirection(int dir) {
		//		posY += 8;
		this.direction = (dir) % arrClipWalking.length;
	}
	public void move(int d) { 
		if(this.direction == 0) {	// down
			this.posY = this.posY + d;
		}
		if(this.direction == 1) {	// left
			this.posX = this.posX - d;
		}
		if(this.direction == 2) {	// right
			this.posX = this.posX + d;
		}
		if(this.direction == 3) {	// up
			this.posY = this.posY - d;
		}
		if(d != 0)
			this.nextIndex();
	}
	// - getter
	public int getPositionX() {
		return this.posX;
	}
	public int getPositionY() {
		return this.posY;
	}
}
