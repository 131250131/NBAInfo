package ui.frame.match;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.DataTransform;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.MatchVO;
import vo.TeamVO;

@SuppressWarnings("serial")
public class MatchVSLabel extends JPanel{
	
	TeamVO leftTeam, rightTeam;
	int num = 14;
	SingleDataLabel[] dataLabel = new SingleDataLabel[num];
	
	public MatchVSLabel(int x, int y, int width, int height, MatchVO match){
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.1f));
		
		leftTeam = match.getLeftTeam();
		rightTeam = match.getRightTeam();
		
		ImageLabel image1 = new ImageLabel(ImageSaver.getTeamIcon(leftTeam.getShortName())
				, (int) (115 * UIData.changeX), (int) (70 * UIData.changeY), (int) (200 * UIData.changeX), (int) (200 * UIData.changeY));
		this.add(image1);
		
		ImageLabel image2 = new ImageLabel(ImageSaver.getTeamIcon(rightTeam.getShortName())
				, (int) (1092 * UIData.changeX), (int) (70 * UIData.changeY), (int) (200 * UIData.changeX), (int) (200 * UIData.changeY));
		this.add(image2);
		
		for(int i = 0; i < num; i++){
			dataLabel[i] = new SingleDataLabel(getTitle(i), getMatchData(0, i), getMatchData(1, i), getAverData(0, i), getAverData(1, i));
			dataLabel[i].setLocation((int) (115 * UIData.changeX), (int) (300 * UIData.changeY + i * dataLabel[i].getHeight()));
			this.add(dataLabel[i]);
			}
		
		ImageLabel show1 = new ImageLabel(ImageSaver.getIcon("进度条粉"), (int) (320 * UIData.changeX), (int) (75 * UIData.changeY),
				(int) (100 * UIData.changeY), (int) (10 * UIData.changeY));
		this.add(show1);
		
		JLabel info1 = new JLabel("本场比赛数据", JLabel.CENTER);
		info1.setBounds(0, (int) (show1.getY() - 5 * UIData.changeY), this.getWidth(), (int) (20 * UIData.changeY));
		info1.setForeground(Color.WHITE);
		info1.setVisible(true);
		this.add(info1);
		
		ImageLabel show3 = new ImageLabel(ImageSaver.getIcon("进度条黄"), (int) (320 * UIData.changeX), (int) (105 * UIData.changeY),
				(int) (100 * UIData.changeY), (int) (10 * UIData.changeY));
		this.add(show3);
		
		ImageLabel show2 = new ImageLabel(ImageSaver.getIcon("进度条蓝"), (int) (990 * UIData.changeX), (int) (75 * UIData.changeY),
				(int) (100 * UIData.changeY), (int) (10 * UIData.changeY));
		this.add(show2);
		

		JLabel info2 = new JLabel("赛季平均数据", JLabel.CENTER);
		info2.setBounds(0, (int) (show3.getY() - 5 * UIData.changeY), this.getWidth(), (int) (20 * UIData.changeY));
		info2.setForeground(Color.WHITE);
		info2.setVisible(true);
		this.add(info2);
		
		ImageLabel show4 = new ImageLabel(ImageSaver.getIcon("进度条绿"), (int) (990 * UIData.changeX), (int) (105 * UIData.changeY),
				(int) (100 * UIData.changeY), (int) (10 * UIData.changeY));
		this.add(show4);
	}
	
	class SingleDataLabel extends JPanel{
		
		public SingleDataLabel(String _title, double matchL, double matchR, double averL, double averR){
			this.setVisible(true);
			this.setLayout(null);
			this.setOpaque(false);
			this.setSize((int) (1170 * UIData.changeX), (int) (120 * UIData.changeY));
			
			JLabel title = new JLabel(_title, JLabel.CENTER);
			title.setForeground(Color.WHITE);
			title.setBounds(0, 0, this.getWidth(), (int) (20 * UIData.changeY));
			title.setVisible(true);
			this.add(title);
			
			int maxLength = this.getWidth();
			double maxMatch = matchL + matchR;
			double maxAvg = averL + averR;
			int matchLengthL = (int) (maxLength * (matchL / maxMatch));
			int matchLengthR = (int) (maxLength * (matchR / maxMatch));
			int avgLengthL = (int) (maxLength * (averL / maxAvg));
			int avgLengthR = (int) (maxLength * (averR / maxAvg));
			
			JLabel info1 = new JLabel("  " + DataTransform.transDoubleTopointXXString(matchL) + one00PercentTrans(matchL / maxMatch), JLabel.LEFT);
			info1.setBounds(0, (int) (31 * UIData.changeY), (int) (300 * UIData.changeX), (int) (20 * UIData.changeY));
			info1.setForeground(Color.BLACK);
			info1.setVisible(true);
			this.add(info1);
			
			if(matchLengthL != 0){
				ImageLabel imageML = new ImageLabel(ImageSaver.getIcon("进度条粉"), (int) (0 * UIData.changeX), (int) (31 * UIData.changeY),
						matchLengthL, (int) (20 * UIData.changeY));
				this.add(imageML);
			}
			
			JLabel info2 = new JLabel(one00PercentTrans(matchR / maxMatch) + DataTransform.transDoubleTopointXXString(matchR) + "  ", JLabel.RIGHT);
			info2.setBounds(0, (int) (31 * UIData.changeY), maxLength, (int) (20 * UIData.changeY));
			info2.setForeground(Color.BLACK);
			info2.setVisible(true);
			this.add(info2);
			
			if(matchLengthR != 0){
				ImageLabel imageMR = new ImageLabel(ImageSaver.getIcon("进度条蓝"), matchLengthL, (int) (30 * UIData.changeY),
						matchLengthR, (int) (20 * UIData.changeY));
				this.add(imageMR);
			}
			
			JLabel info3 = new JLabel("  " + DataTransform.transDoubleTopointXXString(averL) + one00PercentTrans(averL / maxAvg), JLabel.LEFT);
			info3.setBounds(0, (int) (71 * UIData.changeY), (int) (300 * UIData.changeX), (int) (20 * UIData.changeY));
			info3.setForeground(Color.BLACK);
			info3.setVisible(true);
			this.add(info3);
			
			if(avgLengthL != 0){
				ImageLabel imageAL = new ImageLabel(ImageSaver.getIcon("进度条黄"), (int) (0 * UIData.changeX), (int) (71 * UIData.changeY),
						avgLengthL, (int) (20 * UIData.changeY));
				this.add(imageAL);
			}
			
			JLabel info4 = new JLabel(one00PercentTrans(averR / maxAvg) + DataTransform.transDoubleTopointXXString(averR) + "  ", JLabel.RIGHT);
			info4.setBounds(0, (int) (71 * UIData.changeY), maxLength, (int) (20 * UIData.changeY));
			info4.setForeground(Color.BLACK);
			info4.setVisible(true);
			this.add(info4);
				
			if(avgLengthR != 0){
				ImageLabel imageAR = new ImageLabel(ImageSaver.getIcon("进度条绿"), avgLengthL, (int) (70 * UIData.changeY),
						avgLengthR, (int) (20 * UIData.changeY));
				this.add(imageAR);
			}
			
		}
	}
	
	private String one00PercentTrans(double num){
		return " (" + DataTransform.transDoubleTopointXXString(num * 100) + "% ) ";
	}
	
	private double getAverData(int leftisZero, int i){
		Object returnVALUE = null;
		if(leftTeam.getShortName() != null)
		if(leftisZero == 0){
			TeamVO team = new TeamVO();
//					Controller.teamController.getOneTeamInfo(leftTeam.getShortName());
			switch(i){
			case 0: returnVALUE = team.getAver_teamScores();
			case 1: returnVALUE = team.getTeamFGP();
			case 2: returnVALUE = team.getAver_team3FG();
			case 3: returnVALUE = team.getTeam3FGP();
			case 4: returnVALUE = team.getAver_teamFTG();
			case 5: returnVALUE = team.getTeamFTGP();
			case 6: returnVALUE = team.getAver_teamAssists();
			case 7: returnVALUE = team.getAver_teamTotalRebounds();
			case 8: returnVALUE = team.getAver_teamOffenceRebounds();
			case 9: returnVALUE = team.getAver_teamDeffenceRebounds();
			case 10: returnVALUE = team.getAver_teamSteals();
			case 11: returnVALUE = team.getAver_teamBlocks();
			case 12: returnVALUE = team.getAver_teamFouls();
			case 13: returnVALUE = team.getAver_teamTurnovers();
			}
		}else{
			TeamVO team = new TeamVO();
//			= Controller.teamController.getOneTeamInfo(rightTeam.getShortName());
			switch(i){
			case 0: returnVALUE = team.getAver_teamScores();
			case 1: returnVALUE = team.getTeamFGP();
			case 2: returnVALUE = team.getAver_team3FG();
			case 3: returnVALUE = team.getTeam3FGP();
			case 4: returnVALUE = team.getAver_teamFTG();
			case 5: returnVALUE = team.getTeamFTGP();
			case 6: returnVALUE = team.getAver_teamAssists();
			case 7: returnVALUE = team.getAver_teamTotalRebounds();
			case 8: returnVALUE = team.getAver_teamOffenceRebounds();
			case 9: returnVALUE = team.getAver_teamDeffenceRebounds();
			case 10: returnVALUE = team.getAver_teamSteals();
			case 11: returnVALUE = team.getAver_teamBlocks();
			case 12: returnVALUE = team.getAver_teamFouls();
			case 13: returnVALUE = team.getAver_teamTurnovers();
			}
		}
		if(returnVALUE != null)
			return (double)returnVALUE;
		return 0;
	}
	
	private double getMatchData(int leftisZero, int i){
		if(leftisZero == 0){
			switch(i){
			case 0: return leftTeam.getTeamScores();
			case 1: return leftTeam.getTeamFGP();
			case 2: return leftTeam.getTeam3FG();
			case 3: return leftTeam.getTeam3FGP();
			case 4: return leftTeam.getTeamFTG();
			case 5: return leftTeam.getTeamFTGP();
			case 6: return leftTeam.getTeamAssists();
			case 7: return leftTeam.getTeamTotalRebounds();
			case 8: return leftTeam.getTeamOffenceRebounds();
			case 9: return leftTeam.getTeamDeffenceRebounds();
			case 10: return leftTeam.getTeamSteals();
			case 11: return leftTeam.getTeamBlocks();
			case 12: return leftTeam.getTeamFouls();
			case 13: return leftTeam.getTeamTurnovers();
			}
		}else{
			switch(i){
			case 0: return rightTeam.getTeamScores();
			case 1: return rightTeam.getTeamFGP();
			case 2: return rightTeam.getTeam3FG();
			case 3: return rightTeam.getTeam3FGP();
			case 4: return rightTeam.getTeamFTG();
			case 5: return rightTeam.getTeamFTGP();
			case 6: return rightTeam.getTeamAssists();
			case 7: return rightTeam.getTeamTotalRebounds();
			case 8: return rightTeam.getTeamOffenceRebounds();
			case 9: return rightTeam.getTeamDeffenceRebounds();
			case 10: return rightTeam.getTeamSteals();
			case 11: return rightTeam.getTeamBlocks();
			case 12: return rightTeam.getTeamFouls();
			case 13: return rightTeam.getTeamTurnovers();
			}
			
		}
		return 0;
	}
	
	private String getTitle(int i){
		switch(i){
		case 0: return "得分";
		case 1: return "命中率";
		case 2: return "三分命中数";
		case 3: return "三分命中率";
		case 4: return "罚球命中数";
		case 5: return "罚球命中率";
		case 6: return "助攻";
		case 7: return "总篮板";
		case 8: return "进攻篮板";
		case 9: return "防守篮板";
		case 10: return "抢断";
		case 11: return "盖帽";
		case 12: return "犯规";
		case 13: return "失误";
		}
		return null;
	}

}
