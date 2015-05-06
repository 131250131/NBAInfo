package logicservice;

import logic.MatchController;
import logic.PlayerController;
import logic.TeamController;

public interface mainControllerService {
		public void init();
		public PlayerController getPlayerController();
		public TeamController getTeamController();	
		public MatchController getMatchController();
		public boolean hasUpdate();
		public void updateAllInfo();
}
