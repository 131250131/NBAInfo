package thirdVersion;

public class liveThread implements Runnable{
	String n="";
	private LiveCast l=LiveCast.getInstance();
	boolean flag=true;
    public liveThread(String number){
    	n=number;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
		flag=l.setlivedata(n);
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public LiveCast getL() {
		return l;
	}
}
