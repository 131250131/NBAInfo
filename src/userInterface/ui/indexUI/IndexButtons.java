package userInterface.ui.indexUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;


/*
 *这是位于最Index的快捷按钮 
 */

@SuppressWarnings("serial")
public class IndexButtons extends JButton{
	
	int buttonFirstX = IndexBounds.indexButtonFirstX;
	int buttonY = IndexBounds.indexButtonY;
	int buttonSizeX = IndexBounds.indexButtonSizeX;
	int buttonSizeY = IndexBounds.indexButtonSizeY;
		
	public IndexButtons(int index){	
		this.setBackground(new Color( 18, 31, 48));
		this.setBounds(buttonFirstX + buttonSizeX * index, buttonY, buttonSizeX, buttonSizeY);	
		this.setForeground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setVisible(true);
		this.setOpaque(true);
		this.setFont(new Font("Candara",Font.PLAIN ,15));
		
		switch(index){
		case 0 : this.setText("Matches");break;
		case 1 : this.setText("Players");break;
		case 2 : this.setText("Teams");break;
		case 3 : this.setText("Hotspots");break;
		case 4 : this.setText("Standings");break;
		case 5 : this.setText("more");break;
		}
	}
	
	public int getButtonFirstX(){
		return buttonFirstX;
	}

}
