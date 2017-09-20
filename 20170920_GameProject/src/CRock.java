import java.io.IOException;
import javax.imageio.ImageIO;

public class CRock extends CRoadblocks{

	public CRock() {
		this.type = this.ROCK;
		this.canPassed = false;
		this.canDestroyed = false;
		this.isVisible = true;
		try {
			this.img = ImageIO.read(getClass().getResource(""));
		} catch (IOException ioEx) {
			System.out.println("CRock img is Not Found.");
		}
	}

	// getter
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
