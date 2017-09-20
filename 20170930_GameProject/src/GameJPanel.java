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
//	private CRole2 cRole2;
	
	// Timer
	private Timer t1;
	private boolean timer1IsStart;
	
	// Move
	private int oneStepMoveDistance;
	
	// Constructor
	public GameJPanel() {
		this.CMap1 = new CMap();
		// initial setting
		this.rangePanel = new Rectangle(700, 700);
		this.posRoleInit = new Point(50, 25); // 畫面初始, 出生位置
//		this.cRole2 = new CRole2((int)this.posRoleInit.getX(), (int)this.posRoleInit.getY(), 7);
		this.cRole1 = new CRole1((int)this.posRoleInit.getX() + 80, (int)this.posRoleInit.getY() + 80, 7);
		this.oneStepMoveDistance = 16;
		// listener
		this.addKeyListener(new CMyListener1());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		// timer
		t1 = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// role
//				cRole2.nextIndex();
//				cRole2.move(oneStepMoveDistance);
				if(!isTouchEdge()) {
					cRole1.nextIndex();
					cRole1.move(oneStepMoveDistance);
				}
			}
		});
		this.timer1IsStart = false;
	}
	public boolean isTouchEdge() {
		if((cRole1.getPositionX() < this.rangePanel.x && cRole1.direction == 1) 
			|| (cRole1.getPositionX() >= this.rangePanel.width && cRole1.direction == 2)
			|| (cRole1.getPositionY() < this.rangePanel.y && cRole1.direction == 3)
			|| (cRole1.getPositionY() >= this.rangePanel.height && cRole1.direction == 0)) {
			return true;
		}
		return false;
	}
	// Paint
	@Override public void paint(Graphics g) {
		// CRole1
		this.cRole1.paint(g);

		// CMap1
		super.paintComponent(g);
		CMap1.loadMap();
		Image image = new ImageIcon("bin//bg.png").getImage();
		int x = 0;
		int y = 0;
		int bitisx = getSize().width;
		int bitisy = getSize().height;
		int w = bitisx / CMap1.getMapWH()[0];
		int l = bitisy / CMap1.getMapWH()[1];
		g.drawImage(image, x, y ,bitisx, bitisy, null);
		for(int i = 0; i < CMap1.getMapWH()[1] / CMap1.getEleWH()[1]; i++){  
			for(int j = 0; j < CMap1.getMapWH()[0] / CMap1.getEleWH()[0]; j++){
				//第0層  
				if(CMap1.getIcon2dimen()[0][i][j] != null){  
					g.drawImage(CMap1.getIcon2dimen()[0][i][j].getImage(), CMap1.drawX(j), CMap1.drawY(i), CMap1.getEleWH()[0], CMap1.getEleWH()[1], null);  
				}  
				//第1層  
				if(CMap1.getIcon2dimen()[1][i][j] != null){  
					g.drawImage(CMap1.getIcon2dimen()[1][i][j].getImage(), CMap1.drawX(j), CMap1.drawY(i), CMap1.getEleWH()[0], CMap1.getEleWH()[1], null);  
				}  
			}
		}
		
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
//				cRole2.setDirection(0);
				cRole1.setDirection(0);
				if(!timer1IsStart) {
						runTimer1();
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {				
//				cRole2.setDirection(1);
				cRole1.setDirection(1);
				if(!timer1IsStart) {
						runTimer1();
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
//				cRole2.setDirection(2);
				cRole1.setDirection(2);
				if(!timer1IsStart) {
						runTimer1();
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_UP) {
//				cRole2.setDirection(3);
				cRole1.setDirection(3);
				if(!timer1IsStart) {
						runTimer1();
				}
			}
		}
		@Override public void keyReleased(KeyEvent e) {
			stopTimer1();
//			cRole2.setIndex(1);
			cRole1.setIndex(1);
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
}	// class GameJPanel
