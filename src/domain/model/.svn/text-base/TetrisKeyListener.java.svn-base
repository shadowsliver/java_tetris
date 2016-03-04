package domain.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.IController;

public class TetrisKeyListener implements KeyListener {
	private IController c;
	boolean drop;
	
	private void setC(IController c) {
		this.c = c;
	}

	public TetrisKeyListener(IController c){
		setC(c);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_A){
			c.startTime();
		}
		if(key == KeyEvent.VK_B){
			c.stopTime();
		}
		if(key == KeyEvent.VK_LEFT)
		{
			c.moveLeft();
		}
		
		if(key == KeyEvent.VK_RIGHT)
		{
			c.moveRight();
		}
		
		if(key == KeyEvent.VK_DOWN)
		{
			c.drop();
		}
		
		if(key == KeyEvent.VK_UP)
		{
			c.rotate();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
