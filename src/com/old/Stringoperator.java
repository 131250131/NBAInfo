package com.old;
public class Stringoperator {
      String operated;
      String team;
      int tempcount;
      public Stringoperator(String op) {
		// TODO Auto-generated constructor stub
    	  operated=op;
    	  team="left";
    	  tempcount=0;
	}
    public void setstring(String op){
    	operated=op;
    }
	public void playeroperaator() {
		// TODO Auto-generated method stub
		
	}
	public String getoperator() {
		// TODO Auto-generated method stub
		return operated;
	}
	public void matchoperator(Match tempmatch) {
		String[] list=operated.split("/;");
		if(list.length==1){
			tempcount++;
			if(tempcount>1){
				team="right";
			}
		}
		if(list.length==3){
			String Date=list[0];
			String[] teamlist=list[1].split("/-");
			String score=list[2];
		}
		if(list.length==4){
			String firstscore=list[0];
			String secondscore=list[1];
			String thirdscore=list[2];
			String forthscore=list[3];
		}
		if(list.length>4){
			String Name=list[0];
			String Position=list[1];//替补为空
			String Time=list[2];
			int FG=Integer.parseInt(list[3]);
			int FGTry=Integer.parseInt(list[4]);
			int ThreeFG=Integer.parseInt(list[5]);
			int ThreeFGTry=Integer.parseInt(list[6]);
			int FTG=Integer.parseInt(list[7]);
			int FTGTry=Integer.parseInt(list[8]);
			int OffenceRebounds=Integer.parseInt(list[9]);
			int DeffenceRebounds=Integer.parseInt(list[10]);
			int Rebounds=Integer.parseInt(list[11]);
			int Assists=Integer.parseInt(list[12]);
			int Steals=Integer.parseInt(list[13]);
			int Blocks=Integer.parseInt(list[14]);
			int Turnovers=Integer.parseInt(list[15]);
			int Fouls=Integer.parseInt(list[16]);
			int Scores=Integer.parseInt(list[17]);
		}
	}
      
}
