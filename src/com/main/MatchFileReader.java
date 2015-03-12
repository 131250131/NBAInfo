package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


public class MatchFileReader {
	
	//在此处设定文件夹路径
	String path = "data/data/matches";
	Searcher searcher;
	
	public MatchFileReader(Searcher _searcher){
		searcher = _searcher;
	}
	
	public void readAll() throws Exception{
		
		//该方法将会读取比赛信息文件夹中所有球员的信息
		File file = new File(path);                
		File[] matchFile = file.listFiles();       
		for(int i = 0; i < matchFile.length; i++)
			readOne(matchFile[i]);	
	}
	
	private void readOne(File file) throws IOException, FileNotFoundException{

		//该方法将会对每一当场比赛信息进行读取工作
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            operateMatchTxt(lineTxt, lineNumber++);
        }
        
        sentMatchInfo();
        
        read.close();
	}
	

	String leftTeamShortName, rightTeamShortName;
	int leftTeamScore = 0, rightTeamScore = 0;
	int leftTeamTime = 0, rightTeamTime = 0;
	int leftTeamFG = 0, rightTeamFG = 0;
	int leftTeamFGTry = 0, rightTeamFGTry = 0;
	int leftTeam3FG = 0, rightTeam3FG = 0;
	int leftTeam3FGTry = 0, rightTeam3FGTry = 0;
	int leftTeamFTG = 0, rightTeamFTG = 0;
	int leftTeamFTGTry = 0, rightTeamFTGTry = 0;
	int leftTeamOffenceRebounds = 0, rightTeamOffenceRebounds = 0;
	int leftTeamDeffenceRebounds = 0, rightTeamDeffenceRebounds = 0;
	int leftTeamTotalRebounds = 0, rightTeamTotalRebounds = 0;
	int leftTeamAssists = 0, rightTeamAssists = 0;
	int leftTeamSteals = 0, rightTeamSteals = 0;
	int leftTeamBlocks = 0, rightTeamBlocks = 0;
	int leftTeamTurnovers = 0, rightTeamTurnovers = 0;
	int leftTeamFouls = 0, rightTeamFouls = 0;
	double leftOffenceTimes = 0, rightOffenceTimes = 0;
	
	int counter = 0;
	String[] playerName = new String[30];
	int[] playerTime = new int[30];
	boolean[] playerIsStart = new boolean[30];
	int[] playerFG = new int[30];
	int[] playerFGTry = new int[30];
	int[] player3FG = new int[30];
	int[] player3FGTry = new int[30];
	int[] playerFTG = new int[30];
	int[] playerFTGTry = new int[30];
	int[] playerOffenceRebounds = new int[30];
	int[] playerDeffenceRebounds = new int[30];
	int[] playerTotalRebounds = new int[30];
	int[] playerAssists = new int[30];
	int[] playerSteals = new int[30];
	int[] playerBlocks = new int[30];
	int[] playerTurnovers = new int[30];
	int[] playerFouls = new int[30];
	int[] playerScores = new int[30];
	
	boolean isLeft = true;
	int leftRightSwitchPoint = 0;
	
	private void initInfo(){
		leftTeamScore = 0; rightTeamScore = 0;
		leftTeamTime = 0; rightTeamTime = 0;
		leftTeamFG = 0; rightTeamFG = 0;
		leftTeamFGTry = 0; rightTeamFGTry = 0;
		leftTeam3FG = 0; rightTeam3FG = 0;
		leftTeam3FGTry = 0; rightTeam3FGTry = 0;
		leftTeamFTG = 0; rightTeamFTG = 0;
		leftTeamFTGTry = 0; rightTeamFTGTry = 0;
		leftTeamOffenceRebounds = 0; rightTeamOffenceRebounds = 0;
		leftTeamDeffenceRebounds = 0; rightTeamDeffenceRebounds = 0;
		leftTeamTotalRebounds = 0; rightTeamTotalRebounds = 0;
		leftTeamAssists = 0; rightTeamAssists = 0;
		leftTeamSteals = 0; rightTeamSteals = 0;
		leftTeamBlocks = 0; rightTeamBlocks = 0;
		leftTeamTurnovers = 0; rightTeamTurnovers = 0;
		leftTeamFouls = 0; rightTeamFouls = 0;
		leftOffenceTimes = 0; rightOffenceTimes = 0;
		
	    counter = 0;
		
		isLeft = true;
		leftRightSwitchPoint = 0;
	}
	
	private void operateMatchTxt(String lineTxt, int lineNumber){
		if(lineNumber == 0){
			
			initInfo();
			
			System.out.println(lineTxt + (-(Main.T - (double)System.currentTimeMillis())/1000) + "s");
			
			String[] teamInfoStage1 = lineTxt.split(";");
			
			String[] teamInfoStage2 = teamInfoStage1[1].split("-");
			leftTeamShortName = teamInfoStage2[0];
			rightTeamShortName = teamInfoStage2[1];
			
			String[] teamInfoStage3 = teamInfoStage1[2].split("-");			
			leftTeamScore = Integer.parseInt(teamInfoStage3[0]);
			rightTeamScore = Integer.parseInt(teamInfoStage3[1]);
		}
		
		if(lineNumber > 2 && lineTxt.length() == 3){
			isLeft = false;
			leftRightSwitchPoint = lineNumber;
		}
		
		if(lineNumber > 2 && lineTxt.length() != 3){
			
			String[] playerInfo = lineTxt.split(";");
			
			playerName[counter] = playerInfo[0];
			
			if(playerInfo[1].length() > 0){
				playerIsStart[counter] = true;
			}else{
				playerIsStart[counter] = false;
			}
			
			playerTime[counter] = playTimeTransform(playerInfo[2]);
			playerFG[counter] = Integer.parseInt(playerInfo[3]);
			playerFGTry[counter] = Integer.parseInt(playerInfo[4]);
			player3FG[counter] = Integer.parseInt(playerInfo[5]);
			player3FGTry[counter] = Integer.parseInt(playerInfo[6]);
			playerFTG[counter] = Integer.parseInt(playerInfo[7]);
			playerFTGTry[counter] = Integer.parseInt(playerInfo[8]);
			playerOffenceRebounds[counter] = Integer.parseInt(playerInfo[9]);
			playerDeffenceRebounds[counter] = Integer.parseInt(playerInfo[10]);
			playerTotalRebounds[counter] = Integer.parseInt(playerInfo[11]);
			playerAssists[counter] = Integer.parseInt(playerInfo[12]);
			playerSteals[counter] = Integer.parseInt(playerInfo[13]);
			playerBlocks[counter] = Integer.parseInt(playerInfo[14]);
			playerTurnovers[counter] = Integer.parseInt(playerInfo[15]);
			playerFouls[counter] = Integer.parseInt(playerInfo[16]);
			if(!playerInfo[17].equals("null")){
				playerScores[counter] = Integer.parseInt(playerInfo[17]);
			}
			
			if(isLeft){
				leftTeamTime = leftTeamTime + playerTime[counter];
				leftTeamFG = leftTeamFG + playerFG[counter];
				leftTeamFGTry = leftTeamFGTry + playerFGTry[counter];
				leftTeam3FG = leftTeam3FG + player3FG[counter];
				leftTeam3FGTry = leftTeam3FGTry + player3FGTry[counter];
				leftTeamFTG = leftTeamFTG + playerFTG[counter];
				leftTeamFTGTry = leftTeamFTGTry + playerFTGTry[counter];
				leftTeamOffenceRebounds = leftTeamOffenceRebounds + playerOffenceRebounds[counter];
				leftTeamDeffenceRebounds = leftTeamDeffenceRebounds + playerDeffenceRebounds[counter];
				leftTeamTotalRebounds = leftTeamTotalRebounds + playerTotalRebounds[counter];
				leftTeamAssists = leftTeamAssists + playerAssists[counter];
				leftTeamSteals = leftTeamSteals + playerSteals[counter];
				leftTeamBlocks = leftTeamBlocks + playerBlocks[counter];
				leftTeamTurnovers = leftTeamTurnovers + playerTurnovers[counter];
				leftTeamFouls = leftTeamFouls + playerFouls[counter];
			}else{
				rightTeamTime = rightTeamTime + playerTime[counter];
				rightTeamFG = rightTeamFG + playerFG[counter];
				rightTeamFGTry = rightTeamFGTry + playerFGTry[counter];
				rightTeam3FG = rightTeam3FG + player3FG[counter];
				rightTeam3FGTry = rightTeam3FGTry + player3FGTry[counter];
				rightTeamFTG = rightTeamFTG + playerFTG[counter];
				rightTeamFTGTry = rightTeamFTGTry + playerFTGTry[counter];
				rightTeamOffenceRebounds = rightTeamOffenceRebounds + playerOffenceRebounds[counter];
				rightTeamDeffenceRebounds = rightTeamDeffenceRebounds + playerDeffenceRebounds[counter];
				rightTeamTotalRebounds = rightTeamTotalRebounds + playerTotalRebounds[counter];
				rightTeamAssists = rightTeamAssists + playerAssists[counter];
				rightTeamSteals = rightTeamSteals + playerSteals[counter];
				rightTeamBlocks = rightTeamBlocks + playerBlocks[counter];
				rightTeamTurnovers = rightTeamTurnovers + playerTurnovers[counter];
				rightTeamFouls = rightTeamFouls + playerFouls[counter];
			}
			counter++;
		}	
	}
	
	private int playTimeTransform(String time){
		if(!time.equals("null") && !time.equals("None")){
			String[] array = time.split(":");
	  		return Integer.parseInt(array[0]) * 60 + Integer.parseInt(array[1]);//单位秒
		}else{
			return 0;//先暂时写成这样
		}
	}
	

	private void sentMatchInfo() {
		leftOffenceTimes = leftTeamFGTry + 0.4 * leftTeamFTGTry - 1.07 * (leftTeamOffenceRebounds /
				(leftTeamOffenceRebounds + rightTeamDeffenceRebounds) * (leftTeamFGTry - leftTeamFG)) + 1.07 * leftTeamTurnovers;
		rightOffenceTimes = rightTeamFGTry + 0.4 * rightTeamFTGTry - 1.07 * (rightTeamOffenceRebounds /
				(rightTeamOffenceRebounds + leftTeamDeffenceRebounds) * (rightTeamFGTry - rightTeamFG)) + 1.07 * rightTeamTurnovers;

		
		
		for(int i = 0; i < counter; i++){
			
			Player tempPlayer = searcher.playerSearcher(playerName[i]);
			if(tempPlayer == null){
				Player newPlayer = new Player(playerName[i], null, null, null, null, null, null, null, null);
				searcher.getFinalAlaphPlayerList().add(newPlayer);
				searcher.getFinalPlayerList().set(searcher.getCurrentIndex(), searcher.getFinalAlaphPlayerList());
				tempPlayer = newPlayer;
			}
			
			if(i < leftRightSwitchPoint){
				tempPlayer.updatePlayer(playerTime[i], playerIsStart[i], playerFG[i], playerFGTry[i],
						player3FG[i], player3FGTry[i], playerFTG[i], playerFTGTry[i], playerOffenceRebounds[i],
						playerDeffenceRebounds[i], playerTotalRebounds[i], playerAssists[i], playerSteals[i],
						playerBlocks[i], playerTurnovers[i], playerFouls[i], playerScores[i], (leftTeamTime - playerTime[i]),
						leftTeamTotalRebounds, rightTeamTotalRebounds, leftTeamOffenceRebounds, rightTeamOffenceRebounds,
						leftTeamDeffenceRebounds, rightTeamDeffenceRebounds, leftTeamFG, leftTeamFGTry, (rightTeamFGTry - rightTeam3FGTry),
						leftTeamFTGTry, leftTeamTurnovers, rightOffenceTimes);
			}else{
				tempPlayer.updatePlayer(playerTime[i], playerIsStart[i], playerFG[i], playerFGTry[i],
						player3FG[i], player3FGTry[i], playerFTG[i], playerFTGTry[i], playerOffenceRebounds[i],
						playerDeffenceRebounds[i], playerTotalRebounds[i], playerAssists[i], playerSteals[i],
						playerBlocks[i], playerTurnovers[i], playerFouls[i], playerScores[i], (rightTeamTime - playerTime[i]),
						rightTeamTotalRebounds, leftTeamTotalRebounds, rightTeamOffenceRebounds, leftTeamOffenceRebounds,
						rightTeamDeffenceRebounds, leftTeamDeffenceRebounds, rightTeamFG, rightTeamFGTry, (leftTeamFGTry - leftTeam3FGTry),
						rightTeamFTGTry, rightTeamTurnovers, leftOffenceTimes);	
			}
			
			searcher.getFinalAlaphPlayerList().add(tempPlayer);
			searcher.getFinalPlayerList().set(searcher.getCurrentIndex(), searcher.getFinalAlaphPlayerList());				
		}
	}
	
}
