package ui.frame.larger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.hotspot.HotSpotScrollPane;
import ui.frame.index.container.IndexBoard;
import ui.frame.index.container.IndexScrollPane;
import ui.frame.match.MatchScorllPane;
import ui.frame.player.PlayerScrollPanel;
import ui.frame.system.SystemScrollPane;
import ui.frame.team.TeamScrollPane;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;

@SuppressWarnings("serial")
public class LargerPanel extends JPanel implements ActionListener{
	
	IndexScrollPane indexScrollPane;
	IndexBoard indexBoard;
	public static JButton addPlayerPanel, addReturnPanel, addTeamPanel, addSystemPanel, addMatchPanel, refresh, addHotPanel;
	
	public LargerPanel(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(UIData.largerPanelWidth, UIData.largerPanelHeight));
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		
		ImageLabel scrollBack = new ImageLabel(ImageSaver.getIcon("滑轮背景"), (int) (UIData.indexScrollPaneX + (1920 - 25) * UIData.changeX)
				, 0, (int) (25 * UIData.changeX), UIData.frameHeight);
		this.add(scrollBack);
		
		indexBoard = new IndexBoard();
		this.add(indexBoard, 0);
		indexScrollPane = new IndexScrollPane();
		this.add(indexScrollPane, 1);	
		
		ImageLabel[] addback1 = new ImageLabel[100];
		for(int i = 0; i < 100; i++){
			addback1[i] = new ImageLabel(ImageSaver.getIcon("新增页面背景"), UIData.slideSize * i, 0, UIData.frameWidth, UIData.frameHeight);
			this.add(addback1[i], i + 2);
		}
		
		ImageLabel lb_Background3 = new ImageLabel(ImageSaver.getIcon("首页图片2"), UIData.indexScrollPaneX, 0, UIData.frameWidth, UIData.frameHeight);
		this.add(lb_Background3, 103);
		
		JLabel lb_Background2 = new JLabel(ImageSaver.getIcon("主页背景"));
		lb_Background2.setBounds(UIData.indexScrollPaneX + 2, 0, UIData.frameWidth, UIData.frameHeight);
		lb_Background2.setVisible(true);
		this.add(lb_Background2, 104);
		
		ImageLabel lb_Background = new ImageLabel(ImageSaver.getIcon("最底层背景图"), UIData.indexScrollPaneX, 0, UIData.frameWidth, UIData.frameHeight);
		this.add(lb_Background, 105);
		
		addPlayerPanel = new JButton();
		addPlayerPanel.addActionListener(this);
		this.add(addPlayerPanel);
		
		addTeamPanel = new JButton();
		addTeamPanel.addActionListener(this);
		this.add(addTeamPanel);
		
		addSystemPanel = new JButton();
		addSystemPanel.addActionListener(this);
		this.add(addSystemPanel);
		
		addMatchPanel = new JButton();
		addMatchPanel.addActionListener(this);
		this.add(addMatchPanel);
		
		refresh = new JButton();
		refresh.addActionListener(this);
		this.add(refresh);
		
		addHotPanel = new JButton();
		addHotPanel.addActionListener(this);
		this.add(addHotPanel);
		}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addPlayerPanel){
			PlayerScrollPanel playerScrollPanel = new PlayerScrollPanel(Controller.currentPlayerName);
			this.add(playerScrollPanel);
		}	
		
		if(e.getSource() == addTeamPanel){
			TeamScrollPane teamScrollPanel = new TeamScrollPane(Controller.currentTeamName);
			this.add(teamScrollPanel);
		}	
		
		if(e.getSource() == addSystemPanel){
			SystemScrollPane systemScrollPanel = new SystemScrollPane();
			this.add(systemScrollPanel);
		}	
		
		if(e.getSource() == addMatchPanel){
			MatchScorllPane matchSP = new MatchScorllPane(Controller.currentMatch);
			this.add(matchSP);
		}
		
		if(e.getSource() == addHotPanel){
			HotSpotScrollPane matchSP = new HotSpotScrollPane();
			this.add(matchSP);
		}
		
		if(e.getSource() == refresh){
			indexScrollPane.setVisible(false);
			indexScrollPane = new IndexScrollPane();
			this.add(indexScrollPane, 1);
		}
	}

}
