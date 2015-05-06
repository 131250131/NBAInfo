package Utibility;

import java.io.File;

import data.matchdata.Matchdata;

public class JudgeUpdate extends Thread {
	 Matchdata m=new Matchdata();
	 boolean judge =false;
     public JudgeUpdate(String filePath) {
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		judge=m.Matchupdate();
		if(judge==true){
			//刷新界面
		}
		try {  
	        //每运行一次就睡2秒  
	        Thread.sleep(2000);;  
	      }  
	      catch (InterruptedException ex){
	    	  
	      }  
	}
   
}
