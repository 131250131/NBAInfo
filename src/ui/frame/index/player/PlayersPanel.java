package ui.frame.index.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.JSortTable;
import ui.myUI.MyTable;
import ui.system.ChineseTranslator;
import ui.system.Controller;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayersPanel extends JPanel {

	private JComboBox<String> teamName;
	private MyTable table;
	String[] columname={"球员","球队","位置","身高","体重","经验","来自"};
	
	//调用逻辑层接口
	
	public PlayersPanel(){
		Controller.init();
		this.setBounds((int) (390 * UIData.changeX), (int) (220 * UIData.changeY), (int) (1480 * UIData.changeX), (int) (1000 * UIData.changeY));
		this.setOpaque(false);
		this.setLayout(null);
		//加字母标签
		char firstC = 'A';
		int firstAS = (int)firstC - 1;
		int x = (int) (45 * UIData.changeX);
		int y = (int) (40 * UIData.changeY);
		for(int i = 0; i < 26; i++){
			firstAS+=1;
			JLabelOfAlphabet temp = new JLabelOfAlphabet(String.valueOf((char)firstAS));
			temp.setLocation((int) (x + i * 40 * UIData.changeX), y);
			this.add(temp, i);
		}
		//所属球队下拉框
		String[] teamNames={"选择球队","小牛","掘金","勇士","火箭","快船","湖人","灰熊","灰狼","鹈鹕","拓荒者","雷霆","太阳","国王","马刺","爵士",
				"老鹰","篮网","凯尔特人","黄蜂","公牛","骑士","活塞","步行者","热火","雄鹿","尼克斯","魔术","76人","猛龙","奇才"};
		teamName = new JComboBox<String>(teamNames);
		
		teamName.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String shortName = ChineseTranslator.TeamNameTrans(teamName.getSelectedItem().toString());
				ArrayList<PlayerVO> playerlist = Controller.playerController.getplayerbyteam(shortName);
				
				int size = playerlist.size();
		
				Object[][] data = new Object[size][7];
				for(int i = 0 ; i < size; i++){
					data[i][0] = playerlist.get(i).getPlayerName();
					data[i][1] = playerlist.get(i).getTeamShortName();
					if(data[i][1].equals("") || data[i][1].equals(null) || data[i][1] == null){
						data[i][1] = "自由球员";
					}else{
						data[i][1] = ChineseTranslator.TeamNameTrans(playerlist.get(i).getTeamShortName());
					}
					data[i][2] = playerlist.get(i).getPosition();
					data[i][3] = playerlist.get(i).getHeight();
					data[i][4] = playerlist.get(i).getWeight();
					data[i][5] = playerlist.get(i).getPlayerAge();
					data[i][6] = playerlist.get(i).getSchool();
				}
				table.update(columname, data);
			}});
		
		teamName.setFont(new Font("宋体", Font.BOLD, (int) (14 * UIData.changeY)));
		teamName.setBounds((int) (25 * UIData.changeX), (int) (125 * UIData.changeY), (int) (150 * UIData.changeX), (int) (25 * UIData.changeY));
		teamName.setBackground(Color.gray);
		teamName.setForeground(Color.white);
		this.add(teamName, 26);
		
		//表格
		table = new MyTable();
		JSortTable.makeFace(table.getTable());
		Object[][] datas = new Object[1][7];
		table.setBounds((int) (25 * UIData.changeX), (int) (180 * UIData.changeY), (int) (1091 * UIData.changeX), (int) (540 * UIData.changeY));
		table.update(columname, datas);
		this.add(table, 27);
		
		JPanel colorPanel = new JPanel();
		colorPanel.setBounds((int) (25* UIData.changeX), (int) (39 * UIData.changeY), (int) (1091 * UIData.changeX), (int) (31 * UIData.changeY));
		colorPanel.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
		colorPanel.setVisible(true);
		this.add(colorPanel);
		
		ArrayList<PlayerVO> playerlist = Controller.playerController.getAllPlayerVO();
		int size = playerlist.size();
		
		Object[][] data = new Object[size][7];
		for(int i = 0 ; i < size; i++){
			data[i][0] = playerlist.get(i).getPlayerName();
			data[i][1] = playerlist.get(i).getTeamShortName();
			if(data[i][1].equals("") || data[i][1].equals(null) || data[i][1] == null){
				data[i][1] = "自由球员";
			}else{
				data[i][1] = ChineseTranslator.TeamNameTrans(playerlist.get(i).getTeamShortName());
			}
			data[i][2] = playerlist.get(i).getPosition();
			data[i][3] = playerlist.get(i).getHeight();
			data[i][4] = playerlist.get(i).getWeight();
			data[i][5] = playerlist.get(i).getPlayerAge();
			data[i][6] = playerlist.get(i).getSchool();
		}
		table.update(columname, data);
	}
	
	class JLabelOfAlphabet extends JLabel implements MouseListener{

		public JLabelOfAlphabet(String s){
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setSize((int) (25 * UIData.changeX), (int) (25 * UIData.changeY));
			this.setText(s);
			this.setFont(new Font("黑体", Font.BOLD, (int) (20 * UIData.changeY)));
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
			ArrayList<PlayerVO> playerlist = Controller.playerController.getPlayerbyChar(this.getText().toCharArray()[0]);
			int size = playerlist.size();
			Object[][] data = new Object[size][7];
			for(int i = 0; i < size; i++){
				data[i][0] = playerlist.get(i).getPlayerName();
				data[i][1] = playerlist.get(i).getTeamShortName();
				if(data[i][1].equals("") || data[i][1].equals(null) || data[i][1] == null){
					data[i][1] = "自由球员";
				}else{
					data[i][1] = ChineseTranslator.TeamNameTrans(playerlist.get(i).getTeamShortName());
				}
				data[i][2] = playerlist.get(i).getPosition();
				data[i][3] = playerlist.get(i).getHeight();
				data[i][4] = playerlist.get(i).getWeight();
				data[i][5] = playerlist.get(i).getPlayerAge();
				data[i][6] = playerlist.get(i).getSchool();
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
}
