package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.IController;
import domain.model.AFigure;
import domain.model.Block;

public class GameInfoPanel extends JPanel{

	private JLabel gameover;
	private IController controller;
	private AFigure f;
	private Boolean gameoverbool;

	public GameInfoPanel(IController controller) {
		setLayout(new BorderLayout());
		gameover = new JLabel("Game Over");
		gameover.setVisible(false);
		gameover.setFont(new Font("Verdana", Font.BOLD, 50));
		add(gameover, BorderLayout.CENTER);
		this.controller = controller;

	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		f = controller.nextFigure();

		if(f != null){			
			if(controller.getGameOver()){
				setGameOver();
			}else{				
				gameover.setVisible(false);
				for(Block b : f.getBlocks()){
					g.setColor(b.getColor());
					g.fillRect((b.getPos().x)*40, (b.getPos().y+2)*40, 40, 40);
					g.setColor(Color.decode("#000000"));
					g.drawRect(b.getPos().x*40, (b.getPos().y+2)*40, 40, 40);		
				}
			}
		}



	}

	public void setGameOver(){
		controller.stopTime();
		gameover.setVisible(true);
		validate();
		repaint();
		
	}

}
