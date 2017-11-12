import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// Attributes
	// Map
	private CMap CMap1;
	private int[][] mapMatrix;
	private int nowLevel;
	// Role
	private CRole1 cRole1;
	private int posRoleRow;
	private int posRoleColumn;
	// Goal
	private CGoal[] goalList;
	private int goalCount;
	// Box
	private CBox[] boxList;
	private int boxCount;
	// Timer
	private Timer t1;
	// Move
	private int oneStepMoveDistance;
	private Menu menu;
	// Rank
	private Rank rank;
	private ArrayList<Long> timeRecords;
	long startTime;
	// 音效
	private AudioClip bgm;

	// 選項操控
	public static enum STATE {
		MENU, GAME, RANK
	};

	public static STATE state = STATE.MENU;

	// Constructor
	public GameJPanel() {
		try {
			bgm = Applet.newAudioClip(getClass().getResource("sound//bgm1.wav"));
		} catch (Exception e) {

		}
		menu = new Menu();
		rank = new Rank();
		timeRecords = new ArrayList<>();
		nowLevel = 0;
		this.addKeyListener(new CMyListener1());
		this.addMouseListener(new MouseInput());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		t1 = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				if (state == STATE.GAME) {
					posRoleRow = (cRole1.getPositionY()) / 50;
					posRoleColumn = (cRole1.getPositionX()) / 50;
					if (!isTouchBlock()) {
						if (!isTouchBox()) {
							cRole1.move(oneStepMoveDistance);
						}
					}
					// check which box
					// check 'mission complete'
					int completeCount = 0;
					for (int i = 0; i < goalCount; i++) {
						if (mapMatrix[goalList[i].getRow()][goalList[i].getColumn()] == 2)
							completeCount++;
					}
					if (completeCount == goalCount) {
						long newTime = System.currentTimeMillis() - startTime;
						if (timeRecords.get(nowLevel) > newTime) {
							timeRecords.set(nowLevel, newTime);
						}
						t1.stop();
						if (nowLevel < 4) {
							startTime = System.currentTimeMillis();
							toNextLevel();
						} else {
							bgm.stop();
							nowLevel = 0;
							state = STATE.MENU;
							rank.setCount();
							try {
								rankWrite();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		t1.start();
	}

	public void classDP(Graphics g) {
		Font font = new Font("", Font.BOLD, 50);
		g.setFont(font);
		g.drawString("關卡" + (nowLevel + 1), 250, 560);
	}

	// read history rank
	public void rankRead() throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("bin//rank.txt");
		BufferedReader br = new BufferedReader(fr);
		String str;
		while ((str = br.readLine()) != null) {
			long timeMilli = Long.parseLong(str);
			timeRecords.add(timeMilli);
			String s = timeFormat(timeMilli);
			rank.add(s);
		}
		br.close();
		fr.close();
	}

	public void rankWrite() throws IOException {
		FileWriter fw = new FileWriter("bin//rank.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < timeRecords.size(); i++) {
			String str = timeRecords.get(i) + "";
			bw.write(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		fw.close();
	}

	public String timeFormat(long time) {
		long totalSecond = time / 1000;
		long minute = totalSecond / 60;
		long second = totalSecond - (minute * 60);
		long tenMilli = (time % 1000) / 10;
		String str = ((minute < 10) ? "0" : "") + minute + " : " + ((second < 10) ? "0" : "") + second + " : "
				+ ((tenMilli < 10) ? "0" : "") + tenMilli;
		return str;
	}

	public void toNextLevel() {
		this.nowLevel++;
		Start(nowLevel);
	}

	public void reThisLevel() {
		Start(nowLevel);
	}

	public void Start(int level) {
		// CMap
		this.CMap1 = new CMap(nowLevel);
		this.mapMatrix = this.CMap1.getMapMatrix();
		// 確認 人物 與 箱子 出生位置,
		// role
		this.posRoleRow = CMap1.getBornRC()[0];
		this.posRoleColumn = CMap1.getBornRC()[1];
		this.cRole1 = new CRole1(this.posRoleColumn * 50, this.posRoleRow * 50, 1);
		// goal
		this.goalCount = CMap1.getgoalCount();
		this.goalList = new CGoal[this.goalCount];
		for (int i = 0; i < this.goalCount; i++) {
			this.goalList[i] = new CGoal(CMap1.getGoalRC()[i][0], CMap1.getGoalRC()[i][1]);
		}
		// box
		this.boxCount = CMap1.getBoxCount();
		this.boxList = new CBox[this.boxCount];
		for (int i = 0; i < this.boxCount; i++) {
			this.boxList[i] = new CBox(CMap1.getBoxRC()[i][0], CMap1.getBoxRC()[i][1]);
		}
		this.oneStepMoveDistance = 0;
		t1.start();
	}

	public void pushBox() {
		switch (this.cRole1.getDirection()) {
		case 0: // down
			// check two scale is "Empty"
			if (this.mapMatrix[this.posRoleRow + 2][this.posRoleColumn] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow + 2][this.posRoleColumn] = 2; // empty = box
				this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] = 0;
				// move box
				// - which box
				for (int i = 0; i < this.boxList.length; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if (rc[0] == this.posRoleRow + 1 && rc[1] == this.posRoleColumn) {
						box.setForecdDir(0);
						box.setRC(this.posRoleRow + 2, this.posRoleColumn); // 人物兩格遠
						box.move(50);
					}
				}
			}
			break;
		case 1: // left
			// check two scale is "Empty"
			if (this.mapMatrix[this.posRoleRow][this.posRoleColumn - 2] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow][this.posRoleColumn - 2] = 2; // empty = box
				this.mapMatrix[this.posRoleRow][this.posRoleColumn - 1] = 0;
				// move box
				// - which box
				for (int i = 0; i < this.boxList.length; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if (rc[0] == this.posRoleRow && rc[1] == this.posRoleColumn - 1) {
						box.setForecdDir(1);
						box.setRC(this.posRoleRow, this.posRoleColumn - 2); // 人物兩格遠
						box.move(50);
					}
				}
			}
			break;
		case 2: // right
			// check two scale is "Empty"
			if (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 2] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow][this.posRoleColumn + 2] = 2; // empty = box
				this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] = 0;
				// move box
				// - which box
				for (int i = 0; i < this.boxList.length; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if (rc[0] == this.posRoleRow && rc[1] == this.posRoleColumn + 1) {
						box.setForecdDir(2);
						box.setRC(this.posRoleRow, this.posRoleColumn + 2);
						box.move(50);
					}
				}
			}
			break;
		case 3: // up
			// check two scale is "Empty"
			if (this.mapMatrix[this.posRoleRow - 2][this.posRoleColumn] == 0) {
				// swap Role - Box - Empty
				this.mapMatrix[this.posRoleRow - 2][this.posRoleColumn] = 2; // empty = box
				this.mapMatrix[this.posRoleRow - 1][this.posRoleColumn] = 0;
				// move box
				// - which box
				for (int i = 0; i < this.boxList.length; i++) {
					CBox box = this.boxList[i];
					int[] rc = box.getRc();
					if (rc[0] == this.posRoleRow - 1 && rc[1] == this.posRoleColumn) {
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
		if ((this.mapMatrix[this.posRoleRow][(cRole1.getPositionX() + 25) / 50 - 1] == 1 && cRole1.getDirection() == 1) // 左
				|| (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] == 1 && cRole1.getDirection() == 2) // 右
				|| (this.mapMatrix[(cRole1.getPositionY() + 25) / 50 - 1][this.posRoleColumn] == 1
						&& cRole1.getDirection() == 3) // 上
				|| (this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] == 1 && cRole1.getDirection() == 0)) // 下
			return true;
		return false;
	}

	public boolean isTouchBox() {
		if ((this.mapMatrix[this.posRoleRow][(cRole1.getPositionX() + 25) / 50 - 1] == 2 && cRole1.getDirection() == 1) // 左
				|| (this.mapMatrix[this.posRoleRow][this.posRoleColumn + 1] == 2 && cRole1.getDirection() == 2) // 右
				|| (this.mapMatrix[(cRole1.getPositionY() + 25) / 50 - 1][this.posRoleColumn] == 2
						&& cRole1.getDirection() == 3) // 上
				|| (this.mapMatrix[this.posRoleRow + 1][this.posRoleColumn] == 2 && cRole1.getDirection() == 0)) // 下
			return true;
		return false;
	}

	// Paint
	@Override
	public void paint(Graphics g) {
		if (state == STATE.MENU)
			menu.paint(g);
		if (state == STATE.RANK)
			rank.paint(g);
		if (state == STATE.GAME) {
			this.CMap1.paint(g);
			classDP(g);
			for (int i = 0; i < this.goalCount; i++) {
				this.goalList[i].paint(g);
			}
			for (int i = 0; i < this.boxCount; i++) {
				this.boxList[i].paint(g);
			}
			this.cRole1.paint(g);
		}
	}

	// Setter
	public void setOneStepMoveDistance(int d) {
		this.oneStepMoveDistance = d;
	}

	public void printMapMatrix() {
		for (int i = 0; i < this.mapMatrix.length; i++) {
			for (int j = 0; j < this.mapMatrix[i].length; j++) {
				System.out.print(this.mapMatrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	class CMyListener1 extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (state == STATE.GAME) {
				if (cRole1.getPositionX() % 50 != 0 || cRole1.getPositionY() % 50 != 0)
					cRole1.move(oneStepMoveDistance);
				else {
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						cRole1.setDirection(0);
						oneStepMoveDistance = 25;
						if (isTouchBox()) {
							pushBox();
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						cRole1.setDirection(1);
						oneStepMoveDistance = 25;
						if (isTouchBox()) {
							pushBox();
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						cRole1.setDirection(2);
						oneStepMoveDistance = 25;
						if (isTouchBox()) {
							pushBox();
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						cRole1.setDirection(3);
						oneStepMoveDistance = 25;
						if (isTouchBox()) {
							pushBox();
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						printMapMatrix();
					}
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						reThisLevel();
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (cRole1.getPositionX() % 50 != 0 || cRole1.getPositionY() % 50 != 0)
				cRole1.move(oneStepMoveDistance);
			cRole1.setIndex(1);
			oneStepMoveDistance = 0;
			repaint();
		}
	}

	public class MouseInput extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();
			if (mx >= 80 && mx <= 180 && my >= 500 && my <= 550) {
				state = STATE.GAME;
				bgm.loop();
				startTime = System.currentTimeMillis();
				Start(nowLevel);
				try {
					rankRead();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (mx >= 230 && mx <= 330 && my >= 500 && my <= 550) {
				state = STATE.RANK;
				t1.start();
				try {
					rankRead();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if (mx >= 380 && mx <= 480 && my >= 500 && my <= 550) {
				System.exit(1);
			} else if (mx >= 0 && mx <= 50 && my >= 0 && my <= 50) {
				state = STATE.MENU;
				rank.setCount();
			}
		}
	}
}
