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
		ArrayList<TeamMatchDataVO> list = new ArrayList<TeamMatchDataVO>();
		
//		teamController.createSeasonDate(0);
//		teamController.createSeasonDate(1);
//		teamController.createSeasonDate(1);		
//		list = teamController.getMatches("夏洛特黄蜂", "2002-2003", 0);
//		for(TeamMatchDataVO vo : list){
//			System.out.println(vo.getMatchID()+" "+vo.getAssists()+" 111");
//		}
//		ArrayList<TeamVO> teamList=teamController.getAllTeamVO();
//		for(TeamVO vo: teamList){
//			System.out.println(vo.getTeamChineseName()+" "+vo.getTeamEnglishName()+" "
//							+vo.isNowTeam()+" "+vo.getStartSeason()+" "+vo.getEndSeason());
//		}
	}

	//我现在有的数据是：
	//所有的比赛数据
	//历年的球队基本数据
	
	/*我需要的活动
	 * 最好还能给我
	 * 
	 * 获得每个球队的生存赛季;完成！
	 * 每个球队每个赛季的常规赛平均数据
	 * 1.给每场比赛加一个赛季  完成
	 * 2.获得每个球队，每个赛季的比赛，常规赛季后赛分开来  完成
	 * 3。创建一张球队赛季平均数据的 完成
	 * 4.通过步骤2获得的数据来获得每个赛季球队的单项平均数据；完成
	 * 5.拓展，可以获得其对手任意赛季平均数据
	 * 6.table 完善之后
	 * 照着迭代二的需求填写各种方法
	 * */
	
	//这个方法可以不再调用了,在展示数据库设计中可以展示出来
	private void getTeamLife(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			ArrayList<TeamVO> teamList =this.getAllTeamVO();
			for(TeamVO vo: teamList){
				String teamName = vo.getTeamChineseName().substring(0, vo.getTeamChineseName().length()-1);
				sql="SELECT * FROM matches WHERE leftteam="+"'"+teamName+"'";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				vo.setEndSeason("1985");
				vo.setStartSeason("2015");
				while(rs.next()){
					String yearOfMatch = rs.getString(2).substring(0, 4);
					if(vo.getStartSeason().compareTo(yearOfMatch)>0){
						vo.setStartSeason(yearOfMatch);
					}
					if(vo.getEndSeason().compareTo(yearOfMatch)<0){
						vo.setEndSeason(yearOfMatch);
					}
				}
				int startYear = Integer.parseInt(vo.getStartSeason());
				int endYear = Integer.parseInt(vo.getEndSeason());
				vo.setStartSeason(String.valueOf(startYear)+"-"+String.valueOf(startYear+1));
				vo.setEndSeason(String.valueOf(endYear-1)+"-"+String.valueOf(endYear));
			}
			
//			for(TeamVO vo: teamList){
//				System.out.println(vo.getTeamChineseName()+" "+vo.getTeamEnglishName()+" "
//								+vo.isNowTeam()+" "+vo.getStartSeason()+" "+vo.getEndSeanson());
//			}
			System.out.println("根据赛季和球队名称获取该球队所有比赛数据");
			for(TeamVO vo : teamList){
				sql = "UPDATE team SET StartSeason="+"'"+vo.getStartSeason()+
						"'"+" WHERE Chinesename="+"'"+vo.getTeamChineseName()+"'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				sql = "UPDATE team SET EndSeason="+"'"+vo.getEndSeason()+
						"'"+" WHERE Chinesename="+"'"+vo.getTeamChineseName()+"'";
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
			System.out.println("数据的更新已经处理好了");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}		
	}
	
