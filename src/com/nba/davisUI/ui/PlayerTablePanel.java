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
		
		String[] temp = {"球员姓名","球员得分","球员出手数","球员篮板"};
		temp2 = temp;
		data2 = new String[4][];
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
		
		Object[][] data = new Object[RegisterList.getPlayerNumber()][4];
		
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
