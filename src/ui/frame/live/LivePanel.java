package ui.frame.live;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import thirdVersion.LiveCast;
import thirdVersion.liveThread;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class LivePanel extends JPanel implements ActionListener{ 
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (4000 * UIData.changeY);
	
	static JLabel num1, num2;
	
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
		
		num1 = new JLabel("0");
		num1.setHorizontalAlignment(JLabel.CENTER);
		num1.setFont(new Font("Arail", Font.PLAIN, 40));
		num1.setBounds(620 - 40, 210, 70, 40);
		num1.setBackground(null);
		num1.setForeground(Color.BLACK);
		num1.setVisible(true);
		this.add(num1);
		
		num2 = new JLabel("0");
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
				
				liveThread p1 = new liveThread("1");
				Thread t1 = new Thread(p1);
				t1.start();
				
				dataIn(1);
			}
		});
		
		buttons[1].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo2.doClick();
				
				liveThread p2 = new liveThread("2");
				Thread t2 = new Thread(p2);
				t2.start();
				dataIn(2);
			}
		});
		
		buttons[2].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo3.doClick();
				
				liveThread p3 = new liveThread("3");
				Thread t3 = new Thread(p3);
				t3.start();
				dataIn(3);
			}
		});
		
		buttons[3].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnTo4.doClick();
				
				liveThread p4 = new liveThread("4");
				Thread t4 = new Thread(p4);
				t4.start();
				dataIn(4);
			}
		});
		
		buttons[4].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				LiveBoard.turnToOT.doClick();
				
				liveThread p5 = new liveThread("5");
				Thread t5 = new Thread(p5);
				t5.start();
				dataIn(5);
				liveThread p6 = new liveThread("6");
				Thread t6 = new Thread(p6);
				t6.start();
			}
		});
		
		buttons[5].addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Controller.addMatchPanel(LiveCast.getInstance().getMatchvo());
			}
		});
				
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(labelX, 0, labelWidth, height);
		backPanel.setBackground(new Color(0, 0, 0, 0.8f));
		backPanel.setVisible(true);
		this.add(backPanel);
		
				
		liveThread p1 = new liveThread("1");
		Thread t1 = new Thread(p1);
		t1.start();	
//		liveThread p2 = new liveThread("2");
//		Thread t2 = new Thread(p2);
//		t2.start();
//		liveThread p3 = new liveThread("3");
//		Thread t3 = new Thread(p3);
//		t3.start();
//		liveThread p4 = new liveThread("4");
//		Thread t4 = new Thread(p4);
//		t4.start();
//		liveThread p5 = new liveThread("5");
//		Thread t5 = new Thread(p5);
//		t5.start();
		
		LiveBoard.turnTo1.doClick();
		dataIn(1);
		timer.start();
		
	}
	
	Timer timer = new Timer(3000, this);
	public static int currentCount = 0;
	
	private void dataIn(int i){
		currentCount = i;
		LiveBoard.rePaint.doClick();
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
	
	public void rePaint(){
		String[] str = LiveCast.getInstance().getFirstmatchinfo().getTscores().split("-");
		num1.setText(str[0]);
		num2.setText(str[1]);
		LiveBoard.rePaint.doClick();
		num1.repaint();
		num2.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == timer){
			rePaint();
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
