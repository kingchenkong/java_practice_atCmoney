import java.awt.Graphics;

public class RoleJPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;

	// Attributes
	private CNinja role;
	private int offsetX;
	private int offsetY;


	// Constructor
	public RoleJPanel() {
		this.offsetX = 50;
		this.offsetY = 25;
		this.role = new CNinja(80 + this.offsetX, 80 + this.offsetY);

	}

	@Override public void paint(Graphics g) {

		this.role.paint(g);

		//		this.floor.paint(g);
		//		this.floor2.paint(g);
		//		this.floor3.paint(g);
	}
}
