package userInterface.ui.indexUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class TodayMatchPanel extends JPanel implements ActionListener{

	public TodayMatchPanel(){
		this.setVisible(true);	
		this.setLayout(null);	
		this.setOpaque(false);
		initTodaysGames();	
	}
	int matchNum = 10;
	JButton[] matchesButtons = new JButton[matchNum];
	//TodayMatchLabel[] matchesLabelsBack = new TodayMatchLabel[matchNum];
	TodayMatchLabel[] matchesLabelsText = new TodayMatchLabel[matchNum];
	TodayMatchLabel[] matchesLabelsTeam1 = new TodayMatchLabel[matchNum];
	TodayMatchLabel[] matchesLabelsTeam2 = new TodayMatchLabel[matchNum];
	JLabel[] effectLabel = new JLabel[matchNum];
	
	private void initTodaysGames(){
				
		this.setPreferredSize(new Dimension(IndexBounds.TodayMatchLabelSizeX, IndexBounds.TodayMatchLabelSizeY * matchNum));

		int buttonFirstX = 0;
		int buttonY = 0;
		int buttonSizeX = IndexBounds.TodayMatchLabelSizeX;
		int buttonSizeY = IndexBounds.TodayMatchLabelSizeY;
	
		for(int i = 0; i < matchNum; i++){
			
			effectLabel[i] = new JLabel(ImageSaver.getIcon("mouseEffect"));
			effectLabel[i].setBounds(buttonFirstX, buttonY + buttonSizeY * i, buttonSizeX, buttonSizeY);
			effectLabel[i].setVisible(false);
			this.add(effectLabel[i]);
			
			matchesLabelsText[i] = new TodayMatchLabel(1, i);
			matchesLabelsText[i].setBounds(buttonFirstX, buttonY + buttonSizeY * i, buttonSizeX, buttonSizeY);
			this.add(matchesLabelsText[i]);
			
			matchesLabelsTeam1[i] = new TodayMatchLabel(2, i);
			matchesLabelsTeam1[i].setBounds(buttonFirstX, buttonY + buttonSizeY * i, buttonSizeX, buttonSizeY);
			this.add(matchesLabelsTeam1[i]);
			
			matchesLabelsTeam2[i] = new TodayMatchLabel(3, i);
			matchesLabelsTeam2[i].setBounds(buttonFirstX, buttonY + buttonSizeY * i, buttonSizeX, buttonSizeY);
			this.add(matchesLabelsTeam2[i]);
			
//			matchesLabelsBack[i] = new TodayMatchLabel(0, i);
//			matchesLabelsBack[i].setBounds(buttonFirstX, buttonY + buttonSizeY * i, buttonSizeX, buttonSizeY);
//			this.add(matchesLabelsBack[i]);
			
			matchesButtons[i] = new JButton();
			matchesButtons[i].setVisible(true);
			matchesButtons[i].setOpaque(false);
			matchesButtons[i].setBackground(null);
			matchesButtons[i].setContentAreaFilled(false);
			matchesButtons[i].setBorder(BorderFactory.createEmptyBorder());
			matchesButtons[i].setBounds(buttonFirstX, buttonY + buttonSizeY * i, buttonSizeX, buttonSizeY);		
			matchesButtons[i].addActionListener(this);
			this.add(matchesButtons[i]);	
		}	
		addingMatchEffect();	
	}
		
	public void actionPerformed(ActionEvent events) {
		
	}
	
	private void addingMatchEffect(){
		matchesButtons[0].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[0].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[0].setVisible(false);
			}
			}); 
		
		matchesButtons[1].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[1].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[1].setVisible(false);
			}
			}); 
		
		matchesButtons[2].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[2].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[2].setVisible(false);
			}
			}); 
		
		matchesButtons[3].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[3].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[3].setVisible(false);
			}
			}); 
		
		matchesButtons[4].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[4].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[4].setVisible(false);
			}
			}); 
		
		matchesButtons[5].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[5].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[5].setVisible(false);
			}
			}); 
		
		matchesButtons[6].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[6].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[6].setVisible(false);
			}
			}); 
		
		matchesButtons[7].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[7].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[7].setVisible(false);
			}
			}); 
		
		matchesButtons[8].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[8].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[8].setVisible(false);
			}
			}); 
		
		matchesButtons[9].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				effectLabel[9].setVisible(true);
				}
			public void mouseExited(MouseEvent arg0) {
				effectLabel[9].setVisible(false);
			}
			}); 
	}
}
