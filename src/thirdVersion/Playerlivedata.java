package thirdVersion;

public class Playerlivedata {
	 String name="";
	 String position="";
	 String dnpReason="";//如果这个不为空，就直接打出这个 数据不用看了 参照网站上的教练决定没有出场那个，该项周一测试时候才确定
	 boolean isStarter=false;
	 boolean onCourt=false;
	 int plusminus=0;
	 double time=0;//上场时间
     double Assists=0;
     double blocks=0;
     double Rebs=0;
     double defRebs=0;
     double offRebs=0;
     double fg=0;//投篮出手
     double fgz=0;//投篮命中
     double fgp=0;
     double fouls=0;
     double ft=0;
     double ftz=0;
     double ftp=0;
     double sfg=0;
     double sfgz=0;
     double sfgp=0;
     double turnovers=0;
     double steals=0;
     double points=0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDnpReason() {
		return dnpReason;
	}
	public void setDnpReason(String dnpReason) {
		this.dnpReason = dnpReason;
	}
	public boolean isStarter() {
		return isStarter;
	}
	public void setStarter(String isStarter) {
		if(isStarter.equals("true")){
		this.isStarter = true;
		}
		else
			this.isStarter=false;
	}
	public boolean isOnCourt() {
		return onCourt;
	}
	public void setOnCourt(String onCourt) {
		if(onCourt.equals("true")){
		this.onCourt = true;
		}
		else
			this.onCourt=false;
	}
	public int getPlusminus() {
		return plusminus;
	}
	public void setPlusminus(int plusminus) {
		this.plusminus = plusminus;
	}
	public double getAssists() {
		return Assists;
	}
	public void setAssists(double assists) {
		Assists = assists;
	}
	public double getBlocks() {
		return blocks;
	}
	public void setBlocks(double blocks) {
		this.blocks = blocks;
	}
	public double getRebs() {
		return Rebs;
	}
	public void setRebs(double rebs) {
		Rebs = rebs;
	}
	public double getDefRebs() {
		return defRebs;
	}
	public void setDefRebs(double defRebs) {
		this.defRebs = defRebs;
	}
	public double getOffRebs() {
		return offRebs;
	}
	public void setOffRebs(double offRebs) {
		this.offRebs = offRebs;
	}
	public double getFg() {
		return fg;
	}
	public void setFg(double fg) {
		this.fg = fg;
	}
	public double getFgz() {
		return fgz;
	}
	public void setFgz(double fgz) {
		this.fgz = fgz;
	}
	public double getFgp() {
		return fgp;
	}
	public void setFgp(double fgp) {
		this.fgp = fgp;
	}
	public double getFouls() {
		return fouls;
	}
	public void setFouls(double fouls) {
		this.fouls = fouls;
	}
	public double getFt() {
		return ft;
	}
	public void setFt(double ft) {
		this.ft = ft;
	}
	public double getFtz() {
		return ftz;
	}
	public void setFtz(double ftz) {
		this.ftz = ftz;
	}
	public double getFtp() {
		return ftp;
	}
	public void setFtp(double ftp) {
		this.ftp = ftp;
	}
	public double getSfg() {
		return sfg;
	}
	public void setSfg(double sfg) {
		this.sfg = sfg;
	}
	public double getSfgz() {
		return sfgz;
	}
	public void setSfgz(double sfgz) {
		this.sfgz = sfgz;
	}
	public double getSfgp() {
		return sfgp;
	}
	public void setSfgp(double sfgp) {
		this.sfgp = sfgp;
	}
	public double getTurnovers() {
		return turnovers;
	}
	public void setTurnovers(double turnovers) {
		this.turnovers = turnovers;
	}
	public double getSteals() {
		return steals;
	}
	public void setSteals(double steals) {
		this.steals = steals;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
}
