package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controller.*;
import domain.model.AFigure;
import domain.model.Field;
import domain.model.PlayingFieldCalculator;

public class GamePanel  extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4255087909165306023L;
	private FieldPanel fp;
	private GameControlPanel gcp;
	
	public GamePanel(IController controller, PlayingFieldCalculator pfc){
		fp = new FieldPanel(controller, pfc);
		gcp = new GameControlPanel(controller);
		setLayout(new GridLayout(1, 2));
		add(fp);
		add(gcp);
	}
	
	public void giveFigures(ArrayList<AFigure> f, Dimension d){
		fp.draw(f,d);
	}
	
	
	public void setTimer(IController c){
		gcp.setTimer(c);
	}

	public Field getField() {
		return fp.getField();
		
	}
	
	public void update(){
		
	}
	
	public void setGameOver(){
		gcp.setGameOver();
	}
}
