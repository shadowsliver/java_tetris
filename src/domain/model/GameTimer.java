package domain.model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import view.GameMainView;

public class GameTimer implements IObservable {
	private Timer t;
	private int time;
	private ArrayList<IObserver> o;
	
	public GameTimer(GameMainView gameMainView){
		time = 0;
		o = new ArrayList<IObserver>();
		o.add(gameMainView);
	}
	
	public void startTimer(){
		time = 0;
		notifyObservers();
		resumeTimer();
	}
	
	public int getTime(){
		return this.calcTime();
	}
	
	public void stopTimer(){
		t.cancel();
	}
	
	public void resumeTimer(){
		t = new Timer();
		int delay = 50;
	    int period = 50;
	    t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				time += 50;
				notifyObservers();
				
			} }, delay, period);

	}
	
	

	public void addObserver(IObserver o) {
		this.o.add(o);
	}

	public void notifyObservers() {
		for(IObserver ob :o){
			ob.update();
		}	
	}

	public void removeObserver(IObserver sub) {
		this.o.remove(sub);
		
	}
	
	public int calcTime(){
		return time/1000;
	}

}
