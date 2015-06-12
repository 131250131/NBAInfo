package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.BackColorPanel;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;

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
		
		JLabel title = new JLabel("热点信息");
		title.setBounds((int) (185 * UIData.changeX), (int) (165 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		HotspotRankPanel hotspotRankPanel = new HotspotRankPanel();
		this.add(hotspotRankPanel);
	
		PlayerVO todayPlayer = getTodayPlayer();
		PlayerVO allPlayer = getAllPlayer();			
			
		InfoPanel_Today infoToday = new InfoPanel_Today(todayPlayer);
		this.add(infoToday);
		
		TodayPlayerPanel todayPlayerPanel = new TodayPlayerPanel(todayPlayer);
		this.add(todayPlayerPanel);
		
		InfoPanel_All infoAll = new InfoPanel_All(allPlayer);
		this.add(infoAll);
		
		AllTimePlayerPanel allTimePlayerPanel = new AllTimePlayerPanel(allPlayer);
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
		
		JLabel text = new JLabel("TOP 5 ：14-15赛季数据王");
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
	
	private PlayerVO getTodayPlayer(){
		return Controller.playerController.getPlayervobyname("Stephen Curry", "14-15");
	}
	
	private PlayerVO getAllPlayer(){
		return Controller.playerController.getPlayervobyname("Anthony Davis", "14-15");
	}

}
