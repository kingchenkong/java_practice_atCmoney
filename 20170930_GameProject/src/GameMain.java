import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameMain {

	public static void main(String[] args) {
		// 可移動區域編成
		test();	
	}
	public static void test() {
		final JFrame jf = new JFrame();
//		MapJPanel mjp = new MapJPanel();
		GameJPanel gjp = new GameJPanel();

		jf.setTitle("Boomber Man");;
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		jf.add(mjp);
		jf.add(gjp);

		jf.setVisible(true);

//		Timer timer = new Timer(50, new ActionListener() {
//			public void actionPerformed(ActionEvent evt) {
//				jf.repaint();
//			}
//		});
//		timer.start();
	}
}
