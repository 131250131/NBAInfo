package userInterface.ui.hotspotUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class SinglePanel extends JPanel{
	
	JLabel scoreLabel, background, picLabel, nameLabel;
	JButton button;
	
	int sizeX = 150;
	int sizeY = 80;
	int  picX = 100;
	
	public SinglePanel(){
		
		this.setSize(sizeX, sizeY);
		this.setOpaque(false);
		this.setVisible(true);
		this.setLayout(null);
		
		scoreLabel = new JLabel("0", JLabel.RIGHT);
		scoreLabel.setBounds(0, 0, sizeX, 21);
		scoreLabel.setFont(new Font("Arail", Font.PLAIN, 20));
		scoreLabel.setVisible(true);
		scoreLabel.setForeground(Color.WHITE);
		this.add(scoreLabel);
		
		nameLabel = new JLabel("A", JLabel.RIGHT);
		nameLabel.setBounds(0, (sizeY - 20) / 2 + 13, sizeX, 20);
		nameLabel.setFont(new Font("Arail", Font.BOLD, 15));
		nameLabel.setVisible(true);
		nameLabel.setForeground(Color.PINK);
		this.add(nameLabel);
		
		picLabel = new JLabel();
		picLabel.setBounds(0, 0, picX, sizeY);
		picLabel.setVisible(true);
		this.add(picLabel);
		
		button = new JButton();
		button.setBounds(0, 0, sizeX, sizeY);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		this.add(button);
		
		background = new JLabel(ImageSaver.getIcon("background3"));
		background.setBounds(0, 0, sizeX, sizeY);
		background.setVisible(true);
		this.add(background);
	}
	
	public void updatePanel(int score, int step, int index, String playerName){
		setScore(score);
		setLocation(getPanelX(score, step), getPanelY(index));
		setIcon(playerName);
		setLabelName(playerName);
	}
	
	private void setScore(int score){
		scoreLabel.setText(String.valueOf(score) + "  ");
	}
	
	private void setLabelName(String playerName){
		nameLabel.setText(playerName);
	}
	
	private void setIcon(String playerName){
		ImageIcon image = new ImageIcon("data/ui/image/portrait/" + playerName +".png");
		image.setImage(image.getImage().getScaledInstance(picX, sizeY,Image.SCALE_DEFAULT));
		picLabel.setIcon(image);
	}
	
	private int getPanelX(int score, int step){
		
		if(score > step * 5){
			return 0;
		}else if(score < step){
			return 860;
		}else{
			return 1010 - (860/(5 * step))*(score);		
		}
	
	}
	
	private int getPanelY(int index){
		
		int y = 50, blank = 28;		
		return y + (sizeY + blank) * index;
	}


}
