import java.awt.image.BufferedImage;
// 障礙物
// - 石頭, 不可炸 不可穿 	
// - 草,   可炸  可穿
// - 箱子, 可炸  不可穿
//		- 道具 可炸 可穿
//			  - 炸彈距離
//			  - 炸彈個數
//			  - 移動距離
//
abstract class CRoadblocks {
	// 屬性
//	protected String name;	
	protected String type; 	// 種類： 石頭, 草, 箱子
	public final String ROCK = "石頭";
	public final String GRASS = "草";
	public final String BOX = "箱子";
	protected boolean canPassed;
	protected boolean canDestroyed;
	protected boolean isVisible;
	protected BufferedImage img;
	// setter
	
	// getter
	abstract public String getType();
	abstract public boolean getCanPassed();
	abstract public boolean getCanDestroyed();
	abstract public boolean getIsVisible();
	// static method


}
