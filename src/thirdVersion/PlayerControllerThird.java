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
       public static void main(String args[]){
    	   PlayerControllerThird p=new PlayerControllerThird();
    	   for(int i=1;i<1000;i++){
    	   String in=String.valueOf(i);
    	   System.out.println(i);
    	   ArrayList<PSpecificdata> l=p.getplayoffplayerdata(in, DataType.AAssists);
    	   for(PSpecificdata lm:l){
    		   if(lm.isIsuseful()){
    			   System.out.println(lm.getSeason()+" "+lm.getData());
    			   System.out.println();
    		   }
    	   }
    	  
    	   }
       }
      
}