package userInterface.ui.indexUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

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

	private void initTodaysGames(){
				
		this.setPreferredSize(new Dimension(IndexBounds.TodayMatchLabelSizeX, IndexBounds.TodayMatchLabelSizeY * matchNum));

		int buttonFirstX = 0;
		int buttonY = 0;
		int buttonSizeX = IndexBounds.TodayMatchLabelSizeX;
		int buttonSizeY = IndexBounds.TodayMatchLabelSizeY;
	
		for(int i = 0; i < matchNum; i++){
			
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
	}
		
	public void actionPerformed(ActionEvent events) {
		
	}
}
