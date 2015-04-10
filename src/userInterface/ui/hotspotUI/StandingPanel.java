package userInterface.ui.hotspotUI;

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
	
	public StandingPanel(){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);	
		
		panelBack = new JLabel(ImageSaver.getIcon("standingBack"));
		panelBack.setVisible(true);
		panelBack.setBounds(0, 0, width, height);
		this.add(panelBack);
	}

}
