package com.main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/*
 * 该类用于读取初始球员信息，并且用序列化进行球员数据保存。test
 */

public class PlayerFileBuilder {
	
	String playerName, playerNumber, playerPosition, playerHeight, playerWeight, 
		playerBirth, playerAge, playerExp, playerSchool;
	
	ArrayList<ArrayList<Player>> playerList = new ArrayList<ArrayList<Player>>();
	ArrayList<Player> playerListA = new ArrayList<Player>(); 
	ArrayList<Player> playerListB = new ArrayList<Player>(); 
	ArrayList<Player> playerListC = new ArrayList<Player>(); 
	ArrayList<Player> playerListD = new ArrayList<Player>(); 
	ArrayList<Player> playerListE = new ArrayList<Player>(); 
	ArrayList<Player> playerListF = new ArrayList<Player>(); 
	ArrayList<Player> playerListG = new ArrayList<Player>(); 
	ArrayList<Player> playerListH = new ArrayList<Player>();
	ArrayList<Player> playerListI = new ArrayList<Player>(); 
	ArrayList<Player> playerListJ = new ArrayList<Player>(); 
	ArrayList<Player> playerListK = new ArrayList<Player>(); 
	ArrayList<Player> playerListL = new ArrayList<Player>(); 
	ArrayList<Player> playerListM = new ArrayList<Player>(); 
	ArrayList<Player> playerListN = new ArrayList<Player>(); 
	ArrayList<Player> playerListO = new ArrayList<Player>(); 
	ArrayList<Player> playerListP = new ArrayList<Player>(); 
	ArrayList<Player> playerListQ = new ArrayList<Player>(); 
	ArrayList<Player> playerListR = new ArrayList<Player>(); 
	ArrayList<Player> playerListS = new ArrayList<Player>(); 
	ArrayList<Player> playerListT = new ArrayList<Player>(); 
	ArrayList<Player> playerListU = new ArrayList<Player>(); 
	ArrayList<Player> playerListV = new ArrayList<Player>(); 
	ArrayList<Player> playerListW = new ArrayList<Player>(); 
	ArrayList<Player> playerListX = new ArrayList<Player>(); 
	ArrayList<Player> playerListY = new ArrayList<Player>(); 
	ArrayList<Player> playerListZ = new ArrayList<Player>(); 
	
	int playerID = 1;
	
	//在此处设定文件夹路径
	String path = "data/data/players/info";
	
	public void ReadAll() throws Exception{
		
		//该方法将会读取球员信息文件夹中所有球员的信息
		File file = new File(path);                
		File[] playerFile = file.listFiles();       
		for(int i = 0; i < playerFile.length; i++)
			ReadOne(playerFile[i]);
		
		wirteToFile(playerList);
	}

	private void ReadOne(File file) throws IOException, FileNotFoundException{
		
		//该方法将会对每一球员信息进行读取工作
		
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(file),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int lineNumber = 0;
        while((lineTxt = bufferedReader.readLine()) != null){
            operatePlayerTxt(lineTxt, lineNumber++);
        }
        sentPlayerInfo(playerName, playerNumber, playerPosition, playerHeight, playerWeight, 
        		playerBirth, playerAge, playerExp, playerSchool);
        playerID++;
        read.close();
	}

	private void operatePlayerTxt(String lineTxt, int lineNumber){
		
		//该方法将从球员文件中搜索出有用信息
		switch(lineNumber){
		case 1:
			String[] splitNameStage1 = lineTxt.split("│");
			String[] splitNameStage2 = splitNameStage1[1].split("	");
			String[] splitNameStage3 = splitNameStage2[0].split("║");
			String[] splitNameStage4 = splitNameStage3[0].split("[.]");
			playerName = splitNameStage4[0];
			break;
		case 3:
			String[] splitNumberStage1 = lineTxt.split("│");
			String[] splitNumberStage2 = splitNumberStage1[1].split("	");
			playerNumber = splitNumberStage2[0];
			break;
		case 5:
			String[] splitPositionStage1 = lineTxt.split("│");
			String[] splitPositionStage2 = splitPositionStage1[1].split("	");
			playerPosition = splitPositionStage2[0];
			break;
		case 7:
			String[] splitHeightStage1 = lineTxt.split("│");
			String[] splitHeightStage2 = splitHeightStage1[1].split("	");
			playerHeight = splitHeightStage2[0];
			break;
		case 9:
			String[] splitWeightStage1 = lineTxt.split("│");
			String[] splitWeightStage2 = splitWeightStage1[1].split("	");
			playerWeight = splitWeightStage2[0];
			break;
		case 11:
			String[] splitBirthStage1 = lineTxt.split("│");
			String[] splitBirthStage2 = splitBirthStage1[1].split("	");
			playerBirth = splitBirthStage2[0];
			break;
		case 13:
			String[] splitAgeStage1 = lineTxt.split("│");
			String[] splitAgeStage2 = splitAgeStage1[1].split("	");
			playerAge = splitAgeStage2[0];
			break;
		case 15:
			String[] splitExpStage1 = lineTxt.split("│");
			String[] splitExpStage2 = splitExpStage1[1].split("	");
			playerExp = splitExpStage2[0];
			break;
		case 17:
			String[] splitSchoolStage1 = lineTxt.split("│");
			String[] splitSchoolStage2 = splitSchoolStage1[1].split("	");
			playerSchool = splitSchoolStage2[0];
			break;
			
		default:
			break;
		}
	}
	

	private void sentPlayerInfo(String playerName, String playerNumber,String playerPosition,
			String playerHeight, String playerWeight, String playerBirth, 
			String playerAge, String playerExp, String playerSchool) {
		
		//该方法用于将找出的有用信息保存至球员的序列化中
		
		Player player = new Player(playerName, playerNumber, playerPosition, playerHeight, playerWeight, 
				playerBirth, playerAge, playerExp, playerSchool, playerID);
		
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
	
	private void wirteToFile(ArrayList<ArrayList<Player>> playerList) {
		
		playerList.add(playerListA);
		playerList.add(playerListB);
		playerList.add(playerListC);
		playerList.add(playerListD);
		playerList.add(playerListE);
		playerList.add(playerListF);
		playerList.add(playerListG);
		playerList.add(playerListH);
		playerList.add(playerListI);
		playerList.add(playerListJ);
		playerList.add(playerListK);
		playerList.add(playerListL);
		playerList.add(playerListM);
		playerList.add(playerListN);
		playerList.add(playerListO);
		playerList.add(playerListP);
		playerList.add(playerListQ);
		playerList.add(playerListR);
		playerList.add(playerListS);
		playerList.add(playerListT);
		playerList.add(playerListU);
		playerList.add(playerListV);
		playerList.add(playerListW);
		playerList.add(playerListX);
		playerList.add(playerListY);
		playerList.add(playerListZ);
		
		String saveFile = "data/save/player.ser";
		try {  
	           ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(saveFile));  
	           os.writeObject(playerList);// 将List列表写进文件  
	           os.close();  
	       } catch (FileNotFoundException e) {  
	           e.printStackTrace();  
	       } catch (IOException e) {  
	           e.printStackTrace();  
	       }  	
	}
}
