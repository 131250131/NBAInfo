package ui.frame.player;

import java.awt.Color;
import java.awt.Font;
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

import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
import thirdservice.playerControllerThirdService;
import ui.frame.player.AnalysisOfPlayers.JLabelOfAlphabet;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.UIData;

public class InferPanel extends JPanel {

	private MyTable inferDatasTable;
	private MyTable table;
	private JComboBox<String> seasonComb;
	private String[] dataCategoryNames={"选择数据种类","进攻数据","防守数据"};
	
	private String[] columname={"球员ID","球员姓名","场均出场时间","投篮命中率","场均投篮命中率","场均投篮出手数","三分命中率",
			"场均三分命中数","均三分出手数","罚球命中率","场均罚球命中数","场均罚球出手数","场均篮板数",
			"场均前场篮板数","场均后场篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	private String[] columnameOfinferDatas={
			"场均得分","助攻","篮板","进攻篮板","防守篮板","投篮命中率","罚球命中率","三分命中率","抢断","盖帽","犯规","失误","真实命中率"
	};
	private playerControllerThirdService controllerForPlayer=new PlayerControllerThird();//逻辑层接口
	public InferPanel(){
		this.setSize(1280, 720);
		this.setLayout(null);
		this.setBackground(Color.black);
		//加字母标签
		char firstC = 'A';
		int firstAS = (int)firstC - 1;
		int x = 20;
		int y = 170 ;
		for(int i = 0; i < 26; i++){
			firstAS+=1;
			JLabelOfAlphabet temp = new JLabelOfAlphabet(String.valueOf((char)firstAS));
			temp.setLocation(x + i * 40 , y);
			this.add(temp, i);
		}
				
		table =new MyTable();
		JSortTable.makeFace(table.getTable());
		table.setBounds(20,200 ,1240,490);
		iniTable();
		this.add(table,26);
		
		ListSelectionModel cellSelectionModel = table.getJTable().getSelectionModel();  
        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){  
            public void valueChanged(ListSelectionEvent e) {//单元格值变动事件 
            	String id = table.getSign(1);
            	ArrayList<String> inferDatas=controllerForPlayer.dataforecast(id, 0.95);
            	
            	Object[][] data=new Object[1][inferDatas.size()];
            	for(int i=0;i<inferDatas.size();i++){
            		data[0][i]=inferDatas.get(i);
            	}
            	
            	inferDatasTable.update(columnameOfinferDatas, data);
            }
        });
	
	}
	void iniTable(){
		
 	   	ArrayList<PlayerBasicInfoVO> playerlist=controllerForPlayer.getthisseasonplayer();
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
		InferPanel pg=new InferPanel();
		pg.setLocation(0, 0);
		jf.add(pg);
		jf.setVisible(true);
	}

}
