package userInterface.ui.hotspotUI;

import java.awt.Color;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class HotSpotComboBox2 extends JComboBox<String>{
	
	int x = HotSpotBounds.comboBox2X;
	int y = HotSpotBounds.comboBox2Y;
	int width = HotSpotBounds.comboBoxSize2X;
	int height = HotSpotBounds.comboBoxSize2Y;
	
	public HotSpotComboBox2(){
		this.setBounds(x, y, width, height);
		addItem();
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);	
	}
	
	private void addItem(){	
		this.addItem("Scores");
		this.addItem("Assists");
		this.addItem("Rebounds");
		this.addItem("Blocks");
		this.addItem("Steals");
		this.addItem("Efficiency");
	}

}
