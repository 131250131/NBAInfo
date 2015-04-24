package DataService;

import java.io.IOException;
import java.util.ArrayList;

import po.TeamPO;

public interface TeamDataService {
	public ArrayList<TeamPO> readTeamsBaiscInfo() throws IOException;
}
