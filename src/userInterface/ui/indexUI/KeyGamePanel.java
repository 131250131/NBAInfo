package userInterface.ui.indexUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class KeyGamePanel extends JPanel implements ActionListener{
	
	int x = IndexBounds.keyGameX;
	int y = IndexBounds.keyGameY;
	int width = IndexBounds.keyGameSizeX;
	int height = IndexBounds.keyGameSizeY;
	
	JButton button;
	JLabel back;
	
	String title = "Key Game ! ";
	
	String team1Name = "BOS";
	String team2Name = "MIN";
	
	public KeyGamePanel(){
		
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
		
		JLabel titleLabel = new JLabel(title + team1Name + " VS " + team2Name);
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
		
		int teamSize = 150;
		
		ImageIcon image2 = new ImageIcon("data/newImage/Team/" + team1Name + ".png");
		image2.setImage(image2.getImage().getScaledInstance(teamSize, teamSize,Image.SCALE_DEFAULT));	
		JLabel teamLabel1 = new JLabel(image2);
		teamLabel1.setBounds(43 - 37 + 5, 100 - 33, teamSize, teamSize);
		teamLabel1.setVisible(true);
		this.add(teamLabel1);
		
		ImageIcon image3 = new ImageIcon("data/newImage/Team/" + team2Name + ".png");
		image3.setImage(image3.getImage().getScaledInstance(teamSize, teamSize,Image.SCALE_DEFAULT));		
		JLabel teamLabel2 = new JLabel(image3);
		teamLabel2.setBounds(222 - 33, 62 - 57, teamSize, teamSize);
		teamLabel2.setVisible(true);
		this.add(teamLabel2);
		
		back = new JLabel(ImageSaver.getIcon("keyGameBack2"));
		back.setBounds(0, 0, width, height);
		back.setVisible(true);
		this.add(back);
		
		button.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				back.setIcon(ImageSaver.getIcon("keyGameBack"));
			}
			public void mouseExited(MouseEvent arg0) {
				back.setIcon(ImageSaver.getIcon("keyGameBack2"));
			}
			}); 
		
	}
	
	public void actionPerformed(ActionEvent events) {
		
	}

}
