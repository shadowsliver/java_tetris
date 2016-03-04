package domain.model;

import java.util.ArrayList;

import domain.db.DatabasePostgreSQL;
import domain.db.IDatabase;

public class TetrisFacade implements IFacade {
	private boolean checkedOnce;
	private GameTimer t;
	private ArrayList<AFigure> figures;
	private PieceFactory pf;
	private IObserver ob;
	private Field field;
	private int time;
	private boolean gameOver;
	private Player player;
	private AFigure nextFigure;
	private IDatabase db;
	private PlayingFieldCalculator pfc;

	public TetrisFacade(GameTimer t, IObserver o, Player player, PlayingFieldCalculator pfc) {
		checkedOnce= false;
		time = 0;
		this.t = t;
		this.ob = o;
		figures = new ArrayList<>();
		this.player = player;
		db = new DatabasePostgreSQL();
		this.pfc = pfc;
	}

	public void checkDrop() {
		int timeTest = t.getTime();

		if (colisionDetectionDrop()) {
			if (timeTest > time) {
				time = timeTest;
				boolean test = figures.get(figures.size() - 1).drop(1);
				if (!test) {
					this.figures.add(nextFigure);
					nextFigure = pf.GeneratePiece();
				}
			}
		}else{
			figures.add(nextFigure);
			nextFigure = pf.GeneratePiece();
		}	
	}

	public void tienOpEenRij(){
		ArrayList<Block> blocks = new ArrayList<>();

		for(int rij=0;rij<=20;rij++){
			ArrayList<Block> deleteBlocks = new ArrayList<Block>();
			int count = 0;
			for(int fig =0;fig < figures.size()-1;fig++){	
				//for(AFigure f : figures){
				for(Block b : figures.get(fig).getBlocks()){
					if(b.getPos().y == rij){
						count++;
						deleteBlocks.add(b);
					}
				}
			}
			if(count == 11){
				removeRow(deleteBlocks);
				player.setScore(player.getScore()+10);
				adjustRowAfterRemoval(rij);
			}
		}
	}

	private void adjustRowAfterRemoval(int rij) {	
		for(int drop = rij-1; drop >= 0;drop--){
			for(AFigure a : figures){
				for(Block b : a.getBlocks()){
					if(b.getPos().y == drop){
						b.drop(1);
					}
				}
			}
		}
	}

	private void removeRow(ArrayList<Block> deleteBlocks){
		for(Block b : deleteBlocks){
			for(int fig =0;fig < figures.size()-1;fig++){
				figures.get(fig).getBlocks().remove(b);
			}
		}
	}

	public void setField(Field f) {
		field = f;
	}


	@Override
	public int getTime() {
		checkDrop();
		tienOpEenRij();
		return t.getTime();
	}

	@Override
	public void startTime() {
		pf = new PieceFactory(ob, field, pfc);
		gameOver = false;
		time = 0;
		figures.clear();
		nextFigure = pf.GeneratePiece();
		figures.add(pf.GeneratePiece());
		t.startTimer();

	}

	@Override
	public void stopTime() {
		t.stopTimer();

	}

	@Override
	public void resumeTime() {
		t.resumeTimer();

	}

	@Override
	public ArrayList<AFigure> getFigures() {
		return figures;

	}

	public boolean getGameOver(){
		return gameOver;
	}

	public void moveLeft() {
		if(colisionDetectionLeftRight("left") )
			figures.get(figures.size() - 1).moveLeft(-1);
	}

	public void moveRight() {
		if(colisionDetectionLeftRight("right"))
			figures.get(figures.size() - 1).moveRight(1);
	}

	public Field getField(int height, int width, String colorHex) {
		return field;
	}

	@Override
	public void drop() {
		boolean test = figures.get(figures.size() - 1).drop(1);

		if (!test || !colisionDetectionDrop()) {
			
			this.figures.add(nextFigure);
			nextFigure = pf.GeneratePiece();
		}
	}

	public boolean colisionDetectionDrop() {
		boolean output = true;
		boolean onder = true;

		ArrayList<Block> blocks = new ArrayList<>();

		// getAllBlocks
		for (AFigure fig : figures) {
			for (Block b : fig.getBlocks()) {
				blocks.add(b);
			}
		}

		for (int teller = 0; teller <= 3; teller++) {
			blocks.remove(blocks.size() - 1);
		}

		ArrayList<Block> blocks2 = figures.get(figures.size() - 1).getBlocks();
		for (Block b : blocks2) {
			Block b2 = b.getClone();
			b2.drop(1);

			for (Block bl : blocks) { // BL
				if (bl.getPos().x == b2.getPos().x && bl.getPos().y == b2.getPos().y) {
					output = false;
					if(b.getPos().y == 0){
						gameOver = true;
						if(gameOver && !checkedOnce){
							checkedOnce = true;
							player.setTime(this.t.getTime());
							uploadPlayer();
						}
						
					}
				}

			}
		}

		return output;
	}

	public boolean colisionDetectionLeftRight(String left_or_right) {
		boolean output = true;

		ArrayList<Block> blocks = new ArrayList<>();

		// getAllBlocks
		for (AFigure fig : figures) {
			for (Block b : fig.getBlocks()) {
				blocks.add(b);
			}
		}

		for (int teller = 0; teller <= 3; teller++) {
			blocks.remove(blocks.size() - 1);
		}

		ArrayList<Block> blocks2 = figures.get(figures.size() - 1).getBlocks();
		for (Block b : blocks2) {
			Block b2 = b.getClone();

			if(left_or_right.equals("right")){
				b2.move(1);
				for (Block bl : blocks) { // BL
					if (bl.getPos().x == b2.getPos().x && bl.getPos().y == b2.getPos().y) {
						output = false;
					}
				}
			}else if(left_or_right.equals("left")){
				b2.move(-1);
				for (Block bl : blocks) { // BL
					if (bl.getPos().x == b2.getPos().x && bl.getPos().y == b2.getPos().y) {
						output = false;
					}
				}
			}		
		}
		return output;
	}

	@Override
	public void rotate() {
		figures.get(figures.size()-1).rotate();
	}

	@Override
	public Player getPlayer() {
		return this.player;
		
	}

	@Override
	public AFigure nextFigure() {
		return nextFigure;
	}

	@Override
	public String getTop10() {
		return db.toString();
	}

	@Override
	public void uploadPlayer() {
		db.insert(player);		
	}

	@Override
	public void setDatabase(IDatabase db) {
		this.db = db;
	}

	@Override
	public void setPlayingFieldCalculator() {
		for(int i = 0; i <= figures.size()-2;i++){
			for(Block b : figures.get(i).getBlocks()){
				b.setSize(pfc.getWidthColum());
			}
		}
	}

}
