package ui.frame.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import thirdVersion.PlayerBasicInfoVO;
import thirdVersion.PlayerControllerThird;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;

@SuppressWarnings("serial")
public class tempDataOfPlayerPanel extends JPanel {

	private ImageLabel portrait;
	
//1.球员名称 （球员名称作为查找唯一标识）
	private JLabel playerName;
//2.球员毕业高中
	private JTextArea playerHighSchool;
	
//3.球员位置
	//先发中锋C 先发前锋F 先发后卫G 
	private JLabel position;
	
//4.球员高度
	//格式类似：6-0 (6尺0寸)
	private JLabel height;
	
//5.球员体重
	//格式类似：161
	private JLabel weight;

//6.球员生日
	//格式类似： JAN 14， 1985
	private JLabel playerBirth;

//8.球员出生地
	private JLabel playerBirthPlace;
	
//9.球员毕业大学
	private JTextArea playerUniversity;
	
	String _playerName;
		
	//调用逻辑层接口
//	playerControllerService pcs = PlayerController.getInstance();
	private PlayerControllerThird pcs=new PlayerControllerThird();//逻辑层接口
	public tempDataOfPlayerPanel(){
		initial1();
	}
	public tempDataOfPlayerPanel(int num){
		initial2();
	}
	public String getID(){
		return portrait.getText();
	}
	/*第一种初始化——横向摆放组件*/
	public void initial1(){
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		this.setSize(850 , 200 );
		
		position = new JLabel();
		playerName = new JLabel();
		playerHighSchool = new JTextArea();
		height = new JLabel();
		playerBirth = new JLabel();
		playerBirthPlace = new JLabel();
		playerUniversity = new JTextArea();
		weight = new JLabel();
		portrait = new ImageLabel(ImageSaver.getPlayerIcon("null2"), 0, 0, 1, 1);
		
		//设置标签字体
		position.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerName.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerHighSchool.setFont(new Font("Arail", Font.BOLD,  14 ));
		height.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerBirth.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerBirthPlace.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerUniversity.setFont(new Font("Arail", Font.BOLD,  14 ));
		weight.setFont(new Font("Arail", Font.BOLD, 14 ));
		
		//设置字体颜色
		position.setForeground(Color.white);
		playerName.setForeground(Color.white);
		playerHighSchool.setForeground(Color.white);
		height.setForeground(Color.white);
		playerBirth.setForeground(Color.white);
		playerBirthPlace.setForeground(Color.white);
		playerUniversity.setForeground(Color.white);
		weight.setForeground(Color.white);
		
		//设置标签大小位置
		playerName.setBounds(255 , 10 , 200 , 20 );
		position.setBounds(255 , 50 , 200 , 20 );
		height.setBounds(255 , 90 , 200 , 20 );
		playerBirth.setBounds(255 , 130 , 200 , 20 );
		playerBirthPlace.setBounds(255 , 170 , 200 , 20 );
		playerHighSchool.setBounds(455 , 50 , 200 , 20 );
		playerUniversity.setBounds(455 , 90 , 500 , 20 );
		weight.setBounds(455 , 130 , 200 , 20 );
		
		this.add(playerName);
		this.add(playerHighSchool);
		this.add(position);
		this.add(height);
		this.add(playerBirth);
		this.add(playerBirthPlace);
		this.add(playerUniversity);
		this.add(weight);
		
		empty();
	}
	/*第二种初始化——纵向摆放组件*/
	public void initial2(){
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setSize(300 , 670);
		
		position = new JLabel();
		playerName = new JLabel();
		playerHighSchool = new JTextArea();
		height = new JLabel();
		playerBirth = new JLabel();
		playerBirthPlace = new JLabel();
		
		playerUniversity = new JTextArea();
		weight = new JLabel();
		portrait = new ImageLabel(ImageSaver.getPlayerIcon("null2"), 0, 0, 1, 1);
		
		//设置标签字体
		position.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerName.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerHighSchool.setFont(new Font("Arail", Font.BOLD,  14 ));
		height.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerBirth.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerBirthPlace.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerUniversity.setFont(new Font("Arail", Font.BOLD,  14 ));
		weight.setFont(new Font("Arail", Font.BOLD, 14 ));
		
		//设置字体颜色
		position.setForeground(Color.white);
		playerName.setForeground(Color.white);
		playerHighSchool.setForeground(Color.white);
		height.setForeground(Color.white);
		playerBirth.setForeground(Color.white);
		playerBirthPlace.setForeground(Color.white);
		playerUniversity.setForeground(Color.white);
		weight.setForeground(Color.white);
		
		//文本域设置
		playerUniversity.setBorder(null);
		playerUniversity.setOpaque(false);
		playerUniversity.setLineWrap(true);
		playerUniversity.setEditable(false);
		
		playerHighSchool.setBorder(null);
		playerHighSchool.setOpaque(false);
		playerHighSchool.setLineWrap(true);
		playerHighSchool.setEditable(false);
		
		
		//设置标签大小位置
		playerName.setBounds(10 , 220 , 200 , 20 );
		position.setBounds(10 , 270 , 200 , 20 );
		height.setBounds(10 , 320 , 200 , 20 );
		weight.setBounds(10 , 370 , 200 , 20 );
		playerBirth.setBounds(10 , 420 , 200 , 20 );
		playerBirthPlace.setBounds(10 , 470 , 200 , 20 );
		playerHighSchool.setBounds(10 , 520 , 290 , 40 );
		playerUniversity.setBounds(10 , 590 , 290 , 40 );
		
		
		this.add(playerName);
		this.add(playerHighSchool);
		this.add(position);
		this.add(height);
		this.add(playerBirth);
		this.add(playerBirthPlace);
		this.add(playerUniversity);
		this.add(weight);
		
		empty();
	}
	void empty(){
		//头像
		portrait = new ImageLabel(ImageSaver.getPlayerIcon("null2"), 
				35 , 15 , 230 , 185 );
		portrait.setForeground(Color.gray);
		this.add(portrait);
		_playerName = "null";
		this.repaint();
		//信息
		playerName.setText("球员：");
		playerHighSchool.setText("高中：");
		position.setText("位置：");
		height.setText("身高：");
		playerBirth.setText("生日：");
		playerBirthPlace.setText("出生地：" );
		playerUniversity.setText("大学：");
		weight.setText("体重：" );
		portrait.setText("-1");
	}
	
