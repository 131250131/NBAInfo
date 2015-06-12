package thirdservice;

import java.util.ArrayList;

import thirdVersion.MatchVOThird;
import thirdVersion.TeamAverDataVO;
import thirdVersion.TeamMatchDataVO;
import thirdVersion.TeamVOThird;
import vo.TeamVO;

public interface teamControllerThirdService {
	public ArrayList<TeamMatchDataVO> getMatches(String teamName,String season,int isPlayOffs);
	public ArrayList<TeamVO> getTeamHistorySeason(String teamName , int isPlayOff);
	public ArrayList<TeamVO> getSeasonHotTeam_Rebound(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_ORebound(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_Assit(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_Foul(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_Turnover(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_Score(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_3FGP(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_FGP(String season, boolean isPlayOffs);
	public ArrayList<TeamVO> getSeasonHotTeam_FTGP(String season, boolean isPlayOffs);
	public ArrayList<MatchVOThird> getTeamMatchDataOfSeanson(String season,String teamName);
	public ArrayList<TeamVO> getAllTeamVO();
	
}
