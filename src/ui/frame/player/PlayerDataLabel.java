package ui.frame.player;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.DataTransform;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class PlayerDataLabel extends JPanel{

	int num1 = 19, num2 = 16;
	SingleDataLabel[] singleDataLabel = new SingleDataLabel[num1];
	SingleDataLabel2[] singleDataLabel2 = new SingleDataLabel2[num2];
	
	PlayerVO player;
	
	public PlayerDataLabel(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		this.player = player;
		
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
		case 15:
			return "赛季PER效率";
	
		}
		return null;
	}
	
	private double getAllData(int type, int i){
		if(type == 0){
			switch(i){
			case 0:
				return player.getPlayerScores();
			case 1:
				return player.getPlayerFG();
			case 2:
				return player.getPlayerFGTry();
			case 3:
				return player.getPlayer3FG();
			case 4:
				return player.getPlayer3FGTry();
			case 5:
				return player.getPlayerFTG();
			case 6:
				return player.getPlayerFTGTry();
			case 7:
				return player.getPlayerAssists();
			case 8:
				return player.getPlayerTotalRebounds();
			case 9:
				return player.getPlayerOffenceRebounds();
			case 10:
				return player.getPlayerDeffenceRebounds();
			case 11:
				return player.getPlayerBlocks();
			case 12:
				return player.getPlayerSteals();
			case 13:
				return player.getPlayerTurnovers();
			case 14:
				return player.getPlayerFouls();
			case 15:
				return player.getPlayerPER();
			}
			return 0;
		}else if(type == 1){
			switch(i){
			case 0:
				return 20 * player.getPlayerAttends();
			case 1:
				return 10 * player.getPlayerAttends();
			case 2:
				return 15 * player.getPlayerAttends();
			case 3:
				return 3 * player.getPlayerAttends();
			case 4:
				return 5 * player.getPlayerAttends();
			case 5:
				return 7 * player.getPlayerAttends();
			case 6:
				return 13 * player.getPlayerAttends();
			case 7:
				return 5 * player.getPlayerAttends();
			case 8:
				return 6 * player.getPlayerAttends();
			case 9:
				return 2 * player.getPlayerAttends();
			case 10:
				return 4 * player.getPlayerAttends();
			case 11:
				return 3 * player.getPlayerAttends();
			case 12:
				return 4 * player.getPlayerAttends();
			case 13:
				return 4 * player.getPlayerAttends();
			case 14:
				return 3.2 * player.getPlayerAttends();
			case 15:
				return 10.4;
			}
			return 0;
		}else{
			switch(i){
			case 0:
				return 50 * player.getPlayerAttends();
			case 1:
				return 20 * player.getPlayerAttends();
			case 2:
				return 30 * player.getPlayerAttends();
			case 3:
				return 10 * player.getPlayerAttends();
			case 4:
				return 10 * player.getPlayerAttends();
			case 5:
				return 10 * player.getPlayerAttends();
			case 6:
				return 20 * player.getPlayerAttends();
			case 7:
				return 20 * player.getPlayerAttends();
			case 8:
				return 10 * player.getPlayerAttends();
			case 9:
				return 10 * player.getPlayerAttends();
			case 10:
				return 10 * player.getPlayerAttends();
			case 11:
				return 10 * player.getPlayerAttends();
			case 12:
				return 10 * player.getPlayerAttends();
			case 13:
				return 10 * player.getPlayerAttends();
			case 14:
				return 8 * player.getPlayerAttends();
			case 15:
				return 40;
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
		case 18:
			return "平均上场时间";
		}
		return null;
	}
	
	private double getAverData(int type, int i){
		if(type == 0){
			switch(i){
			case 0:
				return player.getAver_playerScores();
			case 1:
				return player.getAver_playerFG();
			case 2:
				return player.getAver_playerFGTry();
			case 3:
				return player.getPlayerFGP() / 100;
			case 4:
				return player.getAver_player3FG();
			case 5:
				return player.getAver_player3FGTry();
			case 6:
				return player.getPlayer3FGP() / 100;
			case 7:
				return player.getAver_playerFTG();
			case 8:
				return player.getAver_playerFTGTry();
			case 9:
				return player.getPlayerFTGP() / 100;
			case 10:
				return player.getAver_playerTotalRebounds();
			case 11:
				return player.getAver_playerOffenceRebounds();
			case 12:
				return player.getAver_playerDeffenceRebounds();
			case 13:
				return player.getAver_playerAssists();
			case 14:
				return player.getAver_playerBlocks();
			case 15:
				return player.getAver_playerSteals();
			case 16:
				return player.getAver_playerTurnovers();
			case 17:
				return player.getAver_playerFouls();
			case 18:
				return player.getAver_playerPlayTime() / 60;
			}
			return 0;
		}else if(type == 1){
			switch(i){
			case 0:
				return 20;
				//return Controller.associationController.;
			case 1:
				return 8;
			case 2:
				return 15;
			case 3:
				return 0.3;
			case 4:
				return 3;
			case 5:
				return 5;
			case 6:
				return 0.27;
			case 7:
				return 7;
			case 8:
				return 10;
			case 9:
				return 0.73;
			case 10:
				return 6;
			case 11:
				return 2;
			case 12:
				return 4;
			case 13:
				return 4;
			case 14:
				return 1.5;
			case 15:
				return 3;
			case 16:
				return 3;
			case 17:
				return 3.4;
			case 18:
				return 24;
			}
			return 0;
		}else{
			switch(i){
			case 0:
				return 50;
			case 1:
				return 40;
			case 2:
				return 40;
			case 3:
				return 1;
			case 4:
				return 20;
			case 5:
				return 20;
			case 6:
				return 1;
			case 7:
				return 30;
			case 8:
				return 30;
			case 9:
				return 1;
			case 10:
				return 15;
			case 11:
				return 10;
			case 12:
				return 10;
			case 13:
				return 15;
			case 14:
				return 10;
			case 15:
				return 10;
			case 16:
				return 10;
			case 17:
				return 8;
			case 18:
				return 60;
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
