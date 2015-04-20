package userInterface.ui.matchUI;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MatchDataPanel extends JPanel {

	private MyTable table;
	private DataOfPlayerPanel players;
	private DataOfMatchPanel thismatch;
	public MatchDataPanel(){
		this.setBounds(0, 0, 1280, 720);
		this.setBackground(Color.black);
		this.setLayout(null);
		
		//各组件
		table = new MyTable();
		players=new DataOfPlayerPanel();
		thismatch=new DataOfMatchPanel();
		JSortTable.makeFace(table.getTable());
		
		thismatch.setLocation(0, 50);
		players.setLocation(400, 50);
		table.setBounds(400,270, 850, 400);
		
		this.add(thismatch,0);
		this.add(players,1);
		this.add(table,2);
	}
	public static void main(String[] args) {
		JFrame test=new JFrame();
		test.setUndecorated(true);
		test.setBounds(20, 20, 1280, 720);
		test.setLayout(null);
		test.add(new MatchDataPanel());
		
		test.setVisible(true);
	}
}
