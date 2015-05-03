package ui.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import ui.frame.mainframe.MainFrame;
import ui.system.Controller;
import ui.system.UIData;

public class Main_UI_Test {
	
	public static void main(String[] args) {
		
		int frameSizeX = getFrameSizeX();
		int frameSizeY = getFrameSizeY();
		
//		int frameSizeX = getFullScreenSizeX();
//		int frameSizeY = getFullScreenSizeY();
		
		@SuppressWarnings("unused")
		UIData uiData = new UIData(frameSizeX , frameSizeY);
		UIData.setFavoriteTeam("CLE");
		
		//初始化后端
		Controller.init();	
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		
	}
	
	public static int getFrameSizeX(){
		double k = 0.67;
		double returnValue = 1920 * k;
		return (int) returnValue;
	}
	
	public static int getFrameSizeY(){
		double k = 0.67;
		double returnValue = 1080 * k;
		return (int) returnValue;
	}
	
	public static int getFullScreenSizeX(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		return screensize.width;
	}
	
	public static int getFullScreenSizeY(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		return screensize.height;
	}

}
