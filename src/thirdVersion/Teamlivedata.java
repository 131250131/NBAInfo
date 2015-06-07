package thirdVersion;

import java.util.ArrayList;

public class Teamlivedata {
	   String name="";
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
       double score=0;
       double q1Score=0;
       double q2Score=0;
       double q3Score=0;
       double q4Score=0;
       double ot1Score=0;
       double ot2Score=0;
       double ot3Score=0;
       ArrayList<Playerlivedata> players=new ArrayList<Playerlivedata>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	public int getQ1Score() {
		return (int) q1Score;
	}
	public void setQ1Score(double q1Score) {
		this.q1Score = q1Score;
	}
	public int getQ2Score() {
		return (int)q2Score;
	}
	public void setQ2Score(double q2Score) {
		this.q2Score = q2Score;
	}
	public int getQ3Score() {
		return (int)q3Score;
	}
	public void setQ3Score(double q3Score) {
		this.q3Score = q3Score;
	}
	public int getQ4Score() {
		return (int)q4Score;
	}
	public void setQ4Score(double q4Score) {
		this.q4Score = q4Score;
	}
	public int getOt1Score() {
		return (int)ot1Score;
	}
	public void setOt1Score(double ot1Score) {
		this.ot1Score = ot1Score;
	}
	public int getOt2Score() {
		return (int)ot2Score;
	}
	public void setOt2Score(double ot2Score) {
		this.ot2Score = ot2Score;
	}
	public int getOt3Score() {
		return (int)ot3Score;
	}
	public void setOt3Score(double ot3Score) {
		this.ot3Score = ot3Score;
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
	public int getScore() {
		return (int) score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public ArrayList<Playerlivedata> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Playerlivedata> players) {
		this.players = players;
	}
	public double getRebs() {
		return Rebs;
	}
	public void setRebs(double rebs) {
		Rebs = rebs;
	}
}
