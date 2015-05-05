package ui.frame.match;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.myUI.ImageLabel;
import ui.system.ImageSaver;
import ui.system.UIData;
import vo.MatchVO;

@SuppressWarnings("serial")
public class DataOfMatchPanel extends JPanel {

	//标签
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
	
	//team1数据
	//每节比分
	private JLabel first1;
	private JLabel second1;
	private JLabel third1;
	private JLabel fourth1;
	//加时
	private JLabel extra1;
	//总比分
	private JLabel total1;
	//日期
	private JLabel date1;
	//队伍图片
	private ImageLabel team1;
	//队伍名称
	private JLabel name1;
	
	//team2数据
	//每节比分
	private JLabel first2;
	private JLabel second2;
	private JLabel third2;
	private JLabel fourth2;
	//加时
	private JLabel extra2;
	//总比分
	private JLabel total2;
	//日期
	private JLabel date2;
	//队伍图片
	private JLabel team2;
	//队伍名称
	private JLabel name2;
	
	public DataOfMatchPanel(){
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		this.setSize((int) (350 * UIData.changeX), (int) (620 * UIData.changeY));
		
		first = new JLabel("1ST", JLabel.CENTER);
		second = new JLabel("2ND", JLabel.CENTER);
		third = new JLabel("3RD", JLabel.CENTER);
		fourth = new JLabel("4TH", JLabel.CENTER);
		extra = new JLabel("加时", JLabel.CENTER);
		total = new JLabel("总分", JLabel.CENTER);
		date = new JLabel("日期", JLabel.CENTER);
		
		first1 = new JLabel("23",JLabel.CENTER);
		second1 = new JLabel("24",JLabel.CENTER);
		third1 = new JLabel("26",JLabel.CENTER);
		fourth1 = new JLabel("27",JLabel.CENTER);
		extra1 = new JLabel("0",JLabel.CENTER);
		total1 = new JLabel("100",JLabel.CENTER);
		date1 = new JLabel("2014/9/8",JLabel.CENTER);
		name1 = new JLabel("team1",JLabel.CENTER);
		
		first2 = new JLabel("20",JLabel.CENTER);
		second2 = new JLabel("20",JLabel.CENTER);
		third2 = new JLabel("20",JLabel.CENTER);
		fourth2 = new JLabel("20",JLabel.CENTER);
		extra2 = new JLabel("0",JLabel.CENTER);
		total2 = new JLabel("80",JLabel.CENTER);
		date2 = new JLabel("2014/9/8",JLabel.CENTER);
		team2 = new JLabel();
		name2 = new JLabel("team2",JLabel.CENTER);
		
		
		//设置标签字体
		first.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		second.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		third.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		fourth.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		extra.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		total.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		date.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		
		//设置字体颜色
		first.setForeground(Color.white);
		second.setForeground(Color.white);
		third.setForeground(Color.white);
		fourth.setForeground(Color.white);
		extra.setForeground(Color.white);
		total.setForeground(Color.white);
		date.setForeground(Color.white);
		
		//设置标签字体
		first1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		second1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		third1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		fourth1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		extra1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		total1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		date1.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		name1.setFont(new Font("Arail", Font.BOLD, (int) (40 * UIData.changeY)));
		
		//设置字体颜色
		first1.setForeground(Color.white);
		second1.setForeground(Color.white);
		third1.setForeground(Color.white);
		fourth1.setForeground(Color.white);
		extra1.setForeground(Color.white);
		total1.setForeground(Color.white);
		date1.setForeground(Color.white);
		name1.setForeground(Color.white);
		
		//设置标签字体
		first2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		second2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		third2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		fourth2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		extra2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		total2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		date2.setFont(new Font("Arail", Font.BOLD, (int) (14 * UIData.changeY)));
		name2.setFont(new Font("Arail", Font.BOLD, (int) (40 * UIData.changeY)));
		
		//设置字体颜色
		first2.setForeground(Color.white);
		second2.setForeground(Color.white);
		third2.setForeground(Color.white);
		fourth2.setForeground(Color.white);
		extra2.setForeground(Color.white);
		total2.setForeground(Color.white);
		date2.setForeground(Color.white);
		name2.setForeground(Color.white);
		
		
		//设置标签大小位置
		name1.setBounds((int) (0 * UIData.changeX), (int) (0 * UIData.changeY), (int) (350 * UIData.changeX), (int) (50 * UIData.changeY));
		name2.setBounds((int) (0 * UIData.changeX),(int) (570 * UIData.changeY), (int) (350 * UIData.changeX), (int) (50 * UIData.changeY));
		
		first1.setBounds((int) (15 * UIData.changeX), (int) (250 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		second1.setBounds((int) (55 * UIData.changeX), (int) (250 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		third1.setBounds((int) (95 * UIData.changeX), (int) (250 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		fourth1.setBounds((int) (135 * UIData.changeX), (int) (250 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		extra1.setBounds((int) (175 * UIData.changeX), (int) (250 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		total1.setBounds((int) (215 * UIData.changeX), (int) (250 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		date1.setBounds((int) (255 * UIData.changeX), (int) (250 * UIData.changeY), (int) (80 * UIData.changeX), (int) (40 * UIData.changeY));
		
		first.setBounds((int) (15 * UIData.changeX), (int) (290 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		second.setBounds((int) (55 * UIData.changeX), (int) (290 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		third.setBounds((int) (95 * UIData.changeX), (int) (290 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		fourth.setBounds((int) (135 * UIData.changeX), (int) (290 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		extra.setBounds((int) (175 * UIData.changeX), (int) (290 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		total.setBounds((int) (215 * UIData.changeX), (int) (290 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		date.setBounds((int) (255 * UIData.changeX), (int) (290 * UIData.changeY), (int) (80 * UIData.changeX), (int) (40 * UIData.changeY));
		
		first2.setBounds((int) (15 * UIData.changeX), (int) (330 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		second2.setBounds((int) (55 * UIData.changeX),(int) (330 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		third2.setBounds((int) (95 * UIData.changeX), (int) (330 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		fourth2.setBounds((int) (135 * UIData.changeX), (int) (330 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		extra2.setBounds((int) (175 * UIData.changeX), (int) (330 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		total2.setBounds((int) (215 * UIData.changeX), (int) (330 * UIData.changeY), (int) (40 * UIData.changeX), (int) (40 * UIData.changeY));
		date2.setBounds((int) (255 * UIData.changeX), (int) (330 * UIData.changeY), (int) (80 * UIData.changeX), (int) (40 * UIData.changeY));
		
//		test();
		this.add(first);
		this.add(second);
		this.add(third);
		this.add(fourth);
		this.add(extra);
		this.add(total);
		this.add(date);
		this.add(name1);
		this.add(name2);
		this.add(first1);
		this.add(second1);
		this.add(third1);
		this.add(fourth1);
		this.add(extra1);
		this.add(total1);
		this.add(date1);
		this.add(first2);
		this.add(second2);
		this.add(third2);
		this.add(fourth2);
		this.add(extra2);
		this.add(total2);
		this.add(date2);
		
	}
	
	public JLabel getTeam1() {
		return team1;
	}

	public JLabel getName1() {
		return name1;
	}

	public void setName1(JLabel name1) {
		this.name1 = name1;
	}

	public JLabel getTeam2() {
		return team2;
	}

	public JLabel getName2() {
		return name2;
	}

	public void setName2(JLabel name2) {
		this.name2 = name2;
	}

	public void update(MatchVO match){
		
		String[] score1 = match.getScores1().split("-");
		String[] score2 = match.getScores2().split("-");
		String[] score3 = match.getScores3().split("-");
		String[] score4 = match.getScores4().split("-");
		String[] total = match.getScore().split("-");
		if(match.getExtrascores() != null){
			String[] extra=match.getExtrascores().split("-");
			extra1.setText(extra[0]);//未完
			extra2.setText(extra[1]);//未完
		}
		//信息
		first1.setText(score1[0]);
		first2.setText(score1[1]);
		second1.setText(score2[0]);
		second2.setText(score2[1]);
		third1.setText(score3[0]);
		third2.setText(score3[1]);
		fourth1.setText(score4[0]);
		fourth2.setText(score4[1]);
		total1.setText(total[0]);
		total2.setText(total[1]);
		date1.setText(match.getDate());
		date2.setText(match.getDate());
		
		name1.setText(match.getLeftTeam().getShortName());
		name2.setText(match.getRightTeam().getShortName());
		//队伍图片
		team1 = new ImageLabel(ImageSaver.getTeamIcon(match.getLeftTeam().getShortName()), (int) (75 * UIData.changeX)
				, (int) (50 * UIData.changeY), (int) (200 * UIData.changeX), (int) (200 * UIData.changeY));
		team2 = new ImageLabel(ImageSaver.getTeamIcon(match.getRightTeam().getShortName()), (int) (75 * UIData.changeX),
				(int) (370 * UIData.changeY), (int) (200 * UIData.changeX), (int) (200 * UIData.changeY));
		this.add(team1);
		this.add(team2);
	}
	
}
