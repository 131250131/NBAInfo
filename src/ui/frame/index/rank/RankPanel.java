package ui.frame.index.rank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.index.hotspot.HotspotBounds;
import ui.myUI.BackColorPanel;
import ui.system.Controller;
import ui.system.UIData;

@SuppressWarnings("serial")
public class RankPanel extends JPanel{
	
	int x = UIData.rankingBoundsX;
	int y = UIData.rankingBoundsY;
	int width = UIData.rankingBoundsWidth;
	int height = UIData.rankingBoundsHeight;
		
	public RankPanel(){
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setVisible(true);
		
			
		JLabel title = new JLabel("战绩排名");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		JLabel label1 = new JLabel("统计1");
		label1.setBounds(400, 400, 100, 30);
		label1.setVisible(true);
		label1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ1();
			}
		});
		this.add(label1);
		
		JLabel label2 = new JLabel("统计2");
		label2.setBounds(400, 440, 100, 30);
		label2.setVisible(true);
		label2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ2();
			}
		});
		this.add(label2);
		
		JLabel label3 = new JLabel("统计3");
		label3.setBounds(400, 480, 100, 30);
		label3.setVisible(true);
		label3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ3();
			}
		});
		this.add(label3);
		
		BackColorPanel backPanel1 = new BackColorPanel(0,
				(int) (((1280 - 900) / 2 - 20) * UIData.changeY), HotspotBounds.BackPanel1Width, (int) (940 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 4);
		this.add(backPanel);
	}


}
