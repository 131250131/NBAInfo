package ui.frame.index.container;

import java.awt.Dimension;

import javax.swing.JPanel;

import ui.frame.index.homepage.HomepagePanel;
import ui.frame.index.hotspot.HotspotPanel;
import ui.frame.index.match.MatchPanel;
import ui.frame.index.rank.RankPanel;
import ui.system.UIData;

@SuppressWarnings("serial")
public class IndexPanel extends JPanel{
	
	HomepagePanel homepagePanel;
	HotspotPanel hotspotPanel;
	MatchPanel matchPanel;
	RankPanel rankPanel;
	
	public IndexPanel(){		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(UIData.indexPanelWidth + 2, UIData.indexPanelHeight));
		this.setOpaque(false);
		this.setVisible(true);
		
		homepagePanel = new HomepagePanel();
		this.add(homepagePanel);
		hotspotPanel = new HotspotPanel();
		this.add(hotspotPanel);
		matchPanel = new MatchPanel();
		this.add(matchPanel);
		rankPanel = new RankPanel();
		this.add(rankPanel);
		}

}
