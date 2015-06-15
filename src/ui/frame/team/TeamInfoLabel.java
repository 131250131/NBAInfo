package ui.frame.team;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ChineseTranslator;
import ui.system.DataTransform;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.TeamVO;

@SuppressWarnings("serial")
public class TeamInfoLabel extends JPanel{
	
	public TeamInfoLabel(int x, int y, int width, int height, TeamVO team){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		
		JLabel nameLabel = new JLabel(team.getTeamName(), JLabel.CENTER);
		nameLabel.setBounds((int) (30 * UIData.changeX), (int) (245 * UIData.changeY)
				, (int) (244 * UIData.changeX), (int) (30 * UIData.changeY));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBackground(null);
		nameLabel.setVisible(true);
		nameLabel.setFont(new Font("新細明體", Font.PLAIN, (int) (30 * UIData.changeY)));
		this.add(nameLabel);
		
		TextLabel text1 = new TextLabel("球队全名: " + team.getTeamName());
		text1.setLocation((int) (400 * UIData.changeX), (int) (85 * UIData.changeY));
		this.add(text1);
		
		TextLabel text2 = new TextLabel("所属分部: " + ChineseTranslator.teamEastOrWest(team.isEast()));
		text2.setLocation((int) (400 * UIData.changeX), (int) (115 * UIData.changeY));
		this.add(text2);
		
		TextLabel2 text7 = new TextLabel2("场均得分: " + DataTransform.transDoubleTopointXXString(team.getAver_teamScores()));
		text7.setLocation((int) (900 * UIData.changeX), (int) (73 * UIData.changeY));
		this.add(text7);
		
		TextLabel2 text8 = new TextLabel2("场均篮板: " + DataTransform.transDoubleTopointXXString(team.getAver_teamTotalRebounds()));
		text8.setLocation((int) (900 * UIData.changeX), (int) (103 * UIData.changeY));
		this.add(text8);
		
		TextLabel2 text9 = new TextLabel2("场均助攻: " + DataTransform.transDoubleTopointXXString(team.getAver_teamAssists()));
		text9.setLocation((int) (900 * UIData.changeX), (int) (133 * UIData.changeY));
		this.add(text9);	
				
		ImageLabel image = new ImageLabel(ImageSaver.getTeamIcon(ChineseTranslator.TeamNameTrans(team.getTeamName()))
				, (int) (30 * UIData.changeX), (int) (0 * UIData.changeY), (int) (240 * UIData.changeX), (int) (240 * UIData.changeY));
		this.add(image);
		
		int bacX = (int) (0 * UIData.changeX);
		int bacY = (int) (234 * UIData.changeY);
		int bacWidth = width - bacX * 2;
		int bacHeight = height - bacY;
		JPanel backPanel = new JPanel();
		backPanel.setBounds(bacX, bacY, bacWidth, bacHeight);
		backPanel.setBackground(new Color(0, 0, 0, 0.8f));
		backPanel.setVisible(true);
		this.add(backPanel);
		
	}
	
	class TextLabel extends JLabel{
		
		public TextLabel(String txt){
			this.setText(txt);
			this.setForeground(Color.WHITE);
			this.setBackground(null);
			this.setVisible(true);
			this.setSize((int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
			this.setFont(new Font("Arail", Font.PLAIN, (int) (20 * UIData.changeY)));
		}
	}
	
	class TextLabel2 extends JLabel{
		
		public TextLabel2(String txt){
			this.setText(txt);
			this.setForeground(Color.LIGHT_GRAY);
			this.setBackground(null);
			this.setVisible(true);
			this.setSize((int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
			this.setFont(new Font("Arail", Font.PLAIN, (int) (20 * UIData.changeY)));
		}
	}

}

