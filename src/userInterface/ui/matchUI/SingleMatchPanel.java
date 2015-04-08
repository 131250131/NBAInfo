package userInterface.ui.matchUI;

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

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class SingleMatchPanel extends JPanel{
	
	int width = MatchBounds.singleMatchPanelSizeX;
	int height = MatchBounds.singleMatchPanelSizeY;
	
	JLabel backgroundLabel;
	JButton backgroundEnterEffect;
	
	JLabel teamLogo1, teamLogo2, scoreLabel, scoreTitle, leftScoreLabel, rightScoreLabel, dateLabel;
	
	public SingleMatchPanel(){
		this.setSize(width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);
		
		backgroundEnterEffect = new JButton();
		backgroundEnterEffect.setBounds(0, 0, width, height);
		backgroundEnterEffect.setVisible(true);
		backgroundEnterEffect.setBorder(BorderFactory.createEmptyBorder());
		backgroundEnterEffect.setOpaque(false);
		backgroundEnterEffect.setBackground(null);
		backgroundEnterEffect.setContentAreaFilled(false);
		backgroundEnterEffect.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				backgroundLabel.setIcon(ImageSaver.getIcon("singleMatchBack2"));
			}
			public void mouseExited(MouseEvent arg0) {
				backgroundLabel.setIcon(ImageSaver.getIcon("singleMatchBack"));
			}
			}); 
		this.add(backgroundEnterEffect);
		
		backgroundLabel = new JLabel(ImageSaver.getIcon("singleMatchBack"));
		backgroundLabel.setBounds(0, 0, width, height);
		backgroundLabel.setVisible(true);
		this.add(backgroundLabel);	
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
		int picSize = 140;
		ImageIcon image1 = new ImageIcon("data/newImage/Team/" + leftTeamName + ".png");
		ImageIcon image2 = new ImageIcon("data/newImage/Team/" + rightTeamName + ".png");
		image1.setImage(image1.getImage().getScaledInstance(picSize, picSize,Image.SCALE_DEFAULT));
		image2.setImage(image2.getImage().getScaledInstance(picSize, picSize,Image.SCALE_DEFAULT));
		
		teamLogo1 = new JLabel(image1);
		teamLogo1.setBounds(30, 10, picSize, picSize);
		teamLogo1.setVisible(true);
		this.add(teamLogo1);
		
		teamLogo2 = new JLabel(image2);
		teamLogo2.setBounds(300 + 30, 10, picSize, picSize);
		teamLogo2.setVisible(true);
		this.add(teamLogo2);
		
		scoreTitle = new JLabel("TEAM    1st    2nd    3rd    4th    O.T     TOTAL");
		scoreTitle.setBounds(495, 10, 500, 30);
		scoreTitle.setVisible(true);
		scoreTitle.setForeground(Color.BLACK);
		scoreTitle.setFont(new Font("OCR A Std", Font.BOLD, 14));
		this.add(scoreTitle);
		
		leftScoreLabel = new JLabel(leftTeamName + "     " + leftTeamScore_1Q + "     " + leftTeamScore_2Q
				+ "     " + leftTeamScore_3Q + "     " + leftTeamScore_4Q + "     " + leftTeamScore_OT + "      " + leftTeamScore_total);
		leftScoreLabel.setBounds(500, 50, 500, 30);
		leftScoreLabel.setVisible(true);
		leftScoreLabel.setForeground(Color.BLUE);
		leftScoreLabel.setFont(new Font("OCR A Std", Font.BOLD, 14));
		this.add(leftScoreLabel);
		
		rightScoreLabel = new JLabel(rightTeamName + "     " + rightTeamScore_1Q + "     " + rightTeamScore_2Q
				+ "     " + rightTeamScore_3Q + "     " + rightTeamScore_4Q + "     " + rightTeamScore_OT + "      " + rightTeamScore_total);
		rightScoreLabel.setBounds(500, 90, 500, 30);
		rightScoreLabel.setVisible(true);
		rightScoreLabel.setForeground(Color.DARK_GRAY);
		rightScoreLabel.setFont(new Font("OCR A Std", Font.BOLD, 14));
		this.add(rightScoreLabel);
		
		dateLabel = new JLabel(matchDate, JLabel.RIGHT);
		dateLabel.setBounds(500, 130, 485, 30);
		dateLabel.setVisible(true);
		dateLabel.setForeground(Color.GRAY);
		dateLabel.setFont(new Font("OCR A Std", Font.PLAIN, 12));
		this.add(dateLabel);
		
		scoreLabel = new JLabel(leftTeamScore_total + " - " + rightTeamScore_total);
		scoreLabel.setBounds(175, 10, picSize + 30, picSize);
		scoreLabel.setVisible(true);
		scoreLabel.setForeground(Color.DARK_GRAY);
		scoreLabel.setFont(new Font("OCR A Std", Font.BOLD, 26));
		this.add(scoreLabel);
	}

}
