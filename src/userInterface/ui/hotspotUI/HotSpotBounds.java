package userInterface.ui.hotspotUI;

import userInterface.ui.indexUI.IndexBounds;
import userInterface.ui.matchUI.MatchBounds;

public class HotSpotBounds {
	
	//整张比赛画板的位置与大小
	public static int panelX = IndexBounds.indexButtonFirstX;
	public static int panelY =  IndexBounds.advY + IndexBounds.advSizeY + 20 + MatchBounds.advY + MatchBounds.advSizeY + 20;
	public static int panelSizeX = 1020;
	public static int panelSizeY = 600 + 200;
	
	//comboBox1的位置与大小
	public static int comboBox1X = 0;
	public static int comboBox1Y = 0;
	public static int comboBoxSize1X = 200;
	public static int comboBoxSize1Y= 25;
	
	//comboBox2的位置与大小
	public static int comboBox2X = comboBox1X + comboBoxSize1X + 20;
	public static int comboBox2Y = comboBox1Y;
	public static int comboBoxSize2X = comboBoxSize1X;
	public static int comboBoxSize2Y= comboBoxSize1Y;
	
	//searchButton的bounds
	public static int searchButtonX = comboBox2X + comboBoxSize2X + 20;
	public static int searchButtonY = comboBox1Y;
	public static int searchButtonSizeX = comboBoxSize1X;
	public static int searchButtonSizeY = comboBoxSize1Y;
	
	//standingPanel的bounds
	public static int standingPanelX = comboBox1X;
	public static int standingPanelY = comboBox1Y + comboBoxSize1Y + 20;
	public static int standingPanelSizeX = 1010;
	public static int standingPanelSizeY = 580;
	
	//分界线的bounds
	public static int advX = 0; 
	public static int advY = standingPanelY + standingPanelSizeY + 40;
	public static int advSizeX = 1050; 
	public static int advSizeY = 25;

}
