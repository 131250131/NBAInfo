package ui.frame.index.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.index.hotspot.HotspotBounds;
import ui.myUI.BackColorPanel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.MatchVO;

@SuppressWarnings("serial")
public class MatchPanel extends JPanel implements ActionListener{
	
	int x = UIData.matchBoundsX;
	int y = UIData.matchBoundsY;
	int width = UIData.matchBoundsWidth;
	int height = UIData.matchBoundsHeight;
	
	int panelHeight = (int) (900 * UIData.changeY);
	
	JButton searchButton, searchButton2;
	MatchComboBox matchComboBox;
	MatchScrollPane matchScrollPane;
	MatchListPanel matchesListPanel;
	
	public MatchPanel(){
		Controller.readAllMatch();
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.setVisible(true);
		
		matchScrollPane = new MatchScrollPane();
		this.add(matchScrollPane);
		
		searchButton = new JButton("搜索");
		searchButton.setBounds((int) (440  * UIData.changeX), (int) (190 * UIData.changeY),
				(int) (200 * UIData.changeX), (int) (35 * UIData.changeY));
		searchButton.setBackground(Color.DARK_GRAY);
		searchButton.setForeground(Color.WHITE);
		searchButton.addActionListener(this);
		searchButton.setVisible(true);
		this.add(searchButton);
		
		searchButton2 = new JButton("详细搜索");
		searchButton2.setBounds((int) (660 * UIData.changeX), (int) (190 * UIData.changeY),
				(int) (200 * UIData.changeX), (int) (35 * UIData.changeY));
		searchButton2.setBackground(Color.DARK_GRAY);
		searchButton2.setForeground(Color.WHITE);
		searchButton2.addActionListener(this);
		searchButton2.setVisible(true);
		this.add(searchButton2);
		
		matchComboBox = new MatchComboBox();
		this.add(matchComboBox);
		
		JLabel scrollBack = new JLabel(ImageSaver.getIcon("比赛背景图片"));
		scrollBack.setVisible(true);
		scrollBack.setBounds((int) (221 * UIData.changeX), (int) (253 * UIData.changeY),
				(int) (1500 * UIData.changeX), (int) (800 * UIData.changeY));
		this.add(scrollBack);
			
		JLabel title = new JLabel("比赛信息");
		title.setBounds((int) (185 * UIData.changeX), (int) (115 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.ORANGE);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		BackColorPanel backPanel1 = new BackColorPanel(0,
				(int) (((1280 - 900) / 2 - 20) * UIData.changeY), HotspotBounds.BackPanel1Width, (int) (940 * UIData.changeY), 0);
		this.add(backPanel1);
		
		BackColorPanel backPanel = new BackColorPanel(0, 0, width, height, 3);
		this.add(backPanel);
	}

	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == searchButton){
			int maxNum = Controller.dateList.size();
			ArrayList<MatchVO> matchArray = Controller.matchController.getSomeMacthVO(Controller.dateList.get(maxNum - matchComboBox.getSelectedIndex() - 1));
			matchesListPanel = new MatchListPanel(matchArray);
			matchScrollPane.setViewportView(matchesListPanel);
		}
	}

}
