package thirdservice;

import java.util.ArrayList;

import thirdVersion.MatchVOThird;
import thirdVersion.TeamAverData;
import thirdVersion.TeamMatchDataVO;
import thirdVersion.TeamVOThird;

public interface teamControllerThirdService {
	public ArrayList<TeamMatchDataVO> getMatches(String teamName,String season,int isPlayOffs);
	public ArrayList<TeamAverData> getTeamHistorySeason(String teamName , int isPlayOff);
	public ArrayList<TeamAverData> getSeasonHotTeam_Rebound(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_ORebound(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_Assit(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_Foul(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_Turnover(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_Score(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_3FGP(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_FGP(String season, boolean isPlayOffs);
	public ArrayList<TeamAverData> getSeasonHotTeam_FTGP(String season, boolean isPlayOffs);
	public ArrayList<MatchVOThird> getTeamMatchDataOfSeanson(String season,String teamName);
	public ArrayList<TeamVOThird> getAllTeamVO();
	
}
