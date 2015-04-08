package userInterface.myUI;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
	boolean isDraging;
	int xx, yy, X0, Y0;
	JButton bt_mini, bt_close;
	
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
		
		//add close button
		bt_mini = new JButton();
		bt_mini.setVisible(true);
		bt_mini.setBorder(BorderFactory.createEmptyBorder());
		bt_mini.setOpaque(false);
		bt_mini.setBackground(null);
		bt_mini.setContentAreaFilled(false);
		bt_mini.setBounds(frameSizeX - 50, 0, 25, 25);
		bt_mini.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				MyFrame.this.setExtendedState(JFrame.ICONIFIED);
			}
		});
		this.add(bt_mini);
		
		bt_close = new JButton();
		bt_close.setVisible(true);
		bt_close.setBorder(BorderFactory.createEmptyBorder());
		bt_close.setOpaque(false);
		bt_close.setBackground(null);
		bt_close.setContentAreaFilled(false);
		bt_close.setBounds(frameSizeX - 25, 0, 25, 25);
		bt_close.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.exit(0);
			}
		});
		this.add(bt_close);
		
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
