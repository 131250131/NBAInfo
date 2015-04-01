package com.nba.registerList;

import java.util.ArrayList;

import com.nba.data.Player;
import com.nba.data.SetOfSort;
import com.nba.data.Team;
import com.nba.data.DataLoader;
import com.nba.data.DataSaver;


/*
 * 寄存器列表类，其中有个static的list，本软件中的所有操作都由这个寄存器列表来进行相关操作
 */
public class RegisterList {
	
	public static ArrayList<Object> saveList ;
	public static int currentIndexInPlayerList;
	public static int currentIndexInSaveList;
	public static int currentIndexInTeamList;
	
	//用于生成一个空的列表，以便后期加载至此
	public void initList(){
		saveList = new ArrayList<Object>();
	}	
	
	//从序列化中获取保存的列表，并加载到这个寄存器列表中
	public void getDataList(){
		DataLoader dataLoader = new DataLoader();
		saveList = dataLoader.loadingData();
	}
	
	//保存寄存器列表至序列化中
	public static void saveDataList(){
		DataSaver dataSaver = new DataSaver();
		dataSaver.saveData(saveList);
	}
	
	//用于通过球员名字进行搜索 来返回一个球员类
	public static Player getPlayerWithName(String _playerName){
		
		//判断球员保存在哪一个列表中，即A的在第0位,B在第1位 以此类推
		byte[] nameBytes = _playerName.getBytes();
		int currentIndex = nameBytes[0] - 65;
		currentIndexInSaveList = currentIndex;
		
		if(currentIndex < 0 || currentIndex >= 27){
			return null;
		}
		@SuppressWarnings("unchecked")
		ArrayList<Player> playerList = (ArrayList<Player>) saveList.get(currentIndex);
		
		//遍历列表 并找到球员
		int listSize = playerList.size();
		for(int i = 0; i < listSize; i++){
			Player temp_player = playerList.get(i);
			
			//如果找到球员则返回球员类
			if(temp_player.getPlayerName().equals(_playerName)){	
				currentIndexInPlayerList = i;
				return temp_player;
			}
		}	
		
		//若都找不到则返回“空”
		currentIndexInPlayerList = getCurrentAlphaList().size();
		return null;
	}
	
	//用于返回当前球员属于的列表
	@SuppressWarnings("unchecked")
	public static ArrayList<Player> getCurrentAlphaList(){
		return (ArrayList<Player>) saveList.get(currentIndexInSaveList);
	}
	
	//用于返回队伍的列表
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Team> getTeamList(){
		return (ArrayList<Team>) saveList.get(26);
	}
	
	
	//用队伍的简写来搜索并返回队伍
	public static Team getTeamWithShortName(String _shortName){
		
		@SuppressWarnings("unchecked")
		ArrayList<Team> teamList = (ArrayList<Team>) saveList.get(26);
		
		int listSize = teamList.size();
		for(int i = 0; i < listSize; i++){
			Team tempTeam = teamList.get(i);
			
			if(tempTeam.getTeamShortName().equals(_shortName)){
				currentIndexInTeamList = i;
				return tempTeam;
			}
		}
		return null;
	}
	
	//用来更新球员数据（将自动获取其位置）
	public static void updatePlayer(Player tempPlayer){
		getCurrentAlphaList().set(currentIndexInPlayerList, tempPlayer);	
	}
	
	//用来更新球队数据（将自动获取其位置）
	public static void updateTeam(Team _team){
		getTeamList().set(currentIndexInTeamList, _team);
	}
	
	//返回球员个数
	@SuppressWarnings("unchecked")
	public static int getPlayerNumber(){
		int size = 0;
		for(int i = 0; i < 26; i++){
			ArrayList<Player> playerList = (ArrayList<Player>) saveList.get(i);
			size += playerList.size();		
		}
		return size;
	}
	
