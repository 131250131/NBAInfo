package userInterface.ui.matchUI;

import java.awt.Color;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class TeamComboBox extends JComboBox<String>{
	
	int x = MatchBounds.TeamComboBoxX;
	int y = MatchBounds.TeamComboBoxY;
	int width = MatchBounds.TeamComboBoxSizeX;
	int height = MatchBounds.TeamComboBoxSizeY;
	
	public TeamComboBox(){
		this.setBounds(x, y, width, height);
		addItem();
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
	}
	
	private void addItem(){
		
		int itemSize = 10;

		for(int i = 0; i < itemSize; i++){
			this.addItem("TeamInfomation");
		}
	}
}
