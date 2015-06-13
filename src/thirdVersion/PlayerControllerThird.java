package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.IFLE;

import logic.PlayerController;
import thirdservice.playerControllerThirdService;
import vo.PlayerVO;
import Utibility.DataType;

public class PlayerControllerThird implements playerControllerThirdService{
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
        			p.setEnglishName(rs.getString(2));//球员姓名
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
        			p.setChinesename(rs.getString(30));
        			if(p.getFGP()>=100){
        				p.setFGP(p.getFGP()/100);
        			}
        			if(p.getSFGP()>=100){
        				p.setFGP(p.getSFGP()/100);
        			}
        			if(p.getFTGP()>=100){
        				p.setFGP(p.getFTGP()/100);
        			}
        			     inidata.add(p);
        		}
        		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
	}
	/*
	 * 根据球员id得到球员基本信息
	 */
	public PlayerBasicInfoVO getbasicinfo(String pid){
		   PlayerBasicInfoVO result=new PlayerBasicInfoVO();
		   for(PlayerBasicInfoVO p:inidata){
			   if(p.getPlayerID().equals(pid)){
				   return p;
			   }
		   }
		   return result;
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
       		else{
 			   if(t==DataType.FGP||t==DataType.SFGP||t==DataType.FTGP||t==DataType.JJLFGP||t==DataType.LXFGP||t==DataType.ZJLFGP||t==DataType.YJLFGP||t==DataType.HFGP||t==DataType.HSFGP||t==DataType.HFTGP){
 				   p.setData(Double.parseDouble(df.format(s*100)));
 			   }
 			   else{
 			   p.setData(Double.parseDouble(df.format(s)));
 			   }
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
    		   else{
    			   if(t==DataType.FGP||t==DataType.SFGP||t==DataType.FTGP||t==DataType.JJLFGP||t==DataType.LXFGP||t==DataType.ZJLFGP||t==DataType.YJLFGP||t==DataType.HFGP||t==DataType.HSFGP||t==DataType.HFTGP){
    				   p.setData(Double.parseDouble(df.format(s*100)));
    			   }
    			   else{
    			   p.setData(Double.parseDouble(df.format(s)));
    			   }
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
			char[] str = vo.getEnglishName().toCharArray();
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
		   if(vo.getEnglishName().equals(name)){
			   return vo;
		   }
		}
		return p;
		
	}
    
    public String getEnglishName(String id){
    	String name = new String();
		for(PlayerBasicInfoVO vo : inidata){
			   if(vo.getPlayerID().equals(id)){
				   name  = vo.getEnglishName();
			   }
		}
    	return name;
    }
    
    /*
     * 根据DataType和赛季得到热点球员,ipl代表是不是季后赛
     */
    public ArrayList<PlayerVO> getSeasonHotPlayers(String Season,DataType type,boolean ipl){
    	ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
    	ArrayList<PlayerdatainfoVO> presult=new ArrayList<PlayerdatainfoVO>();
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
        			    presult.add(p);
        				count++;
        			}
        			else
        				break;
        		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	for(PlayerdatainfoVO p:presult){
    		result.add(datainfotovo(p));
    	}
    	return result;
    }
    /*
     * 根据DataType和赛季得到热点球员,ipl代表是不是季后赛
     */
    public ArrayList<PlayerVO> getSeasonKingPlayers(String Season,DataType type,boolean ipl){
    	ArrayList<PlayerdatainfoVO> presult=new ArrayList<PlayerdatainfoVO>();
    	ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
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
        			    presult.add(p);
        				count++;
        			}
        			else
        				break;
        		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	for(PlayerdatainfoVO p:presult){
    		result.add(datainfotovo(p));
    	}
    	return result;
    }
    /*
     * 根据球员name得到打过的赛季
     */
    public ArrayList<String> getseasonbyname(String name){
    	ArrayList<String> result=new ArrayList<String>();
    	try{
     		sql="SELECT season FROM playerdatainfo WHERE Name='"+name+"'" ;
     		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn =DriverManager.getConnection(url, user, password);
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()){
    			if(!result.contains(rs.getString("season")))
    			      result.add(rs.getString("season"));
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.println(result);
    	return result;
    }
    /*
     * 根据球队和赛季得到球员
     */
    public ArrayList<PlayerVO> getplayerbyteam(String tname,String Season){
    	ArrayList<PlayerdatainfoVO> presult=new ArrayList<PlayerdatainfoVO>();
    	ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
    	ArrayList<String> pnames=new ArrayList<String>();
    	tname=tname.substring(0, tname.length()-1);
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
    			    presult.add(p);
    		
        		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	for(PlayerdatainfoVO p:presult){
    		result.add(datainfotovo(p));
    	}
    	return result;
    }
    
    /*
     * 给饼图的数据的接口
     * 饼图的话提供各项基本数据就好了,需要的远少于折线图，因为球队数据种类有限
     */
    public double[] getdataforpiechart(String pid,String seasons,DataType dtp){
    	double[] result=new double[2];
    	ArrayList<PSpecificdata> temp=new ArrayList<PSpecificdata>();
    	ArrayList<String> teams=new ArrayList<String>();
    	try{
     		sql="SELECT * FROM playerdatainfo where id='"+pid+"'"+"AND season='"+seasons+"'";
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection conn =DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=conn.prepareStatement(sql);
        		ResultSet rs=pstmt.executeQuery();
        		while(rs.next()){
        			PSpecificdata p=new PSpecificdata();
        			p.setTeam(rs.getString("teamname"));
        			p.setData(rs.getDouble(dtp.toString()));
        			if(!p.getTeam().equals("总计")){
        				temp.add(p);
        				teams.add(p.getTeam());
        			}
        		}
        		if(temp.size()==0){
        			result[0]=0;
        		}
        		if(temp.size()==1){
        			result[0]=temp.get(0).getData();
        		}
        		if(temp.size()>1){
        			double total=0;
        			for(PSpecificdata l:temp){
        				total=total+l.getData();
        			}
        			result[0]=total/(double)temp.size();
        		}
        		result[1]=TeamControllerThird.getdataforpiechart(teams, dtp, seasons);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        return result;
    }
    
    /*
     *  柱状图要调用的方法,一共八项数据，按顺序来    投篮命中率，三分命中率，罚球命中率，场均篮板，场均助攻，场均抢断，场均盖帽，场均得分
     *  前八个为第一个赛季，后八个为最后一个赛季
     *  如果只有一个赛季，则只返回一个8的arraylist 你可以只展示那八个 或者跳个对话框显示该球员只打了一个赛季，数据不足 无法展示
     *  这样还可以显示我们对脏数据进行了处理
     *  学长，注意-1和-100的处理
     */
    public ArrayList<Double> getdatabybarchart(String pid){
    	ArrayList<Double> result=new ArrayList<Double>();
    	ArrayList<PlayerdatainfoVO> presult=new ArrayList<PlayerdatainfoVO>();
    	ArrayList<PlayerdatainfoVO> pfirst=new ArrayList<PlayerdatainfoVO>();
    	ArrayList<PlayerdatainfoVO> plast=new ArrayList<PlayerdatainfoVO>();
    	sql="SELECT * FROM playerdatainfo where id='"+pid+"'";
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			PlayerdatainfoVO p=new PlayerdatainfoVO();
			p.setSeason(rs.getString("season"));
			p.setTeamname(rs.getString("teamname"));
			p.setFGP(rs.getDouble("FGP"));
			p.setSFGP(rs.getDouble("SFGP"));
			p.setFTGP(rs.getDouble("FTGP"));
			p.setARebounds(rs.getDouble("ARebounds"));
			p.setAAssists(rs.getDouble("AAssists"));
			p.setASteals(rs.getDouble("ASteals"));
			p.setABlocks(rs.getDouble("ABlocks"));
			p.setAScores(rs.getDouble("AScores"));
			presult.add(p);
		}
		String firstseason=presult.get(0).getSeason();
		String lastseason=presult.get(presult.size()-1).getSeason();
		for(PlayerdatainfoVO p:presult){
			if(p.getSeason().equals(firstseason)){
				pfirst.add(p);
			}
			if(p.getSeason().equals(lastseason)){
				plast.add(p);
			}
		}
		
		/*
		 * 只打过一个赛季
		 */
//		System.out.println(firstseason);
//		System.out.println(lastseason);
		if(firstseason.equals(lastseason)){
			
		   if(pfirst.size()==1){
			   PlayerdatainfoVO p=pfirst.get(0);
			   result.add(p.getFGP());
			   result.add(p.getSFGP());
			   result.add(p.getFTGP());
			   result.add(p.getARebounds());
			   result.add(p.getAAssists());
			   result.add(p.getASteals());
			   result.add(p.getABlocks());
			   result.add(p.getAScores());
		   }
		   else{
			   for(PlayerdatainfoVO p:pfirst){
				   if(p.getTeamname().equals("总计")){
					   result.add(p.getFGP());
					   result.add(p.getSFGP());
					   result.add(p.getFTGP());
					   result.add(p.getARebounds());
					   result.add(p.getAAssists());
					   result.add(p.getASteals());
					   result.add(p.getABlocks());
					   result.add(p.getAScores());
					   break;
				   }
			   }
		   }
		}
		else{
			if(pfirst.size()==1){
				
				   PlayerdatainfoVO p=pfirst.get(0);
				   result.add(p.getFGP());
				   result.add(p.getSFGP());
				   result.add(p.getFTGP());
				   result.add(p.getARebounds());
				   result.add(p.getAAssists());
				   result.add(p.getASteals());
				   result.add(p.getABlocks());
				   result.add(p.getAScores());
			   }
			else{
				for(PlayerdatainfoVO p:pfirst){
					
					   if(p.getTeamname().equals("总计")){
						  
						   result.add(p.getFGP());
						   result.add(p.getSFGP());
						   result.add(p.getFTGP());
						   result.add(p.getARebounds());
						   result.add(p.getAAssists());
						   result.add(p.getASteals());
						   result.add(p.getABlocks());
						   result.add(p.getAScores());
						   break;
					   }
				   }
			}
			if(plast.size()==1){
				   PlayerdatainfoVO p=pfirst.get(0);
				   
				   result.add(p.getFGP());
				   result.add(p.getSFGP());
				   result.add(p.getFTGP());
				   result.add(p.getARebounds());
				   result.add(p.getAAssists());
				   result.add(p.getASteals());
				   result.add(p.getABlocks());
				   result.add(p.getAScores());
			   }
			else{
				for(PlayerdatainfoVO p:plast){
					   if(p.getTeamname().equals("总计")){
						   result.add(p.getFGP());
						   result.add(p.getSFGP());
						   result.add(p.getFTGP());
						   result.add(p.getARebounds());
						   result.add(p.getAAssists());
						   result.add(p.getASteals());
						   result.add(p.getABlocks());
						   result.add(p.getAScores());
						   break;
					   }
				   }
			}
			
		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /*
     * playerdatainfo 转成迭代二的playervo
     */
    public PlayerVO datainfotovo(PlayerdatainfoVO p){
    	
    	PlayerVO result=new PlayerVO();
    	PlayerBasicInfoVO pbv=new PlayerBasicInfoVO();
    	System.out.println(inidata.size());
    	for(PlayerBasicInfoVO pb:inidata){
    		if(pb.getPlayerID().equals(p.getId())){
    			pbv=pb;
    			break;
    		}
    	}
    	
    	if(pbv!=null){
    	result.setPlayerName(pbv.getEnglishName());  	
    	result.setPlayerAttends((int)p.getAttendmatches());
    	result.setPosition(pbv.getPlayerPosition());
    	result.setTeamname(p.getTeamname());
    	result.setHeight(pbv.getPlayerHeight());
    	result.setWeight(pbv.getPlayerWeight());
    	result.setPlayerBirth(pbv.getPlayerBirthDay());
    	result.setPlayerAge(0);//年龄没有,进入联盟时间也没有
    	result.setPlayerID(pbv.getPlayerID());
    	result.setSchool(pbv.getPlayerUniversity());
    	result.setHighSchool(pbv.getPlayerHighSchool());//多出来的
    	result.setSeason(p.getSeason());//多出来的
    	result.setAver_playerPlayTime(p.getAtime());
    	result.setPlayerFGP(p.getFGP());
    	result.setAver_playerFG(p.getAFGZ());
    	result.setAver_playerFGTry(p.getAFG());
    	result.setPlayer3FGP(p.getSFGP());
    	result.setAver_player3FG(p.getASFGZ());
    	result.setAver_player3FGTry(p.getASFG());
    	result.setPlayerFTGP(p.getFTGP());
    	result.setAver_playerFTG(p.getAFTGZ());
    	result.setAver_playerFTGTry(p.getAFTGZ());
    	result.setAver_playerTotalRebounds(p.getARebounds());
    	result.setAver_playerOffenceRebounds(p.getAORebouns());
    	result.setAver_playerDeffenceRebounds(p.getADRebounds());
    	result.setAver_playerAssists(p.getAAssists());
    	result.setAver_playerSteals(p.getASteals());
    	result.setAver_playerBlocks(p.getABlocks());
    	result.setAver_playerTurnovers(p.getATurnovers());
    	result.setAver_playerFouls(p.getAFeals());
    	result.setAver_playerScores(p.getAScores());
    	result.setWingames(p.getWin());
    	result.setLosegames(p.getLose());
    	result.setPlayerPlayTime((int)p.getTtime());
    	result.setPlayerFG((int)p.getTFGZ());
    	result.setPlayerFGTry((int)p.getTFG());
    	result.setPlayer3FG((int)p.getTSFGZ());
    	result.setPlayer3FGTry((int)p.getTSFG());
    	result.setPlayerFTG((int)p.getTFTGZ());
    	result.setPlayer3FGTry((int)p.getTFTG());
    	result.setPlayerTotalRebounds((int)p.getTRebounds());
    	result.setPlayerOffenceRebounds((int)p.getTORebouns());
    	result.setPlayerDeffenceRebounds((int)p.getTDRebounds());
    	result.setPlayerAssists((int)p.getTAssists());
    	result.setPlayerSteals((int)p.getTSteals());
    	result.setPlayerBlocks((int)p.getTBlocks());
    	result.setPlayerTurnovers((int)p.getTTurnovers());
    	result.setPlayerFouls((int)p.getTFeals());
    	result.setPlayerScores((int)p.getTScores());
    	result.setRR(p.getRR());
    	result.setO_RR(p.getO_RR());
    	result.setD_RR(p.getD_RR());
    	result.setAR(p.getAR());
    	result.setSR(p.getSR());
    	result.setBR(p.getBR());
    	result.setTR(p.getTR());
    	result.setUR(p.getUseRate());
    	result.setPlayerPER(p.getPER());
    	result.setPlayerTSP(p.getRealShootRate());
    	result.setPlayerSER(p.getS_RR());
    	result.setMatchnumbers((int)p.getAttendmatches());
    	result.setSalary(p.getSalary());
    	}
    	//gmsc效率没有
    	return result;
    }
    public PlayerVO matchdatatovo(PlayerMatchDataVO p){
    	PlayerVO result=new PlayerVO();
    	PlayerBasicInfoVO pbv=new PlayerBasicInfoVO();
    	for(PlayerBasicInfoVO pb:inidata){
    		if(pb.getPlayerID().equals(p.getPlayerID())){
    			pbv=pb;
    			
    			break;
    		}
    	}
    	if(pbv!=null){
    	result.setPlayerName(pbv.getEnglishName());
    	result.setPosition(pbv.getPlayerPosition());
    	result.setHeight(pbv.getPlayerHeight());
    	result.setWeight(pbv.getPlayerWeight());
    	result.setPlayerBirth(pbv.getPlayerBirthDay());
    	result.setPlayerAge(0);//年龄没有,进入联盟时间也没有
    	result.setPlayerID(pbv.getPlayerID());
    	result.setSchool(pbv.getPlayerUniversity());
    	result.setHighSchool(pbv.getPlayerHighSchool());//多出来的
    	result.setPlayerAssists((int)p.getAssists());
		result.setPlayerBlocks((int)p.getBlocks());
		result.setPlayerDeffenceRebounds((int)p.getDRebounds());
		result.setPlayerOffenceRebounds((int)p.getORebounds());
		result.setPlayerTotalRebounds((int)p.getRebounds());
		result.setPlayerFGTry((int)p.getFG());
		result.setPlayerFG((int)p.getFGZ());
		result.setPlayerFGP(p.getFGP());
		result.setPlayer3FGTry((int)p.getSFG());
		result.setPlayer3FG((int)p.getSFGZ());
		result.setPlayer3FGP(p.getSFGP());
		result.setPlayerFTGTry((int)p.getFTG());
		result.setPlayerFTG((int)p.getFTGZ());
		result.setPlayerFTGP(p.getFTGP());
		result.setPlayerTurnovers((int)p.getTurnovers());
		result.setPlayerSteals((int)p.getSteals());
	    result.setPlayerPlayTime((int)p.getTime()*60);
	    result.setPlayerScores((int)p.getScores());
	    result.setPlayerFouls((int)p.getFouls());
	    result.setPlayerTSP(p.getRealShootRate());
	    result.setIsfirst(p.isFirst);
    	}
	    return result;
    }
    /*
     * 测试用的main方法
     */
       public static void main(String args[]){
    	   PlayerControllerThird p=new PlayerControllerThird();
    	  // ArrayList<PlayerdatainfoVO> pr=p.getplayerbyteam("金州勇士", "13-14");
//    	   PlayerVO result=new PlayerVO();
//    	   result=p.getPlayervobyname("Larry Bird", "91-92");
//    	   System.out.println(result.getPlayerName()+result.getTeamname()+result.getAver_playerScores());
    	   ArrayList<String> s=p.getthesameeason("1", "10");
    	   System.out.println(s);
//    	   for(PlayerdatainfoVO l:pr){
//    		   System.out.println(l.getName());
//    	   }
//    	   ArrayList<PlayerVO> pr=new ArrayList<PlayerVO>();
//    	   pr=p.getSeasonHotPlayers("07-08", DataType.ARebounds,true);
//    	   int i=0;
//    	   for(PlayerVO l:pr){
//    		   i++;
//   		   System.out.println(i+" "+l.getPlayerName()+" "+l.getAver_playerTotalRebounds());
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
	@Override
	public PlayerVO getPlayervobyname(String name,String season) {
		// TODO Auto-generated method stub
		ArrayList<PlayerdatainfoVO> ps=new ArrayList<PlayerdatainfoVO>();
		ArrayList<String> teamname=new ArrayList<String>();
		PlayerVO result=new PlayerVO();
		PlayerBasicInfoVO pbv=new PlayerBasicInfoVO();
		try{
     		sql="SELECT * FROM playerdatainfo where name='"+name+"'"+"AND season='"+season+"'";
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
    			   // System.out.println(p.teamname);
    			    ps.add(p);
        		}
                    if(ps.size()>1){
                        boolean count=true;
                    	for(PlayerdatainfoVO l:ps){
                    		if(!teamname.contains(l.getTeamname())&&!l.getTeamname().equals("总计")){
                    			teamname.add(l.getTeamname());
                    		}
                    		if(l.getTeamname().equals("总计")){
                    			result=datainfotovo(l);
                    			count=false;
                              
                    		}
                    	}
                    	if(count){
                    		for(PlayerdatainfoVO l:ps){
                        		if(!l.isIsplayoff()){
                        			result=datainfotovo(l);
                                    break;
                        		}
                        		
                        	}
                    	}
                    	else{
                    		String n="";
                    		for(String s:teamname){
                    			n+=s+" ";
                    		}
                    		result.setTeamname(n);
                    	}
                    }
	                if(ps.size()==1){
	                	result=datainfotovo(ps.get(0));
	                }
	}catch(Exception e){
		e.printStackTrace();
	}
		return result;
	}
	
	public ArrayList<PlayerVO> getSelectedPlayers(String position,String season,String infoType){
		ArrayList<PlayerVO> result = new ArrayList<PlayerVO>();
		ArrayList<PlayerdatainfoVO> ps=new ArrayList<PlayerdatainfoVO>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
    		Connection conn =DriverManager.getConnection(url, user, password);
    		String dataType = "助攻";
    		if(season.equals("")){
    			season = "2014-2015";
    		}
    		if(position.equals("")){
    			position = "中锋";
    		}
    		switch(infoType){
    			case "助攻": dataType = "TAssists";break;
    			case "分钟": dataType = "TTime";break;
    			case "篮板": dataType = "TRebounds";break;
    			case "抢断": dataType = "TSteals";break;
    			case "盖帽": dataType = "TBlocks";break;
    			case "失误": dataType = "TTurnovers";break;
    			case "犯规": dataType = "TFouls";break;
    			case "得分": dataType = "TScores";break;
    			case "投篮": dataType = "TFGZ";break;
    			case "三分": dataType = "TSFGZ";break;
    			case "罚球": dataType = "TFTGZ";break;
    			case "效率": dataType = "PER";break;
    			case "平均篮板": dataType = "ARebounds";break;
    			case "平均助攻": dataType = "AAssists";break;
    			case "平均抢断": dataType = "ASteals";break;
    			case "平均得分": dataType = "AScores";break;
    			case "平均盖帽": dataType = "ABlocks";break;
    			case "FGP": dataType = "FGP";break;
    			case "3FGP": dataType = "SFGP";break;
    			case "FTGP": dataType = "FTGP";break;
    		}
    		
    		sql="SELECT * FROM playerdatainfo WHERE position= '"+position+"'"+"AND season='"+season+"' and isplayoff =0 ORDER BY "+dataType+" DESC;";

    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		ResultSet rs=pstmt.executeQuery();
    		int i=0;
    		while(rs.next()&&i<=50){
    			i++;
    			PlayerdatainfoVO p=new PlayerdatainfoVO();
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
			    System.out.println(p.teamname);
			    ps.add(p);
    		}
    		
    		for(PlayerdatainfoVO temp : ps){
    			PlayerVO p =  this.datainfotovo(temp);
    			result.add(p);
    		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public PlayerVO getPlayervobyid(String pid, String season) {

		// TODO Auto-generated method stub
		ArrayList<PlayerdatainfoVO> ps=new ArrayList<PlayerdatainfoVO>();
		ArrayList<String> teamname=new ArrayList<String>();
		PlayerVO result=new PlayerVO();
		PlayerBasicInfoVO pbv=new PlayerBasicInfoVO();
		try{
     		sql="SELECT * FROM playerdatainfo where id='"+pid+"'"+"AND season='"+season+"'";
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
    			   // System.out.println(p.teamname);
    			    ps.add(p);
        		}
                    if(ps.size()>1){
                        boolean count=true;
                    	for(PlayerdatainfoVO l:ps){
                    		if(!teamname.contains(l.getTeamname())&&!l.getTeamname().equals("总计")){
                    			teamname.add(l.getTeamname());
                    		}
                    		if(l.getTeamname().equals("总计")){
                    			result=datainfotovo(l);
                    			count=false;
                              
                    		}
                    	}
                    	if(count){
                    		for(PlayerdatainfoVO l:ps){
                        		if(!l.isIsplayoff()){
                        			result=datainfotovo(l);
                                    break;
                        		}
                        		
                        	}
                    	}
                    	else{
                    		String n="";
                    		for(String s:teamname){
                    			n+=s+" ";
                    		}
                    		result.setTeamname(n);
                    	}
                    }
	                if(ps.size()==1){
	                	result=datainfotovo(ps.get(0));
	                }
	}catch(Exception e){
		e.printStackTrace();
	}
		return result;
	
	}
	@Override
	public ArrayList<String> getthesameeason(String id1, String id2) {
		// TODO Auto-generated method stub
		ArrayList<String> result =new ArrayList<String>();
		ArrayList<String> season1=new ArrayList<String>();
		ArrayList<String> season2=new ArrayList<String>();
		try{
     		sql="SELECT season FROM playerdatainfo where id='"+id1+"'";
     		String sql1="SELECT season FROM playerdatainfo where id='"+id2+"'";
        		Class.forName("com.mysql.jdbc.Driver");
        		Connection conn =DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=conn.prepareStatement(sql);
        		PreparedStatement pstmt1=conn.prepareStatement(sql1);
        		ResultSet rs=pstmt.executeQuery();
        		ResultSet rs1=pstmt1.executeQuery();
        		while(rs.next()){
        			if(!season1.contains(rs.getString("season"))){
        				season1.add(rs.getString("season"));
        			}
        		}
        		while(rs1.next()){
        			if(!season2.contains(rs1.getString("season"))){
        				season2.add(rs1.getString("season"));
        			}
        		}
        		for(String s1:season1){
        			if(!result.contains(s1)){
        			for(String s2:season2){
        				if(s2.equals(s1)){
        					result.add(s1);
        					break;
        				}
        			}
        			}
        		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
      
}
