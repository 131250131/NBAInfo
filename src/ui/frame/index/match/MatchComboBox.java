package ui.frame.index.match;

import java.awt.Color;

import javax.swing.JComboBox;

import ui.system.UIData;

@SuppressWarnings("serial")
public class MatchComboBox extends JComboBox<String>{
		
	public MatchComboBox(){
		this.setBounds((int) ((85  + 135) * UIData.changeX), (int) (190 * UIData.changeY),
				(int) (200 * UIData.changeX), (int) (35 * UIData.changeY));
		addItem();
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
	}
	
	private void addItem(){
		
		int itemSize = 10;

		for(int i = 0; i < itemSize; i++){
			this.addItem("比赛信息");
		}
	}
}
