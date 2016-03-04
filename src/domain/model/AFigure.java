package domain.model;

import java.awt.Color;
import java.util.ArrayList;

public abstract class AFigure implements IObservable {

	private String colorHex;
	protected ArrayList<Block> blocks;
	private ArrayList<IObserver> o;
	protected Field field;
	protected int rotateState;
	protected PlayingFieldCalculator pfc;

	public AFigure(String colorHex, IObserver o, Field field, PlayingFieldCalculator pfc) {
		this.pfc = pfc;
		this.o = new ArrayList<IObserver>();
		blocks = new ArrayList<Block>();
		setColorHex(colorHex);
		this.field = field;
		generateBlocks();
		rotateState = 1;
	}

	public String getColorHex() {
		return colorHex;
	}

	public Color getColor() {
		return Color.decode(getColorHex());
	}

	private void setColorHex(String colorHex) {
		this.colorHex = colorHex;
	}

	public ArrayList<Block> getBlocks(){
		return this.blocks;
	}

	public void addObserver(IObserver o) {
		this.o.add(o);
	}

	public void notifyObservers() {
		for (IObserver ob : o) {
			o.notify();
		}
	}

	public void removeObserver(IObserver sub) {
		o.remove(sub);
	}

	public abstract void changePos();

	public void moveLeft(int distance){
		Block t0;
		Block t1;
		Block t2;
		Block t3;
		
		t0 = getBlocks().get(0).getClone();
		t1 = getBlocks().get(1).getClone();
		t2 = getBlocks().get(2).getClone();
		t3 = getBlocks().get(3).getClone();
		
		Boolean test0= t0.move(distance);
		Boolean test1= t1.move(distance);
		Boolean test2= t2.move(distance);
		Boolean test3= t3.move(distance);
		boolean test = false;
		
		if(test0 == true && test1 == true && test2 == true && test3 == true){
			test = true;
		}
		
		if (test){
			for(Block b : getBlocks()){
				b.move(distance);
			}
		}
	}

	public void moveRight(int distance){
		Block t0;
		Block t1;
		Block t2;
		Block t3;
		
		t0 = getBlocks().get(0).getClone();
		t1 = getBlocks().get(1).getClone();
		t2 = getBlocks().get(2).getClone();
		t3 = getBlocks().get(3).getClone();
		
		Boolean test0= t0.move(distance);
		Boolean test1= t1.move(distance);
		Boolean test2= t2.move(distance);
		Boolean test3= t3.move(distance);
		boolean test = false;
		
		if(test0 == true && test1 == true && test2 == true && test3 == true){
			test = true;
		}
		
		if (test){
			for(Block b : getBlocks()){
				b.move(distance);
			}
		}
	}

	public boolean drop(int distance){
		Block t0;
		Block t1;
		Block t2;
		Block t3;
		
		t0 = getBlocks().get(0).getClone();
		t1 = getBlocks().get(1).getClone();
		t2 = getBlocks().get(2).getClone();
		t3 = getBlocks().get(3).getClone();
		
		Boolean test0= t0.drop(distance);
		Boolean test1= t1.drop(distance);
		Boolean test2= t2.drop(distance);
		Boolean test3= t3.drop(distance);
		boolean test = false;
		
		if(test0 == true && test1 == true && test2 == true && test3 == true){
			test = true;
		}
		
		if (test){
			for (Block b : blocks){
				b.drop(distance);
			}
		}
		return test;
	}

	public void generateBlocks() {
		// TODO Auto-generated method stub
		
	}
	
	public void dropBlock(boolean b1, boolean b2, boolean b3, boolean b4){
		int offset = 0;
		if(b1){
			blocks.remove(0);
			offset++;
		}
		if(b2){
			blocks.remove(1 - offset);
			offset++;
		}
		if(b3){
			blocks.remove(2 - offset);
			offset++;
		}
		if(b4){
			blocks.remove(3 - offset);
			offset++;
		}
	}
	
	public abstract void rotate();
	
	
}