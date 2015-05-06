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
			ArrayList<PlayerVO> playerList;
			switch(itemIndex){
			case 0:
				playerList = Controller.today_Scores;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerScores();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 1:
				playerList = Controller.today_Assists;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerAssists();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 2:
				playerList = Controller.today_rebounds;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerTotalRebounds();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 3:
				playerList = Controller.today_blocks;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerBlocks();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 4:
				playerList = Controller.today_steals;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerSteals();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 5:
				playerList = Controller.today_FP;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerFGP() * 100;
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 6:
				playerList = Controller.today_3FTP;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayer3FGP() * 100;
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 7:
				playerList = Controller.today_FTP;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerFTGP() * 100;
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			}
		}else if(kindIndex == 1){
			
			ArrayList<PlayerVO> playerList;
			
			switch(itemIndex){
			case 0:
				playerList = Controller.all_Scores;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerScores();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 1:
				playerList = Controller.all_Assists;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerAssists();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 2:
				playerList = Controller.all_rebounds;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerTotalRebounds();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 3:
				playerList = Controller.all_blocks;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerBlocks();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 4:
				playerList = Controller.all_steals;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getAver_playerSteals();
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 5:
				playerList = Controller.all_FP;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerFGP() * 100;
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 6:
				playerList = Controller.all_3FTP;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayer3FGP() * 100;
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			case 7:
				playerList = Controller.all_FTP;
				for(int i = 0; i < 5; i++){
					showInfo[i] = playerList.get(i).getPlayerFTGP() * 100;
					playerNames[i] = playerList.get(i).getPlayerName();
				}
				break;
			}
		}else if(kindIndex == 3){
			
			ArrayList<PlayerVO> playerList = null;
			
			switch(itemIndex){
			case 0:
				playerList = Controller.playerController.getAdvancedPlayers("得分");
				break;
			case 1:
				playerList = Controller.playerController.getAdvancedPlayers("助攻");
				break;
			case 2:
				playerList = Controller.playerController.getAdvancedPlayers("篮板");
				break;
			case 3:
				playerList = Controller.playerController.getAdvancedPlayers("盖帽");
				break;
			case 4:
				playerList = Controller.playerController.getAdvancedPlayers("抢断");
				break;
			case 5:
				playerList = Controller.playerController.getAdvancedPlayers("FGP");
				break;
			case 6:
				playerList = Controller.playerController.getAdvancedPlayers("3FGP");
				break;
			case 7:
				playerList = Controller.playerController.getAdvancedPlayers("FTGP");
				break;
			}
			
			for(int i = 0; i < 5; i++){
				showInfo[i] = playerList.get(i).getAdvancedP();
				playerNames[i] = playerList.get(i).getPlayerName();
			}
				
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
			case 5:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_FGP();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getTeamFGP() * 100;
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			case 6:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_3FGP();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getTeam3FGP() * 100;
					playerNames[i] = teamList.get(i).getShortName();
				}
				break;
			case 7:
				teamList = Controller.dataCollectorService.getSeasonHotTeams_FTGP();
				for(int i = 0; i < 5; i++){
					showInfo[i] = teamList.get(i).getTeamFTGP() * 100;
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
					step = 10;break;
				case 4:
					step = 10;break;
				case 5:
					step = 100;break;
				case 6:
					step = 100;break;
				case 7:
					step = 100;break;
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
				case 5:
					step = 100;break;
				case 6:
					step = 100;break;
				case 7:
					step = 100;break;
				}
			
			if(kindIndex == 3)
				switch(itemIndex){
				case 0:
					step = 10;break;
				case 1:
					step = 10;break;
				case 2:
					step = 10;break;
				case 3:
					step = 10;break;
				case 4:
					step = 10;break;
				case 5:
					step = 10;break;
				case 6:
					step = 10;break;
				case 7:
					step = 10;break;
				}
		}else{
			switch(itemIndex){
			case 0:
				step = 120;break;
			case 1:
				step = 30;break;
			case 2:
				step = 50;break;
			case 3:
				step = 10;break;
			case 4:
				step = 10;break;
			case 5:
				step = 100;break;
			case 6:
				step = 100;break;
			case 7:
				step = 100;break;
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

