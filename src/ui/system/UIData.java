package ui.system;

import java.awt.Dimension;
import java.awt.Toolkit;

import ui.frame.index.homepage.HomepageBounds;

public class UIData {
	
	/*
	 * type 1, FrameSize:1920_1080
	 * type 2, FrameSize:1280_720
	 */
	
	public static int fwidth, fheight;
	
	public UIData(int width, int height){
			
			frameWidth = width;
			frameHeight = height;
			changeX = (frameWidth + 0.0) / 1920;
			changeY = (frameHeight + 0.0) / 1080;
			fwidth =  (int) (frameWidth + 0 * changeX);
			fheight = (int) (frameHeight + 0 * changeY);
			init();
	}
	
	public static double changeX;
	public static double changeY;
		
	private void init(){		
		setFrameLoction();
		setLargerBounds();
		setIndexBoardBounds();
		setIndexScrollPaneBounds();
		setIndexPanelBounds();
		setHomepagePanelBounds();
		setHotspotPanelBounds();
		setMatchPanelBounds();
		
		@SuppressWarnings("unused")
		HomepageBounds homepageBounds = new HomepageBounds();
	}
	
	private void setFrameLoction(){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int)screensize.getWidth();
		int screenHeight = (int)screensize.getHeight();
		
		frameX = (screenWidth - frameWidth) /2;
		frameY = (screenHeight - frameHeight) /2;
	}
	
	public static int slideSize;
	
	private void setLargerBounds(){
		largerScrollPaneX = 0;
		largerScrollPaneY = 0;
		slideSize = (int) (1650 * changeX);
		largerScrollPaneWidth = fwidth;
		largerScrollPaneHeight = fheight;
		largerPanelWidth = frameWidth + slideSize * 2;
		largerPanelHeight = frameHeight - 10;
	}
	
	private void setIndexScrollPaneBounds(){
		indexScrollPaneX = slideSize * 2;
		indexScrollPaneY = 0;
		indexScrollPaneWidth = frameWidth;
		indexScrollPaneHeight = frameHeight;
	}
	
	private void setIndexPanelBounds(){
		indexPanelWidth = indexScrollPaneWidth - 20;
		indexPanelHeight = frameHeight * 6;
	}
	
	private void setHomepagePanelBounds(){
		homepagePanelX = 0;
		homepagePanelY = 0;
		homepagePanelWidth = indexPanelWidth;
		homepagePanelHeight = frameHeight;
	}
	
	private void setIndexBoardBounds(){
		indexBoardX = slideSize * 2;
		indexBoardY = 0;
		indexBoardWidth = (int) (175 * changeX);
		indexBoardHeight = frameHeight;
	}
	
	private void setHotspotPanelBounds(){
		hotspotBoundsX = 0;
		hotspotBoundsY = (int) (frameHeight);
		hotspotBoundsWidth = indexPanelWidth;
		hotspotBoundsHeight = (int)((3000 - 170) * changeY);
	}
	
	public void setMatchPanelBounds(){
		matchBoundsX = 0;
		matchBoundsY = hotspotBoundsY + hotspotBoundsHeight;
		matchBoundsWidth = indexPanelWidth;
		matchBoundsHeight = (int)(1080 * changeY);
	}
	
	//frame
	public static int frameX;
	public static int frameY;
	public static int frameWidth;
	public static int frameHeight;
	
	//larger
	public static int largerScrollPaneX;
	public static int largerScrollPaneY;
	public static int largerScrollPaneWidth;
	public static int largerScrollPaneHeight;
	public static int largerPanelWidth;
	public static int largerPanelHeight;
	
	//index
	public static int indexScrollPaneX;
	public static int indexScrollPaneY;
	public static int indexScrollPaneWidth;
	public static int indexScrollPaneHeight;	
	public static int indexPanelWidth;
	public static int indexPanelHeight;
	public static int homepagePanelX;
	public static int homepagePanelY;
	public static int homepagePanelWidth;
	public static int homepagePanelHeight;
	public static int indexBoardX;
	public static int indexBoardY;
	public static int indexBoardWidth;
	public static int indexBoardHeight;
	public static int hotspotBoundsX;
	public static int hotspotBoundsY;
	public static int hotspotBoundsWidth;
	public static int hotspotBoundsHeight;
	public static int matchBoundsX;
	public static int matchBoundsY;
	public static int matchBoundsWidth;
	public static int matchBoundsHeight;

}
