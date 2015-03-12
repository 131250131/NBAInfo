package com.nba.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/*
 * 该类用于加载序列化文件
 */

public class DataLoader {
	
	//初始化文件路径保存器，并加载需要的路径
	FilePathSaver fileSaver = new FilePathSaver();
	private String filePath = fileSaver.getDataLoadingPath();
	
	@SuppressWarnings("unchecked")
	public ArrayList<Object> loadingData(){
		try{  
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));    
			ArrayList<Object> dataList = (ArrayList<Object>) inputStream.readObject(); 
			inputStream.close();  		
			return dataList;
		}catch(FileNotFoundException e){  
			e.printStackTrace();  
		}catch (IOException e){  
			e.printStackTrace();  
		}catch (ClassNotFoundException e){  
			e.printStackTrace();  
		}
		return null;  
	}
}
