package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.IController;
import domain.*;
import domain.model.DatabaseChoiceListener;
import domain.model.ResumeButtonListener;
import domain.model.StartButtonListener;
import domain.model.StopButtonListener;

public class ChronometerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2042091237056818864L;
	private JButton buttonStart, buttonStop, buttonResume;
	private JLabel lblTime, lblTimer, lblScoreText, lblScore;
	//private JTextField txtTimer;
	private JPanel time, score;
    private JComboBox saveOption;
	
	public ChronometerPanel(final IController controller) 
	{
		buttonStart = new JButton("Start");
		buttonStop = new JButton("Stop");
		buttonResume = new JButton("Resume");
		String[] options = {"Database","Text File"};
		saveOption = new JComboBox(options);
		saveOption.addItemListener(new DatabaseChoiceListener(saveOption, controller));
		buttonStart.addActionListener(new StartButtonListener(buttonStart, buttonStop, buttonResume, controller));
		buttonStop.addActionListener(new StopButtonListener(buttonStart, buttonStop, buttonResume, controller));
		buttonResume.addActionListener(new ResumeButtonListener(buttonStart, buttonStop, buttonResume, controller));
		lblTime = new JLabel("Time");
		lblTimer = new JLabel("0", JLabel.CENTER);
		lblTimer.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
		lblTimer.setBackground(Color.decode("#ffff00"));
		lblTimer.setOpaque(true);
		lblScoreText = new JLabel("Score");
		lblScore = new JLabel("0", JLabel.CENTER);
		lblScore.setBorder(BorderFactory.createLineBorder(Color.decode("#000000")));
		lblScore.setBackground(Color.decode("#ffff00"));
		lblScore.setOpaque(true);
		buttonStart.setEnabled(true);
		buttonStop.setEnabled(false);
		buttonResume.setEnabled(false);
		
		
		Dimension d = lblTimer.getPreferredSize();
		//lblTimer.setPreferredSize(new Dimension(lblTimer.getPreferredSize().width*25,lblTimer.getPreferredSize().height));
		lblTimer.setPreferredSize(new Dimension(ChronometerPanel.this.getPreferredSize().width*25,lblTimer.getPreferredSize().height));
		lblScore.setPreferredSize(new Dimension(ChronometerPanel.this.getPreferredSize().width*25,lblScore.getPreferredSize().height));
		
		time = new JPanel();
		time.setLayout(new FlowLayout());
		
		score = new JPanel();
		score.setLayout(new FlowLayout());
		
		setLayout(new GridLayout(6,1));
		
		
		time.add(lblTime);
		time.add(lblTimer);
		score.add(lblScoreText);
		score.add(lblScore);
		add(time);
		add(score);

		add(saveOption);
		add(buttonStart);
		add(buttonResume);
		add(buttonStop);
	}
	
	
	public void setTimer(IController c){
		this.lblTimer.setText(String.valueOf(c.getTime()));
		this.lblScore.setText(String.valueOf(c.getScore()));
	}
}
