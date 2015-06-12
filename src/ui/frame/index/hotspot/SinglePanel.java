package ui.frame.index.hotspot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ChineseTranslator;
import ui.system.Controller;
import ui.system.DataTransform;
import ui.system.ImageSaver;
import ui.system.UIData;


@SuppressWarnings("serial")
public class SinglePanel extends JPanel implements ActionListener{
	
	JLabel scoreLabel, background, picLabel, nameLabel;
	JButton button;
	ImageLabel colorPanel, colorLabel;
	
	int height = (int) (120 * UIData.changeY);
	int index = 9;
	
	public SinglePanel(int i){		
		index = i;
		this.setBounds(0, getPanelY(), (int) (1775 * UIData.changeY), height);
		this.setSize(HotspotBounds.rankingPanelWidth, height);
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);

		ImageIcon image = null, image2 = null;
		switch(i){
		case 0:
			image = ImageSaver.getIcon("进度条绿");
			image2 = ImageSaver.getIcon("标签绿");break;
		case 1:
			image = ImageSaver.getIcon("进度条蓝");
			image2 = ImageSaver.getIcon("标签蓝");break;
		case 2:
			image = ImageSaver.getIcon("进度条黄");
			image2 = ImageSaver.getIcon("标签黄");break;
		case 3:
			image = ImageSaver.getIcon("进度条橘");
			image2 = ImageSaver.getIcon("标签橘");break;
		case 4:
			image = ImageSaver.getIcon("进度条粉");
			image2 = ImageSaver.getIcon("标签粉");break;
		}
		
		nameLabel = new JLabel();
		nameLabel.setBounds(0, 0, (int) (300 * UIData.changeX), (int) (20 * UIData.changeY));
		nameLabel.setFont(new Font("Arail", Font.BOLD, (int) (20 * UIData.changeY)));
		nameLabel.setVisible(true);
		nameLabel.setForeground(Color.ORANGE);
		this.add(nameLabel);
		
		picLabel = new JLabel();
		picLabel.setBounds(0, 0, (int) (180 * UIData.changeX), (int) (140 * UIData.changeY));
		picLabel.setVisible(true);
		picLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				button.doClick();
			}
		});
		this.add(picLabel);
		
		scoreLabel = new JLabel("0", JLabel.CENTER);
		scoreLabel.setBounds((int) (-5 * UIData.changeX), 0, (int) (100 * UIData.changeX), (int)(20 * UIData.changeY));
		scoreLabel.setFont(new Font("Arail", Font.BOLD, (int)(20 * UIData.changeY)));
		scoreLabel.setVisible(true);
		scoreLabel.setForeground(Color.WHITE);
		this.add(scoreLabel);
		
		colorLabel = new ImageLabel(image2, 0, (int) (45 * UIData.changeY), (int) (250 * UIData.changeX), (int) (75 * UIData.changeY));
		colorLabel.setVisible(true);
		this.add(colorLabel);
		
		colorPanel = new ImageLabel(image, 0, (int) (45 * UIData.changeY), (int) (1775 * UIData.changeX), (int) (30 * UIData.changeY));
		colorPanel.setVisible(true);
		this.add(colorPanel);
		
		button = new JButton();
		button.addActionListener(this);
		this.add(button);
	}
	
	boolean flager = true;
	
	public void updatePanel(double score, int step, String playerName, int i, boolean flag){
		
		this.playerName = playerName;
		
		if(i == 0){
			setScore(score, flag);
			locateUI(score, step);
			setIcon(playerName);
			setLabelName(playerName);
		}else{
			setScore(score, flag);
			locateUI(score, step);
			flager = false;
			setTeamIcon(playerName);
			setTeamName(playerName);
		}
	}
	
	private void locateUI(double score, int step){
		colorPanel.setLocation(getPanelX((int) score, step), (int) (45 * UIData.changeY));
		colorLabel.setLocation((int) (getPanelX((int) score, step) - 230 * UIData.changeX), (int) (25 * UIData.changeY));
		scoreLabel.setLocation((int) (colorLabel.getLocation().x + 160 * UIData.changeX)
				, (int) (colorLabel.getLocation().y + 27 * UIData.changeY));
		picLabel.setLocation((int) (colorLabel.getLocation().x + 12 * UIData.changeX)
				, (int) (colorLabel.getLocation().y - 18 * UIData.changeY));
		button.setLocation((int) (colorLabel.getLocation().x + 12 * UIData.changeX)
				, (int) (colorLabel.getLocation().y - 18 * UIData.changeY));
		nameLabel.setLocation((int) (colorLabel.getLocation().x + 142 * UIData.changeX)
				, (int) (colorLabel.getLocation().y + 70 * UIData.changeY));
	}
	
	private void setScore(double score, boolean flag2){
		if(flag2 == true){
			scoreLabel.setText(DataTransform.transDoubleTopointXXString(score) + "%");	
		}else{
			scoreLabel.setText(DataTransform.transDoubleTopointXXString(score));
		}
	}
	
	private void setLabelName(String playerName){
		nameLabel.setText("  - "+ playerName);
	}
	
	private void setTeamName(String playerName){
		picLabel.setSize((int) (180 * UIData.changeX), (int) (140 * UIData.changeY));
		nameLabel.setText(playerName);
	}
	
	private void setTeamIcon(String playerName){
		picLabel.setSize((int) (110 * UIData.changeX), (int) (110 * UIData.changeY));
		picLabel.setLocation((int) (colorLabel.getLocation().x + 42 * UIData.changeX)
				, (int) (colorLabel.getLocation().y - 8 * UIData.changeY));
		ImageIcon image = ImageSaver.getTeamIcon(ChineseTranslator.TeamNameTrans(playerName));
		image.setImage(image.getImage().getScaledInstance(picLabel.getSize().width, picLabel.getSize().height,Image.SCALE_DEFAULT));
		picLabel.setIcon(image);
	}
	
	private void setIcon(String playerName){
		ImageIcon image = ImageSaver.getPlayerIcon(playerName);
		image.setImage(image.getImage().getScaledInstance(picLabel.getSize().width, picLabel.getSize().height,Image.SCALE_DEFAULT));
		picLabel.setIcon(image);
	}
	
	private int getPanelX(int score, int step){		
		int length = step * 5;
		if(score > length){
			return (int) (275 * UIData.changeX);
		}else{
			return (int) (1775 * UIData.changeX - (1440 * UIData.changeX / length * (score + 0.0)));		
		}
	
	}
	
	private int getPanelY(){
		int y = (int) (100 * UIData.changeY), blank = (int) (10 * UIData.changeY);		
		return y + (height + blank) * index;
	}
	
	String playerName;

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == button){
			if(flager == true){
				Controller.addPlayerPanel(playerName);
			}else{
				Controller.addTeamPanel(playerName);
			}
		}
	}

}
