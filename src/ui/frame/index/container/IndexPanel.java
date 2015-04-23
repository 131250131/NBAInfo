package ui.frame.index.container;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.frame.index.homepage.HomepagePanel;
import ui.frame.index.hotspot.HotspotBounds;
import ui.frame.index.hotspot.HotspotPanel;
import ui.myUI.BackColorPanel;
import ui.system.UIData;

@SuppressWarnings("serial")
public class IndexPanel extends JPanel{
	
	HomepagePanel homepagePanel;
	HotspotPanel hotspotPanel;
	
	public IndexPanel(){		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(UIData.indexPanelWidth, UIData.indexPanelHeight));
		this.setOpaque(false);
		this.setVisible(true);
		
		homepagePanel = new HomepagePanel();
		this.add(homepagePanel);
		hotspotPanel = new HotspotPanel();
		this.add(hotspotPanel);
	}

}
