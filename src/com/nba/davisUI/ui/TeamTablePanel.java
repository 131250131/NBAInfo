package com.nba.davisUI.ui;

import java.awt.Color;
import java.util.ArrayList;

import com.main.Team;
import com.nba.davisUI.myUI.MyPanel;
import com.nba.registerList.RegisterList;
import com.nba.ui.MyTable;

public class TeamTablePanel extends MyPanel{
	
		MyTable table;
	
		String[][] data2;
		String[] temp2;
		
		public TeamTablePanel(){
			this.setBounds(0, 0, 1280, 720);
			this.setBackground(Color.WHITE);
			
			/*
			 * 球队的属性列表
			 * 球队名称，比赛场数，投篮命中数，投篮出手次数，三分命中数，
			三分出手数，罚球命中数，罚球出手数，进攻篮板数，防守篮板数，篮板数，助
			攻数，抢断数，盖帽数，失误数，犯规数，比赛得分， 投篮命中率，三分命中率，
			罚球命中率，胜率，进攻回合，进攻效率，防守效率，篮板效率，抢断效率，助
			攻率
			 * 
			 * */
			
			String[] temp ={ "球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数，",
					"三分出手数","罚球命中数，","罚球出手数，","进攻篮板数，","防守篮板数，","篮板数，","助攻数，",
					"抢断数","盖帽数，","失误数，","犯规数，","比赛得分，", "投篮命中率，","三分命中率，",
					"罚球命中率","胜率","进攻回合，","进攻效率，","防守效率，","篮板效率，","抢断效率，","助功率"};
			temp2 = temp;
			data2 = new String[29][];
			table = new MyTable(temp, data2);
			
			table.setBounds(200, 130, 1000, 550);
			table.setVisible(true);
			this.add(table);
			
			getData();
			
		}
		
		private void getData(){
			Object[][] data = new Object[30][30];
			
			System.out.println(RegisterList.getPlayerNumber());
			
			int index = 0;
			
			ArrayList<Team> teamList = (ArrayList<Team>) RegisterList.saveList.get(26);
			int size =teamList.size();	
			for(int i=0;i < size;i++){
				Team tempTeam = teamList.get(i);
				
			}
			table.update(temp2, data);
		}
		
		
		
}
