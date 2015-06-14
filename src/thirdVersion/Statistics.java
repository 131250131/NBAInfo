package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Utibility.DataType;

//这是一个统计类，用来完成迭代三的统计部分的
public class Statistics {
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="941211";	
	//如果遇到数据库密码的问题，可能是 "",也有可能是 "941211" 试一下就好
	String sql="";
	DecimalFormat    df   = new DecimalFormat("######0.00"); 
	
	
	public static void main(String arg){
		Statistics s = new Statistics();
		s.getTestSalary("1", "11-12");
	}
	
	public double forcastData(String pID, DataType dtp){
		double result =0.0;
		ArrayList<Double> playerData = this.getDataList(pID, dtp);
		MathCalculator calculator = new MathCalculator();
		double aver = calculator.getAverage(playerData);
		double var = calculator.getVariance(playerData);
		//这边调用方法获得我的预测信息
		//这个预测有多准？
		//这个公式该怎么写
		//妈蛋我还真是不知道
		
		return result;
	}
	
	public double getForcastPercent(double forcast , DataType dtp){
		double result =0;
		//这边调用一个函数来获得可信度
		
		
		return result;
	}
	
	public ArrayList<Double> getDataList(String pID, DataType dtp){
		ArrayList<Double> result =  new ArrayList<Double>();
		String datatype = new String();
		switch(dtp){
			case Atime:datatype = "Atime" ;break;
			case FGP:datatype = "FGP" ;break;
			case AFGZ: datatype = "AFGZ" ;break;
			case AFG:datatype = "AFG" ;break;
			case SFGP:datatype = "SFGP"  ;break;
			case ASFGZ:datatype = "ASFGZ" ;break;
			case ASFG: datatype = "ASFG" ;break;
			case FTGP:datatype = "FTGP" ;break;
			case AFTGZ:datatype = "AFTGZ" ;break;
			case AFTG: datatype = "AFTG" ;break;
			case ARebounds:datatype = "ARebounds" ;break;
			case AORebouns: datatype = "AORebouns" ;break;
			case ADRebounds:datatype = "ADRebounds" ;break;
			case AAssists: datatype = "AAssists" ;break;
			case ASteals:datatype = "ASteals" ;break;
			case ABlocks: datatype = "ABlocks" ;break;
			case ATurnovers:datatype = "ATurnovers" ;break;
			case AFouls:datatype = "AFouls"  ;break;
			case AScores:datatype = "AScores" ;break;
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/nbadata?characterEncoding=utf-8", "root", "");
			String sql =  new String();
				sql = "SELECT "+"'"+datatype+"' FROM playerdatainfo WHERE id="+"'"+pID+"'";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				double temp = 0.0;
				while(rs.next()){
					temp=rs.getDouble(1);
					result.add(temp);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	} 
	
	public double getTestSalary(String playerID,String season){
		double result = 0;
		PlayerdatainfoVO p = new PlayerdatainfoVO();
		String position = new String();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/nbadata?characterEncoding=utf-8", "root", "");
			String sql =  new String();
				sql = "SELECT * playerdatainfo WHERE id="+""+playerID+"' and season="+"'"+season+"'and ispalyoff="+"0"+" ;";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					p.id=rs.getString(1);//球员编号 
    			    p.season=rs.getString(2);//赛季
    			    p.teamname=rs.getString(3);//teamname为总计时，表示该球员一个赛季在两个球队打过
    			    p.attendmatches=Double.parseDouble(df.format(rs.getDouble(4)));
    			    p.First=Double.parseDouble(df.format(rs.getDouble(5)));
    			    p.Atime=Double.parseDouble(df.format(rs.getDouble(6)));
    			    p.FGP=Double.parseDouble(df.format(rs.getDouble(7)*100));
    			    p.AFGZ=Double.parseDouble(df.format(rs.getDouble(8)));//Z代表命中
    			    p.AFG=Double.parseDouble(df.format(rs.getDouble(9)));
    			    p.SFGP=Double.parseDouble(df.format(rs.getDouble(10)*100));
    			    p.ASFGZ=Double.parseDouble(df.format(rs.getDouble(11)));
    			    p.ASFG=Double.parseDouble(df.format(rs.getDouble(12)));
    			    p.FTGP=Double.parseDouble(df.format(rs.getDouble(13)*100));
    			    p.AFTGZ=Double.parseDouble(df.format(rs.getDouble(14)));
    			    p.AFTG=Double.parseDouble(df.format(rs.getDouble(15)));
    			    p.ARebounds=Double.parseDouble(df.format(rs.getDouble(16)));
    			    p.AORebouns=Double.parseDouble(df.format(rs.getDouble(17)));
    			    p.ADRebounds=Double.parseDouble(df.format(rs.getDouble(18)));
    			    p.AAssists=Double.parseDouble(df.format(rs.getDouble(19)));
    			    p.ASteals=Double.parseDouble(df.format(rs.getDouble(20)));
    			    p.ABlocks=Double.parseDouble(df.format(rs.getDouble(21)));
    			    p.ATurnovers=Double.parseDouble(df.format(rs.getDouble(22)));
    			    p.AFeals=Double.parseDouble(df.format(rs.getDouble(23)));
    			    p.AScores=Double.parseDouble(df.format(rs.getDouble(24)));
    			    p.Win=Double.parseDouble(df.format(rs.getDouble(25)));
    			    p.Lose=Double.parseDouble(df.format(rs.getDouble(26)));
    			    p.Ttime=Double.parseDouble(df.format(rs.getDouble(27)));
    			    p.TFGZ=Double.parseDouble(df.format(rs.getDouble(28)));
    			    p.TFG=Double.parseDouble(df.format(rs.getDouble(29)));
    			    p.TSFGZ=Double.parseDouble(df.format(rs.getDouble(30)));
    			    p.TSFG=Double.parseDouble(df.format(rs.getDouble(31)));
    			    p.TFTGZ=Double.parseDouble(df.format(rs.getDouble(32)));
    			    p.TFTG=Double.parseDouble(df.format(rs.getDouble(33)));
    			    p.TRebounds=Double.parseDouble(df.format(rs.getDouble(34)));
    			    p.TORebouns=Double.parseDouble(df.format(rs.getDouble(35)));
    			    p.TDRebounds=Double.parseDouble(df.format(rs.getDouble(36)));
    			    p.TAssists=Double.parseDouble(df.format(rs.getDouble(37)));
    			    p.TSteals=Double.parseDouble(df.format(rs.getDouble(38)));
    			    p.TBlocks=Double.parseDouble(df.format(rs.getDouble(39)));
    			    p.TTurnovers=Double.parseDouble(df.format(rs.getDouble(40)));
    			    p.TFeals=Double.parseDouble(df.format(rs.getDouble(41)));
    			    p.TScores=Double.parseDouble(df.format(rs.getDouble(42)));
    			    p.RR=Double.parseDouble(df.format(rs.getDouble(43)));//篮板率
    			    p.O_RR=Double.parseDouble(df.format(rs.getDouble(44)));//进攻篮板率
    			    p.D_RR=Double.parseDouble(df.format(rs.getDouble(45)));//防守篮板率
    			    p.AR=Double.parseDouble(df.format(rs.getDouble(46)));//助攻率
    			    p.SR=Double.parseDouble(df.format(rs.getDouble(47)));//抢断率
    			    p.BR=Double.parseDouble(df.format(rs.getDouble(48)));//盖帽率
    			    p.TR=Double.parseDouble(df.format(rs.getDouble(49)));//失误率
    			    p.UseRate=Double.parseDouble(df.format(rs.getDouble(50)));//使用率(上场率)
    			    p.OR=Double.parseDouble(df.format(rs.getDouble(51)));//进攻率
    			    p.DR=Double.parseDouble(df.format(rs.getDouble(52)));//防守率
    			    p.WS=Double.parseDouble(df.format(rs.getDouble(53)));//WS
    			    p.O_WS=Double.parseDouble(df.format(rs.getDouble(54)));//进攻WS
    			    p.D_WS=Double.parseDouble(df.format(rs.getDouble(55)));//防守WS
    			    p.PER=Double.parseDouble(df.format(rs.getDouble(56)));//效率
    			    p.Dunk=Double.parseDouble(df.format(rs.getDouble(57)));//扣篮个数
    			    p.TTPO=Double.parseDouble(df.format(rs.getDouble(58)));//2/3+1(并不知道是什么)
    			    p.Blocked=Double.parseDouble(df.format(rs.getDouble(59)));//被冒个数
    			    p.ShootDistance=Double.parseDouble(df.format(rs.getDouble(60)));//投篮距离	    
    			    p.LXFGP=Double.parseDouble(df.format(rs.getDouble(61)*100));//LX表示篮下
    			    p.LXFGZ=Double.parseDouble(df.format(rs.getDouble(62)));
    			    p.LXFG=Double.parseDouble(df.format(rs.getDouble(63)));
    			    p.LXFGRate=Double.parseDouble(df.format(rs.getDouble(64)));//表示篮下投篮在所有投篮中比例，以下类推 
    			    p.JJLFGP=Double.parseDouble(df.format(rs.getDouble(65)*100));//JJ表示近距离
    			    p.JJLFGZ=Double.parseDouble(df.format(rs.getDouble(66)));
    			    p.JJLFG=Double.parseDouble(df.format(rs.getDouble(67)));
    			    p.JJLFGRate=Double.parseDouble(df.format(rs.getDouble(68)));
    			    p.ZJLFGP=Double.parseDouble(df.format(rs.getDouble(69)*100));//ZJL表示中距离
    			    p.ZJLFGZ=Double.parseDouble(df.format(rs.getDouble(70)));
    			    p.ZJLFG=Double.parseDouble(df.format(rs.getDouble(71)));
    			    p.ZJLFGRate=Double.parseDouble(df.format(rs.getDouble(72)));
    			    p.YJLFGP=Double.parseDouble(df.format(rs.getDouble(73)*100));//YJL表示远距离
    			    p.YJLFGZ=Double.parseDouble(df.format(rs.getDouble(74)));
    			    p.YJLFG=Double.parseDouble(df.format(rs.getDouble(75)));
    			    p.YJLFGRate=Double.parseDouble(df.format(rs.getDouble(76)));
    			    p.RealShootRate=Double.parseDouble(df.format(rs.getDouble(77)));//真实命中率
    			    p.S_RR=Double.parseDouble(df.format(rs.getDouble(78)));//投篮效率
    			    p.Htime=Double.parseDouble(df.format(rs.getDouble(79)));
    			    p.HFGP=Double.parseDouble(df.format(rs.getDouble(80)*100));
    			    p.HFGZ=Double.parseDouble(df.format(rs.getDouble(81)));//Z代表命中
    			    p.HFG=Double.parseDouble(df.format(rs.getDouble(82)));
    			    p.HSFGP=Double.parseDouble(df.format(rs.getDouble(83)*100));
    			    p.HSFGZ=Double.parseDouble(df.format(rs.getDouble(84)));
    			    p.HSFG=Double.parseDouble(df.format(rs.getDouble(85)));
    			    p.HFTGP=Double.parseDouble(df.format(rs.getDouble(86)*100));
    			    p.HFTGZ=Double.parseDouble(df.format(rs.getDouble(87)));
    			    p.HFTG=Double.parseDouble(df.format(rs.getDouble(88)));
    			    p.HRebounds=Double.parseDouble(df.format(rs.getDouble(89)));
    			    p.HORebouns=Double.parseDouble(df.format(rs.getDouble(90)));
    			    p.HDRebounds=Double.parseDouble(df.format(rs.getDouble(91)));
    			    p.HAssists=Double.parseDouble(df.format(rs.getDouble(92)));
    			    p.HSteals=Double.parseDouble(df.format(rs.getDouble(93)));
    			    p.HBlocks=Double.parseDouble(df.format(rs.getDouble(94)));
    			    p.HTurnovers=Double.parseDouble(df.format(rs.getDouble(95)));
    			    p.HFeals=Double.parseDouble(df.format(rs.getDouble(96)));
    			    p.HScores=Double.parseDouble(df.format(rs.getDouble(97)));
    			    p.salary=rs.getString(98);//薪水，带单位，所以用String
    			    p.isplayoff=rs.getBoolean(99);//是否是季候赛，是季后赛表示为1，不是为0 
    			    p.name=rs.getString(100);
    			    position = rs.getString(101);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		double q1 = 0.0;
		double q2 = 0.0;
		//     
		
		//得分	命中率	助攻	进攻篮板	失误	犯规	防守篮板	抢断	盖帽
		//1	1/10	2	1.5	-1/2	-1/2	-	-	-
		switch(position){
			case "后卫": 
				q1 = p.getAScores() + 0.1*p.getFGP() + 2*p.getAAssists() - 0.5*p.getAFeals() - 0.5*p.getATurnovers() + 1.5*p.getAORebouns();
				q2 = 0 -0.5*p.getAFeals() - 0.5*p.getATurnovers() + p.getADRebounds() + 2*p.getASteals() + 2*p.getABlocks();
				result = 29.1*q1 + 36.883*q2 -162.157;		
				break;
			case "中锋": 
				q1 = 0.0;
				q2 = 0 -0.5*p.getAFeals() - 0.5*p.getATurnovers() + 3*p.getADRebounds() + p.getASteals() + 2*p.getABlocks();
				result = 48.001*q2 - 47.520;
				break;
			case "前锋": 
				q1 =  1.5*p.getAScores() + 0*p.getFGP() + 2*p.getAAssists() - 0.5*p.getAFeals() - 0.5*p.getATurnovers() + 0*p.getAORebouns();;
				q2 = 0 -1*p.getAFeals() - 1*p.getATurnovers() + 4*p.getADRebounds() + 2*p.getASteals() + 0;
				result = 17.322*q1 + 10.317*q2 +72.324;
				break;
			}
		System.out.println(result + p.getName() + p.getSalary());
		return result;
	}
	
	public ArrayList<PlayerdatainfoVO> getTopTenSalary(String season){
		 ArrayList<PlayerdatainfoVO> result = new ArrayList<PlayerdatainfoVO>();
		 
		 return result;
	}
	
	public ArrayList<Double> getTopTenTestSalary(){
		ArrayList<Double> result =  new ArrayList<Double>();
		return result;
	}
	
}
