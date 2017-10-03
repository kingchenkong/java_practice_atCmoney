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
	// 地圖關卡數
	private int nowLevel;
	private CMap CMap1; 
	private int[][] mapMatrix;
	// Role
	private CRole1 cRole1;
	private int posRoleRow;
	private int posRoleColumn;
	// Goal
	//	private int[][] posGoalRC;
	private CGoal[] goalList;
	private int goalCount;
	// Box
	private CBox[] boxList;
	private int boxCount;
	// Timer
	private Timer t1;
	private boolean timer1IsStart;
	// Move
	private int oneStepMoveDistance;

	// Menu
	private Menu menu;
	public static enum STATE {
		MENU, GAME, LEVEUP, GAMEOVER
	};
	public static STATE state = STATE.MENU;

	// Constructor
	public GameJPanel(int nl) {
		this.menu = new Menu();
		this.constructPanel(nl);
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
				}
				// check which box
				repaint();
				// check 'mission complete'
				int completeCount = 0;
				for(int i = 0; i < goalCount; i++) {
					if(mapMatrix[goalList[i].getRow()][goalList[i].getColumn()] == 2) {
						completeCount++;
					}
				}
				if(completeCount == goalCount) {
					System.out.println("Mission " + nowLevel + " Complete!!!");
					//					stopTimer1();
					toNextLevel();
				}
			}
		});
		t1.start();
		this.timer1IsStart = true;
		//test
		System.out.println("gc = "+ this.goalCount + ", bc = " + this.boxCount);
	}
	public void toNextLevel() {
		if(this.nowLevel < 2) {
			this.nowLevel += 1;
			this.constructPanel(this.nowLevel);
		}
	}
	public void reThisLevel() {
		this.constructPanel(this.nowLevel);
	}
	public void constructPanel(int nl) {
		// CMap
		this.nowLevel = nl;
		this.CMap1 = new CMap(nl);
		this.mapMatrix = this.CMap1.getMapMatrix();
		// 確認 人物 與 箱子 出生位置, 
		// role
		this.posRoleRow = CMap1.getBornRC()[0];
		this.posRoleColumn = CMap1.getBornRC()[1];
		this.cRole1 = new CRole1(this.posRoleColumn * 50, this.posRoleRow * 50, 1);
		// goal
		this.goalCount = CMap1.getGoalCount();
		//				this.posGoalRC = CMap1.getGoalRC();
		this.goalList = new CGoal[this.goalCount];
		for(int i = 0; i < this.goalCount; i++) {
			this.goalList[i] = new CGoal(CMap1.getGoalRC()[i][0], CMap1.getGoalRC()[i][1]);
		}
		// box
		this.boxCount = CMap1.getBoxCount();
		this.boxList = new CBox[this.boxCount];
		for(int i = 0; i < this.boxCount; i++) {
			this.boxList[i] = new CBox(CMap1.getBoxRC()[i][0], CMap1.getBoxRC()[i][1]);
		}
		this.oneStepMoveDistance = 0;
		// listener
		this.addKeyListener(new CMyListener1());
		this.addMouseListener(new MouseInput());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}

	public void pushBox() {
		switch(this.cRole1.getDirection()) {
		case 0: // down
			// check two scale is "Empty"
			if(this.mapMatrix[this.posRoleRow + 2][this.posRoleColumn] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow + 2][this.posRoleColumn] = 2; // empty = box
				this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] = 0;
				// move box
				// - which box
				for(int i = 0; i < this.boxCount; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if(rc[0] == this.posRoleRow + 1 && rc[1] == this.posRoleColumn) {
						box.setForecdDir(0);
						box.setRC(this.posRoleRow + 2, this.posRoleColumn); // 人物兩格遠
						box.move(50);
					}
				}
			}
			break;
		case 1: // left
			// check two scale is "Empty"
			if(this.mapMatrix[this.posRoleRow][this.posRoleColumn - 2] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow][this.posRoleColumn - 2] = 2; // empty = box
				this.mapMatrix[this.posRoleRow][this.posRoleColumn - 1] = 0;
				// move box
				// - which box
				for(int i = 0; i < this.boxCount; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if(rc[0] == this.posRoleRow && rc[1] == this.posRoleColumn - 1) {
						box.setForecdDir(1);
						box.setRC(this.posRoleRow, this.posRoleColumn - 2); // 人物兩格遠
						box.move(50);
					}
				}
			}
			break;
		case 2: // right
			// check two scale is "Empty"
			if(this.mapMatrix[this.posRoleRow][this.posRoleColumn + 2] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow][this.posRoleColumn + 2] = 2; // empty = box
				this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] = 0;
				// move box
				// - which box
				for(int i = 0; i < this.boxCount; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if(rc[0] == this.posRoleRow && rc[1] == this.posRoleColumn + 1) {
						box.setForecdDir(2);
						box.setRC(this.posRoleRow, this.posRoleColumn + 2);
						box.move(50);
					}
				}
			}
			break;
		case 3: // up
			// check two scale is "Empty"
			if(this.mapMatrix[this.posRoleRow - 2][this.posRoleColumn] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow - 2][this.posRoleColumn] = 2; // empty = box
				this.mapMatrix[this.posRoleRow - 1][this.posRoleColumn] = 0;
				// move box
				// - which box
				for(int i = 0; i < this.boxCount; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if(rc[0] == this.posRoleRow - 1 && rc[1] == this.posRoleColumn) {
						box.setForecdDir(3);
						box.setRC(this.posRoleRow - 2, this.posRoleColumn);
						box.move(50);
					}
				}
			}
			break;
		default:
			System.out.println("Error: cRole1.getDirection error.");
		}
	}
	public boolean isTouchBlock() {
		if((this.mapMatrix[this.posRoleRow][(cRole1.getPositionX() + 25) / 50 - 1] == 1 && cRole1.getDirection() == 1) //左
				|| (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] == 1 && cRole1.getDirection() == 2) //右
				|| (this.mapMatrix[(cRole1.getPositionY() + 25) / 50 - 1][this.posRoleColumn] == 1 && cRole1.getDirection() == 3) //上
				|| (this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] == 1  && cRole1.getDirection() == 0)) //下
			return true;
		return false;
	}
	public boolean isTouchBox() {
		if((this.mapMatrix[this.posRoleRow][(cRole1.getPositionX() + 25) / 50 - 1] == 2 && cRole1.getDirection() == 1) //左
				|| (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] == 2 && cRole1.getDirection() == 2) //右
				|| (this.mapMatrix[(cRole1.getPositionY() + 25) / 50 - 1][this.posRoleColumn] == 2 && cRole1.getDirection() == 3) //上
				|| (this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] == 2  && cRole1.getDirection() == 0)) //下
			return true;
		return false;
	}
	// Paint
	@Override 
	public void paint(Graphics g) {
		this.menu.paint(g);
		if(state == STATE.GAME) {
			// CMap1
			this.CMap1.paint(g);
			// CRole1
			this.cRole1.paint(g);
			//box
			for (int i = 0; i < this.boxCount; i++) {
				this.goalList[i].paint(g);
				this.boxList[i].paint(g);
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
	public void printMapMatrix() {
		System.out.println(" -- map");
		for(int i = 0; i < this.mapMatrix.length; i++) {
			for(int j = 0; j < this.mapMatrix[i].length; j++) {
				System.out.print( this.mapMatrix[i][j] + " ");
			}	
			System.out.println("");
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
					if(isTouchBox()) {
						pushBox();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {				
					cRole1.setDirection(1);
					oneStepMoveDistance = 25;
					if(isTouchBox()) {
						pushBox();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					cRole1.setDirection(2);
					oneStepMoveDistance = 25;
					if(isTouchBox()) {
						pushBox();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					cRole1.setDirection(3);
					oneStepMoveDistance = 25;
					if(isTouchBox()) {
						pushBox();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					printMapMatrix();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					reThisLevel();
				}
				//				System.out.println(e.getKeyCode());
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
