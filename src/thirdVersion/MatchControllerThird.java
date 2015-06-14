package thirdVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import thirdservice.matchControllerThirdService;
import vo.MatchVO;
import vo.PlayerVO;
import vo.TeamVO;

public class MatchControllerThird implements matchControllerThirdService{
	String url="jdbc:mysql://localhost/nbadata?characterEncoding=utf-8";
	String user="root";
	String password="";
	String sql="";
	DecimalFormat    df   = new DecimalFormat("######0.00"); 
	/*
	 * 根据日期的到比赛
	 */
	public ArrayList<MatchVO> getmatchbydate(String date){
		ArrayList<MatchVO> result =new ArrayList<MatchVO>();
		sql="SELECT * FROM matches WHERE time="+"'"+date+"'";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			MatchVO mvo=new MatchVO();
			mvo.setNum(rs.getString(1));
			mvo.setDate(rs.getString(2));
			mvo.setLeftTeam(getmatchteam(mvo.getNum(),rs.getString(3)));
			mvo.setRightTeam(getmatchteam(mvo.getNum(),rs.getString(4)));
			mvo.setLeftplayerlist(getmatchplayers(mvo.getNum(),"left"));;
			mvo.setRightplayerlist(getmatchplayers(mvo.getNum(),"right"));
			mvo.setScores1(rs.getString(5));
			mvo.setScores2(rs.getString(6));
			mvo.setScores3(rs.getString(7));
			mvo.setScores4(rs.getString(8));
			mvo.setExtrascores(rs.getString(9));
			mvo.setScore(rs.getString(10));
			mvo.setIsplayoff(rs.getBoolean(11));
			mvo.setSeason(rs.getString(12));
			result.add(mvo);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
    /*
     * 根据比赛id得到球员信息,这个接口暂时供你界面接口测试 ，先发不是默认前五个 ，(如果需要)有个参数判断
     */
	public ArrayList<PlayerVO> getmatchplayers(String id,String lr){
		ArrayList<PlayerVO> result=new ArrayList<PlayerVO>();
		PlayerControllerThird pc=new PlayerControllerThird();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			String sql1="SELECT * FROM playermatchdata WHERE matchid="+"'"+id+"'";//等数据好了这句话会改 球员会变正确
			PreparedStatement pstmt=conn.prepareStatement(sql1);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				PlayerMatchDataVO pl=new PlayerMatchDataVO();
				PlayerVO p=new PlayerVO();
				pl.setMatchID(rs.getString(1));
				pl.setPlayerID(rs.getString(2));
				pl.setPlayerName(rs.getString(3));
				pl.setTime(Double.parseDouble(df.format(rs.getDouble(4))));
				pl.setFGP(Double.parseDouble(df.format(rs.getDouble(5)*100)));
				pl.setFGZ(Double.parseDouble(df.format(rs.getDouble(6))));
				pl.setFG(Double.parseDouble(df.format(rs.getDouble(7))));
				pl.setSFGP(Double.parseDouble(df.format(rs.getDouble(8)*100)));
				pl.setSFGZ(Double.parseDouble(df.format(rs.getDouble(9))));
				pl.setSFG(Double.parseDouble(df.format(rs.getDouble(10))));
				pl.setFTGP(Double.parseDouble(df.format(rs.getDouble(11)*100)));
				pl.setFTGZ(Double.parseDouble(df.format(rs.getDouble(12))));
				pl.setFTG(Double.parseDouble(df.format(rs.getDouble(13))));
				pl.setRealShootRate(Double.parseDouble(df.format(rs.getDouble(14))));
				pl.setRebounds(Double.parseDouble(df.format(rs.getDouble(15))));
				pl.setORebounds(Double.parseDouble(df.format(rs.getDouble(16))));
				pl.setDRebounds(Double.parseDouble(df.format(rs.getDouble(17))));
				pl.setAssists(Double.parseDouble(df.format(rs.getDouble(18))));
				pl.setSteals(Double.parseDouble(df.format(rs.getDouble(19))));
				pl.setBlocks(Double.parseDouble(df.format(rs.getDouble(20))));
				pl.setTurnovers(Double.parseDouble(df.format(rs.getDouble(21))));
				pl.setFouls(Double.parseDouble(df.format(rs.getDouble(22))));
				pl.setScores(Double.parseDouble(df.format(rs.getDouble(23))));
				pl.setFirst(rs.getBoolean(24));
				p=pc.matchdatatovo(pl);
				result.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	/*
	 * 根据比赛id得到球队信息
	 */
	public TeamVO getmatchteam(String id,String teamname){
		TeamVO result=new TeamVO();
		TeamControllerThird t=new TeamControllerThird();
		TeamMatchDataVO temp = new TeamMatchDataVO();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection(url, user, password);
			sql = "SELECT * FROM teammatchdata WHERE matchid="+"'"+id+"'"+"AND teamname='"+teamname+"'";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs2=pstmt.executeQuery();
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
		}catch(Exception e){
			e.printStackTrace();
		}
		result=t.thirdVOTosecondVO_3(temp);
        return result;
		
	}
	/*
     * 测试用的main方法
     */
	public static void main(String args[]){
		MatchControllerThird m=new MatchControllerThird();
//		ArrayList<String> result = m.getMatchdatesbySeaon("2014-2015");
//		for(String temp : result){
//			System.out.println(temp);
//		}
//		
//		MatchVOThird mm=new MatchVOThird();
//		mm.setMatchID("1");
//		System.out.println(mm.getPdate().size());
//		for(PlayerMatchDataVO mv:mm.getPdate()){
//			System.out.println(mv.getPlayerName());
//		}
//		ArrayList<MatchVO> mm=m.getmatchbydate("2015-03-09");
////		System.out.println(mm.size());
//		for(MatchVO k:mm){
//			System.out.println(k.getLeftplayerlist().size()+"  "+k.getNum());
		
		System.out.println(m.getMatchdatesbySeaon("2014-2015").size());
	}

	public ArrayList<String> getMatchdatesbySeaon(String season) {
		ArrayList<String> result = new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			sql="SELECT time FROM matches m WHERE season="+"'"+season+"' ORDER BY time;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				String temp = rs.getString(1);
				if(result.size()==0||(!result.get(result.size()-1).equals(temp))){
					result.add(temp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
