package ui.frame.player;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import ui.myUI.MyTable;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerDataTable extends JPanel{
	
	PlayerVO player;
	JComboBox<String> comboBox;
	MyTable table;
	
	public PlayerDataTable(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		this.player = player;
		
		initGames();
		table = new MyTable();
		table.setBounds((int) (200 * UIData.changeX), (int) (270 * UIData.changeY), (int) (1050 * UIData.changeX), (int) (400 * UIData.changeY));
		this.add(table);
		table.setVisible(true);
		initData();
	}
	
	ArrayList<PlayerVO> dataArray = new ArrayList<PlayerVO>();
	ArrayList<String> seasonArray;
	
	private void initData(){
		ArrayList<PlayerVO> playerlist = dataArray;
		String[] columname = {"姓名", "赛季","场均上场时间(分钟)", "%", "场均命中", "场均出手", "三分%"
				, "场均三分命中", "场均三分出手", "罚球%", "场均罚球命中", "场均罚球出手", "+/-", "场均进攻篮板"
				, "场均防守篮板", "场均篮板", "场均助攻", "场均犯规", "场均抢断", "场均失误", "场均盖帽", "场均得分"};
	
		Object[][] data = new Object[playerlist.size()][22];
		for(int i = 0; i < playerlist.size(); i++){
			data[i][0] = playerlist.get(i).getPlayerName();
			data[i][1] = playerlist.get(i).getPlayerName();
			data[i][2] = playerlist.get(i).getAver_playerPlayTime();
			data[i][3] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayerFGP() * 100);
			data[i][4] = playerlist.get(i).getAver_playerFG();
			data[i][5] = playerlist.get(i).getAver_playerFGTry();
			data[i][6] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayer3FGP() * 100);
			data[i][7] = playerlist.get(i).getAver_player3FG();
			data[i][8] = playerlist.get(i).getAver_player3FGTry();
			data[i][9] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayerFTGP() * 100);
			data[i][10] = playerlist.get(i).getAver_playerFTG();
			data[i][11] = playerlist.get(i).getAver_playerFTGTry();
			data[i][12] = playerlist.get(i).getPlayerPER();
			data[i][13] = playerlist.get(i).getAver_playerOffenceRebounds();
			data[i][14] = playerlist.get(i).getAver_playerDeffenceRebounds();
			data[i][15] = playerlist.get(i).getAver_playerTotalRebounds();
			data[i][16] = playerlist.get(i).getAver_playerAssists();
			data[i][17] = playerlist.get(i).getAver_playerFouls();
			data[i][18] = playerlist.get(i).getAver_playerSteals();
			data[i][19] = playerlist.get(i).getAver_playerTurnovers();
			data[i][20] = playerlist.get(i).getAver_playerBlocks();
			data[i][21] = playerlist.get(i).getAver_playerScores();
			
			for(int j = 2; j < 22 ; j++){
				data[i][j] = DataTransform.transDoubleTopointXXString((double) data[i][j]);
			}
		}
		table.update(columname, data);
		
	}
	
	private void initGames(){
		String name = player.getPlayerName();
		seasonArray = Controller.playerController.getseasonbyname(name);
		for(int i = 0; i < seasonArray.size(); i++){
			dataArray.add(Controller.playerController.getPlayervobyname(name, seasonArray.get(i)));
		}
	}
	
}
