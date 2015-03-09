package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Searcher {
	
	
	//用来通过球员名称来获取球员的类
	public Player playerSearcher(String _playerName){
		
		byte[] nameBytes = _playerName.getBytes();
		int location = nameBytes[0] - 65;
			
		try{  		  
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data/save/player.ser"));    
			@SuppressWarnings("unchecked") 
			ArrayList<ArrayList<Player>> playerList = (ArrayList<ArrayList<Player>>) inputStream.readObject();// 从流中读取List的数据 
			
			ArrayList<Player> playerCharList = playerList.get(location);
			
			for(int i = 0; i < playerCharList.size(); i++){
				if(playerCharList.get(i).playerName.equals(_playerName)){
					inputStream.close(); 
					return playerCharList.get(i);
				}
			}		
		    inputStream.close();  
	    }catch(FileNotFoundException e){  
	        e.printStackTrace();  
	    }catch(IOException e){  
	        e.printStackTrace();  
	    }catch(ClassNotFoundException e){  
	        e.printStackTrace();  
	    }  
		
		return null;
	}
	
	//用来通过队伍缩写来搜索队伍
	public Team teamSearcher(String _teamShortName){
		
		try{  		  
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data/save/team.ser"));    
			@SuppressWarnings("unchecked") 
			ArrayList<Team> playerList = (ArrayList<Team>) inputStream.readObject();// 从流中读取List的数据 
				
			for(int i = 0; i < playerList.size(); i++){
				if(playerList.get(i).shortName.equals(_teamShortName)){
					inputStream.close(); 
					return playerList.get(i);
				}
			}		
		    inputStream.close();  
	    }catch(FileNotFoundException e){  
	        e.printStackTrace();  
	    }catch(IOException e){  
	        e.printStackTrace();  
	    }catch(ClassNotFoundException e){  
	        e.printStackTrace();  
	    }  
		
		return null;
	}
}
