package userInterface.ui.matchUI;

import userInterface.ui.indexUI.IndexBounds;

public class MatchBounds {
	
	//整张比赛画板的位置与大小
	public static int MatchX = IndexBounds.indexButtonFirstX;
	public static int MatchY = IndexBounds.advY + IndexBounds.advSizeY + 20;
	public static int MatchSizeX = 1020;
	public static int MatchSizeY = 600 + 200;
	
	//MatchComboBox的bounds
	public static int MatchComboBoxX = 0;
	public static int MatchComboBoxY = 0;
	public static int MatchComboBoxSizeX = 200;
	public static int MatchComboBoxSizeY = 25;
	
	//TeamComboBox的bounds
	public static int TeamComboBoxX = MatchComboBoxSizeX + 20;
	public static int TeamComboBoxY = MatchComboBoxY;
	public static int TeamComboBoxSizeX = MatchComboBoxSizeX;
	public static int TeamComboBoxSizeY = MatchComboBoxSizeY;
	
	//searchButton的bounds
	public static int searchButtonX = TeamComboBoxX;
	public static int searchButtonY = MatchComboBoxY;
	public static int searchButtonSizeX = MatchComboBoxSizeX;
	public static int searchButtonSizeY = MatchComboBoxSizeY;
	
	//MatchScrollPane的bounds
	public static int scrollPaneX = MatchComboBoxX;
	public static int scrollPaneY = MatchComboBoxY + MatchComboBoxSizeY + 25;
	public static int scrollPaneSizeX = MatchSizeX;
	public static int scrollPaneSizeY = MatchSizeY - scrollPaneY - 200;
	
	//SingelMatchPanel的size
	public static int singleMatchPanelSizeX = scrollPaneSizeX - 25;
	public static int singleMatchPanelSizeY = 160;
	
	//分界线的bounds
	public static int advX = 0; 
	public static int advY = scrollPaneY + scrollPaneSizeY + 40;
	public static int advSizeX = 1050; 
	public static int advSizeY = 25;
}	
