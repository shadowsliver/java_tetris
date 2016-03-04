package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.IController;
import domain.model.AFigure;
import domain.model.Block;
import domain.model.Field;
import domain.model.PlayingFieldCalculator;

public class FieldPanel extends JPanel{

	private ArrayList<AFigure> f;
	private Field field;
	private IController controller;
	private PlayingFieldCalculator pfc;
	
	public FieldPanel(IController controller, PlayingFieldCalculator pfc){
		this.pfc = pfc;
		setBackground(Color.decode("#ffff00"));
		setBorder(BorderFactory.createLineBorder(Color.decode("#ff8800")));
		f = new ArrayList<>();
		field = new Field((FieldPanel.this.getSize().width-40)*2, FieldPanel.this.getSize().width-40, "#ffffff");
		this.controller = controller;
		pfc.setHeight(field.getHeight());
		pfc.setWidth(field.getWidth());
	}
	
	public void draw(ArrayList<AFigure> f, Dimension d){
		field = new Field(((FieldPanel.this.getSize().width-40)*2)+32, FieldPanel.this.getSize().width, "#ffffff");
		this.f = controller.getFigures();
		pfc.setHeight(field.getHeight());
		pfc.setWidth(FieldPanel.this.getSize().width-40);
	}

	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.decode(field.getColorHex()));
		g.fillRect(0, 0, field.getWidth(), field.getHeight());
		
		for (AFigure fig : f){
			for (Block b : fig.getBlocks()){
				g.setColor(b.getColor());
				g.fillRect(b.getPos().x*pfc.getHeightRow(), b.getPos().y*pfc.getHeightRow(), b.getSize(), b.getSize());
				g.setColor(Color.decode("#000000"));
				g.drawRect(b.getPos().x*pfc.getHeightRow(), b.getPos().y*pfc.getHeightRow(), b.getSize(), b.getSize());
			}
		}
		
		
	}

	public Field getField() {
		return field;
	}}

