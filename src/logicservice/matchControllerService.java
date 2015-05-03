package logicservice;

import java.sql.Date;
import java.util.ArrayList;

import vo.MatchVO;
import vo.TeamShortName;

public interface matchControllerService {
	public ArrayList<MatchVO> getAllMatchVO();
	public ArrayList<MatchVO> getSomeMacthVO(String date);
	public ArrayList<MatchVO> getSomeMatchVO(String playerName);
	public ArrayList<MatchVO> getSomeMatchVO(TeamShortName teamShortName);
	public Object[][] getTeamData(String team,int matchnum);//查找队伍本场比赛数据，team：left/right,matchnum为场次
	public ArrayList<MatchVO> getMatchOfPlayer(String playerName);
	public MatchVO getMatch(int num);//根据场次查找比赛
	public ArrayList<MatchVO> gettodaysmatch();
	public ArrayList<String>  getDatehavematches();
}
