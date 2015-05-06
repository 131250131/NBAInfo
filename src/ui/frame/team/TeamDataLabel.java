package ui.frame.team;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.TeamVO;

@SuppressWarnings("serial")
public class TeamDataLabel extends JPanel{

	int num1 = 18, num2 = 15;
	SingleDataLabel[] singleDataLabel = new SingleDataLabel[num1];
	SingleDataLabel2[] singleDataLabel2 = new SingleDataLabel2[num2];
	
	TeamVO team;
	
	public TeamDataLabel(int x, int y, int width, int height, TeamVO team){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		this.team = team;
		
		for(int i = 0; i < num1; i++){
			singleDataLabel[i] = new SingleDataLabel(getAverTitle(i), getAverData(0, i), getAverData(1, i), getAverData(2, i));
			singleDataLabel[i].setBounds((int) (150 * UIData.changeX), (int) ((80 * i + 60) * UIData.changeY)
					, (int) (1000 * UIData.changeX), (int) (70 * UIData.changeX));
			this.add(singleDataLabel[i]);
		}
		
		for(int i = 0; i < num2; i++){
			singleDataLabel2[i] = new SingleDataLabel2(getAllTitle(i), getAllData(0, i), getAllData(1, i), getAllData(2, i));
			singleDataLabel2[i].setBounds((int) (150 * UIData.changeX), (int) ((80 * num1 + 60 + 40 + 80 * i) * UIData.changeY)
					, (int) (1000 * UIData.changeX), (int) (70 * UIData.changeX));
			this.add(singleDataLabel2[i]);
		}
	}
	
	private String getAllTitle(int i){
		switch(i){
		case 0:
			return "赛季总得分";
		case 1:
			return "赛季命中数";
		case 2:
			return "赛季出手数";
		case 3:
			return "赛季三分命中数";
		case 4:
			return "赛季三分出手数";
		case 5:
			return "赛季罚球命中数";
		case 6:
			return "赛季罚球出手数";
		case 7:
			return "赛季总助攻数";
		case 8:
			return "赛季总篮板数";
		case 9:
			return "赛季进攻篮板数";
		case 10:
			return "赛季防守篮板数";
		case 11:
			return "赛季总盖帽数";
		case 12:
			return "赛季总抢断数";
		case 13:
			return "赛季总失误数";
		case 14:
			return "赛季总犯规数";
		}
		return null;
	}
	
	private double getAllData(int type, int i){
		if(type == 0){
			switch(i){
			case 0:
				return team.getTeamScores();
			case 1:
				return team.getTeamFG();
			case 2:
				return team.getTeamFGTry();
			case 3:
				return team.getTeam3FG();
			case 4:
				return team.getTeam3FGTry();
			case 5:
				return team.getTeamFTG();
			case 6:
				return team.getTeamFTGTry();
			case 7:
				return team.getTeamAssists();
			case 8:
				return team.getTeamTotalRebounds();
			case 9:
				return team.getTeamOffenceRebounds();
			case 10:
				return team.getTeamDeffenceRebounds();
			case 11:
				return team.getTeamBlocks();
			case 12:
				return team.getTeamSteals();
			case 13:
				return team.getTeamTurnovers();
			case 14:
				return team.getTeamFouls();
			}
			return 0;
		}else if(type == 1){		
			switch(i){
			case 0:
				return team2.getTeamScores() * 1.12;
			case 1:
				return team2.getTeamFG() * 1.12;
			case 2:
				return team2.getTeamFGTry() * 1.12;
			case 3:
				return team2.getTeam3FG() * 1.12;
			case 4:
				return team2.getTeam3FGTry() * 1.12;
			case 5:
				return team2.getTeamFTG() * 1.12;
			case 6:
				return team2.getTeamFTGTry() * 1.12;
			case 7:
				return team2.getTeamAssists() * 1.12;
			case 8:
				return team2.getTeamTotalRebounds() * 1.12;
			case 9:
				return team2.getTeamOffenceRebounds() * 1.12;
			case 10:
				return team2.getTeamDeffenceRebounds() * 1.12;
			case 11:
				return team2.getTeamBlocks() * 1.12;
			case 12:
				return team2.getTeamSteals() * 1.12;
			case 13:
				return team2.getTeamTurnovers() * 1.12;
			case 14:
				return team2.getTeamFouls() * 1.12;
			}
			return 0;
		}else{
			switch(i){
			case 0:
				return team2.getTeamScores() * 2;
			case 1:
				return team2.getTeamFG() * 2;
			case 2:
				return team2.getTeamFGTry() * 2;
			case 3:
				return team2.getTeam3FG() * 2;
			case 4:
				return team2.getTeam3FGTry() * 2;
			case 5:
				return team2.getTeamFTG() * 2;
			case 6:
				return team2.getTeamFTGTry() * 2;
			case 7:
				return team2.getTeamAssists() * 2;
			case 8:
				return team2.getTeamTotalRebounds() * 2;
			case 9:
				return team2.getTeamOffenceRebounds() * 2;
			case 10:
				return team2.getTeamDeffenceRebounds() * 2;
			case 11:
				return team2.getTeamBlocks() * 2;
			case 12:
				return team2.getTeamSteals() * 2;
			case 13:
				return team2.getTeamTurnovers() * 2;
			case 14:
				return team2.getTeamFouls() * 2;
			}
			return 0;
		}
	}
	
