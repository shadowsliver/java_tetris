package domain.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.IController;

public class ResumeButtonListener implements ActionListener {
	private JButton buttonStart;
	private JButton buttonStop;
	private JButton buttonResume;
	private IController controller;
	
	public ResumeButtonListener(JButton buttonStart, JButton buttonStop, JButton buttonResume, IController controller){
		setButtonStart(buttonStart);
		setButtonResume(buttonResume);
		setButtonStop(buttonStop);
		setController(controller);
		
	}
	
	
	private void setButtonStart(JButton buttonStart) {
		this.buttonStart = buttonStart;
	}


	private void setButtonStop(JButton buttonStop) {
		this.buttonStop = buttonStop;
	}


	private void setButtonResume(JButton buttonResume) {
		this.buttonResume = buttonResume;
	}


	private void setController(IController controller) {
		this.controller = controller;
	}


	public void actionPerformed(ActionEvent arg0) {
		buttonStart.setEnabled(false);
		buttonStop.setEnabled(true);
		buttonResume.setEnabled(false);
		controller.resumeTime();
	}

}
