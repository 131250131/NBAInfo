package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchFileReader {
	
	//在此处设定文件夹路径
	String path = "data/data/matches";
	
	public void readAll() throws Exception{
		
		//该方法将会读取比赛信息文件夹中所有球员的信息
		File file = new File(path);                
		File[] matchFile = file.listFiles();       
		//for(int i = 0; i < matchFile.length; i++)
//			readOne(matchFile[i]);
		
		readOne(matchFile[0]);
		
	}
	
	private void readOne(File file) throws IOException, FileNotFoundException{

		//该方法将会对每一当场比赛信息进行读取工作
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            operateMatchTxt(lineTxt, lineNumber++);
        }
        
        read.close();
	}
	
	String leftTeamName, rightTeamName;
	int leftTeamScore, rightTeamScore;
	boolean isLeft = true;
	
	private void operateMatchTxt(String lineTxt, int lineNumber){
		if(lineNumber == 1){
			String[] teamInfoStage1 = lineTxt.split(";");
			
			String[] teamInfoStage2 = teamInfoStage1[1].split("-");
			leftTeamName = teamInfoStage2[0];
			rightTeamName = teamInfoStage2[1];
			
			String[] teamInfoStage3 = teamInfoStage1[2].split("-");			
			leftTeamScore = Integer.parseInt(teamInfoStage3[0]);
			rightTeamScore = Integer.parseInt(teamInfoStage3[1]);
		}
		
		if(lineNumber > 3 && lineTxt.length() == 3){
			isLeft = false;
		}
		
		if(lineNumber > 3 && lineTxt.length() != 3){
			String[] playerInfo = lineTxt.split(";");
			
		}
	}
	
}
