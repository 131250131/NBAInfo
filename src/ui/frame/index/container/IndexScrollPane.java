package ui.frame.index.container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import ui.system.UIData;

@SuppressWarnings("serial")
public class IndexScrollPane extends JScrollPane implements ActionListener{
	
	int x = UIData.indexScrollPaneX;
	int y = UIData.indexScrollPaneY;
	int width = UIData.indexScrollPaneWidth + 2;
	int height = UIData.indexScrollPaneHeight;
	
	IndexPanel indexPanel;
	Timer timer = new Timer(1, this);
	public static JButton turnto0, turnto1, turnto2, turnto3;
	
	public IndexScrollPane(){	
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.getVerticalScrollBar().setOpaque(false);
		this.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		this.getVerticalScrollBar().setUnitIncrement(35);
		
		indexPanel = new IndexPanel();
		setViewportView(indexPanel);
		
		turnto0 = new JButton();
		turnto0.addActionListener(this);
		this.add(turnto0);	
		
		turnto1 = new JButton();
		turnto1.addActionListener(this);
		this.add(turnto1);	
		
		turnto2 = new JButton();
		turnto2.addActionListener(this);
		this.add(turnto2);	
		
		turnto3 = new JButton();
		turnto3.addActionListener(this);
		this.add(turnto3);
	}
	
	int currentLoction;
	int destination;
	int step;
	int move = 0;
	
	int time = 3;
	
	private void setScrollLoction(int _destination){
		currentLoction = this.getVerticalScrollBar().getValue();
		destination = _destination;
		move = 0;
		int height = UIData.frameHeight * 3;
		time = Math.abs((destination - currentLoction)) / height + 3;
		
		step = (destination - currentLoction) / time;
		timer.start();	
	}
	
	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == timer){
			if(move == time){
				timer.stop();				
			}else{
				move++;
				int value = currentLoction + step * move;
				this.getVerticalScrollBar().setValue(value);
			}			
		}
		
		if(events.getSource() == turnto0){
			setScrollLoction(0);
		}
		
		if(events.getSource() == turnto1){
			setScrollLoction(UIData.hotspotBoundsY);
		}
		
		if(events.getSource() == turnto2){
			setScrollLoction((int) (UIData.matchBoundsY + (80 * UIData.changeY)));
		}
		
		if(events.getSource() == turnto3){
			setScrollLoction((int) (UIData.rankingBoundsY + (100 * UIData.changeY)));
		}
		
	}
	
	
	

}
