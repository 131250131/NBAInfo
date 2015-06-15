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

import thirdVersion.MathCalculator;
import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
import thirdVersion.PlayerdatainfoVO;
import thirdservice.playerControllerThirdService;
import ui.frame.match.tempDataOfPlayerPanel;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.UIData;

public class ComparePlayer extends JPanel {

	private tempDataOfPlayerPanel Player1;
	private tempDataOfPlayerPanel Player2;
	private MyTable table;
	private BarChart barChart;
	private JPanel barPanel;
	private JComboBox<String> seasonComb;
	private JComboBox<String> dataCategory;
	private String[] dataCategoryNames={"选择数据种类","进攻数据","防守数据","效率数据"};
	private String[] seasons={"选择赛季"};
	private boolean isLeft=true;
	private int count=0;
	private String[] Odata={"投篮命中率","三分命中率","罚球命中率","前场篮板","助攻","得分"};
	private String[] Ddata={"后场篮板","抢断","盖帽","犯规"};
	private String[] Edata={"篮板率","助攻率","抢断率","盖帽率","失误率","命中率"};
	
	private String[] columname={"球员ID","球员姓名","场均出场时间","投篮命中率","场均投篮命中率","场均投篮出手数","三分命中率",
			"场均三分命中数","均三分出手数","罚球命中率","场均罚球命中数","场均罚球出手数","场均篮板数",
			"场均前场篮板数","场均后场篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	private playerControllerThirdService controllerForPlayer=new PlayerControllerThird();//逻辑层接口
	
	
	public ComparePlayer(){
		this.setSize(1280, 720);
		this.setLayout(null);
		this.setBackground(Color.black);
		//加字母标签
		char firstC = 'A';
		int firstAS = (int)firstC - 1;
		int x = 320 ;
		int y = 340 ;
		for(int i = 0; i < 26; i++){
			if(i==13){
				x=320;
				y=370;
			}
			firstAS+=1;
			JLabelOfAlphabet temp = new JLabelOfAlphabet(String.valueOf((char)firstAS));
			x+=40;
			temp.setLocation(x, y);
			this.add(temp, i);
		}
		//球员1基本信息
		Player1=new tempDataOfPlayerPanel(2);
		Player1.setLocation(10, 25);
		this.add(Player1,0);
		//球员2基本信息
		Player2=new tempDataOfPlayerPanel(2);
		Player2.setLocation(970, 25);
		this.add(Player2,1);
		//球员表格
		table =new MyTable();
		JSortTable.makeFace(table.getTable());
		table.setBounds(320,400 ,640,290);
		iniTable();
		this.add(table,2);
		
		//单元格值变化事件监控输出球员姓名
        ListSelectionModel cellSelectionModel = table.getJTable().getSelectionModel();  
        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){  
            public void valueChanged(ListSelectionEvent e) {//单元格值变动事件  
            	//交替在左右显示选中的球员
            	count++;
            	System.out.println(count);
            	if(isLeft){
            		String s = controllerForPlayer.getEnglishName(table.getSign(1));
                	Player1.update(s);
            	}
            	else{
            		String s = controllerForPlayer.getEnglishName(table.getSign(1));
                	Player2.update(s);
            	}
            	if(count%2==0){
            		isLeft=!isLeft;
            		count=0;
            	}
            	String id1=Player1.getID();
            	String id2=Player2.getID();
            	if(!id1.equals("-1")&&!id2.equals("-1")){
            		//更新赛季
                	seasonComb.removeAllItems();
                	seasonComb.addItem("选择赛季");
                	ArrayList<String> list=controllerForPlayer.getthesameeason(id1, id2);
                	System.out.println("打过"+list.size());
                	for(int i=0;i<list.size();i++){
                		seasonComb.addItem(list.get(i));
                	}
            	}
            	
            	doCompare();
            }  
        });  
        
