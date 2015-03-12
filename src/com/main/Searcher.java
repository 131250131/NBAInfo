package com.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Searcher {
	

	private ArrayList<ArrayList<Player>> finalPlayerList;
	private ArrayList<Player> finalAlaphPlayerList;
	private int currentIndex;
	private int size;
	public Searcher(){
		
	}
	
	public void setList(ArrayList<ArrayList<Player>> list){
		finalPlayerList = list;
	}
	
	public Searcher(int a){
		try{  
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data/save/player.ser"));  
			@SuppressWarnings("unchecked") 
			ArrayList<ArrayList<Player>> playerList = (ArrayList<ArrayList<Player>>) inputStream.readObject();// 从流中读取List的数据 
			finalPlayerList = playerList;
			inputStream.close(); 	
		}catch(FileNotFoundException e){  
	        e.printStackTrace();  
	    }catch(IOException e){  
	        e.printStackTrace();  
	    }catch(ClassNotFoundException e){  
	        e.printStackTrace();  
	    }  
	}
	
	//用来通过球员名称来获取球员的类
	public Player playerSearcher(String _playerName){
		
		byte[] nameBytes = _playerName.getBytes();
		currentIndex = nameBytes[0] - 65;
			
		finalAlaphPlayerList = finalPlayerList.get(currentIndex);
		
		for(int i = 0; i < finalAlaphPlayerList.size(); i++){
			if(finalAlaphPlayerList.get(i).playerName.equals(_playerName)){			
				return finalAlaphPlayerList.get(i);
			}
		}	
		
		return null;
		
//		//试试看用二分法查找
//		
//		return binarySearch(_playerName);
	}
	
//	private Player binarySearch(String _playerName){
//		int low = 0;
//		int high = finalAlaphPlayerList.size() - 1;
//				
//		while(low <= high){
//			int mid = (low + high) / 2;
//			Player player = finalAlaphPlayerList.get(mid);
//			String name = player.playerName;
//			
//			if(name.compareTo(_playerName) < 0){
//				low = mid + 1;
//			}else if(name.compareTo(_playerName) > 0){
//				high = mid - 1;
//			}else{
//				return player;
//			}
//		}	
//		return null;
//	}
	
	public void rewritePlayerFile(){
		String saveFile = "data/save/player.ser";
		try {  
	           ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(saveFile));  
	           os.writeObject(finalPlayerList);// 将List列表写进文件  
	           os.close();  
	       } catch (FileNotFoundException e) {  
	           e.printStackTrace();  
	       } catch (IOException e) {  
	           e.printStackTrace();  
	       }  
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
	public ArrayList<ArrayList<Player>> getFinalPlayerList() {
		return finalPlayerList;
	}

	public void setFinalPlayerList(ArrayList<ArrayList<Player>> finalPlayerList) {
		this.finalPlayerList = finalPlayerList;
	}
	
	public ArrayList<Player> getFinalAlaphPlayerList() {
		return finalAlaphPlayerList;
	}

	public void setFinalAlaphPlayerList(ArrayList<Player> finalAlaphPlayerList) {
		this.finalAlaphPlayerList = finalAlaphPlayerList;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
