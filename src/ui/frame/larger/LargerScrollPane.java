package ui.frame.larger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import ui.system.Controller;
import ui.system.UIData;

@SuppressWarnings("serial")
public class LargerScrollPane extends JScrollPane implements ActionListener{
	
	int x = UIData.largerScrollPaneX;
	int y = UIData.largerScrollPaneY;
	int width = UIData.largerScrollPaneWidth;
	int height = UIData.largerScrollPaneHeight;;
	
	LargerPanel largerPanel;
	Timer timer = new Timer(1, this);
	public static JButton turnto;
	
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
		
		turnto = new JButton();
		turnto.addActionListener(this);
		this.add(turnto);	
	}
	
	int currentLoction;
	int destination;
	int step;
	int move = 0;
	
	private void setScrollLoction(int _destination){
		currentLoction = this.getHorizontalScrollBar().getValue();
		destination = _destination;
		move = 0;
		step = (destination - currentLoction) / 4;
		timer.start();	
	}
	
	@Override
	public void actionPerformed(ActionEvent events) {
		
		if(events.getSource() == timer){
			if(move == 4){
				timer.stop();				
			}else{
				move++;
				int value = currentLoction + step * move;
				this.getHorizontalScrollBar().setValue(value);
			}			
		}
		
		if(events.getSource() == turnto){
			setScrollLoction(UIData.slideSize * (UIData.slideMax - UIData.currentStep));
		}
				
	}

}
