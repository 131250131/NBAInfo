package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MatchControllerThird {
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
	/*
	 * 根据日期的到比赛
	 */
	public ArrayList<MatchVO> getmatchbydate(String date){
		ArrayList<MatchVO> result =new ArrayList<MatchVO>();
		System.out.println(date);
		sql="SELECT * FROM matches WHERE time="+date;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			MatchVO mvo=new MatchVO();
			mvo.setMatchID(rs.getString(1));
			mvo.setDate(rs.getString(2));
			mvo.setLeftTeamName(rs.getString(3));
			mvo.setRightTeamName(rs.getString(4));
			mvo.setFirstScore(rs.getString(5));
			mvo.setSecondScore(rs.getString(6));
			mvo.setThirdScore(rs.getString(7));
			mvo.setForthScore(rs.getString(8));
			mvo.setExttaScore(rs.getString(9));
			mvo.setTotalScore(rs.getString(10));
			result.add(mvo);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	public static void main(String args[]){
		MatchControllerThird m=new MatchControllerThird();
		ArrayList<MatchVO> r=m.getmatchbydate("1985-10-25");
		System.out.println(r.size());
		for(MatchVO mv:r){
			System.out.println(mv.getDate());
		}
	}
}
