package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.*;

import controller.ControllerTetris;
import controller.IController;
import domain.model.Field;
import domain.model.GameTimer;
import domain.model.IObserver;
import domain.model.Player;
import domain.model.PlayingFieldCalculator;
import domain.model.TetrisKeyListener;

public class GameMainView extends JFrame implements IObserver{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3420850862298460174L;

	private GamePanel gp;
	private Container c;
	protected IController controller;
	protected TetrisKeyListener tkl;
	protected String playername;

	int i;
	int width;
	int height;
	
	public GameMainView(){
		PlayingFieldCalculator pfc = new PlayingFieldCalculator();
		askplayerName();
		setFocusable(true);
		controller = new ControllerTetris(new GameTimer(this), this, new Player(playername), pfc);
		c = getContentPane();
		gp = new GamePanel(controller, pfc);
		tkl = new TetrisKeyListener(controller);
		addKeyListener(tkl);
		c.add(gp);
		controller.setField(getField());

		setSize(new Dimension(800,800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void update() {		
		controller.setField(getField());
		requestFocus();
		gp.setTimer(controller);
		gp.giveFigures(controller.getFigures(), this.getContentPane().getSize());
		gp.update();
		validate();
		repaint();	
		
		if(controller.getGameOver()){
			JOptionPane.showMessageDialog(null, new JTextArea(controller.getTop10()));
		}
	}

	public Field getField(){
		return gp.getField();
	}

	private void askplayerName(){
		try {
			playername = JOptionPane.showInputDialog("Player name?");
			if(playername.equals("")){
				throw new ViewException("You need to enter a valid player name");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "You need to enter a valid player name");
			askplayerName();
		}
	}


}

