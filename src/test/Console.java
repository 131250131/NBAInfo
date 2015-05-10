package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

import logic.MainController;
import logicservice.mainControllerService;
import Utibility.FilePathSaver;

public class Console {
	 public void execute(PrintStream out, String[] args) {
		 if(args[0].equals("--datasource")){
	           FilePathSaver filepath= new FilePathSaver();
	           filepath.setMatchString(args[1]);
	        }
	        else if(args[0].equals("-player") || args[0].equals("-team")){
	            ParameterExplicate parameter = new ParameterExplicate(args);
	            mainControllerService mainController = new MainController();
	    		mainController.init();
	            ArrayList<Object> result = mainController.getResult(parameter);
	            for(Object token:result){
	                out.append(token.toString());
	            }
	        }
	        else{
	            System.out.println("error in Console.execute: can not parsing input parameters: " + args[0]);
	        }
	 }
	 public static void main(String[] args) {
		  System.out.println("use a space to split string,example: --datasource D:nba// ,notice that space in a path is not supported! enter your command:");
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String input = null;
	        try {
	                input = reader.readLine();
	                Console c = new Console();
	                c.execute(System.out, input.trim().split(" "));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	       // System.out.println("测试数据： " + TeamController.testValue);
	 }
}
