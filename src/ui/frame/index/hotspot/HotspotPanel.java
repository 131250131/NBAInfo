package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.BackColorPanel;
import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
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
		
		ImageLabel backgroundPic = new ImageLabel(ImageSaver.getIcon("热点球员背景"), HotspotBounds.rankingPanelX
				, HotspotBounds.rankingPanelY + HotspotBounds.HotspotRankY, HotspotBounds.rankingPanelWidth, HotspotBounds.rankingPanelHeight);
		this.add(backgroundPic);
		
		BackColorPanel backPanel1 = new BackColorPanel(HotspotBounds.BackPanel1X,
				HotspotBounds.BackPanel1Y, HotspotBounds.BackPanel1Width, HotspotBounds.BackPanel1Height, 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel2 = new BackColorPanel(HotspotBounds.BackPanel2X,
				HotspotBounds.BackPanel2Y, HotspotBounds.BackPanel2Width, HotspotBounds.BackPanel2Height, 0);
		this.add(backPanel2);
		
		JLabel text = new JLabel("TOP 5 - 数据王");
		text.setVisible(true);
		text.setBounds((int)(85 * UIData.changeX), HotspotBounds.BackPanel3Y + (int)(2 * UIData.changeY), (int)(300 * UIData.changeX), (int)(40 * UIData.changeY));
		text.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		text.setForeground(Color.ORANGE);
		this.add(text);

		BackColorPanel backPanel3 = new BackColorPanel(HotspotBounds.BackPanel3X,
				HotspotBounds.BackPanel3Y, HotspotBounds.BackPanel3Width, HotspotBounds.BackPanel3Height, 0);
		this.add(backPanel3);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 2);
		this.add(backPanel);
	}

}
