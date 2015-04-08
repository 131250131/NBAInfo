package userInterface.ui.matchUI;

import java.awt.Color;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class MatchComboBox extends JComboBox<String>{
	
	int x = MatchBounds.MatchComboBoxX;
	int y = MatchBounds.MatchComboBoxY;
	int width = MatchBounds.MatchComboBoxSizeX;
	int height = MatchBounds.MatchComboBoxSizeY;
	
	public MatchComboBox(){
		this.setBounds(x, y, width, height);
		addItem();
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
	}
	
	private void addItem(){
		
		int itemSize = 10;

		for(int i = 0; i < itemSize; i++){
			this.addItem("MatchInfomation");
		}
	}
}
