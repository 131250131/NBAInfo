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
import com.nba.initProcess.InitProcess;
import com.nba.registerList.RegisterList;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class AllTimeBestPlayerPanel extends JPanel implements ActionListener{
	
	int x = IndexBounds.allTimePlayerX;
	int y = IndexBounds.allTimePlayerY;
	int width = IndexBounds.allTimePlayerSizeX;
	int height = IndexBounds.allTimePlayerSizeY;
	
	String title = ": All-Time Best Player";
	
	Player player;
	JButton button;
	JLabel back;
	
	int picSizeX = (int) (440 * 0.7);
	int picSizeY = (int) (700 * 0.68);
	
	public AllTimeBestPlayerPanel(){
		
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
		
		JLabel titleLabel = new JLabel(player.getPlayerName() + title);
		titleLabel.setHorizontalAlignment(JLabel.RIGHT);
		titleLabel.setBounds(0, 237, width - 5, 30);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(null);
		titleLabel.setVisible(true);
		titleLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 20));
		this.add(titleLabel);
		
		JLabel back2 = new JLabel(ImageSaver.getIcon("allPlayerBack2"));
		back2.setBounds(0, 0, width, height);
		back2.setVisible(true);
		this.add(back2);
		
		ImageIcon image = new ImageIcon("data/ui/image/action/" + player.getPlayerName() + ".png");
		image.setImage(image.getImage().getScaledInstance(picSizeX, picSizeY,Image.SCALE_DEFAULT));
		
		JLabel playerIcon = new JLabel(image);
		playerIcon.setBounds(228 - 74 - 114, 45 - 71 - 41, picSizeX, picSizeY);
		playerIcon.setVisible(true);
		this.add(playerIcon);
		
		back = new JLabel(ImageSaver.getIcon("allPlayerBack"));
		back.setBounds(0, 0, width, height);
		back.setVisible(true);
		this.add(back);
		
		button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back.setIcon(ImageSaver.getIcon("allPlayerBack3"));
			}
			public void mouseExited(MouseEvent arg0) {
				back.setIcon(ImageSaver.getIcon("allPlayerBack"));
			}
			}); 
	}
	
	private Player getPlayer(){
		InitProcess init = new InitProcess();
		init.init();
		@SuppressWarnings("unchecked")
		ArrayList<Player> list = (ArrayList<Player>) RegisterList.saveList.get(10);
		return list.get(11);
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}

}
