package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Searcher {
	
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
}
