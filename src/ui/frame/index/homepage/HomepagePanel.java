package ui.frame.index.homepage;

import javax.swing.JPanel;

import ui.myUI.BackColorPanel;
import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class HomepagePanel extends JPanel{
	
	int x = UIData.homepagePanelX;
	int y = UIData.homepagePanelY;
	int width = UIData.homepagePanelWidth;
	int height = UIData.homepagePanelHeight;
	
	public HomepagePanel(){
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		
		ImageLabel homepageImage = new ImageLabel(ImageSaver.getIcon("首页图片"), HomepageBounds.BackImageX
				, HomepageBounds.BackImageY, HomepageBounds.BackImageWidth, HomepageBounds.BackImageHeight);
		this.add(homepageImage);
		
		BackColorPanel backPanel1 = new BackColorPanel(HomepageBounds.BackImageX, HomepageBounds.BackImageY - (int)(20 * UIData.changeY)
				, HomepageBounds.BackImageWidth, HomepageBounds.BackImageHeight + (int)(40 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel2 = new BackColorPanel(0, 0, width, height, 1);
		this.add(backPanel2);
	}

}
