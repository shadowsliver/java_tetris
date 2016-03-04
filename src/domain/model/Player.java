package domain.model;

public class Player {
	private String name;
	private int score, time;
	
	public Player(String name){
		this.setName(name);
	}
	
	public Player(String name, int score){
		this.setName(name);
		this.setScore(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
	

}
