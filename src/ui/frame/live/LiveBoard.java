package ui.frame.live;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import ui.system.UIData;

@SuppressWarnings("serial")
public class LiveBoard extends JScrollPane implements ActionListener{
	
	int width = (int) (1200 * UIData.changeX);
	int height = (int) (600 * UIData.changeY);
	int x = (int) ((1920 - width)/2 * UIData.changeX - 50);
	int y = (int) ((200 - 40 + 200 + 50) * UIData.changeY);
	
	static int MaxSize = 700;
	
	LargeLiveBoard largeLiveBoard;
	@SuppressWarnings("unchecked")
	public static ArrayList<String>[] wordsArray = new ArrayList[5];
	
	public LiveBoard(){
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setVisible(true);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		this.getVerticalScrollBar().setUnitIncrement(35);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

		getMaxSize();
		
		largeLiveBoard = new LargeLiveBoard();
		this.setViewportView(largeLiveBoard);
		
		turnTo1 = new JButton();
		turnTo1.addActionListener(this);
		this.add(turnTo1);
		
		turnTo2 = new JButton();
		turnTo2.addActionListener(this);
		this.add(turnTo2);
		
		turnTo3 = new JButton();
		turnTo3.addActionListener(this);
		this.add(turnTo3);
		
		turnTo4 = new JButton();
		turnTo4.addActionListener(this);
		this.add(turnTo4);
		
		turnToOT = new JButton();
		turnToOT.addActionListener(this);
		this.add(turnToOT);
	}
	
	private void getMaxSize(){
		for(int i = 0; i < 5; i++){
			wordsArray[i] = new ArrayList<String>();
		}
		getWords();
		
		int temp = 0;
		
		for(int i = 0; i < 4; i++){
			temp = Math.max(wordsArray[i].size(), wordsArray[i + 1].size());
		}
		
		if(temp > MaxSize){
			MaxSize = temp;
		}
	}
	
	private void getWords(){
		for(int i = 0 ; i < 11; i++){
			wordsArray[0].add("1asd " + (i + 1));
		}
		
		for(int i = 0 ; i < 3; i++){
			wordsArray[1].add("2asd " + (i + 1));
		}
		
		for(int i = 0 ; i < 20; i++){
			wordsArray[2].add("3asd " + (i + 1));
		}
		
		for(int i = 0 ; i < 13; i++){
			wordsArray[3].add("4asd " + (i + 1));
		}
		
		for(int i = 0 ; i < 21; i++){
			wordsArray[4].add("5asd " + (i + 1));
		}
	}
	
	public static JButton turnTo1, turnTo2, turnTo3, turnTo4, turnToOT;

	int currentLoction;
	int destination;
	int step;
	int move = 0;
	int time = 3;
	Timer timer = new Timer(1, this);
	
	private void setScrollLoction(int _destination){
		currentLoction = this.getHorizontalScrollBar().getValue();
		destination = _destination;
		move = 0;
		int height = 400;
		time = Math.abs((destination - currentLoction)) / height + 3;
		
		step = (destination - currentLoction) / time;
		timer.start();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			if(move == time){
				timer.stop();				
			}else{
				move++;
				int value = currentLoction + step * move;
				this.getHorizontalScrollBar().setValue(value);
			}			
		}
		
		if(e.getSource() == turnTo1){
			setScrollLoction(0);
		}
		
		if(e.getSource() == turnTo2){
			setScrollLoction(1 * 1200);
		}
		
		if(e.getSource() == turnTo3){
			setScrollLoction(2 * 1200);
		}
		
		if(e.getSource() == turnTo4){
			setScrollLoction(3 * 1200);
		}
		
		if(e.getSource() == turnToOT){
			setScrollLoction(4 * 1200);
		}
	}

}

@SuppressWarnings("serial")
class LargeLiveBoard extends JPanel{
	
	LiveBoardPanel[] liveArray = new LiveBoardPanel[5];
	
	int width = (int) (1200 * 5 * UIData.changeX);
	int height = (int) (LiveBoard.MaxSize * UIData.changeY);
	
	public LargeLiveBoard(){
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		this.setBackground(new Color(0,0,0,0));
		
		for(int i = 0; i < 5; i++){
			liveArray[i] = new LiveBoardPanel(i);
			liveArray[i].setBounds(i * 1200, 0, 1200, height);
			liveArray[i].setVisible(true);
			this.add(liveArray[i]);
		}
	}
}

@SuppressWarnings("serial")
class LiveBoardPanel extends JPanel{
	
	public LiveBoardPanel(int i){
		this.setLayout(null);
		this.setBackground(null);
		
		initWords(LiveBoard.wordsArray[i].size(), i);
	}
	
	public void initWords(int size, int index){
		for(int i = 0; i < size; i++){
			WordsLabel word = new WordsLabel(LiveBoard.wordsArray[index].get(i), i);
			word.setVisible(true);
			this.add(word);
		}
	}
}

@SuppressWarnings("serial")
class WordsLabel extends JPanel{
	
	public WordsLabel(String str, int index){
		int height = 30;
		this.setBounds(0, height * index, 1200, height);
		this.setLayout(null);
		if(index % 2 == 0){
			this.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.3f));
		}else{
			this.setBackground(new Color(0.4f, 0.4f, 0.4f, 0.25f));
		}

		JLabel label = new JLabel(str, JLabel.CENTER);
		label.setBounds(0, 0, 1200, height);
		label.setVisible(true);
		label.setForeground(Color.WHITE);
		this.add(label);
	}
	
}
