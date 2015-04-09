package DataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import po.MatchPO;
public interface MatchDataService {
	public void readMatch();
	public ArrayList<MatchPO> getAllMatch();
	public boolean Matchupdate();
}
