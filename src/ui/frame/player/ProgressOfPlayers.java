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

import thirdVersion.PSpecificdata;
import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
import ui.frame.match.tempDataOfPlayerPanel;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.ChineseTranslator;
import ui.system.UIData;
import Utibility.DataType;

public class ProgressOfPlayers extends JPanel {

	private JComboBox<String> dataComb;
	private MyTable table;
	private tempDataOfPlayerPanel dataOfPlayer;
	private TimeSeriesChart chartest;
	private String[] dataName={"选择数据类型","出场次数","首发场数","平均时间","命中率","平均投篮命中数",
			"平均投篮出手数","三分命中率","平均三分命中数","平均三分出手数",
			"平均罚球命中率","平均罚球命中数","平均罚球数","平均篮板","平均球场篮板","平均后场篮板",
			"平均助攻","平均抢断","平均盖帽","平均失误","平均犯规","平均得分","参加比赛球队胜场","参加比赛球队负场",
			"总时间","总投篮命中","总投篮出手","总三分命中","总三分出手","总罚球命中","总罚球出手"
			,"总篮板","总前场板","总后场板","总助攻","总抢断","总盖帽","总失误","总犯规",
			"总得分","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率"
			,"失误率","使用率(上场率)","进攻率","防守率","效率","投篮距离","篮下命中率","篮下命中数"
			,"篮下出手数","篮下出手比例","近距离投篮命中率","近距离投篮命中数","近距离投篮数","近距离投篮比例","中距离投篮命中率","中距离投篮命中数"
			,"中距离投篮出手数","中距离投篮比例","远距离投篮命中率","远距离投篮命中数","远距离投篮出手数","远距离投篮比例","真实命中率","投篮效率"
			,"最高出场时间","最高命中率","最高命中数","最高出手数","最高三分命中率","最高三分命中","最高三分出手","最高罚球命中率"
			,"最高罚球命中","最高罚球数","最高篮板","最高前场板","最高后场板","最高助攻","最高抢断","最高篮板"
			,"最高失误","最高犯规","最高得分","年薪（万元）"};
	private DataType[] dataType={ 
			DataType.attendmatches,//出场次数
			DataType.First,//首发场数
			DataType.Atime,//平均时间
			DataType. FGP,//命中率
			DataType.AFGZ ,//平均投篮命中数
			DataType.AFG ,//平均投篮出手数
			DataType.SFGP ,//三分命中率
			DataType.ASFGZ ,//平均三分命中数
			DataType.ASFG ,//平均三分出手数
			DataType.FTGP ,//平均罚球命中率
			DataType.AFTGZ ,//平均罚球命中数
			DataType.AFTG ,//平均罚球数
			DataType.ARebounds ,//平均篮板
			DataType.AORebouns ,//平均球场篮板
			DataType.ADRebounds ,//平均后场篮板
			DataType.AAssists ,//平均助攻
			DataType.ASteals ,//平均抢断
			DataType.ABlocks ,//平均盖帽
			DataType.ATurnovers ,//平均失误
			DataType.AFouls ,//平均犯规
			DataType.AScores ,//平均得分
	       
			DataType.Win ,//参加比赛球队胜场
			DataType.Lose ,//参加比赛球队负场
	        
	        /*
	         * Total
	         */
			DataType.Ttime ,//总时间
			DataType.TFGZ ,//总投篮命中
			DataType.TFG ,//总投篮出手
			DataType.TSFGZ ,//总三分命中
			DataType.TSFG ,//总三分出手
			DataType.TFTGZ ,//总罚球命中
			DataType.TFTG ,//总罚球出手
			DataType.TRebounds ,//总篮板
			DataType.TORebouns ,//总前场板
			DataType.TDRebounds ,//总后场板
			DataType.TAssists ,//总助攻
			DataType.TSteals ,//总抢断
			DataType.TBlocks ,//总盖帽
			DataType.TTurnovers ,//总失误
			DataType.TFouls ,//总犯规
			DataType.TScores ,//总得分
	        
	        /*
	         * Advanced data
	         */
			DataType.RR ,//篮板率
			DataType.O_RR ,//进攻篮板率
			DataType.D_RR ,//防守篮板率
			DataType.AR ,//助攻率
			DataType. SR ,//抢断率
			DataType.BR ,//盖帽率
			DataType.TR ,//失误率
			DataType.UseRate ,//使用率(上场率)
			DataType.OR ,//进攻率
			DataType.DR ,//防守率
			DataType.PER ,//效率
			DataType.ShootDistance ,//投篮距离
	        
			DataType.LXFGP ,//篮下命中率
			DataType.LXFGZ ,//篮下命中数
			DataType.LXFG ,//篮下出手数
			DataType.LXFGRate ,//篮下出手比例
	        
			DataType.JJLFGP ,//近距离投篮命中率
			DataType.JJLFGZ ,//近距离投篮命中数
			DataType.JJLFG ,//近距离投篮数
			DataType.JJLFGRate ,//近距离投篮比例
	        
			DataType.ZJLFGP ,//中距离投篮命中率
			DataType.ZJLFGZ ,//中距离投篮命中数
			DataType.ZJLFG ,//中距离投篮出手数
			DataType.ZJLFGRate ,//中距离投篮比例
	        
			DataType.YJLFGP ,//远距离投篮命中率
			DataType.YJLFGZ ,//远距离投篮命中数
			DataType.YJLFG ,//远距离投篮出手数
			DataType.YJLFGRate ,//远距离投篮比例
	        
			DataType.RealShootRate ,//真实命中率
			DataType.S_RR ,//投篮效率
	        
	        /*
	         * High data
	         */
			DataType.Htime ,//最高出场时间
			DataType. HFGP ,//最高命中率
			DataType. HFGZ ,////最高命中数
			DataType.HFG ,//最高出手数
			DataType.HSFGP ,//最高三分命中率
			DataType.HSFGZ ,//最高三分命中
			DataType.HSFG ,//最高三分出手
			DataType.HFTGP ,//最高罚球命中率
			DataType.HFTGZ ,//最高罚球命中
			DataType.HFTG ,//最高罚球数
			DataType.HRebounds ,//最高篮板
			DataType. HORebouns ,//最高前场板
			DataType.HDRebounds ,//最高后场板
			DataType.HAssists ,//最高助攻
			DataType.HSteals ,//最高抢断
			DataType.HBlocks ,//最高篮板
			DataType.HTurnovers ,//最高失误
			DataType.HFouls ,//最高犯规
			DataType.HScores ,//最高得分
			DataType.salary//年薪 单位是万美元 界面加一下吧 这边传给你前面的数字
	             };
	private String[] columname={"球员ID","球员姓名","场均出场时间","投篮命中率","场均投篮命中率","场均投篮出手数","三分命中率",
			"场均三分命中数","均三分出手数","罚球命中率","场均罚球命中数","场均罚球出手数","场均篮板数",
			"场均前场篮板数","场均后场篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	private PlayerControllerThird p=new PlayerControllerThird();//逻辑层接口
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
            }  
        });  
		//数据类型下拉框
		
        dataComb = new JComboBox<String>(dataName);
		
        dataComb.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String dataName=dataComb.getSelectedItem().toString();
				String playerID= dataOfPlayer.getID();
				if(!dataName.equals("选择数据类型")&&!playerID.equals("-1")){
					DataType type = translate(dataName);
					
					ArrayList<PSpecificdata> normalList=p.getnormalplayerdata(playerID, type);
					ArrayList<PSpecificdata> playoffList=p.getplayoffplayerdata(playerID, type);
					
					int size1=normalList.size();
					int size2=playoffList.size();
					System.out.println("常规赛"+size1+"_"+"季后赛"+size2);
					int[] year1=new int[size1];
					double[] data1 = new double[size1];
					int[] year2=new int[size2];
					double[] data2=new double[size2];
					for(int i=0;i<normalList.size();i++){
						//数据
						data1[i]=normalList.get(i).getData();
						//赛季换算
						int temp=Integer.parseInt(normalList.get(i).getSeason().split("-")[0]);
						if(temp>=15){
							temp+=1900;
						}
						else{
							temp+=2000;
						}
						//赛季
						year1[i]=temp;
						System.out.print(year1[i]+"-"+data1[i]+";");
					}
					for(int i=0;i<playoffList.size();i++){
						//数据
						data2[i]=playoffList.get(i).getData();
						//赛季换算
						int temp=Integer.parseInt(playoffList.get(i).getSeason().split("-")[0]);
						if(temp>=15){
							temp+=1900;
						}
						else{
							temp+=2000;
						}
						//赛季
						year2[i]=temp;
					}
					
					chartest.update(dataName, year1, data1, year2, data2);
				}
				
			}});
		
        dataComb.setFont(new Font("宋体", Font.BOLD, 14));
        dataComb.setBounds(320,25,200, 30);
        dataComb.setBackground(Color.gray);
        dataComb.setForeground(Color.white);
		this.add(dataComb, 28);
		//折线图
		chartest=new TimeSeriesChart();
	  	 ChartPanel test=chartest.getChartPanel();
	  	 test.setBounds(320,70, 950,280);
	  	this.add(test,29);
	  	
	  	System.out.println(dataName.length+"____"+dataType.length);
	}
	void iniTable(){
		
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
	/*转换成枚举类*/
	DataType translate(String s){
		for(int i=1 ;i<dataName.length;i++){
			if(s.equals(dataName[i])){
				return dataType[i-1];
			}
		}
		return null;
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
			ArrayList<PlayerBasicInfoVO> playerlist = p.getPlayersbyChar(this.getText().toCharArray()[0]);
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
			if(size != 0)
			table.update(columname, data);
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
