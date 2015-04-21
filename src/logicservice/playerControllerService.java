package logicservice;

import java.util.ArrayList;

import vo.PlayerVO;

public interface playerControllerService {
	public ArrayList<PlayerVO> getAllPlayers();
	public PlayerVO find(String name);
}