//这个方法用来给比赛添加一个所属赛季在数据库里搞一点大动作  
	public void processAlltheSeasons_Match(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			sql="SELECT * FROM matches";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			String date;
			int year;
			int month;
			String id;
			while(rs.next()){
				id = rs.getString(1);
				date = rs.getString(2);
				year = Integer.parseInt(date.substring(0,4));
				month = Integer.parseInt(date.split("-")[1]);
				if(month>8){
					date = String.valueOf(year)+"-"+String.valueOf(year+1);
				}else{
					date = String.valueOf(year-1)+"-"+String.valueOf(year);
				}
				sql = "UPDATE matches SET season="+"'"+date+"'"+" WHERE id="+"'"+id+"'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			}
			System.out.println("球队比赛都加了一个赛季");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("数据库的连接出现了问题");
		}
	}
	
	//这个方法用来创造所有球队所有赛季的平均数据
	//isPlayOff是用来判断季后赛or常规赛
	public void createSeasonDate(int isPlayOff){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			ArrayList<TeamVO> list = this.getAllTeamVO();
			String season = new String();
			ArrayList<TeamAverData> seasonDataList = new ArrayList<TeamAverData>();
			for(TeamVO vo : list){
				int nowYear = Integer.parseInt(vo.getStartSeason().substring(0,4));
				int endYear = Integer.parseInt(vo.getEndSeason().substring(0,4));
//				String teamShortName = 
				ArrayList<TeamMatchDataVO> seasonMatches = new ArrayList<TeamMatchDataVO>();
				while(nowYear<=endYear){
					season = String.valueOf(nowYear)+"-"+String.valueOf(nowYear+1);	
					seasonMatches = this.getMatches(vo.getTeamChineseName().substring(0,vo.getTeamChineseName().length()-1), season, isPlayOff);
					TeamAverData temp = new TeamAverData();
					temp.setTeamChinsesName(vo.getTeamChineseName());
					temp.setSeason(season);
					temp.setIsPlayOff(0);
					temp.setAttends(seasonMatches.size());
					for(TeamMatchDataVO matchvo : seasonMatches){
						temp.setAll_assists(temp.getAll_assists()+matchvo.getAssists());
						temp.setAll_blocks(temp.getAll_blocks()+matchvo.getBlocks());
						temp.setAll_DRebounds(temp.getAll_DRebounds()+matchvo.getDRebounds());
						temp.setAll_FG(temp.getAll_FG()+matchvo.getFG());
						temp.setAll_FGZ(temp.getAll_FGZ()+matchvo.getFGZ());
						temp.setAll_ORebounds(temp.getAll_ORebounds()+matchvo.getORebounds());
						temp.setAll_Rebounds(temp.getAll_DRebounds()+matchvo.getRebounds());
						temp.setAll_scores(temp.getAll_scores()+matchvo.getScores());
						temp.setAll_steals(temp.getAll_steals()+matchvo.getSteals());
						temp.setAll_ThreeFG(temp.getAll_ThreeFG()+matchvo.getThreeFG());
						temp.setAll_ThreeFGZ(temp.getAll_ThreeFGZ()+matchvo.getThreeFGZ());
						temp.setAll_turnovers(temp.getAll_turnovers()+matchvo.getTurnovers());
						temp.setAll_fouls(temp.getAll_fouls()+matchvo.getFouls());
						temp.setAll_FTG(temp.getAll_FTG()+matchvo.getFTG());
						temp.setAll_FTGZ(temp.getAll_FTGZ()+matchvo.getFTGZ());
					}
					temp.setAll_ThreeFGP((temp.getAll_ThreeFGZ()+0.0)/(temp.getAll_ThreeFG()));
					temp.setAll_FGP((temp.getAll_FGZ()+0.0)/(temp.getAll_FG()));
					temp.setAll_FTGP((temp.getAll_FTGZ()+0.0)/(temp.getAll_FTG()));
					temp.setAver_assists((temp.getAll_assists()+0.0)/temp.getAttends());
					temp.setAver_blocks((temp.getAll_blocks()+0.0)/temp.getAttends());
					temp.setAver_DRebounds((temp.getAll_DRebounds()+0.0)/temp.getAttends());
					temp.setAver_FG((temp.getAll_FG()+0.0)/temp.getAttends());
					temp.setAver_FGZ((temp.getAll_FGZ()+0.0)/temp.getAttends());
					temp.setAver_fouls((temp.getAll_fouls()+0.0)/temp.getAttends());
					temp.setAver_FTG((temp.getAll_FTG()+0.0)/temp.getAttends());
					temp.setAver_FTGZ((temp.getAll_FTGZ()+0.0)/temp.getAttends());
					temp.setAver_ORebounds((temp.getAll_ORebounds()+0.0)/temp.getAttends());
					temp.setAver_Rebounds((temp.getAll_Rebounds()+0.0)/temp.getAttends());
					temp.setAver_scores((temp.getAll_scores()+0.0)/temp.getAttends());
					temp.setAver_steals((temp.getAll_steals()+0.0)/temp.getAttends());
					temp.setAver_ThreeFG((temp.getAll_ThreeFG()+0.0)/temp.getAttends());
					temp.setAver_ThreeFGZ((temp.getAll_ThreeFGZ()+0.0)/temp.getAttends());
					temp.setAver_turnovers((temp.getAll_turnovers()+0.0)/temp.getAttends());		
					nowYear++;
					seasonDataList.add(temp);
//					System.out.println(vo.getTeamChineseName()+" "+season+" "+temp.getAll_assists()+" "+temp.getAver_assists());
					sql = "INSERT INTO teamseasondata(teamChinesename, season, isplayoff, attends, aver_FGP, all_FGz, all_FG, aver_3FGP, "
							+ " all_3FGz, all_3FG,aver_FTGP, all_FTGz, all_FTG, all_rebounds, all_orebounds, all_drebounds, all_assists,all_steals,all_blocks, all_turnovers, all_fouls, all_scores, "
							+ "aver_FGz, aver_FG, aver_3FGZ, aver_3FG, aver_FTGz, aver_FTG, aver_rebounds, aver_orebounds, aver_drebounds, aver_assists, aver_steals, aver_blocks, aver_turnovers,  aver_fouls, aver_scores ) "
							+ "Values(" +"'"+vo.getTeamChineseName()+"'"+", '"+season+"', "+isPlayOff+","+temp.getAttends()+","+temp.getAll_FGP()+","+temp.getAll_FGZ()+","+temp.getAll_FG()+","+temp.getAll_ThreeFGP()+","+temp.getAll_ThreeFGZ()+","+temp.getAll_ThreeFG()+","+
							temp.getAll_FTGP()+","+temp.getAll_FTGZ()+","+temp.getAll_FTG()+","+temp.getAll_Rebounds()+","+temp.getAll_ORebounds()+","+temp.getAll_DRebounds()+","+temp.getAll_assists()+","+temp.getAll_steals()+","+temp.getAll_blocks()+","+
							temp.getAll_turnovers()+","+temp.getAll_fouls()+","+temp.getAll_scores()+","+temp.getAver_FGZ()+","+temp.getAver_FG()+","+temp.getAver_ThreeFGZ()+","+temp.getAver_ThreeFG()+","+temp.getAver_FTGZ()+","+temp.getAver_FTG()+","+
							temp.getAver_Rebounds()+","+temp.getAver_ORebounds()+","+temp.getAver_DRebounds()+","+temp.getAver_assists()+","+temp.getAver_steals()+","+temp.getAver_blocks()+","+temp.getAver_turnovers()+","+temp.getAver_fouls()+","+temp.getAver_scores()+")";
					System.out.println(sql);
					if(temp.getAttends()>0){
						Statement stmt = conn.createStatement();
						stmt.execute(sql);
						stmt.close();
					}
				}
			}
			conn.close();
			if(isPlayOff==1){
				System.out.println("季后赛赛季平均数据录入数据库");
			}else{
				System.out.println("常规赛赛季平均数据录入数据库");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<TeamMatchDataVO> getMatches(String teamName,String season,int isPlayOffs){
		ArrayList<TeamMatchDataVO> oneSeasonMatches = new ArrayList<TeamMatchDataVO>();
		try{
			int attends = 0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql = "SELECT id FROM matches WHERE (leftteam="+"'"+teamName+"'"
					+" OR rightteam="+"'"+teamName+"'"+") AND season="+"'"
					+season+"'"+" and isplayoff="+isPlayOffs;
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				sql = "SELECT * FROM teammatchdata WHERE matchid="+"'"+rs.getString(1)+"'";
				pstmt =conn.prepareStatement(sql);
				ResultSet rs2=pstmt.executeQuery();
				TeamMatchDataVO temp = new TeamMatchDataVO();
				while(rs2.next()){
					temp.setMatchID(rs2.getString(1));
					temp.setTeamChinsesName(rs2.getString(2));
					temp.setFGP(rs2.getDouble(3));
					temp.setFGZ(rs2.getInt(4));
					temp.setFG(rs2.getInt(5));
					temp.setThreeFGP(rs2.getDouble(6));
					temp.setThreeFGZ(rs2.getInt(7));
					temp.setThreeFG(rs2.getInt(8));
					temp.setFTGP(rs2.getDouble(9));
					temp.setFTGZ(rs2.getInt(10));
					temp.setFTG(rs2.getInt(11));
					temp.setRealShootRate(rs2.getDouble(12));
					temp.setRebounds(rs2.getInt(13));
					temp.setORebounds(rs2.getInt(14));
					temp.setDRebounds(rs2.getInt(15));
					temp.setAssists(rs2.getInt(16));
					temp.setSteals(rs2.getInt(17));
					temp.setBlocks(rs2.getInt(18));
					temp.setTurnovers(rs2.getInt(19));
					temp.setFouls(rs2.getInt(20));
					temp.setScores(rs2.getInt(21));
					temp.setIsplayoff(rs2.getInt(22));
				}					
				oneSeasonMatches.add(temp);
				attends++;
			}
			System.out.println("获得了"+teamName+" "+season+ " "+isPlayOffs+" 所有比赛"+attends);
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return oneSeasonMatches;
	}
	
	//获得该球队历史上所有赛季的单赛季平均数据
	public ArrayList<TeamAverData> getTeamHistorySeason(String teanName , int isPlayOff){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		
		
		return result;
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
