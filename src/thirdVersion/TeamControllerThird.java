package thirdVersion;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeamControllerThird {
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
	
	public static void main(String args[]){
		TeamControllerThird teamController = new TeamControllerThird();
		
		ArrayList<TeamVO> teamList=teamController.getAllTeamVO();
		for(TeamVO vo: teamList){
			System.out.println(vo.getTeamChineseName()+" "+vo.getTeamEnglishName()+" "
							+vo.isNowTeam()+" "+vo.getStartSeason()+" "+vo.getEndSeason());
		}
	}

	//我现在有的数据是：
	//所有的比赛数据
	//历年的球队基本数据
	
	/*我需要的活动
	 * 最好还能给我
	 * 
	 * 获得每个球队的生存赛季;完成！
	 * 每个球队每个赛季的常规赛平均数据
	 * 1.给每场比赛加一个赛季
	 * 2.获得每个球队，每个赛季的比赛，常规赛季后赛分开来
	 * 3。创建一张球队赛季平均数据的表
	 * 4.通过步骤2获得的数据来获得每个赛季球队的单项平均数据；
	 * 5.拓展，可以获得其对手任意赛季平均数据
	 * 6.table 完善之后
	 * 照着迭代二的需求填写各种方法
	 * */
	
	//这个方法可以不再调用了
//	private void getTeamLife(){
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn =DriverManager.getConnection(url, user, password);
//			ArrayList<TeamVO> teamList =this.getAllTeamVO();
//			for(TeamVO vo: teamList){
//				String teamName = vo.getTeamChineseName().substring(0, vo.getTeamChineseName().length()-1);
//				sql="SELECT * FROM matches WHERE leftteam="+"'"+teamName+"'";
//				PreparedStatement pstmt=conn.prepareStatement(sql);
//				ResultSet rs=pstmt.executeQuery();
//				vo.setEndSeason("1985");
//				vo.setStartSeason("2015");
//				while(rs.next()){
//					String yearOfMatch = rs.getString(2).substring(0, 4);
//					if(vo.getStartSeason().compareTo(yearOfMatch)>0){
//						vo.setStartSeason(yearOfMatch);
//					}
//					if(vo.getEndSeason().compareTo(yearOfMatch)<0){
//						vo.setEndSeason(yearOfMatch);
//					}
//				}
//				int startYear = Integer.parseInt(vo.getStartSeason());
//				int endYear = Integer.parseInt(vo.getEndSeason());
//				vo.setStartSeason(String.valueOf(startYear)+"-"+String.valueOf(startYear+1));
//				vo.setEndSeason(String.valueOf(endYear-1)+"-"+String.valueOf(endYear));
//			}
//			
////			for(TeamVO vo: teamList){
////				System.out.println(vo.getTeamChineseName()+" "+vo.getTeamEnglishName()+" "
////								+vo.isNowTeam()+" "+vo.getStartSeason()+" "+vo.getEndSeanson());
////			}
//			System.out.println("根据赛季和球队名称获取该球队所有比赛数据");
//			for(TeamVO vo : teamList){
//				sql = "UPDATE team SET StartSeason="+"'"+vo.getStartSeason()+
//						"'"+" WHERE Chinesename="+"'"+vo.getTeamChineseName()+"'";
//				Statement stmt = conn.createStatement();
//				stmt.executeUpdate(sql);
//				sql = "UPDATE team SET EndSeason="+"'"+vo.getEndSeason()+
//						"'"+" WHERE Chinesename="+"'"+vo.getTeamChineseName()+"'";
//				stmt = conn.createStatement();
//				stmt.executeUpdate(sql);
//			}
//			System.out.println("数据的更新已经处理好了");
//			conn.close();
//		}catch(Exception e){
//			e.printStackTrace();	
//		}		
//	}
	
//这个方法用来创造球队的平均数据，在数据库里搞一点大动作
	public void processAlltheSeasons(){
		
	}
	
	public void getMatches(String teanName,String season,boolean isPlayOffs){
		
	}
	
	//获得该球队历史上所有赛季的单赛季平均数据
	public void getTeamHistorySeason(String teanName){
		
	}
	
//
	public void getSeasonHotTeam(String seson , boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_Rebound(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_ORebound(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_DRebound(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_Assit(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_Block(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_Foul(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_Turnover(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_Score(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_3FGP(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_FGP(String seson, boolean isPlayOffs){
		
	}
	
	public void getSeasonHotTeam_FTGP(String seson, boolean isPlayOffs){
		
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

	//completed;
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
				vo.setEndSeason(rs.getString(5));
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
