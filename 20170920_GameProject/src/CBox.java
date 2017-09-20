import java.io.IOException;

import javax.imageio.ImageIO;

public class CBox extends CRoadblocks{

	public CBox() {
		this.type = this.BOX;
		this.canPassed = false;
		this.canDestroyed = true;
		this.isVisible = true;
		try {
			this.img = ImageIO.read(getClass().getResource(""));	
		} catch (IOException ioEx) {
			System.out.println("CBox img is Not Found.");
		}
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public boolean getCanPassed() {
		return this.canPassed;
	}

	@Override
	public boolean getCanDestroyed() {
		return this.canDestroyed;
	}

	@Override
	public boolean getIsVisible() {
		return this.isVisible;
	}

}
