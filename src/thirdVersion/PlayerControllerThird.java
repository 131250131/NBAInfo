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
    
       public static void main(String args[]){
    	   PlayerControllerThird p=new PlayerControllerThird();    	
    	  // System.out.println(p.VOinitial().size());
//    	   for(PlayerBasicInfoVO pb:p.VOinitial()){
//    		   System.out.println(pb.getFGP());
//    		   System.out.println(pb.getSFGP());
//    		   System.out.println(pb.getFTGP());
//    	   }
    	   ArrayList<PSpecificdata> l=p.getnormalplayerdata("1001", DataType.AAssists);
    	   for(PSpecificdata k:l){
    		   System.out.println(k.getData());
    	   }
//    	   PlayerBasicInfoVO ppp=p.getPlayerbyname("Aaron Brooks");
//    	   System.out.println(ppp.getAAssists());
//    	   for(PlayerBasicInfoVO lm:l){
//    		 if(lm.getPlayerName().equals("Aaron Brooks")){
//    			 System.out.println(lm.getAAssists());
//    		 }
//    	   }
    	  
    	   
       }
      
}