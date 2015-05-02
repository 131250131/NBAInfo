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

import logic.Player;
import po.MatchPO;
import po.PlayerPO;
import po.TeamPO;
import Utibility.FilePathSaver;


import Utibility.JudgeUpdate;
import DataService.MatchDataService;

public class Matchdata implements MatchDataService{
	private ArrayList<MatchPO> matches=new ArrayList<MatchPO>();
	private ArrayList<PlayerPO> leftplayerlist=new ArrayList<PlayerPO>();
	private ArrayList<PlayerPO> rightplayerlist=new ArrayList<PlayerPO>();
	private ArrayList<Integer>  wrong=new ArrayList<Integer>();
	private String leftTeamShortName="";
	private String rightTeamShortName="";
    int matchnum=0;
	FilePathSaver pathSaver = new FilePathSaver();
	private String filePath = pathSaver.getMatchFilePath();
	private int lscore=0;
	private int rscore=0;
	private int lhalfscore=0;
	private int rhalfscore=0;
	@Override
	public void readMatch() {
		// TODO Auto-generated method stub
		
		File file = new File(filePath);                
		File[] matchFile = file.listFiles();
		int index = 0;
		for(int i = 0; i < matchFile.length; i++){
			MatchPO match=new MatchPO();
			int count = 0;   //用于判断是客队还是主队球员,为1时左队，为2时右队
			int line=0;
			//每次处理比赛的初始化
			String[] a = matchFile[i].toString().split("_");
			String season =a[0];
			match.setSeason(season);
			//得到赛季
			try{
			InputStreamReader read = new InputStreamReader(new FileInputStream(matchFile[i]),"UTF-8");
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	        while((lineTxt = bufferedReader.readLine() ) != null){
	        	String[] context=lineTxt.split(";");
	        	System.out.println(lineTxt);
	        	//System.out.println(context.length);
	        	if(context.length==1){
	        	
	        		count++;
	        	}
	        	if(context.length==3){
	        	
	        		String date =context[0];
	        		match.setDate(date);
	        		String score=context[2];
	        		match.setScore(score);
	        		String[] s=score.split("-");
	        		String ls=s[0];
	        		String rs=s[1];
	        		lscore =Integer.parseInt(ls);
	        		//System.out.println(lscore);
	        		rscore =Integer.parseInt(rs);
	        		String[] teamname=context[1].split("-");
	        		leftTeamShortName=teamname[0];
	        		rightTeamShortName=teamname[1];
	        		line++;
	        	}
	        	if(line==2){
	        		String scores1=context[0];
	        		String scores2=context[1];
	        		String scores3=context[2];
	        		String scores4=context[3];
	        		String[] s1=scores1.split("-");
	        		String[] s2=scores2.split("-");
	        		int lsc1=Integer.parseInt(s1[0]);
	        		int lsc2=Integer.parseInt(s2[0]);
	        		int rsc1=Integer.parseInt(s1[1]);
	        		int rsc2=Integer.parseInt(s2[1]);
	        		lhalfscore=lsc1+lsc2;
	        		rhalfscore=rsc1+rsc2;
	        		match.setScores1(scores1);
	        		match.setScores2(scores2);
	        		match.setScores3(scores3);
	        		match.setScores4(scores4);
	        		//处理加时
	        		if(context.length>4){
	        			ArrayList<String> exs=new ArrayList<String>();
	        			for(int k=4;k<context.length;k++){
	        				exs.add(context[k]);
	        			}
	        			int left=0;
	        			int right=0;
	        			for(String p:exs){
	        				String[] s=p.split("-");
	        				 left=left+Integer.parseInt(s[0]);
	        				 right=right+Integer.parseInt(s[1]);
	        			}
	        			match.setExtrascores(String.valueOf(left)+"-"+String.valueOf(right));
	        		}
	        		line++;
	        	}
	        	if(context.length==18){
	        
	        		if(count==1){
	        			try{
	        			String teamname=leftTeamShortName;
	        			String playername=context[0];
	        			String position=context[1];
	        			String[] timestring=context[2].split(":");
	        			//System.out.println(timestring[0]);
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
	        			match.addleftplayer(player);
	        			player.addAttendedMatches(matchnum);
	        			leftplayerlist.add(player);
	        			}
	        			catch(Exception e){
	        				e.printStackTrace();
	        				break;
	        			}
	        		}
	        		if(count==2){
	        			try{
		        			String teamname=rightTeamShortName;
		        			String playername=context[0];
		        			String position=context[1];
		        			String[] timestring=context[2].split(":");
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
		        			match.addrightplayer(player);
		        			player.addAttendedMatches(matchnum);
		        			rightplayerlist.add(player);
		        			}
		        			catch(Exception e){
		        				e.printStackTrace();
		        				break;
		        			}
	        		}
	        	}
	        	 
	        }
	        match.setNum(matchnum);
        	matchnum++;
			}catch(Exception e){
				e.printStackTrace();
				break;
			}
			/*下面处理球队
			 * 
			 */
			TeamPO leftteam =teamdataoperator("left");
			TeamPO rightteam =teamdataoperator("right");	
			if(leftteam.getTeamFGTry()!=0){
					if(leftteam.getTeamFG()/leftteam.getTeamFGTry()>rightteam.getTeamFG()/rightteam.getTeamFGTry()  
						&& lscore>rscore	){
						leftteam.addwinMoreFGP();
					}
					if(leftteam.getTeamFG()/leftteam.getTeamFGTry()>rightteam.getTeamFG()/rightteam.getTeamFGTry()  
			    		&& lscore<rscore	){
			    		leftteam.addloseMoreFGP();
		    		}
		    		if(leftteam.getTeamFG()/leftteam.getTeamFGTry()<rightteam.getTeamFG()/rightteam.getTeamFGTry()  
			    		&& lscore>rscore	){
			    		rightteam.addloseMoreFGP();
		    		}
		    		if(leftteam.getTeamFG()/leftteam.getTeamFGTry()<rightteam.getTeamFG()/rightteam.getTeamFGTry()  
			    		&& lscore<rscore	){
			    		rightteam.addwinMoreFGP();
			    	}
			}
		    if(leftteam.getTeamTotalRebounds()>rightteam.getTeamTotalRebounds() && lscore>rscore){
		    	  leftteam.addwinMoreRebounds();
		    }
		    if(leftteam.getTeamTotalRebounds()>rightteam.getTeamTotalRebounds() && lscore<rscore){
		    	  leftteam.addloseMoreRebounds();
		    }
		    if(leftteam.getTeamTotalRebounds()>rightteam.getTeamTotalRebounds() && lscore>rscore){
		    	  rightteam.addloseMoreRebounds();
		    }
		    if(leftteam.getTeamTotalRebounds()>rightteam.getTeamTotalRebounds() && lscore<rscore){
		    	  rightteam.addwinMoreRebounds();
		    }
		    if(leftteam.getTeamTurnovers()<rightteam.getTeamTurnovers() && lscore>rscore){
		    	  leftteam.addwinLessTurnovers();
		    }
		    if(leftteam.getTeamTurnovers()<rightteam.getTeamTurnovers() && lscore<rscore){
		    	  leftteam.addloseLessTurnovers();
		    }
		    if(leftteam.getTeamTurnovers()<rightteam.getTeamTurnovers() && lscore>rscore){
		    	  rightteam.addloseLessTurnovers();
		    }
		    if(leftteam.getTeamTurnovers()<rightteam.getTeamTurnovers() && lscore<rscore){
		    	  rightteam.addwinLessTurnovers();
		    }
		    if(lscore>rscore){
		    	leftteam.addwinGuest();
		    	rightteam.addloseHome();
		    	match.setWinteamname(leftteam.getTeamName());
		    	leftteam.addwinWin_lose();
		    	rightteam.addloseWin_lose();
		    }
		    if(lscore<rscore){
		    	leftteam.addloseGuest();
		    	rightteam.addwinHome();
		    	match.setWinteamname(rightteam.getTeamName());
		    	leftteam.addloseWin_lose();
		    	rightteam.addwinWin_lose();
		    }
		    if(lhalfscore>rhalfscore && lscore<rscore){
		    	leftteam.addloseBanchanglingxian();
		    }
		    if(lhalfscore>rhalfscore && lscore>rscore){
		    	leftteam.addwinBanchanglingxian();
		    }
		    if(lhalfscore<rhalfscore && lscore<rscore){
		    	rightteam.addwinBanchanglingxian();
		    }
		    if(lhalfscore<rhalfscore && lscore>rscore){
		    	rightteam.addloseBanchanglingxian();
		    }
		    if(lhalfscore<rhalfscore && lscore<rscore){
		    	leftteam.addloseBanchangluohou();
		    }
		    if(lhalfscore<rhalfscore && lscore>rscore){
		    	leftteam.addwinBanchangluohou();
		    }
		    if(lhalfscore>rhalfscore && lscore<rscore){
		    	rightteam.addwinBanchangluohou();
		    }
		    if(lhalfscore>rhalfscore && lscore>rscore){
		    	rightteam.addloseBanchangluohou();
		    }
			match.setLeftTeam(leftteam);
			match.setRightTeam(rightteam);
			matches.add(match);
		}  
	}
	@Override
	public ArrayList<MatchPO> getAllMatch() {
		// TODO Auto-generated method stub
		return this.matches;
	}
	
	
	
