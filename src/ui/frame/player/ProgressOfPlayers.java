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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jfree.chart.ChartPanel;

import test.TimeSeriesChart;
import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
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
	private tempDataOfPlayerPanel dataOfPlayer;
	private String[] columname={"球员ID","球员姓名","场均出场时间","投篮命中率","场均投篮命中率","场均投篮出手数","三分命中率",
			"场均三分命中数","均三分出手数","罚球命中率","场均罚球命中数","场均罚球出手数","场均篮板数",
			"场均前场篮板数","场均后场篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
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
		dataOfPlayer=new tempDataOfPlayerPanel(2);
		dataOfPlayer.setLocation(10, 25);
		this.add(dataOfPlayer,26);
		//球员表格
		table =new MyTable();
		JSortTable.makeFace(table.getTable());
		table.setBounds(320,410 ,950,280);
		iniTable();
		this.add(table,27);
		//单元格值变化事件监控输出球员姓名
        ListSelectionModel cellSelectionModel = table.getJTable().getSelectionModel();  
        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){  
            public void valueChanged(ListSelectionEvent e) {//单元格值变动事件  
            	String s = table.getSign(2);
            	dataOfPlayer.update(s);
            	System.out.println("come in");
            }  
        });  
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
	void iniTable(){
		PlayerControllerThird p=new PlayerControllerThird();
 	   	ArrayList<PlayerBasicInfoVO> playerlist=p.VOinitial();
		int size = playerlist.size();

		Object[][] data = new Object[size][21];
		for(int i = 0 ; i < size; i++){
			data[i][0] = playerlist.get(i).getPlayerID();
			data[i][1] = playerlist.get(i).getPlayerName();
			data[i][2] = playerlist.get(i).getAtime();
			data[i][3] = playerlist.get(i).getFGP();
			data[i][4] = playerlist.get(i).getAFGZ();
			data[i][5] = playerlist.get(i).getAFG();
			data[i][6] = playerlist.get(i).getSFGP();
			data[i][7] = playerlist.get(i).getASFGZ();
			data[i][8] = playerlist.get(i).getASFG();
			data[i][9] = playerlist.get(i).getFTGP();
			data[i][10] = playerlist.get(i).getAFTGZ();
			data[i][11] = playerlist.get(i).getAFTG();
			data[i][12] = playerlist.get(i).getARebounds();
			data[i][13] = playerlist.get(i).getAORebouns();
			data[i][14] = playerlist.get(i).getADRebounds();
			data[i][15] = playerlist.get(i).getAAssists();
			data[i][16] = playerlist.get(i).getASteals();
			data[i][17] = playerlist.get(i).getABlocks();
			data[i][18] = playerlist.get(i).getATurnovers();
			data[i][19] = playerlist.get(i).getAFeals();
			data[i][20] = playerlist.get(i).getAScores();
		}
		table.update(columname, data);
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
		UIData ui = new UIData(1280, 720);
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
