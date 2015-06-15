package ui.frame.team;

import java.util.ArrayList;

import javax.swing.JPanel;

import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.UIData;
import vo.TeamVO;

@SuppressWarnings("serial")
public class TeamDataTable extends JPanel{
	
	TeamVO team;
	MyTable table;
	
	public TeamDataTable(int x, int y, int width, int height, TeamVO team){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setOpaque(false);
		this.team = team;
		
		initGames();
		table = new MyTable();
		JSortTable.makeFace(table.getTable());
		
		table.setBounds((int) (0 * UIData.changeX), (int) (30 * UIData.changeY), (int) (width * UIData.changeX), (int) (410 * UIData.changeY));
		table.setVisible(true);
		this.add(table);
		
		initData();
	}

	ArrayList<TeamVO> seasonArray;
	
	private void initData(){
		String[] columname = {"赛季", "%", "场均命中", "场均出手", "三分%"
				, "场均三分命中", "场均三分出手", "罚球%", "场均罚球命中", "场均罚球出手", "场均进攻篮板"
				, "场均防守篮板", "场均篮板", "场均助攻", "场均犯规", "场均抢断", "场均失误", "场均盖帽", "场均得分"};
	
		Object[][] data = new Object[seasonArray.size()][19];
		for(int i = 0; i < seasonArray.size(); i++){
			data[i][0] = seasonArray.get(i).getSeason();
			data[i][1] = seasonArray.get(i).getTeamFGP() * 100;
			data[i][2] = seasonArray.get(i).getTeamFG();
			data[i][3] = seasonArray.get(i).getTeamFGTry();
			data[i][4] = seasonArray.get(i).getTeam3FGP() * 100;
			data[i][5] = seasonArray.get(i).getTeam3FG();
			data[i][6] = seasonArray.get(i).getTeam3FGTry();
			data[i][7] = seasonArray.get(i).getTeamFTGP() * 100;
			data[i][8] = seasonArray.get(i).getTeamFTG();
			data[i][9] = seasonArray.get(i).getTeamFTGTry();
			data[i][10] = seasonArray.get(i).getAver_teamOffenceRebounds();
			data[i][11] = seasonArray.get(i).getAver_teamDeffenceRebounds();
			data[i][12] = seasonArray.get(i).getAver_teamDeffenceRebounds();
			data[i][13] = seasonArray.get(i).getAver_teamAssists();
			data[i][14] = seasonArray.get(i).getAver_teamFouls();
			data[i][15] = seasonArray.get(i).getAver_teamSteals();
			data[i][16] = seasonArray.get(i).getAver_teamTurnovers();
			data[i][17] = seasonArray.get(i).getAver_teamBlocks();
			data[i][18] = seasonArray.get(i).getAver_teamScores();
			
			for(int j = 1; j < 19 ; j++){
				if(j != 2 && j != 3 && j != 5 && j != 6 && j != 8 && j != 9)
					data[i][j] = DataTransform.transDoubleTopointXXString((double)data[i][j]);
			}		
		}
		
		table.update(columname, data);
	}
	
	private void initGames(){
		String name = team.getTeamName();
		seasonArray = Controller.teamController.getTeamHistorySeason(name, 0);
	}
	
}
