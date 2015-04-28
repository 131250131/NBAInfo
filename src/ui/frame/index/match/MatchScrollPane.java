package ui.frame.index.match;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import ui.system.UIData;

@SuppressWarnings("serial")
public class MatchScrollPane extends JScrollPane{
	
	int x = (int) ((85 + 135) * UIData.changeX); 
	int y = (int) (250 * UIData.changeY);
	int width = (int) (1515 * UIData.changeX);
	int height = (int) (800 * UIData.changeY);

	public MatchScrollPane(){
		
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.setVisible(true);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		this.getVerticalScrollBar().setUnitIncrement(20);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
	}
	
}
