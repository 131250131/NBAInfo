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

import thirdservice.teamControllerThirdService;
import Utibility.DataType;

public class TeamControllerThird implements teamControllerThirdService{
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
	
	public static void main(String args[]){
		TeamControllerThird teamController = new TeamControllerThird();
		ArrayList<TeamMatchDataVO> list = new ArrayList<TeamMatchDataVO>();
		ArrayList<TeamAverData> list2 = new ArrayList<TeamAverData>();

//		list2 = teamController.getSeasonHotTeam_Rebound("2014-2015", false);
//		list2 = teamController.getTeamHistorySeason("金州勇士队", 0);
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
			ArrayList<TeamVOThird> teamList =this.getAllTeamVO();
			for(TeamVOThird vo: teamList){
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
			for(TeamVOThird vo : teamList){
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
			ArrayList<TeamVOThird> list = this.getAllTeamVO();
			String season = new String();
			ArrayList<TeamAverData> seasonDataList = new ArrayList<TeamAverData>();
			for(TeamVOThird vo : list){
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

	//获得某一赛季，某一球队，常规赛or季后赛的所有比赛
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
	public ArrayList<TeamAverData> getTeamHistorySeason(String teamName , int isPlayOff){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql = "SELECT * FROM teamseasondata t WHERE teamChinesename ="+"'"+teamName+"' and isplayoff="+isPlayOff+";";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAll_assists());
			}
			conn.close();
			System.out.println("获得了"+teamName+"历史数据");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_Rebound(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_rebounds DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_ORebound(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_orebounds DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_Assit(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_assists DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_Foul(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_fouls DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_Turnover(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_turnovers DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_Score(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_scores DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_3FGP(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_3FGP DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_FGP(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_FGP DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamAverData> getSeasonHotTeam_FTGP(String season, boolean isPlayOffs){
		ArrayList<TeamAverData> result = new ArrayList<TeamAverData>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT * FROM teamseasondata t WHERE season="+"'"+season+"' and isplayoff="+isPlayOffs+" ORDER BY aver_FTGP DESC;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamAverData temp = new TeamAverData();
				temp.setTeamChinsesName(rs.getString(1));
				temp.setSeason(rs.getString(2));
				temp.setAver_scores(rs.getDouble(3));
				temp.setAver_Rebounds(rs.getDouble(4));
				temp.setAver_ORebounds(rs.getDouble(5));
				temp.setAver_DRebounds(rs.getDouble(6));
				temp.setAver_steals(rs.getDouble(7));
				temp.setAver_fouls(rs.getDouble(8));
				temp.setAver_blocks(rs.getDouble(9));
				temp.setAver_turnovers(rs.getDouble(10));	
				temp.setAll_ThreeFGP(rs.getDouble(11));
				temp.setAll_FGP(rs.getDouble(12));
				temp.setAll_FTGP(rs.getDouble(13));
				temp.setAll_scores(rs.getInt(14));
				temp.setAll_Rebounds(rs.getInt(15));
				temp.setAll_ORebounds(rs.getInt(16));
				temp.setAll_DRebounds(rs.getInt(17));
				temp.setAll_steals(rs.getInt(18));
				temp.setAll_fouls(rs.getInt(19));
				temp.setAll_blocks(rs.getInt(20));
				temp.setAll_turnovers(rs.getInt(21));
				temp.setAll_ThreeFG(rs.getInt(22));
				temp.setAll_ThreeFGZ(rs.getInt(23));
				temp.setAll_FTG(rs.getInt(24));
				temp.setAll_FTGZ(rs.getInt(25));
				temp.setAll_FG(rs.getInt(26));
				temp.setAll_FGZ(rs.getInt(27));
				temp.setAver_ThreeFG(rs.getDouble(28));
				temp.setAver_ThreeFGZ(rs.getDouble(29));				
				temp.setAver_FTG(rs.getDouble(30));
				temp.setAver_FTGZ(rs.getDouble(31));
				temp.setAver_FG(rs.getInt(32));
				temp.setAver_FGZ(rs.getDouble(33));
				temp.setIsPlayOff(rs.getInt(34));
				temp.setAttends(rs.getInt(35));
				temp.setAll_assists(rs.getInt(36));
				temp.setAver_assists(rs.getDouble(37));
				result.add(temp);
				System.out.println(temp.getTeamChinsesName()+" "+temp.getSeason()+" "+temp.getAver_Rebounds());
			}
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	//completed;
	public ArrayList<MatchVOThird> getTeamMatchDataOfSeanson(String season,String teamName){
		ArrayList<MatchVOThird> matchList = new ArrayList<MatchVOThird>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			sql = "SELECT * FROM matches WHERE (leftteam="+"'"+teamName+"' OR rightteam="+"'"+teamName+"' )and season="+"'"+season+"'"+";";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				MatchVOThird temp = new MatchVOThird();
				temp.setMatchID(rs.getString(1));
				temp.setDate(rs.getString(2));
				temp.setLeftTeamName(rs.getString(3));
				temp.setRightTeamName(rs.getString(4));
				temp.setFirstScore(rs.getString(5));
				temp.setSecondScore(rs.getString(6));
				temp.setThirdScore(rs.getString(7));
				temp.setForthScore(rs.getString(8));
				temp.setExtraScore(rs.getString(9));
				temp.setTotalScore(rs.getString(10));
				temp.setIsplayoff(rs.getInt(11));
				temp.setSeason(rs.getString(12));
				matchList.add(temp);
			}
			System.out.println("根据赛季和球队名称获取该球队所有比赛数据");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();	
		}
		return matchList;
	}

	//completed;
	public ArrayList<TeamVOThird> getAllTeamVO(){
		ArrayList<TeamVOThird> teamList = new ArrayList<TeamVOThird>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			sql = "SELECT * FROM team t;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				TeamVOThird vo = new TeamVOThird();
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

	/*
	 * 根据球队一个list和赛季还有datatype枚举得到列表球队该项数据的平均数的方法 阿超你来不全一下,我给你的球队名字没有队，要是这样不方便和我讲 我那里可以改 
	 * static方便我调用 要是这些球队这个赛季没有了 你就直接给我0就好了
	 */
	public static double getdataforpiechart(ArrayList<String> teams,DataType dpt,String season){
		int num =teams.size();
		double sum=0.0;
		double result =0.0;
		String datatype = new String();
		switch(dpt){
			case AFGZ : datatype = "aver_FGz";break;
			case AFG : datatype = "aver_FG";break;			
			case ASFGZ : datatype = "aver_3FGz";break;
			case ASFG : datatype = "aver_3FG";break;		
			case AFTGZ : datatype = "aver_FTGz";break;
			case AFTG : datatype = "aver_FTG";break;	
			case ARebounds : datatype = "aver_rebounds";break;
			case AORebouns : datatype = "aver_orebounds";break;
			case ADRebounds : datatype = "aver_drebounds";break;
			case AAssists : datatype = "aver_assists";break;
			case ASteals : datatype = "aver_steals";break;
			case ABlocks : datatype = "aver_blocks";break;
			case ATurnovers : datatype = "aver_turnovers";break;
			case AFouls : datatype = "aver_fouls";break;
			case AScores : datatype = "aver_scores";break;
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/nbadata?characterEncoding=utf-8", "root", "");
			String sql =  new String();
			for(String teamName : teams){
				teamName = teamName+"队";
				sql = "SELECT "+datatype+" FROM teamseasondata t WHERE season="+"'"+season+"' and teanChineseName="+"'"+teamName+"'"+";";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					double temp = rs.getDouble(1);
					sum += temp;
				}
			}
			result = num==0?0:sum/num;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
}
