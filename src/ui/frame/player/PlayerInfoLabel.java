package ui.frame.player;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerInfoLabel extends JPanel{
		
	public PlayerInfoLabel(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		//this.setOpaque(false);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		
		JLabel nameLabel = new JLabel(player.getPlayerName(), JLabel.CENTER);
		nameLabel.setBounds((int) (30 * UIData.changeX), (int) (245 * UIData.changeY)
				, (int) (244 * UIData.changeX), (int) (30 * UIData.changeY));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBackground(null);
		nameLabel.setVisible(true);
		nameLabel.setFont(new Font("新細明體", Font.PLAIN, (int) (30 * UIData.changeY)));
		this.add(nameLabel);
		
		TextLabel text1 = new TextLabel("所属球队: " );
		text1.setLocation(400, 30);
		this.add(text1);
		
		TextLabel text2 = new TextLabel("身高体重: " + player.getHeight() + "; " + player.getWeight());
		text2.setLocation(400, 60);
		this.add(text2);
		
		TextLabel text3 = new TextLabel("擅长位置: " + player.getPosition());
		text3.setLocation(400, 90);
		this.add(text3);
		
		TextLabel text4 = new TextLabel("生日日期: " + player.getPlayerBirth());
		text4.setLocation(400, 120);
		this.add(text4);
		
		TextLabel text5 = new TextLabel("资历年数: " + player.getExp());
		text5.setLocation(400, 150);
		this.add(text5);
		
		TextLabel text6 = new TextLabel("来       自: " + player.getSchool());
		text6.setLocation(400, 180);
		this.add(text6);
		
		TextLabel2 text7 = new TextLabel2("场均得分: " + player.getAver_playerScores());
		text7.setLocation(700, 65);
		this.add(text7);
		
		TextLabel2 text8 = new TextLabel2("场均篮板: " + player.getAver_playerTotalRebounds());
		text8.setLocation(900, 65);
		this.add(text8);
		
		TextLabel2 text9 = new TextLabel2("场均助攻: " + player.getAver_playerAssists());
		text9.setLocation(1100, 65);
		this.add(text9);
		
		TextLabel2 text10 = new TextLabel2("赛季效率: " + player.getPlayerGmScER());
		text10.setLocation(700, 140);
		this.add(text10);
		
		TextLabel2 text11 = new TextLabel2("EYE-NBA 智能评分: " + 82);
		text11.setLocation(900, 140);
		this.add(text11);
		
		ImageLabel image = new ImageLabel(ImageSaver.getPlayerIcon(player.getPlayerName())
				, (int) (30 * UIData.changeX), (int) (30 * UIData.changeY), (int) (240 * UIData.changeX), (int) (200 * UIData.changeY));
		this.add(image);
		
		//player.getTeamShortName()
		ImageLabel teamImage = new ImageLabel(ImageSaver.getTeamIcon("CHI")
				, (int) (155 * UIData.changeX), (int) (20 * UIData.changeY), (int) (220 * UIData.changeX), (int) (220 * UIData.changeY));
		this.add(teamImage);
		
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
			this.setSize(300, 30);
			this.setFont(new Font("Arail", Font.PLAIN, (int) (20 * UIData.changeY)));
		}
	}
	
	class TextLabel2 extends JLabel{
		
		public TextLabel2(String txt){
			this.setText(txt);
			this.setForeground(Color.LIGHT_GRAY);
			this.setBackground(null);
			this.setVisible(true);
			this.setSize(400, 30);
			this.setFont(new Font("Arail", Font.PLAIN, (int) (30 * UIData.changeY)));
		}
	}

}
