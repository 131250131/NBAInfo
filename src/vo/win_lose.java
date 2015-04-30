package vo;

import java.io.Serializable;

public class win_lose implements Serializable{
		private int win=0;
		private int lose=0;
		public int getWin() {
			return win;
		}
		public void addWin() {
			win++;
		}
		public int getLose() {
			return lose;
		}
		public void addLose() {
			lose++;
		}

}
