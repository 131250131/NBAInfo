package ui.frame.index.match;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.UIData;
import vo.MatchVO;

@SuppressWarnings("serial")
public class MatchListPanel extends JPanel{
	
	public MatchListPanel(ArrayList<MatchVO> matchArray){	
		this.setLayout(null);
		matchNum = matchArray.size();
		this.setPreferredSize(new Dimension((int) ((1920 - 25) * UIData.changeX), (int) (160 * 1.5 * UIData.changeY) * (matchNum + 1)));
		this.setOpaque(false);	
		createMatches(matchArray);
	}
	
	int matchNum;
	
	JLabel matchInfoLabel;
	
	private void createMatches(ArrayList<MatchVO> matchArray){	
		SingleMatchPanel[] singleMatchPanel = new SingleMatchPanel[matchNum];
		for(int i = 0; i < matchNum; i++){
			singleMatchPanel[i] = new SingleMatchPanel(matchArray.get(i));
			singleMatchPanel[i].setLocation(0, i * (int) (160 * 1.5 * UIData.changeY));
			this.add(singleMatchPanel[i]);
		}
		
		matchInfoLabel = new JLabel("已加载 " + matchNum + " 场比赛", JLabel.CENTER);
		matchInfoLabel.setBounds(0, (int) ((matchNum * 150 * 1.5 + 90 ) * UIData.changeY), (int) (1500 * UIData.changeX), (int) (120 * UIData.changeY));
		matchInfoLabel.setFont(new Font("新細明體", Font.BOLD, (int) (20 * 1.5 * UIData.changeY)));
		matchInfoLabel.setForeground(Color.BLACK);
		this.add(matchInfoLabel);
	}

}
