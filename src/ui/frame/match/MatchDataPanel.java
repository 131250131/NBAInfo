package ui.frame.match;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.DataTransform;
import ui.system.UIData;
import vo.MatchVO;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class MatchDataPanel extends JPanel{

	private MyTable table;
	private DataOfPlayerPanel players;
	private DataOfMatchPanel thismatch;
	private MatchVO matchData;

	public MatchDataPanel(MatchVO match){
		this.setOpaque(false);
		this.setLayout(null);
		this.setVisible(true);
		
		//各组件
		table = new MyTable();
		players = new DataOfPlayerPanel();
		thismatch = new DataOfMatchPanel();
		JSortTable.makeFace(table.getTable());
		
		thismatch.setLocation((int) (0 * UIData.changeX), (int) (50 * UIData.changeY));
		players.setLocation((int) (400 * UIData.changeX), (int) (50 * UIData.changeY));
		table.setBounds((int) (400 * UIData.changeX), (int) (270 * UIData.changeY), (int) (850 * UIData.changeX), (int) (400 * UIData.changeY));
		
		//单元格值变化事件监控输出球员姓名
        ListSelectionModel cellSelectionModel = table.getJTable().getSelectionModel();  
        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){  
            public void valueChanged(ListSelectionEvent e) {//单元格值变动事件  
            	String s = table.getSign(1);
            	players.update(s);
            }  
        });  
		this.add(thismatch, 0);
		this.add(players, 1);
		this.add(table, 2);
		
		this.update(match);
		thismatch.getTeam1().addMouseListener(new MouseListenerOfteam("left"));
		thismatch.getTeam2().addMouseListener(new MouseListenerOfteam("right"));
		thismatch.getName1().addMouseListener(new MouseListenerOfteam("left"));
		thismatch.getName2().addMouseListener(new MouseListenerOfteam("right"));
		
		mousePress("left");
	}

	/*更新比赛信息*/
	public void update(MatchVO matchData){
		this.matchData = matchData;
		
		thismatch.update(matchData);
	}
	
	private void mousePress(String team){
		ArrayList<PlayerVO> playerlist=null;
		String[] columname = {"姓名", "分钟", "%", "命中", "出手", "三分%"
				, "三分命中", "三分出手", "罚球%", "罚球命中", "罚球出手", "+/-", "进攻"
				, "防守", "篮板", "助攻", "犯规", "抢断", "失误", "盖帽", "得分"};
		System.out.println(matchData.getLeftplayerlist().size());
		//根据左右标志获取左右球队球员信息
		if(team.equals("left")){
			playerlist = matchData.getLeftplayerlist();
		}
		else{
			playerlist = matchData.getRightplayerlist();
		}
		
		Object[][] data = new Object[playerlist.size()][21];
		for(int i = 0; i < playerlist.size(); i++){
			data[i][0] = playerlist.get(i).getPlayerName();
			data[i][1] = playerlist.get(i).getPlayerPlayTime() / 60;
			data[i][2] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayerFGP());
			data[i][3] = playerlist.get(i).getPlayerFG();
			data[i][4] = playerlist.get(i).getPlayerFGTry();
			data[i][5] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayer3FGP());
			data[i][6] = playerlist.get(i).getPlayer3FG();
			data[i][7] = playerlist.get(i).getPlayer3FGTry();
			data[i][8] = DataTransform.transDoubleTopointXX(playerlist.get(i).getPlayerFTGP());
			data[i][9] = playerlist.get(i).getPlayerFTG();
			data[i][10] = playerlist.get(i).getPlayerFTGTry();
			data[i][11] = playerlist.get(i).getPlayerPER();
			data[i][12] = playerlist.get(i).getPlayerOffenceRebounds();
			data[i][13] = playerlist.get(i).getPlayerDeffenceRebounds();
			data[i][14] = playerlist.get(i).getPlayerTotalRebounds();
			data[i][15] = playerlist.get(i).getPlayerAssists();
			data[i][16] = playerlist.get(i).getPlayerFouls();
			data[i][17] = playerlist.get(i).getPlayerSteals();
			data[i][18] = playerlist.get(i).getPlayerTurnovers();
			data[i][19] = playerlist.get(i).getPlayerBlocks();
			data[i][20] = playerlist.get(i).getPlayerScores();
			if(i < 5){
				data[i][0] = data[i][0] + "(先发)";
			}
		}
		table.update(columname, data);
	}
	
	class MouseListenerOfteam implements MouseListener{

		String team="";
		public MouseListenerOfteam(String team){
			this.team = team;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		
		}

		@Override
		public void mousePressed(MouseEvent e) {		
			mousePress(team);		
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}

}
