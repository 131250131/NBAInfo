package test;

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
		 
	 }
}
