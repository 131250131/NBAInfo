package ui.myUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ui.frame.match.DataOfPlayerPanel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;



@SuppressWarnings("serial")
public class PlayerTablePanel extends MyPanel{
	
	
	private MyTable table;
	private DataOfPlayerPanel players;
	private String[][] data2;
	private String[] temp2;
	
	public PlayerTablePanel(){
		Controller.init();
		this.setBounds(0, 0, 1280, 720);
		this.setBackground(Color.BLACK);
		
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
		String[] temp = {"球员姓名","所属球队","参赛场数","先发场数","篮板数","进攻篮板","防守篮板","助攻数","场均出场时间"
						,"投篮命中率","三分命中率","罚球命中率","抢断数","盖帽数",
						"失误数","犯规数","球员得分","效率","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率",
						"防守篮板率","助攻率","抢断绿","盖帽率","失误率","使用率","两双次数"};
		temp2 = temp;
		data2 = new String[30][];
		table = new MyTable();
		
		//背景
//		JLabel bg=new JLabel();
//		
//		bg.setBounds(0, 0, 1280, 720);
		
		//筛选板
		JPanel filtrate=new JPfiltrate();
		filtrate.setBounds(350,40, 870, 100);
		
		players = new DataOfPlayerPanel();
		players.setLocation(350,150);
		
		table.setBounds(350,350, 870, 300);
		table.setVisible(true);
		
		//单元格值变化事件监控输出球员姓名
        ListSelectionModel cellSelectionModel = table.getJTable().getSelectionModel();  
        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){  
            public void valueChanged(ListSelectionEvent e) {//单元格值变动事件  
            	String s = table.getSign(1);
            	players.update(s);
            }  
        });  
        
		this.add(table,0);
		this.add(filtrate,1);
		this.add(players,2);
		
		getData();
		JSortTable.makeFace(table.getTable());
	}
	/*筛选板块*/
	class JPfiltrate extends JPanel{
		private JComboBox positionCb;
		private JComboBox distributionCb;
		private JComboBox infoTypeCb;
		private JTextField value1=new JTextField(5);
		private JTextField value2=new JTextField(5);
		private JLabel position=new JLabel("位置");
		private JLabel distribution=new JLabel("分区");
		private JLabel infoType=new JLabel("数据");
//		private JLabel to=new JLabel("—",JLabel.CENTER);
		private JLabel scan=new JLabel(ImageSaver.getIcon("scan"));
		
		public String[] getCondition(){
			String[] condition={positionCb.getSelectedItem().toString(),
					distributionCb.getSelectedItem().toString(),
					infoTypeCb.getSelectedItem().toString()};
			return condition;
			
		}
		public JPfiltrate(){
			this.setLayout(null);
			//设置面板透明
			this.setOpaque(false);
			//设置标签字体
			position.setFont(new Font("宋体",Font.BOLD,14));
			distribution.setFont(new Font("宋体",Font.BOLD,14));
			infoType.setFont(new Font("宋体",Font.BOLD,14));
//			to.setFont(new Font("宋体",Font.BOLD,14));
			//设置字体颜色
			position.setForeground(Color.white);
			distribution.setForeground(Color.white);
			infoType.setForeground(Color.white);
//			to.setForeground(Color.white);
			//设置标签大小位置
			position.setBounds(0, 30, 40, 20);
			distribution.setBounds(240, 30, 40, 20);
			infoType.setBounds(480, 30, 40, 20);
//			to.setBounds(730, 30, 20, 20);
			
			//搜索按钮
			scan.setBounds(840, 28, 24, 24);
			scan.addMouseListener(new MouseListenerForScan());
			
			String[] positions={"","前锋","中锋","后卫"};
			positionCb = new JComboBox(positions);
			positionCb.setFont(new Font("宋体",Font.BOLD,14));
			positionCb.setBounds(40,30,150,20);
			positionCb.setBackground(Color.gray);
			positionCb.setForeground(Color.white);
			
			String[] distributions={"","东部","西部","太平洋区","西南区","东南区","大西洋区","中央区","西北区"};
			distributionCb = new JComboBox(distributions);
			distributionCb.setFont(new Font("宋体",Font.BOLD,14));
			distributionCb.setBounds(280,30, 150, 20);
			distributionCb.setBackground(Color.gray);
			distributionCb.setForeground(Color.white);
			
			String[] infoTypes={"","得分","篮板","助攻","得分/篮板/助攻","盖帽","抢断","犯规","失误","分钟","效率","投篮","三分","罚球","两双"};
			infoTypeCb = new JComboBox(infoTypes);
			infoTypeCb.setFont(new Font("宋体",Font.BOLD,14));
			infoTypeCb.setBounds(520,30, 150, 20);
			infoTypeCb.setBackground(Color.gray);
			infoTypeCb.setForeground(Color.white);
//			position.addKeyListener(KeyFindStrategy);
			
//			value1.setBounds(680,30, 50, 20);
//			value1.setOpaque(false);//文本框透明
//			value1.setForeground(Color.white);//前景色
//			value1.setCaretColor(Color.white);
//			
//			value2.setBounds(750,30, 50, 20);
//			value2.setOpaque(false);//文本框透明
//			value2.setForeground(Color.white);//前景色
//			value2.setCaretColor(Color.white);
			
			this.add(position,0);
			this.add(distribution,1);
			this.add(infoType,2);
			this.add(positionCb,3);
			this.add(distributionCb,4);
			this.add(infoTypeCb,5);
//			this.add(value1,6);
//			this.add(value2,7);
//			this.add(to,6);
			this.add(scan,6);
		}
		/*搜索按钮的监控*/
		class MouseListenerForScan implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				//根据已经输入的条件判断并进行筛选球员
				String[] condition=JPfiltrate.this.getCondition();
				if(condition[0].equals("")&&condition[1].equals("")&&condition[2].equals("")){
//					MainFrame.warnbt.showWarning("筛选条件不能为空");
				}
				else{
					ArrayList<PlayerVO> tempPlayers=Controller.playerController.getSelectedPlayers(condition[0], condition[1], condition[2]);
					
					Object[][] data= new Object[tempPlayers.size()][30];
					for(int index=0;index<tempPlayers.size();index++){
						PlayerVO tempPlayer = tempPlayers.get(index);
						data[index][0] = tempPlayer.getPlayerName();
						data[index][1] = tempPlayer.getTeamShortName();//所属球队
						data[index][2] = tempPlayer.getPlayerAttends();
						data[index][3] = tempPlayer.getStartTimes();
						data[index][4] = tempPlayer.getPlayerTotalRebounds();
						data[index][5] = tempPlayer.getPlayerOffenceRebounds();
						data[index][6] = tempPlayer.getPlayerDeffenceRebounds();
						data[index][7] = tempPlayer.getPlayerAssists();
						data[index][8] = tempPlayer.getPlayerPlayTime();
						data[index][9] = tempPlayer.getPlayerFGP();
						data[index][10] = tempPlayer.getPlayer3FGP();
						data[index][11] = tempPlayer.getPlayerFTGP();
						data[index][12] = tempPlayer.getPlayerSteals();
						data[index][13] = tempPlayer.getPlayerBlocks();
						data[index][14] = tempPlayer.getPlayerTurnovers();
						data[index][15] = tempPlayer.getPlayerFouls();
						data[index][16] = tempPlayer.getPlayerScores();
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
						data[index][29] = tempPlayer.getdouble_double();
					}	
					
					Object[][] data2=new Object[50][];
					System.out.println(data.length);
					if(data.length>50){
				    	for(int i=0;i<50;i++){
				    		data2[i]=data[i];
//				    		data2[i][0]=i;
				    	}
				    	table.update(temp2, data2);
				    }
					else if(data.length==0){
//						MainFrame.warnbt.showWarning("未搜索到符合条件的结果");
						table.update(temp2, new Object[][]{});
					}
					else{
						table.update(temp2, data);
					}
				}
				
				
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
	}
	
	@SuppressWarnings("unchecked")
	public void getData(){
		
		Object[][] data = new Object[Controller.playerController.getAllPlayerVO().size()][30];
		
		//System.out.println(RegisterList.getPlayerNumber());
		
		int index = 0;
		
			ArrayList<PlayerVO> playerList = Controller.playerController.getAllPlayerVO();
			int size = playerList.size();	
			for(int j = 0; j < size; j++){
				PlayerVO tempPlayer = playerList.get(j);
				data[index][0] = tempPlayer.getPlayerName();
				data[index][1] = tempPlayer.getTeamShortName();//所属球队
				data[index][2] = tempPlayer.getPlayerAttends();
				data[index][3] = tempPlayer.getStartTimes();
				data[index][4] = tempPlayer.getPlayerTotalRebounds();
				data[index][5] = tempPlayer.getPlayerOffenceRebounds();
				data[index][6] = tempPlayer.getPlayerDeffenceRebounds();
				data[index][7] = tempPlayer.getPlayerAssists();
				data[index][8] = tempPlayer.getPlayerPlayTime();
				data[index][9] = tempPlayer.getPlayerFGP();
				data[index][10] = tempPlayer.getPlayer3FGP();
				data[index][11] = tempPlayer.getPlayerFTGP();
				data[index][12] = tempPlayer.getPlayerSteals();
				data[index][13] = tempPlayer.getPlayerBlocks();
				data[index][14] = tempPlayer.getPlayerTurnovers();
				data[index][15] = tempPlayer.getPlayerFouls();
				data[index][16] = tempPlayer.getPlayerScores();
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
				data[index][29] = tempPlayer.getdouble_double();
				index++;
			}
		table.update(temp2, data);
	}
	public static void main(String[] args){
		UIData ui = new UIData(1280, 720);
		JFrame test=new JFrame();
		test.setSize(1280, 720);
		test.setUndecorated(true);
		test.add(new PlayerTablePanel());
		test.setLocation(50, 50);
		test.setVisible(true);
	}
}