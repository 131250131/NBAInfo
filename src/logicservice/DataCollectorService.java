package logicservice;

import java.util.ArrayList;

import vo.PlayerVO;
import vo.TeamVO;

public interface DataCollectorService {
	public ArrayList<ArrayList<PlayerVO>> getSeasonHotPlayers();
	public ArrayList<ArrayList<TeamVO>> getSeasonHotTeams();
	public ArrayList<PlayerVO> getTodayAllPlayers();
	public ArrayList<PlayerVO> getTodayHotPlayers();
	
}
