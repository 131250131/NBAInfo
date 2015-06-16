package ui.myUI;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ImageLabel extends JLabel{
	
	public ImageLabel(ImageIcon image, int x, int y, int width, int height){				
//		image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));		
		this.setBounds(x, y, width, height);
		this.setIcon(image);
		this.setVisible(true);
	}

}
