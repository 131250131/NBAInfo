package data.matchdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
import Utibility.FilePathSaver;


import DataService.MatchDataService;

public class MatchReader implements MatchDataService{
	private ArrayList<MatchPO> matches=new ArrayList<MatchPO>();
	private ArrayList<PlayerPO> leftplayerlist=new ArrayList<PlayerPO>();
	private ArrayList<PlayerPO> rightplayerlist=new ArrayList<PlayerPO>();
	private String leftTeamShortName="";
	private String rightTeamShortName="";

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
			int count = 0;   //用于判断是客队还是主队球员,为1时左队，为2时右队
			//每次处理比赛的初始化
			String[] a = matchFile[i].toString().split("_");
			String season =a[0];
			match.setSeason(season);
			//得到赛季
			try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	        while((lineTxt = bufferedReader.readLine()) != null){
	        	String[] context=lineTxt.split("/;");
	        	if(context.length==1){
	        		count++;
	        	}
	        	if(context.length==3){
	        		String date =context[0];
	        		match.setDate(date);
	        		String score=context[2];
	        		match.setScore(score);
	        		String[] teamname=context[1].split("/-");
	        		leftTeamShortName=teamname[0];
	        		rightTeamShortName=teamname[1];
	        	}
	        	if(context.length==4){
	        		String scores1=context[0];
	        		String scores2=context[1];
	        		String scores3=context[2];
	        		String scores4=context[3];
	        		match.setScores1(scores1);
	        		match.setScores2(scores2);
	        		match.setScores3(scores3);
	        		match.setScores4(scores4);
	        	}
	        	if(context.length==18){
	        		if(count==1){
	        			try{
	        			String teamname=leftTeamShortName;
	        			String playername=context[0];
	        			String position=context[1];
	        			String[] timestring=context[2].split("/:");
	        			int minute =Integer.parseInt(timestring[0])*60;
	        			int second =Integer.parseInt(timestring[1]);
	        			int time =minute + second;
	        			int playerFG = Integer.parseInt(context[3]);
	        			int playerFGTry = Integer.parseInt(context[4]);
	        			int player3FG = Integer.parseInt(context[5]);
	        			int player3FGTry = Integer.parseInt(context[6]);
	        			int playerFTG = Integer.parseInt(context[7]);
	        			int playerFTGTry = Integer.parseInt(context[8]);
	        			int playerOffenceRebounds = Integer.parseInt(context[9]);
	        			int playerDeffenceRebounds = Integer.parseInt(context[10]);
	        			int playerTotalRebounds = Integer.parseInt(context[11]);
	        			int playerAssists = Integer.parseInt(context[12]);
	        			int playerSteals = Integer.parseInt(context[13]);
	        			int playerBlocks = Integer.parseInt(context[14]);
	        			int playerTurnovers = Integer.parseInt(context[15]);
	        			int playerFouls = Integer.parseInt(context[16]);
	        			int playerScores = Integer.parseInt(context[17]);
	        			PlayerPO player =playerdataoperator(playername,teamname,time, playerFG, playerFGTry, player3FG, player3FGTry, 
	        					playerFTG, playerFTGTry, playerOffenceRebounds, playerDeffenceRebounds, playerTotalRebounds,
	        					playerAssists, playerSteals, playerBlocks, playerTurnovers, playerFouls, playerScores);
	        			match.addplayer(player);
	        			leftplayerlist.add(player);
	        			}
	        			catch(Exception e){
	        				System.out.println("数据出错");
	        			}
	        		}
	        		if(count==2){
	        			try{
		        			String teamname=rightTeamShortName;
		        			String playername=context[0];
		        			String position=context[1];
		        			String[] timestring=context[2].split("/:");
		        			int minute =Integer.parseInt(timestring[0])*60;
		        			int second =Integer.parseInt(timestring[1]);
		        			int time =minute + second;
		        			int playerFG = Integer.parseInt(context[3]);
		        			int playerFGTry = Integer.parseInt(context[4]);
		        			int player3FG = Integer.parseInt(context[5]);
		        			int player3FGTry = Integer.parseInt(context[6]);
		        			int playerFTG = Integer.parseInt(context[7]);
		        			int playerFTGTry = Integer.parseInt(context[8]);
		        			int playerOffenceRebounds = Integer.parseInt(context[9]);
		        			int playerDeffenceRebounds = Integer.parseInt(context[10]);
		        			int playerTotalRebounds = Integer.parseInt(context[11]);
		        			int playerAssists = Integer.parseInt(context[12]);
		        			int playerSteals = Integer.parseInt(context[13]);
		        			int playerBlocks = Integer.parseInt(context[14]);
		        			int playerTurnovers = Integer.parseInt(context[15]);
		        			int playerFouls = Integer.parseInt(context[16]);
		        			int playerScores = Integer.parseInt(context[17]);
		        			PlayerPO player =playerdataoperator(playername,teamname,time, playerFG, playerFGTry, player3FG, player3FGTry, 
		        					playerFTG, playerFTGTry, playerOffenceRebounds, playerDeffenceRebounds, playerTotalRebounds,
		        					playerAssists, playerSteals, playerBlocks, playerTurnovers, playerFouls, playerScores);
		        			match.addplayer(player);
		        			rightplayerlist.add(player);
		        			}
		        			catch(Exception e){
		        				System.out.println("数据出错");
		        			}
	        		}
	        	}
	        	 
	        }
			}catch(Exception e){
				System.out.println(e);
			}
			/*下面处理球队
			 * 
			 */
			TeamPO leftteam =teamdataoperator("left");
			TeamPO rightteam =teamdataoperator("right");
			match.setLeftTeam(leftteam);
			match.setRightTeam(rightteam);
			matches.add(match);
		}
		/*序列化
		 * 
		 */
		
		try {
			FileOutputStream fos = new FileOutputStream("MatchList");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(matches);
            oos.close();                  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
	@Override
	public ArrayList<MatchPO> getAllMatch() {
		// TODO Auto-generated method stub
		 ArrayList<MatchPO> result =new ArrayList<MatchPO>();
		 try{
		 FileInputStream fis = new FileInputStream("MatchList");
         ObjectInputStream ois = new ObjectInputStream(fis);
         result= (ArrayList<MatchPO>) ois.readObject();
		 }catch(Exception e){
			 System.out.println(e);
			 return null;
		 }
		return result;
	}
	
	
	
	@Override
	public boolean Matchupdate() {
		// TODO Auto-generated method stub
		
		return true;
	}
	@Override
	public PlayerPO playerdataoperator(String name,String team,int time, int FG, int FGTry,
			int threeFG, int threeFGTry, int FTG, int FTGTry,
			int offenceRebounds, int deffenceRebounds, int totalRebounds,
			int assists, int steals, int blocks, int turnovers, int fouls,
			int scores) {
		// TODO Auto-generated method stub
		PlayerPO player=new PlayerPO();
		player.updatePlayer(name, team, time, FG, FGTry, threeFG, threeFGTry, FTG, FTGTry, offenceRebounds, deffenceRebounds, totalRebounds, assists, steals, blocks, turnovers, fouls, scores);
		return player;
	}
	@Override
	public TeamPO teamdataoperator(String type) {
		// TODO Auto-generated method stub
		TeamPO team =new TeamPO();
		int teamFG = 0;
		int teamFGTry = 0;
		int team3FG = 0;
		int team3FGTry = 0;
		int teamFTG = 0;
		int teamFTGTry = 0;
		int teamOffenceRebounds = 0;
		int teamDeffenceRebounds = 0;
		int teamTotalRebounds = 0;
		int teamAssists = 0;
		int teamSteals = 0;
		int teamBlocks = 0;
		int teamTurnovers = 0;
		int teamFouls = 0;
		int teamScores = 0;
		if(type.equals("left")){
			for(PlayerPO p:leftplayerlist){
				 teamFG = teamFG+p.getPlayerFG();
				 teamFGTry = teamFGTry+p.getPlayer3FG();
				 team3FG = team3FG+p.getPlayer3FG();
				 team3FGTry = team3FGTry+p.getPlayer3FGTry();
				 teamFTG = teamFTG+p.getPlayerFTG();
				 teamFTGTry = teamFTGTry+p.getPlayerFTGTry();
				 teamOffenceRebounds = teamOffenceRebounds+p.getPlayerOffenceRebounds();
				 teamDeffenceRebounds = teamDeffenceRebounds+p.getPlayerDeffenceRebounds();
				 teamTotalRebounds = teamTotalRebounds+p.getPlayerTotalRebounds();
				 teamAssists = teamAssists+p.getPlayerAssists();
				 teamSteals = teamSteals+p.getPlayerSteals();
				 teamBlocks = teamBlocks+p.getPlayerBlocks();
				 teamTurnovers = teamTurnovers+p.getPlayerTurnovers();
				 teamFouls = teamFouls+p.getPlayerFouls();
				 teamScores = teamScores+p.getScores();
			}
		}
		else if(type.equals("right")){
			for(PlayerPO p:rightplayerlist){
				 teamFG = teamFG+p.getPlayerFG();
				 teamFGTry = teamFGTry+p.getPlayer3FG();
				 team3FG = team3FG+p.getPlayer3FG();
				 team3FGTry = team3FGTry+p.getPlayer3FGTry();
				 teamFTG = teamFTG+p.getPlayerFTG();
				 teamFTGTry = teamFTGTry+p.getPlayerFTGTry();
				 teamOffenceRebounds = teamOffenceRebounds+p.getPlayerOffenceRebounds();
				 teamDeffenceRebounds = teamDeffenceRebounds+p.getPlayerDeffenceRebounds();
				 teamTotalRebounds = teamTotalRebounds+p.getPlayerTotalRebounds();
				 teamAssists = teamAssists+p.getPlayerAssists();
				 teamSteals = teamSteals+p.getPlayerSteals();
				 teamBlocks = teamBlocks+p.getPlayerBlocks();
				 teamTurnovers = teamTurnovers+p.getPlayerTurnovers();
				 teamFouls = teamFouls+p.getPlayerFouls();
				 teamScores = teamScores+p.getScores();
			}
		}
		team.setTeamFG(teamFG);
		team.setTeamFTGTry(teamFTGTry);
		team.setTeam3FG(team3FG);
		team.setTeam3FGTry(team3FGTry);
		team.setTeamFTG(teamFTG);
		team.setTeamFTGTry(teamFTGTry);
		team.setTeamOffenceRebounds(teamOffenceRebounds);
		team.setTeamDeffenceRebounds(teamDeffenceRebounds);
		team.setTeamTotalRebounds(teamTotalRebounds);
		team.setTeamAssists(teamAssists);
		team.setTeamSteals(teamSteals);
		team.setTeamBlocks(teamBlocks);
		team.setTeamTurnovers(teamTurnovers);
		team.setTeamFouls(teamFouls);
		team.setTeamScores(teamScores);
		return team;
	}
	
	


		
	
			

	}
        

