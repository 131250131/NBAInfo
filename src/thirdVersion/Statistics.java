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
	String password="";	
	//如果遇到数据库密码的问题，可能是 "",也有可能是 "941211" 试一下就好
	String sql="";
	DecimalFormat    df   = new DecimalFormat("######0.00"); 
	
	
	public static void main(String arg[]){
		Statistics s = new Statistics();
//		s.getTestSalary("785", "13-14");
//		s.getTestSalary("1564", "11-12");
//		s.getTestSalary("695", "11-12");
		double num[][] = new double[3][];
		ArrayList<SalaryVO> result = s.getAllSalaryInfoBySeason("12-13",num);
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
			case AORebounds: datatype = "AORebouns" ;break;
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
				conn.close();
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
				sql = "SELECT * FROM playerdatainfo WHERE id="+"'"+playerID+"' and season="+"'"+season+"'and isplayoff="+"0"+" ;";
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
				conn.close();
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
		System.out.println(result + " " + p.getName() + " "+p.getSalary());
		return result;
	}
	
	public ArrayList<PlayerdatainfoVO> getTopTenSalary(String season){
		 ArrayList<PlayerdatainfoVO> result = new ArrayList<PlayerdatainfoVO>();
		 try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/nbadata?characterEncoding=utf-8", "root", "");
				String sql =  new String();
					sql = "SELECT * FROM playerdatainfo WHERE season="+"'"+season+"'and isplayoff="+"0"+" ORDER BY ;";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					ResultSet rs=pstmt.executeQuery();
					while(rs.next()){
						PlayerdatainfoVO p = new PlayerdatainfoVO();
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
					}
					conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		 return result;
	}
	
	public ArrayList<SalaryVO> getAllSalaryInfoBySeason(String season , double num[][]){
		ArrayList<SalaryVO> result = new ArrayList<SalaryVO>();
		double xy1[][] = new double[2][1000];
		double z1[] =  new double[1000];
		int size1 = 0;
		double a1[] = new double[1000];//回归系数
		double r1[] =  new double[10];//一些数据
		double v1[] = new double[10];//相关系数
		
		double xy2[][] = new double[2][1000];
		double z2[] =  new double[1000];
		int size2 = 0;
		double a2[] = new double[1000];//回归系数
		double r2[] =  new double[10];//一些数据
		double v2[] = new double[10];//相关系数
		
		double xy3[][] = new double[2][1000];
		double z3[] =  new double[1000];
		int size3 = 0;
		double a3[] = new double[1000];//回归系数
		double r3[] =  new double[10];//一些数据
		double v3[] = new double[10];//相关系数
		
		try{
			String position = new String();
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url,user,password);
			String sql =  new String();
				sql = "SELECT * FROM playerdatainfo WHERE season="+"'"+season+"'and isplayoff="+"0"+" ;";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					PlayerdatainfoVO p = new PlayerdatainfoVO();
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
    			    SalaryVO temp = new SalaryVO();
    			    double q1 = 0.0;
    				double q2 = 0.0;
    				double test = 0.0;
    				double real;
    				if(!p.getSalary().equals("")){
        				 real = Double.parseDouble(p.getSalary().split("万")[0]);
    				}else{
    					 real = 0.0 ;
    				}

    				switch(position){
    				case "前锋": 
						q1 =  1*p.getAScores() + 0.1*p.getFGP() + 2*p.getAAssists()  + 1.5*p.getAORebouns()- 0.5*p.getAFeals() - 0.5*p.getATurnovers();
						q2 = 0 -0.5*p.getAFeals() - 0.5*p.getATurnovers() + 1*p.getADRebounds() + 2*p.getASteals() + 2*p.getABlocks();
//						test = 17.322*q1 + 10.317*q2 +72.324;
		   				
						break;
    					case "中锋": 
    						q1 =  2*p.getAScores() + 3*p.getAAssists()  + 4*p.getAORebouns()- 0.5*p.getAFeals() - 0.5*p.getATurnovers();;
    						q2 = 0 -0.5*p.getAFeals() - 0.5*p.getATurnovers() + 3*p.getADRebounds() + p.getASteals() + 2*p.getABlocks();
//    						test = 48.001*q2 - 47.520;
    		   				
    					break;
    					case "后卫": 
    						q1 = 1.5*p.getAScores() + 0*p.getFGP() + 2*p.getAAssists() - 0.5*p.getAFeals() - 0.5*p.getATurnovers();
    						q2 = 0 -1*p.getAFeals() - 1*p.getATurnovers() + 4*p.getADRebounds() + 2*p.getASteals() ;
//    						test = 29.1*q1 + 36.883*q2 -162.157;
    	    				
    					break;
    				}
    				temp.setPlayerEnglishName(p.getName());
    				temp.setPlayerID(p.getId());
    				temp.setTeamName(p.getTeamname());
    				temp.setRealSalary(Double.parseDouble(df.format(real)));
    				temp.setQ1(Double.parseDouble(df.format(q1)));
    				temp.setQ2(Double.parseDouble(df.format(q2)));
    				
    				switch(position){
    				case "前锋":
    					if(temp.getRealSalary()<=1500){
	    					xy1[0][size1] = temp.getQ1();
	    					xy1[1][size1] = temp.getQ2();
	    					z1[size1] = temp.getRealSalary();
	    					size1++;
	    				}break;
    				case "中锋":
    					if(temp.getRealSalary()<=1500){
        					xy2[0][size2] = temp.getQ1();
        					xy2[1][size2] = temp.getQ2();
        					z2[size2] = temp.getRealSalary();
        					size2++;
        				}break;
    				case "后卫":
    					if(temp.getRealSalary()<=1500){
	    					xy3[0][size3] = temp.getQ1();
	    					xy3[1][size3] = temp.getQ2();
	    					z3[size3] = temp.getRealSalary();
	    					size3++;
	    				}break;
    				}
    				
    				
//    				if(temp.getRealSalary()<=1300&&temp.getRealSalary()>=50){
//    					xy1[0][size1] = temp.getQ1();
//    					xy1[1][size1] = temp.getQ2();
//    					z1[size1] = temp.getRealSalary();
//    					size1++;
//    				}
//    				temp.setTestSalaty(Double.parseDouble(df.format(test)));
    				temp.setPosition(position);
//    				temp.setDif(Double.parseDouble(df.format(temp.getRealSalary()-temp.getTestSalaty())));
//    				double per = (real==0)?0:(test/real);
//    				temp.setPer(Double.parseDouble(df.format(per)));
    			    result.add(temp);
//    			    System.out.println(temp.getPlayerEnglishName()+" "+temp.getPlayerID()+" q1:"+temp.getQ1()+
//    			    		" q2"+temp.getQ2()+" real"+temp.getRealSalary()+" test"+temp.getTestSalaty()+" per"+ temp.getPer());
				}
				System.out.println("size1 "+size1);
				System.out.println("size2 "+size2);
				System.out.println("size3 "+size3);

				this.sqt2(xy1, z1, 2, size1, a1, r1, v1);
				this.sqt2(xy2, z2, 2, size2, a2, r2, v2);
				this.sqt2(xy3, z3, 2, size3, a3, r3, v3);
				System.out.println("相关系数  "+v1[0]+" "+v1[1]+" 偏差平方和"+r1[0]+" 平均标准差"+r1[1]+" 复相关系数"+r1[2]+" 回归平方和"+r1[3] +" 回归系数"+ a1[0]+" "+a1[1]+" "+a1[2]);
				System.out.println("相关系数  "+v2[0]+" "+v2[1]+" 偏差平方和"+r2[0]+" 平均标准差"+r2[1]+" 复相关系数"+r2[2]+" 回归平方和"+r2[3] +" 回归系数"+ a2[0]+" "+a2[1]+" "+a2[2]);
				System.out.println("相关系数  "+v3[0]+" "+v3[1]+" 偏差平方和"+r3[0]+" 平均标准差"+r3[1]+" 复相关系数"+r3[2]+" 回归平方和"+r3[3] +" 回归系数"+ a3[0]+" "+a3[1]+" "+a3[2]);
				System.out.println("运过");
				double test =0;
				for(SalaryVO temp :result){
	   				switch(temp.getPosition()){
    				case "前锋":
    					test = a1[0]*temp.getQ1() + a1[1]*temp.getQ2() + a1[2];
    					break;
    				case "中锋":
    					test = a2[0]*temp.getQ1() + a2[1]*temp.getQ2() + a2[2];
    					break;
    				case "后卫":
    					test = a3[0]*temp.getQ1() + a3[1]*temp.getQ2() + a3[2];
    					break;
    				}
	   				temp.setTestSalaty(Double.parseDouble(df.format(test)));
	   				temp.setDif(Double.parseDouble(df.format(temp.getRealSalary()-temp.getTestSalaty())));
	   				double per = (temp.getRealSalary()==0)?0:(test/temp.getRealSalary());
	   				temp.setPer(Double.parseDouble(df.format(per)));
	   			 System.out.println(temp.getPlayerEnglishName()+" "+temp.getPlayerID()+" q1:"+temp.getQ1()+
 			    		" q2:"+temp.getQ2()+" real:"+temp.getRealSalary()+" test:"+temp.getTestSalaty()+" per"+ temp.getPer());
				}
				conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/** 
	  * 多元线性回归分析   *  
	  * @param x[m][n] 
	  *            每一列存放m个自变量的观察值  
	 * @param y[n] 
	  *            存放随即变量y的n个观察值   
	* @param m 
	  *            自变量的个数   
	* @param n 
	  *            观察数据的组数   
	* @param a 
	  *            返回回归系数a0,...,am   * 
	@param dt[4] 
	 
	  *            dt[0]偏差平方和q,dt[1] 平均标准偏差s dt[2]返回复相关系数r 
	  *dt[3]返回回归平方和u  
	  * * @param v[m]   *            返回m个自变量的偏相关系数   */
	
	public  void sqt2(double[][] x, double[] y, int m, int n, double[] a,
			double[] dt, double[] v) {
		int i, j, k, mm;
		double q, e, u, p, yy, s, r, pp;
		double[] b = new double[(m + 1) * (m + 1)];
		mm = m + 1;
		b[mm * mm - 1] = n;
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++)
				p = p + x[j][i];
			b[m * mm + j] = p;
			b[j * mm + m] = p;
		}
		for (i = 0; i <= m - 1; i++)
			for (j = i; j <= m - 1; j++) {
				p = 0.0;
				for (k = 0; k <= n - 1; k++)
					p = p + x[i][k] * x[j][k];
				b[j * mm + i] = p;
				b[i * mm + j] = p;
			}
		a[m] = 0.0;
		for (i = 0; i <= n - 1; i++)
			a[m] = a[m] + y[i];
		for (i = 0; i <= m - 1; i++) {
			a[i] = 0.0;
			for (j = 0; j <= n - 1; j++)
				a[i] = a[i] + x[i][j] * y[j];
		}
		chlk(b, mm, 1, a);
		yy = 0.0;
		for (i = 0; i <= n - 1; i++)
			yy = yy + y[i] / n;
		q = 0.0;
		e = 0.0;
		u = 0.0;
		for (i = 0; i <= n - 1; i++) {
			p = a[m];
			for (j = 0; j <= m - 1; j++)
				p = p + a[j] * x[j][i];
			q = q + (y[i] - p) * (y[i] - p);
			e = e + (y[i] - yy) * (y[i] - yy);
			u = u + (yy - p) * (yy - p);
		}
		s = Math.sqrt(q / n);
		r = Math.sqrt(1.0 - q / e);
		for (j = 0; j <= m - 1; j++) {
			p = 0.0;
			for (i = 0; i <= n - 1; i++) {
				pp = a[m];
				for (k = 0; k <= m - 1; k++)
					if (k != j)
						pp = pp + a[k] * x[k][i];
				p = p + (y[i] - pp) * (y[i] - pp);
			}
			v[j] = Math.sqrt(1.0 - q / p);
		}
		dt[0] = q;
		dt[1] = s;
		dt[2] = r;
		dt[3] = u;
	}
	
	private int chlk(double[] a, int n, int m, double[] d) {
		int i, j, k, u, v;
		if ((a[0] + 1.0 == 1.0) || (a[0] < 0.0)) {
			System.out.println("fail\n");
			return (-2);
		}
		a[0] = Math.sqrt(a[0]);
		for (j = 1; j <= n - 1; j++)
			a[j] = a[j] / a[0];
		for (i = 1; i <= n - 1; i++) {
			u = i * n + i;
			for (j = 1; j <= i; j++) {
				v = (j - 1) * n + i;
				a[u] = a[u] - a[v] * a[v];
			}
			if ((a[u] + 1.0 == 1.0) || (a[u] < 0.0)) {
				System.out.println("fail\n");
				return (-2);
			}
			a[u] = Math.sqrt(a[u]);
			if (i != (n - 1)) {
				for (j = i + 1; j <= n - 1; j++) {
					v = i * n + j;
					for (k = 1; k <= i; k++)
						a[v] = a[v] - a[(k - 1) * n + i] * a[(k - 1) * n + j];
					a[v] = a[v] / a[u];
				}
			}
		}
		for (j = 0; j <= m - 1; j++) {
			d[j] = d[j] / a[0];
			for (i = 1; i <= n - 1; i++) {
				u = i * n + i;
				v = i * m + j;
				for (k = 1; k <= i; k++)
					d[v] = d[v] - a[(k - 1) * n + i] * d[(k - 1) * m + j];
				d[v] = d[v] / a[u];
			}
		}
		for (j = 0; j <= m - 1; j++) {
			u = (n - 1) * m + j;
			d[u] = d[u] / a[n * n - 1];
			for (k = n - 1; k >= 1; k--) {
				u = (k - 1) * m + j;
				for (i = k; i <= n - 1; i++) {
					v = (k - 1) * n + i;
					d[u] = d[u] - a[v] * d[i * m + j];
				}
				v = (k - 1) * n + k - 1;
				d[u] = d[u] / a[v];
			}
		}
		return (2);
	}
	
}
