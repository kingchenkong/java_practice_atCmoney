import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {

	public static void main(String[] args) {
		final JFrame jf = new JFrame();
		GameJPanel gjp = new GameJPanel();
		jf.setTitle("this is JFrame");;
		jf.setSize(700, 650);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(gjp);
		jf.setVisible(true);

		Timer timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jf.repaint();
			}
		});
		timer.start();
	}
}
