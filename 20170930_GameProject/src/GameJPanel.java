import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameJPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	// Attributes
	// Map
	private CMap CMap1; 

	// Role
	private Rectangle rangePanel;
	private Point posRoleInit;
	private CRole1 cRole1;
	
	// Timer
	private Timer t1;
	private boolean timer1IsStart;

	// Move
	private int oneStepMoveDistance;

	// Constructor
	public GameJPanel() {
		// CMap
		this.CMap1 = new CMap();
		// initial setting
		this.rangePanel = new Rectangle(50, 50, 475, 450);
		this.posRoleInit = new Point(25, 25); // 畫面初始, 出生位置
		this.cRole1 = new CRole1((int)this.posRoleInit.getX() + 0, (int)this.posRoleInit.getY() + 0, 1);
		this.oneStepMoveDistance = 0;
		// listener
		this.addKeyListener(new CMyListener1());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		// timer
		t1 = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// role
				if(!isTouchEdge()) {
					cRole1.move(oneStepMoveDistance);
				}
				repaint();
			}
		});
		t1.start();
		this.timer1IsStart = false;
	}
	public boolean isTouchEdge() {
		if((cRole1.getPositionX() < this.rangePanel.x && cRole1.direction == 1) 
				|| (cRole1.getPositionX() > this.rangePanel.width && cRole1.direction == 2)
				|| (cRole1.getPositionY() < this.rangePanel.y && cRole1.direction == 3)
				|| (cRole1.getPositionY() > this.rangePanel.height && cRole1.direction == 0)) {
			return true;
		}
		return false;
	}
	// Paint
	@Override public void paint(Graphics g) {

		// CMap1
		this.CMap1.paint(g);
		// CRole1
		this.cRole1.paint(g);
	}
	// Setter
	public void setOneStepMoveDistance(int d) {
		this.oneStepMoveDistance = d;
	}
	public void runTimer1() {
		if(!this.timer1IsStart) {
			this.t1.start();
			this.timer1IsStart = true;
		}
	}
	public void stopTimer1() {
		if(this.timer1IsStart) {
			this.t1.stop();
			this.timer1IsStart = false;
		}
	}
	class CMyListener1 extends KeyAdapter {
		@Override public void keyPressed(KeyEvent e) {
//			System.out.println(e.getKeyCode());
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				cRole1.setDirection(0);
				oneStepMoveDistance = 25;
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {				
				cRole1.setDirection(1);
				oneStepMoveDistance = 25;
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				cRole1.setDirection(2);
				oneStepMoveDistance = 25;
			}
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				cRole1.setDirection(3);
				oneStepMoveDistance = 25;
			}
//			if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
//				System.out.printf("(%3d,%3d)\n", cRole1.getPositionX(), cRole1.getPositionY());
//			}
		}
		@Override public void keyReleased(KeyEvent e) {

			cRole1.setIndex(1);
			oneStepMoveDistance = 0;
			repaint();
		}
	}	// class CMyListener1
}	// class GameJPanel
