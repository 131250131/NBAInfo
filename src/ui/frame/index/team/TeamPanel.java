package ui.frame.index.team;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.index.hotspot.HotspotBounds;
import ui.myUI.BackColorPanel;
import ui.system.UIData;

@SuppressWarnings("serial")
public class TeamPanel extends JPanel{

	int x = UIData.teamBoundsX;
	int y = UIData.teamBoundsY;
	int width = UIData.teamBoundsWidth;
	int height = UIData.teamBoundsHeight;
	
	SingleTeamPanel[] singleTeamPanel = new SingleTeamPanel[6];
	
	public TeamPanel(){
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("球队列表");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		initTeamPanel();
		
		BackColorPanel backPanel1 = new BackColorPanel(0,
				(int) (((1280 - 900) / 2 - 20) * UIData.changeY), HotspotBounds.BackPanel1Width, (int) (940 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 5);
		this.add(backPanel);
	}
	
	private void initTeamPanel(){
		//太平洋区 西南区 西北区
		//大西洋区 东南区 中部区
		int panelX = (int) (200 * UIData.changeX);
		int panelXE = (int) (1130 * UIData.changeX);
		int panelY = (int) (210 * UIData.changeY);
		int panelWidth = (int) (600 * UIData.changeX);
		int panelHeight = (int) (260 * UIData.changeY);
		int blank = (int) (40 * UIData.changeY);
		
		for(int i = 0; i < 3; i++){
			singleTeamPanel[i] = new SingleTeamPanel(i);
			singleTeamPanel[i].setBounds(panelX, panelY + (panelHeight + blank) * i, panelWidth, panelHeight);
			singleTeamPanel[i].setVisible(true);
			this.add(singleTeamPanel[i]);
		}
		
		for(int i = 3; i < 6; i++){
			singleTeamPanel[i] = new SingleTeamPanel(i);
			singleTeamPanel[i].setBounds(panelXE, panelY + (panelHeight + blank) * (i - 3), panelWidth, panelHeight);
			singleTeamPanel[i].setVisible(true);
			this.add(singleTeamPanel[i]);
		}
	}
	
}