	public void update(String player){
//		String[] str = player.split("[(]");
//		player = str[0];
		PlayerBasicInfoVO temp = pcs.getPlayerbyname(player);
		portrait.setVisible(false);
		if(temp == null){
			System.out.println("null");
			empty();
		}
		else{
			//头像
			portrait = new ImageLabel(ImageSaver.getPlayerIcon(temp.getEnglishName()), 
					35 , 15 , 230 , 185 );
			portrait.setForeground(Color.gray);
			portrait.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent arg0) {	
					Controller.addPlayerPanel(_playerName);
				}
			});
			this.add(portrait);
			_playerName = temp.getEnglishName();
			this.repaint();
			//信息
			playerName.setText("球员：" + temp.getChinesename());
			playerHighSchool.setText("高中：" + temp.getPlayerHighSchool());
			position.setText("位置：" + temp.getPlayerPosition());
			height.setText("身高：" + temp.getPlayerHeight());
			playerBirth.setText("生日：" + temp.getPlayerBirthDay());
			playerBirthPlace.setText("出生地：" + temp.getPlayerBirthPlace());
			playerUniversity.setText("大学：" + temp.getPlayerUniversity());
			weight.setText("体重：" + temp.getPlayerWeight());
			portrait.setText(temp.getPlayerID());
		}
	}
}
