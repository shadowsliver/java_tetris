package controller;

import java.util.ArrayList;

import domain.db.DatabasePostgreSQL;
import domain.db.IDatabase;
import domain.model.AFigure;
import domain.model.Field;
import domain.model.Player;
import domain.model.PlayingFieldCalculator;

public interface IController {
	
	public int getTime();
	public void startTime();
	public void stopTime();
	public void resumeTime();
	public ArrayList<AFigure> getFigures();
	public void moveLeft();
	public void moveRight();
	public void drop();
	public void setField(Field field); 
	public boolean getGameOver();
	public void rotate();
	public Player getPlayer();
	public AFigure nextFigure();
	public String getTop10();
	public void UploadSpeler();
	public int getScore();
	public void setDatabase(IDatabase db);

}
