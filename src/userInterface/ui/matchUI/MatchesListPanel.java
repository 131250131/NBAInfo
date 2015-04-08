package userInterface.ui.matchUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MatchesListPanel extends JPanel{
	
	public MatchesListPanel(){	
		this.setLayout(null);
		this.setPreferredSize(new Dimension(MatchBounds.scrollPaneSizeX - 25, MatchBounds.singleMatchPanelSizeY * 15));
		this.setOpaque(false);
		
		createMatches();
	}
	
	int matchNum;
	
	JLabel matchInfoLabel;
	
	private void createMatches(){
		matchNum = 8;
		SingleMatchPanel[] singleMatchPanel = new SingleMatchPanel[matchNum];
		for(int i = 0; i < matchNum; i++){
			singleMatchPanel[i] = new SingleMatchPanel();
			singleMatchPanel[i].setLocation(0, i * MatchBounds.singleMatchPanelSizeY);
			singleMatchPanel[i].initSingleMatchPanelWithMatch();
			this.add(singleMatchPanel[i]);
		}
		
		matchInfoLabel = new JLabel("Containing " + matchNum + " game(s)", JLabel.CENTER);
		matchInfoLabel.setBounds(0, matchNum * MatchBounds.singleMatchPanelSizeY, 1000, 80);
		matchInfoLabel.setFont(new Font("OCR A Std", Font.PLAIN, 20));
		matchInfoLabel.setForeground(Color.BLACK);
		this.add(matchInfoLabel);
	}

}