	public static Object[][] getSomeData(String position,String distribution,String infoType){
		Object[][] data= new Object[50][30];
		int size=0;
		ArrayList<Player> allPlayers= new ArrayList<Player>(); 
		ArrayList<Player> tempPlayers = new ArrayList<Player>(); 
		
		for(int i = 0; i < 26; i++){
			ArrayList<Player> playerList = (ArrayList<Player>) RegisterList.saveList.get(i);
			size = playerList.size();
			for(int j = 0; j < size; j++){
				Player tempPlayer = playerList.get(j);
				allPlayers.add(tempPlayer);
			}
		}
		
		size = allPlayers.size();
		switch(position){
			case "前锋":
				switch(distribution){
					case "东部":for(int i=0;i<size;i++){
								Player tempPlayer = allPlayers.get(i);
									if(tempPlayer.getEast(tempPlayer.getTeamShortName())){
										if(tempPlayer.getPosition().equals("F")||(tempPlayer.getPosition().equals("F/C"))){
											tempPlayers.add(tempPlayer);
										}
									}
							   }
							break;
					case "西部":for(int i=0;i<size;i++){
								Player tempPlayer = allPlayers.get(i);
								if(!tempPlayer.getEast(tempPlayer.getTeamShortName())){
									if(tempPlayer.getPosition().equals("F")||(tempPlayer.getPosition().equals("F/C"))){
										tempPlayers.add(tempPlayer);
									}
								}
							   }
							break;
					default:
						for(int i=0;i<size;i++){
							Player tempPlayer = allPlayers.get(i);
							if(tempPlayer.getDivision(tempPlayer.getTeamShortName()).equals(distribution)){
								if(tempPlayer.getPosition().equals("F")||(tempPlayer.getPosition().equals("F/C"))){
									tempPlayers.add(tempPlayer);
								}
							}
						   }
			}break;
			case "中锋":{
				switch(distribution){
				case "东部":for(int i=0;i<size;i++){
					Player tempPlayer = allPlayers.get(i);
						if(tempPlayer.getEast(tempPlayer.getTeamShortName())){
							if(tempPlayer.getPosition().equals("C")){
								tempPlayers.add(tempPlayer);
							}
						}
				   }
				break;
				case "西部":for(int i=0;i<size;i++){
					Player tempPlayer = allPlayers.get(i);
					if(!tempPlayer.getEast(tempPlayer.getTeamShortName())){
						if(tempPlayer.getPosition().equals("C")){
							tempPlayers.add(tempPlayer);
						}
					}
				   }
				break;
					default:
						for(int i=0;i<size;i++){
							Player tempPlayer = allPlayers.get(i);
							if(tempPlayer.getDivision(tempPlayer.getTeamShortName()).equals(distribution)){
								if(tempPlayer.getPosition().equals("F")||(tempPlayer.getPosition().equals("F/C"))){
									if(distribution!=""){
										if(tempPlayer.getDivision(tempPlayer.getTeamShortName()).equals(distribution)){
											tempPlayers.add(tempPlayer);
										}
										}else{
											tempPlayers.add(tempPlayer);
									}
								}
							}
						   }
					}				
			}break;
			case "后卫":{
				switch(distribution){
				case "东部":for(int i=0;i<size;i++){
					Player tempPlayer = allPlayers.get(i);
						if(tempPlayer.getEast(tempPlayer.getTeamShortName())){
							if(tempPlayer.getPosition().equals("G")||(tempPlayer.getPosition().equals("G/F"))){
								tempPlayers.add(tempPlayer);
							}
						}
				   }
				break;
				case "西部":for(int i=0;i<size;i++){
					Player tempPlayer = allPlayers.get(i);
					if(!tempPlayer.getEast(tempPlayer.getTeamShortName())){
						if(tempPlayer.getPosition().equals("G")||(tempPlayer.getPosition().equals("G/F"))){
							tempPlayers.add(tempPlayer);
						}
					}
				   }
				break;
				default:
					for(int i=0;i<size;i++){
						Player tempPlayer = allPlayers.get(i);
						if(tempPlayer.getDivision(tempPlayer.getTeamShortName()).equals(distribution)){
							if(tempPlayer.getPosition().equals("G")||(tempPlayer.getPosition().equals("G/F"))){
								if(distribution!=""){
									if(tempPlayer.getDivision(tempPlayer.getTeamShortName()).equals(distribution)){
										tempPlayers.add(tempPlayer);
									}
									}else{
										tempPlayers.add(tempPlayer);
								}
							}
						}
					   }
				}
			}break;
			default:{
				switch(distribution){
				case "东部":for(int i=0;i<size;i++){
					Player tempPlayer = allPlayers.get(i);
						if(tempPlayer.getEast(tempPlayer.getTeamShortName())){
								tempPlayers.add(tempPlayer);
						}
				   }
				break;
				case "西部":for(int i=0;i<size;i++){
					Player tempPlayer = allPlayers.get(i);
					if(!tempPlayer.getEast(tempPlayer.getTeamShortName())){
							tempPlayers.add(tempPlayer);
					}
				   }
				break;
				default:
					for(int i=0;i<size;i++){
						Player tempPlayer = allPlayers.get(i);
						if(distribution!=""){
							if(tempPlayer.getDivision(tempPlayer.getTeamShortName()).equals(distribution)){
								tempPlayers.add(tempPlayer);
							}
							}else{
								tempPlayers.add(tempPlayer);
						}
					  }
				}
			}
		}
		
			SetOfSort sos=new SetOfSort();
			sos.playerquickSort(tempPlayers, 0, tempPlayers.size()-1,infoType);
		
			for(int index=0;index<tempPlayers.size();index++){
				Player tempPlayer = tempPlayers.get(index);
				data[index][0] = tempPlayer.getPlayerName();
				data[index][1] = tempPlayer.getTeamShortName();//所属球队
				data[index][2] = tempPlayer.getPlayerAttends();
				data[index][3] = tempPlayer.getPlayerStartTimes();
				data[index][4] = tempPlayer.getPlayerTotalRebounds();
				data[index][5] = tempPlayer.getPlayerOffenceRebounds();
				data[index][6] = tempPlayer.getPlayerDeffenceRebounds();
				data[index][7] = tempPlayer.getPlayerAssists();
				data[index][8] = tempPlayer.getPlayerPlayTime();
				data[index][9] = tempPlayer.getPlayerFGP();
				data[index][10] = tempPlayer.getPlayer3FGP();
				data[index][11] = tempPlayer.getPlayerFTGP();
				data[index][12] = tempPlayer.getPlayerSteals();
				data[index][13] = tempPlayer.getPlayerBlocks();
				data[index][14] = tempPlayer.getPlayerTurnovers();
				data[index][15] = tempPlayer.getPlayerFouls();
				data[index][16] = tempPlayer.getPlayerScores();
				data[index][17] = tempPlayer.getPlayerPER();
				data[index][18] = tempPlayer.getPlayerGmScER();
				data[index][19] = tempPlayer.getPlayerTSP();
				data[index][20] = tempPlayer.getPlayerSER();
				data[index][21] = tempPlayer.getRR();
				data[index][22] = tempPlayer.getO_RR();
				data[index][23] = tempPlayer.getD_RR();
				data[index][24] = tempPlayer.getAR();
				data[index][25] = tempPlayer.getSR();
				data[index][26] = tempPlayer.getBR();
				data[index][27] = tempPlayer.getTR();
				data[index][28] = tempPlayer.getUR();
				data[index][29] = tempPlayer.getdouble_double();
			}	
		return data;
	}
	
	
}
