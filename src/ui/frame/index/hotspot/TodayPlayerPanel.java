package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;






import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;

import com.nba.data.Player;
import com.nba.initProcess.InitProcess;
import com.nba.registerList.RegisterList;


@SuppressWarnings("serial")
public class TodayPlayerPanel extends JPanel implements ActionListener{

	int x = HotspotBounds.TodayPlayerPanelX;
	int y = HotspotBounds.TodayPlayerPanelY;
	int width = HotspotBounds.TodayPlayerPanelWidth;
	int height = HotspotBounds.TodayPlayerPanelHeight;
	
	String title = "今日最佳球员";
	
	Player player;
	
	JButton button;
	JLabel nameLabel;
	ImageLabel back, back3;
	ImageLabel playerIcon;
	
	public TodayPlayerPanel(){
		
		player = getPlayer();
		
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setVisible(true);
		
		button = new JButton();
		button.setVisible(true);
		button.setOpaque(false);
		button.setBackground(null);
		button.setContentAreaFilled(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBounds(0, 0, width, height);		
		button.addActionListener(this);
		this.add(button);
		
		nameLabel = new JLabel(player.getPlayerName());
		nameLabel.setBounds((int) (40 * UIData.changeX), (int) (500 * UIData.changeY)
				, (int) (800 * UIData.changeX), (int) (90 * UIData.changeY));
		nameLabel.setForeground(Color.ORANGE);
		nameLabel.setBackground(null);
		nameLabel.setVisible(true);
		nameLabel.setFont(new Font("Old English Text MT", Font.PLAIN, (int) (80 * UIData.changeY)));
		this.add(nameLabel);
		
		JLabel titleLabel = new JLabel(title, JLabel.RIGHT);
		titleLabel.setBounds((int) (-30 * UIData.changeX),(int) (600 * UIData.changeY), width, (int) (100 * UIData.changeY));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(null);
		titleLabel.setVisible(true);
		titleLabel.setFont(new Font("新細明體", Font.PLAIN, (int) (36 * UIData.changeY)));
		this.add(titleLabel);
		
		ImageLabel back2 = new ImageLabel(ImageSaver.getIcon("今日最佳球员背景3"), 0, 0, width, height);
		back2.setVisible(true);
		this.add(back2);
			
		playerIcon = new ImageLabel(new ImageIcon("data/ui/image/action/" + player.getPlayerName() + ".png"), 
				(int) (500 * UIData.changeX), (int) (-70 * UIData.changeY),(int) (440 * 1.1 * UIData.changeX) , (int) (700 * 1.1 * UIData.changeY));
		playerIcon.setVisible(true);
		this.add(playerIcon);
		
		ImageLabel teamLabel = new ImageLabel(new ImageIcon("data/newImage/Team/" + player.getTeamShortName() + ".png"),
				(int) (700 * UIData.changeX), (int) (100 * UIData.changeY), (int) (420 * UIData.changeX), (int) (420 * UIData.changeY));
		teamLabel.setVisible(true);
		this.add(teamLabel);
		
		back3 = new ImageLabel(ImageSaver.getIcon("今日最佳球员背景2"), 0, 0, width, height);
		back3.setVisible(false);
		this.add(back3);
		
		back = new ImageLabel(ImageSaver.getIcon("今日最佳球员背景"), 0, 0, width, height);
		back.setVisible(true);
		this.add(back);
		
		button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back3.setVisible(true);
			}
			public void mouseExited(MouseEvent arg0) {
				back3.setVisible(false);
			}
			}); 
	}
	
	private Player getPlayer(){
		InitProcess init = new InitProcess();
		init.init();
		@SuppressWarnings("unchecked")
		ArrayList<Player> list = (ArrayList<Player>) RegisterList.saveList.get(10);
		return list.get(18);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == button){
			Controller.addPlayerPanel(player.getPlayerName());
		}
		
	}

}
