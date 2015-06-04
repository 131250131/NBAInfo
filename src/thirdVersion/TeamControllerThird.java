package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamControllerThird {
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
	
	public static void main(String args[]){
		TeamControllerThird teamController = new TeamControllerThird();
		teamController.getTeamLife();
//		ArrayList<TeamVO> teamList=teamController.getAllTeamVO();
//		for(TeamVO vo: teamList){
//			System.out.println(vo.getTeamChineseName()+" "+vo.getTeamEnglishName()+" "
//							+vo.isNowTeam()+" "+vo.getStartSeason()+" "+vo.getEndSeanson());
//		}
	}

	//我现在有的数据是：
	//所有的比赛数据
	//历年的球队基本数据
	
	/*我需要的活动
	 * 最好还能给我
	 * 
	 * 获得每个球队的生存赛季
	 * 每个球队每个赛季的常规赛平均数据
	 * 
	 * */
	
	private void getTeamLife(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			ArrayList<TeamVO> teamList =this.getAllTeamVO();
			for(TeamVO vo: teamList){
				sql = "SELECT * FROM matches WHERE leftteam="+vo.getTeamChineseName();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				vo.setEndSeanson("1985");
				vo.setStartSeason("2015");
				while(rs.next()){
					String yearOfMatch = rs.getString(1).substring(0, 4);
					if(vo.getStartSeason().compareTo(yearOfMatch)>0){
						vo.setStartSeason(yearOfMatch);
					}
					if(vo.getEndSeanson().compareTo(yearOfMatch)<0){
						vo.setEndSeanson(yearOfMatch);
					}
				}
				int startYear = Integer.parseInt(vo.getStartSeason());
				int endYear = Integer.parseInt(vo.getEndSeanson());
				vo.setStartSeason(String.valueOf(startYear)+"-"+String.valueOf(startYear+1));
				vo.setEndSeanson(String.valueOf(endYear-1)+"-"+String.valueOf(endYear));
			}
			
			for(TeamVO vo: teamList){
				System.out.println(vo.getTeamChineseName()+" "+vo.getTeamEnglishName()+" "
								+vo.isNowTeam()+" "+vo.getStartSeason()+" "+vo.getEndSeanson());
			}
			
			System.out.println("根据赛季和球队名称获取该球队所有比赛数据");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}		
	}
	

	public void processAlltheSeasons(){
		
	}
	
	public ArrayList<TeamMatchDataVO> getTeamMatchDataOfSeanson(String seanon,String shortName){
		ArrayList<TeamMatchDataVO> matchList = new ArrayList<TeamMatchDataVO>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			System.out.println("根据赛季和球队名称获取该球队所有比赛数据");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return matchList;
	}
	
	public ArrayList<TeamVO> getAllTeamVO(){
		ArrayList<TeamVO> teamList = new ArrayList<TeamVO>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			sql = "SELECT * FROM team t;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamVO vo = new TeamVO();
				vo.setTeamChineseName(rs.getString(1));
				vo.setTeamEnglishName(rs.getString(2));
				vo.setNowTeam(rs.getDouble(3)==0.0?true:false);
				vo.setStartSeason(rs.getString(4));
				vo.setEndSeanson(rs.getString(5));
				teamList.add(vo);
			}
			System.out.println("获取所有球队的基本信息");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return teamList;
	}

	
	
	
}
