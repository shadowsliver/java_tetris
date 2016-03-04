package domain.model;

import java.util.ArrayList;

import domain.db.IDatabase;

public interface IFacade {
	
	public int getTime();
	public void startTime();
	public void stopTime();
	public void resumeTime();
	public ArrayList<AFigure> getFigures();
	public void moveLeft();
	public void moveRight();
	public void drop();
	public void setField(Field f);
	public Field getField(int height, int width, String colorHex);
	public boolean colisionDetectionDrop();
	public boolean getGameOver();
	public void rotate();
	public Player getPlayer();
	public AFigure nextFigure();
	public String getTop10();
	public void uploadPlayer();
	public void setDatabase(IDatabase db);
	void setPlayingFieldCalculator();
}
