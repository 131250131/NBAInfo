package com.nba.initProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.nba.data.Player;
import com.nba.data.FilePathSaver;
import com.nba.registerList.RegisterList;

public class PlayerListBuilder {
	
	//生成文件路径保存器并获取球员文件夹路径
	FilePathSaver pathSaver = new FilePathSaver();
	private String filePath = pathSaver.getPlayerFilePath();
	
	
	//该方法将会读取球员信息文件夹中所有球员的信息
	public void readAll() throws Exception{
		File file = new File(filePath);                
		File[] playerFile = file.listFiles();  
		
		//获取球员个数
		int fileLength = playerFile.length;
		
		//对每一球员使用方法进行单独处理
		for(int i = 0; i < fileLength; i++)
			readOne(playerFile[i]);
		
		wirteToFile();
	}
	
	private String temp_playerName, temp_playerNumber, temp_playerPosition, temp_playerHeight, temp_playerWeight, 
	temp_playerBirth, temp_playerAge, temp_playerExp, temp_playerSchool;
	
	//该方法将会对每一球员信息进行读取工作
	private void readOne(File file) throws IOException, FileNotFoundException{
	
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            operatePlayerTxt(lineTxt, lineNumber++);
        }
        sentPlayerInfo(temp_playerName, temp_playerNumber, temp_playerPosition, temp_playerHeight, temp_playerWeight, 
        		temp_playerBirth, temp_playerAge, temp_playerExp, temp_playerSchool);
        read.close();
	}
	
	
	//该方法将从球员文件中搜索出有用信息
	private void operatePlayerTxt(String lineTxt, int lineNumber){
		
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
	
	private ArrayList<Player> playerListA = new ArrayList<Player>(); 
	private ArrayList<Player> playerListB = new ArrayList<Player>(); 
	private ArrayList<Player> playerListC = new ArrayList<Player>(); 
	private ArrayList<Player> playerListD = new ArrayList<Player>(); 
	private ArrayList<Player> playerListE = new ArrayList<Player>(); 
	private ArrayList<Player> playerListF = new ArrayList<Player>(); 
	private ArrayList<Player> playerListG = new ArrayList<Player>(); 
	private ArrayList<Player> playerListH = new ArrayList<Player>();
	private ArrayList<Player> playerListI = new ArrayList<Player>(); 
	private ArrayList<Player> playerListJ = new ArrayList<Player>(); 
	private ArrayList<Player> playerListK = new ArrayList<Player>(); 
	private ArrayList<Player> playerListL = new ArrayList<Player>(); 
	private ArrayList<Player> playerListM = new ArrayList<Player>(); 
	private ArrayList<Player> playerListN = new ArrayList<Player>(); 
	private ArrayList<Player> playerListO = new ArrayList<Player>(); 
	private ArrayList<Player> playerListP = new ArrayList<Player>(); 
	private ArrayList<Player> playerListQ = new ArrayList<Player>(); 
	private ArrayList<Player> playerListR = new ArrayList<Player>(); 
	private ArrayList<Player> playerListS = new ArrayList<Player>(); 
	private ArrayList<Player> playerListT = new ArrayList<Player>(); 
	private ArrayList<Player> playerListU = new ArrayList<Player>(); 
	private ArrayList<Player> playerListV = new ArrayList<Player>(); 
	private ArrayList<Player> playerListW = new ArrayList<Player>(); 
	private ArrayList<Player> playerListX = new ArrayList<Player>(); 
	private ArrayList<Player> playerListY = new ArrayList<Player>(); 
	private ArrayList<Player> playerListZ = new ArrayList<Player>();
	
	//该方法用于将找出的有用信息保存至球员的序列化中
	private void sentPlayerInfo(String playerName, String playerNumber,String playerPosition,
			String playerHeight, String playerWeight, String playerBirth, 
			String playerAge, String playerExp, String playerSchool) {
		
		Player player = new Player(playerName, playerNumber, playerPosition, playerHeight, playerWeight, 
				playerBirth, playerAge, playerExp, playerSchool);
		
		byte[] bytes = playerName.getBytes();
		
		switch(bytes[0]){
		case 65:
			playerListA.add(player);
			break;
		case 66:
			playerListB.add(player);
			break;
		case 67:
			playerListC.add(player);
			break;
		case 68:
			playerListD.add(player);
			break;
		case 69:
			playerListE.add(player);
			break;
		case 70:
			playerListF.add(player);
			break;
		case 71:
			playerListG.add(player);
			break;
		case 72:
			playerListH.add(player);
			break;
		case 73:
			playerListI.add(player);
			break;
		case 74:
			playerListJ.add(player);
			break;
		case 75:
			playerListK.add(player);
			break;
		case 76:
			playerListL.add(player);
			break;
		case 77:
			playerListM.add(player);
			break;
		case 78:
			playerListN.add(player);
			break;
		case 79:
			playerListO.add(player);
			break;
		case 80:
			playerListP.add(player);
			break;
		case 81:
			playerListQ.add(player);
			break;
		case 82:
			playerListR.add(player);
			break;
		case 83:
			playerListS.add(player);
			break;
		case 84:
			playerListT.add(player);
			break;
		case 85:
			playerListU.add(player);
			break;
		case 86:
			playerListV.add(player);
			break;
		case 87:
			playerListW.add(player);
			break;
		case 88:
			playerListX.add(player);
			break;
		case 89:
			playerListY.add(player);
			break;
		case 90:
			playerListZ.add(player);
			break;
		}
	}
	
	private void wirteToFile() {		
		RegisterList.saveList.add(playerListA);
		RegisterList.saveList.add(playerListB);
		RegisterList.saveList.add(playerListC);
		RegisterList.saveList.add(playerListD);
		RegisterList.saveList.add(playerListE);
		RegisterList.saveList.add(playerListF);
		RegisterList.saveList.add(playerListG);
		RegisterList.saveList.add(playerListH);
		RegisterList.saveList.add(playerListI);
		RegisterList.saveList.add(playerListJ);
		RegisterList.saveList.add(playerListK);
		RegisterList.saveList.add(playerListL);
		RegisterList.saveList.add(playerListM);
		RegisterList.saveList.add(playerListN);
		RegisterList.saveList.add(playerListO);
		RegisterList.saveList.add(playerListP);
		RegisterList.saveList.add(playerListQ);
		RegisterList.saveList.add(playerListR);
		RegisterList.saveList.add(playerListS);
		RegisterList.saveList.add(playerListT);
		RegisterList.saveList.add(playerListU);
		RegisterList.saveList.add(playerListV);
		RegisterList.saveList.add(playerListW);
		RegisterList.saveList.add(playerListX);
		RegisterList.saveList.add(playerListY);
		RegisterList.saveList.add(playerListZ);		
		}
}
