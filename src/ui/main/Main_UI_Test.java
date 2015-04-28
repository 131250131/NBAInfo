package ui.main;

import ui.frame.mainframe.MainFrame;
import ui.system.UIData;

public class Main_UI_Test {
	
	public static void main(String[] args) {
		
		int frameSizeX = getFrameSizeX();
		int frameSizeY = getFrameSizeY();
		@SuppressWarnings("unused")
		UIData uiData = new UIData(frameSizeX , frameSizeY);
		UIData.setFavoriteTeam("CLE");
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}
	
	public static int getFrameSizeX(){
		double k = 1;
		double returnValue = 1920 * k;
		return (int) returnValue;
	}
	
	public static int getFrameSizeY(){
		double k = 1;
		double returnValue = 1080 * k;
		return (int) returnValue;
	}

}
