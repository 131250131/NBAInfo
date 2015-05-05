package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.Controller;
import ui.system.UIData;
import vo.PlayerVO;
import vo.TeamVO;

@SuppressWarnings("serial")
public class RankingPanel extends JPanel implements ActionListener{
	
	int x = HotspotBounds.rankingPanelX;
	int y = HotspotBounds.rankingPanelY;
	int width = HotspotBounds.rankingPanelWidth;
	int height = HotspotBounds.rankingPanelHeight;
	
	JLabel panelBack;
	SinglePanel[] singlePanel = new SinglePanel[5];
	StepLabel[] stepLabel = new StepLabel[5];
	
	public static JButton update;
	
	public RankingPanel(){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		//this.setOpaque(false);
		this.setLayout(null);	
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.9f));
		
		int step = width / 6;
		
		for(int i = 0; i < 5; i++){
			stepLabel[i] = new StepLabel();
			stepLabel[i].setLocation((int)(20 * UIData.changeX + step * (i + 1)), (int)(20 * UIData.changeY));
			this.add(stepLabel[i]);
		}
		
		for(int i = 0; i < 5; i++){
			singlePanel[i] = new SinglePanel(i);
			this.add(singlePanel[i]);
		}
		
		update = new JButton();
		update.addActionListener(this);
		this.add(update);
		updateStanding(0, 0);
	}
	

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == update){
			updateStanding(HotspotRankPanel.index1, HotspotRankPanel.index2);
		}
	}
	
	double[] showInfo = new double[5];
	String[] playerNames = new String[5];
	
	private void updateStanding(int kindIndex, int itemIndex){
		int step = getStep(kindIndex, itemIndex);	
		getPlayerList(kindIndex, itemIndex);
		
		int flag = 0;
		if(kindIndex == 2)
			flag = 1;
		
		for(int i = 0; i < 5; i++){
			stepLabel[i].setText(transToTwoNum(step * (5 - i)));
			singlePanel[i].updatePanel(showInfo[i], step, playerNames[i], flag);
		}
	}
	
	private String transToTwoNum(int num){                                                                                                   
		if(num < 10){
			return "0" + String.valueOf(num);
		}
		return String.valueOf(num);
	}
	
	private void getPlayerList(int kindIndex, int itemIndex){
			
		if(kindIndex == 0){
			String date = Controller.dateList.get(Controller.dateList.size() - 1);
			ArrayList<PlayerVO> playerList;
			
			switch(itemIndex){
			case 0:
				playerList = Controller.dataCollectorService.getSomeDayPlayers_Score(date);
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerScores();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 1:
				playerList = Controller.dataCollectorService.getSomeDayPlayers_Assist(date);
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerAssists();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 2:
				playerList = Controller.dataCollectorService.getSomeDayPlayers_Rebound(date);
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerTotalRebounds();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 3:
				playerList = Controller.dataCollectorService.getSomeDayPlayers_Block(date);
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerBlocks();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 4:
				playerList = Controller.dataCollectorService.getSomeDayPlayers_Steal(date);
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerSteals();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			}
		}else if(kindIndex == 1){
			
			ArrayList<PlayerVO> playerList;
			
			switch(itemIndex){
			case 0:
				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Score();
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerScores();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 1:
				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Assist();
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerAssists();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 2:
				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Rebound();
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerTotalRebounds();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 3:
				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Block();
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerBlocks();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 4:
				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Steal();
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerSteals();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			}
		}else if(kindIndex == 3){
//			
//			ArrayList<PlayerVO> playerList;
//			
//			switch(itemIndex){
//			case 0:
//				playerList = Controller.dataCollectorService.;
//				for(int i = 0; i < 5; i++){
//					showInfo[i] = playerList.get(i).getPlayerScores();
//					playerNames[i] = playerList.get(i).getPlayerName();
//				}
//				break;
//			case 1:
//				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Assist();
//				for(int i = 0; i < 5; i++){
//					showInfo[i] = playerList.get(i).getPlayerAssists();
//					playerNames[i] = playerList.get(i).getPlayerName();
//				}
//				break;
//			case 2:
//				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Rebound();
//				for(int i = 0; i < 5; i++){
//					showInfo[i] = playerList.get(i).getPlayerTotalRebounds();
//					playerNames[i] = playerList.get(i).getPlayerName();
//				}
//				break;
//			case 3:
//				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Block();
//				for(int i = 0; i < 5; i++){
//					showInfo[i] = playerList.get(i).getPlayerBlocks();
//					playerNames[i] = playerList.get(i).getPlayerName();
//				}
//				break;
//			case 4:
//				playerList = Controller.dataCollectorService.getSeasonHotPlayers_Steal();
//				for(int i = 0; i < 5; i++){
//					showInfo[i] = playerList.get(i).getPlayerSteals();
//					playerNames[i] = playerList.get(i).getPlayerName();
//				}
//				break;
//			}
		}else{			
			ArrayList<TeamVO> teamList;
			
			switch(itemIndex){
			case 0:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_Score();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getAver_teamScores();
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			case 1:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_Assist();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getAver_teamAssists();
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			case 2:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_Rebound();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getAver_teamTotalRebounds();
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			case 3:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_Block();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getAver_teamBlocks();
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			case 4:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_Steal();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getAver_teamSteals();
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			}
		}
	}
	
	private int getStep(int kindIndex, int itemIndex){
		
		int step = 0;
		
		if(kindIndex != 2){
			if(kindIndex == 0)
				switch(itemIndex){
				case 0:
					step = 50;break;
				case 1:
					step = 20;break;
				case 2:
					step = 20;break;
				case 3:
					step = 15;break;
				case 4:
					step = 15;break;
				}	
			
			if(kindIndex == 1)
				switch(itemIndex){
				case 0:
					step = 40;break;
				case 1:
					step = 15;break;
				case 2:
					step = 15;break;
				case 3:
					step = 5;break;
				case 4:
					step = 5;break;
				}
		}else{
			switch(itemIndex){
			case 0:
				step = 120;break;
			case 1:
				step = 30;break;
			case 2:
				step = 40;break;
			case 3:
				step = 15;break;
			case 4:
				step = 15;break;
			}
			
		}
		return step / 5;
	}

	class StepLabel extends JLabel{
		
		public StepLabel(){
			this.setSize((int)(200 * UIData.changeX), (int)(50 * UIData.changeY));
			this.setVisible(true);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("OCR A Std", Font.PLAIN, (int)(30 * UIData.changeY)));
		}
	}
}

