package userInterface.ui.hotspotUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HotSpotPanel extends JPanel{
	
	int x = HotSpotBounds.panelX;
	int y = HotSpotBounds.panelY;
	int width = HotSpotBounds.panelSizeX;
	int height = HotSpotBounds.panelSizeY;
	
	HotSpotComboBox1 comboBox1;
	HotSpotComboBox2 comboBox2;
	JButton searchButton;
	StandingPanel standingPanel;
	
	public HotSpotPanel(){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);
		
		searchButton = new JButton("Check");
		searchButton.setBounds(HotSpotBounds.searchButtonX, HotSpotBounds.searchButtonY,
				HotSpotBounds.searchButtonSizeX, HotSpotBounds.searchButtonSizeY);
		searchButton.setBackground(Color.DARK_GRAY);
		searchButton.setForeground(Color.WHITE);
		searchButton.setVisible(true);
		this.add(searchButton);
		
		comboBox1 = new HotSpotComboBox1();
		this.add(comboBox1);
		
		comboBox2 = new HotSpotComboBox2();
		this.add(comboBox2);
		
		standingPanel = new StandingPanel();
		this.add(standingPanel);
	}

}
