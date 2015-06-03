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
    public ArrayList<PSpecificdata>  getplayerdata(String pid,DataType t){
    	   ArrayList<PSpecificdata> result=new ArrayList<PSpecificdata>();
    	   try{
    		sql="SELECT * FROM playerdatainfo WHERE id='1'";
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
       		   p.setSeason(rs.getString("season"));
       		   result.add(p);
             }
       	    }
       		//System.out.println("cheng gong");
       		conn.close();
       		
       	}catch(Exception e){
       		System.out.println(e);
       	}
    	   return result;
       }
    
       public static void main(String args[]){
    	   PlayerControllerThird p=new PlayerControllerThird();
    	   p.getplayerdata("1", DataType.salary);
       }
      
}