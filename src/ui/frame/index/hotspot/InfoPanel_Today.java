package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.DataTransform;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class InfoPanel_Today extends JPanel{

	int x = HotspotBounds.InfoPanel_TodayX;
	int y = HotspotBounds.InfoPanel_TodayY;
	int width = HotspotBounds.InfoPanel_TodayWidth;
	int height = HotspotBounds.InfoPanel_TodayHeight;
	
	int num = 11;
	TextLabel[][] textLabel = new TextLabel[4][num];
	double[][] numArray = new double[2][num];
	
	PlayerVO _player, allPlayer;
	
	public InfoPanel_Today(PlayerVO player){
		
		_player = player;
		allPlayer = player;
		
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setVisible(true);
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.7f));
		
		initText();
	}
	
	private void initText(){
		
		for(int i = 0; i < num; i++){
			textLabel[0][i] = new TextLabel(getInfoText1(i));
			int a = 0;
			if(i == num - 1){
				a = 1;
				textLabel[0][i].setForeground(Color.WHITE);
			}
			textLabel[0][i].setBounds((int) (10 * UIData.changeX), (int) ((100 + (i + a) * 40) * UIData.changeY),
					(int) (230 * UIData.changeX), (int) (30 * UIData.changeY));
			textLabel[0][i].setHorizontalAlignment(JLabel.LEFT);
			this.add(textLabel[0][i]);
		}
		
		for(int i = 0; i < num; i++){
			textLabel[1][i] = new TextLabel(getInfoNum1(i));
			int a = 0;
			if(i == num - 1){
				a = 1;
			}
			textLabel[1][i].setBounds((int) (25 * UIData.changeX), (int) ((100 + (i + a) * 40) * UIData.changeY),
					(int) (230 * UIData.changeX), (int) (30 * UIData.changeY));
			textLabel[1][i].setHorizontalAlignment(JLabel.RIGHT);
			this.add(textLabel[1][i]);
		}
		
		for(int i = 0; i < num; i++){
			textLabel[2][i] = new TextLabel(getInfoText2(i));
			int a = 0;
			if(i == num - 1){
				a = 1;
				textLabel[2][i].setForeground(Color.WHITE);
			}
			textLabel[2][i].setBounds((int) (338 * UIData.changeX), (int) ((100 + (i + a) * 40) * UIData.changeY),
					(int) (230 * UIData.changeX), (int) (30 * UIData.changeY));
			textLabel[2][i].setHorizontalAlignment(JLabel.RIGHT);
			this.add(textLabel[2][i]);
		}
		
		for(int i = 0; i < num; i++){
			textLabel[3][i] = new TextLabel(getInfoNum2(i));
			int a = 0;
			if(i == num - 1){
				a = 1;
			}
			textLabel[3][i].setBounds((int) (330 * UIData.changeX), (int) ((100 + (i + a) * 40) * UIData.changeY),
					(int) (230 * UIData.changeX), (int) (30 * UIData.changeY));
			textLabel[3][i].setHorizontalAlignment(JLabel.LEFT);			
			this.add(textLabel[3][i]);
		}
		
		changeColor();
		
	}
	
	private void changeColor(){
		for(int i = 0; i < num; i++){
			
			if(numArray[0][i] < numArray[1][i]){
				textLabel[3][i].setForeground(Color.ORANGE);
			}else if(numArray[0][i] == numArray[1][i]){
				textLabel[1][i].setForeground(Color.ORANGE);
				textLabel[3][i].setForeground(Color.ORANGE);
			}else{
				textLabel[1][i].setForeground(Color.ORANGE);
			}
			
		}
	}
	
	private String getInfoText1(int i){
		
		switch(i){
		case 0:return "最近得分数:    " ;
		case 1:return "最近助攻数:    " ;
		case 2:return "最近篮板数:    " ;
		case 3:return "最近抢断数:    " ;
		case 4:return "最近盖帽数:    " ;
		
		case 5:return "最近失误数:    " ;
		case 6:return "最近命中率:";
		case 7:return "最近罚球命中率:";
		case 8:return "最近三分命中率:" ;
		case 9:return "最近上场时间数:";
		
		case 10:return "最近效率:  ";
		}
		
		return null;
	}
	
	private String getInfoNum1(int i){
		switch(i){
		case 0:
			numArray[0][i] = DataTransform.transDoubleTopointXX(22);
			return  DataTransform.transDoubleTopointXXString(22) + "";
		case 1:
			numArray[0][i] = DataTransform.transDoubleTopointXX(6);
			return  DataTransform.transDoubleTopointXXString(6) + "";
		case 2:
			numArray[0][i] = DataTransform.transDoubleTopointXX(2);
			return  DataTransform.transDoubleTopointXXString(2) + "";
		case 3:
			numArray[0][i] = DataTransform.transDoubleTopointXX(1);
			return  DataTransform.transDoubleTopointXXString(1) + "";
		case 4:
			numArray[0][i] = DataTransform.transDoubleTopointXX(0);
			return  DataTransform.transDoubleTopointXXString(0) + "";	
		case 5:
			numArray[0][i] = DataTransform.transDoubleTopointXX(4);
			return  DataTransform.transDoubleTopointXXString(4) + "";	
		case 6:
			numArray[0][i] = DataTransform.transDoubleTopointXX(47.1);
			return  DataTransform.transDoubleTopointXXString(47.1) + "";	
		case 7:
			numArray[0][i] = DataTransform.transDoubleTopointXX(100);
			return  DataTransform.transDoubleTopointXXString(100) + "";
		case 8:
			numArray[0][i] = DataTransform.transDoubleTopointXX(57.1);
			return  DataTransform.transDoubleTopointXXString(57.1) + "";
		case 9:
			numArray[0][i] = DataTransform.transDoubleTopointXX(41.03);
			return  DataTransform.transDoubleTopointXXString(41.03) + "";
		case 10:
			numArray[0][i] = DataTransform.transDoubleTopointXX(23);
			return  DataTransform.transDoubleTopointXXString(23) + "";
		}
		
		return null;
	}
	
	private String getInfoText2(int i){
		
		switch(i){
		case 0:return  "    :平均得分数";
		case 1:return  "    :平均助攻数";
		case 2:return  "    :平均篮板数";
		case 3:return  "    :平均抢断数";
		case 4:return  "    :平均盖帽数" ;
		
		case 5:return  "    :平均失误数";
		case 6:return  ":赛季命中率";
		case 7:return  ":赛季罚球命中率";
		case 8:return  ":赛季三分命中率";
		case 9:return  ":平均上场时间数" ;

		case 10:return "  :平均效率";
		}
		
		return null;
	}
	
	private String getInfoNum2(int i){
		
		switch(i){
		case 0:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerScores());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerScores()) + "";
		case 1:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerAssists());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerAssists()) + "";
		case 2:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerTotalRebounds());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerTotalRebounds()) + "";
		case 3:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerSteals());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerSteals()) + "";
		case 4:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerBlocks());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerBlocks()) + "";	
		case 5:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerTurnovers());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerTurnovers()) + "";	
		case 6:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getPlayerFGP());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getPlayerFGP()) + "";	
		case 7:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getPlayerFTGP());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getPlayerFTGP()) + "";
		case 8:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getPlayer3FGP());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getPlayer3FGP()) + "";
		case 9:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getAver_playerPlayTime());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getAver_playerPlayTime()) + "";
		case 10:
			numArray[1][i] = DataTransform.transDoubleTopointXX(allPlayer.getPlayerPER());
			return  DataTransform.transDoubleTopointXXString(allPlayer.getPlayerPER()) + "";
		}
		
		return null;
	}
	
	class TextLabel extends JLabel{
		
		public TextLabel(String text){
			this.setText(text);
			this.setVisible(true);
			this.setFont(new Font("新細明體", Font.PLAIN, (int)(20 * UIData.changeY)));
			this.setForeground(Color.LIGHT_GRAY);
		}
	}
}
