package thirdVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import logic.MatchController;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LiveCast  {
	MatchLivedata firstmatchinfo=new MatchLivedata();//第一节的直播信息
	MatchLivedata secondmatchinfo=new MatchLivedata();//第二节的直播信息
	MatchLivedata thirdmatchinfo=new MatchLivedata();//第三节的直播信息
	MatchLivedata forthmatchinfo=new MatchLivedata();//第四节的直播信息
	MatchLivedata extra1matchinfo=new MatchLivedata();//加时一的直播信息
	MatchLivedata extra2matchinfo=new MatchLivedata();//加时二的直播信息
	MatchLivedata extra3matchinfo=new MatchLivedata();//加时三的直播信息
	Teamlivedata homeTeam =new Teamlivedata();//主队信息
	Teamlivedata awayTeam =new Teamlivedata();//客队信息
	private static LiveCast instance =null;
	private LiveCast(){
		
	}
	public static LiveCast getInstance(){
		if(instance == null){
			instance = new LiveCast();
		}
		return instance;
	}
	//感觉一般不会超过三个加时吧
	ArrayList<String> yuju=new ArrayList<String>();
	ArrayList<Playerlivedata> players=new ArrayList<Playerlivedata>();
	int setnumber=1;
	boolean clicked=true; 
	public 	String getjson(String u){
		String json="";
		try{
		String n=String.valueOf(setnumber);
		URL url = new URL(u);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty(
				"User-Agent",
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15");
		conn.setRequestProperty("Content-Type", "text/html");
		conn.setRequestProperty("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		InputStream is = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		String line = null;
		int count=0;
		while ((line = br.readLine()) != null) {
			json=line;
		}
		 br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	public boolean setlivedata (String n) {
		/*
		 *得到网页json内容 
		 */
		    try{
		    String ptjson=getjson("http://china.nba.com/wap/static/data/game/snapshot_0041400401.json");
			String json=getjson("http://china.nba.com/wap/static/data/game/playbyplay_0041400401_"+n+".json");	
			
			if(n.equals("1")){
			JSONObject  jsonObj  = JSONObject.fromObject(json);
			//System.out.println(jsonObj.get("payload"));
			JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
			JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
			JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
			//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
			firstmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
			firstmatchinfo.setAttendence(jsonObj3.getString("attendance"));
			firstmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
			System.out.println(firstmatchinfo.getTscores());
			JSONArray jary=jsonObj1.getJSONArray("playByPlays");
			JSONObject obj = jary.getJSONObject(0);
			JSONArray jary1=obj.getJSONArray("events");
			yuju=new ArrayList<String>();
			for (int i=0;i<jary1.size();i++) {
		         JSONObject obj1 = jary1.getJSONObject(i);
		         yuju.add("第一节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
		         if(obj1.getString("description").equals("本节比赛结束")){
		        	 clicked=false;
		         }
		         System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
		        }
//			     System.out.println(jary1.size());
			     firstmatchinfo.setYuju(yuju);
			    //System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
			     
			
			}
			if(n.equals("2")){
				JSONObject  jsonObj  = JSONObject.fromObject(json);
				//System.out.println(jsonObj.get("payload"));
				JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
				JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
				JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
				//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
				secondmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
				secondmatchinfo.setAttendence(jsonObj3.getString("attendance"));
				secondmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
				System.out.println(secondmatchinfo.getTscores());
				JSONArray jary=jsonObj1.getJSONArray("playByPlays");
				JSONObject obj = jary.getJSONObject(0);
				JSONArray jary1=obj.getJSONArray("events");
				yuju=new ArrayList<String>();
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("第二节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    secondmatchinfo.setYuju(yuju);
//				    System.out.println(secondmatchinfo.getDescriptions().size()+" "+secondmatchinfo.getGameclocks().size()+" "+secondmatchinfo.getScores().size());
				  
				
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			if(n.equals("3")){
				JSONObject  jsonObj  = JSONObject.fromObject(json);
				//System.out.println(jsonObj.get("payload"));
				JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
				JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
				JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
				//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
				firstmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
				firstmatchinfo.setAttendence(jsonObj3.getString("attendance"));
				firstmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
				System.out.println(firstmatchinfo.getTscores());
				JSONArray jary=jsonObj1.getJSONArray("playByPlays");
				JSONObject obj = jary.getJSONObject(0);
				JSONArray jary1=obj.getJSONArray("events");
				yuju=new ArrayList<String>();
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("第三节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    thirdmatchinfo.setYuju(yuju);
//				    System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				    
				    
				
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			if(n.equals("4")){
				JSONObject  jsonObj  = JSONObject.fromObject(json);
				//System.out.println(jsonObj.get("payload"));
				JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
				JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
				JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
				//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
				firstmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
				firstmatchinfo.setAttendence(jsonObj3.getString("attendance"));
				firstmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
				System.out.println(firstmatchinfo.getTscores());
				JSONArray jary=jsonObj1.getJSONArray("playByPlays");
				JSONObject obj = jary.getJSONObject(0);
				JSONArray jary1=obj.getJSONArray("events");
				yuju=new ArrayList<String>();
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("第四节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));			         
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    forthmatchinfo.setYuju(yuju);
//				    System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				 
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			if(n.equals("5")){
				JSONObject  jsonObj  = JSONObject.fromObject(json);
				//System.out.println(jsonObj.get("payload"));
				JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
				JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
				JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
				//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
				firstmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
				firstmatchinfo.setAttendence(jsonObj3.getString("attendance"));
				firstmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
				System.out.println(firstmatchinfo.getTscores());
				JSONArray jary=jsonObj1.getJSONArray("playByPlays");
				JSONObject obj = jary.getJSONObject(0);
				JSONArray jary1=obj.getJSONArray("events");
				yuju=new ArrayList<String>();
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("加时一"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    extra1matchinfo.setYuju(yuju);
//				    System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			if(n.equals("6")){
				JSONObject  jsonObj  = JSONObject.fromObject(json);
				//System.out.println(jsonObj.get("payload"));
				JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
				JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
				JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
				//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
				firstmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
				firstmatchinfo.setAttendence(jsonObj3.getString("attendance"));
				firstmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
				System.out.println(firstmatchinfo.getTscores());
				JSONArray jary=jsonObj1.getJSONArray("playByPlays");
				JSONObject obj = jary.getJSONObject(0);
				JSONArray jary1=obj.getJSONArray("events");
				yuju=new ArrayList<String>();
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("加时二"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         //System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    extra2matchinfo.setYuju(yuju);
				 //   System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				 
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			if(n.equals("7")){
				JSONObject  jsonObj  = JSONObject.fromObject(json);
				//System.out.println(jsonObj.get("payload"));
				JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
				JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
				JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
				//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
				firstmatchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
				firstmatchinfo.setAttendence(jsonObj3.getString("attendance"));
				firstmatchinfo.setTscores(jsonObj3.getString("awayScore")+"-"+jsonObj3.getString("homeScore"));
				System.out.println(firstmatchinfo.getTscores());
				JSONArray jary=jsonObj1.getJSONArray("playByPlays");
				JSONObject obj = jary.getJSONObject(0);
				JSONArray jary1=obj.getJSONArray("events");
				yuju=new ArrayList<String>();
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("加时三"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         //System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    extra3matchinfo.setYuju(yuju);
//				    System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				 
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			
			
			
			/*
			 * 处理主队球队和球员数据
			 */
			
			JSONObject  ptjsonObj  = JSONObject.fromObject(ptjson);
			JSONObject  ptjsonObj1  = JSONObject.fromObject(ptjsonObj.getString("payload"));
			JSONObject  ptjsonObj2  = JSONObject.fromObject(ptjsonObj1.getString("homeTeam"));
			JSONObject  ptjsonObj3  = JSONObject.fromObject(ptjsonObj2.getString("profile"));
			JSONObject  ptjsonObj4  = JSONObject.fromObject(ptjsonObj2.getString("score"));
			JSONArray hometeamjary=ptjsonObj2.getJSONArray("gamePlayers");
			//System.out.println(ptjsonObj);
			homeTeam.setName(ptjsonObj3.getString("city")+ptjsonObj3.getString("displayAbbr"));
			homeTeam.setAssists(ptjsonObj4.getDouble("assists"));
			homeTeam.setBlocks(ptjsonObj4.getDouble("blocks"));
			homeTeam.setDefRebs(ptjsonObj4.getDouble("defRebs"));
			homeTeam.setOffRebs(ptjsonObj4.getDouble("offRebs"));
			homeTeam.setRebs(ptjsonObj4.getDouble("rebs"));
			homeTeam.setFg(ptjsonObj4.getDouble("fga"));
			homeTeam.setFgz(ptjsonObj4.getDouble("fgm"));
			homeTeam.setFgp(ptjsonObj4.getDouble("fgpct"));
			homeTeam.setSfg(ptjsonObj4.getDouble("tpa"));
			homeTeam.setSfgz(ptjsonObj4.getDouble("tpm"));
			homeTeam.setSfgp(ptjsonObj4.getDouble("tppct"));
			homeTeam.setFt(ptjsonObj4.getDouble("fta"));
			homeTeam.setFtz(ptjsonObj4.getDouble("ftm"));
			homeTeam.setFtp(ptjsonObj4.getDouble("ftpct"));
			homeTeam.setTurnovers(ptjsonObj4.getDouble("turnovers"));
			homeTeam.setSteals(ptjsonObj4.getDouble("steals"));
			homeTeam.setScore(ptjsonObj4.getDouble("score"));
			homeTeam.setOt1Score(ptjsonObj4.getDouble("ot1Score"));
			homeTeam.setOt2Score(ptjsonObj4.getDouble("ot2Score"));
			homeTeam.setOt3Score(ptjsonObj4.getDouble("ot3Score"));
			homeTeam.setQ1Score(ptjsonObj4.getDouble("q1Score"));
			homeTeam.setQ2Score(ptjsonObj4.getDouble("q2Score"));
			homeTeam.setQ3Score(ptjsonObj4.getDouble("q3Score"));
			homeTeam.setQ4Score(ptjsonObj4.getDouble("q4Score"));
			//System.out.println(hometeamjary.size());
			players=new ArrayList<Playerlivedata>();
			for (int i=0;i<hometeamjary.size();i++) {
				JSONObject obj1 = hometeamjary.getJSONObject(i);
				JSONObject  pjsonObj1  = JSONObject.fromObject(obj1.get("profile"));
				JSONObject  pjsonObj2  = JSONObject.fromObject(obj1.get("boxscore"));
				JSONObject  pjsonObj3  = JSONObject.fromObject(obj1.get("statTotal"));
				Playerlivedata p=new Playerlivedata();
				p.setName(pjsonObj1.getString("displayName"));
				p.setEnglishname(pjsonObj1.getString("displayNameEn"));
				p.setPosition(pjsonObj1.getString("position"));
				p.setDnpReason(pjsonObj2.getString("dnpReason"));
				p.setStarter(pjsonObj2.getString("isStarter"));
				p.setOnCourt(pjsonObj2.getString("onCourt"));
				p.setPlusminus(pjsonObj2.getInt("plusMinus"));
				p.setAssists(pjsonObj3.getDouble("assists"));
				p.setBlocks(pjsonObj3.getDouble("blocks"));
				p.setDefRebs(pjsonObj3.getDouble("defRebs"));
				p.setOffRebs(pjsonObj3.getDouble("offRebs"));
				p.setRebs(pjsonObj3.getDouble("rebs"));
				p.setFg(pjsonObj3.getDouble("fga"));
				p.setFgz(pjsonObj3.getDouble("fgm"));
				p.setFgp(pjsonObj3.getDouble("fgpct"));
				p.setSfg(pjsonObj3.getDouble("tpa"));
				p.setSfgz(pjsonObj3.getDouble("tpm"));
				p.setSfgp(pjsonObj3.getDouble("tppct"));
				p.setFt(pjsonObj3.getDouble("fta"));
				p.setFtz(pjsonObj3.getDouble("ftm"));
				p.setFtp(pjsonObj3.getDouble("ftpct"));
				p.setTurnovers(pjsonObj3.getDouble("turnovers"));
				p.setSteals(pjsonObj3.getDouble("steals"));
			    p.setTime(pjsonObj3.getDouble("mins"));
			    p.setPoints(pjsonObj3.getDouble("points"));
			    players.add(p);
			
//				System.out.println(p.getAssists()+" "+p.getBlocks()+" "+p.getDefRebs()+" "+p.getName()
//						+" "+p.getPoints()+" "+p.getPlusminus()+" "+p.getPosition()+" "+p.getFgp()+" "
//						+p.getDnpReason()+p.getEnglishname());
			}
//			System.out.println(players.size());
			homeTeam.setPlayers(players);
//			System.out.println(homeTeam.getPlayers().size());
			
			
			
			/*
			 * 处理客队球队和球员信息
			 */
			
			JSONObject  aptjsonObj  = JSONObject.fromObject(ptjson);
			JSONObject  aptjsonObj1  = JSONObject.fromObject(aptjsonObj.getString("payload"));
			JSONObject  aptjsonObj2  = JSONObject.fromObject(aptjsonObj1.getString("awayTeam"));
			JSONObject  aptjsonObj3  = JSONObject.fromObject(aptjsonObj2.getString("profile"));
			JSONObject  aptjsonObj4  = JSONObject.fromObject(aptjsonObj2.getString("score"));
			JSONArray awayteamjary=aptjsonObj2.getJSONArray("gamePlayers");
			//System.out.println(ptjsonObj);
			awayTeam.setName(aptjsonObj3.getString("city")+aptjsonObj3.getString("displayAbbr"));
			awayTeam.setAssists(aptjsonObj4.getDouble("assists"));
			awayTeam.setBlocks(aptjsonObj4.getDouble("blocks"));
			awayTeam.setDefRebs(aptjsonObj4.getDouble("defRebs"));
			awayTeam.setOffRebs(aptjsonObj4.getDouble("offRebs"));
			awayTeam.setRebs(aptjsonObj4.getDouble("rebs"));
			awayTeam.setFg(aptjsonObj4.getDouble("fga"));
			awayTeam.setFgz(aptjsonObj4.getDouble("fgm"));
			awayTeam.setFgp(aptjsonObj4.getDouble("fgpct"));
			awayTeam.setSfg(aptjsonObj4.getDouble("tpa"));
			awayTeam.setSfgz(aptjsonObj4.getDouble("tpm"));
			awayTeam.setSfgp(aptjsonObj4.getDouble("tppct"));
			awayTeam.setFt(aptjsonObj4.getDouble("fta"));
			awayTeam.setFtz(aptjsonObj4.getDouble("ftm"));
			awayTeam.setFtp(aptjsonObj4.getDouble("ftpct"));
			awayTeam.setTurnovers(aptjsonObj4.getDouble("turnovers"));
			awayTeam.setSteals(aptjsonObj4.getDouble("steals"));
			awayTeam.setScore(aptjsonObj4.getDouble("score"));
			awayTeam.setOt1Score(aptjsonObj4.getDouble("ot1Score"));
			awayTeam.setOt2Score(aptjsonObj4.getDouble("ot2Score"));
			awayTeam.setOt3Score(aptjsonObj4.getDouble("ot3Score"));
			awayTeam.setQ1Score(aptjsonObj4.getDouble("q1Score"));
			awayTeam.setQ2Score(aptjsonObj4.getDouble("q2Score"));
			awayTeam.setQ3Score(aptjsonObj4.getDouble("q3Score"));
			awayTeam.setQ4Score(aptjsonObj4.getDouble("q4Score"));
			//System.out.println(awayTeam.getName()+" "+awayTeam.getScore()+" "+awayTeam.getSfgp());
			players=new ArrayList<Playerlivedata>();
			for (int i=0;i<awayteamjary.size();i++) {
				JSONObject obj1 = awayteamjary.getJSONObject(i);
				JSONObject  pjsonObj1  = JSONObject.fromObject(obj1.get("profile"));
				JSONObject  pjsonObj2  = JSONObject.fromObject(obj1.get("boxscore"));
				JSONObject  pjsonObj3  = JSONObject.fromObject(obj1.get("statTotal"));
				Playerlivedata p=new Playerlivedata();
				p.setName(pjsonObj1.getString("displayName"));
				p.setEnglishname(pjsonObj1.getString("displayNameEn"));
				p.setPosition(pjsonObj1.getString("position"));
				p.setDnpReason(pjsonObj2.getString("dnpReason"));
				p.setStarter(pjsonObj2.getString("isStarter"));
				p.setOnCourt(pjsonObj2.getString("onCourt"));
				p.setPlusminus(pjsonObj2.getInt("plusMinus"));
				p.setAssists(pjsonObj3.getDouble("assists"));
				p.setBlocks(pjsonObj3.getDouble("blocks"));
				p.setDefRebs(pjsonObj3.getDouble("defRebs"));
				p.setOffRebs(pjsonObj3.getDouble("offRebs"));
				p.setRebs(pjsonObj3.getDouble("rebs"));
				p.setFg(pjsonObj3.getDouble("fga"));
				p.setFgz(pjsonObj3.getDouble("fgm"));
				p.setFgp(pjsonObj3.getDouble("fgpct"));
				p.setSfg(pjsonObj3.getDouble("tpa"));
				p.setSfgz(pjsonObj3.getDouble("tpm"));
				p.setSfgp(pjsonObj3.getDouble("tppct"));
				p.setFt(pjsonObj3.getDouble("fta"));
				p.setFtz(pjsonObj3.getDouble("ftm"));
				p.setFtp(pjsonObj3.getDouble("ftpct"));
				p.setTurnovers(pjsonObj3.getDouble("turnovers"));
				p.setSteals(pjsonObj3.getDouble("steals"));
			    p.setTime(pjsonObj3.getDouble("mins"));
			    p.setPoints(pjsonObj3.getDouble("points"));
			    players.add(p);
			
//				System.out.println(p.getAssists()+" "+p.getBlocks()+" "+p.getDefRebs()+" "+p.getName()
//						+" "+p.getPoints()+" "+p.getPlusminus()+" "+p.getPosition()+" "+p.getFgp()+" "
//						+p.getEnglishname());
			}			
//			System.out.println(players.size());
			awayTeam.setPlayers(players);
//			System.out.println(homeTeam.getPlayers().size());
			
			
			
			
			
			
			
			
			
			 
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		    return clicked;
		}
		
	
	
	public MatchLivedata getFirstmatchinfo() {
		return firstmatchinfo;
	}
	public void setFirstmatchinfo(MatchLivedata firstmatchinfo) {
		this.firstmatchinfo = firstmatchinfo;
	}
	public MatchLivedata getSecondmatchinfo() {
		return secondmatchinfo;
	}
	public void setSecondmatchinfo(MatchLivedata secondmatchinfo) {
		this.secondmatchinfo = secondmatchinfo;
	}
	public MatchLivedata getThirdmatchinfo() {
		return thirdmatchinfo;
	}
	public void setThirdmatchinfo(MatchLivedata thirdmatchinfo) {
		this.thirdmatchinfo = thirdmatchinfo;
	}
	public MatchLivedata getForthmatchinfo() {
		return forthmatchinfo;
	}
	public void setForthmatchinfo(MatchLivedata forthmatchinfo) {
		this.forthmatchinfo = forthmatchinfo;
	}
	public MatchLivedata getExtrama1tchinfo() {
		return extra1matchinfo;
	}
	public void setExtra1matchinfo(MatchLivedata extra1matchinfo) {
		this.extra1matchinfo = extra1matchinfo;
	}
	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	public int getSetnumber() {
		return setnumber;
	}

	public void setSetnumber(int setnumber) {
		yuju=new ArrayList<String>();
		this.setnumber = setnumber;
	}
	public static void main(String[] args){
//		/*
//		 * 要等到前面的节结束再去点下面的节,不然后面的json还没生成，会报错,回点前面的节是支持的,每次要新开线程
//		 * 现在线程的处理上还有待改进
//		 */
//		LiveCast l=new LiveCast();
//		try{
//			l.setClicked(true);
//			Thread t=new Thread(l);
//			t.start();
//			System.out.println("gg");
//			//l.setSetnumber(2);
//			//t.start();
//			//System.out.println(l.getSecondmatchinfo().getYuju());
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		//Thread t=new Thread(new LiveCast());
//		///t.start();
		liveThread p1=new liveThread("1");
		liveThread p2=new liveThread("2");
		liveThread p3=new liveThread("3");
		liveThread p4=new liveThread("4");
		Thread t1=new Thread(p1);
		Thread t2=new Thread(p2);
		Thread t3=new Thread(p3);
		Thread t4=new Thread(p4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	
}
