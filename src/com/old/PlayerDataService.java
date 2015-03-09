package com.old;


import java.util.ArrayList;

public interface PlayerDataService {
     public void update();
     public void add(ArrayList<Player> player,String level);
     public void delete();
     public ArrayList<Player> get(String level);
}
