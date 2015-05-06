package logicservice;

import java.util.ArrayList;

import vo.TeamVO;

public interface teamControllerService {
		public ArrayList<TeamVO> getSeasonAllTeamInfo();//获取球队
		public TeamVO getOneTeamInfo(String shortName);//获得某一队的具体信息
		public ArrayList<TeamVO> getSeasonHotTeams_Score();
		public ArrayList<TeamVO> getSeasonHotTeams_Rebound();
		public ArrayList<TeamVO> getSeasonHotTeams_Assist();
		public ArrayList<TeamVO> getSeasonHotTeams_Block();
		public ArrayList<TeamVO> getSeasonHotTeams_Steal();
		public ArrayList<TeamVO> getSeasonHotTeams_3FGP();
		public ArrayList<TeamVO> getSeasonHotTeams_FGP();
		public ArrayList<TeamVO> getSeasonHotTeams_FTGP();
		public ArrayList<TeamVO> gethomeraterank();
		public ArrayList<TeamVO> getguestraterank();
		public ArrayList<TeamVO> getteamrank();
}
