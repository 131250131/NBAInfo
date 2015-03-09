package com.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/*
 * 该类用于读取初始球队信息，并且用序列化进行球队数据保存。
 */

public class TeamFileBuilder {
	
	String teamFullName, teamShortName, teamLocation, teamEastOrWest, teamDivision, teamGym, teamBirth;
	
	//定义文件位置
	String file = "data/data/teams/teams";
	
	ArrayList<Team> teamList = new ArrayList<Team>(); 
	
	public void readFile()  throws IOException, FileNotFoundException{
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            operateTeamTxt(lineTxt, lineNumber++);
        }
        read.close();
        writeToFile(teamList);
	}

	private void operateTeamTxt(String lineTxt, int lineNumber){
		//teamFullName, teamShortName, teamLocation, teamEastOrWest, teamDivision, teamGym, teamBirth
		if(lineNumber > 0 && lineNumber < 31){
			String[] splitStage1 = lineTxt.split("║");
			String[] splitStage2 = splitStage1[1].split("│");
			
			String[] splitStage2_1 = splitStage2[0].split("	");
			teamFullName = splitStage2_1[0];
			
			teamShortName = splitStage2[1];
			
			String[] splitStage2_3 = splitStage2[2].split("	");
			teamLocation = splitStage2_3[0];
			
			teamEastOrWest = splitStage2[3];
			
			String[] splitStage2_5 = splitStage2[4].split("	");
			teamDivision = splitStage2_5[0];
			
			String[] splitStage2_6 = splitStage2[5].split("	");
			teamGym = splitStage2_6[0];
			
			teamBirth = splitStage2[6];
			
			Team team = new Team(teamFullName, teamShortName, teamLocation, teamEastOrWest, teamDivision, teamGym, teamBirth);
			teamList.add(team);
		}
	}
	
	
	private void writeToFile(ArrayList<Team> teamList) {
		
		String saveFile = "data/save/team.ser";
		try {  
	           ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(saveFile));  
	           os.writeObject(teamList);// 将List列表写进文件  
	           os.close();  
	       } catch (FileNotFoundException e) {  
	           e.printStackTrace();  
	       } catch (IOException e) {  
	           e.printStackTrace();  
	       } 
	}

}
