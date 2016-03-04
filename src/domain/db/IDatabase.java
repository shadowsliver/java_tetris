package domain.db;

import java.util.ArrayList;

import domain.model.Player;

public interface IDatabase {
	
	public void connect();
	public ArrayList<Player> read();
	public void insert(Player p);
	public String toString();
	

}
