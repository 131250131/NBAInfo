package com.main;

public class Main {

	public static void main(String[] args) {
		
		//初始时间
		double t1 = System.currentTimeMillis();
		
		//读取所有player文件 并且进行相应处理 （之后需要做一个判断 如果无需读取的情况下不需要进行此项操作）
		PlayerFileBuilder b = new PlayerFileBuilder();
		try {
			b.ReadAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//结束时间
		double t2 = System.currentTimeMillis();
		
		//计算用时
		double useTime = (t2 - t1) / 1000;
		System.out.println("Using " + useTime + "s");
		
		
// 读序列号的方法先丢到一边儿去		
//		 try {  
//	            ObjectInputStream is = new ObjectInputStream(new FileInputStream(  
//	                    "bin/save/player.ser"));    
//	            ArrayList<ArrayList<Player>> tempList = (ArrayList<ArrayList<Player>>) is.readObject();// 从流中读取List的数据  
//	           System.out.println(tempList.get(0).get(5).playerName);
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
