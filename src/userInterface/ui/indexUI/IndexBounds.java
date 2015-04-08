package userInterface.ui.indexUI;

//用于保存各个重要组建位置
public class IndexBounds {
	
	//indexButton的bounds
	public static int indexButtonFirstX = 65 + 20;
	public static int indexButtonY = 50;
	public static int indexButtonSizeX = 170;
	public static int indexButtonSizeY = 30;
	
	//TodayMatchButton的bounds
	public static int TodayMatchButtonX = indexButtonFirstX;
	public static int TodayMatchButtonUpY = indexButtonY + indexButtonSizeY + 20;	
	public static int TodayMatchButtonSizeX = (int) (1.5 * indexButtonSizeX + 10);
	public static int TodayMatchButtonSizeY = 15 ;
	
	
	//TodayMatchScrollPane的bounds
	public static int todayMatchSPX = indexButtonFirstX;
	public static int todayMatchSPY = TodayMatchButtonUpY + TodayMatchButtonSizeY;
	public static int TodayMatchLabelSizeY = 100;//TodayMatchLabel的bounds
	public static int todayMatchSPSizeX = TodayMatchButtonSizeX;
	public static int todayMatchSPSizeY = TodayMatchLabelSizeY * 5 ;
	public static int TodayMatchLabelSizeX = todayMatchSPSizeX;
	
	//TodayMatchButton的bounds
	public static int TodayMatchButtonDownY = TodayMatchButtonUpY + todayMatchSPSizeY + TodayMatchButtonSizeY;
	
	//TodayPlayerPanel的bounds
	public static int todayPlayerX = todayMatchSPX + todayMatchSPSizeX + 30;
	public static int todayPlayerY = TodayMatchButtonUpY;
	public static int todayPlayerSizeX = indexButtonFirstX + indexButtonSizeX * 6 - todayPlayerX; 
	public static int todayPlayerSizeY = 380;
	
	//AllTimePlayer的bounds
	public static int allTimePlayerX = todayPlayerX;
	public static int allTimePlayerY = todayPlayerY + todayPlayerSizeY + 20;
	public static int allTimePlayerSizeX = 350; 
	public static int allTimePlayerSizeY = 280;
	
	//KeyGame的bounds
	public static int keyGameX = todayPlayerX + allTimePlayerSizeX + 20;
	public static int keyGameY = todayPlayerY + todayPlayerSizeY + 20;
	public static int keyGameSizeX = 350; 
	public static int keyGameSizeY = 280;
	
	//adv1的bounds
	public static int advX = TodayMatchButtonX - 17;
	public static int advY = keyGameY + keyGameSizeY + 30;
	public static int advSizeX = 1050; 
	public static int advSizeY = 25;
	
}
