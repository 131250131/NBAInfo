package thirdVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LiveCast implements Runnable {
	MatchLivedata firstmatchinfo=new MatchLivedata();//第一节的直播信息
	MatchLivedata secondmatchinfo=new MatchLivedata();//第二节的直播信息
	MatchLivedata thirdmatchinfo=new MatchLivedata();//第三节的直播信息
	MatchLivedata forthmatchinfo=new MatchLivedata();//第四节的直播信息
	MatchLivedata extra1matchinfo=new MatchLivedata();//加时一的直播信息
	MatchLivedata extra2matchinfo=new MatchLivedata();//加时二的直播信息
	MatchLivedata extra3matchinfo=new MatchLivedata();//加时三的直播信息
	//感觉一般不会超过三个加时吧
	int dnumber=0;
	ArrayList<String> yuju=new ArrayList<String>();
	int setnumber=1;
	boolean clicked=true; 
	public void run() {
		/*
		 *得到网页json内容 
		 */
		while(clicked){
		    try{
			String json=null;
			String n=String.valueOf(setnumber);
			URL url = new URL("http://china.nba.com/wap/static/data/game/playbyplay_0041400401_"+n+".json");
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
			if(dnumber<jary1.size()){
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
			     dnumber=jary1.size();
			}
			//array = object.getJSONArray("");
//			for (Object obj : array) {
//				JSONObject o = JSONObject.fromObject(obj);
//				System.out.println(o.get("context"));
//			}
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
				if(dnumber<jary1.size()){
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
				    dnumber=jary1.size();
				}
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
				if(dnumber<jary1.size()){
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
				    dnumber=jary1.size();
				    
				}
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
				if(dnumber<jary1.size()){
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
				    dnumber=jary1.size();
				}
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
				if(dnumber<jary1.size()){
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
				    dnumber=jary1.size();
				}
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
				if(dnumber<jary1.size()){
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("加时二"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    extra2matchinfo.setYuju(yuju);
				 //   System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				    dnumber=jary1.size();
				}
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
				if(dnumber<jary1.size()){
				for (int i=0;i<jary1.size();i++) {
			         JSONObject obj1 = jary1.getJSONObject(i);
			         yuju.add("加时三"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			         if(obj1.getString("description").equals("本节比赛结束")){
			        	 clicked=false;
			         }
			         System.out.println("第"+n+"节"+"  "+obj1.getString("gameClock")+" "+obj1.getString("description")+" "+obj1.getString("awayScore")+"-"+obj1.getString("homeScore"));
			        }
//				System.out.println(jary1.size());
				    extra3matchinfo.setYuju(yuju);
//				    System.out.println(firstmatchinfo.getDescriptions().size()+" "+firstmatchinfo.getGameclocks().size()+" "+firstmatchinfo.getScores().size());
				    dnumber=jary1.size();
				}
				//array = object.getJSONArray("");
//				for (Object obj : array) {
//					JSONObject o = JSONObject.fromObject(obj);
//					System.out.println(o.get("context"));
//				}
				}
			 br.close();
			 Thread.sleep(5000);
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		}
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
		dnumber=0;
		this.setnumber = setnumber;
	}
	public static void main(String[] args){
		/*
		 * 要等到前面的节结束再去点下面的节,不然后面的json还没生成，会报错,回点前面的节是支持的,每次要新开线程
		 * 现在线程的处理上还有待改进
		 */
		LiveCast l=new LiveCast();
		try{
			l.setClicked(true);
			l.setSetnumber(2);
			Thread t=new Thread(l);
			t.start();
			l.setSetnumber(3);
			Thread t1=new Thread(l);
			t1.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		//Thread t=new Thread(new LiveCast());
		///t.start();
	}

	
}
