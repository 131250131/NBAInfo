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
	}
	public LiveCast getL() {
		return l;
	}
}
