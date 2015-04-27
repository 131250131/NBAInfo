package userInterface.ui.matchUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vo.MatchVO;
import vo.PlayerVO;

public class MatchDataPanel extends JPanel {

	private MyTable table;
	private DataOfPlayerPanel players;
	private DataOfMatchPanel thismatch;
	private MatchVO matchData;
	public MatchDataPanel(){
		this.setBounds(0, 0, 1280, 720);
		this.setBackground(Color.black);
		this.setLayout(null);
		
		//各组件
		table = new MyTable();
		players=new DataOfPlayerPanel();
		thismatch=new DataOfMatchPanel();
		JSortTable.makeFace(table.getTable());
		
		thismatch.setLocation(0, 50);
		players.setLocation(400, 50);
		table.setBounds(400,270, 850, 400);
		
		//监控
		thismatch.getTeam1().addMouseListener(new MouseListenerOfteam("left"));
		thismatch.getTeam2().addMouseListener(new MouseListenerOfteam("right"));
		thismatch.getName1().addMouseListener(new MouseListenerOfteam("left"));
		thismatch.getName2().addMouseListener(new MouseListenerOfteam("right"));
		table.addKeyListener((KeyListener) new MyActionListener());
		this.add(thismatch,0);
		this.add(players,1);
		this.add(table,2);
	}
	/*更新比赛信息*/
	public void update(MatchVO matchData){
		this.matchData=matchData;
		thismatch.update(matchData);
	}
	class MouseListenerOfteam implements MouseListener{

		String team="";
		public MouseListenerOfteam(String team){
			this.team=team;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			ArrayList<PlayerVO> playerlist=null;
			String[] columname={"姓名","位置","分钟","%","命中","出手","三分%"
					,"三分命中","三分出手","罚球%","罚球命中","罚球出手","+/-","进攻"
					,"防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
			//根据左右标志获取左右球队球员信息
			if(team.equals("left")){
				playerlist=matchData.getLeftplayerlist();
			}
			else{
				playerlist=matchData.getRightplayerlist();
			}
			
			Object[][] data=new Object[playerlist.size()][22];
			for(int i=0;i<playerlist.size();i++){
				data[i][0]=playerlist.get(i).getPlayerName();
				data[i][1]=playerlist.get(i).getPosition();
				data[i][2]=playerlist.get(i).getPlayerPlayTime();
				data[i][3]=playerlist.get(i).getPlayerFGP();
				data[i][4]=playerlist.get(i).getPlayerFG();
				data[i][5]=playerlist.get(i).getPlayerFGTry();
				data[i][6]=playerlist.get(i).getPlayer3FGP();
				data[i][7]=playerlist.get(i).getPlayer3FG();
				data[i][8]=playerlist.get(i).getPlayer3FGTry();
				data[i][9]=playerlist.get(i).getPlayerFTGP();
				data[i][10]=playerlist.get(i).getPlayerFTG();
				data[i][11]=playerlist.get(i).getPlayerFTGTry();
				data[i][12]=playerlist.get(i).getRR();
				data[i][13]=playerlist.get(i).getPlayerOffenceRebounds();
				data[i][14]=playerlist.get(i).getPlayerDeffenceRebounds();
				data[i][15]=playerlist.get(i).getPlayerTotalRebounds();
				data[i][16]=playerlist.get(i).getPlayerAssists();
				data[i][17]=playerlist.get(i).getPlayerFouls();
				data[i][18]=playerlist.get(i).getPlayerSteals();
				data[i][19]=playerlist.get(i).getPlayerTurnovers();
				data[i][20]=playerlist.get(i).getPlayerBlocks();
				data[i][21]=playerlist.get(i).getPlayerScores();
			}
			table.update(columname, data);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(table.getSign(1));
		}
		
	}
	public static void main(String[] args) {
		JFrame test=new JFrame();
		test.setUndecorated(true);
		test.setBounds(20, 20, 1280, 720);
		test.setLayout(null);
		test.add(new MatchDataPanel());
		
		test.setVisible(true);
	}
}
