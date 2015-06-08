package ui.frame.index.myteam;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.BackColorPanel;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class MyTeamPanel extends JPanel{

	int x = UIData.myTeamBoundsX;
	int y = UIData.myTeamBoundsY;
	int width = UIData.myTeamBoundsWidth;
	int height = UIData.myTeamBoundsHeight;
	
	ImageLabel imageLabel;
	
	public MyTeamPanel(){
		this.setVisible(true);
		this.setOpaque(false);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		
		JLabel title = new JLabel("比赛直播");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		imageLabel = new ImageLabel(ImageSaver.getIcon("live"), (int) (0 * UIData.changeX), (int) (200 * UIData.changeY), (int) (1920 * UIData.changeX), (int) (850 * UIData.changeY));
		imageLabel.addMouseListener(new MouseAdapter(){  
				public void mouseClicked(MouseEvent e){
					Controller.addLivePanel();
				}
		});
		this.add(imageLabel);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 7);
		this.add(backPanel);
	}	
}

