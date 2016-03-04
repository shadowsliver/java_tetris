package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import controller.IController;
import domain.model.GameTimer;

public class GameControlPanel extends JPanel{
	
	private ChronometerPanel cp;
	private GameInfoPanel gip;
	
	public GameControlPanel(IController controller){
		cp = new ChronometerPanel(controller);
		gip = new GameInfoPanel(controller);
		add(gip);
		add(cp);
		setLayout(new GridLayout(2,1));
	}	
	
	public void setTimer(IController c){
		cp.setTimer(c);
	}

	public void setGameOver() {
		gip.setGameOver();
	}

}
