package com.nba.registerList;

import java.util.ArrayList;

import com.nba.data.DataLoader;


/*
 * 寄存器列表类，其中有个static的list，本软件中的所有操作都由这个寄存器列表来进行相关操作
 */
public class RegisterList {
	
	public static ArrayList<Object> saveList ;
	
	public void initList(){
		saveList = new ArrayList<Object>();
	}	

	public void getDataList(){
		DataLoader dataLoader = new DataLoader();
		saveList = dataLoader.loadingData();
	}
}
