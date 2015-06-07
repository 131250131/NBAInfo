package thirdVersion;

import java.util.ArrayList;

public class MatchLivedata {
      private String location="";//球馆
      private String attendence="";//观众
      private String Tscores="";//总比分
      private String statusDesc="";//暂时不确定是啥
      private ArrayList<String> yuju=new ArrayList<String>();//直播语句
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
	

	

	

	

	public String getTscores() {
		return Tscores;
	}

	public void setTscores(String tscores) {
		Tscores = tscores;
	}

	

	
	public ArrayList<String> getYuju() {
		return yuju;
	}

	public void setYuju(ArrayList<String> yuju) {
		this.yuju = yuju;
	}

	
}
