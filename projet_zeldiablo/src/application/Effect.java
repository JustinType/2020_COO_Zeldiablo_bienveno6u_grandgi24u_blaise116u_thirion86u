package application;

public class Effect{
	private int TIMER;
	private int vitesse;
	private int COUNTER;
	
	public Effect(int TIMER,int vitesse) {
		this.vitesse = vitesse;
		this.TIMER = TIMER;
	}

	public boolean increseTime() {
		COUNTER++;
		return (COUNTER != TIMER);
	}
	
	public int getVitesse() {
		return this.vitesse;
	}
	
}
