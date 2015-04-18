package userInterface.ui.matchUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.PlayerController;
import logicservice.playerControllerService;
import userInterface.myUI.ImageSaver;
import vo.PlayerVO;

public class DataOfPlayerPanel extends JPanel {

	private JLabel portrait;
	
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
		
	//调用逻辑层接口
	playerControllerService pcs=new PlayerController();
	public DataOfPlayerPanel(){
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		this.setSize(850, 200);
		
		portrait=new JLabel();
		portrait.setBounds(10, 10, 230, 185);
		
		position=new JLabel();
		playerName=new JLabel();
		playerNumber=new JLabel();
		height=new JLabel();
		playerBirth=new JLabel();
		playerAge=new JLabel();
		exp=new JLabel();
		school=new JLabel();
		weight=new JLabel();
		//设置标签字体
		position.setFont(new Font("宋体",Font.BOLD,14));
		playerName.setFont(new Font("宋体",Font.BOLD,14));
		playerNumber.setFont(new Font("宋体",Font.BOLD,14));
		height.setFont(new Font("宋体",Font.BOLD,14));
		playerBirth.setFont(new Font("宋体",Font.BOLD,14));
		playerAge.setFont(new Font("宋体",Font.BOLD,14));
		exp.setFont(new Font("宋体",Font.BOLD,14));
		school.setFont(new Font("宋体",Font.BOLD,14));
		weight.setFont(new Font("宋体",Font.BOLD,14));
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
		playerName.setBounds(255, 10, 200, 20);
		playerNumber.setBounds(255,50, 200, 20);
		position.setBounds(255, 90, 200, 20);
		height.setBounds(255, 130, 200, 20);
		playerBirth.setBounds(255, 170, 200, 20);
		playerAge.setBounds(455, 10, 200, 20);
		exp.setBounds(455, 50, 200, 20);
		school.setBounds(455, 90, 200, 20);
		weight.setBounds(455, 130, 200, 20);
		
		test();
		this.add(playerName,0);
		this.add(playerNumber,1);
		this.add(position,2);
		this.add(height,3);
		this.add(playerBirth,4);
		this.add(playerAge,5);
		this.add(exp,6);
		this.add(school,7);
		this.add(weight,8);
		this.add(portrait,9);
	}
	void test(){
		//头像
		portrait.setIcon(ImageSaver.getIcon("portrait/"+"Aaron Brooks"));
		//信息
		playerName.setText("球员："+"Aaron Brooks");
		playerNumber.setText("号码："+"66");
		position.setText("位置："+"门将");
		height.setText("身高："+"1.5");
		playerBirth.setText("生日："+"10/1");
		playerAge.setText("年龄："+"50");
		exp.setText("球龄："+"1");
		school.setText("毕业院校："+"Blue Shit");
		weight.setText("体重："+"70");
	}
	public void update(String player){
		PlayerVO temp = null;
		//头像
		portrait.setIcon(ImageSaver.getIcon("portrait/"+temp.getPlayerName()));
		//信息
		playerName.setText("球员："+temp.getPlayerName());
		playerNumber.setText("号码："+temp.getPlayerNumber());
		position.setText("位置："+temp.getPosition());
		height.setText("身高："+temp.getHeight());
		playerBirth.setText("生日："+temp.getPlayerBirth());
		playerAge.setText("年龄："+String.valueOf(temp.getPlayerAge()));
		exp.setText("球龄："+String.valueOf(temp.getExp()));
		school.setText("毕业院校："+temp.getSchool());
		weight.setText("体重："+String.valueOf(temp.getWeight()));
	}
}
