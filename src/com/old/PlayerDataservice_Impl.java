package com.old;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class PlayerDataservice_Impl implements PlayerDataService {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(ArrayList<Player> player,String level) {
		// TODO Auto-generated method stub
		try {
            ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("source/player"+level+".txt",false));                        
            os.writeObject(player);
            os.close();                       
    } catch (Exception ex) { ex.printStackTrace();}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Player> get(String level) {
		// TODO Auto-generated method stub
		try {
            FileInputStream fis = new FileInputStream("source/player"+level+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Player> players = (ArrayList<Player>) ois.readObject();
            ois.close();
            return players;
    }catch (Exception ex) {
            return null;
    }	}

}
