package ui.frame.index.hotspot;

import ui.system.UIData;

public class HotspotBounds {

	public static int TodayPlayerPanelX = (int) (710 * UIData.changeX);
	public static int TodayPlayerPanelY = (int) (230 * UIData.changeY);
	public static int TodayPlayerPanelWidth = (int) (1150 * UIData.changeX);
	public static int TodayPlayerPanelHeight = (int) (700 * UIData.changeY);
	
	public static int BackPanel1X = 0;
	public static int BackPanel1Y = TodayPlayerPanelY - (int)(20 * UIData.changeY);
	public static int BackPanel1Width = UIData.hotspotBoundsWidth;
	public static int BackPanel1Height = TodayPlayerPanelHeight + 2 * (int)(20 * UIData.changeY);
	
	public static int AllTimePlayerPanelX = TodayPlayerPanelX;
	public static int AllTimePlayerPanelY = TodayPlayerPanelY + TodayPlayerPanelHeight + (int) (70 * UIData.changeY);
	public static int AllTimePlayerPanelWidth = TodayPlayerPanelWidth;
	public static int AllTimePlayerPanelHeight = TodayPlayerPanelHeight;
	
	public static int BackPanel2X = 0;
	public static int BackPanel2Y = AllTimePlayerPanelY - (int)(20 * UIData.changeY);
	public static int BackPanel2Width =  UIData.hotspotBoundsWidth;
	public static int BackPanel2Height = TodayPlayerPanelHeight + 2 * (int)(20 * UIData.changeY);
	
	public static int InfoPanel_TodayX = (int) (80 * UIData.changeX);
	public static int InfoPanel_TodayY = TodayPlayerPanelY;
	public static int InfoPanel_TodayWidth = (int) (580 * UIData.changeX);
	public static int InfoPanel_TodayHeight = (int) (700 * UIData.changeY);
	
	public static int InfoPanel_ALLX = (int) (80 * UIData.changeX);
	public static int InfoPanel_ALLY = AllTimePlayerPanelY;
	public static int InfoPanel_ALLWidth = (int) (580 * UIData.changeX);
	public static int InfoPanel_ALLHeight = (int) (700 * UIData.changeY);
}
