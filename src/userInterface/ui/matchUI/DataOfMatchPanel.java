package userInterface.ui.matchUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.myUI.ImageSaver;
import vo.MatchVO;

import com.nba.davisUI.myUI.ImageBin;

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
	private JLabel team1;
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
		
		this.setSize(350, 620);
		
		first=new JLabel("1ST",JLabel.CENTER);
		second=new JLabel("2ND",JLabel.CENTER);
		third=new JLabel("3RD",JLabel.CENTER);
		fourth=new JLabel("4TH",JLabel.CENTER);
		extra=new JLabel("EXT",JLabel.CENTER);
		total=new JLabel("TOT",JLabel.CENTER);
		date=new JLabel("DAT",JLabel.CENTER);
		
		first1=new JLabel("23",JLabel.CENTER);
		second1=new JLabel("24",JLabel.CENTER);
		third1=new JLabel("26",JLabel.CENTER);
		fourth1=new JLabel("27",JLabel.CENTER);
		extra1=new JLabel("0",JLabel.CENTER);
		total1=new JLabel("100",JLabel.CENTER);
		date1=new JLabel("2014/9/8",JLabel.CENTER);
		team1=new JLabel();
		name1=new JLabel("team1",JLabel.CENTER);
		
		first2=new JLabel("20",JLabel.CENTER);
		second2=new JLabel("20",JLabel.CENTER);
		third2=new JLabel("20",JLabel.CENTER);
		fourth2=new JLabel("20",JLabel.CENTER);
		extra2=new JLabel("0",JLabel.CENTER);
		total2=new JLabel("80",JLabel.CENTER);
		date2=new JLabel("2014/9/8",JLabel.CENTER);
		team2=new JLabel();
		name2=new JLabel("team2",JLabel.CENTER);
		
		
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
		
		//设置标签字体
		first1.setFont(new Font("宋体",Font.BOLD,14));
		second1.setFont(new Font("宋体",Font.BOLD,14));
		third1.setFont(new Font("宋体",Font.BOLD,14));
		fourth1.setFont(new Font("宋体",Font.BOLD,14));
		extra1.setFont(new Font("宋体",Font.BOLD,14));
		total1.setFont(new Font("宋体",Font.BOLD,14));
		date1.setFont(new Font("宋体",Font.BOLD,14));
		name1.setFont(new Font("宋体",Font.BOLD,40));
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
		first2.setFont(new Font("宋体",Font.BOLD,14));
		second2.setFont(new Font("宋体",Font.BOLD,14));
		third2.setFont(new Font("宋体",Font.BOLD,14));
		fourth2.setFont(new Font("宋体",Font.BOLD,14));
		extra2.setFont(new Font("宋体",Font.BOLD,14));
		total2.setFont(new Font("宋体",Font.BOLD,14));
		date2.setFont(new Font("宋体",Font.BOLD,14));
		name2.setFont(new Font("宋体",Font.BOLD,40));
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
		name1.setBounds(0, 0, 350, 50);
		team1.setBounds(75, 50, 200, 200);
		team2.setBounds(75, 370, 200, 200);
		name2.setBounds(0,570, 350, 50);
		
		first1.setBounds(15, 250, 40, 40);
		second1.setBounds(55,250, 40, 40);
		third1.setBounds(95, 250, 40, 40);
		fourth1.setBounds(135, 250, 40, 40);
		extra1.setBounds(175, 250, 40, 40);
		total1.setBounds(215, 250, 40, 40);
		date1.setBounds(255, 250, 80, 40);
		
		first.setBounds(15, 290, 40, 40);
		second.setBounds(55,290, 40, 40);
		third.setBounds(95, 290, 40, 40);
		fourth.setBounds(135, 290, 40, 40);
		extra.setBounds(175, 290, 40, 40);
		total.setBounds(215, 290, 40, 40);
		date.setBounds(255, 290, 80, 40);
		
		first2.setBounds(15, 330, 40, 40);
		second2.setBounds(55,330, 40, 40);
		third2.setBounds(95, 330, 40, 40);
		fourth2.setBounds(135, 330, 40, 40);
		extra2.setBounds(175, 330, 40, 40);
		total2.setBounds(215, 330, 40, 40);
		date2.setBounds(255, 330, 80, 40);
		
//		test();
		this.add(first,0);
		this.add(second,1);
		this.add(third,2);
		this.add(fourth,3);
		this.add(extra,4);
		this.add(total,5);
		this.add(date,6);
		this.add(name1,7);
		this.add(team1,8);
		this.add(name2,9);
		this.add(team2,10);
		this.add(first1,11);
		this.add(second1,12);
		this.add(third1,13);
		this.add(fourth1,14);
		this.add(extra1,15);
		this.add(total1,16);
		this.add(date1,17);
		this.add(first2,18);
		this.add(second2,19);
		this.add(third2,20);
		this.add(fourth2,21);
		this.add(extra2,22);
		this.add(total2,23);
		this.add(date2,24);
		
	}
	
	public JLabel getTeam1() {
		return team1;
	}

	public void setTeam1(JLabel team1) {
		this.team1 = team1;
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

	public void setTeam2(JLabel team2) {
		this.team2 = team2;
	}

	public JLabel getName2() {
		return name2;
	}

	public void setName2(JLabel name2) {
		this.name2 = name2;
	}

	/*测试*/
	void test(){
		//信息
		first1.setText("20");
		first2.setText("20");
		second1.setText("20");
		second2.setText("20");
		third1.setText("20");
		third2.setText("20");
		fourth1.setText("20");
		fourth2.setText("20");
		extra1.setText("0");//未完
		extra2.setText("0");//未完
		total1.setText("80");
		total2.setText("80");
		date1.setText("2015/4/18");
		date2.setText("2015/4/18");
		
		team1.setText("ATL");
		team2.setText("BKN");
		name1.setText("ATL");
		name2.setText("BKN");
		
		
	}
	public void update(MatchVO match){
		
		String[] score1=match.getScores1().split("-");
		String[] score2=match.getScores2().split("-");
		String[] score3=match.getScores3().split("-");
		String[] score4=match.getScores4().split("-");
		String[] total=match.getScore().split("-");
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
		
		team1.setText(match.getLeftTeam().getShortName());
		team2.setText(match.getRightTeam().getShortName());
		name1.setText(match.getLeftTeam().getShortName());
		name2.setText(match.getRightTeam().getShortName());
		//队伍图片
		team1.setIcon(ImageSaver.getIcon("teams/"+match.getLeftTeam().getShortName()));
		team2.setIcon(ImageSaver.getIcon("teams/"+match.getRightTeam().getShortName()));
	}
	
}
