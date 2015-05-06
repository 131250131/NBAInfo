package ui.frame.index.container;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.larger.LargerPanel;
import ui.frame.larger.LargerScrollPane;
import ui.myUI.ImageLabel;
import ui.myUI.OpaqueButton;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class IndexBoard extends JPanel implements ActionListener{

	int x = UIData.indexBoardX;
	int y = UIData.indexBoardY;
	int width = UIData.indexBoardWidth;
	int height = UIData.indexBoardHeight;
	
	OpaqueButton switchButton;
	ImageLabel background ,background2;
	boolean flag = true;
	
	public IndexBoard(){
		
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);
		
		switchButton = new OpaqueButton();
		switchButton.setBounds((int) (58 * UIData.changeX), (int) (1040 * UIData.changeY)
				, (int) (70 * UIData.changeX), (int) (25 * UIData.changeY));
		switchButton.addActionListener(this);
		this.add(switchButton);
		
		initTextLabel();
		
		background = new ImageLabel(ImageSaver.getIcon("选择栏背景"), 0, 0, width, height);
		background.setVisible(false);
		this.add(background);
		
		background2 = new ImageLabel(ImageSaver.getIcon("选择栏背景-关闭"), 0, 0, width, height);
		this.add(background2);
	}
	

	int textNum = 9;
	JLabel[] textLabel = new JLabel[textNum];
	OpaqueButton[] textButton = new OpaqueButton[textNum];
	int labelHeight = (int) (30 * UIData.changeY);
	
	private void initTextLabel(){
		
		for(int i = 0; i < textNum; i++){
			textLabel[i] = new JLabel(getText(i), JLabel.CENTER);
			textLabel[i].setFont(new Font("新細明體", Font.BOLD, (int)(24 * UIData.changeY)));
			textLabel[i].setForeground(Color.GRAY);
			textLabel[i].setBounds((int) (5 * UIData.changeX), getTextY(i), width, labelHeight);
			textLabel[i].setVisible(false);
			this.add(textLabel[i]);
			
			textButton[i] = new OpaqueButton();
			textButton[i].setBounds((int) (5 * UIData.changeX), getTextY(i), width, labelHeight);
			textButton[i].setVisible(false);
			textButton[i].addActionListener(this);
			this.add(textButton[i]);
		}
		
		addEffect();
	}
	
	private void addEffect(){
		textButton[0].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[0].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[0].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[1].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[1].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[1].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[2].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[2].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[2].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[3].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[3].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[3].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[4].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[4].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[4].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[5].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[5].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[5].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[6].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[6].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[6].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[7].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[7].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[7].setForeground(Color.GRAY);
			}
			}); 
		
		textButton[8].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				textLabel[8].setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				textLabel[8].setForeground(Color.GRAY);
			}
			}); 
	}
	
	private int getTextY(int i){
		//这里是针对按钮时单数的情况
		int midLocation = height / 2 - labelHeight / 2;
		int blank = (int) (40 * UIData.changeY);
		return midLocation + (blank + labelHeight) * (i - textNum / 2);
	}
	
	private String getText(int i){
		switch(i){
		case 0:
			return "首页";
		case 1:
			return "最佳球员";
		case 2:
			return "热点信息";
		case 3:
			return "比赛信息";
		case 4:
			return "战绩排名";
		case 5:
			return "球队列表";
		case 6:
			return "球员列表";
		case 7:
			return "我的球队";
		case 8:
			return "系统";
		}
		return null;
	}
	
	private void switchOn(){
		for(int i = 0; i < textNum; i++){
			textLabel[i].setVisible(true);
			textButton[i].setVisible(true);
		}
		flag = false;
		background.setVisible(true);
		background2.setVisible(false);
	}
	
	private void switchOff(){
		for(int i = 0; i < textNum; i++){
			textLabel[i].setVisible(false);
			textButton[i].setVisible(false);
		}
		flag = true;
		background.setVisible(false);
		background2.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == switchButton){
			if(flag == true){
				switchOn();
			}else{
				switchOff();
			}
		}
		
		if(events.getSource() == textButton[0]){
			IndexScrollPane.turnto0.doClick();
		}
		
		if(events.getSource() == textButton[1]){
			IndexScrollPane.turnto1.doClick();
		}
		
		if(events.getSource() == textButton[2]){
			IndexScrollPane.turnto2.doClick();
		}
		
		if(events.getSource() == textButton[3]){
			IndexScrollPane.turnto3.doClick();
		}
		
		if(events.getSource() == textButton[4]){
			IndexScrollPane.turnto4.doClick();
		}
		
		if(events.getSource() == textButton[5]){
			IndexScrollPane.turnto5.doClick();
		}
		
		if(events.getSource() == textButton[6]){
			IndexScrollPane.turnto6.doClick();
		}
		
		if(events.getSource() == textButton[7]){
			IndexScrollPane.turnto7.doClick();
		}
		
		if(events.getSource() == textButton[8]){
			LargerPanel.addSystemPanel.doClick();
			LargerScrollPane.turnto.doClick();
		}
	}
}
