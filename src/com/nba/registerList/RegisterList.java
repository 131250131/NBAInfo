package com.nba.registerList;

import java.util.ArrayList;

import com.main.Player;
import com.nba.data.DataLoader;
import com.nba.data.DataSaver;


/*
 * 寄存器列表类，其中有个static的list，本软件中的所有操作都由这个寄存器列表来进行相关操作
 */
public class RegisterList {
	
	public static ArrayList<Object> saveList ;
	
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
		@SuppressWarnings("unchecked")
		ArrayList<Player> playerList = (ArrayList<Player>) saveList.get(currentIndex);
		
		//遍历列表 并找到球员
		int listSize = playerList.size();
		for(int i = 0; i < listSize; i++){
			Player temp_player = playerList.get(i);
			
			//如果找到球员则返回球员类
			if(temp_player.getPlayerName().equals(_playerName)){			
				return playerList.get(i);
			}
		}	
		
		//若都找不到则返回“空”
		return null;
	}
}
