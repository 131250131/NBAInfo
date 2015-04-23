package ui.frame.index.container;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class LargerPanel extends JPanel{
	
	IndexScrollPane indexScrollPane;
	IndexBoard indexBoard;
	
	public LargerPanel(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(UIData.largerPanelWidth, UIData.largerPanelHeight));
		this.setOpaque(false);
		this.setVisible(true);
		
		indexBoard = new IndexBoard();
		this.add(indexBoard);
		indexScrollPane = new IndexScrollPane();
		this.add(indexScrollPane);
		
		ImageLabel lb_Background3 = new ImageLabel(ImageSaver.getIcon("首页图片2"), UIData.indexScrollPaneX, 0, UIData.frameWidth, UIData.frameHeight);
		this.add(lb_Background3);
		
		JLabel lb_Background2 = new JLabel(ImageSaver.getIcon("主页背景"));
		lb_Background2.setBounds(UIData.indexScrollPaneX + 2, 0, UIData.frameWidth, UIData.frameHeight);
		lb_Background2.setVisible(true);
		this.add(lb_Background2);
		
		ImageLabel lb_Background = new ImageLabel(ImageSaver.getIcon("最底层背景图"), UIData.indexScrollPaneX, 0, UIData.frameWidth, UIData.frameHeight);
		this.add(lb_Background);
	}

}
