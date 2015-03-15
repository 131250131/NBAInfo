package com.nba.initProcess;

import com.nba.registerList.RegisterList;

public class InitProcess {
	
	RegisterList registerList = null;
	
	//通过这个值来判断时候需要重新读取球员以及球队的列表来更新数据
	private boolean needsInfoLoading = true;
			
	//通过这个值来判断时候需要重新读取比赛文件来更新数据
	private boolean needsMatchLoading = true;
	
	
	//初始化寄存器，即让static的寄存列表生成
	public InitProcess(){
		registerList = new RegisterList();
	}
	
	
	/*
	 *判断一： 是否需要 重新读取球员以及球队的列表来更新数据
	 *判断二： 是否需要重新读取比赛文件来更新数据
	 */
	public void init(){
		if(needsInfoLoading){	
			//初始化数据
			initPlayerAndTeam();
			initWithMatchFile();
		}else{
			if(needsMatchLoading){
				//加载已初始化的数据
				getData();
				initWithMatchFile();
			}else{
				//
			}
		}
	}
	
	
	//根据球队以及球员数据初始化列表
	private void initPlayerAndTeam(){
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
	private void getData(){
		registerList.getDataList();
	}
	
	private void initWithMatchFile(){
		MatchFileReader matchFileReader = new MatchFileReader();
		try {
			matchFileReader.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
