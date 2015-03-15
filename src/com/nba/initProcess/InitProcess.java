package com.nba.initProcess;

import com.nba.registerList.RegisterList;

public class InitProcess {
	
	RegisterList registerList = null;
	
	//初始化寄存器，即让static的寄存列表生成
	public InitProcess(){
		registerList = new RegisterList();
	}
	
	//根据球队以及球员数据初始化列表
	public void init(){
		registerList.initList();
		PlayerListBuilder playerListBuilder = new PlayerListBuilder();
		TeamListBuilder teamListBuilder = new TeamListBuilder();
		try {
			playerListBuilder.readAll();
			teamListBuilder.readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取已保存好的数据
	public void getData(){
		registerList.getDataList();
	}
	
	public void initWithMatchFile(){
		MatchFileReader matchFileReader = new MatchFileReader();
		try {
			matchFileReader.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
