package thirdVersion;

import java.util.ArrayList;

public class MatchLivedata {
      private String location="";
      private String attendence="";//观众
      private String TawayScore="";//全场客队分
      private String ThomeScore="";//全场主队分
      private String statusDesc="";//暂时不确定是啥
      /*
       * 一下都是一一对应的
       */
      private ArrayList<String> gameclocks=new ArrayList<String>();
      private ArrayList<String> descriptions=new ArrayList<String>();
      
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAttendence() {
		return attendence;
	}

	public void setAttendence(String attendence) {
		this.attendence = attendence;
	}

	public String getTAwayScore() {
		return TawayScore;
	}

	public void setTAwayScore(String awayScore) {
		this.TawayScore = awayScore;
	}

	public String getTHomeScore() {
		return ThomeScore;
	}

	public void setTHomeScore(String homeScore) {
		this.ThomeScore = homeScore;
	}

	public ArrayList<String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(ArrayList<String> descriptions) {
		this.descriptions = descriptions;
	}

	public ArrayList<String> getGameclocks() {
		return gameclocks;
	}

	public void setGameclocks(ArrayList<String> gameclocks) {
		this.gameclocks = gameclocks;
	}
}
