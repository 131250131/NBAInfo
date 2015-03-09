package com.main;

public class Main {
	
	public static double T = 0;
	
	public static void main(String[] args) {
		
		//初始时间
		double t1 = System.currentTimeMillis();
		T = t1;
		
		//读取所有player文件 并且进行相应处理 （之后需要做一个判断 如果无需读取的情况下不需要进行此项操作）
		PlayerFileBuilder playerFileBuilder = new PlayerFileBuilder();
		try {
			playerFileBuilder.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		//读取所有team文件 并且进行相应处理 （之后需要做一个判断 如果无需读取的情况下不需要进行此项操作）
//		TeamFileBuilder teamFileBuilder = new TeamFileBuilder();
//		try {
//			teamFileBuilder.readFile();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//读取所有match文件 并且进行相应处理
		
		Searcher searcher = new Searcher();
		
		MatchFileReader matchFileReader = new MatchFileReader(searcher);
		try {
			matchFileReader.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		searcher.rewritePlayerFile();	
		
//		Searcher searcher = new Searcher();
//		System.out.println(searcher.playerSearcher("Al Horford").playerScores);
				
		//结束时间
		double t2 = System.currentTimeMillis();
		
		//计算用时
		double useTime = (t2 - t1) / 1000;
		System.out.println("Using " + useTime + "s");
		
		
// 读序列号的方法先丢到一边儿去		
//		 try {  
//	            ObjectInputStream is = new ObjectInputStream(new FileInputStream(  
//	                    "data/save/team.ser"));    
//	            ArrayList<Team> tempList = (ArrayList<Team>) is.readObject();// 从流中读取List的数据  
//	           System.out.println(tempList.get(0).gymName);
//	            is.close();  
//	        } catch (FileNotFoundException e) {  
//	            e.printStackTrace();  
//	        } catch (IOException e) {  
//	            e.printStackTrace();  
//	        } catch (ClassNotFoundException e) {  
//	            e.printStackTrace();  
//	        }  

	}

}
