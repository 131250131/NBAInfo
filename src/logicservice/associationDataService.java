package logicservice;

import java.sql.Date;
import java.util.ArrayList;

public interface associationDataService {
	public ArrayList<Date> getDateList();
	
	
	public double getAver_playerAssists();
	public double getAver_playerPlayTime();
	public double getAver_playerFG();
	public double getAver_playerFGTry() ;
	public double getAver_player3FG() ;
	public double getAver_player3FGTry() ;
	public double getAver_playerFTG();
	public double getAver_playerFTGTry();
	public double getAver_playerOffenceRebounds();
	public double getAver_playerDeffenceRebounds() ;
	public double getAver_playerTotalRebounds() ;
	public double getAver_playerSteals();
	public double getAver_playerBlocks();
	public double getAver_playerTurnovers();
	public double getAver_playerFouls();
	public double getPlayerFGP();
	public double getPlayer3FGP();
	public double getPlayerFTGP();
	public double getPlayerPER();
//	public double getPlayerGmScER();
//	public double getPlayerTSP();
//	public double getPlayerSER();
	
	public int getscreenWidth();
    public void setwh(int w,int h);
    public void	writewh();
	public int getscreenHeight();

	
	public double getAver_teamAssists();
	public double getAver_teamFG();
	public double getAver_teamFGTry();
	public double getTeamFGP();
	public double getAver_team3FG();
	public double getAver_team3FGTry();
	public double getTeam3FGP();
	public double getAver_teamFTG();
	public double getAver_teamFTGTry();
	public double getTeamFTGP();
	public double getAver_teamOffenceRebounds();
	public double getAver_teamDeffenceRebounds();
	public double getAver_teamTotalRebounds();
	public double getAver_teamSteals();
	public double getAver_teamBlocks();
	public double getAver_teamTurnovers();
	public double getAver_teamFouls();
	public double getAver_teamScores();
}