	private String getAverTitle(int i){
		switch(i){
		case 0:
			return "场均得分";
		case 1:
			return "场均两分命中数";
		case 2:
			return "场均两分出手数";
		case 3:
			return "赛季两分命中率";
		case 4:
			return "场均三分命中数";
		case 5:
			return "场均三分出手数";
		case 6:
			return "赛季三分命中率";
		case 7:
			return "赛季罚球命中数";
		case 8:
			return "赛季罚球出手数";
		case 9:
			return "赛季罚球命中率";
		case 10:
			return "平均篮板数";
		case 11:
			return "平均进攻篮板数";
		case 12:
			return "平均防守篮板数";
		case 13:
			return "平均助攻数";
		case 14:
			return "平均盖帽数";
		case 15:
			return "平均抢断数";
		case 16:
			return "平均失误数";
		case 17:
			return "平均犯规数";
		}
		return null;
	}
	
	TeamVO team2 = Controller.teamController.getOneTeamInfo("BOS");
	
	private double getAverData(int type, int i){
		if(type == 0){
			switch(i){
			case 0:
				return team.getAver_teamScores();
			case 1:
				return team.getAver_teamFG();
			case 2:
				return team.getAver_teamFGTry();
			case 3:
				return team.getTeamFGP();
			case 4:
				return team.getAver_team3FG();
			case 5:
				return team.getAver_team3FGTry();
			case 6:
				return team.getTeam3FGP();
			case 7:
				return team.getAver_teamFTG();
			case 8:
				return team.getAver_teamFTGTry();
			case 9:
				return team.getTeamFTGP();
			case 10:
				return team.getAver_teamTotalRebounds();
			case 11:
				return team.getAver_teamOffenceRebounds();
			case 12:
				return team.getAver_teamDeffenceRebounds();
			case 13:
				return team.getAver_teamAssists();
			case 14:
				return team.getAver_teamBlocks();
			case 15:
				return team.getAver_teamSteals();
			case 16:
				return team.getAver_teamTurnovers();
			case 17:
				return team.getAver_teamFouls();
			}
			return 0;
		}else if(type == 1){
			switch(i){
			case 0:
				return team2.getAver_teamScores() * 1.12;
			case 1:
				return team2.getAver_teamFG() * 1.12;
			case 2:
				return team2.getAver_teamFGTry() * 1.12;
			case 3:
				return team2.getTeamFGP() * 1.12;
			case 4:
				return team2.getAver_team3FG() * 1.12;
			case 5:
				return team2.getAver_team3FGTry() * 1.12;
			case 6:
				return team2.getTeam3FGP() * 1.12;
			case 7:
				return team2.getAver_teamFTG() * 1.12;
			case 8:
				return team2.getAver_teamFTGTry() * 1.12;
			case 9:
				return team2.getTeamFTGP() * 1.12;
			case 10:
				return team2.getAver_teamTotalRebounds() * 1.12;
			case 11:
				return team2.getAver_teamOffenceRebounds() * 1.12;
			case 12:
				return team2.getAver_teamDeffenceRebounds() * 1.12;
			case 13:
				return team2.getAver_teamAssists() * 1.12;
			case 14:
				return team2.getAver_teamBlocks() * 1.12;
			case 15:
				return team2.getAver_teamSteals() * 1.12;
			case 16:
				return team2.getAver_teamTurnovers() * 1.12;
			case 17:
				return team2.getAver_teamFouls() * 1.12;
			}
			return 0;
		}else{
			switch(i){
			case 0:
				return team2.getAver_teamScores() * 2;
			case 1:
				return team2.getAver_teamFG() * 2;
			case 2:
				return team2.getAver_teamFGTry() * 2;
			case 3:
				return 1;
			case 4:
				return team2.getAver_team3FG() * 2;
			case 5:
				return team2.getAver_team3FGTry() * 2;
			case 6:
				return 1;
			case 7:
				return team2.getAver_teamFTG() * 2;
			case 8:
				return team2.getAver_teamFTGTry() * 2;
			case 9:
				return 1;
			case 10:
				return team2.getAver_teamTotalRebounds() * 2;
			case 11:
				return team2.getAver_teamOffenceRebounds() * 2;
			case 12:
				return team2.getAver_teamDeffenceRebounds() * 2;
			case 13:
				return team2.getAver_teamAssists() * 2;
			case 14:
				return team2.getAver_teamBlocks() * 2;
			case 15:
				return team2.getAver_teamSteals() * 2;
			case 16:
				return team2.getAver_teamTurnovers() * 2;
			case 17:
				return team2.getAver_teamFouls() * 2;
			}
			return 0;
		}
		
	}
	
