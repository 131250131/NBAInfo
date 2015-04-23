package ui.myUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class OpaqueButton extends JButton{

	public OpaqueButton(){
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setVisible(true);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
	}
}
