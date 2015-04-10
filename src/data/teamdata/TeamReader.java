package data.teamdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import po.TeamPO;

public class TeamReader {
//球队的7个基本信息;
	public String temp_teamFullName;
	public String temp_teamShortName; 
	public String temp_teamLocation;
	public String temp_teamEastOrWest;
	public String temp_teamDivision;
	public String temp_teamGym;
	public String temp_teamBirth;
	
	protected String filePath = "data/data/teams/teams";
	
	//这个方法用来读取所有的球队的基本信息;
	public ArrayList<TeamPO> readTeamsBaiscInfo() throws IOException{
		ArrayList<TeamPO> allTeams = new ArrayList<TeamPO>(); 
		InputStreamReader fileReader = new InputStreamReader(new FileInputStream(filePath),"UTF-8");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lineTxt = null;
	    int lineNumber = 0;
	    
	    while((lineTxt = bufferedReader.readLine()) != null){
	    	if(lineNumber > 0 && lineNumber < 31){
				String[] splitStage1 = lineTxt.split("║");
				String[] splitStage2 = splitStage1[1].split("│");
				
				String[] splitStage2_1 = splitStage2[0].split("	");
				temp_teamFullName = splitStage2_1[0];
				
				temp_teamShortName = splitStage2[1];
				
				String[] splitStage2_3 = splitStage2[2].split("	");
				temp_teamLocation = splitStage2_3[0];
				
				temp_teamEastOrWest = splitStage2[3];
				
				String[] splitStage2_5 = splitStage2[4].split("	");
				temp_teamDivision = splitStage2_5[0];
				
				String[] splitStage2_6 = splitStage2[5].split("	");
				temp_teamGym = splitStage2_6[0];
				
				temp_teamBirth = splitStage2[6];
				
				TeamPO tempTeamPO = new TeamPO(temp_teamFullName, temp_teamShortName, temp_teamLocation,
						temp_teamEastOrWest, temp_teamDivision, temp_teamGym, temp_teamBirth);
				allTeams.add(tempTeamPO);
				
			}
	    	lineNumber++;
	    }
		return allTeams;
	}
	
}
