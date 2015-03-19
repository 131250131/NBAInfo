package com.nba.davisUI.ui;

import java.awt.Color;







import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import com.nba.data.Player;
import com.nba.davisUI.myUI.MyPanel;
import com.nba.registerList.RegisterList;
import com.nba.ui.MyTable;

@SuppressWarnings("serial")
public class PlayerTablePanel extends MyPanel{
	
	
	MyTable table;
	
	String[][] data2;
	String[] temp2;
	
	public PlayerTablePanel(){
		
		this.setBounds(0, 0, 1280, 720);
		this.setBackground(Color.WHITE);
		
		/*
		 * 球员名称，所属球队，参赛场数，先发场数，篮板数，助攻数，在
			场时间，投篮命中率，三分命中率，罚球命中率，进攻数，防守数，抢断数，盖
			帽数，失误数，犯规数， 得分，效率， GmSc 效率值，真实命中率，投篮效率，
			篮板率，进攻篮板率，防守篮板率，助攻率，抢断率，盖帽率，失误率，使用率
			传入的数据均要匹配
		 * */
		/*
		 * 
		 * 
		 * */
		String[] temp = {"球员姓名","所属球队","参赛场数","先发场数","篮板数","进攻篮板","防守篮板","助攻数","在场时间"
						,"投篮命中率","三分命中率","罚球命中率","抢断数","盖帽数",
						"失误数","犯规数","球员得分","效率","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率",
						"防守篮板绿","助攻率","抢断绿","盖帽率","失误率","使用率"};
		temp2 = temp;
		data2 = new String[29][];
		table = new MyTable(temp, data2);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(200, 130, 1000, 550);
		jsp.getViewport().setBackground(new Color(0,0,0,0.3f));
		jsp.setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setVisible(true);
		this.add(jsp);
		
		getData();
	}
	
	@SuppressWarnings("unchecked")
	public void getData(){
		
		Object[][] data = new Object[RegisterList.getPlayerNumber()][29];
		
		System.out.println(RegisterList.getPlayerNumber());
		
		int index = 0;
		
		for(int i = 0; i < 26; i++){
			ArrayList<Player> playerList = (ArrayList<Player>) RegisterList.saveList.get(i);
			int size = playerList.size();	
			for(int j = 0; j < size; j++){
				Player tempPlayer = playerList.get(j);
				data[index][0] = tempPlayer.getPlayerName();
				data[index][1] = null;//所属球队
				data[index][2] = tempPlayer.getPlayerAttends();
				data[index][3] = tempPlayer.getPlayerStartTimes();
				data[index][4] = tempPlayer.getPlayerTotalRebounds();
				data[index][5] = tempPlayer.getPlayerOffenceRebounds();
				data[index][6] = tempPlayer.getPlayerDeffenceRebounds();
				data[index][7] = tempPlayer.getPlayerAssists();
				data[index][8] = tempPlayer.getPlayerFGP();
				data[index][9] = tempPlayer.getPlayer3FGP();
				data[index][10] = tempPlayer.getPlayerFTGP();
				data[index][11] = tempPlayer.getPlayerSteals();
				data[index][12] = tempPlayer.getPlayerBlocks();
				data[index][13] = tempPlayer.getPlayerTurnovers();
				data[index][14] = tempPlayer.getPlayerFouls();
				data[index][15] = tempPlayer.getPlayerScores();
				data[index][16] = tempPlayer.getPlayerTotalRebounds();
				data[index][17] = tempPlayer.getPlayerPER();
				data[index][18] = tempPlayer.getPlayerGmScER();
				data[index][19] = tempPlayer.getPlayerTSP();
				data[index][20] = tempPlayer.getPlayerSER();
				data[index][21] = tempPlayer.getRR();
				data[index][22] = tempPlayer.getO_RR();
				data[index][23] = tempPlayer.getD_RR();
				data[index][24] = tempPlayer.getAR();
				data[index][25] = tempPlayer.getSR();
				data[index][26] = tempPlayer.getBR();
				data[index][27] = tempPlayer.getTR();
				data[index][28] = tempPlayer.getUR();
				index++;
			}
		}
		
		table.update(temp2, data);
	}

}
