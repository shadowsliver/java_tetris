package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import domain.model.Player;
import domain.model.PropertiesReader;
import domain.model.PropertiesReaderLogin;

public class DatabasePostgreSQL implements IDatabase {
	private String url, user, password, sslfactory;
	private boolean ssl;
	private PropertiesReader p;
	private PropertiesReaderLogin p1;
	private Properties connectionParameters;
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	
	public DatabasePostgreSQL(){
		p = new PropertiesReader();
		p1 = new PropertiesReaderLogin();
		ssl = Boolean.getBoolean(p.getProperty("ssl"));
		url = p.getProperty("url");
		user= p1.getProperty("user");
		password= p1.getProperty("password");
		sslfactory= p.getProperty("sslfactory");
		result = null;
		connect();
	}

	@Override
	public void connect() {
		connectionParameters = new Properties();
		connectionParameters.setProperty("user", user);
		connectionParameters.setProperty("password", password);
		connectionParameters.setProperty("ssl", "true");
		connectionParameters.setProperty("sslfactory", sslfactory);
		
		try {
			connection = DriverManager.getConnection(url, connectionParameters);
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Player> read() {
		try {
			result = statement.executeQuery("SELECT * FROM playerresults");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Player> players = new ArrayList<Player>(); 
		
		try {
			while(result.next()){
				Player p = new Player(result.getString("playername"));
				p.setScore(result.getInt("score"));
				p.setTime(result.getInt("time"));
				players.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}

	@Override
	public void insert(Player p) {
		try {
			
			result = statement.executeQuery("INSERT INTO playerresults (playername, score, time) VALUES ('" + p.getName() + "', " + p.getScore() + ", " + p.getTime() + ");");

		} catch (SQLException e) {
		}
	}

	@Override
	public String toString(){
		
		try {
			result = statement.executeQuery("SELECT playername, score, time FROM playerresults ORDER BY score DESC LIMIT 10");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String output = "---TOP 10 Spelers--- \n Name\t-\tScore\t-\tTime\n";
		
		try {
			while(result.next()){
				
				String name = result.getString("playername"); 
				
				if(name.length() > 9){
					name = name.substring(0, 8);
				}
				
				
				output += name + "\t-\t" + result.getInt("score") + "\t-\t" + result.getInt("time") + "\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
}
