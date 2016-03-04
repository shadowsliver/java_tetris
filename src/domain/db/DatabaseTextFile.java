package domain.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import domain.model.Player;

public class DatabaseTextFile implements IDatabase {
	private File file;

	public DatabaseTextFile() {
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Player> read() {
		File file = new File("/playerList.txt");
		ArrayList<Player> list = new ArrayList<Player>();
		Scanner sc = new Scanner(getClass().getResourceAsStream("/playerList.txt"));

		while (sc.hasNext()) {
			String line = sc.next();
			String[] splittedLine = line.split(",");
			Player p = new Player(splittedLine[0]);
			p.setScore(Integer.parseInt(splittedLine[1]));
			p.setTime(Integer.parseInt(splittedLine[2]));
			list.add(p);
		}
		sc.close();
		return list;
	}

	@Override
	public void insert(Player p) {
		ArrayList<Player> players = read();
		players.add(p);

		try {
			PrintWriter writer = new PrintWriter("/playerList.txt", "UTF-8");

			for (Player pl : players) {
				writer.println(pl.getName() + "," + pl.getScore() + ","
						+ pl.getTime());
			}

			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString(){
		ArrayList<Player> players = read();
		int max = 0;
		if(players.size() < 10){
			max = players.size()-1;
		}else{
			max = 9;
		}
		
		sortScores(players);
		
		String output = "---TOP 10 Spelers--- \n Name\t-\tScore\t-\tTime\n";
		
		for (int i=0; i<= max; i++){
					String name = players.get(i).getName();
					int time = players.get(i).getTime();
					int score = players.get(i).getScore();
					
					if(name.length() > 9){
						name = name.substring(0, 8);
					}
										
					output += name + "\t-\t" + score + "\t-\t" + time + "\n";
		}
		
	
		return output;
		
	}
	
	public void sortScores(ArrayList<Player> players){
		int n = players.size();

		for(int i=0;i<n;i++){
			for(int j=1; j < (n-i); j++){
				if(players.get(j-1).getScore() < players.get(j).getScore()){
					Player temp = new Player(players.get(j-1).getName(),players.get(j-1).getScore());
					players.get(j-1).setName(players.get(j).getName());
					players.get(j-1).setScore(players.get(j).getScore());
					players.get(j).setName(temp.getName());
					players.get(j).setScore(temp.getScore());
				}
			}
		}
	}
	

}
