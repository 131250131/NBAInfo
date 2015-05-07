package Utibility;

import logic.MatchController;

public class JudgeUpdate extends Thread {

	 MatchController m=MatchController.getInstance();
	 boolean judge =false;

	 public static boolean needUpdate = false;
	 
	 public static void setFalse(){
		 needUpdate = false;
	 }
	 
	 public void run() {
		for(;;){
			if(needUpdate != true){
				judge = m.Matchupdate();
				
				if(judge == true){
					needUpdate = true;
					
				}
				if(judge == false){
					needUpdate = false;
				}
			}
				System.out.println("================");
				System.out.println(needUpdate);
				System.out.println(judge);
				System.out.println("================");
				
				try {  
			        //每运行一次就睡4秒  
			        Thread.sleep(2000); 
			      }  
			      catch (InterruptedException ex){
			    	  
			    }  		
		}
	}
   
}
