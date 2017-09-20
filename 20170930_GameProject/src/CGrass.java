import java.io.IOException;

import javax.imageio.ImageIO;

public class CGrass extends CRoadblocks{

	public CGrass() {
		this.type = this.GRASS;
		this.canPassed = true;
		this.canDestroyed = true;
		this.isVisible = true;
		try {
			this.img = ImageIO.read(getClass().getResource(""));
		} catch (IOException ioEx) {
			System.out.println("CGrass img is Not Found.");
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
