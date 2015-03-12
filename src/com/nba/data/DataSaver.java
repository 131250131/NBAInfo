package com.nba.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataSaver {
	
	//初始化文件路径保存器，并加载需要的路径
	FilePathSaver fileSaver = new FilePathSaver();
	private String filePath = fileSaver.getDataLoadingPath();
	
	public void saveData(ArrayList<Object> saveList){
		
		try {  
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));  
			os.writeObject(saveList);  
			os.close();  
	    }catch(FileNotFoundException e){  
	    	e.printStackTrace();  
	    }catch(IOException e){  
	    	e.printStackTrace();  
	    }  
	}
}
