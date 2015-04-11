package com.nba.davisUI.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import po.MatchPO;

import com.nba.davisUI.myUI.ImageBin;

public class DataOfMatchPanel extends JPanel {

	
	//每节比分
	private JLabel first;
	private JLabel second;
	private JLabel third;
	private JLabel fourth;
	//加时
	private JLabel extra;
	//总比分
	private JLabel total;
	//日期
	private JLabel date;
	public DataOfMatchPanel(){
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		this.setSize(870, 200);
		
		first=new JLabel();
		second=new JLabel();
		third=new JLabel();
		fourth=new JLabel();
		extra=new JLabel();
		total=new JLabel();
		date=new JLabel();
		//设置标签字体
		first.setFont(new Font("宋体",Font.BOLD,14));
		second.setFont(new Font("宋体",Font.BOLD,14));
		third.setFont(new Font("宋体",Font.BOLD,14));
		fourth.setFont(new Font("宋体",Font.BOLD,14));
		extra.setFont(new Font("宋体",Font.BOLD,14));
		total.setFont(new Font("宋体",Font.BOLD,14));
		date.setFont(new Font("宋体",Font.BOLD,14));
		//设置字体颜色
		first.setForeground(Color.white);
		second.setForeground(Color.white);
		third.setForeground(Color.white);
		fourth.setForeground(Color.white);
		extra.setForeground(Color.white);
		total.setForeground(Color.white);
		date.setForeground(Color.white);
		//设置标签大小位置
//		second.setBounds(255, 10, 200, 20);
//		third.setBounds(255,50, 200, 20);
//		first.setBounds(255, 90, 200, 20);
//		fourth.setBounds(255, 130, 200, 20);
//		extra.setBounds(255, 170, 200, 20);
//		total.setBounds(455, 10, 200, 20);
//		date.setBounds(455, 50, 200, 20);
		
		this.add(first,0);
		this.add(second,1);
		this.add(third,2);
		this.add(fourth,3);
		this.add(extra,4);
		this.add(total,5);
		this.add(date,6);
		
	}
	public void update(){
		MatchPO temp = null;
		//信息
		first.setText("第一场："+temp.getScores1());
		second.setText("第二场："+temp.getScores2());
		third.setText("第三场："+temp.getScores3());
		fourth.setText("第四场："+temp.getScores4());
		extra.setText("加时：");//未完
		total.setText("总比分："+temp.getScore());
		date.setText("日期："+temp.getDate());
	}
	
}
