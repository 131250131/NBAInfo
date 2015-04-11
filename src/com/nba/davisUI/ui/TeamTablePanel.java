package com.nba.davisUI.ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.nba.data.Team;
import com.nba.davisUI.myUI.ImageBin;
import com.nba.davisUI.myUI.MyPanel;
import com.nba.davisUI.ui.PlayerTablePanel.MouseListenerOfRe;
import com.nba.registerList.RegisterList;
import com.nba.ui.JSortTable;
import com.nba.ui.MyTable;

@SuppressWarnings("serial")
public class TeamTablePanel extends MyPanel{
	
		MyTable table;
	
		String[][] data2;
		String[] temp2;
		private JLabel re;
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
			
			String[] temp ={ "序号","球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数",
					"三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数",
					"抢断数","盖帽数","失误数","犯规数","比赛得分", "投篮命中率","三分命中率",
					"罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助功率"};
			temp2 = temp;
			data2 = new String[30][];
			table = new MyTable(temp, data2);
			
			
			table.setBounds(200, 130, 1000, 550);
			table.setVisible(true);
			
			//背景
			JLabel bg=new JLabel();
			bg.setIcon(ImageBin.getImage("bgOfPlayer"));
			bg.setBounds(0, 0, 1280, 720);
			//返回
			re=new JLabel();
			re.setBounds(20, 335, 50, 50);
			re.addMouseListener(new MouseListenerOfRe());
			
			this.add(table,0);
			this.add(re,1);
			this.add(bg,2);
			
			getData();
			JSortTable.makeFace(table.getTable());
			
		}
		
		class MouseListenerOfRe implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				MainFrame.returnFromPlayerTablePanel.doClick();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				re.setIcon(ImageBin.getImage("return"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				re.setIcon(new ImageIcon());
			}
			
		}
		private void getData(){
			Object[][] data = new Object[30][28];
			
			System.out.println(RegisterList.getPlayerNumber());
			
			int index = 0;
			int sequence=0;
			
			@SuppressWarnings("unchecked")
			ArrayList<Team> teamList = (ArrayList<Team>) RegisterList.saveList.get(26);
			int size =teamList.size();	
			for(int i=0;i < size;i++){
				Team tempTeam = teamList.get(i);
				/*
				 * "球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数",
					"三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数",
					"抢断数","盖帽数","失误数","犯规数","比赛得分", "投篮命中率","三分命中率",
					"罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助功率"
				 * */
				sequence++;
				data[index][0] = sequence;
				data[index][1] = tempTeam.getTeamShortName();
				data[index][2] = tempTeam.getTeamGames();
				data[index][3] = tempTeam.getteamFG();
				data[index][4] = tempTeam.getTeamFGTry();
				data[index][5] = tempTeam.getTeam3FG();
				data[index][6] = tempTeam.getTeam3FGTry();
				data[index][7] = tempTeam.getTeamFTG();
				data[index][8] = tempTeam.getTeamFTGTry();
				data[index][9] = tempTeam.getTeamOffenceRebounds();
				data[index][10] = tempTeam.getTeamDeffenceRebounds();
				data[index][11] = tempTeam.getTeamAllRebounds();
				data[index][12] = tempTeam.getTeamAssists();
				data[index][13] = tempTeam.getTeamSteals();
				data[index][14] = tempTeam.getTeamBlocks();
				data[index][15] = tempTeam.getTeamTurnovers();
				data[index][16] = tempTeam.getTeamFouls();
				data[index][17] = tempTeam.getTeamScores();
				data[index][18] = tempTeam.getTeamFGP();
				data[index][19] = tempTeam.getTeam3FGP();
				data[index][20] = tempTeam.getTeamFTGP();
				data[index][21] = tempTeam.getWinRate();
				data[index][22] = tempTeam.getTeamAttackRounds();
				data[index][23] = tempTeam.getTeamOffE();
				data[index][24] = tempTeam.getTeamDefE();
				data[index][25] = tempTeam.getTeamRebE();
				data[index][26] = tempTeam.getTeamSteE();
				data[index][27] = tempTeam.getTeamAssE();
				index++;
			}
			table.update(temp2, data);
		}
		
		
		
}
