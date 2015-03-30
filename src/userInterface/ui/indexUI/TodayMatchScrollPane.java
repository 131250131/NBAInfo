package userInterface.ui.indexUI;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TodayMatchScrollPane extends JScrollPane{
	
	int jspX = IndexBounds.todayMatchSPX;
	int jspY = IndexBounds.todayMatchSPY;
	int jspSizeX = IndexBounds.todayMatchSPSizeX;
	int jspSizeY = IndexBounds.todayMatchSPSizeY;
	
	public TodayMatchScrollPane(){
		this.setBounds(jspX, jspY, jspSizeX, jspSizeY);
		this.setVisible(true);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	}
}
