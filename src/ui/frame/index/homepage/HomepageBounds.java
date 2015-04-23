package ui.frame.index.homepage;

import ui.system.UIData;

public class HomepageBounds {
	
	public static int BackImageX = 0;
	public static int BackImageY = 180;
	public static int BackImageWidth = UIData.homepagePanelWidth;
	public static int BackImageHeight = 720;
	
	public HomepageBounds(){
			BackImageY = (int) (BackImageY * UIData.changeY);
			BackImageX = (int) (BackImageX * UIData.changeX);
			BackImageHeight = (int) (BackImageHeight * UIData.changeY);
	}

}
