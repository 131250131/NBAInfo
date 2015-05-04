package userInterface.ui.matchUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.Controller;

public class PlayersPanel extends JPanel {

	private JComboBox teamName;
	private MyTable table;
	public PlayersPanel(){
		this.setBounds(0, 0, 1280, 720);
		this.setBackground(Color.black);
		this.setLayout(null);
		//加字母标签
		char firstC ='A';
		int firstAS=(int)firstC-1;
		int x=20;
		int y=30;
		for(int i=0;i<26;i++){
			firstAS+=1;
			JLabelOfAlphabet temp=new JLabelOfAlphabet(String.valueOf((char)firstAS));
			temp.setLocation(x+i*35, y);
			this.add(temp, i);
		}
		//所属球队下拉框
		String[] teamNames={"选择球队","小牛","掘金","勇士","火箭","快船","湖人","灰熊","灰狼","鹈鹕","拓荒者","雷霆","太阳","国王","马刺","爵士",
				"老鹰","篮网","凯尔特人","黄蜂","公牛","骑士","活塞","步行者","热火","雄鹿","尼克斯","魔术","76人","猛龙","奇才"};
		teamName = new JComboBox(teamNames);
		teamName.setFont(new Font("宋体",Font.BOLD,14));
		teamName.setBounds(25,75, 150, 25);
		teamName.setBackground(Color.gray);
		teamName.setForeground(Color.white);
		this.add(teamName, 26);
		//表格
		table = new MyTable();
		JSortTable.makeFace(table.getTable());
		String[] columname={"球员","球队","位置","身高","体重","经验","国籍"
				};
		Object[][] datas=new Object[1][7];
		table.setBounds(25, 120, 880, 540);
		table.update(columname, datas);
		this.add(table, 27);
	}
	class JLabelOfAlphabet extends JLabel implements MouseListener{

		public JLabelOfAlphabet(String s){
			this.setHorizontalAlignment(JLabel.CENTER);
			this.setSize(25, 25);
			this.setText(s);
			this.setFont(new Font("黑体",Font.BOLD,20));
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
		JFrame test=new JFrame();
		test.setUndecorated(true);
		test.setBounds(20, 20, 1280, 720);
		test.setLayout(null);
		test.add(new PlayersPanel());
		
		test.setVisible(true);
	}
}
