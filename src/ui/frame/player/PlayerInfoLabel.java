package ui.frame.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ChineseTranslator;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerInfoLabel extends JPanel implements ActionListener{

	JButton teamBt1, teamBt2;
	PlayerVO _player;
	
	public PlayerInfoLabel(int x, int y, int width, int height, PlayerVO player){
		
		_player = player;
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
	
		teamBt2 = new JButton();
		teamBt2.addActionListener(this);
		this.add(teamBt2);
		
		TextLabel text1 = new TextLabel("所属球队: " + player.getTeamname());
		text1.setLocation((int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
		text1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamBt2.doClick();
			}
		});
		this.add(text1);
		
		TextLabel text2 = new TextLabel("身高体重: " + player.getHeight() + "; " + player.getWeight());
		text2.setLocation((int) (400 * UIData.changeX), (int) (60 * UIData.changeY));
		this.add(text2);
		
		TextLabel text3 = new TextLabel("擅长位置: " + player.getPosition());
		text3.setLocation((int) (400 * UIData.changeX), (int) (90 * UIData.changeY));
		this.add(text3);
		
		TextLabel text4 = new TextLabel("生日日期: " + player.getPlayerBirth());
		text4.setLocation((int) (400 * UIData.changeX), (int) (120 * UIData.changeY));
		this.add(text4);
		
		TextLabel text5 = new TextLabel("资历年数: " + player.getExp());
		text5.setLocation((int) (400 * UIData.changeX), (int) (150 * UIData.changeY));
		this.add(text5);
		
		TextLabel text6 = new TextLabel("来       自: " + player.getSchool());
		text6.setLocation((int) (400 * UIData.changeX), (int) (180 * UIData.changeY));
		this.add(text6);
		
		TextLabel2 text7 = new TextLabel2("场均得分: " + DataTransform.transDoubleTopointXXString(player.getAver_playerScores()));
		text7.setLocation((int) (900 * UIData.changeX), (int) (30 * UIData.changeY));
		this.add(text7);
		
		TextLabel2 text8 = new TextLabel2("场均篮板: " + DataTransform.transDoubleTopointXXString(player.getAver_playerTotalRebounds()));
		text8.setLocation((int) (900 * UIData.changeX), (int) (60 * UIData.changeY));
		this.add(text8);
		
		TextLabel2 text9 = new TextLabel2("场均助攻: " + DataTransform.transDoubleTopointXXString(player.getAver_playerAssists()));
		text9.setLocation((int) (900 * UIData.changeX), (int) (90 * UIData.changeY));
		this.add(text9);
		
		TextLabel2 text10 = new TextLabel2("赛季效率: " + DataTransform.transDoubleTopointXXString(player.getPlayerGmScER()));
		text10.setLocation((int) (900 * UIData.changeX), (int) (150 * UIData.changeY));
		this.add(text10);
		
		TextLabel2 text11 = new TextLabel2("EYE-NBA 智能评分: " + DataTransform.getNBAEYEScore(player.getPlayerGmScER()));
		text11.setLocation((int) (900 * UIData.changeX), (int) (180 * UIData.changeY));
		this.add(text11);
		
		TextLabel2 text12 = new TextLabel2("平均上场: " + DataTransform.transDoubleTopointXXString(player.getAver_playerPlayTime() / 60) + "分");
		text12.setLocation((int) (900 * UIData.changeX), (int) (120 * UIData.changeY));
		this.add(text12);

		ImageLabel image = new ImageLabel(ImageSaver.getPlayerIcon(player.getPlayerName())
				, (int) (30 * UIData.changeX), (int) (30 * UIData.changeY), (int) (240 * UIData.changeX), (int) (200 * UIData.changeY));
		this.add(image);

		teamBt1 = new JButton();
		teamBt1.addActionListener(this);
		this.add(teamBt1);
		
		ImageLabel teamImage = new ImageLabel(ImageSaver.getTeamIcon(player.getTeamShortName())
				, (int) (155 * UIData.changeX), (int) (20 * UIData.changeY), (int) (220 * UIData.changeX), (int) (220 * UIData.changeY));
		teamImage.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				teamBt1.doClick();
			}
		});
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
			this.setSize((int) (500 * UIData.changeX), (int) (30 * UIData.changeY));
			this.setFont(new Font("Arail", Font.PLAIN, (int) (20 * UIData.changeY)));
		}
	}
	
	class TextLabel2 extends JLabel{
		
		public TextLabel2(String txt){
			this.setText(txt);
			this.setForeground(Color.LIGHT_GRAY);
			this.setBackground(null);
			this.setVisible(true);
			this.setSize((int) (500 * UIData.changeX), (int) (30 * UIData.changeY));
			this.setFont(new Font("Arail", Font.PLAIN, (int) (20 * UIData.changeY)));
		}
	}

	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == teamBt1){
			Controller.addTeamPanel(_player.getTeamShortName());
		}
		
		if(events.getSource() == teamBt2){
			Controller.addTeamPanel(_player.getTeamShortName());
		}
		
	}

}
