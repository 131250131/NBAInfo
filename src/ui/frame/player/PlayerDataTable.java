package ui.frame.player;

import java.util.ArrayList;

import javax.swing.JPanel;

import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerDataTable extends JPanel{
	
	PlayerVO player;
	MyTable table, table2;
	
	public PlayerDataTable(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setOpaque(false);
		this.player = player;
		
		initGames();
		table = new MyTable();
		JSortTable.makeFace(table.getTable());
		table2 = new MyTable();
		JSortTable.makeFace(table2.getTable());
		
		table.setBounds((int) (0 * UIData.changeX), (int) (60 * UIData.changeY), (int) (width * UIData.changeX), (int) (230 * UIData.changeY));
		table.setVisible(true);
		this.add(table);
		
		table2.setBounds((int) (0 * UIData.changeX), (int) ((60 + 230 + 40) * UIData.changeY), (int) (width * UIData.changeX), (int) (230 * UIData.changeY));
		table2.setVisible(true);
		this.add(table2);
		
		initData();
	}
	
	ArrayList<PlayerVO> dataArray = new ArrayList<PlayerVO>();
	ArrayList<String> seasonArray;
	
	private void initData(){
		ArrayList<PlayerVO> playerlist = dataArray;
		String[] columname = {"赛季","场均上场时间(分钟)", "%", "场均命中", "场均出手", "三分%"
				, "场均三分命中", "场均三分出手", "罚球%", "场均罚球命中", "场均罚球出手", "+/-", "场均进攻篮板"
				, "场均防守篮板", "场均篮板", "场均助攻", "场均犯规", "场均抢断", "场均失误", "场均盖帽", "场均得分"};
	
		Object[][] data = new Object[playerlist.size()][22];
		for(int i = 0; i < playerlist.size(); i++){
			data[i][0] = seasonArray.get(i);
			data[i][1] = playerlist.get(i).getAver_playerPlayTime();
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
		
		String[] columname2 = {"赛季", "效力球队", "效率", "真实命中率", "投篮效率", "篮板率", "助攻率", "抢断率", "盖帽率",
				"失误率", "使用率", "进攻篮板率", "防守篮板率"};
		Object[][] data2 = new Object[playerlist.size()][13];
		for(int i = 0; i < playerlist.size(); i++){
			data2[i][0] = seasonArray.get(i);
			data2[i][1] = playerlist.get(i).getTeamname();
			data2[i][2] = playerlist.get(i).getPlayerPER();
			data2[i][3] = playerlist.get(i).getPlayerTSP();
			data2[i][4] = playerlist.get(i).getPlayerSER();
			data2[i][5] = playerlist.get(i).getRR();
			data2[i][6] = playerlist.get(i).getAR();
			data2[i][7] = playerlist.get(i).getSR();
			data2[i][8] = playerlist.get(i).getBR();
			data2[i][9] = playerlist.get(i).getTR();
			data2[i][10] = playerlist.get(i).getUR();
			data2[i][11] = playerlist.get(i).getO_RR();
			data2[i][12] = playerlist.get(i).getD_RR();
		}
		
		table.update(columname, data);
		table2.update(columname2, data2);
	}
	
	private void initGames(){
		String name = player.getPlayerName();
		seasonArray = Controller.playerController.getseasonbyname(name);
		for(int i = 0; i < seasonArray.size(); i++){
			dataArray.add(Controller.playerController.getPlayervobyname(name, seasonArray.get(i)));
		}
	}
	
}
