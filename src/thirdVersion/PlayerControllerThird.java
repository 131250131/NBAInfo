package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Utibility.DataType;

public class PlayerControllerThird {
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
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
       		   String s=rs.getString(t.toString());
       		   if(s.equals("-1"))
       			   p.setData(0.0);
       		   else
       			   p.setData(Double.parseDouble(s));
       		   
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
    		   String s=rs.getString(t.toString());
    		   if(s.equals("-1"))
    			   p.setData(0.0);
    		   else
    			   p.setData(Double.parseDouble(s));
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
     * 初始化信息
     */
    public ArrayList<PlayerBasicInfoVO> VOinitial(){
    	ArrayList<PlayerBasicInfoVO> result=new ArrayList<PlayerBasicInfoVO>();
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
        			p.setAtime(rs.getDouble(11));
        			p.setFGP(rs.getDouble(12));
        			p.setAFGZ(rs.getDouble(13));
        			p.setAFG(rs.getDouble(14));
        			p.setSFGP(rs.getDouble(15));
        			p.setASFGZ(rs.getDouble(16));
        			p.setASFG(rs.getDouble(17));
        			p.setFTGP(rs.getDouble(18));
        			p.setAFTGZ(rs.getDouble(19));
        			p.setAFTG(rs.getDouble(20));
        			p.setARebounds(rs.getDouble(21));
        			p.setAORebouns(rs.getDouble(22));
        			p.setADRebounds(rs.getDouble(23));
        			p.setAAssists(rs.getDouble(24));
        			p.setASteals(rs.getDouble(25));
        			p.setABlocks(rs.getDouble(26));
        			p.setATurnovers(rs.getDouble(27));
        			p.setAFeals(rs.getDouble(28));
        			p.setAScores(rs.getDouble(29));
        			result.add(p);
        		}
        		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return result;
    }
       public static void main(String args[]){
    	   PlayerControllerThird p=new PlayerControllerThird();
    	   
    	   ArrayList<PlayerBasicInfoVO> l=p.VOinitial();
    	 
    	   for(PlayerBasicInfoVO lm:l){
    		  System.out.println(lm.getPlayerName());
    	   }
    	  
    	   
       }
      
}