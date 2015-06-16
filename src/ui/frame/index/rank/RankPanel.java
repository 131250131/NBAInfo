package ui.frame.index.rank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.index.hotspot.HotspotBounds;
import ui.myUI.BackColorPanel;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
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
		
			
		JLabel title = new JLabel("数据统计");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		ImageLabel image = new ImageLabel(ImageSaver.getIcon("tj"), (int) (512 * UIData.changeX), (int) (300 * UIData.changeY)
				, (int) (1052 * UIData.changeX), (int) (584 * UIData.changeY));
		this.add(image);
		
		JLabel label1 = new JLabel("球员成长与贡献");
		label1.setBounds((int) (200 * UIData.changeX), (int) (400 * UIData.changeY), (int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
		label1.setFont(new Font("Arail", Font.PLAIN, (int) (30 * UIData.changeY)));
		label1.setVisible(true);
		label1.setForeground(Color.LIGHT_GRAY);
		label1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ1();
			}
		});
		this.add(label1);
		
		JLabel label2 = new JLabel("球员对比");
		label2.setBounds((int) (200 * UIData.changeX), (int) (470 * UIData.changeY), (int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
		label2.setFont(new Font("Arail", Font.PLAIN, (int) (30 * UIData.changeY)));
		label2.setVisible(true);
		label2.setForeground(Color.LIGHT_GRAY);
		label2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ2();
			}
		});
		this.add(label2);
		
		JLabel label3 = new JLabel("球员数据预测");
		label3.setBounds((int) (200 * UIData.changeX), (int) (540 * UIData.changeY), (int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
		label3.setFont(new Font("Arail", Font.PLAIN, (int) (30 * UIData.changeY)));
		label3.setForeground(Color.LIGHT_GRAY);
		label3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ3();
			}
		});
		this.add(label3);
		
		JLabel label4 = new JLabel("球员性价比评估");
		label4.setBounds((int) (200 * UIData.changeX), (int) (610 * UIData.changeY), (int) (400 * UIData.changeX), (int) (30 * UIData.changeY));
		label4.setFont(new Font("Arail", Font.PLAIN, (int) (30 * UIData.changeY)));
		label4.setForeground(Color.LIGHT_GRAY);
		label4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addTJ4();
			}
		});
		this.add(label4);
		
		BackColorPanel backPanel1 = new BackColorPanel(0,
				(int) (((1280 - 900) / 2 - 20) * UIData.changeY), HotspotBounds.BackPanel1Width, (int) (940 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 4);
		this.add(backPanel);
	}


}
