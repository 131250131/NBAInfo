package userInterface.ui.hotspotUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class StandingPanel extends JPanel{
	
	int x = HotSpotBounds.standingPanelX;
	int y = HotSpotBounds.standingPanelY;
	int width = HotSpotBounds.standingPanelSizeX;
	int height = HotSpotBounds.standingPanelSizeY;
	
	JLabel panelBack;
	JLabel stepLabel;
	SinglePanel[] singlePanel = new SinglePanel[5];
	
	public StandingPanel(){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);	
	
		stepLabel = new JLabel(".");
		stepLabel.setBounds(0, 0, 1000, 50);
		stepLabel.setVisible(true);
		stepLabel.setForeground(Color.WHITE);
		stepLabel.setFont(new Font("OCR A Std", Font.PLAIN, 30));
		this.add(stepLabel);
		
		for(int i = 0; i < 5; i++){
			singlePanel[i] = new SinglePanel();
			this.add(singlePanel[i]);
		}
		
		panelBack = new JLabel(ImageSaver.getIcon("standingBack"));
		panelBack.setVisible(true);
		panelBack.setBounds(0, 0, width, height);
		this.add(panelBack);
		
		updateStanding(0, 0);
	}
	
	private void updateStanding(int kindIndex, int itemIndex){
		
		int step = getStep(kindIndex, itemIndex);
		String blank = "      ";
		stepLabel.setText("       " + transToTwoNum(step * 5) + blank + transToTwoNum(step * 4) 
				+ blank + transToTwoNum(step * 3) + blank + transToTwoNum(step * 2) + blank + transToTwoNum(step));
		
		singlePanel[0].updatePanel(53, step, 0, "Allen Crabbe");
		singlePanel[1].updatePanel(42, step, 1, "James Johnson");
		singlePanel[2].updatePanel(38, step, 2, "Jan Vesely");
		singlePanel[3].updatePanel(14, step, 3, "Chris Bosh");
		singlePanel[4].updatePanel(8, step, 4, "Melvin Ely");
		
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

}
