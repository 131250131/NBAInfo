package ui.frame.index.hotspot;

import javax.swing.JPanel;

import ui.myUI.BackColorPanel;
import ui.system.UIData;

@SuppressWarnings("serial")
public class HotspotPanel extends JPanel{
	
	int x = UIData.hotspotBoundsX;
	int y = UIData.hotspotBoundsY;
	int width = UIData.hotspotBoundsWidth;
	int height = UIData.hotspotBoundsHeight;
	
	public HotspotPanel(){
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setVisible(true);
		
		HotspotRankPanel hotspotRankPanel = new HotspotRankPanel();
		this.add(hotspotRankPanel);

		InfoPanel_All infoAll = new InfoPanel_All();
		this.add(infoAll);
		
		InfoPanel_Today infoToday = new InfoPanel_Today();
		this.add(infoToday);
		
		TodayPlayerPanel todayPlayerPanel = new TodayPlayerPanel();
		this.add(todayPlayerPanel);
		
		AllTimePlayerPanel allTimePlayerPanel = new AllTimePlayerPanel();
		this.add(allTimePlayerPanel);
		
		BackColorPanel backPanel1 = new BackColorPanel(HotspotBounds.BackPanel1X,
				HotspotBounds.BackPanel1Y, HotspotBounds.BackPanel1Width, HotspotBounds.BackPanel1Height, 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel2 = new BackColorPanel(HotspotBounds.BackPanel2X,
				HotspotBounds.BackPanel2Y, HotspotBounds.BackPanel2Width, HotspotBounds.BackPanel2Height, 0);
		this.add(backPanel2);

		BackColorPanel backPanel3 = new BackColorPanel(HotspotBounds.BackPanel3X,
				HotspotBounds.BackPanel3Y, HotspotBounds.BackPanel3Width, HotspotBounds.BackPanel3Height, 0);
		this.add(backPanel3);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 2);
		this.add(backPanel);
	}

}
