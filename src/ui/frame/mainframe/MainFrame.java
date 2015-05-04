package ui.frame.mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ui.frame.larger.LargerScrollPane;
import ui.myUI.MyFrame;

@SuppressWarnings("serial")
public class MainFrame extends MyFrame implements ActionListener{
	
	LargerScrollPane largerScrollPane;
	public static JButton mini;
	public MainFrame(){		
		largerScrollPane = new LargerScrollPane();
		this.add(largerScrollPane);
		LargerScrollPane.turnto3.doClick();
		
		mini = new JButton();
		mini.addActionListener(this);
		this.add(mini);
	}
	@Override
	public void actionPerformed(ActionEvent events) {
	
		if(events.getSource() == mini){
			MainFrame.this.setExtendedState(JFrame.ICONIFIED);
		}
		
	}

}
