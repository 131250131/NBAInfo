package ui.frame.team;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ui.frame.match.DataOfPlayerPanel;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.UIData;
import vo.PlayerVO;
import vo.TeamVO;

@SuppressWarnings("serial")
public class TeamList extends JPanel{

	private MyTable table;
	private DataOfPlayerPanel players;

	public TeamList(TeamVO team){
		this.setOpaque(false);
		this.setLayout(null);
		this.setVisible(true);
		
		//各组件
		table = new MyTable();
		players = new DataOfPlayerPanel();
		JSortTable.makeFace(table.getTable());
		
		players.setLocation((int) (200 * UIData.changeX), (int) (50 * UIData.changeY));
		table.setBounds((int) (200 * UIData.changeX), (int) (270 * UIData.changeY), (int) (1050 * UIData.changeX), (int) (400 * UIData.changeY));
		
		//单元格值变化事件监控输出球员姓名
        ListSelectionModel cellSelectionModel = table.getJTable().getSelectionModel();  
        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){  
            public void valueChanged(ListSelectionEvent e) {//单元格值变动事件  
            	String s = table.getSign(1);
            	players.update(s);
            }  
        });  
	
		this.add(players);
		this.add(table);
		
		update(team);
	}

	private void update(TeamVO team){
		ArrayList<PlayerVO> playerlist=null;
		String[] columname = {"姓名", "场均上场时间(分钟)", "%", "场均命中", "场均出手", "三分%"
				, "场均三分命中", "场均三分出手", "罚球%", "场均罚球命中", "场均罚球出手", "+/-", "场均进攻篮板"
				, "场均防守篮板", "场均篮板", "场均助攻", "场均犯规", "场均抢断", "场均失误", "场均盖帽", "场均得分"};
	
		playerlist = Controller.playerController.getplayerbyteam(team.getShortName());
	
		Object[][] data = new Object[playerlist.size()][21];
		for(int i = 0; i < playerlist.size(); i++){
			data[i][0] = playerlist.get(i).getPlayerName();
			data[i][1] = playerlist.get(i).getAver_playerPlayTime() / 60;
			data[i][2] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayerFGP() * 100);
			data[i][3] = playerlist.get(i).getAver_playerFG();
			data[i][4] = playerlist.get(i).getAver_playerFGTry();
			data[i][5] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayer3FGP() * 100);
			data[i][6] = playerlist.get(i).getAver_player3FG();
			data[i][7] = playerlist.get(i).getAver_player3FGTry();
			data[i][8] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayerFTGP() * 100);
			data[i][9] = playerlist.get(i).getAver_playerFTG();
			data[i][10] = playerlist.get(i).getAver_playerFTGTry();
			data[i][11] = playerlist.get(i).getPlayerPER();
			data[i][12] = playerlist.get(i).getAver_playerOffenceRebounds();
			data[i][13] = playerlist.get(i).getAver_playerDeffenceRebounds();
			data[i][14] = playerlist.get(i).getAver_playerTotalRebounds();
			data[i][15] = playerlist.get(i).getAver_playerAssists();
			data[i][16] = playerlist.get(i).getAver_playerFouls();
			data[i][17] = playerlist.get(i).getAver_playerSteals();
			data[i][18] = playerlist.get(i).getAver_playerTurnovers();
			data[i][19] = playerlist.get(i).getAver_playerBlocks();
			data[i][20] = playerlist.get(i).getAver_playerScores();
			
			for(int j = 1; j < 21 ; j++){
				data[i][j] = DataTransform.transDoubleTopointXXString((double) data[i][j]);
			}
		}
		table.update(columname, data);
		
	}
}

