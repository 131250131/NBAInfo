package logic;

/*
 * 这个类主要是用来初始化，以及是用来初试化其他的子Controller，以及对所有的VO进行生成;
 * 这样ui层调用的时候就不会出现问题;
 * 构造阶段，测试单个功能时，先调用下MainController的getInstance;
 * 最终版本里，ui层只要调用一次就行;
 * */

public class MainController {
	private static MainController instance = null;
	
	private MainController(){
			this.init();
	}
	
	public MainController getInstance(){
		if(instance == null){
			instance = new MainController();
		}
		return instance;
	}
	
	private void init(){
		PlayerController playerController = PlayerController.getInstance();
		TeamController teamController = TeamController.getInstance();
		MatchController matchController = MatchController.getInstance();
	}
	
}
