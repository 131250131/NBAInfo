package userInterface.ui.matchUI;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MatchScrollPane extends JScrollPane{
	
	int x = MatchBounds.scrollPaneX; 
	int y = MatchBounds.scrollPaneY;
	int width = MatchBounds.scrollPaneSizeX;
	int height = MatchBounds.scrollPaneSizeY;
	
	public MatchScrollPane(){
		
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.setVisible(true);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
	}

}
