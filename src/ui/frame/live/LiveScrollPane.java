package ui.frame.live;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class LiveScrollPane extends JScrollPane implements ActionListener{
		
	int x = UIData.getNextX();
	int y = 0;
	int width = UIData.slideSize;
	int height = UIData.fheight;
	
	JButton button;
	
	public LiveScrollPane(){
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		this.getVerticalScrollBar().setUnitIncrement(35);
		
		LivePanel playerPanel = new LivePanel();
		this.setViewportView(playerPanel);
		
		button = new JButton();
		button.setBounds((int) (1720 * UIData.changeX), y, (int) (200 * UIData.changeX), playerPanel.height);
		button.setVisible(true);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setContentAreaFilled(false);
		button.addActionListener(this);
		this.add(button);
		
		ImageLabel addback1 = new ImageLabel(ImageSaver.getIcon("新增页面背景2"), 0, 0, UIData.frameWidth, UIData.frameHeight);
		this.add(addback1);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button){
			UIData.returnToFormerStep();
			this.setVisible(false);
		}		
	}
}

