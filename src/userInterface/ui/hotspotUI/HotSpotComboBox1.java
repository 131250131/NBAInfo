package userInterface.ui.hotspotUI;

import java.awt.Color;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class HotSpotComboBox1 extends JComboBox<String>{
	
	int x = HotSpotBounds.comboBox1X;
	int y = HotSpotBounds.comboBox1Y;
	int width = HotSpotBounds.comboBoxSize1X;
	int height = HotSpotBounds.comboBoxSize1Y;
	
	public HotSpotComboBox1(){
		this.setBounds(x, y, width, height);
		addItem();
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);	
	}
	
	private void addItem(){	
		this.addItem("Recent Player");
		this.addItem("All-Time Player");
		this.addItem("Team");
		
	}

}
