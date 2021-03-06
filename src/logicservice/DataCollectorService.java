package logicservice;

import java.util.ArrayList;

import logic.PlayerController;
import vo.PlayerVO;
import vo.TeamVO;

public interface DataCollectorService {
//	public ArrayList<ArrayList<PlayerVO>> getSeasonHotPlayers();
//	public ArrayList<ArrayList<TeamVO>> getSeasonHotTeams();
		public ArrayList<PlayerVO> getSeasonHotPlayers_Score() ;
		public ArrayList<PlayerVO> getSeasonHotPlayers_Rebound();
		public ArrayList<PlayerVO> getSeasonHotPlayers_Assist() ;
		public ArrayList<PlayerVO> getSeasonHotPlayers_Block();
		public ArrayList<PlayerVO> getSeasonHotPlayers_Steal() ;
		public ArrayList<PlayerVO> getSeasonHotPlayers_3FGP() ;
		public ArrayList<PlayerVO> getSeasonHotPlayers_FGP();
		public ArrayList<PlayerVO> getSeasonHotPlayers_FTGP() ;
		public ArrayList<PlayerVO> getSeasonHotPlayers_GmScER() ;
		
		public ArrayList<TeamVO> getSeasonHotTeams_Score();
		public ArrayList<TeamVO> getSeasonHotTeams_Rebound();
		public ArrayList<TeamVO> getSeasonHotTeams_Assist();
		public ArrayList<TeamVO> getSeasonHotTeams_Block();
		public ArrayList<TeamVO> getSeasonHotTeams_Steal() ;
		
		public ArrayList<PlayerVO> getSeasonHotPlayers_AverScore();
		public ArrayList<PlayerVO> getSeasonHotPlayers_AverRebound();
		public ArrayList<PlayerVO> getSeasonHotPlayers_AverAssist();
		public ArrayList<PlayerVO> getSeasonHotPlayers_AverBlock();
		public ArrayList<PlayerVO> getSeasonHotPlayers_AverSteal() ;
		
		
		public ArrayList<TeamVO> getSeasonHotTeams_3FGP() ;
		public ArrayList<TeamVO> getSeasonHotTeams_FGP();
		public ArrayList<TeamVO> getSeasonHotTeams_FTGP() ;
		
		public ArrayList<PlayerVO> getSomeDayPlayers_Score(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_Rebound(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_Assist(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_Block(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_Steal(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_GmScER(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_FGP(String date) ;
		
		public ArrayList<PlayerVO> getSomeDayAllPlayers(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_3FGP(String date);
		public ArrayList<PlayerVO> getSomeDayPlayers_FTGP(String date);
}
