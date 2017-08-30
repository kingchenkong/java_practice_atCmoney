import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import javax.imageio.ImageIO;
import javax.swing.Timer;

public class GameJPanel extends javax.swing.JPanel {
	//	BufferedImage img;
	//	int x;
	//	int y;
	//	int dir;
	
	CAircraft ac;
	ArrayList<CEnemy> cm;


	public GameJPanel() {
		//		initComponents();
		//		this.x = 30;
		//		this.y = 250;
		//		this.dir = 0;

		ac = new CAircraft();
		cm = new ArrayList();

		this.addMouseListener(new CMyListener1());
		this.addMouseMotionListener(new CMyListener1());
		// delay = 100 ms 
		Timer t1 = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ac.move();		
				if(Math.random() > 0.8 && cm.size() < 11) {
					CEnemy c = new CEnemy((int)(Math.random()*600), 0, ((int)(Math.random()*10) + 1) - 5);
					cm.add(c);
				}	
				for(int i = 0; i < cm.size(); i++) {
					if(cm.get(i).move() == false) {
						cm.remove(i);
					} else {
						if(ac.checkAttack(cm.get(i))) { 
							System.exit(0);
						}	
					}
				}
			}
		});
		t1.start();
	}
	//	@Override public void paintComponent(Graphics g) {
	//		try {
	//			g.drawImage(ImageIO.read(getClass().getResource("airplane1.png")), 30, 30, 250, 250, this);
	////			g.drawImage(ImageIO.read(getClass().getResource("resources//enemy1.png")), 100, 100, 250, 250, this);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}
	@Override public void paint(Graphics g) {
		ac.paint(g);
		for(int i = 0; i < cm.size(); i++)
			cm.get(i).paint(g);
	}
	//	public void move() {
	//		if(this.dir == 0) 
	//			this.x += 16;
	//		else 
	//			this.x -= 16;
	//	}
	//	public void changeDir(int x) {
	//		if(this.x > x)
	//			dir = 1;
	//		else
	//			dir = 0;
	//	}	
	// 巢狀 類別
	class CMyListener1 extends MouseAdapter {
		public void mouseMoved(MouseEvent e) {
			ac.changeDir(e.getX());
		}
	}
}
