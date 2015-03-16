package com.nba.registerList;

import java.util.ArrayList;

import com.nba.data.Player;
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
	
}
