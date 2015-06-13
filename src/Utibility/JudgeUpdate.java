//package Utibility;
//
//import ui.frame.index.container.IndexScrollPane;
//import ui.frame.larger.LargerPanel;
//import ui.system.Controller;
//import logic.MatchController;
//
//public class JudgeUpdate extends Thread {
//
//	 MatchController m=MatchController.getInstance();
//	 boolean judge =false;
//
//	 public static boolean needUpdate = false;
//	 
//	 public static void setFalse(){
//		 needUpdate = false;
//	 }
//	 
//	 public void run() {
//		for(;;){
//			if(needUpdate != true){
//				judge = m.Matchupdate();
//				
//				if(judge == true){
//					needUpdate = true;
//					Controller.reInit();
//					LargerPanel.refresh.doClick();
//					JudgeUpdate.setFalse();
//					IndexScrollPane.turnto1.doClick();;
//				}
//				if(judge == false){
//					needUpdate = false;
//				}
//			}
//				
//				try {  
//			        //每运行一次就睡4秒  
//			        Thread.sleep(10000); 
//			      }  
//			      catch (InterruptedException ex){
//			    	  
//			    }  		
//		}
//	}
//   
//}
