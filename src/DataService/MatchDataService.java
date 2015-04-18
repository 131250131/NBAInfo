package DataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
public interface MatchDataService {
	public void readMatch();
	public ArrayList<MatchPO> getAllMatch();
	public boolean Matchupdate();
	public PlayerPO playerdataoperator(String name,String team,int time, int FG, int FGTry, int threeFG, int threeFGTry,
			int FTG, int FTGTry, int offenceRebounds, int deffenceRebounds, int totalRebounds,
			int assists, int steals, int blocks, int turnovers, int fouls, int scores);
	public TeamPO teamdataoperator(String type);
	public MatchPO getMatchbynum(int number);
}
