package userInterface.myUI;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyBackground extends JLabel{
	
	public MyBackground(String index){
		this.setBounds(0, 0, 1280, 720);
		this.setVisible(true);
		this.setIcon(ImageSaver.getIcon(index));
	}

}
