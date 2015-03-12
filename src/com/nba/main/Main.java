package com.nba.main;

import com.nba.initProcess.InitProcess;
import com.nba.initProcess.PlayerListBuilder;
import com.nba.registerList.RegisterList;

public class Main {
	
	public static void main(String[] args){
		
		//起始时间
		double t1 = System.currentTimeMillis();
	
		
		
		
		//**************************PROCESS START**************************
		
		//通过这个值来判断时候需要重新读取球员以及球队的列表来更新数据
		boolean needsInfoLoading = true;
		
		//通过这个值来判断时候需要重新读取比赛文件来更新数据
		boolean needsMatchLoading = true;
		
		//开启软件时通过InitProcess来初始化进程
		InitProcess initProcess = new InitProcess();
		
		/*
		 *判断一： 是否需要 重新读取球员以及球队的列表来更新数据
		 *判断二： 是否需要重新读取比赛文件来更新数据
		 */
		
		if(needsInfoLoading){	
			//初始化数据
			initProcess.init();
		}else{
			if(needsMatchLoading){
				//加载已初始化的数据
				initProcess.getData();
			}else{
				
			}
		}
		
		
		
		//**************************PROCESS FINISH**************************
		
		
		
		
		//结束时间
		double t2 = System.currentTimeMillis();
		
		//计算用时
		double useTime = (t2 - t1) / 1000;
		System.out.println("Using " + useTime + "s");
	}
}
