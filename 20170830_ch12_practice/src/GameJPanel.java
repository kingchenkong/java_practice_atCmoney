import java.applet.Applet;
import java.applet.AudioClip;
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
	ArrayList<CBoom> bm;
	int sx, sy;
	AudioClip clip;

	public GameJPanel() {
		//		initComponents();
		//		this.x = 30;
		//		this.y = 250;
		//		this.dir = 0;

		// 子彈 初始座標
		this.sx = 0;
		this.sy = 0;

		ac = new CAircraft();
		cm = new ArrayList();
		bm = new ArrayList();

		this.addMouseListener(new CMyListener1());
		this.addMouseMotionListener(new CMyListener1());
		try {
		this.clip = Applet.newAudioClip(getClass().getResource("resources//bomb.wav"));
		} catch(Exception e) {
			
		}
		// delay = 100 ms 
		// - 匿名內部類別
		Timer t1 = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// me
				ac.move();		
				// enemy
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

				for(int i = 0; i < bm.size(); i++) {
					if(bm.get(i).move() == false) {
						bm.remove(i);			
					} else {
						if(bm.get(i).state == 0) {
							for(int j = 0; j < cm.size(); j++) {
								if(bm.get(i).checkAttack(cm.get(j))) {
									cm.remove(j);
									break;
								}
							}
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
		for(int i = 0; i < bm.size(); i++)
			bm.get(i).paint(g);
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
		@Override public void mouseMoved(MouseEvent e) {
			ac.changeDir(e.getX());
			//
//			sx = ac.x + 5;
//			sy = ac.y - 10;
//			CBoom c = new CBoom(sx, sy);
//			bm.add(c);
//			clip.play();
		}

		@Override public void mousePressed(MouseEvent e) {
			if(e.getButton() == e.BUTTON1) {
				sx = ac.x + 5;
				sy = ac.y - 10;
				CBoom c = new CBoom(sx, sy);
				bm.add(c);
				clip.play();
			}
		}

	}
}
