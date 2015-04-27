package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.UIData;

@SuppressWarnings("serial")
public class InfoPanel_Today extends JPanel{

	int x = HotspotBounds.InfoPanel_TodayX;
	int y = HotspotBounds.InfoPanel_TodayY;
	int width = HotspotBounds.InfoPanel_TodayWidth;
	int height = HotspotBounds.InfoPanel_TodayHeight;
	
	int num = 11;
	TextLabel[][] textLabel = new TextLabel[4][num];
	double[][] numArray = new double[2][num];
	
	public InfoPanel_Today(){
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
		case 0:return "今日得分数:    " ;
		case 1:return "今日助攻数:    " ;
		case 2:return "今日篮板数:    " ;
		case 3:return "今日抢断数:    " ;
		case 4:return "今日盖帽数:    " ;
		
		case 5:return "今日失误数:    " ;
		case 6:return "今日命中率:";
		case 7:return "今日罚球命中率:";
		case 8:return "今日三分命中率:" ;
		case 9:return "今日上场时间数:";
		
		case 10:return "今日效率:  ";
		}
		
		return null;
	}
	
	private String getInfoNum1(int i){
		switch(i){
		case 0:numArray[0][i] = 10;return "" + 10;
		case 1:numArray[0][i] = 2;return "" + 2;
		case 2:numArray[0][i] = 7;return "" + 7;
		case 3:numArray[0][i] = 3;return "" + 3;
		case 4:numArray[0][i] = 2;return "" + 2;
		
		case 5:numArray[0][i] = 4;return "" + 4;
		case 6:numArray[0][i] = 0.612;return "" + 0.612;
		case 7:numArray[0][i] = 0.760;return "" + 0.760;
		case 8:numArray[0][i] = 0.201;return "" + 0.201;
		case 9:numArray[0][i] = 23.01;return "" + 23.01;
		
		case 10:numArray[0][i] = 7.134;return "" + 7.134;
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
		case 6:return  ":平均命中率";
		case 7:return  ":平均罚球命中率";
		case 8:return  ":平均三分命中率";
		case 9:return  ":平均上场时间数" ;

		case 10:return "  :平均效率";
		}
		
		return null;
	}
	
	private String getInfoNum2(int i){
		
		switch(i){
		case 0:numArray[1][i] = 12.10;return  12.10 + "";
		case 1:numArray[1][i] = 2.30;return  2.30 + "";
		case 2:numArray[1][i] = 7.15;return  7.15 + "";
		case 3:numArray[1][i] = 3.13;return  3.13 + "";
		case 4:numArray[1][i] = 2.12;return  2.12 + "" ;
		
		case 5:numArray[1][i] = 4.2;return  4.2 + "";
		case 6:numArray[1][i] = 0.810;return  0.810 + "";
		case 7:numArray[1][i] = 0.400;return  0.400 + "";
		case 8:numArray[1][i] = 0.520;return  0.520 + "";
		case 9:numArray[1][i] = 19.54;return  19.54 + "" ;

		case 10:numArray[1][i] = 9.134;return 9.134 + "";
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
