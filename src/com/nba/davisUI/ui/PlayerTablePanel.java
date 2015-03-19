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
		String[] temp = {"球员姓名","所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间"
						,"投篮命中率","三分命中率","罚球命中率","进攻篮板","防守篮板","抢断数","盖帽数",
						"失误数","犯规数","球员得分","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率",
						"防守篮板绿","助攻率","抢断绿","盖帽率","失误率","使用率"};
		temp2 = temp;
		data2 = new String[28][];
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
		
		Object[][] data = new Object[RegisterList.getPlayerNumber()][28];
		
		System.out.println(RegisterList.getPlayerNumber());
		
		int index = 0;
		
		for(int i = 0; i < 26; i++){
			ArrayList<Player> playerList = (ArrayList<Player>) RegisterList.saveList.get(i);
			int size = playerList.size();	
			for(int j = 0; j < size; j++){
				Player tempPlayer = playerList.get(j);
				data[index][0] = tempPlayer.getPlayerName();
				data[index][1] = tempPlayer.getPlayerScores();
				data[index][2] = tempPlayer.getPlayerFG();
				data[index++][3] = tempPlayer.getPlayerTotalRebounds();
			}
		}
		
		table.update(temp2, data);
	}

}
