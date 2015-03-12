package com.nba.initProcess;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.main.Team;
import com.nba.data.FilePathSaver;
import com.nba.registerList.RegisterList;

public class TeamListBuilder {
	
	private String teamFullName, teamShortName, teamLocation, teamEastOrWest, teamDivision, teamGym, teamBirth;
	
	//初始化文件路径保存器并获取球队文件保存位置
	FilePathSaver filePathSaver = new FilePathSaver();
	private String filePath = filePathSaver.getTeamFilePath();
	private ArrayList<Team> teamList = new ArrayList<Team>();
	
	public void readFile()  throws IOException, FileNotFoundException{
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(filePath),"UTF-8");
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
		RegisterList.saveList.add(teamList);
	}
}
