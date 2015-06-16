package ui.frame.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
import thirdVersion.SalaryVO;
import thirdservice.playerControllerThirdService;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.UIData;

public class CostPerformance extends JPanel {

	private JComboBox<String> seasonComb;
	private MyTable tableForCoefficient;
	private MyTable tableForPlayers;
	private String[] columname2={"球员ID","球员姓名","球队","位置","进攻能力","防守能力","分析价值(万元)","实际薪水(万元)",
			"价值波动(万元)","性价比"};
	private String[] columname1={"位置","进攻回归系数","防守回归系数","常数回归系数","偏差平方和","平方标准差","复相关系数","平方和",
			"进攻偏相关系数","防守偏相关系数"};
	private playerControllerThirdService controllerForPlayer=new PlayerControllerThird();//逻辑层接口
	
	public CostPerformance(){
		this.setSize(1280, 720);
		this.setLayout(null);
		this.setBackground(Color.black);
		
		  //赛季
        String[] season=new String[30];
        for(int i=29;i>=0;i--){
        	String s1=String.valueOf(i+1985).substring(2);
        	String s2=String.valueOf(i+1985+1).substring(2);
        	season[29-i]=s1+"-"+s2;
        }
    	seasonComb = new JComboBox<String>(season);
    	seasonComb.setFont(new Font("宋体", Font.BOLD, 14));
    	seasonComb.setBounds(20,20,200, 30);
    	seasonComb.setBackground(Color.gray);
    	seasonComb.setForeground(Color.white);
    	seasonComb.addItemListener(new ItemListener(){
 			@Override
 			public void itemStateChanged(ItemEvent e) {
 				double[][] Coefficient=new double[3][10];
 				String season=seasonComb.getSelectedItem().toString();
 				ArrayList<SalaryVO> playerlist=controllerForPlayer.getSalaryBySeason(season,Coefficient);
 				
 				//系数表格更新
 				Object[][] coe = new Object[3][10];
 				for(int i=0;i<3;i++){
 					for(int j=0;j<10;i++){
 						coe[i][j]=Coefficient[i][j];
 					}
 				}
 				tableForCoefficient.update(columname1, coe);
 				
 				int size = playerlist.size();
 				Object[][] data = new Object[size][21];
 				for(int i = 0 ; i < size; i++){
 					data[i][0] = playerlist.get(i).getPlayerID();
 					data[i][1] = playerlist.get(i).getPlayerEnglishName();
 					data[i][2] = playerlist.get(i).getTeamName();
 					data[i][3] = playerlist.get(i).getPosition();
 					data[i][4] = playerlist.get(i).getQ1();
 					data[i][5] = playerlist.get(i).getQ2();
 					data[i][6] = playerlist.get(i).getTestSalaty();
 					data[i][7] = playerlist.get(i).getRealSalary();
 					data[i][8] = playerlist.get(i).getDif();
 					data[i][9] = playerlist.get(i).getPer();
 				}
 				tableForPlayers.update(columname2, data);
 			}
    	});
    	
    	this.add(seasonComb,0);
		//球员表格		
		tableForPlayers =new MyTable();
		JSortTable.makeFace(tableForPlayers.getTable());
		tableForPlayers.setBounds(20,210,1240,500);
		this.add(tableForPlayers,1);
		
		//系数表格		
		tableForCoefficient =new MyTable();
		JSortTable.makeFace(tableForCoefficient.getTable());
		tableForCoefficient.setBounds(20,70,1240,120);
		this.add(tableForCoefficient,2);
		
		iniTable();
	}
	
void iniTable(){
		double[][] Coefficient=new double[3][10];
 	   	ArrayList<SalaryVO> playerlist=controllerForPlayer.getSalaryBySeason("14-15",Coefficient);
 	   	//系数表格更新
		Object[][] coe = new Object[3][10];
		for(int i=0;i<3;i++){
			for(int j=0;j<10;i++){
				coe[i][j]=Coefficient[i][j];
			}
		}
		tableForCoefficient.update(columname1, coe);
 	   	int size = playerlist.size();

		Object[][] data = new Object[size][21];
		for(int i = 0 ; i < size; i++){
			data[i][0] = playerlist.get(i).getPlayerID();
			data[i][1] = playerlist.get(i).getPlayerEnglishName();
			data[i][2] = playerlist.get(i).getTeamName();
			data[i][3] = playerlist.get(i).getPosition();
			data[i][4] = playerlist.get(i).getQ1();
			data[i][5] = playerlist.get(i).getQ2();
			data[i][6] = playerlist.get(i).getTestSalaty();
			data[i][7] = playerlist.get(i).getRealSalary();
			data[i][8] = playerlist.get(i).getDif();
			data[i][9] = playerlist.get(i).getPer();
		}
		tableForPlayers.update(columname2, data);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UIData ui = new UIData(1280, 720);
		JFrame jf=new  JFrame();
		jf.setSize(1280, 720);
		jf.setUndecorated(true);
		jf.setLocation(20, 10);
		CostPerformance pg=new CostPerformance();
		pg.setLocation(0, 0);
		jf.add(pg);
		jf.setVisible(true);
	}

}