	class SingleDataLabel extends JPanel{
		
		public SingleDataLabel(String title, double self, double avg, double max){
			
			this.setVisible(true);
			this.setOpaque(false);
			this.setLayout(null);
			
			int maxLength = (int) (850 * UIData.changeX);
			int selfLength = (int) (maxLength * (self / max));
			int avgLength = (int) (maxLength * (avg / max));
			
			if(selfLength != 0){
				ImageLabel imageSelf = new ImageLabel(ImageSaver.getIcon("进度条粉"), (int) (160 * UIData.changeX), (int) (10 * UIData.changeY),
						selfLength, (int) (20 * UIData.changeY));
				this.add(imageSelf);
			}
			
			JLabel selfLabel = new JLabel(DataTransform.transDoubleTopointXXString(self));
			selfLabel.setBounds((int) (175 * UIData.changeX + selfLength), (int) (10 * UIData.changeY),
					(int) (100 * UIData.changeX), (int) (20 * UIData.changeY));
			selfLabel.setVisible(true);
			selfLabel.setForeground(Color.WHITE);
			this.add(selfLabel);
			
			ImageLabel imageAvg = new ImageLabel(ImageSaver.getIcon("进度条蓝"), (int) (160 * UIData.changeX), (int) (40 * UIData.changeY),
					avgLength, (int) (20 * UIData.changeY));
			this.add(imageAvg);
			
			JLabel avgLabel = new JLabel(DataTransform.transDoubleTopointXXString(avg));
			avgLabel.setBounds((int) (175 * UIData.changeX + avgLength), (int) (40 * UIData.changeY),
					(int) (100 * UIData.changeX), (int) (20 * UIData.changeY));
			avgLabel.setVisible(true);
			avgLabel.setForeground(Color.WHITE);
			this.add(avgLabel);
			
			int titleHeight = (int) (20 * UIData.changeY);
 			int titleY = (int) (25 * UIData.changeY);
			JLabel titleLabel = new JLabel(title, JLabel.RIGHT);
			titleLabel.setBounds(0, titleY, (int) (150 * UIData.changeX), titleHeight);
			titleLabel.setVisible(true);
			titleLabel.setForeground(Color.WHITE);
			this.add(titleLabel);
		}
	}
	
	class SingleDataLabel2 extends JPanel{
		
		public SingleDataLabel2(String title, double self, double avg, double max){
			
			this.setVisible(true);
			this.setOpaque(false);
			this.setLayout(null);
				
			int maxLength = (int) (850 * UIData.changeX);			
			int selfLength = (int) (maxLength * (self / max));
			int avgLength = (int) (maxLength * (avg / max));
			
			if(selfLength != 0){
				ImageLabel imageSelf = new ImageLabel(ImageSaver.getIcon("进度条黄"), (int) (160 * UIData.changeX), (int) (10 * UIData.changeY),
						selfLength, (int) (20 * UIData.changeY));
				this.add(imageSelf);
			}
			
			JLabel selfLabel = new JLabel(DataTransform.transDoubleTopointXXString(self));
			selfLabel.setBounds((int) (175 * UIData.changeX + selfLength), (int) (10 * UIData.changeY),
					(int) (100 * UIData.changeX), (int) (20 * UIData.changeY));
			selfLabel.setVisible(true);
			selfLabel.setForeground(Color.WHITE);
			this.add(selfLabel);
			
			ImageLabel imageAvg = new ImageLabel(ImageSaver.getIcon("进度条绿"), (int) (160 * UIData.changeX), (int) (40 * UIData.changeY),
					avgLength, (int) (20 * UIData.changeY));
			this.add(imageAvg);
			
			JLabel avgLabel = new JLabel(DataTransform.transDoubleTopointXXString(avg));
			avgLabel.setBounds((int) (175 * UIData.changeX + avgLength), (int) (40 * UIData.changeY),
					(int) (100 * UIData.changeX), (int) (20 * UIData.changeY));
			avgLabel.setVisible(true);
			avgLabel.setForeground(Color.WHITE);
			this.add(avgLabel);
			
			int titleHeight = (int) (20 * UIData.changeY);
 			int titleY = (int) (25 * UIData.changeY);
			JLabel titleLabel = new JLabel(title, JLabel.RIGHT);
			titleLabel.setBounds(0, titleY, (int) (150 * UIData.changeX), titleHeight);
			titleLabel.setVisible(true);
			titleLabel.setForeground(Color.WHITE);
			this.add(titleLabel);
		}
	}
}
