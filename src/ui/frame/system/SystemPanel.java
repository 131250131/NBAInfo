package ui.frame.system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.frame.mainframe.MainFrame;
import ui.system.UIData;

@SuppressWarnings("serial")
public class SystemPanel extends JPanel implements ActionListener{
	
	int width = (int) (1720 * UIData.changeX);
	int height = (int) (4000 * UIData.changeY);
	
	JButton buttonOff, buttonMini, buttonSize;
	JLabel labelOff, labelMini, labelSize;
	JComboBox<String> comboBox;
	
	public SystemPanel(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		this.setVisible(true);
		
		JLabel title = new JLabel("系统设置");
		title.setBounds((int) (285 * UIData.changeX), (int) (30 * UIData.changeY), (int) (200 * UIData.changeX), (int) (30 * UIData.changeY));
		title.setForeground(Color.LIGHT_GRAY);
		title.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
		title.setVisible(true);
		this.add(title);
		
		buttonOff = new JButton();
		buttonOff.setVisible(true);
		buttonOff.setBounds((int) (770 * UIData.changeX), (int) (200 * UIData.changeY),
				(int) (300 * UIData.changeX), (int) (25 * UIData.changeY));
		buttonOff.addActionListener(this);
		buttonOff.setContentAreaFilled(false);
		buttonOff.setBorder(BorderFactory.createEmptyBorder());
		buttonOff.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				labelOff.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				labelOff.setForeground(Color.WHITE);
			}
			});
		this.add(buttonOff);
		
		labelOff = new JLabel("-关闭系统-", JLabel.CENTER);
		labelOff.setBounds(buttonOff.getX(), buttonOff.getY(), buttonOff.getWidth(), buttonOff.getHeight());
		labelOff.setForeground(Color.WHITE);
		labelOff.setFont(new Font("新細明體", Font.BOLD, (int)(25 * UIData.changeY)));
		labelOff.setVisible(true);
		this.add(labelOff);
		
		buttonMini = new JButton();
		buttonMini.setVisible(true);
		buttonMini.setBounds((int) (770 * UIData.changeX), (int) (300 * UIData.changeY),
				(int) (300 * UIData.changeX), (int) (25 * UIData.changeY));
		buttonMini.addActionListener(this);
		buttonMini.setContentAreaFilled(false);
		buttonMini.setBorder(BorderFactory.createEmptyBorder());
		buttonMini.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				labelMini.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				labelMini.setForeground(Color.WHITE);
			}
			});
		this.add(buttonMini);
		
		labelMini = new JLabel("-最小化窗口-", JLabel.CENTER);
		labelMini.setBounds(buttonMini.getX(), buttonMini.getY(), buttonMini.getWidth(), buttonMini.getHeight());
		labelMini.setForeground(Color.WHITE);
		labelMini.setFont(new Font("新細明體", Font.BOLD, (int)(25 * UIData.changeY)));
		labelMini.setVisible(true);
		this.add(labelMini);
		
		buttonSize = new JButton();
		buttonSize.setVisible(true);
		buttonSize.setBounds((int) (770 * UIData.changeX), (int) (460 * UIData.changeY),
				(int) (300 * UIData.changeX), (int) (25 * UIData.changeY));
		buttonSize.addActionListener(this);
		buttonSize.setContentAreaFilled(false);
		buttonSize.setBorder(BorderFactory.createEmptyBorder());
		buttonSize.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent arg0) {
				labelSize.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				labelSize.setForeground(Color.WHITE);
			}
			});
		this.add(buttonSize);
		
		labelSize = new JLabel("-改变窗口分辨率-", JLabel.CENTER);
		labelSize.setBounds(buttonSize.getX(), buttonSize.getY(), buttonSize.getWidth(), buttonSize.getHeight());
		labelSize.setForeground(Color.WHITE);
		labelSize.setFont(new Font("新細明體", Font.BOLD, (int)(25 * UIData.changeY)));
		labelSize.setVisible(true);
		this.add(labelSize);
		
		ArrayList<String> array = UIData.getSuitableSize();
		String[] stringArray = new String[array.size()];
		for(int i = 0; i < array.size(); i++)
			stringArray[i] = array.get(i);
		comboBox = new JComboBox<String>(stringArray);
		comboBox.setBounds((int) (770 * UIData.changeX), (int) (410 * UIData.changeY),
				(int) (300 * UIData.changeX), (int) (30 * UIData.changeY));
		comboBox.setVisible(true);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setForeground(Color.WHITE);
		this.add(comboBox);
		
		int labelX = (int) (200 * UIData.changeX);
		int labelWidth = (int) (1410 * UIData.changeX);
		
		JPanel backPanel = new JPanel();
		backPanel.setBounds(labelX, 0, labelWidth, height);
		backPanel.setBackground(new Color(0, 0, 0, 0.8f));
		backPanel.setVisible(true);
		this.add(backPanel);
	}

	@Override
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == buttonOff){
			System.exit(0);
		}
		
		if(events.getSource() == buttonMini){
			MainFrame.mini.doClick();
		}
	}
}
