package ui.frame.mainframe;

import ui.frame.index.container.LargerScrollPane;
import ui.myUI.MyFrame;

@SuppressWarnings("serial")
public class MainFrame extends MyFrame{
	
	LargerScrollPane largerScrollPane;
	
	public MainFrame(){		
		largerScrollPane = new LargerScrollPane();
		this.add(largerScrollPane);
		LargerScrollPane.turnto2.doClick();
	}

}
