package com.nba.davisUI.myUI;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	//重写JFrame并
	
	private static final long serialVersionUID = 1L;
	
	boolean isDraging;
	int xx, yy, X0, Y0;
	
	public MyFrame(){
		
		Toolkit toolkit = this.getToolkit();
		int screenX = toolkit.getScreenSize().width;
		int screenY = toolkit.getScreenSize().height;
		int frameSizeX = 1280;
		int frameSizeY = 720;
		
		setSize(frameSizeX, frameSizeY);
		setLocation((screenX - frameSizeX) / 2 , (screenY - frameSizeY) / 2);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addMouseListener(new MouseAdapter() {
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
