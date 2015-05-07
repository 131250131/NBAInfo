package Utibility;

import data.matchdata.Matchdata;

public class JudgeUpdate extends Thread {
	 Matchdata m = new Matchdata();
	 boolean judge = false;
	 public static boolean needUpdate = false;
	 
	 public void run() {
		judge = m.Matchupdate();
		if(judge == true){
			needUpdate = true;
		}
		if(judge == false){
			needUpdate = false;
		}
		
		System.out.println("================");
		System.out.println(needUpdate);
		System.out.println(judge);
		System.out.println("================");
		
		try {  
	        //每运行一次就睡4秒  
	        Thread.sleep(4000);;  
	      }  
	      catch (InterruptedException ex){
	    	  
	      }  
	}
   
}
