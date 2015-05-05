package ui.frame.match;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.system.UIData;
import vo.MatchVO;

@SuppressWarnings("serial")
public class MatchPanel extends JPanel{
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (4000 * UIData.changeY);
	
	public MatchPanel(MatchVO match){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("比赛信息");
		title.setBounds((int) (285 * UIData.changeX), (int) (30 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.LIGHT_GRAY);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		
		MatchVSLabel vsLabel = new MatchVSLabel(labelX, (int) ((1020 - 165) * UIData.changeY), labelWidth, (int) (2500 * UIData.changeY), match);
		this.add(vsLabel);

		MatchDataPanel matchDataPanel = new MatchDataPanel(match);
		matchDataPanel.setBounds((int) (300 * UIData.changeX), (int) (120 * UIData.changeY)
				, (int) (1280 * UIData.changeX), (int) (720 * UIData.changeY));
		this.add(matchDataPanel);
		
		JLabel info = new JLabel("*点击球队图片查看所选球队比赛信息");
		info.setBounds((int) (1308 * UIData.changeX), (int) (800 * UIData.changeY), (int) (300 * UIData.changeX), (int) (20 * UIData.changeY));
		info.setForeground(Color.RED);
		info.setVisible(true);
		this.add(info);
		
		JPanel backPanel4 = new JPanel();
		backPanel4.setBounds((int) (320 * UIData.changeX), (int) (matchDataPanel.getY() + 307 * UIData.changeY ), (int) (300 * UIData.changeX), (int) (115 * UIData.changeX));
		backPanel4.setBackground(new Color(0f, 0f, 0f, 0.4f));
		backPanel4.setVisible(true);
		this.add(backPanel4);
		
		JPanel backPanel3 = new JPanel();
		backPanel3.setBounds((int) (320 * UIData.changeX), (int) (matchDataPanel.getY() + 20 * UIData.changeY), (int) (300 * UIData.changeX), matchDataPanel.getHeight());
		backPanel3.setBackground(new Color(0, 0, 0, 0.3f));
		backPanel3.setVisible(true);
		this.add(backPanel3);
		
		JPanel backPanel2 = new JPanel();
		backPanel2.setBounds((int) (200 * UIData.changeX), (int) (matchDataPanel.getY() + 20 * UIData.changeY), labelWidth, matchDataPanel.getHeight());
		backPanel2.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.5f));
		backPanel2.setVisible(true);
		this.add(backPanel2);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(labelX, 0, labelWidth, height);
		backPanel.setBackground(new Color(0, 0, 0, 0.8f));
		backPanel.setVisible(true);
		this.add(backPanel);
	}

}

