package ui.frame.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import test.TimeSeriesChart;
import ui.frame.match.tempDataOfPlayerPanel;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.ChineseTranslator;
import ui.system.Controller;
import ui.system.UIData;
import vo.PlayerVO;

public class ProgressOfPlayers extends JPanel {

	private JComboBox<String> teamName;
	private MyTable table;
	private String[] columname;
	public ProgressOfPlayers(){
		this.setSize(1280, 720);
		this.setLayout(null);
		this.setBackground(Color.black);
		//加字母标签
		char firstC = 'A';
		int firstAS = (int)firstC - 1;
		int x = 320 ;
		int y = 370 ;
		for(int i = 0; i < 26; i++){
			firstAS+=1;
			JLabelOfAlphabet temp = new JLabelOfAlphabet(String.valueOf((char)firstAS));
			temp.setLocation(x + i * 40 , y);
			this.add(temp, i);
		}
		//球员基本信息
		tempDataOfPlayerPanel dataOfPlayer=new tempDataOfPlayerPanel(2);
		dataOfPlayer.setLocation(10, 25);
		this.add(dataOfPlayer,26);
		//球员表格
		table =new MyTable();
		JSortTable.makeFace(table.getTable());
		table.setBounds(320,410 ,950,280);
		this.add(table,27);
		//数据类型下拉框
		String[] teamNames={"选择球队","小牛","掘金","勇士","火箭","快船","湖人","灰熊","灰狼","鹈鹕","拓荒者","雷霆","太阳","国王","马刺","爵士",
				"老鹰","篮网","凯尔特人","黄蜂","公牛","骑士","活塞","步行者","热火","雄鹿","尼克斯","魔术","76人","猛龙","奇才"};
		teamName = new JComboBox<String>(teamNames);
		
//		teamName.addItemListener(new ItemListener(){
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				String shortName = ChineseTranslator.TeamNameTrans(teamName.getSelectedItem().toString());
//				ArrayList<PlayerVO> playerlist = Controller.playerController.getplayerbyteam(shortName);
//				
//				int size = playerlist.size();
//		
//				Object[][] data = new Object[size][7];
//				for(int i = 0 ; i < size; i++){
//					data[i][0] = playerlist.get(i).getPlayerName();
//					data[i][1] = playerlist.get(i).getTeamShortName();
//					if(data[i][1].equals("") || data[i][1].equals(null) || data[i][1] == null){
//						data[i][1] = "自由球员";
//					}else{
//						data[i][1] = ChineseTranslator.TeamNameTrans(playerlist.get(i).getTeamShortName());
//					}
//					data[i][2] = playerlist.get(i).getPosition();
//					data[i][3] = playerlist.get(i).getHeight();
//					data[i][4] = playerlist.get(i).getWeight();
//					data[i][5] = playerlist.get(i).getPlayerAge();
//					data[i][6] = playerlist.get(i).getSchool();
//				}
//				table.update(columname, data);
//			}});
		
		teamName.setFont(new Font("宋体", Font.BOLD, 14));
		teamName.setBounds(320,25,200, 30);
		teamName.setBackground(Color.gray);
		teamName.setForeground(Color.white);
		this.add(teamName, 28);
		//折线图
		 TimeSeriesChart chartest=new TimeSeriesChart();
	  	 ChartPanel test=chartest.getChartPanel();
	  	 test.setBounds(320,70, 950,280);
	  	this.add(test,29);
	}
	/*字母按钮*/
	class JLabelOfAlphabet extends JLabel implements MouseListener{

		public JLabelOfAlphabet(String s){
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setSize(25 ,25 );
			this.setText(s);
			this.setFont(new Font("黑体", Font.BOLD, 20 ));
			this.setForeground(Color.GRAY);
			this.addMouseListener(this);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			//按字母索引查找球员
//			ArrayList<PlayerVO> playerlist = Controller.playerController.getPlayerbyChar(this.getText().toCharArray()[0]);
//			int size = playerlist.size();
//			Object[][] data = new Object[size][7];
//			for(int i = 0; i < size; i++){
//				data[i][0] = playerlist.get(i).getPlayerName();
//				data[i][1] = playerlist.get(i).getTeamShortName();
//				if(data[i][1].equals("") || data[i][1].equals(null) || data[i][1] == null){
//					data[i][1] = "自由球员";
//				}else{
//					data[i][1] = ChineseTranslator.TeamNameTrans(playerlist.get(i).getTeamShortName());
//				}
//				data[i][2] = playerlist.get(i).getPosition();
//				data[i][3] = playerlist.get(i).getHeight();
//				data[i][4] = playerlist.get(i).getWeight();
//				data[i][5] = playerlist.get(i).getPlayerAge();
//				data[i][6] = playerlist.get(i).getSchool();
//			}
//			if(size != 0)
//				table.update(columname, data);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			this.setForeground(Color.white);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			this.setForeground(Color.GRAY);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf=new  JFrame();
		jf.setSize(1280, 720);
		jf.setUndecorated(true);
		jf.setLocation(20, 10);
		ProgressOfPlayers pg=new ProgressOfPlayers();
		pg.setLocation(0, 0);
		jf.add(pg);
		jf.setVisible(true);
		}

}
