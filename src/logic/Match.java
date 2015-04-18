package logic;

import java.util.ArrayList;

import po.MatchPO;
import po.PlayerPO;

import com.nba.registerList.RegisterList;

import data.matchdata.Matchdata;

public class Match {
public Object[][] getData(String team,int matchnum){
        Matchdata mr=new Matchdata();
        MatchPO match =mr.getMatchbynum(matchnum);
        ArrayList<PlayerPO> playerList =new ArrayList<PlayerPO>();
        if(match!=null){
		Object[][] data = new Object[RegisterList.getPlayerNumber()][30];
		if(team.equals("right")){
			playerList = match.getrightplayers();
		}
		else{
			playerList =match.getleftplayers();
		}
		int index = 0;
			int size = playerList.size();	
			for(int j = 0; j < size; j++){
				PlayerPO tempPlayer = playerList.get(j);
				data[index][0] = tempPlayer.getPlayerName();
				data[index][1] = tempPlayer.getTeamShortName();//所属球队
				//data[index][2] = tempPlayer.getPlayerAttends();
				//data[index][3] = tempPlayer.getPlayerStartTimes();
				data[index][2] = tempPlayer.getPlayerTotalRebounds();
				data[index][3] = tempPlayer.getPlayerOffenceRebounds();
				data[index][4] = tempPlayer.getPlayerDeffenceRebounds();
				data[index][5] = tempPlayer.getPlayerAssists();
				data[index][6] = tempPlayer.getPlayerPlayTime();
				data[index][7] = tempPlayer.getPlayerFG();
				data[index][8] = tempPlayer.getPlayer3FG();
				data[index][9] = tempPlayer.getPlayerFTG();
				data[index][10] = tempPlayer.getPlayerSteals();
				data[index][11] = tempPlayer.getPlayerBlocks();
				data[index][12] = tempPlayer.getPlayerTurnovers();
				data[index][13] = tempPlayer.getPlayerFouls();
				//data[index][16] = tempPlayer.getPlayerScores();
				//data[index][17] = tempPlayer.getPlayerPER();
				//data[index][18] = tempPlayer.getPlayerGmScER();
				//data[index][19] = tempPlayer.getPlayerTSP();
				//data[index][20] = tempPlayer.getPlayerSER();
				//data[index][21] = tempPlayer.getRR();
				//data[index][22] = tempPlayer.getO_RR();
				//data[index][23] = tempPlayer.getD_RR();
				//data[index][24] = tempPlayer.getAR();
				//data[index][25] = tempPlayer.getSR();
				//data[index][26] = tempPlayer.getBR();
				//data[index][27] = tempPlayer.getTR();
				//data[index][28] = tempPlayer.getUR();
				//data[index][29] = tempPlayer.getdouble_double();
				index++;
			}
		
		return data;
        }
        else{
        	return null;
        }
}
}
