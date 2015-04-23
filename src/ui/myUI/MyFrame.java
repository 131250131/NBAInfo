package ui.myUI;

import javax.swing.JFrame;

import ui.system.UIData;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setSize(UIData.fwidth, UIData.fheight);
		setLocation(UIData.frameX, UIData.frameY);
		
		setResizable(false);
		setUndecorated(true);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
