package userInterface.ui.mainFrame;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import userInterface.myUI.ImageSaver;
import userInterface.myUI.MyBackground;
import userInterface.myUI.MyFrame;
import userInterface.ui.hotspotUI.HotSpotPanel;
import userInterface.ui.indexUI.AllTimeBestPlayerPanel;
import userInterface.ui.indexUI.IndexBounds;
import userInterface.ui.indexUI.IndexButtons;
import userInterface.ui.indexUI.KeyGamePanel;
import userInterface.ui.indexUI.TodayMatchButton;
import userInterface.ui.indexUI.TodayMatchPanel;
import userInterface.ui.indexUI.TodayMatchScrollPane;
import userInterface.ui.indexUI.TodayPlayerPanel;
import userInterface.ui.matchUI.MatchPanel;

@SuppressWarnings("serial")
public class MainFrame extends MyFrame implements ActionListener{
	
	ContainerScrollPane containerScrollPane;
	ContainerPanel containerPanel;
	
	int len = 150;

	public MainFrame(){
		
		//初始化位于最底层的滑动Panel
		containerScrollPane = new ContainerScrollPane();
		getContentPane().add(containerScrollPane);
		
		//初始化位于最底层的Panel
		containerPanel = new ContainerPanel();
		initWithIndex();
		initWithMatch();
		initWithHotspot();
		containerScrollPane.setViewportView(containerPanel);	
		this.add(containerScrollPane);
		
		//加载背景图片
		MyBackground bac4 = new MyBackground("background4");
		this.add(bac4);
		MyBackground bac3 = new MyBackground("background3");
		this.add(bac3);
		MyBackground bac2 = new MyBackground("background2");
		this.add(bac2);
		MyBackground bac = new MyBackground("background1");
		this.add(bac);
	}
	
	private int buttonNum = 6;
	IndexButtons[] indexButtons = new IndexButtons[buttonNum];
	
	TodayMatchButton todayMatchUpButton, todayMatchDownButton;
	TodayMatchScrollPane jsp_todayMatch; 
	TodayMatchPanel jp_todayMatch;
	
	private void initWithIndex(){
		
		//只是为了不让程序的监听指在第一个button上而创的无用button
		JButton bt_null = new JButton();
		this.add(bt_null);
		
		initIndexButtons();
		initTodaysMatches();
		initTodaysPlayer();
		
	}
	
	MatchPanel matchPanel;
	
	private void initWithMatch(){
		matchPanel = new MatchPanel();
		containerPanel.add(matchPanel);
	}
	
	HotSpotPanel hotSpotPanel;
	
	private void initWithHotspot(){
		hotSpotPanel = new HotSpotPanel();
		containerPanel.add(hotSpotPanel);
	}
	
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == todayMatchUpButton){
			int step = IndexBounds.TodayMatchLabelSizeY;
			int y = jsp_todayMatch.getVerticalScrollBar().getValue();
			if(y >= step)
				jsp_todayMatch.getVerticalScrollBar().setValue(y - step);
		}
		
		if(events.getSource() == todayMatchDownButton){
			int step = IndexBounds.TodayMatchLabelSizeY;
			int y = jsp_todayMatch.getVerticalScrollBar().getValue();
			if(y < IndexBounds.TodayMatchLabelSizeY * 10)
				jsp_todayMatch.getVerticalScrollBar().setValue(y + step);
		}
	}
	
	TodayPlayerPanel todayPlayerPanel;
	AllTimeBestPlayerPanel allTimePlayerPanel;
	KeyGamePanel keyGamePanel;
	
	//////////////////////////////////INIT TODAYSPLAYER////////////////////////////////
	private void initTodaysPlayer(){
		todayPlayerPanel = new TodayPlayerPanel();
		containerPanel.add(todayPlayerPanel);
		allTimePlayerPanel = new AllTimeBestPlayerPanel();
		containerPanel.add(allTimePlayerPanel);
		keyGamePanel = new KeyGamePanel();
		containerPanel.add(keyGamePanel);
		
		JLabel adv1 = new JLabel(ImageSaver.getIcon("adv1"));
		adv1.setBounds(IndexBounds.advX, IndexBounds.advY, IndexBounds.advSizeX, IndexBounds.advSizeY);
		adv1.setVisible(true);
		containerPanel.add(adv1);
	}
	
	//////////////////////////////////INIT TODAYSMATCHES////////////////////////////////
	private void initTodaysMatches(){
		todayMatchUpButton = new TodayMatchButton(0);
		todayMatchDownButton = new TodayMatchButton(1);
		todayMatchUpButton.addActionListener(this);
		todayMatchDownButton.addActionListener(this);
		containerPanel.add(todayMatchUpButton);
		containerPanel.add(todayMatchDownButton);
		
		jsp_todayMatch = new TodayMatchScrollPane();
		containerPanel.add(jsp_todayMatch);
		jp_todayMatch = new TodayMatchPanel();
		jsp_todayMatch.setViewportView(jp_todayMatch);	
		
		JLabel back = new JLabel(ImageSaver.getIcon("todayBack2"));
		back.setVisible(true);
		back.setBounds(IndexBounds.todayMatchSPX, IndexBounds.todayMatchSPY, 265, 500);
		containerPanel.add(back);
		
		JLabel back2 = new JLabel(ImageSaver.getIcon("backLogo"));
		back2.setVisible(true);
		back2.setBounds(-62 + 13 + 20, 25 + 38, 1280, 720);
		containerPanel.add(back2);
	}
	
	//////////////////////////////////INIT INDEXBUTTONS////////////////////////////////
	private void initIndexButtons(){
		for(int i = 0; i < buttonNum; i++){
			indexButtons[i] = new IndexButtons(i);			
			indexButtons[i].addActionListener(this);		
			containerPanel.add(indexButtons[i]);
		}
			//这货没法用数组弄
		indexButtons[0].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				indexButtons[0].setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				indexButtons[0].setForeground(Color.WHITE);
			}
			}); 
		
		indexButtons[1].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				indexButtons[1].setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				indexButtons[1].setForeground(Color.WHITE);
			}
			}); 
		
		indexButtons[2].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				indexButtons[2].setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				indexButtons[2].setForeground(Color.WHITE);
			}
			}); 
		
		indexButtons[3].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				indexButtons[3].setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				indexButtons[3].setForeground(Color.WHITE);
			}
			}); 
		
		indexButtons[4].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				indexButtons[4].setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				indexButtons[4].setForeground(Color.WHITE);
			}
			}); 
		
		indexButtons[5].addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				indexButtons[5].setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				indexButtons[5].setForeground(Color.WHITE);
			}
			}); 
	}
}