	@Override
	public boolean Matchupdate() {
		// TODO Auto-generated method stub
		JudgeUpdate hasupdate=new JudgeUpdate(filePath);
		hasupdate.run();
		return hasupdate.getHasupdate();
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
			team.addAttendmatches(matchnum);
			if(lscore>rscore&&lscore>100){
				team.addwinMyTeamMoreThan100();
			}
			if(lscore<rscore&&lscore>100){
				team.addloseMyTeamMoreThan100();
			}
			if(lscore>rscore&&rscore>100){
				team.addwinOppoTeamMoreThan100();
			}
			if(lscore<rscore&&rscore>100){
				team.addloseOppoTeamMoreThan100();
			}
			if(Math.abs(lscore-rscore)<3&&lscore>rscore){
				team.addwintLessThan3Points();
			}
			if(Math.abs(lscore-rscore)<3&&lscore<rscore){
				team.addlosetLessThan3Points();
			}
			if(Math.abs(lscore-rscore)>10&&lscore<rscore){
				team.addloseMoreThan10Points();
			}
			if(Math.abs(lscore-rscore)>10&&lscore>rscore){
				team.addwinMoreThan10Points();
			}
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
			team.addAttendmatches(matchnum);
			if(rscore>lscore&&rscore>100){
				team.addwinMyTeamMoreThan100();
			}
			if(rscore<lscore&&rscore>100){
				team.addloseMyTeamMoreThan100();
			}
			if(lscore>rscore&&lscore>100){
				team.addloseOppoTeamMoreThan100();
			}
			if(lscore<rscore&&lscore>100){
				team.addwinOppoTeamMoreThan100();
			}
			if(Math.abs(lscore-rscore)<3&&lscore>rscore){
				team.addlosetLessThan3Points();
			}
			if(Math.abs(lscore-rscore)<3&&lscore<rscore){
				team.addwintLessThan3Points();
			}
			if(Math.abs(lscore-rscore)>10&&lscore>rscore){
				team.addloseMoreThan10Points();
			}
			if(Math.abs(lscore-rscore)>10&&lscore<rscore){
				team.addwinMoreThan10Points();
			}
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
	@Override
	public MatchPO getMatchbynum(int number) {
		ArrayList<MatchPO> temp =new ArrayList<MatchPO>();
		try{
		FileInputStream fis = new FileInputStream("MatchList");
        ObjectInputStream ois = new ObjectInputStream(fis);
        temp = (ArrayList<MatchPO>)ois.readObject();
        for(MatchPO m:temp){
        	if(number==m.getNum()){
        		return m;
        	}
        }
        return null;
		}catch(Exception e){
			return null;
		}
		
	}
	
	
	
	


		
	
			

	}
        

