import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameMain {

	public static void main(String[] args) {
		mainExecute();
	}
	public static void mainExecute() {
		final JFrame jf = new JFrame();

		GameJPanel gjp = new GameJPanel(2);

		jf.setTitle("Push Box");
		jf.setBackground(Color.BLACK);
		jf.setSize(500, 522);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(gjp);

		jf.setVisible(true);


	}

}
