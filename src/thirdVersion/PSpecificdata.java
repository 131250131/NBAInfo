package thirdVersion;

public class PSpecificdata {
       String season="";
       Double data=0.0;//需要的某项特定数据
       String team="";
       Double attendmatches=0.0;//这个是我合并相同赛季用的，UI不需要用到
       boolean isuseful=false;//判断数据是否在画表的时候是有效的
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Double getData() {
		return data;
	}
	public void setData(Double data) {
		this.data = data;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Double getAttendmatches() {
		return attendmatches;
	}
	public void setAttendmatches(Double attendmatches) {
		this.attendmatches = attendmatches;
	}
	public boolean isIsuseful() {
		return isuseful;
	}
	public void setIsuseful(boolean isusefu) {
		this.isuseful = isusefu;
	}
    
       
}
