import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;


public class Test extends JFrame{
       
    public static void main(String[] args){  
    	Background bg = new Background();
    	JFrame frame = new Test();
    	frame.setTitle("Boomber Man");
    	frame.add(bg);
    	frame.setSize(600, 620);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	
    	
    }
  
}  

