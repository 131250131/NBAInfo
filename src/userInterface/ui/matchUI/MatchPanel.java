package userInterface.ui.matchUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.myUI.ImageSaver;

@SuppressWarnings("serial")
public class MatchPanel extends JPanel{
	
	int x = MatchBounds.MatchX;
	int y = MatchBounds.MatchY;
	int width = MatchBounds.MatchSizeX;
	int height = MatchBounds.MatchSizeY;
	
	MatchComboBox matchComboBox;
	TeamComboBox teamComboBox;
	JButton searchButton;
	MatchScrollPane matchScrollPane;
	MatchesListPanel matchesListPanel;
	JLabel scrollBack;
	
	public MatchPanel(){
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setOpaque(false);
		this.setLayout(null);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(MatchBounds.searchButtonX, MatchBounds.searchButtonY,
				MatchBounds.searchButtonSizeX, MatchBounds.searchButtonSizeY);
		searchButton.setBackground(Color.DARK_GRAY);
		searchButton.setForeground(Color.WHITE);
		searchButton.setVisible(true);
		this.add(searchButton);
		
		matchComboBox = new MatchComboBox();
		this.add(matchComboBox);
		
		teamComboBox = new TeamComboBox();
		this.add(teamComboBox);
		
		matchScrollPane = new MatchScrollPane();
		this.add(matchScrollPane);
		matchesListPanel = new MatchesListPanel();
		matchScrollPane.setViewportView(matchesListPanel);
		
		scrollBack = new JLabel(ImageSaver.getIcon("singleMatchBack3"));
		scrollBack.setVisible(true);
		scrollBack.setBounds(MatchBounds.scrollPaneX, MatchBounds.scrollPaneY,
				MatchBounds.scrollPaneSizeX, MatchBounds.scrollPaneSizeY);
		this.add(scrollBack);
	}

}
