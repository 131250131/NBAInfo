package userInterface.ui.mainFrame;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")

/*
 *这是位于最底层的滑动Panel 
 */
public class ContainerScrollPane extends JScrollPane{
	
	public ContainerScrollPane(){
		
		this.setBounds(50, 25, 1180 + 50 - 2, 720 - 50 + 8 + 6);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
	}

}
