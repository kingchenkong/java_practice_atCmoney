import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args){
		mainExecute();
	}
	public static void mainExecute(){
		final JFrame jf = new JFrame();
		GameJPanel gjp = new GameJPanel();
		jf.setTitle("Push Box");
		jf.setBackground(Color.BLACK);
		jf.setSize(600, 622);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(gjp);
		jf.setVisible(true);


	}

}

