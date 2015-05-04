package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.UIData;
import vo.MatchVO;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class InfoPanel_All extends JPanel{

	int x = HotspotBounds.InfoPanel_ALLX;
	int y = HotspotBounds.InfoPanel_ALLY;
	int width = HotspotBounds.InfoPanel_ALLWidth;
	int height = HotspotBounds.InfoPanel_ALLHeight;
	
	int num = 11;
	TextLabel[][] textLabel = new TextLabel[4][num];
	double[][] numArray = new double[2][num];
	
	PlayerVO _player, todayPlayer;
	
	public InfoPanel_All(PlayerVO player){
		
		_player = player;
		todayPlayer = player;
//		ArrayList<MatchVO> array = Controller.matchController.getMatchOfPlayer(player.getPlayerName());
//		boolean flag = true;
//		ArrayList<PlayerVO> list1 = array.get(array.size() - 1).getRightplayerlist();
//		ArrayList<PlayerVO> list2 = array.get(array.size() - 1).getLeftplayerlist();
//		
//		for(int i = 0; i < list1.size(); i++){
//			PlayerVO playerr = list1.get(i);
//			if(playerr.getPlayerName().equals(player.getPlayerName())){
//				todayPlayer = playerr;
//				flag = false;
//			}
//		}
		
//		if(flag == true){
//			for(int i = 0; i < list2.size(); i++){
//				PlayerVO playerr = list2.get(i);
//				if(playerr.getPlayerName().equals(player.getPlayerName())){
//					todayPlayer = playerr;
//				}
//			}
//		}
		
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
			textLabel[1][i].setBounds((int) (10 * UIData.changeX), (int) ((100 + (i + a) * 40) * UIData.changeY),
					(int) (245 * UIData.changeX), (int) (30 * UIData.changeY));
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
			textLabel[2][i].setBounds((int) (310 * UIData.changeX), (int) ((100 + (i + a) * 40) * UIData.changeY),
					(int) (255 * UIData.changeX), (int) (30 * UIData.changeY));
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
					(int) (260 * UIData.changeX), (int) (30 * UIData.changeY));
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
		case 0:return "最近一场得分:    " ;
		case 1:return "最近一场助攻:    " ;
		case 2:return "最近一场篮板:    " ;
		case 3:return "最近一场抢断:    " ;
		case 4:return "最近一场盖帽:    " ;
		
		case 5:return "最近一场失误:    " ;
		case 6:return "最近一场命中:";
		case 7:return "最近一场罚球命中:";
		case 8:return "最近一场三分命中:" ;
		case 9:return "最近一场上场时间:";
		
		case 10:return "最近一场效率:  ";
		}
		
		return null;
	}
	
	private String getInfoNum1(int i){
		switch(i){
		case 0:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerScores());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerScores()) + "";
		case 1:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerAssists());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerAssists()) + "";
		case 2:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerTotalRebounds());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerTotalRebounds()) + "";
		case 3:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerSteals());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerSteals()) + "";
		case 4:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerBlocks());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerBlocks()) + "";	
		case 5:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerTurnovers());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerTurnovers()) + "";	
		case 6:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerFGP());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerFGP()) + "";	
		case 7:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerFTGP());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerFTGP()) + "";
		case 8:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayer3FGP());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayer3FGP()) + "";
		case 9:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerPlayTime() / 60);
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerPlayTime() / 60) + "";
		case 10:
			numArray[0][i] = DataTransform.transDoubleTopointXX(todayPlayer.getPlayerGmScER());
			return  DataTransform.transDoubleTopointXXString(todayPlayer.getPlayerGmScER()) + "";
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
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerScores());
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerScores()) + "";
		case 1:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerAssists());
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerAssists()) + "";
		case 2:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerTotalRebounds());
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerTotalRebounds()) + "";
		case 3:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerSteals());
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerSteals()) + "";
		case 4:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerBlocks());
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerBlocks()) + "";	
		case 5:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerTurnovers());
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerTurnovers()) + "";	
		case 6:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getPlayerFGP());
			return  DataTransform.transDoubleTopointXXString(_player.getPlayerFGP()) + "";	
		case 7:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getPlayerFTGP());
			return  DataTransform.transDoubleTopointXXString(_player.getPlayerFTGP()) + "";
		case 8:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getPlayer3FGP());
			return  DataTransform.transDoubleTopointXXString(_player.getPlayer3FGP()) + "";
		case 9:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getAver_playerPlayTime() / 60);
			return  DataTransform.transDoubleTopointXXString(_player.getAver_playerPlayTime() / 60) + "";
		case 10:
			numArray[1][i] = DataTransform.transDoubleTopointXX(_player.getPlayerGmScER());
			return  DataTransform.transDoubleTopointXXString(_player.getPlayerGmScER()) + "";
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
