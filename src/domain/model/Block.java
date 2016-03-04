package domain.model;

import java.awt.Color;
import java.awt.Rectangle;

public class Block {
	
	private int size;
	private Punt pos;
	private String colorHex;
	private Field field;
	private PlayingFieldCalculator pfc;
	
	public Block(int size, Punt point, String colorHex, Field field, PlayingFieldCalculator pfc){
		this.pfc = pfc;
		setSize(size);
		setPos(point);
		setColorHex(colorHex);
		this.field = field;
	}
	
	public void adjustPos(int x, int y){
		this.pos.x = this.pos.x+x;
		this.pos.y = this.pos.y+y;
	}

	public int getSize() {
		return pfc.getHeightRow();
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Punt getPos() {
		return pos;
	}

	private void setPos(Punt pos) {
		this.pos = pos;
	}
	
	public boolean move(int distance){
		boolean test = false;
		if (pos.x + distance >= 0 && pos.x + distance <= 10){ 
			pos.setLocation(pos.x + distance, pos.y);
			test = true;
		}
		return test;
	}
	
	public Boolean drop(int distance){
		
		
		boolean test = false;
		if (pos.y + distance >= 0 && pos.y + distance <= 20){ 
			pos.setLocation(pos.x, pos.y + distance);
			test = true;
		}
		return test;
		
	}
	
	public Color getColor(){
		return Color.decode(getColorHex());
	}

	public void setColorHex(String colorHex) {
		this.colorHex = colorHex;
	}

	public String getColorHex() {
		return colorHex;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(pos.x, pos.y, size, size);
	}
	
	public Block getClone(){
		return new Block(getSize(), new Punt(pos.x, pos.y ), getColorHex(), field, pfc);
	}
	
	public boolean equals(Block b){
		if(b.pos.x == this.pos.x && this.pos.y == b.pos.y){
			return true;
		}
		return false;
	}

}
