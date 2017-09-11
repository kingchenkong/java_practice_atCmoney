import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

// 障礙物

public class Demo1 {
	public static void main(String[] args) {
		// 可移動區域編成
		test();	
		}
	public static void test() {
		final JFrame jf = new JFrame();
		MapJPanel mjp = new MapJPanel();
		RoleJPanel rjp = new  RoleJPanel();

		jf.setTitle("this is JFrame");;
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		jf.add(mjp);
		jf.add(rjp);
		jf.setVisible(true);

		Timer timer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jf.repaint();
			}
		});
		timer.start();
	}
}
