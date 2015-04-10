package userInterface.ui.mainFrame;

import java.awt.Dimension;

import javax.swing.JPanel;


/*
 *这是位于最底层的Panel 
 */

@SuppressWarnings("serial")
public class ContainerPanel extends JPanel{
	
	public ContainerPanel(){
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1150 + 50 - 2, 720 * 4));
		this.setOpaque(false);
	}

}
