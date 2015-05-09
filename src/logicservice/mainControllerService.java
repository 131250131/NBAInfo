package logicservice;

import java.util.ArrayList;

import test.ParameterExplicate;
import logic.MatchController;
import logic.PlayerController;
import logic.TeamController;

public interface mainControllerService {
		public void init();
		public PlayerController getPlayerController();
		public TeamController getTeamController();	
		public MatchController getMatchController();
		
		public void updateAllInfo();
		public ArrayList<Object> getResult(ParameterExplicate parameter);
}
