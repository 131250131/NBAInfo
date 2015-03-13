package com.nba.data;

/*
 * 该类用来统一保存需要读取以及需要保存的文件地址，即“文件路径保存器”
 */

public class FilePathSaver {
	
	//***********************************属性***********************************
	
	//序列化保存文件加载地址
	private String dataLoadingPath = "data/save/save.ser";
	
	//序列化保存文件存储地址
	private String dataSavingPath = dataLoadingPath;
	
	//球员信息文件夹地址
	private String playerFilePath = "data/data/players/info";
	
	//比赛信息文件夹地址
	private String matchFilePath = "data/data/matches";
	
	//队伍信息文件夹地址
	private String teamFilePath = "data/data/teams/teams";
	
	//******************************以下是获取方法******************************
	
	//获取“序列化保存文件加载地址”
	public String getDataLoadingPath(){
		return dataLoadingPath;
	}
	
	//获取“序列化保存文件存储地址”
	public String getDataSavingPath(){
		return dataSavingPath;
	}
	
	//获取“球员信息文件夹地址”
	public String getPlayerFilePath(){
		return playerFilePath;
	}
	
	//获取“比赛信息文件夹地址”
	public String getMatchFilePath(){
		return matchFilePath;
	}
	
	//获取“队伍信息文件夹地址”
	public String getTeamFilePath(){
		return teamFilePath;
	}

}
