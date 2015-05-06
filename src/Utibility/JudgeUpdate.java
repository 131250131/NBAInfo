package Utibility;

import java.io.File;

public class JudgeUpdate implements Runnable {
	int number;
	String filePath;
	private boolean Hasupdate=false;
     public JudgeUpdate(String filePath) {
		// TODO Auto-generated constructor stub
 		File file = new File(filePath);                
 		File[] File = file.listFiles();
 		this.filePath=filePath;
 		number=File.length;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file = new File(filePath);                
 		File[] File = file.listFiles();
		for(;;){
		   if(File.length!=number){
			   boolean Hasupdate=true;
			   number=File.length;
			   System.out.println("ppp");
		   }
		   System.out.println("ttt");
		   try{
			   Thread.sleep(100);
		   }catch(Exception e){
			   System.out.println("获取数据超时");
		   }
		}
		
	}
   public void initHasupdate(){
	   Hasupdate =false;
   }
   public boolean getHasupdate(){
	   return Hasupdate;
   }
}
