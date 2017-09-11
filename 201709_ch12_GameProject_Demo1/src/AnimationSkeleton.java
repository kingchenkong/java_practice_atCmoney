import java.awt.*;
import javax.swing.JApplet;

public class AnimationSkeleton extends JApplet  implements Runnable {
	
	// 定義多執行緒的方法 
    public void run() { 
        // 動畫迴圈 
        while(true) { 

            // 動畫的狀態改變、緩衝區繪圖 

            this.repaint();  // 重繪畫面 

            // 執行緒暫停 50 毫秒 
            try { 
                Thread.sleep(50); // 避免Busy loop
            } 
            catch(InterruptedException e) { 
                    // 例外處理 
            } 
        }  // while結束 
    }  // run()結束 
 
    // 改寫update()，避免畫面不連續 
    public void update(Graphics g) { 
        this.paint(g);  // 單純呼叫paint() 
    } 
 
    public void paint(Graphics g) { 
        super.paint(g);
        // 繪圖動作 
    } 

}