    	//柱状图面板
        barPanel=new JPanel();
	  	barPanel.setLayout(null);
	  	barPanel.setOpaque(false);
	  	barPanel.setBounds(320, 25,640, 310);
	  	this.add(barPanel,3);
		//数据类型下拉框
        dataCategory = new JComboBox<String>(dataCategoryNames);
        dataCategory.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				doCompare();
			}
			
        });
        dataCategory.setFont(new Font("宋体", Font.BOLD, 14));
        dataCategory.setBounds(0,0,200, 30);
        dataCategory.setBackground(Color.gray);
        dataCategory.setForeground(Color.white);
        barPanel.add(dataCategory,0);
        
        seasonComb = new JComboBox<String>(seasons);
        seasonComb.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				doCompare();
			}
			
        });
        seasonComb.setFont(new Font("宋体", Font.BOLD, 14));
        seasonComb.setBounds(220,0,200, 30);
        seasonComb.setBackground(Color.gray);
        seasonComb.setForeground(Color.white);
        barPanel.add(seasonComb,1);
        //柱状图
        barChart=new BarChart();
	 	ChartPanel chart=barChart.getChartPanel();
	 	chart.setBounds(0,45, 640,265);
	 	barPanel.add(chart,2);
	}
	void iniTable(){
		
 	   	ArrayList<PlayerBasicInfoVO> playerlist=controllerForPlayer.VOinitial();
		int size = playerlist.size();

		Object[][] data = new Object[size][21];
		for(int i = 0 ; i < size; i++){
			data[i][0] = playerlist.get(i).getPlayerID();
			data[i][1] = playerlist.get(i).getChinesename();
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
	
	void doCompare(){
		if(seasonComb.getSelectedItem()!=null&&dataCategory.getSelectedItem()!=null){
			String season=seasonComb.getSelectedItem().toString();
			String category=dataCategory.getSelectedItem().toString();
			String ID1=Player1.getID();
			String ID2=Player2.getID();
			
			if(!ID1.equals("-1")&&!ID2.equals("-1")
					&&!season.equals("选择赛季")&&!category.equals("选择数据种类")){
				
				PlayerdatainfoVO player1=controllerForPlayer.getPlayervobyid(ID1, season);
				PlayerdatainfoVO player2=controllerForPlayer.getPlayervobyid(ID2, season);
				String[] players={player1.getChinesenname(),player2.getChinesenname()};
				
				if(category.equals("进攻数据")){
					
					double[] data1=new double[Odata.length];
					double[] data2=new double[Odata.length];
				
					
					data1[0]=MathCalculator.change(player1.getFGP());
					data1[1]=MathCalculator.change(player1.getSFGP());
					data1[2]=MathCalculator.change(player1.getFTGP());
					data1[3]=MathCalculator.change(player1.getAORebouns());//平均进攻篮板
					data1[4]=MathCalculator.change(player1.getAAssists());//平均助攻
					data1[5]=MathCalculator.change(player1.getAScores());//平均得分
					
					data2[0]=MathCalculator.change(player2.getFGP());
					data2[1]=MathCalculator.change(player2.getSFGP());
					data2[2]=MathCalculator.change(player2.getFTGP());
					data2[3]=MathCalculator.change(player2.getAORebouns());//平均进攻篮板
					data2[4]=MathCalculator.change(player2.getAAssists());//平均助攻
					data2[5]=MathCalculator.change(player2.getAScores());//平均得分
					
					barChart.update(players, Odata, data1, data2);
				}
				else if(category.equals("防守数据")){
					double[] data1=new double[Ddata.length];
					double[] data2=new double[Ddata.length];
				
					
					data1[0]=MathCalculator.change(player1.getADRebounds());
					data1[1]=MathCalculator.change(player1.getASteals());
					data1[2]=MathCalculator.change(player1.getABlocks());
					data1[3]=MathCalculator.change(player1.getAFeals());
					
					data2[0]=MathCalculator.change(player2.getADRebounds());
					data2[1]=MathCalculator.change(player2.getASteals());
					data2[2]=MathCalculator.change(player2.getABlocks());
					data2[3]=MathCalculator.change(player2.getAFeals());
					
					barChart.update(players, Ddata, data1, data2);
				}
				else if(category.equals("效率数据")){
					double[] data1=new double[Edata.length];
					double[] data2=new double[Edata.length];
				
					
					data1[0]=MathCalculator.change(player1.getRR());
					data1[1]=MathCalculator.change(player1.getAR());
					data1[2]=MathCalculator.change(player1.getSR());
					data1[3]=MathCalculator.change(player1.getBR());
					data1[4]=MathCalculator.change(player1.getTR());
					data1[5]=MathCalculator.change(player1.getRealShootRate());

					data2[0]=MathCalculator.change(player2.getRR());
					data2[1]=MathCalculator.change(player2.getAR());
					data2[2]=MathCalculator.change(player2.getSR());
					data2[3]=MathCalculator.change(player2.getBR());
					data2[4]=MathCalculator.change(player2.getTR());
					data2[5]=MathCalculator.change(player2.getRealShootRate());
					
					barChart.update(players, Edata, data1, data2);
				}
			}
		}
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
			ArrayList<PlayerBasicInfoVO> playerlist = controllerForPlayer.getPlayersbyChar(this.getText().toCharArray()[0]);
			int size = playerlist.size();
			Object[][] data = new Object[size][21];
			for(int i = 0 ; i < size; i++){
				data[i][0] = playerlist.get(i).getPlayerID();
				data[i][1] = playerlist.get(i).getChinesename();
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
		ComparePlayer pg=new ComparePlayer();
		pg.setLocation(0, 0);
		jf.add(pg);
		jf.setVisible(true);
	}

}
