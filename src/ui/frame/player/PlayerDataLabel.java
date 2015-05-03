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

	int num1 = 19;
	SingleDataLabel[] singleDataLabel = new SingleDataLabel[num1];
	
	PlayerVO player;
	
	public PlayerDataLabel(int x, int y, int width, int height, PlayerVO player){
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		//this.setOpaque(false);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.6f));
		this.player = player;
		
		for(int i = 0; i < num1; i++){
			singleDataLabel[i] = new SingleDataLabel(getAverTitle(i),getAverData(0,i),getAverData(1,i), getAverData(2,i));
			singleDataLabel[i].setBounds((int) (150 * UIData.changeX), (int) ((80 * i + 60) * UIData.changeY)
					, (int) (1000 * UIData.changeX), (int) (70 * UIData.changeX));
			this.add(singleDataLabel[i]);
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
				return player.getPlayerFGP();
			case 4:
				return player.getAver_player3FG();
			case 5:
				return player.getAver_player3FGTry();
			case 6:
				return player.getPlayer3FGP();
			case 7:
				return player.getAver_playerFTG();
			case 8:
				return player.getAver_playerFTGTry();
			case 9:
				return player.getPlayerFTGP();
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
			
			ImageLabel imageSelf = new ImageLabel(ImageSaver.getIcon("进度条粉"), (int) (160 * UIData.changeX), (int) (10 * UIData.changeY),
					selfLength, (int) (20 * UIData.changeY));
			this.add(imageSelf);
			
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
}
