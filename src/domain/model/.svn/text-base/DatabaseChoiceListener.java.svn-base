package domain.model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.IController;
import domain.db.DatabasePostgreSQL;
import domain.db.DatabaseTextFile;

public class DatabaseChoiceListener implements ItemListener {
	private JComboBox c;
	private IController cont;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseChoiceListener(JComboBox c, IController cont){
		this.c=c;
		this.cont = cont;
	}
	
		
	public void itemStateChanged(ItemEvent arg0) {
			String choice = String.valueOf(c.getSelectedItem());
			

			
			if(choice.equals("Database")){
				cont.setDatabase( new DatabasePostgreSQL());				
			}else{
				cont.setDatabase(new DatabaseTextFile());
			}
	}

}
