package controller;

import java.util.ArrayList;

import domain.db.DatabasePostgreSQL;
import domain.db.IDatabase;
import domain.model.AFigure;
import domain.model.Field;
import domain.model.GameTimer;
import domain.model.IFacade;
import domain.model.IObserver;
import domain.model.Player;
import domain.model.PlayingFieldCalculator;
import domain.model.TetrisFacade;

public class ControllerTetris implements IController {
	private IFacade f;
	
	public ControllerTetris(GameTimer t, IObserver o, Player player, PlayingFieldCalculator pfc){
		f = new TetrisFacade(t, o, player, pfc);
	}

	@Override
	public int getTime() {
		return f.getTime();
	}

	@Override
	public void startTime() {
		f.startTime();
	}

	@Override
	public void stopTime() {
		f.stopTime();		
	}

	@Override
	public void resumeTime() {
		f.resumeTime();
	}

	public ArrayList<AFigure> getFigures(){
		return f.getFigures();
	}

	@Override
	public void moveLeft() {
		f.moveLeft();
	}

	@Override
	public void moveRight() {
		f.moveRight();		
	}

	@Override
	public void drop() {
		f.drop();
		
	}

	@Override
	public void setField(Field field) {
		f.setField(field);		
	}

	@Override
	public boolean getGameOver() {
		return f.getGameOver();
	}

	@Override
	public void rotate() {
		f.rotate();
	}

	@Override
	public Player getPlayer() {
		return f.getPlayer();
		
	}

	@Override
	public AFigure nextFigure() {
		return f.nextFigure();
	}

	@Override
	public String getTop10() {
		
		return f.getTop10();		
	}

	@Override
	public void UploadSpeler() {
		f.uploadPlayer();
	}

	@Override
	public int getScore() {
		return f.getPlayer().getScore();
	}

	@Override
	public void setDatabase(IDatabase db) {
		f.setDatabase(db);
	}
}
