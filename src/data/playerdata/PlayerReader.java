package data.playerdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import DataService.PlayerDataService;
import po.PlayerPO;

public class PlayerReader implements PlayerDataService {
//这些用用来暂存球员的基本信息的;
	public String temp_playerName, 
	temp_playerNumber, 
	temp_playerPosition, 
	temp_playerHeight, 
	temp_playerWeight, 
	temp_playerBirth, 
	temp_playerAge, 
	temp_playerExp, 
	temp_playerSchool;
	
//保存球员信息tx的文件夹名;
	protected String filePath = "data/data/players/info";
	protected File file = new File(filePath);                
	protected File[] playerFile = file.listFiles(); 
	protected int fileLength = playerFile.length;
	
	public ArrayList<PlayerPO> readPlayersBaiscInfo() throws FileNotFoundException, IOException{
		ArrayList<PlayerPO> allPlayers = new ArrayList<PlayerPO>();
 
		for(int i = 0; i < fileLength; i++){
			allPlayers.add(this.readOne(playerFile[i]));
		}
		
		return allPlayers;
	}
	
	//该方法将会对每一球员信息进行读取工作，返回一个PlayerPO;
	public PlayerPO readOne(File file) throws IOException, FileNotFoundException{

		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            this.operatePlayerTxt(lineTxt, lineNumber++);
        }
        PlayerPO tempPlayerPO = new PlayerPO(temp_playerName, temp_playerNumber, temp_playerPosition, temp_playerHeight, temp_playerWeight, 
        		temp_playerBirth, temp_playerAge, temp_playerExp, temp_playerSchool);
        read.close();
        return tempPlayerPO;
	}
	
	//该方法将从球员文件中搜索出有用信息，读出一行;
	public void operatePlayerTxt(String lineTxt, int lineNumber){
		
		switch(lineNumber){
		case 1:
			String[] splitNameStage1 = lineTxt.split("│");
			String[] splitNameStage2 = splitNameStage1[1].split("	");
			String[] splitNameStage3 = splitNameStage2[0].split("║");
		
			String[] splitNameStage4 = splitNameStage3[0].split("[.]");
			if(splitNameStage4[0].length() < 2){
				temp_playerName = splitNameStage3[0];
			}else{
				temp_playerName = splitNameStage4[0];
			}
			break;
		case 3:
			String[] splitNumberStage1 = lineTxt.split("│");
			String[] splitNumberStage2 = splitNumberStage1[1].split("	");
			temp_playerNumber = splitNumberStage2[0];
			break;
		case 5:
			String[] splitPositionStage1 = lineTxt.split("│");
			String[] splitPositionStage2 = splitPositionStage1[1].split("	");
			temp_playerPosition = splitPositionStage2[0];
			break;
		case 7:
			String[] splitHeightStage1 = lineTxt.split("│");
			String[] splitHeightStage2 = splitHeightStage1[1].split("	");
			temp_playerHeight = splitHeightStage2[0];
			break;
		case 9:
			String[] splitWeightStage1 = lineTxt.split("│");
			String[] splitWeightStage2 = splitWeightStage1[1].split("	");
			temp_playerWeight = splitWeightStage2[0];
			break;
		case 11:
			String[] splitBirthStage1 = lineTxt.split("│");
			String[] splitBirthStage2 = splitBirthStage1[1].split("	");
			temp_playerBirth = splitBirthStage2[0];
			break;
		case 13:
			String[] splitAgeStage1 = lineTxt.split("│");
			String[] splitAgeStage2 = splitAgeStage1[1].split("	");
			temp_playerAge = splitAgeStage2[0];
			break;
		case 15:
			String[] splitExpStage1 = lineTxt.split("│");
			String[] splitExpStage2 = splitExpStage1[1].split("	");
			temp_playerExp = splitExpStage2[0];
			break;
		case 17:
			String[] splitSchoolStage1 = lineTxt.split("│");
			String[] splitSchoolStage2 = splitSchoolStage1[1].split("	");
			temp_playerSchool = splitSchoolStage2[0];
			break;		
		default:
			break;
		}
		
	}

	@Override
	public PlayerPO find(String name) {
		// TODO Auto-generated method stub
		try{
		FileInputStream fis = new FileInputStream("data/save/player.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<PlayerPO> temp=new ArrayList<PlayerPO>();
        temp = (ArrayList<PlayerPO>)ois.readObject();
        for(PlayerPO p:temp){
        	if(p.getPlayerName().equals(name)){
        		return p;
        	}
        }
        return null;
		}catch(Exception e){
			return null;
		}
	
	}

	@Override
	public ArrayList<PlayerPO> getallplayers() {
		// TODO Auto-generated method stub
		 ArrayList<PlayerPO> temp=new ArrayList<PlayerPO>();
		try{
		
		FileInputStream fis = new FileInputStream("data/save/player.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        temp = (ArrayList<PlayerPO>)ois.readObject();
		}catch(Exception e){
			System.out.println(e);
		}
	     return temp;
	}
	
}