import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clip_RoleWalk2 {

	private BufferedImage sourceImage;
	private int rowClipCount;
	private int columnClipCount;
	private int roleCount;
	private Dimension sizeOneImg;
	
	public Clip_RoleWalk2() {
		try {
			this.sourceImage = ImageIO.read(getClass().getResource("resources//RoleWalk2.png"));
		} catch (IOException e) {
			System.out.println("Error: sourceImage is not found.");
			e.printStackTrace();
		}
		
		// 角色數量
		this.roleCount = 8;
		// 行列數
		this.rowClipCount = 8;
		this.columnClipCount = 12;
		//
		this.sizeOneImg = new Dimension(this.sourceImage.getWidth() / this.columnClipCount, this.sourceImage.getHeight() / this.rowClipCount);
	}
	

}
