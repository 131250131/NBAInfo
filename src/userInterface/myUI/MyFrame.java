package userInterface.myUI;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
	boolean isDraging;
	int xx, yy, X0, Y0;
	
	public MyFrame(){
		
		//获取使用者电脑屏幕大小
		Toolkit toolkit = this.getToolkit();
		int screenX = toolkit.getScreenSize().width;
		int screenY = toolkit.getScreenSize().height;
		
		//设定本系统的屏幕大小
		int frameSizeX = 1280;
		int frameSizeY = 720;
		
		//初始化本系统相关设定，并且使得窗体出现在屏幕正中央
		setSize(frameSizeX, frameSizeY);
		setLocation((screenX - frameSizeX) / 2 , (screenY - frameSizeY) / 2);
		setResizable(false);
		setUndecorated(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//增加鼠标监听 使得窗体可以跟随鼠标移动
		addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                requestFocus();
                isDraging = true;
                xx = e.getX();
                yy = e.getY();
            }
 
            public void mouseReleased(MouseEvent e) {
                isDraging = false;
            }
        });
		
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDraging) {
                    int left = getLocation().x;
                    int top = getLocation().y;
                    setLocation(left + e.getX() - xx, top + e.getY() - yy);
                }
            }
        });
        
        //增加线程 使得窗体可以逐渐刷新出现
        new HyalineValue().start();
		
	}
	
class HyalineValue extends Thread {
		
		float hyalineValue = 0f;

		public void run() {
			while(true) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hyalineValue += 0.05f;
				if (hyalineValue > 1) {
					hyalineValue = 1;
				}
				setOpacity(hyalineValue);
				if (hyalineValue == 1) {
					break;
				}
			}
		}
    }
}
