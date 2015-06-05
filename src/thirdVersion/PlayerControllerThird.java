package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import logic.PlayerController;
import vo.PlayerVO;
import Utibility.DataType;

public class PlayerControllerThird {
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
	ArrayList<PlayerBasicInfoVO> inidata=new ArrayList<PlayerBasicInfoVO>();
	DecimalFormat    df   = new DecimalFormat("######0.00"); 
	/*
	 * 构造函数
	 */
	public PlayerControllerThird(){
		initial();
	}
	/*
	 * 初始化
	 */
	public void initial(){
    	try{
     		sql="SELECT * FROM playerbasicinfo" ;
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection conn =DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=conn.prepareStatement(sql);
        		ResultSet rs=pstmt.executeQuery();
        		while(rs.next()){
        			PlayerBasicInfoVO p=new PlayerBasicInfoVO();
        			p.setPlayerID(rs.getString(1));//球员编号
        			p.setPlayerName(rs.getString(2));//球员姓名
        			p.setPlayerPosition(rs.getString(3));//球员位置
        			p.setPlayerHeight(rs.getString(4));//球员身高
        			p.setPlayerWeight(rs.getString(5));//球员体重
        			p.setPlayerBirthDay(rs.getString(6));//球员生日
        			p.setPlayerBirthPlace(rs.getString(7));//球员出生地
        			p.setPlayerHighSchool(rs.getString(8));//球员毕业高中
        			p.setPlayerUniversity(rs.getString(9));//球员毕业大学
        			p.setSimilarPlayerID(rs.getString(10));//相似球员编号
        			p.setAtime(Double.parseDouble(df.format(rs.getDouble(11))));//球员场均出场时间
        			p.setFGP(Double.parseDouble(df.format(rs.getDouble(12)*100)));//球员投篮命中率
        			p.setAFGZ(Double.parseDouble(df.format(rs.getDouble(13))));//球员场均投篮命中数
        			p.setAFG(Double.parseDouble(df.format(rs.getDouble(14))));//球员场均投篮出手数
        			p.setSFGP(Double.parseDouble(df.format(rs.getDouble(15)*100)));//球员三分命中率
        			p.setASFGZ(Double.parseDouble(df.format(rs.getDouble(16))));//球员场均三分命中数
        			p.setASFG(Double.parseDouble(df.format(rs.getDouble(17))));//球员场均三分出手数
        			p.setFTGP(Double.parseDouble(df.format(rs.getDouble(18)*100)));//球员罚球命中率
        			p.setAFTGZ(Double.parseDouble(df.format(rs.getDouble(19))));//球员场均罚球命中数
        			p.setAFTG(Double.parseDouble(df.format(rs.getDouble(20))));//球员场均罚球出手数
        			p.setARebounds(Double.parseDouble(df.format(rs.getDouble(21))));//球员场均篮板数
        			p.setAORebouns(Double.parseDouble(df.format(rs.getDouble(22))));//球员场均前场篮板数
        			p.setADRebounds(Double.parseDouble(df.format(rs.getDouble(23))));//球员场均后场篮板数
        			p.setAAssists(Double.parseDouble(df.format(rs.getDouble(24))));//球员场均助攻数
        			p.setASteals(Double.parseDouble(df.format(rs.getDouble(25))));//球员场均抢断数
        			p.setABlocks(Double.parseDouble(df.format(rs.getDouble(26))));//球员场均盖帽数
        			p.setATurnovers(Double.parseDouble(df.format(rs.getDouble(27))));//球员场均失误数
        			p.setAFeals(Double.parseDouble(df.format(rs.getDouble(28))));//球员场均犯规数
        			p.setAScores(Double.parseDouble(df.format(rs.getDouble(29))));//球员场均得分
        			if(p.getFGP()<=100&&p.getSFGP()<100&&p.getFTGP()<100)
        			     inidata.add(p);
        		}
        		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
	}
	/*
	 * 常规赛特定数据
	 */
    public ArrayList<PSpecificdata>  getnormalplayerdata(String pid,DataType t){
    	   ArrayList<PSpecificdata> result=new ArrayList<PSpecificdata>();
    	   ArrayList<String> seasons=new ArrayList<String>();
    	   try{
    		sql="SELECT * FROM playerdatainfo WHERE id="+pid+" AND isplayoff=0";
       		Class.forName("com.mysql.jdbc.Driver");
       		Connection conn =DriverManager.getConnection(url, user, password);
       		PreparedStatement pstmt=conn.prepareStatement(sql);
       		ResultSet rs=pstmt.executeQuery();
       		
       	    if(t==DataType.salary){
       	    	while(rs.next()){
       	    	PSpecificdata p=new PSpecificdata();
            	String s=rs.getString(t.toString());
            	if(s.equals("")){
            		p.setData(0.0);
            	}
            	else{
            		System.out.println(s.substring(0,s.length()-3));
            		p.setData(Double.parseDouble(s.substring(0,s.length()-3)));
            	}
            	
            	String season=rs.getString("season");
            	String team=rs.getString("teamname");
            	double attendmatches=rs.getDouble("attendmatches");
            	p.setSeason(season);
            	p.setTeam(team);
            	p.setAttendmatches(attendmatches);
            	p.setIsuseful(true);
            	
            	if(!seasons.contains(season)){
            		seasons.add(season);
            		result.add(p);
            	}
            	
            	else{
            	   if(team.equals("总计")){
            		   for(PSpecificdata pp:result){
            			   if(pp.getSeason().equals(season)){
            				   if(!pp.getTeam().equals("总计")){
            					   pp.setIsuseful(false);
            				   }
            				   else{
            					   if(pp.getAttendmatches()<attendmatches){
            						   pp.setIsuseful(false);  
            					   }
            					   else{
            						   p.setIsuseful(false);
            					   }
            				   }
            			   }
            		   }
            		   result.add(p);
            	   }
            	  
            	}
                
            	
       	    	}
       	    }
       	    
       	    else{
       		while(rs.next()){
       		   PSpecificdata p=new PSpecificdata();
       		   Double s=rs.getDouble(t.toString());
       		   if(s.equals("-1"))
       			   p.setData(0.0);
       		   else
       			   p.setData(Double.parseDouble(df.format(s)));
       		   
       		String season=rs.getString("season");
        	String team=rs.getString("teamname");
        	double attendmatches=rs.getDouble("attendmatches");
        	p.setSeason(season);
        	p.setTeam(team);
        	p.setAttendmatches(attendmatches);
        	p.setIsuseful(true);
        	
        	if(!seasons.contains(season)){
        		seasons.add(season);
        		result.add(p);
        	}
        	
        	else{
        	   if(team.equals("总计")){
        		   for(PSpecificdata pp:result){
        			   if(pp.getSeason().equals(season)){
        				   if(!pp.getTeam().equals("总计")){
        					   pp.setIsuseful(false);
        				   }
        				   else{
        					   if(pp.getAttendmatches()<attendmatches){
        						   pp.setIsuseful(false);  
        					   }
        					   else{
        						   p.setIsuseful(false);
        					   }
        				   }
        			   }
        		   }
        		   result.add(p);
        	   }
        	  
        	}

             }
       	    }
       		System.out.println("cheng gong");
       		conn.close();
       		
       	}catch(Exception e){
       		System.out.println(e);
       	}
    	   return result;
       }
    
   /*
    * 季后赛特定数据
    */
    public ArrayList<PSpecificdata>  getplayoffplayerdata(String pid,DataType t){
 	   ArrayList<PSpecificdata> result=new ArrayList<PSpecificdata>();
 	   ArrayList<String> seasons=new ArrayList<String>();
 	   try{
 		sql="SELECT * FROM playerdatainfo WHERE id="+pid+" AND isplayoff=1";
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn =DriverManager.getConnection(url, user, password);
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		ResultSet rs=pstmt.executeQuery();
    	    if(t==DataType.salary){
    	    	while(rs.next()){
    	    PSpecificdata p=new PSpecificdata();
         	String s=rs.getString(t.toString());
         	if(s.equals("")){
         		p.setData(0.0);
         	}
         	else{
         		//System.out.println(s.substring(0,s.length()-3));
         		p.setData(Double.parseDouble(s.substring(0,s.length()-3)));
         	}
         	
        	String season=rs.getString("season");
        	String team=rs.getString("teamname");
        	double attendmatches=rs.getDouble("attendmatches");
        	p.setSeason(season);
        	p.setTeam(team);
        	p.setAttendmatches(attendmatches);
        	p.setIsuseful(true);
        	
        	if(!seasons.contains(season)){
        		seasons.add(season);
        		result.add(p);
        	}
        	
        	else{
        	   if(team.equals("总计")){
        		   for(PSpecificdata pp:result){
        			   if(pp.getSeason().equals(season)){
        				   if(!pp.getTeam().equals("总计")){
        					   pp.setIsuseful(false);
        				   }
        				   else{
        					   if(pp.getAttendmatches()<attendmatches){
        						   pp.setIsuseful(false);  
        					   }
        					   else{
        						   p.setIsuseful(false);
        					   }
        				   }
        			   }
        		   }
        		   result.add(p);
        	   }
        	  
        	}
    	    	}
    	    	
    	    }
    	    
    	    else{
    		while(rs.next()){
    		   PSpecificdata p=new PSpecificdata();
    		   Double s=rs.getDouble(t.toString());
    		   if(s.equals("-1"))
    			   p.setData(0.0);
    		   else
    			   p.setData(Double.parseDouble(df.format(s)));
    			String season=rs.getString("season");
            	String team=rs.getString("teamname");
            	double attendmatches=rs.getDouble("attendmatches");
            	p.setSeason(season);
            	p.setTeam(team);
            	p.setAttendmatches(attendmatches);
            	p.setIsuseful(true);
            	
            	if(!seasons.contains(season)){
            		seasons.add(season);
            		result.add(p);
            	}
            	
            	else{
            	   if(team.equals("总计")){
            		   for(PSpecificdata pp:result){
            			   if(pp.getSeason().equals(season)){
            				   if(!pp.getTeam().equals("总计")){
            					   pp.setIsuseful(false);
            				   }
            				   else{
            					   if(pp.getAttendmatches()<attendmatches){
            						   pp.setIsuseful(false);  
            					   }
            					   else{
            						   p.setIsuseful(false);
            					   }
            				   }
            			   }
            		   }
            		   result.add(p);
            	   }
            	  
            	}
          }
    	    }
    		System.out.println("cheng gong");
    		conn.close();
    		
    	}catch(Exception e){
    		System.out.println(e);
    	}
 	   return result;
    }
    /*
     * 得到界面初始化的信息
     */
    public ArrayList<PlayerBasicInfoVO> VOinitial(){
    	 return inidata;
    }
    /*
     * 根据首字母筛选
     */
    public ArrayList<PlayerBasicInfoVO> getPlayersbyChar(char temp){
    	ArrayList<PlayerBasicInfoVO> result=new ArrayList<PlayerBasicInfoVO>();
		for(PlayerBasicInfoVO vo : inidata){
			char[] str = vo.getPlayerName().toCharArray();
			if(str[0]==temp){
				result.add(vo);
			}
		}
		return result;
	}
/*
 * 姓名得到基本信息
 */
    public PlayerBasicInfoVO getPlayerbyname(String name){
    	PlayerBasicInfoVO p=new PlayerBasicInfoVO();
		for(PlayerBasicInfoVO vo : inidata){
		   if(vo.getPlayerName().equals(name)){
			   return vo;
		   }
		}
		return p;
		
	}
    /*
     * 根据DataType和赛季得到热点球员,ipl代表是不是季后赛
     */
    public ArrayList<PlayerdatainfoVO> getSeasonHotPlayers(String Season,DataType type,boolean ipl){
    	ArrayList<PlayerdatainfoVO> result=new ArrayList<PlayerdatainfoVO>();
    	try{
     		sql="SELECT * FROM playerdatainfo WHERE season='"+Season+"'"+"AND isplayoff="+ipl+" ORDER BY "+type+" DESC" ;
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection conn =DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=conn.prepareStatement(sql);
        		ResultSet rs=pstmt.executeQuery();
        		int count=1;
        		while(rs.next()){
        			PlayerdatainfoVO p=new PlayerdatainfoVO();
        			if(count<=50){
        			
        				p.id=rs.getString(1);//球员编号 
        			    p.season=rs.getString(2);//赛季
        			    p.teamname=rs.getString(3);//teamname为总计时，表示该球员一个赛季在两个球队打过
        			    p.attendmatches=Double.parseDouble(df.format(rs.getDouble(4)));
        			    p.First=Double.parseDouble(df.format(rs.getDouble(5)));
        			    p.Atime=Double.parseDouble(df.format(rs.getDouble(6)));
        			    p.FGP=Double.parseDouble(df.format(rs.getDouble(7)));
        			    p.AFGZ=Double.parseDouble(df.format(rs.getDouble(8)));//Z代表命中
        			    p.AFG=Double.parseDouble(df.format(rs.getDouble(9)));
        			    p.SFGP=Double.parseDouble(df.format(rs.getDouble(10)));
        			    p.ASFGZ=Double.parseDouble(df.format(rs.getDouble(11)));
        			    p.ASFG=Double.parseDouble(df.format(rs.getDouble(12)));
        			    p.FTGP=Double.parseDouble(df.format(rs.getDouble(13)));
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
        			    p.LXFGP=Double.parseDouble(df.format(rs.getDouble(61)));//LX表示篮下
        			    p.LXFGZ=Double.parseDouble(df.format(rs.getDouble(62)));
        			    p.LXFG=Double.parseDouble(df.format(rs.getDouble(63)));
        			    p.LXFGRate=Double.parseDouble(df.format(rs.getDouble(64)));//表示篮下投篮在所有投篮中比例，以下类推 
        			    p.JJLFGP=Double.parseDouble(df.format(rs.getDouble(65)));//JJ表示近距离
        			    p.JJLFGZ=Double.parseDouble(df.format(rs.getDouble(66)));
        			    p.JJLFG=Double.parseDouble(df.format(rs.getDouble(67)));
        			    p.JJLFGRate=Double.parseDouble(df.format(rs.getDouble(68)));
        			    p.ZJLFGP=Double.parseDouble(df.format(rs.getDouble(69)));//ZJL表示中距离
        			    p.ZJLFGZ=Double.parseDouble(df.format(rs.getDouble(70)));
        			    p.ZJLFG=Double.parseDouble(df.format(rs.getDouble(71)));
        			    p.ZJLFGRate=Double.parseDouble(df.format(rs.getDouble(72)));
        			    p.YJLFGP=Double.parseDouble(df.format(rs.getDouble(73)));//YJL表示远距离
        			    p.YJLFGZ=Double.parseDouble(df.format(rs.getDouble(74)));
        			    p.YJLFG=Double.parseDouble(df.format(rs.getDouble(75)));
        			    p.YJLFGRate=Double.parseDouble(df.format(rs.getDouble(76)));
        			    p.RealShootRate=Double.parseDouble(df.format(rs.getDouble(77)));//真实命中率
        			    p.S_RR=Double.parseDouble(df.format(rs.getDouble(78)));//投篮效率
        			    p.Htime=Double.parseDouble(df.format(rs.getDouble(79)));
        			    p.HFGP=Double.parseDouble(df.format(rs.getDouble(80)));
        			    p.HFGZ=Double.parseDouble(df.format(rs.getDouble(81)));//Z代表命中
        			    p.HFG=Double.parseDouble(df.format(rs.getDouble(82)));
        			    p.HSFGP=Double.parseDouble(df.format(rs.getDouble(83)));
        			    p.HSFGZ=Double.parseDouble(df.format(rs.getDouble(84)));
        			    p.HSFG=Double.parseDouble(df.format(rs.getDouble(85)));
        			    p.HFTGP=Double.parseDouble(df.format(rs.getDouble(86)));
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
        			    result.add(p);
        				count++;
        			}
        			else
        				break;
        		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return result;
    }
    /*
     * 根据DataType和赛季得到热点球员,ipl代表是不是季后赛
     */
    public ArrayList<PlayerdatainfoVO> getSeasonKingPlayers(String Season,DataType type,boolean ipl){
    	ArrayList<PlayerdatainfoVO> result=new ArrayList<PlayerdatainfoVO>();
    	try{
     		sql="SELECT * FROM playerdatainfo WHERE season='"+Season+"'"+"AND isplayoff="+ipl+" ORDER BY "+type+" DESC" ;
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection conn =DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=conn.prepareStatement(sql);
        		ResultSet rs=pstmt.executeQuery();
        		int count=1;
        		while(rs.next()){
        			PlayerdatainfoVO p=new PlayerdatainfoVO();
        			if(count<=5){
        			
        				p.id=rs.getString(1);//球员编号 
        			    p.season=rs.getString(2);//赛季
        			    p.teamname=rs.getString(3);//teamname为总计时，表示该球员一个赛季在两个球队打过
        			    p.attendmatches=Double.parseDouble(df.format(rs.getDouble(4)));
        			    p.First=Double.parseDouble(df.format(rs.getDouble(5)));
        			    p.Atime=Double.parseDouble(df.format(rs.getDouble(6)));
        			    p.FGP=Double.parseDouble(df.format(rs.getDouble(7)));
        			    p.AFGZ=Double.parseDouble(df.format(rs.getDouble(8)));//Z代表命中
        			    p.AFG=Double.parseDouble(df.format(rs.getDouble(9)));
        			    p.SFGP=Double.parseDouble(df.format(rs.getDouble(10)));
        			    p.ASFGZ=Double.parseDouble(df.format(rs.getDouble(11)));
        			    p.ASFG=Double.parseDouble(df.format(rs.getDouble(12)));
        			    p.FTGP=Double.parseDouble(df.format(rs.getDouble(13)));
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
        			    p.LXFGP=Double.parseDouble(df.format(rs.getDouble(61)));//LX表示篮下
        			    p.LXFGZ=Double.parseDouble(df.format(rs.getDouble(62)));
        			    p.LXFG=Double.parseDouble(df.format(rs.getDouble(63)));
        			    p.LXFGRate=Double.parseDouble(df.format(rs.getDouble(64)));//表示篮下投篮在所有投篮中比例，以下类推 
        			    p.JJLFGP=Double.parseDouble(df.format(rs.getDouble(65)));//JJ表示近距离
        			    p.JJLFGZ=Double.parseDouble(df.format(rs.getDouble(66)));
        			    p.JJLFG=Double.parseDouble(df.format(rs.getDouble(67)));
        			    p.JJLFGRate=Double.parseDouble(df.format(rs.getDouble(68)));
        			    p.ZJLFGP=Double.parseDouble(df.format(rs.getDouble(69)));//ZJL表示中距离
        			    p.ZJLFGZ=Double.parseDouble(df.format(rs.getDouble(70)));
        			    p.ZJLFG=Double.parseDouble(df.format(rs.getDouble(71)));
        			    p.ZJLFGRate=Double.parseDouble(df.format(rs.getDouble(72)));
        			    p.YJLFGP=Double.parseDouble(df.format(rs.getDouble(73)));//YJL表示远距离
        			    p.YJLFGZ=Double.parseDouble(df.format(rs.getDouble(74)));
        			    p.YJLFG=Double.parseDouble(df.format(rs.getDouble(75)));
        			    p.YJLFGRate=Double.parseDouble(df.format(rs.getDouble(76)));
        			    p.RealShootRate=Double.parseDouble(df.format(rs.getDouble(77)));//真实命中率
        			    p.S_RR=Double.parseDouble(df.format(rs.getDouble(78)));//投篮效率
        			    p.Htime=Double.parseDouble(df.format(rs.getDouble(79)));
        			    p.HFGP=Double.parseDouble(df.format(rs.getDouble(80)));
        			    p.HFGZ=Double.parseDouble(df.format(rs.getDouble(81)));//Z代表命中
        			    p.HFG=Double.parseDouble(df.format(rs.getDouble(82)));
        			    p.HSFGP=Double.parseDouble(df.format(rs.getDouble(83)));
        			    p.HSFGZ=Double.parseDouble(df.format(rs.getDouble(84)));
        			    p.HSFG=Double.parseDouble(df.format(rs.getDouble(85)));
        			    p.HFTGP=Double.parseDouble(df.format(rs.getDouble(86)));
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
        			    result.add(p);
        				count++;
        			}
        			else
        				break;
        		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return result;
    }
    /*
     * 根据球队和赛季得到球员
     */
    public ArrayList<PlayerdatainfoVO> getplayerbyteam(String tname,String Season){
    	ArrayList<PlayerdatainfoVO> result=new ArrayList<PlayerdatainfoVO>();
    	ArrayList<String> pnames=new ArrayList<String>();
    	try{
     		sql="SELECT * FROM playerdatainfo WHERE season='"+Season+"'"+"AND teamname="+"'"+tname+"'" ;
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection conn =DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=conn.prepareStatement(sql);
        		ResultSet rs=pstmt.executeQuery();
        		while(rs.next()){
        			PlayerdatainfoVO p=new PlayerdatainfoVO();
        			p.id=rs.getString(1);//球员编号 
    			    p.season=rs.getString(2);//赛季
    			    p.teamname=rs.getString(3);//teamname为总计时，表示该球员一个赛季在两个球队打过
    			    p.attendmatches=Double.parseDouble(df.format(rs.getDouble(4)));
    			    p.First=Double.parseDouble(df.format(rs.getDouble(5)));
    			    p.Atime=Double.parseDouble(df.format(rs.getDouble(6)));
    			    p.FGP=Double.parseDouble(df.format(rs.getDouble(7)));
    			    p.AFGZ=Double.parseDouble(df.format(rs.getDouble(8)));//Z代表命中
    			    p.AFG=Double.parseDouble(df.format(rs.getDouble(9)));
    			    p.SFGP=Double.parseDouble(df.format(rs.getDouble(10)));
    			    p.ASFGZ=Double.parseDouble(df.format(rs.getDouble(11)));
    			    p.ASFG=Double.parseDouble(df.format(rs.getDouble(12)));
    			    p.FTGP=Double.parseDouble(df.format(rs.getDouble(13)));
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
    			    p.LXFGP=Double.parseDouble(df.format(rs.getDouble(61)));//LX表示篮下
    			    p.LXFGZ=Double.parseDouble(df.format(rs.getDouble(62)));
    			    p.LXFG=Double.parseDouble(df.format(rs.getDouble(63)));
    			    p.LXFGRate=Double.parseDouble(df.format(rs.getDouble(64)));//表示篮下投篮在所有投篮中比例，以下类推 
    			    p.JJLFGP=Double.parseDouble(df.format(rs.getDouble(65)));//JJ表示近距离
    			    p.JJLFGZ=Double.parseDouble(df.format(rs.getDouble(66)));
    			    p.JJLFG=Double.parseDouble(df.format(rs.getDouble(67)));
    			    p.JJLFGRate=Double.parseDouble(df.format(rs.getDouble(68)));
    			    p.ZJLFGP=Double.parseDouble(df.format(rs.getDouble(69)));//ZJL表示中距离
    			    p.ZJLFGZ=Double.parseDouble(df.format(rs.getDouble(70)));
    			    p.ZJLFG=Double.parseDouble(df.format(rs.getDouble(71)));
    			    p.ZJLFGRate=Double.parseDouble(df.format(rs.getDouble(72)));
    			    p.YJLFGP=Double.parseDouble(df.format(rs.getDouble(73)));//YJL表示远距离
    			    p.YJLFGZ=Double.parseDouble(df.format(rs.getDouble(74)));
    			    p.YJLFG=Double.parseDouble(df.format(rs.getDouble(75)));
    			    p.YJLFGRate=Double.parseDouble(df.format(rs.getDouble(76)));
    			    p.RealShootRate=Double.parseDouble(df.format(rs.getDouble(77)));//真实命中率
    			    p.S_RR=Double.parseDouble(df.format(rs.getDouble(78)));//投篮效率
    			    p.Htime=Double.parseDouble(df.format(rs.getDouble(79)));
    			    p.HFGP=Double.parseDouble(df.format(rs.getDouble(80)));
    			    p.HFGZ=Double.parseDouble(df.format(rs.getDouble(81)));//Z代表命中
    			    p.HFG=Double.parseDouble(df.format(rs.getDouble(82)));
    			    p.HSFGP=Double.parseDouble(df.format(rs.getDouble(83)));
    			    p.HSFGZ=Double.parseDouble(df.format(rs.getDouble(84)));
    			    p.HSFG=Double.parseDouble(df.format(rs.getDouble(85)));
    			    p.HFTGP=Double.parseDouble(df.format(rs.getDouble(86)));
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
    			    result.add(p);
        		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return result;
    }
       public static void main(String args[]){
    	   PlayerControllerThird p=new PlayerControllerThird();   
    	   ArrayList<PlayerdatainfoVO> pr=p.getplayerbyteam("金州勇士", "13-14");
    	   for(PlayerdatainfoVO l:pr){
    		   System.out.println(l.getName());
    	   }
//    	   ArrayList<PlayerdatainfoVO> pr=new ArrayList<PlayerdatainfoVO>();
//    	   pr=p.getSeasonHotPlayers("13-14", DataType.FTGP,false);
//    	   int i=0;
//    	   for(PlayerdatainfoVO l:pr){
//    		   i++;
//    		   System.out.println(i+" "+l.getName()+" "+l.getFTGP());
//    	   }
    	  // System.out.println(p.VOinitial().size());
//    	   for(PlayerBasicInfoVO pb:p.VOinitial()){
//    		   System.out.println(pb.getFGP());
//    		   System.out.println(pb.getSFGP());
//    		   System.out.println(pb.getFTGP());
//    	   }
//    	   ArrayList<PSpecificdata> l=p.getnormalplayerdata("1001", DataType.AAssists);
//    	   for(PSpecificdata k:l){
//    		   System.out.println(k.getData());
//    	   }
//    	   PlayerBasicInfoVO ppp=p.getPlayerbyname("Aaron Brooks");
//    	   System.out.println(ppp.getAAssists());
//    	   for(PlayerBasicInfoVO lm:l){
//    		 if(lm.getPlayerName().equals("Aaron Brooks")){
//    			 System.out.println(lm.getAAssists());
//    		 }
//    	   }
    	  
    	   
       }
      
}