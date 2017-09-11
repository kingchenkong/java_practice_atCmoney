import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class RoleJPanel extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	// Attributes
	private CRole1 role;
	private int offsetX;
	private int offsetY;
	private Timer t1;
	private boolean timer1IsStart;
	private int oneStepMoveDistance;
	// Constructor
	public RoleJPanel() {
		// initial setting
		this.offsetX = 50;
		this.offsetY = 25;
		this.role = new CRole1(80 + this.offsetX, 80 + this.offsetY, 7);
		this.oneStepMoveDistance = 12;
		// listener
		this.addKeyListener(new CMyListener1());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		// timer
		t1 = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// role
				role.nextIndex();
				role.move(oneStepMoveDistance);
			}
		});
		this.timer1IsStart = false;
	}
	// Paint
	@Override public void paint(Graphics g) {
		this.role.paint(g);

		//		this.floor.paint(g);
		//		this.floor2.paint(g);
		//		this.floor3.paint(g);
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
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				role.setDirection(0);
				if(!timer1IsStart) {
					role.nextIndex();
					role.setPaintPositionY(role.getPositionY() + oneStepMoveDistance);
				}
				runTimer1();
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {				
				role.setDirection(1);
				if(!timer1IsStart) {
					role.nextIndex();
					role.setPaintPositionX(role.getPositionX() - oneStepMoveDistance);
				}
				runTimer1();
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				role.setDirection(2);
				if(!timer1IsStart) {
					role.nextIndex();
					role.setPaintPositionX(role.getPositionX() + oneStepMoveDistance);
				}
				runTimer1();
			}
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				role.setDirection(3);
				if(!timer1IsStart) {
					role.nextIndex();
					role.setPaintPositionY(role.getPositionY() - oneStepMoveDistance);
				}
				runTimer1();
			}
		}
		@Override public void keyReleased(KeyEvent e) {
			stopTimer1();
			role.setIndex(1);
			repaint();
		}
		//		// useless keyTyped
		//		@Override public void keyTyped(KeyEvent e) {
		//			if(e.getKeyCode() == KeyEvent.VK_UP) {
		//				System.out.println("up");
		//			}
		//
		//		}
	}	// class CMyListener1
}	// class RoleJPanel
