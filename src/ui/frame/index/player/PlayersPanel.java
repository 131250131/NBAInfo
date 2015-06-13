package ui.frame.index.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import thirdVersion.PlayerBasicInfoVO;
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
	JLabel check;
	//调用逻辑层接口
	
	public PlayersPanel(){
		this.setBounds((int) (390 * UIData.changeX), (int) (220 * UIData.changeY), (int) (1480 * UIData.changeX), (int) (1000 * UIData.changeY));
		this.setOpaque(false);
		this.setLayout(null);
		
		check = new JLabel("查看所选球员信息");
		check.setBounds((int) (945 * UIData.changeX), (int) (125 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		check.setForeground(Color.WHITE);
		check.setVisible(true);
		check.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				if(getPlayerName() != null){
					Controller.addPlayerPanel(getPlayerName());
				}
			}
			
			public void mouseEntered(MouseEvent arg0) {
				check.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent arg0) {
				check.setForeground(Color.WHITE);
			}	
		});
		this.add(check);
		
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
		String[] teamNames={"选择球队","达拉斯小牛队","丹佛掘金队","金州勇士队","休斯顿火箭队","洛杉矶快船队","洛杉矶湖人队","孟菲斯灰熊队","明尼苏达森林狼队",
				"新奥尔良鹈鹕队","波特兰开拓者队","俄克拉荷马雷霆队","菲尼克斯太阳队","萨克拉门托国王队","圣安东尼奥马刺队","犹他爵士队",
				"亚特兰大老鹰队","纽约篮网队","波士顿凯尔特人队","夏洛特黄蜂队","芝加哥公牛队","克里夫兰骑士队","底特律活塞队",
				"印第安纳步行者队","迈阿密热火队","密尔沃基雄鹿队","纽约尼克斯队","奥兰多魔术队","费城76人队","多伦多猛龙队","华盛顿奇才队"};
		teamName = new JComboBox<String>(teamNames);
		
		teamName.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String shortName = teamName.getSelectedItem().toString();
				ArrayList<PlayerVO> playerlist = Controller.playerController.getplayerbyteam(shortName, "14-15");
				
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
		
		ArrayList<PlayerBasicInfoVO> playerlist = Controller.playerController.getPlayersbyChar('A');
		int size = playerlist.size();
		
		Object[][] data = new Object[size][7];
		for(int i = 0; i < size; i++){
			data[i][0] = Controller.playerController.getEnglishName(playerlist.get(i).getPlayerID());
			data[i][1] = ChineseTranslator.TeamNameTrans(teamName.getSelectedItem().toString());
			if(data[i][1] == null){
				data[i][1] = "自由球员";
			}else{
				data[i][1] = playerlist.get(i).getTeamname();
			}
			data[i][2] = playerlist.get(i).getPlayerPosition();
			data[i][3] = playerlist.get(i).getPlayerHeight();
			data[i][4] = playerlist.get(i).getPlayerWeight();
			data[i][5] = playerlist.get(i).getPlayerBirthDay();
			data[i][6] = playerlist.get(i).getPlayerHighSchool();
		}
		table.update(columname, data);
	}

	private String getPlayerName(){
		String str = null;
		if(table.getTable().getSelectedColumnCount() != 0){
			str = (String)table.getTable().getValueAt(table.getTable().getSelectedRow(), 1);
		}
		return str;
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
			ArrayList<PlayerBasicInfoVO> playerlist = Controller.playerController.getPlayersbyChar(this.getText().toCharArray()[0]);
			int size = playerlist.size();
			Object[][] data = new Object[size][7];
			for(int i = 0; i < size; i++){
				data[i][0] = Controller.playerController.getEnglishName(playerlist.get(i).getPlayerID());
				data[i][1] = ChineseTranslator.TeamNameTrans(teamName.getSelectedItem().toString());
				if(data[i][1] == null){
					data[i][1] = "自由球员";
				}else{
					data[i][1] = playerlist.get(i).getTeamname();
				}
				data[i][2] = playerlist.get(i).getPlayerPosition();
				data[i][3] = playerlist.get(i).getPlayerHeight();
				data[i][4] = playerlist.get(i).getPlayerWeight();
				data[i][5] = playerlist.get(i).getPlayerBirthDay();
				data[i][6] = playerlist.get(i).getPlayerHighSchool();
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
