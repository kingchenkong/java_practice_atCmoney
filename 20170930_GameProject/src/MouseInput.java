import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		/*
		 * public Rectangle playB = new Rectangle(100, 400, 100, 50); public Rectangle
		 * quitB = new Rectangle(300, 400, 100, 50);
		 */
		if (mx >= 100 && mx <= 200) {
			if (my >= 400 && my <= 450) {
				GameJPanel.state = GameJPanel.STATE.GAME;
			}
		}
//		if (mx >= 100 && mx <= 400 && my >= 400 && my <= 450) 
//			GameJPanel.state = GameJPanel.STATE.GAMEOVER;
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
