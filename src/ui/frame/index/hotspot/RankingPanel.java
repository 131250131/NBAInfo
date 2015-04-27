package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.UIData;

@SuppressWarnings("serial")
public class RankingPanel extends JPanel{
	
	int x = HotspotBounds.rankingPanelX;
	int y = HotspotBounds.rankingPanelY;
	int width = HotspotBounds.rankingPanelWidth;
	int height = HotspotBounds.rankingPanelHeight;
	
	JLabel panelBack;
	SinglePanel[] singlePanel = new SinglePanel[5];
	StepLabel[] stepLabel = new StepLabel[5];
	
	public RankingPanel(){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		//this.setOpaque(false);
		this.setLayout(null);	
		this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.9f));
		
		int step = width / 6;
		
		for(int i = 0; i < 5; i++){
			stepLabel[i] = new StepLabel();
			stepLabel[i].setLocation((int)(20 * UIData.changeX + step * (i + 1)), (int)(20 * UIData.changeY));
			this.add(stepLabel[i]);
		}
		
		for(int i = 0; i < 5; i++){
			singlePanel[i] = new SinglePanel(i);
			this.add(singlePanel[i]);
		}
	
		updateStanding(0, 0);
	}
	
	private void updateStanding(int kindIndex, int itemIndex){
		
		int step = getStep(kindIndex, itemIndex);
		for(int i = 0; i < 5; i++){
			stepLabel[i].setText(transToTwoNum(step * (5 - i)));
		}
		singlePanel[0].updatePanel(51, step, "Allen Crabbe");
		singlePanel[1].updatePanel(47, step, "James Johnson");
		singlePanel[2].updatePanel(32, step, "Jan Vesely");
		singlePanel[3].updatePanel(21, step, "Chris Bosh");
		singlePanel[4].updatePanel(14, step, "Melvin Ely");
		
	}
	
	private String transToTwoNum(int num){                                                                                                   
		if(num < 10){
			return "0" + String.valueOf(num);
		}
		return String.valueOf(num);
	}
	
	private int getStep(int kindIndex, int itemIndex){
		
		int step = 0;
		
		if(kindIndex != 2){
			switch(itemIndex){
			case 0:
				step = 50;break;
			case 1:
				step = 15;break;
			case 2:
				step = 15;break;
			case 3:
				step = 10;break;
			case 4:
				step = 10;break;
			}	
		}else{
			switch(itemIndex){
			case 0:
				step = 120;break;
			case 1:
				step = 30;break;
			case 2:
				step = 40;break;
			case 3:
				step = 15;break;
			case 4:
				step = 15;break;
			}
			
		}
		return step / 5;
	}

	class StepLabel extends JLabel{
		
		public StepLabel(){
			this.setSize((int)(200 * UIData.changeX), (int)(50 * UIData.changeY));
			this.setVisible(true);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("OCR A Std", Font.PLAIN, (int)(30 * UIData.changeY)));
		}
	}
	
}

