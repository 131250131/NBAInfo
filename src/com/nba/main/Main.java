package com.nba.main;

import com.nba.ui.Mainframe;

public class Main {
	
	public static double T;
	
	public static void main(String[] args){
		
		//起始时间
		double t1 = System.currentTimeMillis();
		T = t1;
		
		//**************************PROCESS START**************************
			
		//开启软件时通过InitProcess来初始化进程
		//InitProcess initProcess = new InitProcess();
		//initProcess.init();
		
		
		//UI TEST
		Mainframe mainFrame = new Mainframe();
		mainFrame.setVisible(true);
		
		//保存寄存器列表中的列表至序列化中
		//RegisterList.saveDataList();
		
		//**************************PROCESS FINISH**************************
	
		//结束时间
		double t2 = System.currentTimeMillis();
		
		//计算用时
		double useTime = (t2 - t1) / 1000;
		System.out.println("Using " + useTime + "s");
	}
}
