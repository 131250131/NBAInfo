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
	MatchLivedata matchinfo=new MatchLivedata();
	int dnumber=0;
	ArrayList<String> descriptions=new ArrayList<String>();
	int number=1;
	public void run() {
		/*
		 *得到网页json内容 
		 */
		    try{
			String json=null;
			String n=String.valueOf(number);
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
			br.close();
			JSONObject  jsonObj  = JSONObject.fromObject(json);
			//System.out.println(jsonObj.get("payload"));
			JSONObject  jsonObj1  = JSONObject.fromObject(jsonObj.get("payload"));
			JSONObject  jsonObj2  = JSONObject.fromObject(jsonObj1.get("gameProfile"));
			JSONObject  jsonObj3  = JSONObject.fromObject(jsonObj1.get("boxscore"));
			//JSONObject  jsonObj4  = JSONObject.fromObject(jsonObj1.get("playByPlays"));
			matchinfo.setLocation(jsonObj2.getString("arenaName"));//比赛地点
			matchinfo.setAttendence(jsonObj3.getString("attendance"));
			matchinfo.setTAwayScore(jsonObj3.getString("awayScore"));
			matchinfo.setTHomeScore(jsonObj3.getString("homeScore"));
			JSONArray jary=jsonObj1.getJSONArray("playByPlays");
			JSONObject obj = jary.getJSONObject(0);
			JSONArray jary1=obj.getJSONArray("events");
			if(dnumber<jary1.size()){
			for (int i=0;i<jary1.size();i++) {
		         JSONObject obj1 = jary1.getJSONObject(i);
		         System.out.println(obj1);
		         descriptions.add(obj1.getString("description"));
		        }
			    matchinfo.setDescriptions(descriptions);
			    dnumber=jary1.size();
			}
			//array = object.getJSONArray("");
//			for (Object obj : array) {
//				JSONObject o = JSONObject.fromObject(obj);
//				System.out.println(o.get("context"));
//			}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
	}
	public static void main(String[] args){
		LiveCast l=new LiveCast();
		try{
			Thread t=new Thread(new LiveCast());
			t.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		//Thread t=new Thread(new LiveCast());
		///t.start();
	}
}
