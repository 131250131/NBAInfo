package ui.frame.index.container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import ui.system.UIData;

@SuppressWarnings("serial")
public class LargerScrollPane extends JScrollPane implements ActionListener{
	
	int x = UIData.largerScrollPaneX;
	int y = UIData.largerScrollPaneY;
	int width = UIData.largerScrollPaneWidth;
	int height = UIData.largerScrollPaneHeight;;
	
	LargerPanel largerPanel;
	Timer timer = new Timer(1, this);
	public static JButton turnto0, turnto1, turnto2;
	
	public LargerScrollPane(){	
		this.setBounds(x, y, width, height);
		this.setBackground(null);
		this.setOpaque(false);
		this.getViewport().setOpaque(false);
		this.setBorder(null);
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		largerPanel = new LargerPanel();
		setViewportView(largerPanel);
		
		turnto0 = new JButton();
		turnto0.addActionListener(this);
		this.add(turnto0);	
		
		turnto1 = new JButton();
		turnto1.addActionListener(this);
		this.add(turnto1);	
		
		turnto2 = new JButton();
		turnto2.addActionListener(this);
		this.add(turnto2);	
	}
	
	int currentLoction;
	int destination;
	int step;
	int move = 0;
	
	private void setScrollLoction(int _destination){
		currentLoction = this.getVerticalScrollBar().getValue();
		destination = _destination;
		move = 0;
		step = (destination - currentLoction) / 3;
		timer.start();	
	}
	
	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == timer){
			if(move == 3){
				timer.stop();				
			}else{
				move++;
				int value = currentLoction + step * move;
				this.getHorizontalScrollBar().setValue(value);
			}			
		}
		
		if(events.getSource() == turnto0){
			setScrollLoction(0);
		}
		
		if(events.getSource() == turnto1){
			setScrollLoction(UIData.slideSize);
		}
		
		if(events.getSource() == turnto2){
			setScrollLoction(UIData.slideSize * 2);
		}
		
	}

}
