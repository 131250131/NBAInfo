package ui.frame.live;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ui.system.UIData;

@SuppressWarnings("serial")
public class LiveBoard extends JScrollPane{
	
	int width = (int) (1100 * UIData.changeX);
	int height = (int) (600 * UIData.changeY);
	int x = (int) ((1920 - width)/2 * UIData.changeX);
	int y = (int) (200 * UIData.changeY);
	
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
	//	this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

		getMaxSize();
		
		largeLiveBoard = new LargeLiveBoard();
		this.setViewportView(largeLiveBoard);
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

}

@SuppressWarnings("serial")
class LargeLiveBoard extends JPanel{
	
	LiveBoardPanel[] liveArray = new LiveBoardPanel[5];
	
	int width = (int) (1100 * 5 * UIData.changeX);
	int height = (int) (LiveBoard.MaxSize * UIData.changeY);
	
	public LargeLiveBoard(){
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		for(int i = 0; i < 5; i++){
			liveArray[i] = new LiveBoardPanel(i);
			liveArray[i].setBounds(i * 1100, 0, 1100, height);
			liveArray[i].setVisible(true);
			this.add(liveArray[i]);
		}
	}
}

@SuppressWarnings("serial")
class LiveBoardPanel extends JPanel{
	
	public LiveBoardPanel(int i){
		this.setLayout(null);
		
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
		this.setBounds(0, height * index, 1100, height);
		this.setLayout(null);

		JLabel label = new JLabel(str, JLabel.CENTER);
		label.setBounds(0, 0, 1100, height);
		label.setVisible(true);
		this.add(label);
	}
	
}
