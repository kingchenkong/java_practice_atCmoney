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
	private int[][] mapMatrix;
	// Role
	private CRole1 cRole1;
	private int posRoleRow;
	private int posRoleColumn;
	//Box
	private CBox[] boxList = new CBox[3];
	private int count = 0;
	// Timer
	private Timer t1;
	private boolean timer1IsStart;
	// Move
	private int oneStepMoveDistance;

	// Constructor
	public GameJPanel() {
		// CMap
		this.CMap1 = new CMap();
		this.mapMatrix = this.CMap1.getMapMatrix();
		
		for(int i = 0; i < this.mapMatrix.length; i++){  
			for(int j = 0; j < this.mapMatrix[i].length; j++){
				if (mapMatrix[i][j] == 5) // 人物
					this.cRole1 = new CRole1(j * 50, i * 50, 2);
				if (mapMatrix[i][j] == 2) // 箱子
					this.boxList[count++] = new CBox(i, j);
			}
		}
		this.posRoleRow = 1;
		this.posRoleColumn = 1;
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
				// position row & column
				posRoleRow = (cRole1.getPositionY()) / 50;
				posRoleColumn = (cRole1.getPositionX()) / 50;
				if(!isTouchBlock()) {
					if(!isTouchBox()) {
						cRole1.move(oneStepMoveDistance);
					}
					if(isTouchBox()) {
						whichBox();
					}
				}
				// check which box
				repaint();
			}
		});
		t1.start();
		this.timer1IsStart = false;
	}
	public void whichBox() {
		
	}
	public boolean isTouchBlock() {
		if((this.mapMatrix[this.posRoleRow][(cRole1.getPositionX() + 25) / 50 - 1] == 1 && cRole1.direction == 1) //左
				|| (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] == 1 && cRole1.direction == 2) //右
				|| (this.mapMatrix[(cRole1.getPositionY() + 25) / 50 - 1][this.posRoleColumn] == 1 && cRole1.direction == 3) //上
				|| (this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] == 1  && cRole1.direction == 0)) //下
			return true;
		return false;
	}
	public boolean isTouchBox() {
		if((this.mapMatrix[this.posRoleRow][(cRole1.getPositionX() + 25) / 50 - 1] == 2 && cRole1.direction == 1) //左
				|| (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] == 2 && cRole1.direction == 2) //右
				|| (this.mapMatrix[(cRole1.getPositionY() + 25) / 50 - 1][this.posRoleColumn] == 2 && cRole1.direction == 3) //上
				|| (this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] == 2  && cRole1.direction == 0)) //下
			return true;
		return false;
	}
	// Paint
	@Override 
	public void paint(Graphics g) {
		// CMap1
		this.CMap1.paint(g);
		// CRole1
		this.cRole1.paint(g);
		//box
		for (int i = 0; i < count; i++) {
			this.boxList[i].paint(g);
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
			if(cRole1.getPositionX() % 50 != 0 || cRole1.getPositionY() % 50 != 0)
				cRole1.move(oneStepMoveDistance);
			else {
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
			}
		}
		@Override public void keyReleased(KeyEvent e) {
			if(cRole1.getPositionX() % 50 != 0 || cRole1.getPositionY() %50 != 0)
				cRole1.move(oneStepMoveDistance);
			cRole1.setIndex(1);
			oneStepMoveDistance = 0;
			repaint();
		}
	}	
}	
