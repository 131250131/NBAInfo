package ui.frame.team;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ChineseTranslator;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class TeamInfoLabel2 extends JPanel{
	
	public TeamInfoLabel2(int x, int y, int width, int height, String teamname){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		
		JLabel nameLabel = new JLabel(teamname, JLabel.CENTER);
		nameLabel.setBounds((int) (30 * UIData.changeX), (int) (245 * UIData.changeY)
				, (int) (244 * UIData.changeX), (int) (30 * UIData.changeY));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBackground(null);
		nameLabel.setVisible(true);
		nameLabel.setFont(new Font("新細明體", Font.PLAIN, (int) (30 * UIData.changeY)));
		this.add(nameLabel);
		
		TextLabel text1 = new TextLabel("球队离开联盟过久， 数据缺失!");
		text1.setLocation((int) (400 * UIData.changeX), (int) (85 * UIData.changeY));
		this.add(text1);
				
		ImageLabel image = new ImageLabel(ImageSaver.getTeamIcon(ChineseTranslator.TeamNameTrans(teamname))
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


