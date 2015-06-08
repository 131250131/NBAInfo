package ui.frame.live;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class LivePanel extends JPanel{
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (4000 * UIData.changeY);
	
	public LivePanel(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("比赛直播");
		title.setBounds((int) (285 * UIData.changeX), (int) (30 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.LIGHT_GRAY);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		int Lwidth = (int) (1200 * UIData.changeX);
		int Lheight = (int) (600 * UIData.changeY);
		int Lx = (int) ((1920 - Lwidth)/2 * UIData.changeX - 50);
		int Ly = (int) ((200 - 40 + 200 + 50) * UIData.changeY);
		
		JLabel num1 = new JLabel("109");
		num1.setHorizontalAlignment(JLabel.CENTER);
		num1.setFont(new Font("Arail", Font.PLAIN, 40));
		num1.setBounds(620 - 40, 210, 70, 40);
		num1.setBackground(null);
		num1.setForeground(Color.BLACK);
		num1.setVisible(true);
		this.add(num1);
		
		JLabel num2 = new JLabel("90");
		num2.setHorizontalAlignment(JLabel.CENTER);
		num2.setFont(new Font("Arail", Font.PLAIN, 40));
		num2.setBounds(1225 - 40, 210, 70, 40);
		num2.setBackground(null);
		num2.setForeground(Color.BLACK);
		num2.setVisible(true);
		this.add(num2);
		
		ImageLabel label2 = new ImageLabel(ImageSaver.getIcon("live2"), Lx, Lx - 180, 1200, 187);
		this.add(label2);
		
		JPanel color2 = new JPanel();
		color2.setBounds(Lx + Lwidth - 20, Ly, 20, Lheight);
		color2.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
		color2.setVisible(true);
		this.add(color2);

		LiveBoard liveBoard = new LiveBoard();
		this.add(liveBoard);
		
		JPanel color1 = new JPanel();
		color1.setBounds(Lx, Ly, Lwidth, Lheight);
		color1.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
		color1.setVisible(true);
		this.add(color1);
		
		Buttons[] buttons = new Buttons[6];
		for(int i = 0; i < 6; i++){
			buttons[i] = new Buttons(getWords(i), i);
			this.add(buttons[i]);
		}
		
		buttons[0].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo1.doClick();
			}
		});
		
		buttons[1].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo2.doClick();
			}
		});
		
		buttons[2].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo3.doClick();
			}
		});
		
		buttons[3].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo4.doClick();
			}
		});
		
		buttons[4].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnToOT.doClick();
			}
		});
				
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(labelX, 0, labelWidth, height);
		backPanel.setBackground(new Color(0, 0, 0, 0.8f));
		backPanel.setVisible(true);
		this.add(backPanel);
	}
	
	private String getWords(int i){
		switch(i){
		case 0:
			return "第一节";
		case 1:
			return "第二节";
		case 2:
			return "第三节";
		case 3:
			return "第四节";
		case 4:
			return "加时赛";
		default:
			return "详细数据";
		}
	}

}

@SuppressWarnings("serial")
class Buttons extends JButton{
	
	public Buttons(String str, int index){
		this.setText(str);
		this.setVisible(true);
		this.setBounds(200 - 72 + 200 * index + 180, 130 + 250, 200, 30);
		this.setForeground(Color.WHITE);
		this.setBackground(Color.BLACK);
	}
}
