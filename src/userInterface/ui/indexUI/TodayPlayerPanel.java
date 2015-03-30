package userInterface.ui.indexUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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

import com.nba.data.Player;
import com.nba.davisUI.myUI.ImageBin;
import com.nba.initProcess.InitProcess;
import com.nba.registerList.RegisterList;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class TodayPlayerPanel extends JPanel implements ActionListener{
	
	int x = IndexBounds.todayPlayerX;
	int y = IndexBounds.todayPlayerY;
	int width = IndexBounds.todayPlayerSizeX;
	int height = IndexBounds.todayPlayerSizeY;
	
	String title = "Recent Best Player";
	
	Player player;
	
	JButton button;
	JLabel nameLabel, playerIcon, back;
	int picSizeX = (int) (440 * 0.9);
	int picSizeY = (int) (700 * 0.88);
	
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
		nameLabel.setBounds(40, 233, 600, 62);
		nameLabel.setForeground(Color.ORANGE);
		nameLabel.setBackground(null);
		nameLabel.setVisible(true);
		nameLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 60));
		this.add(nameLabel);
		
		JLabel titleLabel = new JLabel(title);
		titleLabel.setBounds(128 + 385, 333, 300, 30);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(null);
		titleLabel.setVisible(true);
		titleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 24));
		this.add(titleLabel);
		
		JLabel back2 = new JLabel(ImageSaver.getIcon("todayPlayerBack2"));
		back2.setBounds(0, 0, width, height);
		back2.setVisible(true);
		this.add(back2);
		
		ImageIcon image = new ImageIcon("data/ui/image/action/" + player.getPlayerName() + ".png");
		image.setImage(image.getImage().getScaledInstance(picSizeX, picSizeY,Image.SCALE_DEFAULT));
		
		playerIcon = new JLabel(image);
		playerIcon.setBounds(338 - 40, (picSizeY - 700) / 2 - 30, picSizeX, picSizeY);
		playerIcon.setVisible(true);
		this.add(playerIcon);
		
		int teamSize = 250;
		
		ImageIcon image2 = new ImageIcon("data/newImage/Team/" + player.getTeamShortName() + ".png");
		image2.setImage(image2.getImage().getScaledInstance(teamSize, teamSize,Image.SCALE_DEFAULT));
		
		JLabel teamLabel = new JLabel(image2);
		teamLabel.setBounds((width - teamSize) / 2 - 30 + 250, (height - teamSize) / 2, teamSize, teamSize);
		teamLabel.setVisible(true);
		this.add(teamLabel);
		
		back = new JLabel(ImageSaver.getIcon("todayPlayerBack"));
		back.setBounds(0, 0, width, height);
		back.setVisible(true);
		this.add(back);
		
		button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back.setIcon(ImageSaver.getIcon("todayPlayerBack3"));
			}
			public void mouseExited(MouseEvent arg0) {
				back.setIcon(ImageSaver.getIcon("todayPlayerBack"));
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
		
	}
}
