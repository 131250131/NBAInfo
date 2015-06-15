package ui.frame.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
import thirdVersion.SalaryVO;
import thirdservice.playerControllerThirdService;
import ui.myUI.JSortTable;
import ui.myUI.MyTable;

public class CostPerformance extends JPanel {

	private JComboBox<String> seasonComb;
	private MyTable table;
	private String[] columname={"球员ID","球员姓名","球队","位置","进攻能力","防守能力","分析价值","实际薪水",
			"价值波动","性价比"};
	private playerControllerThirdService controllerForPlayer=new PlayerControllerThird();//逻辑层接口
	
	public CostPerformance(){
		this.setSize(1280, 720);
		this.setLayout(null);
		this.setBackground(Color.black);
		
		  //赛季
        String[] season=new String[31];
        for(int i=0;i<=29;i++){
        	String s1=String.valueOf(i+1985).substring(2);
        	String s2=String.valueOf(i+1985+1).substring(2);
        	season[i+1]=s1+"-"+s2;
        }
        season[0]="选择赛季";
    	seasonComb = new JComboBox<String>(season);
    	seasonComb.setFont(new Font("宋体", Font.BOLD, 14));
    	seasonComb.setBounds(20,20,200, 30);
    	seasonComb.setBackground(Color.gray);
    	seasonComb.setForeground(Color.white);
    	seasonComb.addItemListener(new ItemListener(){
 			@Override
 			public void itemStateChanged(ItemEvent e) {
 				String season=seasonComb.getSelectedItem().toString();
 				ArrayList<SalaryVO> playerlist=controllerForPlayer.getSalaryBySeason(season);
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
 				table.update(columname, data);
 			}
    	});
    	
    	this.add(seasonComb,0);
		//球员表格		
		table =new MyTable();
		JSortTable.makeFace(table.getTable());
		table.setBounds(20,100 ,1240,590);
		iniTable();
		this.add(table,1);
	}
	
void iniTable(){
		
 	   	ArrayList<SalaryVO> playerlist=controllerForPlayer.getSalaryBySeason("14-15");
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
		table.update(columname, data);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
