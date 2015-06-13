package ui.frame.index.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.ChineseTranslator;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.MatchVO;
import vo.TeamVO;

@SuppressWarnings("serial")
public class SingleMatchPanel extends JPanel implements ActionListener{
	
	int width = (int) (1500 * UIData.changeX);
	int height = (int) (160 * 1.5 * UIData.changeY);
	
	JLabel backgroundLabel;
	JButton backgroundEnterEffect;
	
	JLabel teamLogo1, teamLogo2, scoreLabel, scoreTitle, leftScoreLabel, rightScoreLabel, dateLabel;
	
	MatchVO match;
	
	public SingleMatchPanel(MatchVO _match){
		match = _match;
		this.setSize(width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);
		initSingleMatchPanelWithMatch();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == backgroundEnterEffect){
			Controller.addMatchPanel(match);
		}
		
	}
	
	private String spliterL(String string){
		String[] str = string.split(":");
		int i = Integer.parseInt(str[0]);
		if(i < 10){
			return "0" + i;
		}
		return String.valueOf(i);
	}
	
	private String spliterR(String string){
		String[] str = string.split(":");
		int i = Integer.parseInt(str[1]);
		if(i < 10){
			return "0" + i;
		}
		return String.valueOf(i);
	}
	
	public void initSingleMatchPanelWithMatch(){
		TeamVO leftTeam = match.getLeftTeam();
		TeamVO rightTeam = match.getRightTeam();
		String leftTeamName = leftTeam.getTeamName();
		String rightTeamName= rightTeam.getTeamName();
		
		String leftTeamScore_total = spliterL(match.getScore());
		String rightTeamScore_total = spliterR(match.getScore());
		String leftTeamScore_1Q = spliterL(match.getScores1());
		String rightTeamScore_1Q = spliterR(match.getScores1());
		String leftTeamScore_2Q = spliterL(match.getScores2());
		String rightTeamScore_2Q = spliterR(match.getScores2());
		String leftTeamScore_3Q = spliterL(match.getScores3());
		String rightTeamScore_3Q = spliterR(match.getScores3());
		String leftTeamScore_4Q = spliterL(match.getScores4());
		String rightTeamScore_4Q = spliterR(match.getScores4());
		String leftTeamScore_OT = "0";
		String rightTeamScore_OT = "0";
		if(match.getExtrascores() != null){
			leftTeamScore_OT = spliterL(match.getExtrascores());
			rightTeamScore_OT = spliterR(match.getExtrascores());
		}
		String matchDate = match.getDate();
		int picSizeX = (int) (140 * 1.5 * UIData.changeX);
		int picSizeY = (int) (140 * 1.5 * UIData.changeY);
		ImageIcon image1 = ImageSaver.getTeamIcon(leftTeamName);
		ImageIcon image2 = ImageSaver.getTeamIcon(rightTeamName);
		image1.setImage(image1.getImage().getScaledInstance(picSizeX, picSizeY,Image.SCALE_DEFAULT));
		image2.setImage(image2.getImage().getScaledInstance(picSizeX, picSizeY,Image.SCALE_DEFAULT));
		
		teamLogo1 = new JLabel(image1);
		teamLogo1.setBounds((int) (30 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY), picSizeX, picSizeY);
		teamLogo1.setVisible(true);
		this.add(teamLogo1);
		
		JLabel teamNameLabelL = new JLabel(ChineseTranslator.TeamNameTrans(leftTeamName));
		teamNameLabelL.setBounds((int) (230 * UIData.changeX), (int) (150 * UIData.changeY),(int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		teamNameLabelL.setFont(new Font("黑体", Font.BOLD, (int) (30 * UIData.changeY)));
		teamNameLabelL.setVisible(true);
		teamNameLabelL.setForeground(Color.GRAY);
		this.add(teamNameLabelL);
		
		JLabel teamNameLabelR = new JLabel(ChineseTranslator.TeamNameTrans(rightTeamName),JLabel.RIGHT);
		teamNameLabelR.setBounds((int) (330 * UIData.changeX), (int) (150 * UIData.changeY),(int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		teamNameLabelR.setFont(new Font("黑体", Font.BOLD, (int) (30 * UIData.changeY)));
		teamNameLabelR.setVisible(true);
		teamNameLabelR.setForeground(Color.GRAY);
		this.add(teamNameLabelR);
		
		teamLogo2 = new JLabel(image2);
		teamLogo2.setBounds((int) (330 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY), picSizeX, picSizeY);
		teamLogo2.setVisible(true);
		this.add(teamLogo2);
		
//		scoreTitle = new JLabel("队伍名称     第一节      第二节     第三节    第四节     加  时         总  分");
//		scoreTitle.setBounds((int) (485 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY)
//				, (int) (500 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
//		scoreTitle.setVisible(true);
//		scoreTitle.setForeground(Color.BLACK);
//		scoreTitle.setFont(new Font("新細明體", Font.BOLD, (int) (14 * 1.5 * UIData.changeY)));
//		this.add(scoreTitle);
		
		leftScoreLabel = new JLabel(" " + leftTeamName + "      " + leftTeamScore_1Q + "       " + leftTeamScore_2Q
				+ "       " + leftTeamScore_3Q + "       " + leftTeamScore_4Q + "       " + leftTeamScore_OT + "         " + leftTeamScore_total);
		leftScoreLabel.setBounds((int) (500 * 1.5 * UIData.changeX), (int) (50 * 1.5 * UIData.changeY)
				, (int) (500 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		leftScoreLabel.setVisible(true);		
		leftScoreLabel.setFont(new Font("黑体", Font.BOLD, (int) (14 * 1.5 * UIData.changeY)));
		this.add(leftScoreLabel);
		
		rightScoreLabel = new JLabel(" " + rightTeamName + "      " + rightTeamScore_1Q + "       " + rightTeamScore_2Q
				+ "       " + rightTeamScore_3Q + "       " + rightTeamScore_4Q + "       " + rightTeamScore_OT + "         " + rightTeamScore_total);
		rightScoreLabel.setBounds((int) (500 * 1.5 * UIData.changeX), (int) (90 * 1.5 * UIData.changeY),
				(int) (500 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		rightScoreLabel.setVisible(true);		
		rightScoreLabel.setFont(new Font("黑体", Font.BOLD, (int) (14 * 1.5 * UIData.changeY)));
		this.add(rightScoreLabel);
		
		if(Integer.parseInt(leftTeamScore_total) > Integer.parseInt(rightTeamScore_total)){
			leftScoreLabel.setForeground(Color.BLUE);
			rightScoreLabel.setForeground(Color.DARK_GRAY);
		}else{
			leftScoreLabel.setForeground(Color.DARK_GRAY);
			rightScoreLabel.setForeground(Color.BLUE);
		}
		
		dateLabel = new JLabel(matchDate, JLabel.RIGHT);
		dateLabel.setBounds((int) (500 * 1.5 * UIData.changeX), (int) (130 * 1.5 * UIData.changeY)
				, (int) (485 * 1.5 * UIData.changeX), (int) (30 * 1.5 * UIData.changeY));
		dateLabel.setVisible(true);
		dateLabel.setForeground(Color.GRAY);
		dateLabel.setFont(new Font("Arail", Font.PLAIN, (int) (12 * 1.5 * UIData.changeY)));
		this.add(dateLabel);
		
		scoreLabel = new JLabel(leftTeamScore_total + " - " 
				+ rightTeamScore_total, JLabel.CENTER);
		scoreLabel.setBounds((int) (136 * 1.5 * UIData.changeX), (int) (10 * 1.5 * UIData.changeY), (int) ((picSizeX + 30) * 1.5 * UIData.changeX), picSizeY );
		scoreLabel.setVisible(true);
		scoreLabel.setForeground(Color.DARK_GRAY);
		scoreLabel.setFont(new Font("Arail", Font.BOLD, (int) (25 * 1.5 * UIData.changeY)));
		this.add(scoreLabel);
			
		image3.setImage(image3.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		image4.setImage(image4.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
		
		backgroundEnterEffect = new JButton();
		backgroundEnterEffect.setBounds(0, 0, width, height);
		backgroundEnterEffect.setVisible(true);
		backgroundEnterEffect.setBorder(BorderFactory.createEmptyBorder());
		backgroundEnterEffect.setOpaque(false);
		backgroundEnterEffect.setBackground(null);
		backgroundEnterEffect.setContentAreaFilled(false);
		backgroundEnterEffect.addActionListener(this);
		backgroundEnterEffect.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				backgroundLabel.setIcon(image4);
			}
			public void mouseExited(MouseEvent arg0) {
				backgroundLabel.setIcon(image3);
			}
			}); 
		this.add(backgroundEnterEffect);
		
		backgroundLabel = new JLabel(image3);
		backgroundLabel.setBounds(0, 0, width, height);
		backgroundLabel.setVisible(true);
		this.add(backgroundLabel);	
	}
	
	ImageIcon image3 = ImageSaver.getIcon("单个比赛背景A");
	ImageIcon image4 = ImageSaver.getIcon("单个比赛背景B");

}
