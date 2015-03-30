package userInterface.ui.indexUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class TodayMatchButton extends JButton{
	
	int X = IndexBounds.TodayMatchButtonX;
	int upY = IndexBounds.TodayMatchButtonUpY;
	int downY = IndexBounds.TodayMatchButtonDownY;
	int sizeX = IndexBounds.TodayMatchButtonSizeX;
	int sizeY = IndexBounds.TodayMatchButtonSizeY;
	
	public TodayMatchButton(int i){
		
		this.setBackground(new Color( 16, 22, 32));
		this.setForeground(new Color( 197, 197, 197));	
		this.setFont(new Font("华文琥珀", Font.BOLD, 9));
		this.setVisible(true);
		this.setBorder(BorderFactory.createRaisedBevelBorder());

		if(i == 0){
			this.setBounds(X, upY, sizeX, sizeY);
			this.setText("↑");
		}else{
			this.setBounds(X, downY, sizeX, sizeY);
			this.setText("↓");
		}
	}

}
