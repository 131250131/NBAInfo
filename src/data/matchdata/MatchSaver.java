package data.matchdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import po.MatchPO;
import po.TeamPO;
import Utibility.FilePathSaver;


import DataService.MatchDataService;

public class MatchSaver implements MatchDataService{
	private ArrayList<MatchPO> matches=new ArrayList<MatchPO>();
	
	private String leftTeamShortName, rightTeamShortName;
	private int leftTeamScore = 0, rightTeamScore = 0;
	private int leftTeamTime = 0, rightTeamTime = 0;
	private int leftTeamFG = 0, rightTeamFG = 0;
	private int leftTeamFGTry = 0, rightTeamFGTry = 0;
	private int leftTeam3FG = 0, rightTeam3FG = 0;
	private int leftTeam3FGTry = 0, rightTeam3FGTry = 0;
	private int leftTeamFTG = 0, rightTeamFTG = 0;
	private int leftTeamFTGTry = 0, rightTeamFTGTry = 0;
	private int leftTeamOffenceRebounds = 0, rightTeamOffenceRebounds = 0;
	private int leftTeamDeffenceRebounds = 0, rightTeamDeffenceRebounds = 0;
	private int leftTeamTotalRebounds = 0, rightTeamTotalRebounds = 0;
	private int leftTeamAssists = 0, rightTeamAssists = 0;
	private int leftTeamSteals = 0, rightTeamSteals = 0;
	private int leftTeamBlocks = 0, rightTeamBlocks = 0;
	private int leftTeamTurnovers = 0, rightTeamTurnovers = 0;
	private int leftTeamFouls = 0, rightTeamFouls = 0;
	private double leftOffenceTimes = 0, rightOffenceTimes = 0;
	private int counter = 0;
	private String[] playerName = new String[30];
	private int[] playerTime = new int[30];
	private boolean[] playerIsStart = new boolean[30];
	private int[] playerFG = new int[30];
	private int[] playerFGTry = new int[30];
	private int[] player3FG = new int[30];
	private int[] player3FGTry = new int[30];
	private int[] playerFTG = new int[30];
	private int[] playerFTGTry = new int[30];
	private int[] playerOffenceRebounds = new int[30];
	private int[] playerDeffenceRebounds = new int[30];
	private int[] playerTotalRebounds = new int[30];
	private int[] playerAssists = new int[30];
	private int[] playerSteals = new int[30];
	private int[] playerBlocks = new int[30];
	private int[] playerTurnovers = new int[30];
	private int[] playerFouls = new int[30];
	private int[] playerScores = new int[30];
	private boolean isLeft = true;
	private int leftRightSwitchPoint = 0;
	
	
	FilePathSaver pathSaver = new FilePathSaver();
	private String filePath = pathSaver.getMatchFilePath();
	
	@Override
	public void readMatch() {
		// TODO Auto-generated method stub
		File file = new File(filePath);                
		File[] matchFile = file.listFiles();
		int index = 0;
		for(int i = 0; i < matchFile.length; i++){
			MatchPO match=new MatchPO();
			String[] a = matchFile[i].toString().split("_");
			String seasons =a[0];
			try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	        while((lineTxt = bufferedReader.readLine()) != null){
	        	 //match.set()
	        }
			}catch(Exception e){
				System.out.println(e);
			}
			matches.add(match);
		}
	}
	@Override
	public ArrayList<MatchPO> getAllMatch() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public boolean Matchupdate() {
		// TODO Auto-generated method stub
		
		return true;
	}
	
	


		
	
			

	}
        

