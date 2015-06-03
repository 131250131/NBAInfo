package ui.frame.match;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.PlayerController;
import logicservice.playerControllerService;
import ui.myUI.ImageLabel;
import ui.system.Controller;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.PlayerVO;

@SuppressWarnings("serial")
public class tempDataOfPlayerPanel extends JPanel {

	private static ImageLabel portrait;
	
//1.球员名称 （球员名称作为查找唯一标识）
	private JLabel playerName;
//2.球员号码
	private JLabel playerNumber;
	
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

//7.球员年龄
	private JLabel playerAge;

//8.球员进入联盟时间
	private JLabel exp;
	
//9.球员学校或国家
	private JLabel school;
	
	String _playerName;
		
	//调用逻辑层接口
	playerControllerService pcs = PlayerController.getInstance();
	public tempDataOfPlayerPanel(){
		initial1();
	}
	public tempDataOfPlayerPanel(int num){
		initial2();
	}
	/*第一种初始化——横向摆放组件*/
	public void initial1(){
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		this.setSize(850 , 200 );
		
		position = new JLabel();
		playerName = new JLabel();
		playerNumber = new JLabel();
		height = new JLabel();
		playerBirth = new JLabel();
		playerAge = new JLabel();
		exp = new JLabel();
		school = new JLabel();
		weight = new JLabel();
		portrait = new ImageLabel(ImageSaver.getPlayerIcon("null2"), 0, 0, 1, 1);
		
		//设置标签字体
		position.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerName.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerNumber.setFont(new Font("Arail", Font.BOLD,  14 ));
		height.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerBirth.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerAge.setFont(new Font("Arail", Font.BOLD,  14 ));
		exp.setFont(new Font("Arail", Font.BOLD,  14 ));
		school.setFont(new Font("Arail", Font.BOLD,  14 ));
		weight.setFont(new Font("Arail", Font.BOLD, 14 ));
		
		//设置字体颜色
		position.setForeground(Color.white);
		playerName.setForeground(Color.white);
		playerNumber.setForeground(Color.white);
		height.setForeground(Color.white);
		playerBirth.setForeground(Color.white);
		playerAge.setForeground(Color.white);
		exp.setForeground(Color.white);
		school.setForeground(Color.white);
		weight.setForeground(Color.white);
		
		//设置标签大小位置
		playerName.setBounds(255 , 10 , 200 , 20 );
		playerNumber.setBounds(255 , 50 , 200 , 20 );
		position.setBounds(255 , 90 , 200 , 20 );
		height.setBounds(255 , 130 , 200 , 20 );
		playerBirth.setBounds(255 , 170 , 200 , 20 );
		playerAge.setBounds(455 , 10 , 200 , 20 );
		exp.setBounds(455 , 50 , 200 , 20 );
		school.setBounds(455 , 90 , 500 , 20 );
		weight.setBounds(455 , 130 , 200 , 20 );
		
		this.add(playerName);
		this.add(playerNumber);
		this.add(position);
		this.add(height);
		this.add(playerBirth);
		this.add(playerAge);
		this.add(exp);
		this.add(school);
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
		playerNumber = new JLabel();
		height = new JLabel();
		playerBirth = new JLabel();
		playerAge = new JLabel();
		exp = new JLabel();
		school = new JLabel();
		weight = new JLabel();
		portrait = new ImageLabel(ImageSaver.getPlayerIcon("null2"), 0, 0, 1, 1);
		
		//设置标签字体
		position.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerName.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerNumber.setFont(new Font("Arail", Font.BOLD,  14 ));
		height.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerBirth.setFont(new Font("Arail", Font.BOLD,  14 ));
		playerAge.setFont(new Font("Arail", Font.BOLD,  14 ));
		exp.setFont(new Font("Arail", Font.BOLD,  14 ));
		school.setFont(new Font("Arail", Font.BOLD,  14 ));
		weight.setFont(new Font("Arail", Font.BOLD, 14 ));
		
		//设置字体颜色
		position.setForeground(Color.white);
		playerName.setForeground(Color.white);
		playerNumber.setForeground(Color.white);
		height.setForeground(Color.white);
		playerBirth.setForeground(Color.white);
		playerAge.setForeground(Color.white);
		exp.setForeground(Color.white);
		school.setForeground(Color.white);
		weight.setForeground(Color.white);
		
		//设置标签大小位置
		playerName.setBounds(10 , 220 , 200 , 20 );
		playerNumber.setBounds(10 , 270 , 200 , 20 );
		position.setBounds(10 , 320 , 200 , 20 );
		height.setBounds(10 , 370 , 200 , 20 );
		playerBirth.setBounds(10 , 420 , 200 , 20 );
		playerAge.setBounds(10 , 470 , 200 , 20 );
		exp.setBounds(10 , 520 , 200 , 20 );
		school.setBounds(10 , 570 , 500 , 20 );
		weight.setBounds(10 , 620 , 200 , 20 );
		
		this.add(playerName);
		this.add(playerNumber);
		this.add(position);
		this.add(height);
		this.add(playerBirth);
		this.add(playerAge);
		this.add(exp);
		this.add(school);
		this.add(weight);
		
		empty();
	}
	void empty(){
		//头像
		portrait = new ImageLabel(ImageSaver.getPlayerIcon("null2"), 
				35 , 15 , 230 , 185 );
		this.add(portrait);
		_playerName = "null";
		this.repaint();
		//信息
		playerName.setText("球员：");
		playerNumber.setText("号码：");
		position.setText("位置：");
		height.setText("身高：");
		playerBirth.setText("生日：");
		playerAge.setText("年龄：");
		exp.setText("经验：" );
		school.setText("来自：");
		weight.setText("体重：" );
	}
	
	public void update(String player){
		String[] str = player.split("[(]");
		player = str[0];
		PlayerVO temp = pcs.findPlayerVO(player);
		portrait.setVisible(false);
		if(temp == null){
			empty();
		}
		else{
			//头像
			portrait = new ImageLabel(ImageSaver.getPlayerIcon(temp.getPlayerName()), 
					35 , 15 , 230 , 185 );
			portrait.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent arg0) {	
					Controller.addPlayerPanel(_playerName);
				}
			});
			this.add(portrait);
			_playerName = temp.getPlayerName();
			this.repaint();
			//信息
			playerName.setText("球员：" + temp.getPlayerName());
			playerNumber.setText("号码：" + temp.getPlayerNumber());
			position.setText("位置：" + temp.getPosition());
			height.setText("身高：" + temp.getHeight());
			playerBirth.setText("生日：" + temp.getPlayerBirth());
			playerAge.setText("年龄：" + String.valueOf(temp.getPlayerAge()));
			exp.setText("经验：" + String.valueOf(temp.getExp()));
			school.setText("来自：" + temp.getSchool());
			weight.setText("体重：" + String.valueOf(temp.getWeight()));
		}
	}
}
