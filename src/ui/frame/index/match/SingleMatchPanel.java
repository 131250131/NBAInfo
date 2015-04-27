package ui.frame.index.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class SingleMatchPanel extends JPanel{
	
	int width = (int) (1500 * UIData.changeY);
	int height = (int) (160 * 1.5 * UIData.changeY);
	
	JLabel backgroundLabel;
	JButton backgroundEnterEffect;
	
	JLabel teamLogo1, teamLogo2, scoreLabel, scoreTitle, leftScoreLabel, rightScoreLabel, dateLabel;
	
	public SingleMatchPanel(){
		this.setSize(width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);
	}
	
	String leftTeamName;
	String rightTeamName;
	int leftTeamScore_total = 116;
	int rightTeamScore_total = 103;
	
	int leftTeamScore_1Q = 20;
	int rightTeamScore_1Q = 35;
	int leftTeamScore_2Q = 12;
	int rightTeamScore_2Q = 26;
	int leftTeamScore_3Q = 40;
	String rightTeamScore_3Q = "08";
	int leftTeamScore_4Q = 32;
	int rightTeamScore_4Q = 10;
	String leftTeamScore_OT = "00";
	String rightTeamScore_OT = "00";
	
	String matchDate = "2013.12.11";
	
	public void initSingleMatchPanelWithMatch(){
		leftTeamName = "BOS";
		rightTeamName = "POR";
		int picSize = (int) (140 * 1.5 * UIData.changeX);
		ImageIcon image1 = new ImageIcon("data/newImage/Team/" + leftTeamName + ".png");
		ImageIcon image2 = new ImageIcon("data/newImage/Team/" + rightTeamName + ".png");
		image1.setImage(image1.getImage().getScaledInstance(picSize, picSize,Image.SCALE_DEFAULT));
		image2.setImage(image2.getImage().getScaledInstance(picSize, picSize,Image.SCALE_DEFAULT));
		
		teamLogo1 = new JLabel(image1);
		teamLogo1.setBounds((int) (30 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY), picSize, picSize);
		teamLogo1.setVisible(true);
		this.add(teamLogo1);
		
		teamLogo2 = new JLabel(image2);
		teamLogo2.setBounds((int) (330 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY), picSize, picSize);
		teamLogo2.setVisible(true);
		this.add(teamLogo2);
		
		scoreTitle = new JLabel("队伍名称      第一节       第二节       第三节      第四节       加  时            总  分");
		scoreTitle.setBounds((int) (485 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY)
				, (int) (500 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		scoreTitle.setVisible(true);
		scoreTitle.setForeground(Color.BLACK);
		scoreTitle.setFont(new Font("新細明體", Font.BOLD, (int) (14 * 1.5 * UIData.changeY)));
		this.add(scoreTitle);
		
		leftScoreLabel = new JLabel(leftTeamName + "     " + leftTeamScore_1Q + "     " + leftTeamScore_2Q
				+ "     " + leftTeamScore_3Q + "     " + leftTeamScore_4Q + "     " + leftTeamScore_OT + "      " + leftTeamScore_total);
		leftScoreLabel.setBounds((int) (500 * 1.5 * UIData.changeX), (int) (50 * 1.5 * UIData.changeY)
				, (int) (500 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		leftScoreLabel.setVisible(true);
		leftScoreLabel.setForeground(Color.BLUE);
		leftScoreLabel.setFont(new Font("OCR A Std", Font.BOLD, (int) (14 * 1.5 * UIData.changeY)));
		this.add(leftScoreLabel);
		
		rightScoreLabel = new JLabel(rightTeamName + "     " + rightTeamScore_1Q + "     " + rightTeamScore_2Q
				+ "     " + rightTeamScore_3Q + "     " + rightTeamScore_4Q + "     " + rightTeamScore_OT + "      " + rightTeamScore_total);
		rightScoreLabel.setBounds((int) (500 * 1.5 * UIData.changeX), (int) (90 * 1.5 * UIData.changeY),
				(int) (500 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		rightScoreLabel.setVisible(true);
		rightScoreLabel.setForeground(Color.DARK_GRAY);
		rightScoreLabel.setFont(new Font("OCR A Std", Font.BOLD, (int) (14 * 1.5 * UIData.changeY)));
		this.add(rightScoreLabel);
		
		dateLabel = new JLabel(matchDate, JLabel.RIGHT);
		dateLabel.setBounds((int) (500 * 1.5 * UIData.changeX), (int) (130 * 1.5 * UIData.changeY)
				, (int) (485 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		dateLabel.setVisible(true);
		dateLabel.setForeground(Color.GRAY);
		dateLabel.setFont(new Font("OCR A Std", Font.PLAIN, (int) (12 * 1.5 * UIData.changeY)));
		this.add(dateLabel);
		
		scoreLabel = new JLabel(leftTeamScore_total + " - " + rightTeamScore_total);
		scoreLabel.setBounds((int) (175 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY), (int) (picSize + 30 * 1.5 * UIData.changeX), picSize);
		scoreLabel.setVisible(true);
		scoreLabel.setForeground(Color.DARK_GRAY);
		scoreLabel.setFont(new Font("OCR A Std", Font.BOLD, (int) (26 * 1.5 * UIData.changeY)));
		this.add(scoreLabel);
		
		backgroundEnterEffect = new JButton();
		backgroundEnterEffect.setBounds(0, 0, width, height);
		backgroundEnterEffect.setVisible(true);
		backgroundEnterEffect.setBorder(BorderFactory.createEmptyBorder());
		backgroundEnterEffect.setOpaque(false);
		backgroundEnterEffect.setBackground(null);
		backgroundEnterEffect.setContentAreaFilled(false);
		backgroundEnterEffect.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				backgroundLabel.setIcon(ImageSaver.getIcon("单个比赛背景B"));
			}
			public void mouseExited(MouseEvent arg0) {
				backgroundLabel.setIcon(ImageSaver.getIcon("单个比赛背景A"));
			}
			}); 
		this.add(backgroundEnterEffect);
		
		backgroundLabel = new JLabel(ImageSaver.getIcon("单个比赛背景A"));
		backgroundLabel.setBounds(0, 0, width, height);
		backgroundLabel.setVisible(true);
		this.add(backgroundLabel);	
	}

}
