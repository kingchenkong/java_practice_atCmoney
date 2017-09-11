import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imageClip {
	// Attributes
//	protected static BufferedImage source;
//	protected static int rowClipCount;
//	protected static int columnClipCount;
//	protected static Rectangle[] arrClipWalkingUp;
//	protected static Rectangle[] arrClipWalkingLeft;
//	protected static Rectangle[] arrClipWalkingDown;
//	protected static Rectangle[] arrClipWalkingRight;

	// Constructor
	public imageClip() {

	}

	// Setter

	// Getter

	// Class method
	public static Rectangle[] getArrClipWalkingDown(String sourceImagePath, Dimension size, int count) {

		// load source image
		try {
			BufferedImage source = ImageIO.read(new File(sourceImagePath));
		} catch (IOException e) {
			System.out.println("Error: getArrClipWalkingUp - sourceImagePath");
			e.printStackTrace();
		}
		Rectangle[] arrClipWalkingDown = new Rectangle[count];
		for(int i = 0; i < count; i++) {
			
		}


		return arrClipWalkingDown;
	}
	public static Rectangle[] getArrClipWalkingLeft(String sourceImagePath, Dimension size, int rowCount, int columnCount) {

		Rectangle[] arrClipWalkingLeft = new Rectangle[3];

		return arrClipWalkingLeft;
	}
	public static Rectangle[] getArrClipWalkingUp(String sourceImagePath, Dimension size, int rowCount, int columnCount) {


		Rectangle[] arrClipWalkingUp = new Rectangle[3];
		return arrClipWalkingUp;
	}
	public static Rectangle[] getArrClipWalkingRight(String sourceImagePath, Dimension size, int rowCount, int columnCount) {


		Rectangle[] arrClipWalkingRight = new Rectangle[3];
		return arrClipWalkingRight;
	}

}
