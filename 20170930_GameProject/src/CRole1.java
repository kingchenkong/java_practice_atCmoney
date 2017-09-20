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

	public CRole1(int x, int y, int sheepNo) {
		// load in source
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
		if(sheepNo < 0 || sheepNo > 7) {
			sheepNo = 0;
		}
		switch(sheepNo) {
		case 0:
			this.pointClipStart = new Point(0, 0);	// sheep 0 - 淡灰
			break;
		case 1:
			this.pointClipStart = new Point(144, 0);	// sheep 1 - 淡黃
			break;
		case 2:
			this.pointClipStart = new Point(288, 0);	// sheep 2 - 黑
			break;
		case 3:
			this.pointClipStart = new Point(432, 0);	// sheep 3 - 灰
			break;
		case 4:
			this.pointClipStart = new Point(0, 192);	// sheep 4 - 白
			break;
		case 5:
			this.pointClipStart = new Point(144,192);	// sheep 5 - 黃
			break;
		case 6:
			this.pointClipStart = new Point(288, 192);	// sheep 6 - 褐
			break;
		case 7:
			this.pointClipStart = new Point(432, 192);	// sheep 7 - 淡褐
			break;
		default:
			this.pointClipStart = new Point(0, 0);	// sheep 0 - 淡灰 
		}
		this.arrClipWalking = new BufferedImage[4][3];
		this.setArrClipWalking();

		// role 
		// - position
		this.setPaintPositionX(x);
		this.setPaintPositionY(y);
		// - direction, index
		this.setDirection(0);
		this.setIndex(0);
	}

	// Method
	//  - paint
	public void paint(Graphics g) {
		this.index = (this.index++) % 3;
		g.drawImage(this.arrClipWalking[this.direction][this.index], this.posX, this.posY, 48, 48, null);
	}
	// - setter
	// 		- clip
	public void setArrClipWalking() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				this.arrClipWalking[i][j] = this.sourceImage.getSubimage(this.pointClipStart.x + j * this.sizeOneImg.width, this.pointClipStart.y + i * this.sizeOneImg.height, this.sizeOneImg.width, this.sizeOneImg.height);
			}
		}
	}
	public void setPaintPositionX(int x) {
		this.posX = x;
	}
	public void setPaintPositionY(int y) {
		this.posY = y;
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
	// int forbiddenDir, 
	// -1 - No.
	// 0 - down.
	// 1 - left.
	// 2 - right.
	// 3 - up.
	// int[] validDir,
	// [0], down
	// [1], left
	// [2], right
	// [3], up
	public void move(int d) { 
		if(this.direction == 0)	// down
			this.setPaintPositionY(this.getPositionY() + d);
		if(this.direction == 1)	// left
			this.setPaintPositionX(this.getPositionX() - d);
		if(this.direction == 2)	// right
			this.setPaintPositionX(this.getPositionX() + d);
		if(this.direction == 3)	// up
			this.setPaintPositionY(this.getPositionY() - d);
	}
	// - getter
	public int getPositionX() {
		return this.posX;
	}
	public int getPositionY() {
		return this.posY;
	}
}
