package ui.frame.index.rank;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.index.hotspot.HotspotBounds;
import ui.myUI.BackColorPanel;
import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class RankPanel extends JPanel{
	
	int x = UIData.rankingBoundsX;
	int y = UIData.rankingBoundsY;
	int width = UIData.rankingBoundsWidth;
	int height = UIData.rankingBoundsHeight;
	
	SingleRankPanel[] singleRankPanelW = new SingleRankPanel[15];
	SingleRankPanel[] singleRankPanelE = new SingleRankPanel[15];
	
	public RankPanel(){
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setVisible(true);
		
		initLabel();
		
		JLabel title = new JLabel("战绩排名");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		BackColorPanel backPanel1 = new BackColorPanel(0,
				(int) (((1280 - 900) / 2 - 20) * UIData.changeY), HotspotBounds.BackPanel1Width, (int) (940 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 4);
		this.add(backPanel);
	}
	
	private void initLabel(){
		
		int westX = (int) (370 * UIData.changeX);
		int eastX = (int) (1100 * UIData.changeX);
		int westY = (int) (200 * UIData.changeY);
		int labelWidth = (int) (450 * UIData.changeX);
		int labelHeight = (int) (60 * UIData.changeX);
		
		for(int i = 0; i < 15; i++){
			singleRankPanelW[i] = new SingleRankPanel(getTeamName("W", i), i, "W", westX, westY + labelHeight * i, labelWidth, labelHeight);
			this.add(singleRankPanelW[i]);
		}
		
		for(int i = 0; i < 15; i++){
			singleRankPanelE[i] = new SingleRankPanel(getTeamName("E", i), i, "E", eastX, westY + labelHeight * i, labelWidth, labelHeight);
			this.add(singleRankPanelE[i]);
		}
	}
	
	private String getTeamName(String WestOrEast, int rank){
		String teamName = null;
		if(WestOrEast.equals("W")){
			switch(rank){
			case 0:	
				teamName = "DAL";
				break;
			case 1:	
				teamName = "DEN";
				break;
			case 2:	
				teamName = "GSW";
				break;	
			case 3:	
				teamName = "HOU";
				break;	
			case 4:	
				teamName = "LAC";
				break;	
			case 5:	
				teamName = "LAL";
				break;	
			case 6:	
				teamName = "MEM";
				break;	
			case 7:	
				teamName = "MIN";
				break;
			case 8:	
				teamName = "NOP";
				break;
			case 9:	
				teamName = "POR";
				break;
			case 10:	
				teamName = "OKC";
				break;
			case 11:	
				teamName = "PHX";
				break;
			case 12:	
				teamName = "SAC";
				break;
			case 13:	
				teamName = "SAS";
				break;
			case 14:	
				teamName = "UTA";
				break;
			
			
			}
		}else{
			switch(rank){
			case 0:
				teamName = "ATL";
				break;
			case 1:	
				teamName = "BKN";
				break;
			case 2:	
				teamName = "BOS";
				break;
			case 3:	
				teamName = "CHA";
				break;
			case 4:	
				teamName = "CHI";
				break;
			case 5:	
				teamName = "CLE";
				break;
			case 6:	
				teamName = "DET";
				break;
			case 7:	
				teamName = "IND";
				break;
			case 8:	
				teamName = "MIA";
				break;
			case 9:	
				teamName = "MIL";
				break;
			case 10:	
				teamName = "NYK";
				break;
			case 11:	
				teamName = "ORL";
				break;
			case 12:	
				teamName = "PHI";
				break;
			case 13:	
				teamName = "TOR";
				break;
			case 14:	
				teamName = "WAS";
				break;
			}
			
		}
		
		return teamName;
	}

}
